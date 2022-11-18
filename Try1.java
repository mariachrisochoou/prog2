import java.util.Scanner;
public class Try1 {

	public static void main(String[] args) {
		int ans;
		DbFunctions dbf = new DbFunctions();
		InsertByUser ibu = new InsertByUser();
		Scanner input = new Scanner(System.in); 
		
		try {
			//we call method that searches the database to check if the user exists 
			ibu.getUserDetails(); // if user is not signed up
			dbf.insertUserDetails(ibu.username,ibu.password,ibu.email); //
			//if user is signed up we skip the above 2 lines
			
			System.out.println("Do you want to send a message? Answer 1 for YES or 2 for NO");
			ans = input.nextInt();
			
			if (ans == 1) {
				ibu.getMessageDetails();
				dbf.insertMessageDetails(ibu.sender,ibu.recipient,ibu.message);
			}
			
			dbf.searchMessage(ibu.username);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} 
		
	}

}
