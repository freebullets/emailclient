package cu.cs.cpsc215.project3;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmailPicker extends JDialog {
	private static final long serialVersionUID = 6227441202625554819L;
	private JTable contactsTbl;
	
	public EmailPicker() {
		setTitle("Select an Email to Add");
		setSize(450, 300);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setLocationByPlatform(true);
		
		contactsTbl = new JTable(MainFrame.getInstance().getTableModel());
		JScrollPane scrollPane = new JScrollPane(contactsTbl);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmailPicker.this.selectContact();
			}
		});
		getContentPane().add(btnAdd, BorderLayout.SOUTH);
		
		contactsTbl.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2)
					EmailPicker.this.selectContact();
			}
		});
		
	}
	
	private void selectContact() {
		DialogMediator.getInstance().getTransDlg().addContact(
				DataStore.getInstance().getContact(
						contactsTbl.getSelectedRow()
				)
		);
		
		setVisible(false);
	}

}
