import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.util.Scanner; 
import java.util.Calendar; 
import java.util.ArrayList; 

	public class User {
		
	    private String username; 
	    private String password; 
	    private Calendar dateOfBirth; 
	    private String email; 
	    
	    public User(String name, String pw, Calendar dof, String mail) {
	    	username = name;
	    	password = pw;
	    	dateOfBirth = dof;
	    	email = mail;
	    }
	    
		
	    public void insertUserData() throws Exception {

			DbConnection dbconnection = new DbConnection("jdbc:mysql://127.0.0.1:3306/db","test","testforjava"); 
			Connection con = dbconnection.getConnection(); 

			String sql = "INSERT INTO users VALUES(?,?,?,?)"; 

			PreparedStatement stmt = con.prepareStatement(sql); 
			stmt.setString(1,username); 
			stmt.setString(2,password); 
			stmt.setString(3,email);
			//stmt.setCalendar(4,dateOfBirth); 

			stmt.executeUpdate(); 
			System.out.println("You have registered successfully!");
			DbConnection.closeConnection(con, stmt); //closes connection with the database
	}
	    
	}

