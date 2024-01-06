package study2.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

public class NezhaArchitectureConsoleView extends ViewPart {

    private Text textArea;
    private Tree commandTree;

    @Override
    public void createPartControl(Composite parent) {
        parent.setLayout(new GridLayout(1, false)); // One column layout for the main parent

        // Status indicators at the top
        Composite statusComposite = new Composite(parent, SWT.NONE);
        statusComposite.setLayout(new GridLayout(6, true)); // 6 columns for status indicators
        statusComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

        // Create status indicators
        String[] statusLabels = {"1553B总线", "网络连接总线", "状态1", "状态2", "状态3", "状态4"};
        for (String statusLabel : statusLabels) {
            createStatusIndicator(statusComposite, statusLabel, false); // Initially all statuses are false
        }

        // Input area and Send button just below status indicators
        Composite inputComposite = new Composite(parent, SWT.NONE);
        inputComposite.setLayout(new GridLayout(2, false));
        inputComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        textArea = new Text(inputComposite, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
        GridData textAreaData = new GridData(SWT.FILL, SWT.CENTER, true, false);
        textAreaData.heightHint = 50; // 50 pixels high
        textArea.setLayoutData(textAreaData);

        Button sendButton = new Button(inputComposite, SWT.PUSH);
        sendButton.setText("Send");
        sendButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

        // Bottom part is divided into left (Tree and Button) and right (Table)
        Composite bottomComposite = new Composite(parent, SWT.NONE);
        bottomComposite.setLayout(new GridLayout(2, true)); // Two equal columns
        bottomComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        // Left side for Tree and Button
        Composite treeComposite = new Composite(bottomComposite, SWT.NONE);
        treeComposite.setLayout(new GridLayout(1, false));
        treeComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        commandTree = new Tree(treeComposite, SWT.BORDER | SWT.V_SCROLL);
        commandTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        populateTree(commandTree); // Add some example values to the tree

        Button fillCommandButton = new Button(treeComposite, SWT.PUSH);
        fillCommandButton.setText("Fill Command");
        fillCommandButton.setLayoutData(new GridData(SWT.FILL, SWT.END, true, false));
        fillCommandButton.addListener(SWT.Selection, e -> fillCommandFromTree());

        // Right side for Table
        Table table = new Table(bottomComposite, SWT.BORDER | SWT.FULL_SELECTION);
        table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        // Create columns for the table
        TableColumn column1 = new TableColumn(table, SWT.NONE);
        column1.setText("名称");
        column1.setWidth(150);

        TableColumn column2 = new TableColumn(table, SWT.NONE);
        column2.setText("值");
        column2.setWidth(150);

        // Add some example data to the table
        for (int i = 0; i < 4; i++) {
            TableItem item = new TableItem(table, SWT.NONE);
            item.setText(new String[] { "Item " + (i + 1), String.valueOf(i * 10) });
        }

        // Adjust column width
        table.getColumn(0).pack();
        table.getColumn(1).pack();
    }

    private void createStatusIndicator(Composite parent, String label, boolean status) {
        Label statusLabel = new Label(parent, SWT.NONE);
        statusLabel.setText(label);

        Canvas statusCanvas = new Canvas(parent, SWT.NONE);
        statusCanvas.setLayoutData(new GridData(20, 20));
        statusCanvas.addPaintListener(e -> {
            Color color = status ? parent.getDisplay().getSystemColor(SWT.COLOR_GREEN) 
                                 : parent.getDisplay().getSystemColor(SWT.COLOR_RED);
            e.gc.setBackground(color);
            e.gc.fillOval(3, 3, 14, 14);
            e.gc.setForeground(parent.getDisplay().getSystemColor(SWT.COLOR_BLACK));
            e.gc.drawOval(3, 3, 14, 14); // Draw black border around the circle
        });
    }

    private void populateTree(Tree tree) {
        TreeItem item1 = new TreeItem(tree, SWT.NONE);
        item1.setText("Command 1");
        item1.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT));
        TreeItem item2 = new TreeItem(tree, SWT.NONE);
        item2.setText("Command 2");
        item2.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT));
        TreeItem item3 = new TreeItem(tree, SWT.NONE);
        item3.setText("Command 3");
        item3.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT));
        TreeItem item4 = new TreeItem(tree, SWT.NONE);
        item4.setText("Command 4");
        item4.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT));
        TreeItem item5 = new TreeItem(tree, SWT.NONE);
        item5.setText("Command 5");
        item5.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT));
        TreeItem item6 = new TreeItem(tree, SWT.NONE);
        item6.setText("Command 6");
        item6.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT));
        // Add more items as needed...
    }

    private void fillCommandFromTree() {
        TreeItem[] selection = commandTree.getSelection();
        if (selection.length > 0) {
            textArea.setText(selection[0].getText());
        }
    }

    @Override
    public void setFocus() {
        if (textArea != null && !textArea.isDisposed()) {
            textArea.setFocus();
        }
    }
}
