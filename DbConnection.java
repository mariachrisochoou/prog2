//import librabry sql with the necessary classes to achieve java - mysql connection
import java.sql.*;

public class DbConnection {
	
	//url, dbusername, dbpassword : needed information to successfully connect to the database - standard practice
	 String url;
	 String dbusername;
	 String dbpassword;
	

	// Database Constructor 
	public DbConnection(String url, String dbusername, String dbpassword) {
		this.url = url;
		this.dbusername = dbusername;
		this.dbpassword = dbpassword;
	}


   // Μέθοδος τύπου Connection - Connection is a class in java.sql used to successfully connect java and mysql
   // SQL Exception - errors caused related to sql 
	public Connection getConnection() throws SQLException, Exception{

		//object type Connection
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		//use of the basic info to successfully enter the database
		con = DriverManager.getConnection(url,dbusername,dbpassword);
		System.out.println("Connection established succeessfully");
		return con;
	}
	

	//close the java - mySQL connection  - not needed anymore.
	public static void closeConnection(Connection con,Statement stmt) throws SQLException {
        stmt.close();
        con.close();
        System.out.println("The connection is now closed");
    }
	
	
}
