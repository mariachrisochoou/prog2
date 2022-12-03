import java.sql.*;
import java.util.Scanner;


public class User2 {

	private Connection conn;
	private Scanner in = new Scanner(System.in);
	
	

	public User2(Connection conn) {
		this.conn = conn;
	} 
	
	public void insertData(String username, String password, String email) {
		
		String sql = "INSERT INTO User VALUES(?,?,?);";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println("Entered");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL!");
		} catch (Exception e) {
			System.out.println("Exception!");
		}
	}


	  public void getUserDetails() throws SQLException, Exception {

			String username, password, email;
			System.out.println("Enter your username");
			username = in.nextLine();

			System.out.println("Enter your password");
			password = in.nextLine();

			System.out.println("Enter your email");
			email = in.nextLine();

			insertData(username, password, email);

	    }

}
