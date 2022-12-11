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

	private static JPanel p1,p3;
	private static JFrame frame;
	private static JLabel label = new JLabel();
	private static JButton[] b;
	private static JButton jb;
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
		frame.add(p3); //
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
        
        JList jlist = new JList(model);
        JScrollPane scrollPane1 = new JScrollPane(jlist);
        frame.add(scrollPane1, BorderLayout.CENTER);
        
        jb = new JButton("Return");
        jb.addActionListener(sms);
      
        frame.add(jb, BorderLayout.SOUTH);
		p3.setVisible(true); //
        frame.setVisible(true);
    }
	
	public static void start() {
		p1 = new JPanel();
		p1.setLayout(null);
		frame.add(p1); 
		label = new JLabel("View messages from:");
		label.setBounds(20, 25, 180, 25);
		p1.add(label);
		try {
			senders = m.searchSender("eleni");  //as argument will be the username of the connected user
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int a = 0; a < b.length; a++) {
			if (e.getSource() == b[a]) {
				p1.setVisible(false);
				showMess2(senders.get(a));
				if (e.getSource() == jb) {
				    p3.setVisible(false);
				    p1.setVisible(true);
				    a = 0;
				} 
			}
		}
	}
	
	public static void main(String [] args) {
		createFrame();
		start();
	}
}
