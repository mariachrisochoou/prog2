import java.awt.Color;
import java.awt.Font;
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
	private DbConnection conn = new DbConnection();
	private Profile profile = new Profile(conn.connect());
	
	public static void createFrame() {
		frame = new JFrame(); 
		frame.setTitle("CatchApp"); 
		frame.setSize(500,500); 
		frame.setBounds(400,100,700,700);
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
		label.setBounds(300, 20, 300, 80);
		label.setFont(new Font("Arial", Font.BOLD,20));
		label.setBackground(Color.blue);
		label.setForeground(Color.blue);
		panel.add(label);
			
		b2 = new JButton("MY PROFILE");
		b2.setBounds(240,180,180,40);
		b2.setFocusable(false);
		b2.addActionListener(new Menu());
		panel.add(b2);


		b1 = new JButton("OPTIONS");
		b1.setBounds(240, 240, 180, 40);
		b1.setFocusable(false);
		b1.addActionListener(new Menu());
		panel.add(b1);
		
		b3 = new JButton("LOG OUT");
		b3.setBounds(240, 300, 180, 40);
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
	
			profile.showProfile();
			frame.setVisible(false);

		}
		
	}

	public static void logoutPerformed() {
			AppIntro.intro();
	}

}
