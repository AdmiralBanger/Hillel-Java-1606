import java.sql.ResultSet;
import java.sql.SQLException;

import SQL.doQueryFunc;

public class Task_8
{
	public static void main(String[] args) throws SQLException 

	{
		ResultSet rs = doQueryFunc.doQuery("SELECT name, COUNT(person.id) FROM person, street "
											+ "WHERE streed.id = person.id_street GROUP BY street.name");
		while (rs.next())
		{
			String res1 = rs.getString(1);
			System.out.println(res1);
		}
	}
}