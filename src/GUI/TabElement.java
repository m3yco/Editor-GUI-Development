package GUI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;

public class TabElement {
	
	public static void createTab(CTabFolder folder, Color color) {
		CTabItem tabItem = new CTabItem(folder, SWT.NONE);
		tabItem.setText("new.txt");
		tabItem.setControl(openText(folder, color));
		folder.setSelection(tabItem);
	}
	
	public static void createTab(CTabFolder folder, String name, String content) {
		CTabItem tabItem = new CTabItem(folder, SWT.NONE);
		tabItem.setText(name);
		tabItem.setControl(openText(folder,content));
		folder.setSelection(tabItem);
	}
	
	public static Text openText(CTabFolder folder, Color color) {
		Text textField = new Text(folder, SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		GridData gdataText = new GridData(SWT.FILL,SWT.FILL,true,true,2,1);
		textField.setLayoutData(gdataText);
		textField.setForeground(color);
		return textField;
	}
	
	public static Text openText(CTabFolder folder, String content) {
		Text textField = new Text(folder, SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		GridData gdataText = new GridData(SWT.FILL,SWT.FILL,true,true,2,1);
		textField.setLayoutData(gdataText);
		textField.setText(content);
		return textField;
	}
	
	public static String getFileName(CTabFolder folder) {
		return folder.getSelection().getText();
	}
}
