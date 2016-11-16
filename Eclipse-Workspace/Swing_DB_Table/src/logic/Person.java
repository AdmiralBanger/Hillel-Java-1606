package logic;
import java.sql.*;
import java.util.ArrayList;

public class Person 
{
	public int id;
	public String first_name;
	public String last_name;
	public int age;
	public int street_id;
	
	public Person(int id, String first_name, String last_name, int age, int street_id) 
	{
		init(id, first_name, last_name, age, street_id);
	}
	
	public void init(int id, String first_name, String last_name, int age, int street_id) 
	{
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.street_id = street_id;
	}

	@Override
	public String toString() 
	{
		return "Person [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", age=" + age
				+ ", street_id=" + street_id + "]";
	}
	
	public static ArrayList<Person> initFromH2() throws ClassNotFoundException, SQLException 
	{
		ResultSet rs = Connectors.query("SELECT * FROM person");
		ArrayList<Person> pr = new ArrayList<Person>();
		
		while (rs.next())
        {
			pr.add(new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
        }
		
		return pr;
	}			
}
