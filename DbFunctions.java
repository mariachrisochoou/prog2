import java.sql.*;
public class DbFunctions {
	
	public void insertUserDetails(String username,String password,String email) throws Exception {  //inserts all user data to mysql database
		//we open the database connection
		DataBaseConnection dbconnection = new DataBaseConnection("jdbc:mysql://127.0.0.1:3306/db","test","testforjava");
		Connection con = dbconnection.getConnection();
		
		String sql = "INSERT INTO users VALUES(?,?,?)"; //define sql command
		PreparedStatement stmt = con.prepareStatement(sql); //creates stmt odject with type PreparedStatement
		stmt.setString(1,username); //gives a value to the 1st ? parameter
		stmt.setString(2,password); //gives a value to the 2nd ? parameter
		stmt.setString(3,email); //gives a value to the 3rd ? parameter
		stmt.executeUpdate(); // executes the sql command
		System.out.println("Records inserted successfully"); // prints suitable message
	}
	
	public void insertMessageDetails(String sender,String recipient,String message) throws Exception {
		//we open the database connection 
		DataBaseConnection dbconnection = new DataBaseConnection("jdbc:mysql://127.0.0.1:3306/db","test","testforjava");  //url & credentials as a parameter for user test in mysql
		Connection con = dbconnection.getConnection();
		String sql = "INSERT INTO messages VALUES(?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,sender);
		stmt.setString(2,recipient);
		stmt.setString(3,message);
		stmt.executeUpdate();
		System.out.println("Records inserted successfully");
		DataBaseConnection.closeConnection(con, stmt);  //closes connection with the database
	}
	
	public void searchMessage(String userName) throws Exception {
		//we open the database connection
		        DataBaseConnection dbconnection = new DataBaseConnection("jdbc:mysql://127.0.0.1:3306/db","test","testforjava");
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
