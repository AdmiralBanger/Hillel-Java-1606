import java.sql.ResultSet;
import java.sql.SQLException;

import SQL.doQueryFunc;

public class Task_4 
{

	public static void main(String[] args) throws SQLException 
	{
		ResultSet rs = doQueryFunc.doQuery(
				"SELECT COUNT(*) AS repeats, lastName FROM person GROUP BY lastName HAVING repeats > 1");
		while (rs.next()) 
        {
			String count = rs.getString(2);
			System.out.println(count);
        }
	}
}
