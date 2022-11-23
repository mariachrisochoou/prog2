import java.sql.PreparedStatement; //imports interface PreparedStatement that helps execute an sql query with parameters
import java.sql.ResultSet;  //imports interface ResultSet that allows to keep the results of sql queries
public class Connection {
	public void searchMessage(String userName) throws Exception {
		//we open the database connection
		DbConnection dbconnection = new DbConnection("jdbc:mysql://127.0.0.1:3306/db","test","testforjava"); /* we create dbconnection object
		we give as arguments to DbConnection's constructor the url of my local database named db,username = test, password = testforjava
		(url,username,password may be different depending if you use your own database in mysql) to successfully connect our program with db*/
		Connection con = dbconnection.getConnection();
		String sql = "SELECT sender,message FROM messages WHERE recipient =? "; /*we store the sql query SELECT FROM WHERE in a
		String variable sql and we have one parameter */

		PreparedStatement ps = con.prepareStatement(sql); /*we create an object ps and as argument the sql statement
		which gives the ability to call the method setString in order to give to each parameter a value */
		ps.setString(1,userName); //by calling method setString on object ps we give the parameter the value of variable userName
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
