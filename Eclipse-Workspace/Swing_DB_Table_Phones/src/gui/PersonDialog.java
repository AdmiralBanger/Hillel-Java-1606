package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import logic.Person;

@SuppressWarnings("serial")
public class PersonDialog extends JDialog 
{
	JTextField idField = null;
	JTextField fNameField = null;
	JTextField lNameField = null;
	JTextField ageField = null;
	JTextField streetIDField = null;
	public boolean flag = false; 
	
	public PersonDialog() 
	{
		setTitle("Person Dialog");
		setLayout(null);
		setModal(true);
		setBounds(500, 500, 430, 80);
		
		idField = new JTextField("ID");
		idField.setBounds(10, 10, 30, 20);
		add(idField);
		
		fNameField = new JTextField("First Name");
		fNameField.setBounds(50, 10, 100, 20);
		add(fNameField);
		
		lNameField = new JTextField("Last Name");
		lNameField.setBounds(160, 10, 100, 20);
		add(lNameField);
		
		ageField = new JTextField("Age");
		ageField.setBounds(270, 10, 30, 20);
		add(ageField);
		
		streetIDField = new JTextField("sID");
		streetIDField.setBounds(310, 10, 30, 20);
		add(streetIDField);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(350, 10, 50, 20);
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
	}
	
	public Person getPerson()
	{
		Person p = new Person(
				Integer.parseInt(idField.getText()),
				fNameField.getText(),
				lNameField.getText(),
				Integer.parseInt(ageField.getText()),
				Integer.parseInt(streetIDField.getText()));
		return p;
	}
}
