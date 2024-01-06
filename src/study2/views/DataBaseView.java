package study2.views;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.sql.SQLException;

import study2.utils.SqliteUtil;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.TabFolder;

public class DataBaseView extends ViewPart {
    public DataBaseView() {
    }

    @Override
    public void createPartControl(Composite parent) {
		SqliteUtil sqlite = new SqliteUtil();
        TableViewer tv = new TableViewer(parent, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);

        // 第二步：通过表格内含的Table对象设置布局方式
        Table table = tv.getTable();
        table.setHeaderVisible(true); // 显示表头
        table.setLinesVisible(true); // 显示表格线
        TableLayout layout = new TableLayout(); // 专用于表格的布局
        table.setLayout(layout);

        // 第三步：用TableColumn类创建表格列
		String sql  = "SELECT * FROM testTable;";
		Map map1;
		  List Newlists =new ArrayList();
		List<Map<String, Object>> mapsList;
        try {
			map1=sqlite.select("database1", sql, null).get(1);
			System.out.println(map1);//{aa=2, bb=ggg}
			mapsList=sqlite.select("database1", sql, null);
			 for (Object key : map1.keySet()) {
		            System.out.println(key);
		            layout.addColumnData(new ColumnWeightData(13));// ID列宽13像素
		            new TableColumn(table, SWT.NONE).setText((String) key);
		        }
			 Iterator<Map<String, Object>> iterator = mapsList.iterator();
			 while (iterator.hasNext()) {
				  List Newlist =new ArrayList();
				 Map< String, Object> map=iterator.next();
				 for (Object key : map.keySet()) {
			            
			            Object value = map.get(key);
			            Newlist.add(value);
			            System.out.println(value);
			        }
				 
				 Newlists.add(Newlist);
			 }
			 
			 
			 
			 
			 
			

        
        
        
        
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       

        // 第四步：设置内容器和标签器
        tv.setContentProvider(new TableViewerContentProvider());
        tv.setLabelProvider(new TableViewerLabelProvider());
tv.setInput(Newlists);
        // 第五步：用TableViewer的setInput方法将数据输入到表格
        
       // List transmission = new ArrayList();  
  
        
//        Object data = PeopleFactory.getPeoples();

        
    }

    @Override
    public void setFocus() {
        // TODO Auto-generated method stub
        
    }

}
