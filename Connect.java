import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connect {

	public static Connection connect() {

		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:C:\\sqlite\\AppDatabase.db";
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println("excp");
		}catch (ClassNotFoundException e) {
			System.out.println("Class not found");
	 	} 
		return conn;
	}

	
}


