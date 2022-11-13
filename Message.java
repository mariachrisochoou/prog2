import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.Statement;

public class Message {
	private String sender;
	private String recipient;
	private String message;
	
	public void getMessageDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Give your username");
		sender = sc.nextLine();
		System.out.println("To whom do you want to send a message?");
		recipient = sc.nextLine();
		System.out.println("Write the message");
		message = sc.nextLine();
		sc.close();
	}
	
	public void insertMessageDetails() throws Exception {
		//we open the database connection
		DbConnection dbconnection = new DbConnection("jdbc:mysql://127.0.0.1:3306/db","test","testforjava");
		Connection con = dbconnection.getConnection();
		String sql = "INSERT INTO messages VALUES(?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,sender);
		stmt.setString(2,recipient);
		stmt.setString(3,message);
		stmt.executeUpdate();
		System.out.println("Records inserted successfully");
		DbConnection.closeConnection(con, stmt);  //closes connection with the database
	}
	
	public void searchMessage(String userName) throws Exception {
		//we open the database connection
				DbConnection dbconnection = new DbConnection("jdbc:mysql://127.0.0.1:3306/db","test","testforjava");
				Connection con = dbconnection.getConnection();
				String sql = "SELECT sender,message FROM messages WHERE recipient =? ";
				PreparedStatement ps = con.prepareStatement(sql);
			    ps.setString(1,userName); //give value to the parameter ?
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					 String mensaje = rs.getString("message");
					 String sentby = rs.getString("sender");
					 if (mensaje != null) { 
					 System.out.println(sentby + " sent you a new message: " + mensaje);
					 } else {
						 System.out.println("You don't have a message");
					 }
				}
			   
	}
}
