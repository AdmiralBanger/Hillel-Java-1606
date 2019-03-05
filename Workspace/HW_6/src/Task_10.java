import java.sql.ResultSet;
import java.sql.SQLException;

import SQL.doQueryFunc;

public class Task_10
{
	public static void main(String[] args) throws SQLException 

	{
		ResultSet rs = doQueryFunc.doQuery("SELECT name	FROM street	WHERE id IN"
											+ "(SELECT id_street FROM person HAVING (COUNT(Id_street)<3));");
		while (rs.next()) 
		{
			String res1 = rs.getString(1);
			System.out.println(res1);
		}
	}
}