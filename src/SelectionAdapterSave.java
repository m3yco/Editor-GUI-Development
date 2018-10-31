import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SelectionAdapterSave extends SelectionAdapter{
	private Shell shell;
	private CTabFolder content;
	
	public SelectionAdapterSave(Shell shell, CTabFolder c) {
		this.shell = shell;
		this.content = c;
	}
	
	public void widgetSelected(SelectionEvent e) {
		Text text =  (Text) content.getSelection().getData();
		FileDialog fileSave = new FileDialog(shell, SWT.SAVE);
		String fileName = fileSave.open();
		FileIO.write(fileName, text.getText());
		content.getSelection().setText(content.getSelection().getText());
	}
}
