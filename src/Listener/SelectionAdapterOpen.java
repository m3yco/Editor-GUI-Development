package Listener;

import java.io.FileNotFoundException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import GUI.TabElement;
import XMLparser.XMLread;

public class SelectionAdapterOpen extends SelectionAdapter{
	private Shell shell;
	private CTabFolder parent;

	public SelectionAdapterOpen(Shell pshell, CTabFolder parent) {
		this.shell = pshell;
		this.parent = parent;
	}
	
	public void widgetSelected(SelectionEvent e) {
		FileDialog fileOpen = new FileDialog(shell, SWT.OPEN);
		try {
			String fileName = fileOpen.open();
			// XML Parser Open!!
			if(fileName != null) {
//				String contentText = FileIO.read(fileName);
//				TabElement.createTab(parent, fileName, contentText);
				XMLread reader = new XMLread(fileName, shell);
				TabElement.createTab(parent, fileName, reader.getText(), reader.getColor());
				
			}
		}
		catch (NullPointerException n){
			// wenn kein Name oder Datei gewählt worden ist!
		}
	}

}
