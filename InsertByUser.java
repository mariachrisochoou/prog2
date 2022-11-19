import java.util.Scanner;
public class InsertByUser {
	String username;
	String password;
	String email;
	String sender;
	String recipient;
	String message;
	Scanner input = new Scanner(System.in); //odject input for getting user details
	public void getUserDetails() {
		
		System.out.println("Enter your username");
		username = input.nextLine();
		System.out.println("Enter your email");
		email = input.nextLine();
		System.out.println("Enter your password");
		password = input.nextLine();
		
	}
	public String getUsername() {
		return username;
	}
	public void getMessageDetails() {
		
		sender = getUsername();
		System.out.println("To whom do you want to send a message?");
		recipient = input.nextLine();
		System.out.println("Write the message");
		message = input.nextLine();
		
	}
}
