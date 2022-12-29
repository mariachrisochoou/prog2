


	import java.awt.Image;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;

	public class Welcome implements ActionListener {
		 ImageIcon logo;
		 JFrame frame;
		 JLabel label;
		 JButton b;
		 JPanel panel;
		//private static AppIntro ai = new AppIntro();
		
		public Welcome() {
			
			frame = new JFrame("Welcome to Catch App!");
			frame.setSize(350,350);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			b = new JButton("START");
			b.addActionListener(this);
			b.setBounds(80,250, 150, 25);
			
				
			panel = (JPanel)frame.getContentPane();  
			panel.setLayout(null);
			logo = new ImageIcon(getClass().getResource("photoCATCHAPP.png"));
			Image image = logo.getImage(); // transform it 
			Image newimg = image.getScaledInstance(500, 500,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			logo = new ImageIcon(newimg);  // transform it back
			
			label = new JLabel(logo);
			label.setBounds(0, 0, 330, 330);
				  
			frame.add(label);
			panel.add(b);
			
			frame.setVisible(true);
		}
		
		public static void main(String [] args) {
			new Welcome();
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == b ) {
			    AppIntro.createFrame();
				AppIntro.intro();
				frame.setVisible(false);
			}
		}
		
	}
