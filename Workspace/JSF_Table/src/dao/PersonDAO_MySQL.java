package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import logic.Person;

public class PersonDAO_MySQL implements PersonDAO
{	
	@Override
	public void create(Person p) 
	{
		try
		{
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/person");
			Statement st = dataSource.getConnection().createStatement();
			st.execute("INSERT INTO Person VALUES (" + p.id+ ", '" + p.first_name + "', '" + p.last_name + "', " + p.age + ")");
		}
		catch (SQLException | NamingException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Person> read() 
	{
		ArrayList<Person> pp = new ArrayList<Person>();
		try 
		{
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/person");
			Statement st = dataSource.getConnection().createStatement();		

			ResultSet result;
			result = st.executeQuery("SELECT * FROM Person");
			while (result.next())
			{			
				pp.add(new Person(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getInt(5)));
			}
			result.close();
		} 
		catch (SQLException | NamingException e)
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
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/person");
			Statement st = dataSource.getConnection().createStatement();
			st.execute("UPDATE Person SET fname='"+ p.first_name + "', lname='" + p.last_name + "', age=" + p.age + " WHERE id=" + p.id );
			
			st.close();
		} 
		catch (SQLException | NamingException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) 
	{
		try
		{
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/person");
			Statement st = dataSource.getConnection().createStatement();
			st.execute("DELETE FROM Person WHERE id=" + id);
		
			st.close();
		} 
		catch (SQLException | NamingException e) 
		{
			e.printStackTrace();
		}
	}
}
