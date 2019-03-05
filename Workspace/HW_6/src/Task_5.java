import java.sql.ResultSet;
import java.sql.SQLException;

import SQL.doQueryFunc;

public class Task_5
{
	public static void main(String[] args) throws SQLException 

	{
		ResultSet rs = doQueryFunc.doQuery("SELECT LastName FROM Person WHERE LastName LIKE '_%á%_';");
		while (rs.next()) 
		{
			String count = rs.getString(1);
			System.out.println(count);
		}
	}
}