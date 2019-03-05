package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.PersonDAO;
import logic.Person;
import logic.PhonesTableModel;

@SuppressWarnings("serial")
public class EditDialog extends JDialog 
{
	JTextField idField = null;
	JTextField fNameField = null;
	JTextField lNameField = null;
	JTextField ageField = null;
	JTextField streetIDField = null;
	PhonesTableModel tm = null;
	JTable tbl = null;
	public boolean flag = false; 
	
	public EditDialog() 
	{
		setTitle("Edit Dialog");
		setLayout(null);
		setModal(true);
		setBounds(500, 500, 430, 200);
		
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

		tbl = new JTable();
		JScrollPane scr = new JScrollPane(tbl);
		scr.setBounds(10, 40, 250, 100);
		add(scr);
		tbl.addMouseListener(new MouseListener() 
		{
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				JTable tbl = (JTable) e.getSource();
				
				PhoneDialog dia = new PhoneDialog();
				dia.setPhone(tm.pp.get(tbl.getSelectedRow()));
				dia.setVisible(true);
				
				if(dia.flag == true)
				{
					PersonDAO pd = new PersonDAO();
					pd.updatePhone(dia.getPhone());
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JButton btnCreatePhone = new JButton("Create Phone");
		btnCreatePhone.setBounds(280, 40, 120, 20);
		add(btnCreatePhone);
		btnCreatePhone.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				PhoneDialog dia = new PhoneDialog();
				dia.setVisible(true);
				
				if( dia.flag == true)
				{
					PersonDAO pd = new PersonDAO();
					pd.createPhone(dia.getPhone());
				}
			}
		});
		
		JButton btnDeletePhone = new JButton("Delete Phone");
		btnDeletePhone.setBounds(280, 70, 120, 20);
		add(btnDeletePhone);
		btnDeletePhone.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				PhoneDialog dia = new PhoneDialog();
				dia.setVisible(true);
				
				if( dia.flag == true)
				{
					PersonDAO pd = new PersonDAO();
					pd.deletePhone(dia.getPhone().phone_id);
				}
			}
		});
		
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
		return new Person(
				Integer.parseInt(idField.getText()),
				fNameField.getText(),
				lNameField.getText(),
				Integer.parseInt(ageField.getText()),
				Integer.parseInt(streetIDField.getText()));
	}
	
	public void setPerson(Person p)
	{
		idField.setText(Integer.toString(p.id));
		fNameField.setText(p.first_name);
		lNameField.setText(p.last_name);
		ageField.setText(Integer.toString(p.age));
		streetIDField.setText(Integer.toString(p.street_id));
		
		tm = new PhonesTableModel(p.phones);
		tbl.setModel(tm);
	}
}
