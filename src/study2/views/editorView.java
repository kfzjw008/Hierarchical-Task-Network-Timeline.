package study2.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import swing2swt.layout.BoxLayout;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.alibaba.fastjson2.JSON;

import study2.Plugin.PluginManager;
import study2.utils.VariableUtil;

public class editorView extends ViewPart {
	private Text text;
	private Text text_1;
	public Map<String, Object> mapTypes;
	public String aString;

	public editorView() {
		// TODO Auto-generated constructor stub
	}

	public void createview(Composite parent, Map<String, Object> map) {
		String titleString = (String) (((Map<String, Object>) map.get("information"))).get("title");
		String descriptionString = (String) (((Map<String, Object>) map.get("information"))).get("description");
		System.out.println(titleString);

		parent.setLayout(new GridLayout(4, false));
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);

		Label lblTestlabelfsdfsd_1 = new Label(parent, SWT.NONE);
		lblTestlabelfsdfsd_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblTestlabelfsdfsd_1.setText(titleString);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);

		Label lblTestlabelfsdfsd = new Label(parent, SWT.NONE);
		GridData gd_lblTestlabelfsdfsd = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_lblTestlabelfsdfsd.widthHint = 130;
		lblTestlabelfsdfsd.setLayoutData(gd_lblTestlabelfsdfsd);
		lblTestlabelfsdfsd.setText(descriptionString);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);

//	Map allcontent = (Map<String, Object>) map.get("allcontent");
		List<Object> list = (List<Object>) map.get("allcontent");
		int k = 0;
		ArrayList<String> kArrayList = new ArrayList<>();
		for (Object i : list) {
			Map jsonMap = new HashMap<String, Object>();
			jsonMap = (Map) i;
			jsonMap.get("pagename");
//		System.out.println(jsonMap.get("pagename"));
			// Assert.isNotNull(jsonMap.get("pagename"));
			System.out.println(jsonMap.get("pagename"));
			System.out.println(jsonMap.get("description"));
			List<Object> list2 = (List<Object>) jsonMap.get("pagecontent");
			for (Object i2 : list2) {

				Map jsonMap2 = new HashMap<String, Object>();
				jsonMap = (Map) i2;
				jsonMap.get("name");
				System.out.println(jsonMap.get("name"));

				Label lblTestlabel = new Label(parent, SWT.NONE);
				lblTestlabel.setText((String) jsonMap.get("label"));

				text = new Text(parent, SWT.BORDER);
				text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
				new Label(parent, SWT.NONE);
				text.setData("ViewValues", k);
				kArrayList.add("");
				FocusListener focusListener = new FocusListener() {
					public void focusGained(FocusEvent e) {
						// kArrayList
						Text t = (Text) e.widget;
						int kk = (int) t.getData("ViewValues");
						kArrayList.set(kk, t.getText());

					}

					public void focusLost(FocusEvent e) {
						// TODO Auto-generated method stub
						Text t = (Text) e.widget;
						int kk = (int) t.getData("ViewValues");
						kArrayList.set(kk, t.getText());
						System.out.println(kArrayList);
					}
				};

				text.addFocusListener(focusListener);

				k++;
			}

		}
		// String descriptionString=(String) ( ((Map<String, Object>)
		// map.get("information"))).get("description");

		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);

		Button btnNewButton = new Button(parent, SWT.NONE);
		GridData gd_btnNewButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton.widthHint = 61;
		btnNewButton.setLayoutData(gd_btnNewButton);
		btnNewButton.setText("Submit");

		btnNewButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				// kArrayList
				PluginManager manager = new PluginManager();
				File directory = new File("");
				System.out.println(directory.getAbsolutePath());
				VariableUtil.CurrentPuluinPath = directory.getAbsolutePath() +"/Plugin/"+ VariableUtil.CurrentPuluinName;// 修改当前路径，可以读取新路径
				manager.loadPlugin(VariableUtil.CurrentPuluinName.split("\\.")[0]);
				manager.service(VariableUtil.CurrentPuluinName.split("\\.")[0], kArrayList);
			}
		});

		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		// TODO Auto-generated method stub

	}

	@Override
	public void createPartControl(Composite parent) {

		aString = VariableUtil.jsonstring;
		VariableUtil.b.setString(aString);
		Map mapTypess = JSON.parseObject(aString);
		System.out.println("这个是用JSON类的parseObject来解析JSON字符串!!!");
		if (mapTypess != null) {
			for (Object obj : mapTypess.keySet()) {
				System.out.println("key为：" + obj + "值为：" + mapTypess.get(obj));
			}
			mapTypes = mapTypess;
			VariableUtil.Map = mapTypes;
			createview(parent, VariableUtil.Map);
		}

		VariableUtil.b.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent e) {
				aString = VariableUtil.jsonstring;
				Map mapTypess = JSON.parseObject(aString);
				System.out.println("这个是用JSON类的parseObject来解析JSON字符串!!!");
				for (Object obj : mapTypess.keySet()) {
					System.out.println("key为：" + obj + "值为：" + mapTypess.get(obj));
				}
				mapTypes = mapTypess;

				VariableUtil.Map = mapTypes;
				resetview(parent);
			}
		});

	}

	public void resetview(Composite parent) {
		Control[] con = parent.getChildren();
		for (Control c : con) {
			c.dispose();
		}

		// 填充新内容
		// ******************
		Map<String, Object> map = VariableUtil.Map;// VariableUtil.Map;
		createview(parent, map);
		// 执行刷新操作
		parent.requestLayout();

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
