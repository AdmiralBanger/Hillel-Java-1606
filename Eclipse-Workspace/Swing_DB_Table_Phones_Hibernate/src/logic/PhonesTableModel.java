package logic;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class PhonesTableModel extends AbstractTableModel 
{
	public ArrayList<Phone> pp = null;
	
	public PhonesTableModel(ArrayList<Phone> pp) 
	{
		this.pp = pp;
	}
	@Override
	public int getColumnCount() 
	{
		return 2;
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
		Phone p = pp.get(row);
		Object ret = null;
		switch (col)
		{
			case 0: ret = p.type; break;
			case 1: ret = p.phone; break;
		}
		return ret;
	}
	
	@Override
	public String getColumnName(int index)
	{
		String[] names = {"Type", "Phone"};
		return names[index];
	}
}
