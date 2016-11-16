package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logic.Contact;
import logic.Person;

public class PersonDAO_MySQL implements PersonDAO
{

	private static final  String user = "root";
	private static final  String pswd = "";
	private static final String host = "jdbc:mysql://127.0.0.1:3306/person";

	@Override
	public void create(Person p) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(host, user, pswd);
			Statement st = connection.createStatement();
			st.execute("INSERT INTO Person VALUES (" + p.id+ ", '" + p.fname + "', '" + p.lname + "', " + p.age + ")");
		}
		catch (ClassNotFoundException | SQLException e) 
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
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(host, user, pswd);
			Statement st = connection.createStatement();			

			ResultSet result;
			result = st.executeQuery("SELECT * FROM Person");

			while (result.next()) 
			{
				Person p = new Person(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4));
				for (Contact c : addPhone(result.getInt(1)))
				{
					p.addContact(c);
				}
				pp.add(p);
			}
		} 
		catch (ClassNotFoundException|SQLException e)
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
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(host, user, pswd);
			Statement st = connection.createStatement();
			st.execute("UPDATE Person SET fname='"+ p.fname + "', lname='" + p.lname + "', age=" + p.age + " WHERE id=" + p.id );
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Person p) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(host, user, pswd);
			Statement st = connection.createStatement();
			st.execute("DELETE FROM Person WHERE id=" + p.id);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

	public ArrayList<Contact> addPhone(int id)
	{
		ArrayList<Contact> cc = new ArrayList<Contact>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(host, user, pswd);
			Statement st = connection.createStatement();
			ResultSet result1;
			result1 = st.executeQuery("SELECT * FROM contact where personId =" + id);
			while (result1.next()) 
			{
				cc.add(new Contact(result1.getString(2), result1.getString(3), new Person(id, "", "", 0)));
			}
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return cc;
	}


	public void createTel(Contact c) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(host, user, pswd);
			Statement st = connection.createStatement();
			st.execute("INSERT INTO Contact (num, telType, personId) VALUES ('" + c.num + "', '" + c.telType + "', " + c.person.id + ")");
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

	public void delTel(Contact c) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(host, user, pswd);
			Statement st = connection.createStatement();
			st.execute("DELETE FROM Contact WHERE num = '" + c.num +"' AND personId=" + c.person.id );
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}	
	}


	@Override
	public void updateTel(Contact c) 
	{
		// TODO Auto-generated method stub

	}
}