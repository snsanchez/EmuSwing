package ar.edu.unrn.seminario.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicButtonUI;

public class CambiarContrasenia {

	private JFrame frame;

	private final Color COLOR_FONDO_MAIN = new Color(35, 15, 45);
	private final Color COLOR_PANEL_BOX = new Color(74, 36, 92);
	private final Color COLOR_BORDE_NEON = new Color(169, 65, 196);
	private final Color COLOR_LETRAS = new Color(245, 240, 247);

	private JPasswordField txtContraseniaActual;
	private JPasswordField txtNuevaContrasenia;
	private JPasswordField txtConfirmarContrasenia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CambiarContrasenia window = new CambiarContrasenia();
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
	public CambiarContrasenia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Cambiar contraseña");
		frame.setBounds(100, 100, 700, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().setBackground(COLOR_FONDO_MAIN);

		// Panel superior
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(COLOR_FONDO_MAIN);
		panelSuperior.setBorder(BorderFactory.createEmptyBorder(25, 0, 15, 0));
		frame.getContentPane().add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setLayout(new BorderLayout(0, 0));

		JLabel lblTitulo = new JLabel("CAMBIA TU CONTRASEÑA DE EMUSWING");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("OCR A Extended", Font.BOLD, 24));
		panelSuperior.add(lblTitulo, BorderLayout.NORTH);

		JLabel lblSubtitulo = new JLabel("Actualizá tu contraseña de acceso");
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo.setForeground(COLOR_BORDE_NEON);
		lblSubtitulo.setFont(new Font("Tahoma", Font.ITALIC, 16));
		panelSuperior.add(lblSubtitulo, BorderLayout.SOUTH);

		// Panel central
		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(COLOR_FONDO_MAIN);
		panelCentral.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
		frame.getContentPane().add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		JPanel panelFormulario = new JPanel();
		panelFormulario.setBackground(COLOR_PANEL_BOX);
		panelFormulario.setPreferredSize(new Dimension(500, 190));
		panelFormulario.setLayout(new GridLayout(3, 2, 10, 15));

		TitledBorder bordeFormulario = BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON),
				"Datos de contraseña"
		);
		bordeFormulario.setTitleColor(COLOR_LETRAS);

		panelFormulario.setBorder(BorderFactory.createCompoundBorder(
				bordeFormulario,
				BorderFactory.createEmptyBorder(25, 35, 25, 35)
		));

		panelCentral.add(panelFormulario);

		JLabel lblContraseniaActual = new JLabel("Contraseña actual:");
		lblContraseniaActual.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContraseniaActual.setForeground(COLOR_LETRAS);
		lblContraseniaActual.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelFormulario.add(lblContraseniaActual);

		txtContraseniaActual = new JPasswordField();
		panelFormulario.add(txtContraseniaActual);

		JLabel lblNuevaContrasenia = new JLabel("Nueva contraseña:");
		lblNuevaContrasenia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNuevaContrasenia.setForeground(COLOR_LETRAS);
		lblNuevaContrasenia.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelFormulario.add(lblNuevaContrasenia);

		txtNuevaContrasenia = new JPasswordField();
		panelFormulario.add(txtNuevaContrasenia);

		JLabel lblConfirmarContrasenia = new JLabel("Confirmar contraseña:");
		lblConfirmarContrasenia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmarContrasenia.setForeground(COLOR_LETRAS);
		lblConfirmarContrasenia.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelFormulario.add(lblConfirmarContrasenia);

		txtConfirmarContrasenia = new JPasswordField();
		panelFormulario.add(txtConfirmarContrasenia);

		// Panel inferior
		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(COLOR_FONDO_MAIN);
		panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 18));
		panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
		frame.getContentPane().add(panelInferior, BorderLayout.SOUTH);

		JButton btnGuardar = new JButton("Guardar cambios");
		btnGuardar.setUI(new BasicButtonUI());
		btnGuardar.setBackground(COLOR_FONDO_MAIN);
		btnGuardar.setForeground(COLOR_LETRAS);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGuardar.setFocusPainted(false);
		btnGuardar.setOpaque(true);
		btnGuardar.setContentAreaFilled(true);
		btnGuardar.setBorderPainted(true);
		btnGuardar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnGuardar.setPreferredSize(new Dimension(190, 40));
		btnGuardar.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(6, 16, 6, 16)
		));
		panelInferior.add(btnGuardar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setUI(new BasicButtonUI());
		btnCancelar.setBackground(COLOR_FONDO_MAIN);
		btnCancelar.setForeground(COLOR_LETRAS);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setOpaque(true);
		btnCancelar.setContentAreaFilled(true);
		btnCancelar.setBorderPainted(true);
		btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCancelar.setPreferredSize(new Dimension(190, 40));
		btnCancelar.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(COLOR_BORDE_NEON, 2),
				BorderFactory.createEmptyBorder(6, 16, 6, 16)
		));
		panelInferior.add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
	}
}