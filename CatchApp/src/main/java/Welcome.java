import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** 
 * This class creates frame that welcomes users
 * This class implements ActionListener Interface
 * @author Dimitra Telatinidou, Ornela Kalogeri
 *
 */

public class Welcome implements ActionListener {
		 
	private ImageIcon logo;
	private static JFrame frame;
	private static JLabel label,label2;
	private static JButton b;
	private static JPanel panel;
	
	/* Constructor of Welcome class 
	 * Create frame 
	 */
	public Welcome() {
			
			frame = new JFrame("Welcome to Catch App!");
			frame.setBounds(400,100,700,700);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			b = new JButton("START");
			b.addActionListener(this);
			b.setBackground(Color.red);
			b.setBounds(270,400, 120, 40);
			
				
			panel = (JPanel)frame.getContentPane();  
			panel.setLayout(null);
			panel.setBackground(Color.pink);
			logo = new ImageIcon(getClass().getResource("photoCATCHAPP.png"));
			Image image = logo.getImage(); // transform it 
			Image newimg = image.getScaledInstance(600, 600,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			logo = new ImageIcon(newimg);  // transform it back
			
			label = new JLabel(logo);
			label.setBounds(120, 50, 400, 400);
			
			label2= new JLabel("LOVERS EDITION");
			label2.setBounds(240,480,200,40);
			label2.setForeground(Color.red);
			label2.setFont(new Font("Cambria", Font.BOLD,25));
			panel.add(label2);
			
				  
			frame.add(label);
			panel.add(b);
			
			frame.setVisible(true);
		}
		
	/* Main method that runs the program*/
	public static void main(String [] args) {
		new Welcome();
			
	}
	

	/* Overridden method for the ActionListener interface
	 * Activate the buttons
	 */
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == b ) {
				AppIntro.intro();
				frame.setVisible(false);
			}
		}
		
	}
