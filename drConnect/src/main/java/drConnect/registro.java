package drConnect;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import drConnect.modelos.Paciente;
import drConnect.modelos.TipoUsuario;
import drConnect.modelos.Usuario;
import drConnect.repositorios.MedicoRepositorio;
import drConnect.repositorios.PacienteRepositorio;
import drConnect.repositorios.UsuarioRepositorio;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class registro {

	private JFrame frame;
	private JTextField nomeTextField;
	private JTextField emailTextField;
	private JTextField telefoneTextField;
	private JPasswordField passwordField;
	private JPasswordField confirmePasswordField;
	private JTextField cepTextField;
	private JTextField numeroTextField;
	private JTextField complementoTextField;
	private EntityManager entityManager;
	private UsuarioRepositorio usuarioRepositorio;
	private MedicoRepositorio medicoRepositorio;
	private PacienteRepositorio pacienteRepositorio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro window = new registro();
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
	public registro() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("drconnect");
		entityManager=entityManagerFactory.createEntityManager();
		usuarioRepositorio=new UsuarioRepositorio(entityManager);
		medicoRepositorio=new MedicoRepositorio(entityManager);
		pacienteRepositorio=new PacienteRepositorio(entityManager);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 665, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		nomeTextField = new JTextField();
		nomeTextField.setBounds(42, 71, 217, 20);
		frame.getContentPane().add(nomeTextField);
		nomeTextField.setColumns(10);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(42, 117, 217, 20);
		frame.getContentPane().add(emailTextField);
		emailTextField.setColumns(10);
		
		telefoneTextField = new JTextField();
		telefoneTextField.setColumns(10);
		telefoneTextField.setBounds(42, 170, 217, 20);
		frame.getContentPane().add(telefoneTextField);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('+');
		passwordField.setBounds(42, 226, 217, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel confirmeSenhaLabel = new JLabel("Confirme sua senha");
		confirmeSenhaLabel.setBounds(42, 257, 217, 14);
		frame.getContentPane().add(confirmeSenhaLabel);
		
		JLabel nomeLabel = new JLabel("Nome Completo");
		nomeLabel.setBounds(42, 46, 217, 14);
		frame.getContentPane().add(nomeLabel);
		
		JLabel emailLabel = new JLabel("Seu melhor e-mail");
		emailLabel.setBounds(42, 102, 217, 14);
		frame.getContentPane().add(emailLabel);
		
		JLabel telefoneLabel = new JLabel("Telefone");
		telefoneLabel.setBounds(42, 145, 217, 14);
		frame.getContentPane().add(telefoneLabel);
		
		confirmePasswordField = new JPasswordField();
		confirmePasswordField.setEchoChar('+');
		confirmePasswordField.setBounds(42, 282, 217, 20);
		frame.getContentPane().add(confirmePasswordField);
		
		JLabel senhaLabel = new JLabel("Escolha uma senha");
		senhaLabel.setBounds(42, 201, 217, 14);
		frame.getContentPane().add(senhaLabel);
		
		cepTextField = new JTextField();
		cepTextField.setBounds(358, 71, 217, 20);
		frame.getContentPane().add(cepTextField);
		cepTextField.setColumns(10);
		
		JLabel cepLabel = new JLabel("CEP");
		cepLabel.setBounds(358, 46, 217, 14);
		frame.getContentPane().add(cepLabel);
		
		numeroTextField = new JTextField();
		numeroTextField.setBounds(358, 116, 55, 20);
		frame.getContentPane().add(numeroTextField);
		numeroTextField.setColumns(10);
		
		complementoTextField = new JTextField();
		complementoTextField.setBounds(436, 116, 139, 20);
		frame.getContentPane().add(complementoTextField);
		complementoTextField.setColumns(10);
		
		JLabel NumeroLabel = new JLabel("Numero");
		NumeroLabel.setBounds(358, 102, 55, 14);
		frame.getContentPane().add(NumeroLabel);
		
		JLabel ComplementoLabel = new JLabel("Complemento");
		ComplementoLabel.setBounds(436, 102, 139, 14);
		frame.getContentPane().add(ComplementoLabel);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario usuario=Usuario.builder()
						.email(emailTextField.getText())
						.password(new String (passwordField.getPassword()))
						.nome(nomeTextField.getText())
						.telefone(telefoneTextField.getText())
						.tipoUsuario(TipoUsuario.PACIENTE)
						.build();
				Usuario salvo = usuarioRepositorio.salva(usuario);
				Paciente paciente=Paciente.builder()
						.cep(cepTextField.getText())
						.complemento(complementoTextField.getText())
						.numero(numeroTextField.getText())
						.usuario(salvo)
						.build();
				pacienteRepositorio.salva(paciente);

			}
		});
		btnCadastrar.setBounds(486, 371, 89, 23);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(358, 371, 89, 23);
		frame.getContentPane().add(btnLimpar);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{nomeLabel, nomeTextField, emailLabel, emailTextField, telefoneLabel, telefoneTextField, passwordField, senhaLabel, confirmeSenhaLabel, confirmePasswordField, cepLabel, cepTextField, NumeroLabel, numeroTextField, ComplementoLabel, complementoTextField, btnCadastrar, btnLimpar}));
	}
}
