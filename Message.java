import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet;  
import java.util.Scanner; 

public class Message {
	private String sender; 
	private String recipient; 
	private String message; 
	
	
	
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
	
	
}
