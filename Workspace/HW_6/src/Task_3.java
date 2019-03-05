import SQL.doQueryFunc;
import java.sql.*;

public class Task_3 
{
	
	public static void main(String[] args) throws SQLException 
	{
		ResultSet rs = doQueryFunc.doQuery("SELECT DISTINCT LastName FROM person ORDER BY LastName");
		while (rs.next()) 
        {
			String count = rs.getString(1);
			System.out.println(count);
        }
	}
}
