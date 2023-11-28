import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.core.Core;

public class CameraFrame extends JFrame {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    private VideoCapture capture;
    private CameraPanel cameraPanel;

    public CameraFrame() {
        super("Camera Frame");
        capture = new VideoCapture(0); // 0 表示默认摄像头
        cameraPanel = new CameraPanel();
        Thread cameraThread = new Thread(new CameraProcessor());
        cameraThread.start();

        JButton captureButton = new JButton("Capture");
        captureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveImage();
            }
        });

        this.setLayout(new BorderLayout());
        this.add(cameraPanel, BorderLayout.CENTER);
        this.add(captureButton, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(640, 480);
        this.setVisible(true);
    }

    private void saveImage() {
        Mat frame = new Mat();
        if (capture.read(frame)) {
            try {
                BufferedImage image = matToBufferedImage(frame);
                File outputfile = new File("capturedImage.jpg");
                ImageIO.write(image, "jpg", outputfile);
                System.out.println("Image saved");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private BufferedImage matToBufferedImage(Mat frame) {
        // 方法内容需要根据实际情况编写，用于将Mat对象转换为BufferedImage对象
        // 这通常需要使用OpenCV的Imgcodecs类
    }

    private class CameraPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            BufferedImage image = grabFrame();
            if (image != null) {
                g.drawImage(image, 0, 0, this);
            }
        }

        private BufferedImage grabFrame() {
            Mat frame = new Mat();
            if (capture.read(frame)) {
                return matToBufferedImage(frame);
            }
            return null;
        }
    }

    private class CameraProcessor implements Runnable {
        @Override
        public void run() {
            while (true) {
                cameraPanel.repaint();
            }
        }
    }

    public static void main(String[] args) {
        new CameraFrame();
    }
}
