import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class SelectionAdapterOpen extends SelectionAdapter{
	private Shell shell;
	private CTabFolder parent;

	public SelectionAdapterOpen(Shell pshell, CTabFolder parent) {
		this.shell = pshell;
		this.parent = parent;
	}
	
	public void widgetSelected(SelectionEvent e) {
		FileDialog fileOpen = new FileDialog(shell, SWT.OPEN);
		String fileName = fileOpen.getFileName();
		String contentText = FileIO.read(fileName);
		TabElement.createTab(parent, fileName, contentText);
	}

}
