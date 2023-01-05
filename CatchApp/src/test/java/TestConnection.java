import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

public class TestConnection {
	
	private DbConnection conn = new DbConnection();
	private Message message = new Message(conn.connect());
	private User2 user = new User2(conn.connect());

	@Test
	public void testCheckExistence() {
		
		String recipient = "eleni";
		//The user 'eleni' is already written in the system
	
		assertSame(true, message.checkExistence(recipient));
		
	}
	
	@Test
	public void testShowMessages() {
		
		ArrayList<String> array = new ArrayList<String>();
		array.add("Hi there");
		String recipient = "mchrisochoou";
		String sendby = "ornela";
		assertEquals(array, message.showMessages(sendby, recipient));
		
	}
	
	@Test
	public void testSearchSender() {
		
		ArrayList<String> array = new ArrayList<String>();
		array.add("grigorios");
		array.add("giannis");
		String recipient = "eleni";
		assertEquals(array, message.searchSender(recipient));

	}
	
	@Test
	public void testCheckPassword() {
		String username = "eleni";
		String password = "1234";
		
		//The username and the password are already written in the database
		assertEquals(true, user.checkPassword(username, password));
	}
	
	@Test
	public void testLogUser() {
		String username = "eleni";
		String password = "1234";
		
		assertEquals(true, user.logUser(username, password));
	}

}
