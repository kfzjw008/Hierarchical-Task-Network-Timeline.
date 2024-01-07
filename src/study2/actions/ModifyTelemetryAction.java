package study2.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchWindow;

public class ModifyTelemetryAction extends Action {

    private IWorkbenchWindow window;

    public  ModifyTelemetryAction(IWorkbenchWindow window) {
        this.window = window;
        setText("修改遥测数据…");
        setId("study2.ConnectDatabaseAction");
    }

    @Override
    public void run() {
        // 实现数据库连接的逻辑
    }

}
