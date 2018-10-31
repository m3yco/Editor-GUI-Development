import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;

public class TabElement {
	
	public static void createTab(CTabFolder folder) {
		CTabItem tabItem = new CTabItem(folder, SWT.NONE);
		tabItem.setText("new.txt");
		tabItem.setControl(openText(folder));
		folder.setSelection(tabItem);
	}
	
	public static void createTab(CTabFolder folder, String name, String content) {
		CTabItem tabItem = new CTabItem(folder, SWT.NONE);
		tabItem.setText(name);
		tabItem.setControl(openText(folder,content));
		folder.setSelection(tabItem);
	}
	
	public static Text openText(CTabFolder folder) {
		Text textField = new Text(folder, SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		GridData gdataText = new GridData(SWT.FILL,SWT.FILL,true,true,2,1);
		textField.setLayoutData(gdataText);
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
