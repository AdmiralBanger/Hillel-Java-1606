package logic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import dao.*;

@SuppressWarnings("serial")
public class TableModel extends AbstractTableModel 
{
	
	public ArrayList<Person> 	pp = null;
	public PersonDAO_Mock			pd = new PersonDAO_Mock();
	//public PersonInterface 		pd = new PersonDAO();
	public ActionReadFromDB 	aReadFromDB = new ActionReadFromDB();
	public ActionSave 			save = new ActionSave();
	public ActionRead 			read = new ActionRead();
	public PersonIO 			xml = new PersonIO_XML();
	public PersonIO 			csv = new PersonIO_CSV();
	public PersonIO 			json = new PersonIO_Json();
	public PersonIO 			yaml = new PersonIO_Yaml();
	
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
		pd.update(p, col);
		pp = pd.read();
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
		pd.delete(id);
		pp = pd.read();
		fireTableDataChanged();
	}
	public void insert()
	{
		pd.insert();
		pp = pd.read();
		fireTableDataChanged();
	}
	class ActionReadFromDB implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			pp = pd.read();
			fireTableDataChanged();
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
				xml.write(pp);
			}
			else if (str.equals("CSV"))
			{
				csv.write(pp);
			}
			else if (str.equals("Json"))
			{
				json.write(pp);
			}
			else if (str.equals("Yaml"))
			{
				yaml.write(pp);
			}
		}
	}
	class ActionRead implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String str = e.getActionCommand();
			if (str.equals("XML"))
			{
				pp = xml.read();
				fireTableDataChanged();
			}
			else if (str.equals("CSV"))
			{
				pp = csv.read();
				fireTableDataChanged();
			}
			else if (str.equals("Json"))
			{
				pp = json.read();
				fireTableDataChanged();
			}
			else if (str.equals("Yaml"))
			{
				pp = yaml.read();
				fireTableDataChanged();
			}
		}
	}
}
