import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class MessageSWING implements ActionListener {
	
	private static JFrame frame1;
	private static JPanel panel1, panel2;
	private static JLabel mes, label1, label2,able, notable;
	private static JButton button, button1, button2, buttonb,button3;
	private static JTextField typing, text;
	private static Message objMes = new Message(Connect.connect());
	private static String tXt,receiver,sender;
	private String nameOfSender = AppIntro.getName();

	
	public static void createFrame() {
		frame1 = new JFrame();
		frame1.setSize(500,500);
		frame1.setBounds(400,100,700,700);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void createPanel() {
		panel1 = new JPanel();
		frame1.add(panel1);
		panel1.setLayout(null);
	}
	
	public static void messageOptions() {
		createFrame();
		createPanel();		

		label1 = new JLabel(" How would you like to proceed? ");
		label1.setBounds(200,20,300,25);
		label1.setFont(new Font("Arial", Font.PLAIN,20));
		label1.setBackground(Color.blue);
		label1.setForeground(Color.blue);
		panel1.add(label1);
		
		button1 = new JButton("Text with a friend");
		button1.setBounds(100,100,150,40);
		button1.addActionListener(new MessageSWING());
		panel1.add(button1);

		button2 = new JButton("Show new messages");
		button2.setBounds(380,100,160,40);
		button2.addActionListener(new MessageSWING());
		panel1.add(button2);
			 
		button3= new JButton("Back to menu");
		button3.setBounds(250,300,150,40);
		button3.addActionListener(new MessageSWING());
		panel1.add(button3);
			
		frame1.setVisible(true);
	}

	public static void sendMessageOption() {
		        
		panel2 = new JPanel();
		frame1.add(panel2);
		panel2.setLayout(null);
				

		label2 = new JLabel("Send message to: ");
		label2.setBounds(50,100,200,25);
		panel2.add(label2);

		text = new JTextField(80);
		text.setBounds(200, 100, 200, 25);
		panel2.add(text);

		mes = new JLabel("Type your message!");
		mes.setBounds(50,150,200,25);
		panel2.add(mes);

		typing = new JTextField(100);
		typing.setBounds(200,150,200,25);
		panel2.add(typing);

		button = new JButton("Send");
		button.setBounds(180,250,80,40);
		button.addActionListener(new MessageSWING());
		panel2.add(button);
		
		buttonb = new JButton("Back");
		buttonb.setBounds(380,250,80,40);
		buttonb.addActionListener(new MessageSWING());
		panel2.add(buttonb);

		frame1.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		
		boolean fl = false;
				
		if (e.getSource() == button1) {
			
			panel1.setVisible(false);
			frame1.setVisible(false);
			sendMessageOption();
		
		} else if (e.getSource() == button2){
					
			panel1.setVisible(false);
			frame1.setVisible(false);
			try {
				if (objMes.searchSender(AppIntro.getName()).size() == 0) {  //if there are no senders
					ShowMessagesSwing2.createFrame();
					ShowMessagesSwing2.noMessages();
				} else {
					ShowMessagesSwing2.createFrame();
					ShowMessagesSwing2.start();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		} else if (e.getSource() == button) {
					
			tXt = typing.getText();
			receiver = text.getText();
			sender = nameOfSender;
			try {
				fl = objMes.checkExistence(receiver);
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
					
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
			
			
		   
	public void ableToSend() {
		able = new JLabel("");
	    able.setBounds(150,300,200,25); 
	    panel2.add(able);
	    able.setText("Message is successfully sent!");
	    	
	    frame1.setVisible(true);
	}
	    
	public void notAbleToSend() {
		notable = new JLabel("");
	    notable.setBounds(150,300,200,25);
	    panel2.add(notable);
	    notable.setText("Can not find this user. Try again");
	    	
	    frame1.setVisible(true);
	    	
	}
			
}


