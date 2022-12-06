import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Message {
	
	private Connection conn;
	private Scanner in = new Scanner(System.in);
	
	public Message(Connection conn) {
		this.conn = conn;
	}
	
	public void insertMessageData(String sender, String recipient, String message) {
		
		String sql = "INSERT INTO Messages VALUES(?,?,?);";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println("Entered");
			ps.setString(1, sender);
			ps.setString(2, message);
			ps.setString(3, recipient);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL!");
		} catch (Exception e) {
			System.out.println("Exception!");
		}
	}
	
	public void getMessageDetails() throws SQLException, Exception {

		String s, r, m;
		System.out.println("Enter your username");
		s = in.nextLine();

		System.out.println("Enter the username of the person you want to send the message:");
		r = in.nextLine();

		System.out.println("Enter the message");
		m = in.nextLine();

		insertMessageData(s, r, m);

    }
	
	public void showMessages() throws SQLException, Exception {
		
		String sql = "SELECT sender, message FROM Messages";
		
		try {
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				System.out.println("Sender:" + rs.getString("sender") + " Message:" + rs.getString("message") );
			}
		} catch (SQLException e) {
			System.out.println("SQL!");
		} catch (Exception e) {
			System.out.println("Exception!");
		}
	}
	
}
