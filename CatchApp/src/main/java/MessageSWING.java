
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/** This class achieves the sending of user's messages, 
 * contains message options and the sending message process.
 * Implements ActionListener interface in order to
 * complete the process of sending a message.
 * 
 *  @authors Ornela Kalogeri
 *  */

public class MessageSWING implements ActionListener {
	
	/*JFrame object*/
	private static JFrame frame1;
	
	/*JPanel objects */
	private static JPanel panel1, panel2;
	
	/*JLabel objects*/
	private static JLabel mes, label1, label2,able, notable;
	
	/*JButton objects*/
	private static JButton button, button1, button2, buttonb,button3;
	
	/*JTextField objects for typing our text*/
	private static JTextField typing, text;
	
	/*Connection object for successful connection with database*/
	private DbConnection conn = new DbConnection();
	
	/* Message object for the texting process*/
	private Message objMes = new Message(conn.connect());
	
	/* ShowMessagesSwing2 object for showing messages process*/
	private ShowMessagesSwing2 objSMS = new ShowMessagesSwing2();
	
	private static String tXt,receiver,sender;
	
	private String nameOfSender = AppIntro.getName();

	/* Create frame for our application*/
	public static void createFrame() {
		frame1 = new JFrame();
		frame1.setSize(500,500);
		frame1.setBounds(400,100,700,700);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/* Create panel for out application*/
	public static void createPanel() {
		panel1 = new JPanel();
		frame1.add(panel1);
		panel1.setLayout(null);
		panel1.setBackground(Color.pink);
	}
	
	/* Show to our users their message options*
	 * Options for texting, showing messages or menu*/
	public static void messageOptions() {
		createFrame();
		createPanel();		

		label1 = new JLabel(" How would you like to proceed? ");
		label1.setBounds(200,20,300,25);
		label1.setFont(new Font("Cambria", Font.PLAIN,20));
		label1.setBackground(Color.black);
		label1.setForeground(Color.black);
		panel1.add(label1);
		
		button1 = new JButton("Chat with your crush");
		button1.setBounds(100,100,150,40);
		button1.addActionListener(new MessageSWING());
		button1.setBackground(Color.red);
		panel1.add(button1);

		button2 = new JButton("Show new messages");
		button2.setBounds(380,100,160,40);
		button2.addActionListener(new MessageSWING());
		button2.setBackground(Color.red);
		panel1.add(button2);
			 
		button3= new JButton("Back to menu");
		button3.setBounds(250,300,150,40);
		button3.addActionListener(new MessageSWING());
		button3.setBackground(Color.red);
		panel1.add(button3);
			
		frame1.setVisible(true);
	}
   /* Complete the texting process of our users*
    * Type recipient and message*/
	public static void sendMessageOption() {
		        
		panel2 = new JPanel();
		frame1.add(panel2);
		panel2.setLayout(null);
		panel2.setBackground(Color.pink);
				

		label2 = new JLabel("Send a love letter ♡ to:");
		label2.setBounds(50,100,200,25);
		panel2.add(label2);

		text = new JTextField(80);
		text.setBounds(200, 100, 200, 25);
		panel2.add(text);

		mes = new JLabel("Write your love letter!");
		mes.setBounds(50,150,200,25);
		panel2.add(mes);

		typing = new JTextField(100);
		typing.setBounds(200,150,200,25);
		panel2.add(typing);

		button = new JButton("Send");
		button.setBounds(180,250,150,40);
		button.addActionListener(new MessageSWING());
		button.setBackground(Color.red);
		panel2.add(button);
		
		buttonb = new JButton("Back");
		buttonb.setBounds(380,250,80,40);
		buttonb.addActionListener(new MessageSWING());
		buttonb.setBackground(Color.red);
		panel2.add(buttonb);
		

		frame1.setVisible(true);

	}
	/* Overridden method for the ActionListener interface
	 * Activate the buttons
	 */
	public void actionPerformed(ActionEvent e) {
		
		boolean fl = false;
				
		if (e.getSource() == button1) {
			
			panel1.setVisible(false);
			frame1.setVisible(false);
			sendMessageOption();
		
		} else if (e.getSource() == button2){
					
			panel1.setVisible(false);
			frame1.setVisible(false);
			
			if (objMes.searchSender(AppIntro.getName()).size() == 0) {  //if there are no senders
				ShowMessagesSwing2.createFrame();
				ShowMessagesSwing2.noMessages();
			} else {
				ShowMessagesSwing2.createFrame();
				objSMS.start();
				frame1.setVisible(false);
			}

		} else if (e.getSource() == button) {
					
			tXt = typing.getText();
			receiver = text.getText();
			sender = nameOfSender;
		
			fl = objMes.checkExistence(receiver);
	
			if (fl == true) {
				objMes.insertMessageData(sender,receiver,tXt);
				ableToSend();
			} else {
				notAbleToSend();
			}
					
			panel1.setVisible(false);
		}
				
		if (e.getSource() == buttonb) {
			frame1.setVisible(false);
			messageOptions(); 	
		}
				
		if(e.getSource()== button3) {
			frame1.setVisible(false);
			Menu.createMenu();
		}
				
	}
			
			
	/* Process of texting is complete
	 * Message is successfully sent to other user */
	public void ableToSend() {
		able = new JLabel("");
	    able.setBounds(150,300,300,25); 
	    panel2.add(able);
	    able.setText("Love letter is successfully sent!");
	    	
	    frame1.setVisible(true);
	}
	    /* Process of texting has failed*
	     * Recipient doesnt exist*/
	public void notAbleToSend() {
		notable = new JLabel("");
	    notable.setBounds(150,300,250,25);
	    panel2.add(notable);
	    notable.setText("Cannot find your lovebird. Try again");
	    	
	    frame1.setVisible(true);
	    	
	}
			
}


