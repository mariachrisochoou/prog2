import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class User2 {

	private Connection conn;
	
	
	

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


}
