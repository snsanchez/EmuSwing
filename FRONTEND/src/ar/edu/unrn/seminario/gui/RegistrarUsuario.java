package ar.edu.unrn.seminario.gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarUsuario {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	Color FONDO_CLARO  = new Color(74, 36, 92);
	Color FONDO_OSCURO = new Color(35, 15, 45);
	Color BORDE        = new Color(169, 65, 196);
	Color LETRAS       = new Color(245, 240, 247);

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
		frame = new JFrame("Registrar usuario");
		frame.setBackground(FONDO_CLARO);
		frame.setForeground(LETRAS);
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(FONDO_OSCURO);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setForeground(LETRAS);
		lblContrasea.setBounds(86, 22, 97, 17);
		frame.getContentPane().add(lblContrasea);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(LETRAS);
		lblNombre.setBounds(86, 54, 60, 17);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setForeground(LETRAS);
		lblMail.setBounds(86, 87, 60, 17);
		frame.getContentPane().add(lblMail);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setForeground(LETRAS);
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
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAceptar.setBounds(199, 231, 105, 27);
		frame.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(323, 231, 105, 27);
		frame.getContentPane().add(btnCancelar);
	}
}
