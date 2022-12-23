import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu implements ActionListener {

	private static JFrame frame;
	private static JLabel label;
	private static JPanel panel;
	private static JButton b1, b2, b3; 
	private static ImageIcon image = new ImageIcon("logo.png");
	
	public static void createFrame() {
		frame = new JFrame(); 
		frame.setTitle("CatchApp"); 
		frame.setSize(350,350); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void createPanel() {
		panel = new JPanel(); 
		frame.add(panel);
		panel.setLayout(null);
	}
		
	public static void createMenu() {

		createFrame();
		frame.setIconImage(image.getImage()); 
		
		createPanel();

		label = new JLabel("MENU"); 
		label.setBounds(145, 20, 300, 80);
		panel.add(label);
			
		b2 = new JButton("MY PROFILE");
		b2.setBounds(70,100,180,25);
		b2.setFocusable(false);
		b2.addActionListener(new Menu());
		panel.add(b2);


		b1 = new JButton("OPTIONS");
		b1.setBounds(70, 130, 180, 25);
		b1.setFocusable(false);
		b1.addActionListener(new Menu());
		panel.add(b1);
		
		b3 = new JButton("LOG OUT");
		b3.setBounds(70, 160, 180, 25);
		b3.setFocusable(false);
		b3.addActionListener(new Menu());
		panel.add(b3);
			
		frame.setVisible(true);
	}
	

	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == b1) {
			 MessageSWING.messageOptions();
			 frame.setVisible(false);
		} else if (e.getSource() == b3) {
			frame.setVisible(false);
			logoutPerformed();
		} else if (e.getSource() == b2) {
			Profile.showProfile();
			frame.setVisible(false);
		}
		
	}

	public static void logoutPerformed() {
			AppIntro.intro();
			
	}

}


