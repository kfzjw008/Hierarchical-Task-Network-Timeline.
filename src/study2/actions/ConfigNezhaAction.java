package study2.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchWindow;

public class ConfigNezhaAction extends Action {

    private IWorkbenchWindow window;

    public ConfigNezhaAction(IWorkbenchWindow window) {
        this.window = window;
        setText("架构基本配置…");
        setId("study2.ConfigNezhaAction");
    }

    @Override
    public void run() {
        // 实现打开配置窗口的逻辑
    }
}
