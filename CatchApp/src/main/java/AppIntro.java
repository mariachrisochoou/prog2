import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *This class represents the introduction for our application.
 *Contains the register and log in process.
 *Implements ActionListener interface in order to 
 *complete the registration and log-in of the user.
 *
 *		@author Maria Chrysochoou
 *
 */

public class AppIntro implements ActionListener {
	
	/* JFrame object */
	private static JFrame frame;
	
	/* JPanel objects */
	private static JPanel p1,p2,p3,p4;
	
	/* JLabel objects */
	private static JLabel welcome, l2, register, name, pw, dof, mail, login;
	
	/* JTextField for the username and the information of the user */
	private static JTextField username, email, dateOfBirth;
	
	/* JPasswordField for the secrecy of the password */
	private static JPasswordField password;
	
	/* JButton objects */
	private static JButton b1, b2, b3, b4,b5,b6,b7,wr,wr2;
	
	/* Connection object for the connection with the Database */
	private DbConnection conn = new DbConnection();
	
	/* Object of User2 for the log in and registration process */
	private User2 user = new User2(conn.connect());
	
	private static String n, p, m,d;
	
	private static AppIntro ai = new AppIntro();
	
	/* Getter for the user's name */
	public static String getName() { 
		return n;

	}
	
	/* Getter for the user's mail */
	public static String getMail() { 
		return m;

	}
	
	/* Getter for the user's birthday date */
	public static String getBirthday() { 
		return d;

	}
	
	/* Initiate the Frame
	 * and show the register or log in option
	 */
	public static void intro() {
		
		createFrame();
		p1 = new JPanel();
		frame.add(p1);
		p1.setLayout(null);
		p1.setBackground(Color.pink);
		
		welcome = new JLabel("WELCOME TO CATCH APP! ♥︎ ");
		welcome.setBackground(Color.red);
		welcome.setBounds(110, 40, 550, 25);
		welcome.setForeground(Color.red);
		welcome.setFont(new Font("Arial", Font.ITALIC,35));
		p1.add(welcome);
		
		l2 = new JLabel("How do you want to proceed?");
		l2.setBounds(190, 120, 400, 50);
		l2.setFont(new Font("Cambria", Font.ITALIC, 20));
		p1.add(l2);
		
		b1 = new JButton("REGISTER");
		b1.setBounds(230, 230, 180, 40);
		b1.setBackground(Color.red);
		b1.addActionListener(ai);
		p1.add(b1);
		
		b2 = new JButton("LOGIN ");
		b2.setBackground(Color.red);
		b2.setBounds(230, 290, 180, 40);
		b2.addActionListener(ai);
		p1.add(b2);
		
		frame.setVisible(true);	
	}
	
	/* Ask user for information
	 * and complete registration process
	 */
	public static void register() {
		p2 = new JPanel();
		frame.add(p2);
		p2.setLayout(null);
		p2.setBackground(Color.pink);
		
		
		register = new JLabel("Let's get you registered!");
		register.setBounds(220, 20, 200, 25);
		register.setFont(new Font("Cambria", Font.PLAIN,18));
		p2.add(register);
		
		name = new JLabel("Username: ");
		name.setBounds(10, 100, 200, 25);
		name.setFont(new Font("Arial black", Font.PLAIN,12));
		p2.add(name);
		
		username = new JTextField(30);
		username.setBounds(125, 100, 200, 25);
		p2.add(username);
				
		pw = new JLabel("Password: ");
		pw.setBounds(10, 140, 200, 25);
		pw.setFont(new Font("Arial black", Font.PLAIN,12));
		p2.add(pw);
		
		password = new JPasswordField(30);
		password.setBounds(125, 140, 200, 25);
		p2.add(password);
		
		dof = new JLabel("Date of Birth: ");
		dof.setBounds(10, 180, 200, 25);
		dof.setFont(new Font("Arial black", Font.PLAIN,12));
		p2.add(dof);
		
		dateOfBirth = new JTextField(8);
		dateOfBirth.setBounds(125, 180, 200, 25);
		p2.add(dateOfBirth);
		
		mail = new JLabel("Email: ");
		mail.setBounds(10, 220, 165, 25);
		mail.setFont(new Font("Arial black", Font.PLAIN,12));
		p2.add(mail);
		
		email = new JTextField(50);
		email.setBounds(125, 220, 200, 25);
		p2.add(email);
		
		b3 = new JButton("REGISTER");
		b3.setBounds(380, 340, 120, 40);
		b3.setBackground(Color.red);
		p2.add(b3);
		b3.addActionListener(ai);
		
		wr = new JButton("OOPS, I WANT TO LOGIN");
		wr.setBounds(50,340,200,40);
		wr.setBackground(Color.red);
		p2.add(wr);
		wr.addActionListener(ai);
		
		frame.setVisible(true);
	}
	
	/* Create the Frame for our app */
	public static void createFrame() {
		frame = new JFrame();
		frame.setBounds(400,100,700,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/* Ask user for their username 
	 * and password for log in 
	 * and complete the log in process
	 */
	public static void login() {
		p3 = new JPanel();
		frame.add(p3);
		p3.setLayout(null);
		p3.setBackground(Color.pink);
		
		
		login = new JLabel("Let's get you logged in!");
		login.setBounds(220, 20, 200, 25);
		login.setFont(new Font("Cambria",Font.PLAIN, 18));
		p3.add(login);
		
		name = new JLabel("Username: ");
		name.setBounds(10, 100, 200, 25);
		p3.add(name);
		
		username = new JTextField(30);
		username.setBounds(125, 100, 200, 25);
		p3.add(username);
		
		pw = new JLabel("Password: ");
		pw.setBounds(10, 140, 200, 25);
		p3.add(pw);
		
		password = new JPasswordField(30);
		password.setBounds(125, 140, 200, 25);
		p3.add(password);
		
		b4 = new JButton("LOGIN");
		b4.setBounds(380, 250, 120, 40);
		b4.setBackground(Color.red);
		b4.addActionListener(ai);
		p3.add(b4);
		
		wr2= new JButton("OOPS, I WANT TO REGISTER");
		wr2.setBounds(50,250,250,40);
		wr2.setBackground(Color.red);
		wr2.addActionListener(ai);
		p3.add(wr2);
		
		frame.setVisible(true);
	}
	
	/* Overridden method for the ActionListener interface
	 * Activate the buttons
	 */
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		
		boolean flag;
		
		if (e.getSource() == b1) {

			p1.setVisible(false);
			register();

		} else if (e.getSource() == b2) {

			p1.setVisible(false);
			login();

		} else if (e.getSource() == b4) {

			p3.setVisible(false);
			n = username.getText();
			checkLogIn( (user.logUser(username.getText(), password.getText())));

		} else if (e.getSource() == b3) {
		
			flag = insertDetails();
			checkFlag(flag);
			p2.setVisible(false);
	
		} else if (e.getSource()== b6) {
	
			p4.setVisible(false);
			intro();

		} else if(e.getSource()== b5) {

			Menu.createMenu();
			frame.setVisible(false);

		} else if (e.getSource()==b7) {

			p1.setVisible(false);
			frame.setVisible(false);
			createFrame();
			intro();

		} else if (e.getSource()==wr) {

			frame.setVisible(false);
			p2.setVisible(false);
			intro();
			
		} else if (e.getSource()==wr2) {

			frame.setVisible(false);
			p3.setVisible(false);
			intro();
		}
	}
	
	/* Check if the username and password 
	 * are correct for the user 
	 */
	public void checkLogIn(boolean flag) {
		if (flag) {
			loginSuccess();
		} else {
			loginFail();
		}
	}
	
	/* Add new Panel for the successful log in */
	public void loginSuccess() {
		p1 = new JPanel();
		frame.add(p1);
		p1.setLayout(null);
		p1.setBackground(Color.pink);
		
		welcome = new JLabel("You have logged in successfully!");
		welcome.setBounds(190, 50, 400, 40);
		welcome.setBackground(Color.black);
		welcome.setForeground(Color.black);
		welcome.setFont(new Font("Cambria",Font.PLAIN,20));
		p1.add(welcome);
		
		b5= new JButton("NEXT");
		b5.setBounds(230,150,200,40);
		b5.addActionListener(new AppIntro());
		b5.setBackground(Color.red);
		p1.add(b5);
		
		frame.setVisible(true);
	}
	
	/* Add new Panel for the unsuccessful log in */
	public void loginFail() {
		p1 = new JPanel();
		frame.add(p1);
		p1.setLayout(null);
		p1.setBackground(Color.pink);
		
		welcome = new JLabel("Login failed!");
		welcome.setBounds(260, 50, 400, 40);
		welcome.setBackground(Color.black);
		welcome.setForeground(Color.black);
		welcome.setFont(new Font("Cambria",Font.PLAIN,20));
		
		p1.add(welcome);
		frame.setVisible(false);
		
		b7= new JButton("BACK");
		b7.setBounds(230,150,200,40);
		b7.setBackground(Color.red);
		b7.addActionListener(new AppIntro());
		p1.add(b7);
		
		frame.setVisible(true);
	}
	
	/* Check if user's information are valid */
	public void checkFlag (boolean flag) {
		
		if (flag) {
			accessAccepted();
		} else {
			accessDenied();
		}
		
	}
	
	/* Enter user's information for registration */
	public boolean insertDetails() {
		n = username.getText();
		p = password.getText();
		m = email.getText();
		d = dateOfBirth.getText();
		return user.insertData(n, p, m,d);
	}
		
	
	/* Show that registration process is complete */
	public void accessAccepted() {
		
		p4 = new JPanel();
		frame.add(p4);
		p4.setLayout(null);
		p4.setBackground(Color.pink);
		
		welcome = new JLabel("HELLO NEW LOVEBIRD!");
		welcome.setFont(new Font("Cambria", Font.BOLD,20));
		welcome.setBackground(Color.red);
		welcome.setForeground(Color.red);
		welcome.setBounds(230, 50, 250, 25);
		p4.add(welcome);
		frame.setVisible(false);
		

		b5= new JButton("LET'S GET STARTED");
		b5.setBounds(250,200,180,40);
		b5.addActionListener(new AppIntro());
		b5.setBackground(Color.red);
		p4.add(b5);
		
		b6= new JButton("BACK");
		b6.setBounds(250,270,180,40);
		b6.addActionListener(new AppIntro());
		b6.setBackground(Color.red);
		p4.add(b6);
		
		frame.setVisible(true);
		
	}
	
	/* Show that registration failed */
	public void accessDenied() {
		
		p1 = new JPanel();
		frame.add(p1);
		p1.setLayout(null);
		p1.setBackground(Color.pink);
	
		
		welcome = new JLabel("This lovebird already exists!");
		welcome.setFont(new Font("Cambria", Font.BOLD,20));
		welcome.setBackground(Color.black);
		welcome.setForeground(Color.black);
		welcome.setBounds(200, 100, 300, 25);
		p1.add(welcome);
	
		
		b7= new JButton("BACK");
		b7.setBounds(240,400,180,40);
		b7.addActionListener(new AppIntro());
		b7.setBackground(Color.red);
		p1.add(b7);
	
		
		
		
		frame.setVisible(true);
		
		
	}
	

	

}