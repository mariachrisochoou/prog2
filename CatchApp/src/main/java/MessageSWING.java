import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class MessageSWING implements ActionListener {
	private static JFrame frame1, frame2;
	private static JPanel panel1, panel2;
	private static JLabel mes, label1, label2,able, notable;
	private static JButton button, button1, button2, buttonb;
	private static JTextField typing, text;
	Message objMes = new Message(Connect.connect());
	private static String tXt,receiver,sender;

	AppIntro obj = new AppIntro();
	String nameOfSender = obj.getNam();


    /* public static void main(String[] args) {
	    messageOptions();
    }*/

	 public static void messageOptions() {
		 
		 
	     frame1 = new JFrame();
		 frame1.setSize(400,250);
		 frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			

		 panel1 = new JPanel();
		 frame1.add(panel1);
		 panel1.setLayout(null);


	     label1 = new JLabel(" How would you like to proceed? ");
		 label1.setBounds(60,20,250,25);
		 panel1.add(label1);

		 button1 = new JButton("Text with a friend");
		 button1.setBounds(10,80,150,25);
		 button1.addActionListener(new MessageSWING());
		 panel1.add(button1);
			
		

		 button2 = new JButton("Show new messages");
		 button2.setBounds(160,80,160,25);
		 button2.addActionListener(new MessageSWING());
		 panel1.add(button2);
		
		 frame1.setVisible(true);

		 }


        public static void sendMessageOption() {
			frame2 = new JFrame();
			frame2.setSize(400,250);
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	        
			panel2 = new JPanel();
			frame2.add(panel2);
			panel2.setLayout(null);
			

			label2 = new JLabel("Send message to: ");
			label2.setBounds(10,20,160,25);
			panel2.add(label2);

			text = new JTextField(80);
			text.setBounds(150, 20, 165, 25);
			panel2.add(text);

			mes = new JLabel("Type your message!");
			mes.setBounds(10,50,200,25);
			panel2.add(mes);

			typing = new JTextField(100);
			typing.setBounds(150,50,165,25);
			panel2.add(typing);

			button = new JButton("Send");
			button.setBounds(10,80,80,25);
			button.addActionListener(new MessageSWING());
			panel2.add(button);

			buttonb = new JButton("Back");
			buttonb.setBounds(250,80,80,25);
			buttonb.addActionListener(new MessageSWING());
			panel2.add(buttonb);

			frame2.setVisible(true);

		}

		/*public void showMessagE() {

		}*/


		@Override
	    public void actionPerformed(ActionEvent e) {
			
			//boolean done;
			boolean fl=false;
			
			if (e.getSource() == button1) {
				panel1.setVisible(false);
				frame1.setVisible(false);
				sendMessageOption();
				
			} else if (e.getSource() == button2){
				panel1.setVisible(false);
				frame1.setVisible(false);
				//showMessagE();//
			} else if (e.getSource() == button) {
				tXt = typing.getText();
				receiver = text.getText();
				sender = nameOfSender;
			 
			
				
				
				try {
					fl = objMes.checkExistence(receiver);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
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
				frame2.setVisible(false);
				messageOptions(); 	
			}
			
			}
		
		
	   
        public void ableToSend() {
    
    	    able = new JLabel("");
    	    able.setBounds(10,130,200,25);
    	    panel2.add(able);
    	    
    	    able.setText("Message is successfully sent!");
    	
    	    frame2.setVisible(true);
    }
    
        public void notAbleToSend() {
    	
    	    notable = new JLabel("");
    	    notable.setBounds(10,130,200,25);
    	    panel2.add(notable);
    	    
    	    notable.setText("Can not find this user. Try again");
    	
    	    frame2.setVisible(true);
    	
    }
		

}