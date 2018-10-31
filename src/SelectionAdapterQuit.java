import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class SelectionAdapterQuit extends SelectionAdapter {

	private CTabFolder allTabs;
	
	public SelectionAdapterQuit(CTabFolder allTabs) {
		this.allTabs = allTabs;
	}
	
	public void widgetSelected(SelectionEvent e) {
		CTabItem [] allMyItems = allTabs.getItems();
		Shell shell = (Shell)allTabs.getParent();
		
		MessageBox question = new MessageBox(shell,SWT.ICON_QUESTION | SWT.YES | SWT.NO | SWT.CANCEL);
		question.setMessage("Wollen Sie wirkllich ohne Speichern die Anwendung schließen?");
		int answerQuit = question.open();
		
		// Schleife über alle Items
		//		Textfeld aus allMyITems[i] abfragen mit getControl()
		//		Inhalt aus Texfeld abfragen mit getText()
		//		ggf über FileDialog afragen, wie Datei heißen soll
		//		Inhalt über FileIO abspeichern
		
		//		Ganz am Schluss: alles disposen mit shell.dispose()
		switch(answerQuit) {
		case SWT.YES:	
			shell.dispose(); 
			break;
		case SWT.NO:	
			for(CTabItem a : allMyItems) {
				a.getControl();
				FileDialog dlg = new FileDialog(shell,SWT.SAVE);
				String filename = dlg.open();
				String content = a.getText();
				if(filename != null) {
					FileIO.write(filename, content);
					}
			}
			break;
		case SWT.CANCEL:
			break;
		}
		
	}

}
