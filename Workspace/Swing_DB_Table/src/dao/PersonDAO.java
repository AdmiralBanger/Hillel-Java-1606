package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import logic.*;

public class PersonDAO implements PersonInterface
{
	@Override
	public void create(Person p) 
	{
		try 
		{
			Connectors.execute("INSERT INTO person VALUES (" + p.id + ", '" + p.first_name + "', '" 
									+ p.last_name + "', " + p.age + ", " + p.street_id + ")");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

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

	@Override
	public void update(Person p)
	{
		try
		{
			Connectors.execute("UPDATE Person SET first_name = '"+ p.first_name + "', last_name = '" + p.last_name 
									+ "', age = " + p.age + ", street_id = " + p.street_id + " WHERE id = " + p.id);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Person p) 
	{
		try
		{
			Connectors.execute("DELETE FROM person WHERE id = " + p.id);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
