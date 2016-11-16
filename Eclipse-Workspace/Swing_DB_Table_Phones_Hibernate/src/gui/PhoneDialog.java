package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JTextField;

import logic.Phone;

@SuppressWarnings("serial")
public class PhoneDialog extends JDialog 
{
	JTextField phone_idField = null;
	JTextField person_idField = null;
	JTextField typeField = null;
	JTextField phoneField = null;
	JTable tbl = null;
	public boolean flag = false; 
	
	public PhoneDialog() 
	{
		setTitle("Phone Dialog");
		setLayout(null);
		setModal(true);
		setBounds(500, 500, 430, 100);
		
		phone_idField = new JTextField("phone_id");
		phone_idField.setBounds(10, 10, 30, 20);
		add(phone_idField);
		
		person_idField = new JTextField("First Name");
		person_idField.setBounds(50, 10, 30, 20);
		add(person_idField);
		
		typeField = new JTextField("type");
		typeField.setBounds(90, 10, 100, 20);
		add(typeField);
		
		phoneField = new JTextField("phone");
		phoneField.setBounds(200, 10, 100, 20);
		add(phoneField);
		
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
	
	public Phone getPhone()
	{
		return new Phone(
				Integer.parseInt(phone_idField.getText()), 
				Integer.parseInt(person_idField.getText()), 
				typeField.getText(), 
				phoneField.getText());
	}
	
	public void setPhone(Phone p)
	{
		phone_idField.setText(Integer.toString(p.phone_id));
		person_idField.setText(Integer.toString(p.person_id));
		typeField.setText(p.type);
		phoneField.setText(p.phone);
	}
}
