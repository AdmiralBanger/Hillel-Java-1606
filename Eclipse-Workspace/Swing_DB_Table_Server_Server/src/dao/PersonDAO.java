package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import logic.*;

public class PersonDAO implements PersonInterface
{
	@Override
	public ArrayList<Person> read() 
	{
		ArrayList<Person> pp = new ArrayList<Person>();
		ResultSet result;
		try
		{
			result = Connectors.query("SELECT * FROM Person");
			while (result.next()) 
			{			
				pp.add(new Person(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getInt(5)));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return pp;
	}
	public void create()
	{
		try
		{
			Connectors.execute("INSERT INTO person VALUES()");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void delete(int id)
	{
		try
		{
			Connectors.execute("DELETE FROM Person WHERE id = " + id);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void update(Person p, int col)
	{
		try
		{
			switch (col)
			{
				case 0: Connectors.execute("UPDATE person SET id = " + p.id);
				case 1: Connectors.execute("UPDATE person SET first_name = '" + p.first_name + "' WHERE id = " + p.id);
				case 2: Connectors.execute("UPDATE person SET last_name = '" + p.last_name + "' WHERE id = " + p.id);
				case 3: Connectors.execute("UPDATE person SET age = " + p.age + " WHERE id = " + p.id);
				case 4: Connectors.execute("UPDATE person SET street_id = " + p.street_id + " WHERE id = " + p.id);
			}
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
