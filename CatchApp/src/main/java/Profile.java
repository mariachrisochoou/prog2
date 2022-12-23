import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Profile implements ActionListener {
		
	private static JFrame fProf;
	private static JLabel profile, name, email, dof, n, e, b;
	private static JPanel pProf;
	private static JButton back;
	private static ImageIcon image = new ImageIcon("logo.png"); 
	
	public static void showProfile() {
			
		fProf = new JFrame();
		fProf.setTitle("CatchApp"); 
		fProf.setSize(350,350); 
		fProf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	
		fProf.setIconImage(image.getImage());
			
		pProf = new JPanel(); 
		fProf.add(pProf);
		pProf.setLayout(null);
			
		profile = new JLabel("MY PROFILE");
		profile.setBounds(120, 20, 200, 25);
		pProf.add(profile);
			
		name = new JLabel("Username: ");
		name.setBounds(10, 60, 200, 25);
		pProf.add(name);
			
		n = new JLabel(AppIntro.getName());
		n.setBounds(90, 60, 200, 25);
		pProf.add(n);
			
		email = new JLabel("E-mail: ");
		email.setBounds(10, 90, 200, 25);
		pProf.add(email);
			
		e = new JLabel(AppIntro.getMail());
		e.setBounds(60, 90, 200, 25);
		pProf.add(e);
			
		dof = new JLabel("Birth Date: ");
		dof.setBounds(10, 120, 200, 25);
		pProf.add(dof);
			
		b = new JLabel(AppIntro.getBirthday());
		b.setBounds(90, 120, 200, 25);
		pProf.add(b);
			
		back = new JButton("Back");
		back.setBounds(10,160,80,25);
		back.addActionListener(new Profile());
		pProf.add(back);	
			
		fProf.setVisible(true);
		pProf.setVisible(true);
			
	}
		
	public void actionPerformed(ActionEvent e) {
			
	   if (e.getSource()==back) {
		   pProf.setVisible(false);
		   Menu.createMenu();
		   fProf.setVisible(false);
		    	
	   }
		    	
		    
	}
	
}
		
		
	


