package logic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import dao.*;
import gui.PersonDialog;
import savers.*;

@SuppressWarnings("serial")
public class TableModel extends AbstractTableModel 
{
	public ArrayList<Person> pp = null;
	public PersonInterface pd = new PersonDAO();
	public ActionCreate aCreate = new ActionCreate();
	public ActionRead   aRead   = new ActionRead();
	public ActionUpdate aUpdate = new ActionUpdate();
	public ActionDelete aDelete = new ActionDelete();
	public ActionSave	save = new ActionSave();
	
	public TableModel() 
	{
		pp = pd.read();
	}
	@Override
	public int getColumnCount() 
	{
		return 5;
	}
	@Override
	public int getRowCount() 
	{
		return pp.size();
	}
	@Override
	public boolean isCellEditable(int row, int col)
    { 
		return true; 
	}
	@Override
	public Object getValueAt(int row, int col) 
	{
		Person p = pp.get(row);
		Object ret = null;
		switch (col)
		{
			case 0: ret = p.id; break;
			case 1: ret = p.first_name; break;
			case 2: ret = p.last_name; break;
			case 3: ret = p.age; break;
			case 4: ret = p.street_id; break;
		}
		return ret;
	}
	@Override
	public String getColumnName(int index)
	{
		String[] names = {"ID", "First Name", "Last Name", "Age", "Street ID"};
		return names[index];
	}
	
	class ActionCreate implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			PersonDialog dia = new PersonDialog();
			dia.setVisible(true);
			Person pr = dia.getPerson();
			
			for (int i = 0; i < pp.size(); i++)
			{
				if (i == pr.id)
				{
					JOptionPane.showMessageDialog(null, "This ID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
					fireTableDataChanged();
					dia.flag = false;
				}
			}
			
			if( dia.flag == true)
			{
				pd.create(pr);
			}
		}	
	}
	class ActionRead implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			pp = pd.read();
			fireTableDataChanged();
		}		
	}
	class ActionUpdate implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			PersonDialog dia = new PersonDialog();
			dia.setVisible(true);
			if( dia.flag == true)
			{
				pd.update(dia.getPerson());
				fireTableDataChanged();
			}
		}		
	}
	class ActionDelete implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			PersonDialog dia = new PersonDialog();
			dia.setVisible(true);
			if( dia.flag == true)
			{
				pd.delete(dia.getPerson());
			}
		}		
	}
	class ActionSave implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String str = e.getActionCommand();
			if (str.equals("XML"))
			{
				saveXML.save(pp);
			}
			else if (str.equals("CSV"))
			{
				saveCSV.save(pp);
			}
			else if (str.equals("Json"))
			{
				saveJson.save(pp);
			}
		}
	}
	
}
