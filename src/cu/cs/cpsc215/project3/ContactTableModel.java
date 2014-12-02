package cu.cs.cpsc215.project3;

import javax.swing.table.AbstractTableModel;

public class ContactTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 5285754129908910200L;
	private DataStore ds = DataStore.getInstance();

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return ds.getContactCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int arg1) {
		switch (arg1) {
			case 0:
				return ds.getContact(rowIndex).getFirst();
			case 1:
				return ds.getContact(rowIndex).getLast();
			case 2:
				return ds.getContact(rowIndex).getEmail();
			case 3:
				return ds.getContact(rowIndex).getPhone();
			case 4:
				return ds.getContact(rowIndex).getAddress();
			default:
				return null;
		}
	}
	
	public void refreshData() {
		fireTableDataChanged();
	}
	
	public void addNewContact(Contact p) {
		ds.addContact(p);
		fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
	}
	
	public void removePersons(int[] rowIndices) {
		if (rowIndices.length <= 0)
			return;
		
		for (int i : rowIndices) {
			ds.removeContact(i);
		}
		
		fireTableDataChanged();
	}
}
