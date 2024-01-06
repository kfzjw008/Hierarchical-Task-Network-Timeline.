package study2.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketUtil {

    private String host;
    private int port;

    public SocketUtil(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void sendString(String message) throws IOException {
        try (Socket socket = new Socket(host, port);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            writer.write(message);
            writer.flush();
        }
    }

    public String receiveString() throws IOException {
        try (Socket socket = new Socket(host, port);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        }
    }
}
/***使用此工具类发送和接收数据时，您需要创建一个实例，并提供正确的服务器主机地址和端口号。然后，您可以调用sendString来发送数据，以及receiveString来接收数据。
 * SocketUtil socketUtil = new SocketUtil("127.0.0.1", 12345);
socketUtil.sendString("Hello, server!");
String response = socketUtil.receiveString();
System.out.println("Received from server: " + response);

 * 
 * /
 */