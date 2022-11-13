public class ExcecuteMessage {
	
	public static void main(String [] args) {
		Message mes = new Message();
		mes.getMessageDetails();
		
		try {
			mes.insertMessageDetails();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
