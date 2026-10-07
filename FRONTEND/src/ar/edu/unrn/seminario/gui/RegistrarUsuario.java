package ar.edu.unrn.seminario.gui;
import ar.edu.unrn.seminario.helpers.UIHelper;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.border.LineBorder;

public class RegistrarUsuario {

	private JFrame frame;
	private JTextField textFieldNombre;
	private JPasswordField textFieldContrasena;
	private JTextField textFieldMail;
	private JTextField textFieldRol;

	// Paleta de colores EmuSwing
	private static final Color COLOR_FONDO_PRINCIPAL = new Color(20, 10, 28);
	private static final Color COLOR_PANEL           = new Color(32, 16, 45);
	private static final Color COLOR_TARJETA         = new Color(48, 24, 68);
	private static final Color COLOR_BORDE           = new Color(153, 50, 204);
	private static final Color COLOR_ACCENTO         = new Color(160, 40, 210);
	private static final Color COLOR_TEXTO           = new Color(245, 240, 247);
	private static final Color COLOR_TEXTO_MUTED     = new Color(180, 170, 195);

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

	public RegistrarUsuario() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Registrar Usuario - EmuSwing");
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(UIHelper.COLOR_FONDO_PRINCIPAL);


		// JMenuBar centrado estilo Home
				JMenuBar menuBar = new JMenuBar();
				menuBar.setBackground(UIHelper.COLOR_FONDO_PRINCIPAL);
				menuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, UIHelper.COLOR_PANEL));
				menuBar.add(javax.swing.Box.createHorizontalGlue());
				// Espaciador para centrar las opciones
				menuBar.add(javax.swing.Box.createHorizontalGlue());

				JMenu mnPerfil = new JMenu("Mi Perfil");
				mnPerfil.setForeground(UIHelper.COLOR_TEXTO);
				mnPerfil.setFont(new Font("SansSerif", Font.PLAIN, 13));
				menuBar.add(mnPerfil);

				JMenu mnBiblioteca = new JMenu("Biblioteca");
				mnBiblioteca.setForeground(UIHelper.COLOR_TEXTO);
				mnBiblioteca.setFont(new Font("SansSerif", Font.PLAIN, 13));
				menuBar.add(mnBiblioteca);

				JMenu mnJuegos = new JMenu("Juegos");
				mnJuegos.setForeground(UIHelper.COLOR_TEXTO);
				mnJuegos.setFont(new Font("SansSerif", Font.PLAIN, 13));
				menuBar.add(mnJuegos);

				JMenu mnTienda = new JMenu("Tienda");
				mnTienda.setForeground(UIHelper.COLOR_TEXTO);
				mnTienda.setFont(new Font("SansSerif", Font.PLAIN, 13));
				menuBar.add(mnTienda);

				JMenu mnSoporte = new JMenu("Soporte");
				mnSoporte.setForeground(UIHelper.COLOR_TEXTO);
				mnSoporte.setFont(new Font("SansSerif", Font.PLAIN, 13));
				menuBar.add(mnSoporte);

				JMenu mnAjustes = new JMenu("Ajustes");
				//mnAjustes.// JMenuBar centrado estilo Home
				JMenuBar menuBar1 = new JMenuBar();
				menuBar1.setBackground(UIHelper.COLOR_FONDO_PRINCIPAL);
				menuBar1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, UIHelper.COLOR_PANEL));

				// Espaciador para centrar las opciones
				menuBar1.add(javax.swing.Box.createHorizontalGlue());

				JMenu mnPerfil1 = new JMenu("Mi Perfil");
				mnPerfil1.setForeground(UIHelper.COLOR_TEXTO);
				mnPerfil1.setFont(new Font("SansSerif", Font.PLAIN, 13));
				menuBar1.add(mnPerfil1);

				JMenu mnBiblioteca1 = new JMenu("Biblioteca");
				mnBiblioteca1.setForeground(UIHelper.COLOR_TEXTO);
				mnBiblioteca1.setFont(new Font("SansSerif", Font.PLAIN, 13));
				menuBar1.add(mnBiblioteca1);

				JMenu mnJuegos1 = new JMenu("Juegos");
				mnJuegos1.setForeground(UIHelper.COLOR_TEXTO);
				mnJuegos1.setFont(new Font("SansSerif", Font.PLAIN, 13));
				menuBar1.add(mnJuegos1);

				JMenu mnTienda1 = new JMenu("Tienda");
				mnTienda1.setForeground(UIHelper.COLOR_TEXTO);
				mnTienda1.setFont(new Font("SansSerif", Font.PLAIN, 13));
				menuBar1.add(mnTienda1);

				JMenu mnSoporte1 = new JMenu("Soporte");
				mnSoporte1.setForeground(UIHelper.COLOR_TEXTO);
				mnSoporte1.setFont(new Font("SansSerif", Font.PLAIN, 13));
				menuBar1.add(mnSoporte1);

				JMenu mnAjustes1 = new JMenu("Ajustes");
				mnAjustes1.setForeground(UIHelper.COLOR_TEXTO);
				mnAjustes1.setFont(new Font("SansSerif", Font.PLAIN, 13));
				menuBar1.add(mnAjustes1);


				// Espaciador derecho para empujar todo al centro
				menuBar1.add(javax.swing.Box.createHorizontalGlue());

				frame.setJMenuBar(menuBar1);setForeground(UIHelper.COLOR_TEXTO);
				mnAjustes1.setFont(new Font("SansSerif", Font.PLAIN, 13));
				menuBar1.add(mnAjustes1);

				// Espaciador derecho para empujar todo al centro
				menuBar1.add(javax.swing.Box.createHorizontalGlue());

				frame.setJMenuBar(menuBar1);

		// Panel Central de Formulario
		JPanel panel = new JPanel();
		panel.setBackground(UIHelper.COLOR_PANEL);
		panel.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1, true));
		panel.setBounds(390, 90, 500, 480);
		panel.setLayout(null);
		frame.getContentPane().add(panel);

		// Título del formulario
		JLabel lblRegistrarUsuario = new JLabel("Crear Cuenta");
		lblRegistrarUsuario.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblRegistrarUsuario.setForeground(UIHelper.COLOR_TEXTO);
		lblRegistrarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarUsuario.setBounds(0, 30, 500, 35);
		panel.add(lblRegistrarUsuario);

		JLabel lblSubtitulo = new JLabel("Ingresa los datos para registrar un usuario");
		lblSubtitulo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblSubtitulo.setForeground(UIHelper.COLOR_TEXTO_MUTED);
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo.setBounds(0, 65, 500, 20);
		panel.add(lblSubtitulo);

		// Campo: Nombre
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNombre.setForeground(COLOR_TEXTO);
		lblNombre.setBounds(80, 115, 100, 20);
		panel.add(lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(80, 138, 340, 32);
		textFieldNombre.setBackground(UIHelper.COLOR_TARJETA);
		textFieldNombre.setForeground(UIHelper.COLOR_TEXTO);
		textFieldNombre.setCaretColor(UIHelper.COLOR_TEXTO);
		textFieldNombre.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textFieldNombre.setBorder(BorderFactory.createCompoundBorder(
				new LineBorder(UIHelper.COLOR_BORDE, 1),
				BorderFactory.createEmptyBorder(0, 10, 0, 10)));
		panel.add(textFieldNombre);

		// Campo: Contraseña
		JLabel lblContrasena = new JLabel("Contraseña:");
		lblContrasena.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblContrasena.setForeground(UIHelper.COLOR_TEXTO);
		lblContrasena.setBounds(80, 180, 100, 20);
		panel.add(lblContrasena);

		textFieldContrasena = new JPasswordField();
		textFieldContrasena.setBounds(80, 203, 340, 32);
		textFieldContrasena.setBackground(UIHelper.COLOR_TARJETA);
		textFieldContrasena.setForeground(UIHelper.COLOR_TEXTO);
		textFieldContrasena.setCaretColor(UIHelper.COLOR_TEXTO);
		textFieldContrasena.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textFieldContrasena.setBorder(BorderFactory.createCompoundBorder(
				new LineBorder(UIHelper.COLOR_BORDE, 1),
				BorderFactory.createEmptyBorder(0, 10, 0, 10)));
		panel.add(textFieldContrasena);

		// Campo: Mail
		JLabel lblMail = new JLabel("Correo electrónico:");
		lblMail.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblMail.setForeground(UIHelper.COLOR_TEXTO);
		lblMail.setBounds(80, 245, 150, 20);
		panel.add(lblMail);

		textFieldMail = new JTextField();
		textFieldMail.setBounds(80, 268, 340, 32);
		textFieldMail.setBackground(UIHelper.COLOR_TARJETA);
		textFieldMail.setForeground(UIHelper.COLOR_TEXTO);
		textFieldMail.setCaretColor(UIHelper.COLOR_TEXTO);
		textFieldMail.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textFieldMail.setBorder(BorderFactory.createCompoundBorder(
				new LineBorder(UIHelper.COLOR_BORDE, 1),
				BorderFactory.createEmptyBorder(0, 10, 0, 10)));
		panel.add(textFieldMail);

		// Campo: Rol
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblRol.setForeground(UIHelper.COLOR_TEXTO);
		lblRol.setBounds(80, 310, 100, 20);
		panel.add(lblRol);

		textFieldRol = new JTextField();
		textFieldRol.setBounds(80, 333, 340, 32);
		textFieldRol.setBackground(UIHelper.COLOR_TARJETA);
		textFieldRol.setForeground(UIHelper.COLOR_TEXTO);
		textFieldRol.setCaretColor(UIHelper.COLOR_TEXTO);
		textFieldRol.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textFieldRol.setBorder(BorderFactory.createCompoundBorder(
				new LineBorder(UIHelper.COLOR_BORDE, 1),
				BorderFactory.createEmptyBorder(0, 10, 0, 10)));
		panel.add(textFieldRol);

		// Botones
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnAceptar.setBounds(80, 395, 160, 38);
		btnAceptar.setBackground(UIHelper.COLOR_ACCENTO);
		btnAceptar.setForeground(UIHelper.COLOR_TEXTO);
		btnAceptar.setFocusPainted(false);
		btnAceptar.setBorder(BorderFactory.createEmptyBorder());
		panel.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnCancelar.setBounds(260, 395, 160, 38);
		btnCancelar.setBackground(UIHelper.COLOR_TARJETA);
		btnCancelar.setForeground(UIHelper.COLOR_TEXTO);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1));
		panel.add(btnCancelar);

		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

	private void setForeground(Color colorTexto) {
		// TODO Auto-generated method stub

	}
}
