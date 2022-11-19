
public class Execute {
	public static void main(String [] args) {

		//creates a NewUser object
		 NewUser u = new NewUser();
		 u.getUserDetails();
		 
		 // the same as ExecuteMessage
		 try {
			u.insertUserData();
			 
			} catch (Exception e) {
					System.out.println(e.getMessage());
				}
		 }
}
			 
		
