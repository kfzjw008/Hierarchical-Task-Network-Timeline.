package study2.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.SWT;
import study2.utils.CsvReaderUtil;
import study2.utils.HexToTimeConverter;
import study2.utils.PreferenceConstants;
import study2.utils.VariableUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TelemetryDataView extends ViewPart {
    private Table table;
    private List<TableItem> tableItems;  // 用于存储表格行的列表
    List<String[]> csvData = null;
    public TelemetryDataView() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void createPartControl(Composite parent) {
    	  // 初始化 tableItems
        tableItems = new ArrayList<>();
    	  new Thread(new Runnable() {
              @Override
              public void run() {
                  listenForData();
              }
          }).start();
        table = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        // Add a "编号" column at the beginning
        TableColumn columnNumber = new TableColumn(table, SWT.NONE);
        columnNumber.setText("编号");
        columnNumber.setWidth(50); // Set width to 50 or as per your requirement

        // Add other titles
        String[] titles = { "名称", "原始数据", "解析数据" };
        for (String title : titles) {
            TableColumn column = new TableColumn(table, SWT.NONE);
            column.setText(title);
            if ("名称".equals(title)) {
                column.setWidth(200); // Increase the width of the "名称" column
            } else {
                column.setWidth(100); // Default width for other columns
            }
        }

        // Read data from the CSV file and fill the table
        try {
        	 csvData = CsvReaderUtil.readCsv("config/tmcsv.csv");
            int count = 0; // Start numbering from 1
            TableItem itemtItem = new TableItem(table, SWT.NONE);
            tableItems.add( itemtItem);
            String partOfHex = VariableUtil.hexOutputs.substring(0, 8); // 注意：索引从0开始
            String partOfHexnew= HexToTimeConverter.convertHexToEST(partOfHex);
            itemtItem.setText(new String[] { String.valueOf(count++), "当前时间", partOfHex, partOfHexnew });
           int now;
            
            for (String[] row : csvData) {
            	TableItem item = new TableItem(table, SWT.NONE);
            	
              // String p2=VariableUtil.hexOutputs.substring(Integer.parseInt(row[1])+8, Integer.parseInt(row[2])+Integer.parseInt(row[1])+8);
              // String p3=String.valueOf(HexToTimeConverter.hexToDecimal(p2));
                item.setText(new String[] { String.valueOf(count++), row[0],"","" }); // Add numbering and first column data
                tableItems.add(item);
                // Assume rawData and parsedData are obtained here
                // item.setText(2, rawData);
                // item.setText(3, parsedData);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }

        // Pack the columns only after filling the data
        for (TableColumn col : table.getColumns()) {
            col.pack();
        }
    }
    private void listenForData() {
        try (ServerSocket serverSocket = new ServerSocket(Integer.parseInt(PreferenceConstants.P_PORT))) {
            while (!Thread.currentThread().isInterrupted()) {
                Socket socket = serverSocket.accept(); // 从服务器接收一个连接
                final Socket finalSocket = socket; // 创建一个最终变量引用socket
                // 在UI线程中更新表格
                Display.getDefault().asyncExec(new Runnable() {
                    @Override
                    public void run() {
                        updateTableWithReceivedData(finalSocket);
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace(); // 处理异常
        }
    }


    private void updateTableWithReceivedData(Socket socket) {
        if (socket == null || socket.isClosed()) {
            System.out.println("Socket is null or already closed.");
            return;
        }
        try {
            InputStream input = socket.getInputStream();
            // 创建一个足够大的缓冲区来存储接收到的数据
            byte[] buffer = new byte[1024];
            int bytesRead;
            // 循环读取数据，直到没有更多数据
            while ((bytesRead = input.read(buffer)) != -1) {
                // 将接收到的二进制数据转换为十六进制字符串
            	setHexOutputs(bytesToHex(buffer, bytesRead));
               
                System.out.println("Received data: " + VariableUtil.hexOutputs);
                
            }
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
            // 处理异常
        } finally {
            try {
                socket.close(); // 关闭套接字
            } catch (IOException e) {
                System.out.println("Error closing socket: " + e.getMessage());
            }
        }
    }
    public void setHexOutputs(String newHexOutputs) {
        VariableUtil.hexOutputs = newHexOutputs;
        System.out.println("Received Hex Data: " + VariableUtil.hexOutputs);

        Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
            	 TableItem itemt = tableItems.get(0);
            	
            	 String p22 = VariableUtil.hexOutputs.substring(0, 8);
                 String p33 = String.valueOf(HexToTimeConverter.convertHexToEST(p22));
                 itemt.setText(2, p22);
                 itemt.setText(3, p33);
                for (int i = 0; i < tableItems.size()-1; i++) {
                    TableItem item = tableItems.get(i+1);
                    String[] row = csvData.get(i);

                    try {
                        String p2 = VariableUtil.hexOutputs.substring(Integer.parseInt(row[1]) + 8, Integer.parseInt(row[1]) + Integer.parseInt(row[2]) + 8);
                        String p3 = String.valueOf(HexToTimeConverter.hexToDecimal(p2));
                        item.setText(new String[] { String.valueOf(i + 1), row[0], p2, p3 });

                      //  System.out.println("Updated Row " + (i + 1) + " with " + p2 + ", " + p3);
                    } catch (Exception e) {
                       // System.err.println("Error updating row " + (i + 1) + ": " + e.getMessage());
                    }
                }
            }
        });
    }

    
    public static String bytesToHex(byte[] bytes, int length) {
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            String hex = Integer.toHexString(0xff & bytes[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }






    
    
    @Override
    public void setFocus() {
        // TODO Auto-generated method stub
    }
}
