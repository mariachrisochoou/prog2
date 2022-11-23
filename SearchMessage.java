import java.util.Scanner;  //imports class Scanner from java library for interaction with the user

public class SearchMessage { 
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in); //creates object input type Scanner
		System.out.println("Write your username"); //verify who is the user
		Message mess = new Message(); //creates object mess of class Message to call method searchMessage() in line 11
		String username = input.nextLine(); 
		input.close(); //close input using Scanner's method close() to reclaim memory
		try {
			mess.searchMessage(username); //call method searchMessage on object mess
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
