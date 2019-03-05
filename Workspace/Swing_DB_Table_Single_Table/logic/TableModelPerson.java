package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import dal.PersonDAO;
import dal.PersonDAO_Hibernate;
import gui.PersonContactDialog;
import gui.PersonDialog;

@SuppressWarnings("serial")
public class TableModelPerson extends AbstractTableModel
{
	ArrayList<Person> pp = null;
	PersonDAO pd = new PersonDAO_Hibernate();
	
	public int curRow = 0;
	
	public ActionSelect aSelect = new ActionSelect();
	
	public ActionCreate aCreate = new ActionCreate();
	public ActionDelete aDelete = new ActionDelete();	
	
	public TableModelPerson()
	{
		pp = pd.read();
	}

	@Override 
	public int getColumnCount() 
	{
		return 5;
	}

	public String getColumnName(int col) 
	{
		String[] m_colNames = { "id", "fname", "lname", "age", "phone"};
		return m_colNames[col];
	}

	@Override
	public int getRowCount() 
	{
		return pp.size();
	}

	@Override
	public Object getValueAt(int row, int col) 
	{
		Person p = pp.get(row);
		Object ret = null;
		switch (col)
		{
		case 0: ret = p.id;    break;
		case 1: ret = p.fname; break;
		case 2: ret = p.lname; break;
		case 3: ret = p.age;   break;
		case 4: ret = (getPhoneInfo(p)); break;
		}
		return ret;
	}

	
	public String getPhoneInfo(Person p)
	{
		String str = "";
		String[] cc = p.contacts.split(",");
		if (cc.length > 0)
		{
			str += cc[0];
		}
		if (cc.length > 1)
		{
			str += " (" + cc.length + ")";
		}
		return str;
	}
	
	class ActionCreate implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			PersonDialog dia = new PersonDialog();
			dia.setVisible(true);
			if( dia.flag == true)
			{
				pd.create(dia.getPerson());
				pp = pd.read();
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
				pp = pd.read();
				fireTableDataChanged();
			}
		}		
	}
	
	class ActionSelect implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) 
		{
			JTable target = (JTable)e.getSource();
		    curRow = target.getSelectedRow();
		    
		    if (e.getClickCount() == 2) 
		    {
		    	Person p = pp.get(curRow);
		    	PersonContactDialog dia = new PersonContactDialog(p);
		    	dia.setVisible(true);
				if( dia.flag == true)
				{
					pd.update(dia.getPerson());
					pp = pd.read();
					fireTableDataChanged();
				}
		    }
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {}
	}
	
}
