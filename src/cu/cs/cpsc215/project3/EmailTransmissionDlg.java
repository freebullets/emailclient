package cu.cs.cpsc215.project3;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EmailTransmissionDlg extends JDialog {
	private static final long serialVersionUID = 4104111623221324151L;
	private JTextField txtFrom;
	private JTextField txtTo;
	private JTextField txtSubject;
	private JTextArea txtMessage;
	private TreeSet<Contact> toSet = new TreeSet<Contact>();
	
	public EmailTransmissionDlg() {
		setTitle("Email Composer");
		setSize(500, 350);
		setModalityType(ModalityType.APPLICATION_MODAL);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonPanel.add(btnSend);
		
		JButton btnCancel = new JButton("Cancel");
		buttonPanel.add(btnCancel);
		
		JPanel mainPanel = new JPanel();
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		gbl_mainPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_mainPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_mainPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		mainPanel.setLayout(gbl_mainPanel);
		
		JLabel lblFrom = new JLabel("From");
		GridBagConstraints gbc_lblFrom = new GridBagConstraints();
		gbc_lblFrom.insets = new Insets(0, 0, 5, 5);
		gbc_lblFrom.anchor = GridBagConstraints.EAST;
		gbc_lblFrom.gridx = 0;
		gbc_lblFrom.gridy = 0;
		mainPanel.add(lblFrom, gbc_lblFrom);
		
		txtFrom = new JTextField();
		GridBagConstraints gbc_txtFrom = new GridBagConstraints();
		gbc_txtFrom.gridwidth = 2;
		gbc_txtFrom.insets = new Insets(0, 0, 5, 0);
		gbc_txtFrom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFrom.gridx = 1;
		gbc_txtFrom.gridy = 0;
		mainPanel.add(txtFrom, gbc_txtFrom);
		txtFrom.setColumns(10);
		
		JLabel lblTo = new JLabel("To");
		GridBagConstraints gbc_lblTo = new GridBagConstraints();
		gbc_lblTo.anchor = GridBagConstraints.EAST;
		gbc_lblTo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTo.gridx = 0;
		gbc_lblTo.gridy = 1;
		mainPanel.add(lblTo, gbc_lblTo);
		
		txtTo = new JTextField();
		GridBagConstraints gbc_txtTo = new GridBagConstraints();
		gbc_txtTo.insets = new Insets(0, 0, 5, 5);
		gbc_txtTo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTo.gridx = 1;
		gbc_txtTo.gridy = 1;
		mainPanel.add(txtTo, gbc_txtTo);
		txtTo.setColumns(10);
		
		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogMediator.getInstance().getEmlPicker().setVisible(true);
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 2;
		gbc_button.gridy = 1;
		mainPanel.add(button, gbc_button);
		
		JLabel lblSubject = new JLabel("Subject");
		GridBagConstraints gbc_lblSubject = new GridBagConstraints();
		gbc_lblSubject.anchor = GridBagConstraints.EAST;
		gbc_lblSubject.insets = new Insets(0, 0, 5, 5);
		gbc_lblSubject.gridx = 0;
		gbc_lblSubject.gridy = 2;
		mainPanel.add(lblSubject, gbc_lblSubject);
		
		txtSubject = new JTextField();
		GridBagConstraints gbc_txtSubject = new GridBagConstraints();
		gbc_txtSubject.gridwidth = 2;
		gbc_txtSubject.insets = new Insets(0, 0, 5, 0);
		gbc_txtSubject.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSubject.gridx = 1;
		gbc_txtSubject.gridy = 2;
		mainPanel.add(txtSubject, gbc_txtSubject);
		txtSubject.setColumns(10);
		
		JLabel lblMessage = new JLabel("Message");
		GridBagConstraints gbc_lblMessage = new GridBagConstraints();
		gbc_lblMessage.insets = new Insets(0, 0, 0, 5);
		gbc_lblMessage.gridx = 0;
		gbc_lblMessage.gridy = 3;
		mainPanel.add(lblMessage, gbc_lblMessage);
		
		txtMessage = new JTextArea();
		GridBagConstraints gbc_txtMessage = new GridBagConstraints();
		gbc_txtMessage.gridwidth = 2;
		gbc_txtMessage.fill = GridBagConstraints.BOTH;
		gbc_txtMessage.gridx = 1;
		gbc_txtMessage.gridy = 3;
		mainPanel.add(txtMessage, gbc_txtMessage);
	}
	
	public void addContact(Contact c) {
		toSet.add(c);
		
		String newString = "";
		for (Contact i : toSet) {
			if (newString.length() > 0)
				newString += ", ";
			newString += i.getEmail();
		}
		
		txtTo.setText(newString);
	}

}
