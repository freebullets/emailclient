package cu.cs.cpsc215.project3;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPanel;
import java.awt.GridLayout;

interface Command {
	void execute();
}

interface IMediator {
	public void add();
	public void edit();
	public void delete();
	public void registerTable(TblDisplay v);
	public void registerAdd(BtnAdd a);
	public void registerEdit(BtnEdit b);
	public void registerDelete(BtnDelete d);
}

class BtnAdd extends JButton implements Command {
	private static final long serialVersionUID = 1328622L;
	IMediator med;

	BtnAdd(ActionListener al, IMediator m) {
		super("Add Contact");
		addActionListener(al);
		med = m;
		med.registerAdd(this);
	}

	public void execute() {
		med.add();
	}

}

class BtnEdit extends JButton implements Command {
	private static final long serialVersionUID = 923784L;
	IMediator med;

	BtnEdit(ActionListener al, IMediator m) {
		super("Edit Contact");
		addActionListener(al);
		med = m;
		med.registerEdit(this);
	}

	public void execute() {
		med.edit();
	}

}

class BtnDelete extends JButton implements Command {
	private static final long serialVersionUID = 798123L;
	IMediator med;

	BtnDelete(ActionListener al, IMediator m) {
		super("Delete Contact");
		addActionListener(al);
		med = m;
		med.registerDelete(this);
	}

	public void execute() {
		med.delete();
	}

}

class TblDisplay extends JTable {
	private static final long serialVersionUID = 426862L;
	IMediator med;

	TblDisplay(IMediator m) {
		super(new ContactTableModel());
		med = m;
		med.registerTable(this);
	}

}

public class MainFrame extends JFrame implements ActionListener, IMediator {
	private static final long serialVersionUID = 1745232698701012553L;
	DataStore ds;
	ConfigurationDlg cfgDlg = new ConfigurationDlg();
	ContactEditingDlg contactDlg = new ContactEditingDlg();
	EmailTransmissionDlg transDlg = new EmailTransmissionDlg();
	SystemInformationDlg sysDlg = new SystemInformationDlg();
	TblDisplay contactsTbl;

	public MainFrame() {
		super("Email Client 1.0");

		ds = DataStore.getInstance();
		ds.load();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				DataStore.getInstance().save();
				System.exit(0);
			}
		});

		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"/path/to/image.ico"));
		setSize(600, 400);
		contactsTbl = new TblDisplay(this);
		getContentPane().add(contactsTbl, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		getContentPane().add(panel, BorderLayout.SOUTH);

		JButton frameAddBtn = new BtnAdd(this, this);
		JButton frameEditBtn = new BtnEdit(this, this);
		JButton frameDeleteBtn = new BtnDelete(this, this);

		panel.add(frameAddBtn);
		panel.add(frameEditBtn);
		panel.add(frameDeleteBtn);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmCompose = new JMenuItem("Compose");
		mntmCompose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transDlg.setVisible(true);
			}
		});
		mnFile.add(mntmCompose);

		JMenuItem mntmContacts = new JMenuItem("Contacts");
		mntmContacts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contactDlg.setVisible(true);
			}
		});
		mnFile.add(mntmContacts);

		JMenuItem mntmConfiguration = new JMenuItem("Configuration");
		mntmConfiguration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cfgDlg.setVisible(true);
			}
		});
		mnFile.add(mntmConfiguration);

		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);

		JMenuItem mntmSystemInformation = new JMenuItem("System Information");
		mntmSystemInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sysDlg.setVisible(true);
			}
		});
		mnAbout.add(mntmSystemInformation);
	}
	
	BtnAdd btnAdd;
	BtnEdit btnEdit;
	BtnDelete btnDelete;
	TblDisplay show;

	@Override
	public void registerAdd(BtnAdd a) {
		btnAdd = a;
	}

	@Override
	public void registerEdit(BtnEdit e) {
		btnEdit = e;
	}

	@Override
	public void registerDelete(BtnDelete d) {
		btnDelete = d;
	}

	@Override
	public void registerTable(TblDisplay d) {
		show = d;
	}

	@Override
    public void actionPerformed(ActionEvent ae) {
        Command comd = (Command) ae.getSource();
        comd.execute();
    }

	@Override
	public void add() {
		contactDlg.setVisible(true);
	}

	@Override
	public void edit() {
		contactDlg.setVisible(true);
		int row = contactsTbl.getSelectedRow();
		if (row > -1) {
			contactDlg.fillFields(ds.getContact(row).getFirst(), ds.getContact(row).getLast(), ds.getContact(row).getEmail(), ds.getContact(row).getAddress(), ds.getContact(row).getPhone());
		}
	}

	@Override
	public void delete() {
		ds.removeContact(contactsTbl.getSelectedRow());
		
	}
}
