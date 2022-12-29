import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Welcome implements ActionListener {
		 
	private ImageIcon logo;
	private static JFrame frame;
	private static JLabel label;
	private static JButton b;
	private static JPanel panel;
	
		
	public Welcome() {
			
			frame = new JFrame("Welcome to Catch App!");
			frame.setBounds(400,100,700,700);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			b = new JButton("START");
			b.addActionListener(this);
			b.setBounds(270,400, 120, 40);
	
				
			panel = (JPanel)frame.getContentPane();  
			panel.setLayout(null);
			logo = new ImageIcon(getClass().getResource("photoCATCHAPP.png"));
			Image image = logo.getImage(); // transform it 
			Image newimg = image.getScaledInstance(600, 600,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			logo = new ImageIcon(newimg);  // transform it back
			
			label = new JLabel(logo);
			label.setBounds(150, 50, 400, 400);
			
				  
			frame.add(label);
			panel.add(b);
			
			frame.setVisible(true);
		}
		
	public static void main(String [] args) {
		new Welcome();
			
	}
	

		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == b ) {
				AppIntro.intro();
				frame.setVisible(false);
			}
		}
		
	}