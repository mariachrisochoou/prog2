import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet;  
import java.util.Scanner; 

public class Message {
	private String sender; 
	private String recipient; 
	private String message; 
	
	public Message(String s, String r, String m) {
		sender = s;
		recipient = r;
		message = m;
	}	
	

	//Gets info from user to send a message

	public void insertMessageDetails() throws Exception {

		DbConnection dbconnection = new DbConnection("jdbc:mysql://127.0.0.1:3306/db","test","testforjava"); 
		Connection con = dbconnection.getConnection();
		String sql = "INSERT INTO messages VALUES(?,?,?)";  #

		PreparedStatement stmt = con.prepareStatement(sql); 

		stmt.setString(1,sender); 
		stmt.setString(2,recipient); 
		stmt.setString(3,message); 
		stmt.executeUpdate(); 
		System.out.println("Records inserted successfully");
		DbConnection.closeConnection(con, stmt); 
	}


    // Shows the user who sent them messages and what the message was
	
	public void searchMessage(String userName) throws Exception {

		DbConnection dbconnection = new DbConnection("jdbc:mysql://127.0.0.1:3306/db","test","testforjava"); 
		Connection con = dbconnection.getConnection();

		String sql = "SELECT sender,message FROM messages WHERE recipient =? "; 
		PreparedStatement ps = con.prepareStatement(sql); 

		ps.setString(1,userName); 
		ResultSet rs = ps.executeQuery(); 

		while (rs.next()) { 
			String message = rs.getString("message"); 
			String sentby = rs.getString("sender"); 
			if (message != null) {
				System.out.println(sentby + " sent you a new message: " + message); 
			} else {
				System.out.println("You don't have a message"); 
			}
		}

	}
	
	
}
