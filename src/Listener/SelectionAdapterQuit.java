package Listener;
import java.util.ResourceBundle;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import XMLparser.XMLwrite;

public class SelectionAdapterQuit extends SelectionAdapter {

	private CTabFolder allTabs;
	private ResourceBundle messages;
	
	public SelectionAdapterQuit(CTabFolder allTabs, ResourceBundle rb) {
		this.allTabs = allTabs;
		this.messages  = rb;
	}
	
	public void widgetSelected(SelectionEvent e) {
		CTabItem [] allMyItems = allTabs.getItems();
		Shell shell = (Shell)allTabs.getParent();
		
		MessageBox question = new MessageBox(shell,SWT.ICON_QUESTION | SWT.YES | SWT.NO | SWT.CANCEL);
		question.setMessage(messages.getString("question"));
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
				Text text = (Text) a.getControl();
				FileDialog dlg = new FileDialog(shell,SWT.SAVE);
				try {
					String filename = dlg.open();
					String content = text.getText();
					if(filename != null) {
						Color c = text.getForeground();
						//XML Parser Write!
						XMLwrite writer = new XMLwrite();
						writer.writeDown(filename, content, c);
						c = null;
						}
				}
				catch (NullPointerException ex) {
					// wenn kein Name oder Datei gewählt worden ist!
				}
				
			}
			shell.dispose(); 
			break;
		case SWT.CANCEL:
			break;
		}
		
	}

}
