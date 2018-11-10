package Listener;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;

import GUI.TabElement;

public class SelectionAdapterNew  extends SelectionAdapter{
	private CTabFolder parent;
	private Color color;

	public SelectionAdapterNew(CTabFolder p, Color c) {
		this.parent = p;
		this.color = c;
	}
	
	public void widgetSelected(SelectionEvent e) {
		TabElement.createTab(parent, color);
	}
}
