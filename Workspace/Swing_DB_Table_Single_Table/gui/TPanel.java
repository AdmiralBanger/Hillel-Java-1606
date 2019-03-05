package gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import logic.TableModelPerson;

@SuppressWarnings("serial")
public class TPanel extends JPanel
{
	public static JTable tblPerson;
		
	public TPanel()
	{
		setLayout(null);
		
		TableModelPerson tmPerson = new TableModelPerson();
		tblPerson = new JTable(tmPerson);
		tblPerson.getColumnModel().getColumn(0).setPreferredWidth(20);
		tblPerson.getColumnModel().getColumn(3).setPreferredWidth(20);
		tblPerson.getColumnModel().getColumn(4).setPreferredWidth(90);
		JScrollPane scr = new JScrollPane(tblPerson);
		scr.setBounds(10, 10, 500, 300);
		add(scr);
		tblPerson.addMouseListener(tmPerson.aSelect);
		
	
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(520, 10, 120, 20);
		add(btnCreate);
		btnCreate.addActionListener( tmPerson.aCreate);
		
		JButton btnDel = new JButton("Delete");
		btnDel.setBounds(520, 40, 120, 20);
		add(btnDel);
		btnDel.addActionListener(tmPerson.aDelete);
	}
}