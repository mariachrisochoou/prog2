import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class MessageSWING  {



    public static void main(String[] args) {


			JFrame frame = new JFrame();
			frame.setSize(400,250);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel panel = new JPanel();
			frame.add(panel);
			panel.setLayout(null);

			JLabel label = new JLabel("Send message to: ");
			label.setBounds(10,20,160,25);
			panel.add(label);


			JTextField text = new JTextField(80);
			text.setBounds(150, 20, 165, 25);
			panel.add(text);



			JLabel mes = new JLabel("Type your message!");
			mes.setBounds(10,50,200,25);
			panel.add(mes);

			JTextField texting = new JTextField(100);
			texting.setBounds(150,50,165,25);
			panel.add(texting);

			JButton button = new JButton("Send");
			button.setBounds(10,80,80,25);
			panel.add(button);



			frame.setVisible(true);
		}

}
