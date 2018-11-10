package GUI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import Listener.SelectionAdapterHelp;
import Listener.SelectionAdapterNew;
import Listener.SelectionAdapterOpen;
import Listener.SelectionAdapterQuit;
import Listener.SelectionAdapterSave;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

public class HSAlbSigEditor {
	private Shell shell;
	private Display display;
	private Menu menuBar;
	private CoolBar cbar;
	
    private MenuItem fileTitle, editTitle, helpTitle;
    private Menu fileMenu, editMenu, helpMenu;
    private MenuItem fileNewItem, fileOpenItem, fileSaveItem, fileQuitItem;
    private MenuItem editTextColorItem;
    private MenuItem helpHelpItem;
    
    private CoolItem itemOpen, itemSave;
    private Button buttonOpen, buttonSave;
    
    private CTabFolder tabFolder;
    
    //Color private?
    private Color color;
	
	private void createDisplay() {
		display = new Display();
	}
	
	private void createShell() {
		shell = new Shell(display);
		//shell.setLayout(new FillLayout(SWT.VERTICAL));
		shell.setLayout(new GridLayout(1,true));
	}
	
	public void createMenu(){
		shell.setText("HS AlbSig Editor");
		Image small = new Image(display,"pictures/hsalbsig_icon.gif");
		shell.setImage(small);
		String menuItems[] = {"&File", "&Edit", "&Help"};
	        
	    menuBar = new Menu(shell, SWT.BAR);
	    shell.setMenuBar(menuBar);
	    
	    // Toolbar mit Items befüllen
	    fileTitle = new MenuItem(menuBar, SWT.CASCADE);
	    fileTitle.setText(menuItems[0]);
	 	fileMenu = new Menu(shell, SWT.DROP_DOWN);
	 	fileTitle.setMenu(fileMenu);
	 
	 	editTitle = new MenuItem(menuBar, SWT.CASCADE);
	 	editTitle.setText(menuItems[1]);
	 	editMenu = new Menu(shell, SWT.DROP_DOWN);
	 	editTitle.setMenu(editMenu);
	 	
	 	helpTitle = new MenuItem(menuBar, SWT.CASCADE);
	 	helpTitle.setText(menuItems[2]);
	 	helpMenu = new Menu(shell, SWT.DROP_DOWN);
	 	helpTitle.setMenu(helpMenu);
	 	
	 	// Item File mit Elemte befüllen
	 	fileNewItem = new MenuItem(fileMenu, SWT.PUSH);
	 	fileNewItem.setText("&New\tCtrl+N");
	 	fileNewItem.setAccelerator(SWT.CTRL + 'N');
	 	
	 	fileOpenItem = new MenuItem(fileMenu, SWT.PUSH);
	 	fileOpenItem.setText("&Open ...\tCtrl+O");
	 	fileOpenItem.setAccelerator(SWT.CTRL + 'O');
	 	
	 	fileSaveItem = new MenuItem(fileMenu, SWT.PUSH);
	 	fileSaveItem.setText("&Save ...\tCtrl+S");
	 	fileSaveItem.setAccelerator(SWT.CTRL + 'S');
	 	//fileSaveItem.addSelectionListener(new SelectionAdapterSave(textField));
	 	
	 	fileQuitItem = new MenuItem(fileMenu, SWT.PUSH);
	 	fileQuitItem.setText("&Quit\tCtrl+Q");
	 	fileQuitItem.setAccelerator(SWT.CTRL + 'Q');
	 	
	 	// Item Edit mit Elemente befüllen
	 	editTextColorItem = new MenuItem(editMenu, SWT.PUSH);
	 	editTextColorItem.setText("&Text Color\tCtrl+C");
	 	editTextColorItem.setAccelerator(SWT.CTRL + 'C');
	 	
	 	// Item Help mit Elemente befüllen
	 	helpHelpItem = new MenuItem(helpMenu, SWT.PUSH);
	 	helpHelpItem.setText("&Version \tCtrl+V");
	 	helpHelpItem.setAccelerator(SWT.CTRL + 'V');
	}
	
	public void createCoolBar() {
		// Coolbar erstellen
		cbar = new CoolBar(shell,SWT.BORDER);
		
		// Button für Öffnen erstellen
		itemOpen = new CoolItem(cbar, SWT.NONE);
		buttonOpen = new Button(cbar, SWT.PUSH);
		Image openImage = new Image(display,"pictures/opened-folder.png");
		buttonOpen.setImage(openImage);
		Point size = buttonOpen.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		itemOpen.setPreferredSize(itemOpen.computeSize(size.x, size.y));
		itemOpen.setControl(buttonOpen);
		
		// Button für Speichern erstellen
		itemSave = new CoolItem(cbar, SWT.NONE);
		buttonSave = new Button(cbar, SWT.PUSH);
		Image saveImage = new Image(display,"pictures/save-close.png");
		buttonSave.setImage(saveImage);
		size = buttonSave.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		itemSave.setPreferredSize(itemSave.computeSize(size.x, size.y));
		itemSave.setControl(buttonSave);
		
		cbar.pack();
	}
	
	public void createTabFolder() {
		tabFolder = new CTabFolder(shell, SWT.VERTICAL);
		tabFolder.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,2,1));
		tabFolder.setSimple(false);
		tabFolder.setUnselectedImageVisible(false);
		tabFolder.setUnselectedCloseVisible(false);
	}
	
	public void createTabItem(CTabFolder parent) {
		color = new Color(display,0,0,0);
		TabElement.createTab(parent, color);
		//TabElemet.setDefaltColor();
	}
	
	public void createListeners() {
		
		fileQuitItem.addSelectionListener(new SelectionAdapterQuit(tabFolder));
		helpHelpItem.addSelectionListener(new SelectionAdapterHelp(shell));
		fileNewItem.addSelectionListener(new SelectionAdapterNew(tabFolder, color));
		fileOpenItem.addSelectionListener(new SelectionAdapterOpen(shell, tabFolder));
		fileSaveItem.addSelectionListener(new SelectionAdapterSave(shell, tabFolder));
		
		buttonOpen.addSelectionListener(new SelectionAdapterOpen(shell, tabFolder));
		buttonSave.addSelectionListener(new SelectionAdapterSave(shell, tabFolder));
		
		editTextColorItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				ColorEditor edit = new ColorEditor(shell, shell.getStyle());
				color = (Color) edit.open();
				//TabItem.SetColor(folder,color); TODO????
				//Offnen Speicher New Exceptionwurf!!!
			}
		});
	}
	
	public HSAlbSigEditor() {
		createDisplay();
		createShell();
		createMenu();
		createCoolBar();
		createTabFolder();
		createTabItem(tabFolder);
		createListeners();
	}
	
	public void open() {
		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}// end if
		}// end while
	}// end method
		
}
