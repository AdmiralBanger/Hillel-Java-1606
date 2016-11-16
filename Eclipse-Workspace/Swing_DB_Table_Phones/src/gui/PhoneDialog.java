package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import logic.Phone;

@SuppressWarnings("serial")
public class PhoneDialog extends JDialog 
{
	JTextField phoneIDField = null;
	JTextField personIDField = null;
	JTextField typeField = null;
	JTextField ageField = null;
	JTextField streetIDField = null;
	
	public PhoneDialog() 
	{
		setTitle("Phone Dialog");
		setLayout(null);
		setModal(true);
		setBounds(500, 500, 430, 80);
		
		phoneIDField = new JTextField("Phone ID");
		phoneIDField.setBounds(10, 10, 30, 20);
		add(phoneIDField);
		
		personIDField = new JTextField("Person ID");
		personIDField.setBounds(50, 10, 100, 20);
		add(personIDField);
		
		typeField = new JTextField("Type");
		typeField.setBounds(160, 10, 100, 20);
		add(typeField);
		
		ageField = new JTextField("Phone");
		ageField.setBounds(270, 10, 30, 20);
		add(ageField);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(350, 10, 50, 20);
		add(btnOk);
		btnOk.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
			}
		});
	}
	
	public Phone getPhone()
	{
		Phone p = new Phone(
				Integer.parseInt(phoneIDField.getText()),
				Integer.parseInt(personIDField.getText()),
				typeField.getText(),
				ageField.getText());
		return p;
	}
}
