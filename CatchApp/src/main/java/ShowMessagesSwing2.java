import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ShowMessagesSwing2 implements ActionListener {

	private static JPanel p1, p2, p3;
	private static JFrame frame;
	private static JLabel label, label2;
	private static JButton[] b, like;
	private static JButton back1, back2;
	private DbConnection conn = new DbConnection();
	private Message message = new Message(conn.connect());
	private static ArrayList<String> senders = new ArrayList<String>();
	private static ShowMessagesSwing2 sms = new ShowMessagesSwing2(); 
		
		public static void createFrame() {
			frame = new JFrame();
			frame.setSize(350,350);
			frame.setBounds(400,100,700,700);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("My messages");
	        
		}
		
		public void showMess2(String sender) {
			p3 = new JPanel();
			p3.setLayout(null);
			frame.add(p3); 
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			
			String name = AppIntro.getName();
			ArrayList<String> messages = new ArrayList<String>();
	        messages = message.showMessages(sender, name);
	        
	        String[] data = new String[messages.size()];
	   
	        for (int i = 0; i < data.length; i++) {
	        	data[i] = messages.get(i);
	        }
	        
	        final DefaultListModel model = new DefaultListModel();
	        int y = 5;
	    
	        like = new JButton[data.length];
	        for (int i = 0, n = data.length; i < n; i++) {
	   
	        	
	        	model.addElement(data[i]);
	        	like[i] = new JButton("LIKE");
	        	like[i].setBounds(500,y,100,25);
	        	p3.add(like[i]);
	        	frame.add(like[i]);
	        	y+=30;
	        }

	        
	        JList jlist = new JList(model);
	        jlist.setFont(new Font("Arial", Font.PLAIN,20));
	        JScrollPane scrollPane1 = new JScrollPane(jlist);
	        scrollPane1.setBounds(10,50,300,25);
	        frame.add(scrollPane1, BorderLayout.CENTER);
	        
	        back1 = new JButton("BACK");
		    back1.addActionListener(sms);
		    back1.setBounds(200,350,100,25);
		    
		    frame.add(back1, BorderLayout.SOUTH);
			p3.setVisible(true); 
	        frame.setVisible(true);
	    }
		
		public boolean checkSenders() {
			try {
				senders = message.searchSender(AppIntro.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
				
			if (senders.size() == 0) { 
				return false;
			} else {
				return true;
			}
		}
		
		public void start() {
			
			if (checkSenders() == true) {
				p1 = new JPanel();
				p1.setLayout(null);
				frame.add(p1); 
				
				label = new JLabel("View messages from:");
				label.setFont(new Font("Arial", Font.PLAIN,20));
				label.setBounds(200, 25, 400, 40);
				p1.add(label);
				
				try {
					senders = message.searchSender(AppIntro.getName());  
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				b = new JButton[senders.size()];
				int y = 70;
				for (int i = 0; i < b.length; i++) {
					b[i] = new JButton(senders.get(i));
					b[i].setBounds(230,y, 150, 40); 
					b[i].addActionListener(sms);
					p1.add(b[i]);
					y+=50;
				}
				
				frame.setVisible(true);
			}
		}
			
	
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == back2) {
				p2.setVisible(false);
				frame.setVisible(false);
				MessageSWING.messageOptions();
			}
				
			if (checkSenders() == true) {
				for (int a = 0; a < b.length; a++) {
					if (e.getSource() == b[a]) {
						p1.setVisible(false);
						showMess2(senders.get(a));
						if (e.getSource() == back1) {
							p3.setVisible(false);
							a = 0;
						} 
					}
				}
			}
			
			if (e.getSource() == back1) {
				p3.setVisible(false);
				MessageSWING.messageOptions();
			} 
		}
		
		public static void noMessages() {
			p2 = new JPanel();
			frame.add(p2);
			p2.setLayout(null);
			 
			back2 = new JButton("BACK");
			back2.setBounds(202, 100, 250, 40);
			back2.addActionListener(sms);
			p2.add(back2);
			
			label2 = new JLabel("You have no new messages!");
			label2.setFont(new Font("Arial", Font.PLAIN,20));
			label2.setBounds(200, 40, 400, 40);
			p2.add(label2);
			frame.setVisible(true);
		}

}
	

