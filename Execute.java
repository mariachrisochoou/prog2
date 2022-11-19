
public class Execute {
	public static void main(String [] args) {
		 NewUser u = new NewUser();
		 u.getUserDetails();
		 
		 try {
			u.insertUserData();
			 
			} catch (Exception e) {
					System.out.println(e.getMessage());
				}
		 }
}
			 
		
