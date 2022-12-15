import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.Exception;

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

	public static void main(String[] args) {
	
		
	Message m = new Message(connect());
		
		
		try {
			m.getMessageDetails();
			//m.showMessages();
		} catch (Exception e) {
			
		} 

	}
}


