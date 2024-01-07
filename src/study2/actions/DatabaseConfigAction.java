package study2.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchWindow;

public class DatabaseConfigAction extends Action {

    private IWorkbenchWindow window;

    public DatabaseConfigAction(IWorkbenchWindow window) {
        this.window = window;
        setText("数据库连接配置…");
        setId("study2.DatabaseConfigAction");
    }

    @Override
    public void run() {
        // 实现打开数据库配置窗口的逻辑
    }
}
