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
	private static JButton b1, b2, b3, b4;
	
	public static void createMenu() {
		
		AppIntro ai = new AppIntro();
		
		frame = new JFrame(); // creates a frame
		frame.setTitle("CatchApp"); //sets title of frame
		frame.setSize(350,350); //sets frame size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of app
		
		
		ImageIcon image = new ImageIcon("logo.png"); //creates an ImageIcon
		frame.setIconImage(image.getImage()); //changes the icon of frame
		
		panel = new JPanel(); //creates a panel
		frame.add(panel); 
		panel.setLayout(null);
		
		label = new JLabel("MENU"); //creates a label
		label.setBounds(145, 0, 300, 80);
		panel.add(label);
		
		b1 = new JButton("WRITE A MESSAGE"); 
		b1.setBounds(70, 90, 180, 25);
		b1.setFocusable(false);
		panel.add(b1);
		
		b2 = new JButton("SENT MESSAGES");
		b2.setBounds(70, 120, 180, 25);
		b2.setFocusable(false);
		panel.add(b2);
		
		b3 = new JButton("RECEIVED MESSAGES");
		b3.setBounds(70, 150, 180, 25);
		b3.setFocusable(false);
		panel.add(b3);
		
		b4 = new JButton("LOG OUT");
		b4.setBounds(70, 180, 180, 25);
		b4.setFocusable(false);
		b4.addActionListener(ai);
		panel.add(b4);
		
		frame.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		
		createMenu();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*if (e.getSource() == b1) {
		} else if (e.getSource() == b2) {
		} else if (e.getSource() == b3) {
		} else*/ if (e.getSource() == b4) {
			panel.setVisible(false);
			logoutPerformed();
		}
	}
	
	public static void logoutPerformed() {
		
		AppIntro.createFrame();
		AppIntro.intro();
	}