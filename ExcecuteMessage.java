public class ExcecuteMessage {
	
	public static void main(String [] args) {

		//create a new Message object
		Message mes = new Message();
		mes.getMessageDetails();
		
		// works in try, catch so there is no kind of exception
		try {

			// uses the method that requires from the user to give out message details.
			mes.insertMessageDetails();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
