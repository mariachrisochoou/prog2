import java.sql.Connection; //imports class Connection to establish the connection with mysql database
import java.sql.PreparedStatement; //imports interface PreparedStatement that helps execute an sql query with parameters
import java.util.Scanner; //imports class Scanner from java library for interaction with the user
import java.util.Calendar; //imports class Calendar from java library for user's date of birth
import java.util.ArrayList; 

	public class User {
		
	    private String username; //instance variable username that stores the username of the user who wants to sign up
	    private String password; //instance variable password that stores the password of the user who wants to sign up
	    private Calendar dateOfBirth; //instance variable dateOfBirth that stores the date of birth of the user who wants to sign up
	    private String email; //instance variable email that stores the email of the user who wants to sign up
	    private static ArrayList<String> users = new ArrayList<String> ();
	    
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

