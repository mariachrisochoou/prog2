import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NewUser {
	private String username;
	private String password;
	private String email;
	
	public void getUserDetails() {
		Scanner input = new Scanner(System.in); //odject input for getting user details
		System.out.println("Enter your username");
		username = input.nextLine();
		System.out.println("Enter your email");
		email = input.nextLine();
		System.out.println("Enter your password");
		password = input.nextLine();
		input.close();
	}
	
	public void insertUserData() throws SQLException, Exception {
		//we open the database connection
		DbConnection dbconnection = new DbConnection("jdbc:mysql://127.0.0.1:3306/db","test","testforjava");
		Connection con = dbconnection.getConnection();
		String sql = "INSERT INTO users VALUES(?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,username);
		stmt.setString(2,password);
		stmt.setString(3,email);
		stmt.executeUpdate();
		System.out.println("Records inserted successfully");
		DbConnection.closeConnection(con, stmt);
	}
}
