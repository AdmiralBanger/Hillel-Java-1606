import java.sql.ResultSet;
import java.sql.SQLException;

import SQL.doQueryFunc;

public class Task_7
{
	public static void main(String[] args) throws SQLException 

	{
		ResultSet rs = doQueryFunc.doQuery("SELECT FirstName, LastName FROM Person WHERE age < 18 AND id_street IN "
											+ "(SELECT id FROM Street WHERE Name = '����. ������');");
		while (rs.next()) 
		{
			String res1 = rs.getString(1);
			String res2 = rs.getString(2);
			System.out.println(res1 + "\t" + res2);
		}
	}
}