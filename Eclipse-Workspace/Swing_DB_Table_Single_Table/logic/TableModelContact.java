package logic;

import javax.swing.table.AbstractTableModel;

import dal.PersonDAO;
import dal.PersonDAO_Hibernate;

@SuppressWarnings("serial")
public class TableModelContact extends AbstractTableModel
{
	String[] cc;

	PersonDAO pd = new PersonDAO_Hibernate();
	
	public Person p;
	public int curRow;

	public TableModelContact(Person p) 
	{
		this.p = p;
		cc = p.contacts.split(",");
	}

	public String getColumnName(int col) 
	{
		String[] m_colNames = {"num"};
		return m_colNames[col];
	}

	@Override
	public int getColumnCount() 
	{
		return 1;
	}

	@Override
	public int getRowCount() 
	{
		return cc.length;
	}

	@Override
	public Object getValueAt(int row, int col) 
	{
		Object ret = null;
		switch (col)
		{
		case 0: ret = cc[row];    break;
		}
		return ret;
	}
}
