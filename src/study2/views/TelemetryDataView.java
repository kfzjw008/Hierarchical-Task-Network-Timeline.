package study2.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.SWT;
import study2.utils.CsvReaderUtil;

import java.io.IOException;
import java.util.List;

public class TelemetryDataView extends ViewPart {
    private Table table;

    public TelemetryDataView() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void createPartControl(Composite parent) {
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
            List<String[]> csvData = CsvReaderUtil.readCsv("config/tmcsv.csv");
            int count = 1; // Start numbering from 1
            for (String[] row : csvData) {
                TableItem item = new TableItem(table, SWT.NONE);
                item.setText(new String[] { String.valueOf(count++), row[0], "", "" }); // Add numbering and first column data
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

    @Override
    public void setFocus() {
        // TODO Auto-generated method stub
    }
}
