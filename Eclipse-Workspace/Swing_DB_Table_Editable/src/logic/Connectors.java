package logic;

import java.sql.*;

@SuppressWarnings("unused")
public class Connectors
{
	private static final String MySQL	= "jdbc:mysql://localhost:3306/test";
	private static final String MsSQL	= "jdbc:sqlserver://MYPC\\SQLEXPRESS;databaseName=test";
	private static final String MongoDB	= "jdbc:mongo://ds029847.mongolab.com:29847/tpch";
	private static final String H2 		= "jdbc:h2:~/test";
    private static final String user	= "sa";
    private static final String pass 	= "";
 
    private static Connection 	con;
    private static Statement 	stmt;
    private static ResultSet 	rs;
    
    public static void registerDrivers()
    {
    	try 
    	{
    		Class.forName("mongodb.jdbc.MongoDriver");
    		Class.forName("org.H2.Driver");
    		Class.forName("com.mysql.jdbc.Driver");
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} 
    	catch (ClassNotFoundException e) 
    	{
			e.printStackTrace();
		}
    }
    
    public static ResultSet query(String query) throws SQLException 
    { 
        con = DriverManager.getConnection(H2, user, pass);
        stmt = con.createStatement();
        rs = stmt.executeQuery(query);
        
        return rs;
    }
    
    public static void execute(String query) throws SQLException
    {
        con = DriverManager.getConnection(H2, user, pass);
        stmt = con.createStatement();
        stmt.execute(query);
    }
}
