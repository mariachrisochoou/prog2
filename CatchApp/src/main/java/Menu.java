import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** This class creates the Menu panel with the options
 * the user has.
 * Implements ActionListener interface for the options
 * 
 * 	@author Ellie Papastergiou, Giorgos Giannis
 *
 */
public class Menu implements ActionListener {

	/* JFrame object */
	private static JFrame frame;
	
	/* JLabel objects */
	private static JLabel label;
	
	/* JPanel objects */
	private static JPanel panel;
	
	/* JButton objects */
	private static JButton b1, b2, b3; 
	
	/* Image Object: Application's Logo */
	private static ImageIcon image = new ImageIcon("logo.png");
	
	/* Connection object for the connection with the Database */
	private DbConnection conn = new DbConnection();
	
	/* Object of Profile class */
	private Profile profile = new Profile(conn.connect());
	
	/*Create Frame */
	public static void createFrame() {
		frame = new JFrame(); 
		frame.setTitle("CatchApp"); 
		frame.setSize(500,500); 
		frame.setBounds(400,100,700,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*Create Panel */
	public static void createPanel() {
		panel = new JPanel(); 
		frame.add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.pink);
	}
		
	/*Create Menu with the options */
	public static void createMenu() {

		createFrame();
		frame.setIconImage(image.getImage()); 
		
		createPanel();

		label = new JLabel(" ~ MENU ~ "); 
		label.setBounds(280, 20, 350, 80);
		label.setFont(new Font("Cambria", Font.BOLD,20));
		label.setBackground(Color.red);
		label.setForeground(Color.red);
		panel.add(label);
			
		b2 = new JButton("MY PROFILE");
		b2.setBounds(240,180,180,40);
		b2.setBackground(Color.red);
		b2.setFocusable(false);
		b2.addActionListener(new Menu());
		panel.add(b2);


		b1 = new JButton("OPTIONS");
		b1.setBounds(240, 240, 180, 40);
		b1.setBackground(Color.red);
		b1.setFocusable(false);
		b1.addActionListener(new Menu());
		panel.add(b1);
		
		b3 = new JButton("LOG OUT");
		b3.setBounds(240, 300, 180, 40);
		b3.setBackground(Color.red);
		b3.setFocusable(false);
		b3.addActionListener(new Menu());
		panel.add(b3);
		
			
		frame.setVisible(true);
	}
	
    
    /*Override ActionPerformed to activate the buttons */
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
	
	/* Log out from the app */
	public static void logoutPerformed() {
			AppIntro.intro();
	}

}
