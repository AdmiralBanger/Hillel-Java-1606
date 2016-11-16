package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import logic.Person;

@SuppressWarnings("serial")
public class PersonDialog extends JDialog
{
	JTextField txtId = null;
	JTextField txtFname = null;
	JTextField txtLname = null;
	JTextField txtAge = null;
	
	public boolean flag = false; 
	
	public PersonDialog() 
	{
		setLayout(null);
		setModal(true);
		setBounds(300, 300, 200, 200);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 10, 50, 20);
		add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(60, 10, 100, 20);
		add(txtId);
		
		JLabel lblFname = new JLabel("Fname");
		lblFname.setBounds(10, 40, 50, 20);
		add(lblFname);
		
		txtFname = new JTextField();
		txtFname.setBounds(60, 40, 100, 20);
		add(txtFname);

		JLabel lblLname = new JLabel("Lname");
		lblLname.setBounds(10, 70, 50, 20);
		add(lblLname);
		
		txtLname = new JTextField();
		txtLname.setBounds(60, 70, 100, 20);
		add(txtLname);

		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(10, 100, 50, 20);
		add(lblAge);
		
		txtAge = new JTextField();
		txtAge.setBounds(60, 100, 100, 20);
		add(txtAge);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(10, 130, 75, 20);
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
		btnCancel.setBounds(95, 130, 75, 20);
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

	public void setPerson(Person p)
	{
		txtId.setText("" + p.id);
		txtFname.setText("" + p.fname);
		txtLname.setText("" + p.lname);
		txtAge.setText("" + p.age);
	}
}
