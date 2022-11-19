import java.sql.Connection; //imports class Connection to establish the connection with mysql database 
import java.sql.PreparedStatement; //imports interface PreparedStatement that helps execute an sql query with parameters
import java.sql.ResultSet;  //imports interface ResultSet that allows to keep the results of sql queries 
import java.util.Scanner; //imports class Scanner from java library  

public class Message {
	private String sender; //instance variable sender that stores the username of the user who sends a message
	private String recipient; //instance variable recipient that stores the username of the user who will receive the message
	private String message; //instance variable message that stores the full message that is about to be sent
	
	public void getMessageDetails() {
		Scanner sc = new Scanner(System.in); //creates object sc type Scanner to get the message details from the user
		System.out.println("Give your username");
		sender = sc.nextLine(); //takes input from the user
		System.out.println("To whom do you want to send a message?");
		recipient = sc.nextLine(); //takes input from the user
		System.out.println("Write the message");
		message = sc.nextLine();
		sc.close(); //close sc using Scanner's method close() to reclaim memory
	}
	
	public void insertMessageDetails() throws Exception {
		//we open the database connection in lines 24,25
		DbConnection dbconnection = new DbConnection("jdbc:mysql://127.0.0.1:3306/db","test","testforjava"); /* we create dbconnection object
		we give as arguments to DbConnection's constructor the url of my local database named db,username = test, password = testforjava 
		(url,username,password may be different depending if you use your own database in mysql) to successfully connect our program with db*/
		Connection con = dbconnection.getConnection();
		String sql = "INSERT INTO messages VALUES(?,?,?)";  /*we store the necessary sql statement in a variable sql of type String 
        and with the ? are the parameters that will receive a value in lines 29,30,31 */ 
		PreparedStatement stmt = con.prepareStatement(sql); /*we create an object stmt and as argument the sql statement 
		which gives the ability to call the method setString in order to give to each parameter a value */
		stmt.setString(1,sender); //by calling method setString on object stmt we give the 1st parameter the value of variable sender
		stmt.setString(2,recipient); //by calling method setString on object stmt we give the 2nd parameter the value of variable recipient
		stmt.setString(3,message); //by calling method setString on object stmt we give the 3rd parameter the value of variable message
		stmt.executeUpdate(); //executes the sql statement INSERT INTO..VALUES()
		System.out.println("Records inserted successfully");
		DbConnection.closeConnection(con, stmt);  //closes connection with the database
	}
	
	public void searchMessage(String userName) throws Exception {
		//we open the database connection 
		DbConnection dbconnection = new DbConnection("jdbc:mysql://127.0.0.1:3306/db","test","testforjava"); //explanation in lines 25,26
		Connection con = dbconnection.getConnection();
		String sql = "SELECT sender,message FROM messages WHERE recipient =? "; /*we store the sql query SELECT FROM WHERE in a 
		String variable sql and we have one parameter */
				
		PreparedStatement ps = con.prepareStatement(sql); //same as line 30
		ps.setString(1,userName); //by calling method setString on object stmt we give the parameter the value of variable userName
		ResultSet rs = ps.executeQuery(); /*creates rs object that contains the rows that satisfy the conditions of the query we execute 
		with method executeQuery() */
				
		while (rs.next()) { //next() method moves cursor forward one row from its current position
			String mensaje = rs.getString("message"); //with getString method we get the content of column message and store it in variable mensaje
			String sentby = rs.getString("sender"); //with getString method we get the content of column sender and store it in variable sentby 
			if (mensaje != null) { 
				System.out.println(sentby + " sent you a new message: " + mensaje); //if there is a message prints the sender followed by the  message
			} else {
				System.out.println("You don't have a message"); //if there is no message for this user
			}
		}
		   
	}
}
