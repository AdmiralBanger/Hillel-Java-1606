package SQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class doQueryFunc 
{
	private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "root";
 
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
 
    public static ResultSet doQuery(String query) throws SQLException 
    { 
    	// opening database connection to MySQL server
        con = DriverManager.getConnection(url, user, password);
        
        // getting Statement object to execute query
        stmt = con.createStatement();
        
        // executing SELECT query
        rs = stmt.executeQuery(query);
        
        return rs;
    }
}
