import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Message {
	
	private Connection conn;

	public Message(Connection conn) {
		this.conn = conn;
	}
	
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
	
