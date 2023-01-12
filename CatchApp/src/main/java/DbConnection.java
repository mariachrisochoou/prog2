import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** This class achieves the connection with the database.
 * 
 * 	@author Maria Chrisochoou
 */
public class DbConnection {

	/* Get connection object after connecting with the database */
	public Connection connect() {

		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:C:\\sqlite\\AppDatabase.db";
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {

		} catch (ClassNotFoundException e) {

	 	} 
		
		return conn;
	}

	
}

