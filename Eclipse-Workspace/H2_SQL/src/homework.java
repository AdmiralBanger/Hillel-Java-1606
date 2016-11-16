import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class homework 
{
	
	public static void main(String[] args) throws SQLException 
	{
		ResultSet rs = queryFunction.doQuery("SELECT * FROM person");
		ArrayList<Person> pr = new ArrayList<Person>();
		while (rs.next())
        {
			pr.add(new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
        }
		for (Person p : pr) 
		{
			System.out.println(p);
		}
	}
}
