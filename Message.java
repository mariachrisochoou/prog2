import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Message {
	
	private Connection conn;
	boolean done;
	
	
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
			
		} catch (Exception e) {
		
		}
		
	}
	
	
	
	
	
	
	  public boolean checkExistence(String recipient ) throws SQLException, Exception {
	      String sql = "SELECT username FROM User ";
	      boolean fl = false;
		
		try {
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next() && fl== false) {
				
				 fl=rs.getString("username").equals(recipient); 
					
			     
			}
				
			
				
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
		return fl;
			
			
			
	}
	
	
	/*public void showMessages() throws SQLException, Exception {
		
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
	}*/
	
}
 