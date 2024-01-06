package study2;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.StatusLineContributionItem;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.actions.OpenInNewWindowAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import study2.actions.DeleteAction;
import study2.actions.OpenAction;
import study2.actions.OpenPAction;
import study2.actions.PrefenceAction2;
import study2.actions.PreferenceAction;
import study2.actions.SampleAction;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

/**
 * An action bar advisor is responsible for creating, adding, and disposing of
 * the actions added to a workbench window. Each window will be populated with
 * new actions.
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	// Actions - important to allocate these only in makeActions, and then use
	// them
	// in the fill methods. This ensures that the actions aren't recreated
	// when fillActionBars is called with FILL_PROXY.	
	private IWorkbenchAction iExitAction;
	private IWorkbenchAction iAboutAction;
	private IWorkbenchAction iNewWindowAction;
	private IWorkbenchAction iSaveAction;
	private SampleAction new1;
	private Action preferenceAction;
	private DeleteAction deleteAction;
	private IWorkbenchAction saveProjectAction;// 保存工程文件
	private IWorkbenchAction saveAllAction;// 保存全部
	private IWorkbenchAction exitAction;
	private IWorkbenchAction aboutAction;
	private Action  testAction3;
	private IWorkbenchAction preferenceAction1;
	private Action openAction;
	private Action openPAction;
	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}
	
	protected void makeActions(IWorkbenchWindow window) {
		preferenceAction1 = ActionFactory.PREFERENCES.create(window);
		register(preferenceAction1);
		exitAction = ActionFactory.QUIT.create(window);
		register(exitAction);
		aboutAction = ActionFactory.ABOUT.create(window);
		register(aboutAction);
		saveProjectAction = ActionFactory.SAVE.create(window);
		saveAllAction = ActionFactory.SAVE_ALL.create(window);
		this.getActionBarConfigurer().registerGlobalAction(saveProjectAction); // ctrl+s，保存工程文件。
		this.getActionBarConfigurer().registerGlobalAction(saveAllAction);// 激活快捷键，ctrl+shift+s,全部保存。

		iExitAction = ActionFactory.QUIT.create(window);
		register(iExitAction);
		iSaveAction = ActionFactory.SAVE.create(window);
		register(iSaveAction);
		
		testAction3=new SampleAction();
    	register(testAction3);
		
		iAboutAction = ActionFactory.ABOUT.create(window);
		register(iAboutAction);
		iNewWindowAction = ActionFactory.OPEN_NEW_WINDOW.create(window);
		register(iNewWindowAction);
		
		preferenceAction=new PrefenceAction2();
		preferenceAction.setText("设置");
		register(preferenceAction);
		
		deleteAction=new DeleteAction();
		deleteAction.setText("删除");
		
		register(deleteAction);
		
		new1=new SampleAction();
		new1.setText("TEST");
		register(new1);
		openAction = new OpenAction(window);
		register(openAction);
		openPAction = new OpenPAction(window);
	
		openPAction.setText("添加插件…");	register(openPAction);
		}
	public void fillTrayItem(MenuManager trayMenu) {
		trayMenu.add(new1);
		trayMenu.add(exitAction);
		}
	protected void fillMenuBar(IMenuManager menuBar) {
		MenuManager fileMenu = new MenuManager("&文件",IWorkbenchActionConstants.M_FILE);
		MenuManager helpMenu = new MenuManager("&帮助",IWorkbenchActionConstants.M_HELP);
		MenuManager help2Menu = new MenuManager("&关于",IWorkbenchActionConstants.M_HELP);
		MenuManager cjMenu = new MenuManager("&插件");
		MenuManager xjMenu = new MenuManager("&新建");
		MenuManager sTMenu = new MenuManager("&视图",IWorkbenchActionConstants.M_VIEW);
		MenuManager bjMenu = new MenuManager("&编辑",IWorkbenchActionConstants.M_EDIT);
		MenuManager dataMenu = new MenuManager("&数据",IWorkbenchActionConstants.MB_ADDITIONS);
		menuBar.add(fileMenu);
		menuBar.add(bjMenu);
		menuBar.add(cjMenu);
		menuBar.add(dataMenu);
		menuBar.add(sTMenu);
		menuBar.add(helpMenu);
		menuBar.add(help2Menu);
		// File Menu
		xjMenu.add(openAction);
		fileMenu.add(xjMenu);
		fileMenu.add(openAction);
		fileMenu.add(iSaveAction);
		fileMenu.add(new Separator());
		fileMenu.add(preferenceAction);
		fileMenu.add(preferenceAction1);
		//fileMenu.add(testAction3);
		
		fileMenu.add(new Separator());
		fileMenu.add(iExitAction);
		
		cjMenu.add(new1);
		cjMenu.add(openPAction);
		
		
		
		
		
		// Help Menu
		help2Menu.add(iAboutAction);
		
		bjMenu.add(new1);
		bjMenu.add(new Separator());
		bjMenu.add(deleteAction);
		cjMenu.add(new1);
		sTMenu.add(new1);
		helpMenu.add(new1);
		}
	
	@Override
	protected void fillCoolBar(ICoolBarManager coolBar) {
		// This will add a new toolbar
		IToolBarManager toolbar = new ToolBarManager(SWT.FLAT | SWT.RIGHT); 
		coolBar.add(new ToolBarContributionItem(toolbar, "main"));
		// Add the entry to the
		toolbar.add(openAction);
		toolbar.add(iSaveAction);
	
		
	}
	
    @Override	protected void fillStatusLine(IStatusLineManager statusLine) {
    	super.fillStatusLine(statusLine);	
    // 定义StatusLineContributionItem对象	
    final StatusLineContributionItem statusItem = new StatusLineContributionItem("");	
    // 获取进度监视器，并在状态栏显示		
    statusLine.getProgressMonitor();	
    // 设置状态栏文本		

    
    statusItem.setText("开发:中国科学院国家空间科学中心-张峻巍");	
    //将statusItem注册到statusLine	
    statusLine.add(statusItem);	
    final StatusLineContributionItem statusItem2 = new StatusLineContributionItem("");	
    statusItem2.setText("V0.8.30223.56-Beta");	
    //将statusItem注册到statusLine	
    statusLine.add(statusItem2);
    }
    


	
	

}
