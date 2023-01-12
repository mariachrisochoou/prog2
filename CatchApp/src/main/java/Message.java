import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * This class connects with the Messages table
 * and completes users' requests.
 * @author Dimitra Telatinidoy, Ornela Kalogeri.
 *
 */
public class Message {
	
	/* Connection object*/
	private Connection conn;
    
	/*Constructor of Message class
	 * initiates conn object
	 */
	public Message(Connection conn) {
		this.conn = conn;
	}
	
	/* Insert users' information into the message table of SQLITE Database*/
	public void insertMessageData(String sender, String recipient, String message) {
		
		String sql = "INSERT INTO Messages VALUES(?,?,?);";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sender);
			ps.setString(2, message);
			ps.setString(3, recipient);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL");
		} catch (Exception e) {
			System.out.println("Exception!");
		}
	}
	
	/*Check if user exists in order to send a message*/
	public boolean checkExistence(String recipient) {
		
		String sql = "SELECT username FROM User ";
	    boolean fl = false;
		
	    try {
	    	Statement ps = conn.createStatement();
	    	ResultSet rs = ps.executeQuery(sql);
	    	while (rs.next() && fl== false) {
	    		fl=rs.getString("username").equals(recipient); 	     
	    	}
	    } catch (SQLException e) {
	    	System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return fl;	
	}
	
	/* Take users' new messages from SQLITE Database in order
	 * to show them to our application.
	 */
	public ArrayList<String> showMessages(String sendby, String recipient) {
		
		ArrayList<String> messages = new ArrayList<String>();
		String sql = "SELECT message FROM Messages WHERE (recipient=? AND sender=?) "; 
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(2, sendby);
			ps.setString(1, recipient);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				messages.add(rs.getString("message"));
			}
		} catch(Exception e) {
			e.getMessage();
		}
		
		return messages;
	}
	
	/* Take the names of the senders from SQLITE Database 
	 * and show them to our application*
	 */
	public ArrayList<String> searchSender(String recipient){
		
		ArrayList<String> senders = new ArrayList<String>();
		String sql = "SELECT DISTINCT sender FROM Messages WHERE recipient=?";
	       
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, recipient);
	        ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				senders.add(rs.getString("sender"));			
			}
			
		} catch(Exception e) {
	        	e.printStackTrace();
	    }
		
		return senders;
	}
		
}
	
