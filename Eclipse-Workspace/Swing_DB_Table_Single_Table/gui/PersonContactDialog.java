package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import logic.Person;
import logic.TableModelContact;

@SuppressWarnings("serial")
public class PersonContactDialog extends JDialog
{
	JTextField txtId = null;
	JTextField txtFname = null;
	JTextField txtLname = null;
	JTextField txtAge = null;
	TableModel TM;
	JTable tblContact;
	
	public Person p;
	public boolean flag = false; 
	
	public PersonContactDialog(Person p) 
	{
		this.p = p;
		
		setLayout(null);
		setModal(true);
		setBounds(300, 400, 200, 450);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 10, 50, 20);
		add(lblId);
		
		txtId = new JTextField("" + p.id);
		txtId.setBounds(60, 10, 100, 20);
		add(txtId);
		
		JLabel lblFname = new JLabel("Fname");
		lblFname.setBounds(10, 40, 50, 20);
		add(lblFname);
		
		txtFname = new JTextField("" + p.fname);
		txtFname.setBounds(60, 40, 100, 20);
		add(txtFname);

		JLabel lblLname = new JLabel("Lname");
		lblLname.setBounds(10, 70, 50, 20);
		add(lblLname);
		
		txtLname = new JTextField("" + p.lname);
		txtLname.setBounds(60, 70, 100, 20);
		add(txtLname);

		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(10, 100, 50, 20);
		add(lblAge);
		
		txtAge = new JTextField("" + p.age);
		txtAge.setBounds(60, 100, 100, 20);
		add(txtAge);
		
		
		TableModelContact tmContact = new TableModelContact(p);
		JTable tblContact = new JTable(tmContact);
		
		JScrollPane scr = new JScrollPane(tblContact);
		scr.setBounds(10, 160, 160, 100);
		add(scr);
	
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(10, 350, 75, 20);
		add(btnOk);
		btnOk.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				flag = true;
				setVisible(false);
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(95, 350, 75, 20);
		add(btnCancel);
		btnCancel.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		
	}
	
	public Person getPerson()
	{
		int id = Integer.parseInt(txtId.getText());
		String fname = txtFname.getText();
		String lname = txtLname.getText();
		int age = Integer.parseInt(txtAge.getText());
		Person p = new Person(id, fname, lname, age);
		return p;
	}
}
