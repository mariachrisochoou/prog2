import java.util.Scanner;

public class SearchMessage {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Write your username");
		Message mess = new Message();
		String username = input.nextLine();
		input.close();
		try {
			
			mess.searchMessage(username);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
