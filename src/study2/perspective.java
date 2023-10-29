package study2;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;

import study2.views.MessageConsoleView;

public class perspective implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(true);
		layout.setFixed(false);
		String editorArea = layout.getEditorArea();
		System.out.println("3576085135813947");
		IFolderLayout tabs = layout.createFolder("BOTTOM", IPageLayout.BOTTOM, 0.55f, editorArea);
		// 属性
//		tabs.addPlaceholder(IPageLayout.ID_PROP_SHEET);
		// console view 绑定
		//layout.addView("study2.views.LogView", IPageLayout.BOTTOM,IPageLayout.RATIO_MAX, IPageLayout.ID_EDITOR_AREA);

	IFolderLayout leftTopFolder = layout.createFolder("LEFT", IPageLayout.LEFT, 0.18f, editorArea);
		leftTopFolder.addView("study2.views.DataBaseView");//study2.views.DataBaseView
		//leftTopFolder.addView("study2.view");
		
		// 右侧
		IFolderLayout leftBOTTOMFolder = layout.createFolder("BOTTOM", IPageLayout.BOTTOM, 0.8f, editorArea);
		leftBOTTOMFolder.addView("study2.views.LogView");

		IFolderLayout leftRIGHTFolder = layout.createFolder("RIGHT", IPageLayout.RIGHT, 0.75f, editorArea);
		leftRIGHTFolder.addView("study2.views.editorView");
	       
	    		  
	       
	}

}
