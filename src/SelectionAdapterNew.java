import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class SelectionAdapterNew  extends SelectionAdapter{
	private CTabFolder parent;

	public SelectionAdapterNew(CTabFolder p) {
		this.parent = p;
	}
	
	public void widgetSelected(SelectionEvent e) {
		TabElement.createTab(parent);
	}
}
