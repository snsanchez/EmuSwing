package ar.edu.unrn.seminario.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RegistrarUsuario {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarUsuario window = new RegistrarUsuario();
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
	public RegistrarUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(86, 22, 97, 17);
		frame.getContentPane().add(lblContrasea);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(86, 54, 60, 17);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setBounds(86, 87, 60, 17);
		frame.getContentPane().add(lblMail);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setBounds(86, 116, 60, 17);
		frame.getContentPane().add(lblRol);
		
		textField = new JTextField();
		textField.setBounds(186, 20, 114, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(186, 54, 114, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(186, 85, 114, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(186, 116, 114, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(199, 231, 105, 27);
		frame.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(323, 231, 105, 27);
		frame.getContentPane().add(btnCancelar);
	}
}
