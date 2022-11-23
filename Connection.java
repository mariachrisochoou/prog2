import java.sql.PreparedStatement; 
import java.sql.ResultSet;  

public class Connection {
		
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
