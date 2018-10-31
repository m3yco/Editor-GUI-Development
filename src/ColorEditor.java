import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;

public class ColorEditor extends Dialog{

	private int [] colorValues;
	private Label colorLabel;
	private Group gSpinner;
	private Spinner [] spinBoxRGB;
	
	public ColorEditor(Shell parent, int style) {
		super(parent, style);
		colorValues = new int [2];
	}
		public int[] open() {
			
			Shell dialogShell = new Shell(getParent());
			createContent(dialogShell);
			dialogShell.open();
			Display display = getParent().getDisplay();
			
			while(!dialogShell.isDisposed()) {
				if(!display.readAndDispatch()) {
					display.sleep();
				}
			}
			return colorValues;
		}
		
		public void createContent(Shell shell) {
			//Shell Layout
			GridLayout layout = new GridLayout(2,true);
			shell.setLayout(layout);
			
			//Label
			colorLabel = new Label(shell, SWT.CENTER);
			colorLabel.setText("Test");
			colorLabel.setBackground(new Color(shell.getDisplay(),255,0,0));
			colorLabel.setFont(new Font(shell.getDisplay(),"Arial",14,SWT.BOLD));
			// Parameter 1 & 2: Ausrichtungsverhalten innerhalt der Zelle
			// Parameter 3 & 4: Mitwachsen mit Zelle in x/y Richtung
			// Parameter 5 & 6: Ausdehnung innerhalb der Zelle(n)
			GridData gdata = new GridData(SWT.FILL,SWT.FILL,true,true,1,1);
			colorLabel.setLayoutData(gdata);
			
			//Spinner RGB
			gSpinner = new Group(shell,SWT.NO_RADIO_GROUP | SWT.SHADOW_ETCHED_IN);
			gSpinner.setFont(new Font(shell.getDisplay(),"Arial",12,SWT.BOLD));
			// Verhalten innerhalb der Zelle innerhalb der Shell
			gSpinner.setText("RGB");
			GridData gdataGroup = new GridData(SWT.FILL,SWT.FILL,true,true,1,1);
			gSpinner.setLayoutData(gdataGroup);
			
			// Verhalten der Group als Parent weiterer Widgets(hier: Spinner)
			FillLayout layoutGroup = new FillLayout(SWT.VERTICAL);
			layoutGroup.spacing = 5;
			gSpinner.setLayout(layoutGroup);
			
			// Kindwidgets erzeugen: Platz für 3 Spinner
			spinBoxRGB = new Spinner[3];
			
			for(int i =0; i<spinBoxRGB.length; i++) {
				spinBoxRGB[i] = new Spinner(gSpinner, SWT.NONE);
				spinBoxRGB[i].setMaximum(0);
				spinBoxRGB[i].setMaximum(255);
				spinBoxRGB[i].setFont(new Font(shell.getDisplay(),"Arial",12,SWT.BOLD));
			}
			//Buttons erzeugen
			//Listener
		}
}


