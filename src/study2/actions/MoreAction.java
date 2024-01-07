package study2.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;

public class MoreAction extends Action {

    private IWorkbenchWindow window;

    public MoreAction(IWorkbenchWindow window) {
        this.window = window;
        setText("更多...");
        setId("study2.MoreAction");
    }

    @Override
    public void run() {
        // 显示一个简单的对话框
        MessageDialog.openInformation(window.getShell(), "更多", "这里还在建设中。");
    }
}
