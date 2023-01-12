import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


 /**
 * This class connects with the Users table
 * and completes users' requests.
 * @author Maria Chrisochoou, Xristina Siakavara.
 *
 */
public class User2 {
	
	/* Connection object*/
	private Connection conn;
	
	/*Constructor of User2 class
	 * Initiates conn object
	 */
	public User2(Connection conn) {
		this.conn = conn;
	} 
	
	/* Insert users' information into the user table of SQLITE Database*/
	public boolean insertData(String username, String password, String email, String dob) {
		
		String sql = "INSERT INTO User VALUES(?,?,?,?);";
		boolean flag;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, dob);
			ps.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			flag = false;
		} catch (Exception e) {
			flag = false;
		}
		
		return flag;
	}
	
	/* Check if users password is correct in order to connect
	 * with profile
	 */
	public boolean checkPassword(String username, String password){
		
		String sql = "SELECT username, password FROM User";
		boolean f1 = false, f2 = false;
		
		try {
	    	Statement ps = conn.createStatement();
	    	ResultSet rs = ps.executeQuery(sql);	    	
	    	while (rs.next() && f1 == false) {	
	    		f1 = rs.getString("username").equals(username);
	    		f2 = rs.getString("password").equals(password);
	    	}
	    	
	    } catch (SQLException e) {
	    	System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return f1 & f2; 
		
	}
	
	/* Log in is successfully completed.*/
	public boolean logUser(String username, String password) {
		
	    boolean flag = false;
	    
	    try {
	    	if (checkPassword(username, password)) {
	    		flag = true;
	    	}
	    } catch (Exception e) {
	    	System.out.println(e.getMessage());
	    }
	    
	    return flag;
	    
	}


	 
}