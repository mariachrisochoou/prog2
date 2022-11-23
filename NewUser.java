import java.sql.Connection; //imports class Connection to establish the connection with mysql database
import java.sql.PreparedStatement; //imports interface PreparedStatement that helps execute an sql query with parameters
import java.util.Scanner; //imports class Scanner from java library for interaction with the user

public class NewUser {
	private String username; //instance variable username that stores the username of the user who wants to sign up
	private String password; //instance variable password that stores the password of the user who wants to sign up
	private String email; //instance variable email that stores the email of the user who wants to sign up
	
	public void getUserDetails() {
		Scanner input = new Scanner(System.in); //create odject input to get user details
		System.out.println("Enter your username");
		username = input.nextLine(); //takes input from the user
		System.out.println("Enter your email");
		email = input.nextLine(); //takes input from the user
		System.out.println("Enter your password");
		password = input.nextLine(); //takes input from the user
		input.close(); //close input using Scanner's method close() to reclaim memory
	}
	
	public void insertUserData() throws Exception {
		//we open the database connection
		DbConnection dbconnection = new DbConnection("jdbc:mysql://127.0.0.1:3306/db","test","testforjava"); /* we create dbconnection object,
		we give as arguments to DbConnection's constructor the url of my local database named db,username = test, password = testforjava 
		(url,username,password may be different depending if you use your own database in mysql) to successfully connect our program with db*/
		Connection con = dbconnection.getConnection(); //starts the connection
		String sql = "INSERT INTO users VALUES(?,?,?)";  /*we store the necessary sql statement in a variable sql of type String 
        and with the ? are the parameters that will receive a value in lines 31,32,33 */ 
		PreparedStatement stmt = con.prepareStatement(sql); /*we create an object stmt and as argument the sql statement 
		which gives the ability to call the method setString in order to give to each parameter a value */
		stmt.setString(1,username); //by calling method setString on object stmt we give the 1st parameter the value of variable username
		stmt.setString(2,password); //by calling method setString on object stmt we give the 2nd parameter the value of variable password 
		stmt.setString(3,email); //by calling method setString on object stmt we give the 3rd parameter the value of variable email
		stmt.executeUpdate(); //executes the sql statement INSERT INTO..VALUES()
		System.out.println("Records inserted successfully");
		DbConnection.closeConnection(con, stmt); //closes connection with the database
	}
}
