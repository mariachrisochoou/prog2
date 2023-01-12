import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class creates the Profile option of our application.
 * Implements ActionListener interface to activate the buttons
 * used.
 * 	
 * @author Ellie Papastergiou, Maria Chrisochoou
 *
 */
public class Profile implements ActionListener {
		
	/* JFrame object */
	private static JFrame fProf;
	
	/* JLabel objects */
	private static JLabel profile, name, email, dof, n, e, b;
	
	/* JPanel object */
	private static JPanel pProf;
	
	/* JButton object */
	private static JButton back;
	
	/* Image Object */
	private static ImageIcon image = new ImageIcon("logo.png"); 
	
	/* Connection object */
	private static Connection conn;
	
	/* Db Connection object */
	private DbConnection connection = new DbConnection();
	
	private static String username, mail, birthday;
	
	
	/*Constructor of Profile class
	 * initiates conn object
	 */
	public Profile(Connection conn) {
		this.conn = conn;
	}
	
	/* Show user's information */
	public void showProfile() {
			
		fProf = new JFrame();
		fProf.setTitle("CatchApp"); 
		fProf.setSize(500,500); 
		fProf.setBounds(400,100,700,700);
		fProf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	
		fProf.setIconImage(image.getImage());
			
		pProf = new JPanel(); 
		fProf.add(pProf);
		pProf.setLayout(null);
		pProf.setBackground(Color.pink);
			
		profile = new JLabel("MY PROFILE");
		profile.setBounds(260, 40, 200, 25);
		profile.setFont(new Font("Cambria", Font.PLAIN,20));
		profile.setBackground(Color.red);
		profile.setForeground(Color.red);
		pProf.add(profile);
	
	
		try {
			getUserData(AppIntro.getName());
		} catch (Exception e) {
			
		}
			
		name = new JLabel("Username: ");
		name.setBounds(10, 100, 200, 25);
		name.setFont(new Font("Arial", Font.BOLD,15));
		pProf.add(name);
			
		n = new JLabel(username);
		n.setBounds(120, 100, 200, 25);
		pProf.add(n);
			
		email = new JLabel("E-mail: ");
		email.setBounds(10, 140, 200, 25);
		email.setFont(new Font("Arial", Font.BOLD,15));
		pProf.add(email);
			
		e = new JLabel(mail);
		e.setBounds(120, 140, 200, 25);
		pProf.add(e);
			
		dof = new JLabel("Birth Date: ");
		dof.setBounds(10, 180, 200, 25);
		dof.setFont(new Font("Arial", Font.BOLD,15));
		pProf.add(dof);
			
		b = new JLabel(birthday);
		b.setBounds(120, 180, 200, 25);
		pProf.add(b);
			
		back = new JButton("BACK");
		back.setBounds(260,400,100,40);
		back.addActionListener(new Profile(connection.connect()));
		back.setBackground(Color.red);
		pProf.add(back);	
			
		fProf.setVisible(true);
		pProf.setVisible(true);
			
	}
	
	/* Get user information form database */
	public static void getUserData(String name) {
		
		String sql = "SELECT username, email, date FROM User";
		boolean f1 = false;
		
		try {
			Statement sm = conn.createStatement();
			ResultSet rs = sm.executeQuery(sql);
			
			while (rs.next() && f1 == false) {
				f1 = rs.getString("username").equals(name);
				username = rs.getString("username");
				mail = rs.getString("email");
				birthday = rs.getString("date");
			}
		} catch (Exception e) {
			
		}
		
		
	}
	
	/* Go back to the main menu */ 
	public void actionPerformed(ActionEvent e) {
			
	   if (e.getSource()==back) {
		   pProf.setVisible(false);
		   Menu.createMenu();
		   fProf.setVisible(false);
		    	
	   }
		    	
		    
	}
	
}

