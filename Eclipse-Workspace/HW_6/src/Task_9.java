import java.sql.ResultSet;
import java.sql.SQLException;

import SQL.doQueryFunc;

public class Task_9
{
	public static void main(String[] args) throws SQLException 

	{
		ResultSet rs = doQueryFunc.doQuery("SELECT Name	FROM Street	WHERE CHAR_LENGTH(Name) = 6;");
		while (rs.next()) 
		{
			String res1 = rs.getString(1);
			System.out.println(res1);
		}
	}
}