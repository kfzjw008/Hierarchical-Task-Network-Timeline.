package study2.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchWindow;

public class ExportDataAction extends Action {

    private IWorkbenchWindow window;

    public ExportDataAction(IWorkbenchWindow window) {
        this.window = window;
        setText("数据导出…");
        setId("study2.ExportDataAction");
    }

    @Override
    public void run() {
        // 实现数据导出功能的逻辑
    }
}
