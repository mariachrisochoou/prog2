//import necessary classes
import java.sql.*;

public class DbConnection {
	
	//information needed to establish connection with database
	 String url;
	 String dbusername;
	 String dbpassword;
	
	public DbConnection(String url, String dbusername, String dbpassword) {
		this.url = url;
		this.dbusername = dbusername;
		this.dbpassword = dbpassword;
	}
    
	public Connection getConnection() throws SQLException, Exception{
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,dbusername,dbpassword);
		System.out.println("Connection established succeessfully");
		return con;
	}
	
	public static void closeConnection(Connection con,Statement stmt) throws SQLException {
        stmt.close();
        con.close();
        System.out.println("The connection is now closed");
    }
	
	
}
