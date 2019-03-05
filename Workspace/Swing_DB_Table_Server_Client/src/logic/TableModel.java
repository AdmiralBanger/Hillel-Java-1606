package logic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TableModel extends AbstractTableModel 
{
	private Client client = new Client();
	private ArrayList<Person> 	pp = null;
	public ActionReadFromDB 	aReadFromDB = new ActionReadFromDB();
	
	public TableModel() 
	{
		pp = client.read();
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
	public void setValueAt(Object value, int row, int col) 
	{
		Person p = pp.get(row);
		switch (col)
		{
			case 0: p.id 			= Integer.parseInt((String) value); break;
			case 1: p.first_name 	= (String) value; break;
			case 2: p.last_name		= (String) value; break;
			case 3: p.age 			= Integer.parseInt((String) value); break;
			case 4: p.street_id		= Integer.parseInt((String) value); break;
		}
		client.update(p, col);
		pp = client.read();
		fireTableDataChanged();
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
	public void delete(int id)
	{
		client.delete(id);
		pp = client.read();
		fireTableDataChanged();
	}
	public void insert()
	{
		client.create();
		pp = client.read();
		fireTableDataChanged();
	}
	class ActionReadFromDB implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			pp = client.read();
			fireTableDataChanged();
		}		
	}
}
