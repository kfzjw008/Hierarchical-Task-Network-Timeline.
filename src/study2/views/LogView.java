package study2.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class LogView extends ViewPart {

	public LogView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
	// TODO Auto-generated method stub
	Text text = new Text(parent, SWT.BORDER);
	text.setText("Imagine a fantastic user interface here");
	}
	@Override
	public void setFocus() {
	// TODO Auto-generated method stub
	}
}
