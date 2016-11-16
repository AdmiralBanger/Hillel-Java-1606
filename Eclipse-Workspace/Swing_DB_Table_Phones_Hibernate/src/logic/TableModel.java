package logic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import dao.*;
import gui.EditDialog;

@SuppressWarnings("serial")
public class TableModel extends AbstractTableModel 
{
	public ArrayList<Person> pp = null;
	public PersonInterface pd = new PersonDAO();
	public ActionCreate aCreate = new ActionCreate();
	public ActionRead   aRead   = new ActionRead();
	public ActionUpdate aUpdate = new ActionUpdate();
	public ActionDelete aDelete = new ActionDelete();
	public update aUpd = new update();
	
	public TableModel() 
	{
		pp = pd.read();
	}
	@Override
	public int getColumnCount() 
	{
		return 6;
	}
	@Override
	public int getRowCount() 
	{
		return pp.size();
	}
	@Override
	public boolean isCellEditable(int row, int col)
    { 
		return false; 
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
			case 5: ret = getPhonesNum(p); break;
		}
		return ret;
	}
	
	private String getPhonesNum(Person p)
	{
		String res = "";
		
		if (p.phones.size() > 0)
		{
			res = p.phones.get(0).phone;
			if (p.phones.size() > 1)
			{
				res += " (+" + (p.phones.size()-1) + ")";
			}
		}
		
		return res;
	}
	
	@Override
	public String getColumnName(int index)
	{
		String[] names = {"ID", "First Name", "Last Name", "Age", "Street ID", "Phones"};
		return names[index];
	}
	
	class ActionCreate implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			EditDialog dia = new EditDialog();
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
			EditDialog dia = new EditDialog();
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
			EditDialog dia = new EditDialog();
			dia.setVisible(true);
			if( dia.flag == true)
			{
				pd.delete(dia.getPerson().id);
			}
		}		
	}
	
	class update implements MouseListener
	{
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			JTable tbl = (JTable) e.getSource();
			
			EditDialog dia = new EditDialog();
			dia.setPerson(pp.get(tbl.getSelectedRow()));
			dia.setVisible(true);
			
			if( dia.flag == true)
			{
				pd.update(dia.getPerson());
				fireTableDataChanged();
			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
