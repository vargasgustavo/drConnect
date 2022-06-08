package drConnect;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.Color;

public class login {

	private JFrame frame;
	private JTextField emailTextField;
	private JPasswordField senhaPasswordField;
	private JLabel emailLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 653, 508);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		emailTextField = new JTextField();
		emailTextField.setBackground(new Color(255, 255, 255));
		emailTextField.setBounds(203, 116, 231, 27);
		frame.getContentPane().add(emailTextField);
		emailTextField.setColumns(10);
		
		senhaPasswordField = new JPasswordField();
		senhaPasswordField.setBackground(new Color(255, 255, 255));
		senhaPasswordField.setBounds(203, 194, 231, 27);
		frame.getContentPane().add(senhaPasswordField);
		
		JLabel senhaLabel = new JLabel("SENHA:");
		senhaLabel.setBounds(203, 169, 46, 14);
		frame.getContentPane().add(senhaLabel);
		
		emailLabel = new JLabel("E-MAIL:");
		emailLabel.setBounds(203, 91, 46, 14);
		frame.getContentPane().add(emailLabel);
		
		JButton entrarButton = new JButton("ENTRAR");
		entrarButton.setForeground(new Color(0, 0, 0));
		entrarButton.setBackground(new Color(102, 204, 255));
		entrarButton.setBounds(203, 256, 89, 23);
		frame.getContentPane().add(entrarButton);
		
		JButton registreButton = new JButton("REGISTRE-SE");
		registreButton.setBackground(new Color(102, 204, 255));
		registreButton.setBounds(317, 256, 117, 23);
		frame.getContentPane().add(registreButton);
		
		JLabel esqueceSenhaLabel = new JLabel("Esqueceu a senha?");
		esqueceSenhaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		esqueceSenhaLabel.setBounds(203, 231, 231, 14);
		frame.getContentPane().add(esqueceSenhaLabel);
		
		JList list = new JList();
		list.setBounds(134, 304, 1, 1);
		frame.getContentPane().add(list);
	}
}
