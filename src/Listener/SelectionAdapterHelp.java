package Listener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class SelectionAdapterHelp extends SelectionAdapter {
	private Shell shell;
	
	public SelectionAdapterHelp(Shell shell) {
		this.shell = shell;
	}
	
	public void widgetSelected(SelectionEvent e) {
		MessageBox info = new MessageBox(shell,SWT.ICON_INFORMATION | SWT.OK);
		info.setMessage("GUI Development Praktikum Aufgabe 1 \nHS AlbSig Editor-Anwendung\n"+
		"Gruppenteilnehmer:\nDomenico Milazzo\nJohannes Harzman-Deis\n... \nVersion 1.0");
		info.open();
	}
}
