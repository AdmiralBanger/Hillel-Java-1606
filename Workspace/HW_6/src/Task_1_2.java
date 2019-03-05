import SQL.doQueryFunc;

import java.sql.*;

public class Task_1_2 
{
	
	public static void main(String[] args) throws SQLException 
	{
		ResultSet rs1 = doQueryFunc.doQuery("SELECT COUNT(*) FROM person");
		while (rs1.next())
        {
			int count = rs1.getInt(1);
			System.out.println("Общее количество жителей: " + count + 1);
        }
		
		ResultSet rs2 = doQueryFunc.doQuery("SELECT AVG(age) FROM person");
		while (rs2.next()) 
        {
			int count = rs2.getInt(1);
			System.out.println("Средний возраст жителей: " + count);
        }
	}
}