import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User2 {
	
	private Connection conn;
	
	private static Message m = new Message(Connect.connect());

	
	public User2(Connection conn) {
		this.conn = conn;
	} 
	
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
	
	
	public boolean checkPassword(String u, String p) throws SQLException, Exception{
		
		String sql = "SELECT username, password FROM User";
		boolean f1 = false, f2 = false;
		
		try {
	    	Statement ps = conn.createStatement();
	    	ResultSet rs = ps.executeQuery(sql);	    	
	    	while (rs.next() && f1 == false) {	
	    		f1 = rs.getString("username").equals(u);
	    		f2 = rs.getString("password").equals(p);
	    	}
	    	
	    } catch (SQLException e) {
	    	System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return f1 & f2; 
		
	}
	
	public boolean logUser(String u, String pw) {
		
	    boolean flag = false;
	    
	    try {
	    	if (checkPassword(u,pw)) {
	    		flag = true;
	    	}
	  
	    } catch (Exception e) {
	    	e.getMessage();
	    }
	    return flag;
	  }


	 
}