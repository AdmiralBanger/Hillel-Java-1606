package logic;

import java.sql.*;

public class Connectors
{
	private static final String MySQL	= "jdbc:mysql://localhost:3306/person";
    private static final String user	= "myroot";
    private static final String pass 	= "myroot";
 
    private static Connection 	con;
    private static Statement 	stmt;
    private static ResultSet 	rs;
    
    public static void registerDrivers()
    {
    	try 
    	{
    		Class.forName("com.mysql.jdbc.Driver");
		} 
    	catch (ClassNotFoundException e) 
    	{
			e.printStackTrace();
		}
    }
    
    public static ResultSet query(String query) throws SQLException 
    { 
        con = DriverManager.getConnection(MySQL, user, pass);
        stmt = con.createStatement();
        rs = stmt.executeQuery(query);
        
        return rs;
    }
    
    public static void execute(String query) throws SQLException
    {
        con = DriverManager.getConnection(MySQL, user, pass);
        stmt = con.createStatement();
        stmt.execute(query);
    }
    
    public static ResultSet query(String query, String table) throws SQLException 
    { 
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + table, user, pass);
        stmt = con.createStatement();
        rs = stmt.executeQuery(query);
        
        return rs;
    }
    
    public static void execute(String query, String table) throws SQLException
    {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + table, user, pass);
        stmt = con.createStatement();
        stmt.execute(query);
    }
}
