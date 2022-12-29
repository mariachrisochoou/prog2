import java.awt.BorderLayout;
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

	private static JPanel p1,p3,p2;
	private static JFrame frame;
	private static JLabel label,label2;
	private static JButton[] b;
	private static JButton back1,back2;
	private static Message m = new Message(Connect.connect());
	private static ArrayList<String> senders = new ArrayList<String>();
	private static ShowMessagesSwing2 sms = new ShowMessagesSwing2(); 
		
	public static void createFrame() {
		frame = new JFrame();
		frame.setSize(350,350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("My messages");
	}
		
	public static void showMess2(String senderr) {
		p3 = new JPanel();
		p3.setLayout(null);
		frame.add(p3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			
		ArrayList<String> messagess = new ArrayList<String>();
	    messagess = m.showMessages(senderr);
	    String[] data = new String[messagess.size()];
	    for (int i = 0; i < data.length; i++) {
	        data[i] = messagess.get(i);
	    }
	        
	    final DefaultListModel model = new DefaultListModel();
	    for (int i = 0, n = data.length; i < n; i++) {
	    	model.addElement(data[i]);
	    }
	        
	    JList jlist = new JList (model);
	    JScrollPane scrollPane1 = new JScrollPane(jlist);
	    frame.add(scrollPane1, BorderLayout.CENTER);
	        
	    back1 = new JButton("Back");
	    back1.addActionListener(sms);
	    p3.add(back1);
	    frame.add(back1, BorderLayout.SOUTH);
	    
	    frame.setVisible(true);
	}
		
	public static boolean checkSenders() {
		try {
			senders = m.searchSender(AppIntro.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		if (senders.size() == 0) { //if there are no senders
			return false;
		} else {
			return true;
		}
	}
		
	public static void start() {
		if (checkSenders() == true) {
			p1 = new JPanel();
			p1.setLayout(null);
			frame.add(p1); 
			
			label = new JLabel("View messages from:");
			label.setBounds(20, 25, 180, 25);
			p1.add(label);
			
			try {
				senders = m.searchSender(AppIntro.getName());  
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			b = new JButton[senders.size()];
			int y = 50;
			for (int i = 0; i < b.length; i++) {
				b[i] = new JButton(senders.get(i));
				b[i].setBounds(20,y, 150, 25); 
				b[i].addActionListener(sms);
				p1.add(b[i]);
				y+=30;
			}
			
			frame.setVisible(true);
		}
	}
		
	@Override
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
	}
	
	public static void noMessages() {
		p2 = new JPanel();
		frame.add(p2);
		p2.setLayout(null);
		 
		back2 = new JButton("Back");
		back2.setBounds(150, 130, 120, 25);
		back2.addActionListener(sms);
		p2.add(back2);
		
		label2 = new JLabel("You have no messages");
		label2.setBounds(60, 40, 180, 25);
		p2.add(label2);
		frame.setVisible(true);
	}

}	
