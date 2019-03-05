package logic;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class PhoneModel extends AbstractTableModel 
{
	private ArrayList<Phone> pp;

	public PhoneModel(ArrayList<Phone> pp)
	{
		this.pp = pp;
	}
	
	@Override
	public int getColumnCount() 
	{
		return 4;
	}

	@Override
	public int getRowCount() 
	{
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
