import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AppIntro implements ActionListener {
	
	private static JFrame frame;
	private static JPanel p1,p2,p3;
	private static JLabel welcome, l2, register, name, pw, dof, mail, login;
	private static JTextField username, email, dateOfBirth;
	private static JPasswordField password;
	private static JButton b1, b2, b3, b4;
	

	public static void main(String[] args) {
		createFrame();
		intro();
		//register();
	}
	
	public static void intro() {
		
		AppIntro ai = new AppIntro();
		
		p1 = new JPanel();
		frame.add(p1);
		p1.setLayout(null);
		
		welcome = new JLabel("WELCOME TO CATCH APP!");
		welcome.setBounds(70, 20, 200, 25);
		p1.add(welcome);
		
		l2 = new JLabel("How do you want to proceed?");
		l2.setBounds(20, 60, 200, 25);
		p1.add(l2);
		
		b1 = new JButton("REGISTER");
		b1.setBounds(40, 90, 180, 25);
		b1.addActionListener(ai);
		p1.add(b1);
		
		b2 = new JButton("LOGIN IN");
		b2.setBounds(40, 120, 180, 25);
		b2.addActionListener(ai);
		p1.add(b2);
		
		
		frame.setVisible(true);
		
		
		
	}
	
	public static void register() {
		
		
		p2 = new JPanel();
		frame.add(p2);
		p2.setLayout(null);
		
		
		register = new JLabel("Let's get you registered!");
		register.setBounds(10, 20, 200, 25);
		p2.add(register);
		
		name = new JLabel("Username: ");
		name.setBounds(10, 60, 200, 25);
		p2.add(name);
		
		username = new JTextField(30);
		username.setBounds(125, 60, 165, 25);
		p2.add(username);
		
		pw = new JLabel("Password: ");
		pw.setBounds(10, 90, 200, 25);
		p2.add(pw);
		
		password = new JPasswordField(30);
		password.setBounds(125, 90, 165, 25);
		p2.add(password);
		
		dof = new JLabel("Date of Birth: ");
		dof.setBounds(10, 120, 200, 25);
		p2.add(dof);
		
		dateOfBirth = new JTextField(8);
		dateOfBirth.setBounds(125, 120, 165, 25);
		p2.add(dateOfBirth);
		
		mail = new JLabel("Email: ");
		mail.setBounds(10, 150, 200, 25);
		p2.add(mail);
		
		email = new JTextField(50);
		email.setBounds(125, 150, 200, 25);
		p2.add(email);
		
		b3 = new JButton("REGISTER");
		b3.setBounds(125, 200, 120, 25);
		p2.add(b3);
		
		frame.setVisible(true);
		
		
	}
	
	public static void createFrame() {
		frame = new JFrame();
		frame.setSize(350,350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void login() {
		p3 = new JPanel();
		frame.add(p3);
		p3.setLayout(null);
		
		
		login = new JLabel("Let's get you logged in!");
		login.setBounds(10, 20, 200, 25);
		p3.add(login);
		
		name = new JLabel("Username: ");
		name.setBounds(10, 60, 200, 25);
		p3.add(name);
		
		username = new JTextField(30);
		username.setBounds(125, 60, 165, 25);
		p3.add(username);
		
		pw = new JLabel("Password: ");
		pw.setBounds(10, 90, 200, 25);
		p3.add(pw);
		
		password = new JPasswordField(30);
		password.setBounds(125, 90, 165, 25);
		p3.add(password);
		
		b4 = new JButton("LOGIN");
		b4.setBounds(150, 130, 120, 25);
		p3.add(b4);
		
		
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == b1) {
			p1.setVisible(false);
			register();
		} else if (e.getSource() == b2) {
			p1.setVisible(false);
			login();
		}
		
	}
	

}
