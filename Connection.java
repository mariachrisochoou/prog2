import java.sql.PreparedStatement; 
import java.sql.ResultSet;  

public class Connection {
  
    public void executeMessage() {
        Message mes = new Message();
        mes.getMessageDetails();
    
      try {
          mes.insertMessageDetails();
      } catch (Exception e) {
          System.out.println(e.getMessage());
      }  
    }

	public void searchMessage(String userName) throws Exception {

		DbConnection dbconnection = new DbConnection("jdbc:mysql://127.0.0.1:3306/db","test","testforjava"); 
		Connection con = dbconnection.getConnection();

		String sql = "SELECT sender,message FROM messages WHERE recipient =? "; 
		PreparedStatement ps = con.prepareStatement(sql); 

		ps.setString(1,userName); 
		ResultSet rs = ps.executeQuery(); 

		while (rs.next()) { 
			String message = rs.getString("message"); 
			String sentby = rs.getString("sender"); 
			if (message != null) {
				System.out.println(sentby + " sent you a new message: " + message); 
			} else {
				System.out.println("You don't have a message"); 
			}
		}

	}
		
	    public void getUserDetails() {

			Scanner input = new Scanner(System.in); 

			System.out.println("Enter your username");
			username = input.nextLine(); 

			System.out.println("Enter your email");
			email = input.nextLine(); 

			System.out.println("Enter your date of birth");
			//dateOfBirth = input.nextWHAT(); 

			System.out.println("Enter your password");
			password = input.nextLine(); 

			input.close(); 
	    }

		public void getMessageDetails() {

			Scanner sc = new Scanner(System.in); 

			System.out.println("Give your username");
			sender = sc.nextLine(); 

			System.out.println("To whom do you want to send a message?");
			recipient = sc.nextLine(); 

			System.out.println("Write the message");
			message = sc.nextLine();
			sc.close(); 
	}

}
