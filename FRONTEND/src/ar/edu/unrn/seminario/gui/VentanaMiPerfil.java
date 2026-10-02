package ar.edu.unrn.seminario.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class VentanaMiPerfil extends JFrame {

	// Colores y fuentes exactas extraídas del Helper de tu compañero.
	// Al tenerlos acá, evitamos el problema de conexión entre los módulos en Eclipse.
	private final Color COLOR_FONDO = new Color(24, 10, 32);
	private final Color COLOR_CONTENIDO = new Color(50, 22, 66);
	private final Color COLOR_ACENTO = new Color(191, 90, 224);
	private final Color COLOR_TEXTO = new Color(245, 240, 247);
	
	private final Font FONT_TITULO = new Font("Segoe UI", Font.BOLD, 28);
	private final Font FONT_SECCION = new Font("Segoe UI", Font.BOLD, 14);
	private final Font FONT_SUBTITULO = new Font("Segoe UI", Font.PLAIN, 13);
	private final Font FONT_BOTON = new Font("Segoe UI", Font.BOLD, 15);

	public VentanaMiPerfil() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 865, 620);
		getContentPane().setBackground(COLOR_FONDO);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(COLOR_CONTENIDO);
		panel.setBounds(10, 32, 829, 218);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon iconoOriginal = new ImageIcon("FRONTEND/src/img/esw-logo.png");
		Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		lblNewLabel_1.setIcon(new ImageIcon(imagenEscalada));
		lblNewLabel_1.setBorder(new LineBorder(COLOR_ACENTO, 1));
		lblNewLabel_1.setBounds(20, 20, 120, 120);
		panel.add(lblNewLabel_1);
		
		JButton btnCambiarFoto = new JButton("Cambiar foto");
		btnCambiarFoto.setFocusPainted(false);
		btnCambiarFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCambiarFoto.setBackground(COLOR_FONDO);
		btnCambiarFoto.setForeground(COLOR_TEXTO);
		btnCambiarFoto.setBorder(new LineBorder(COLOR_ACENTO, 1));
		btnCambiarFoto.setFont(FONT_BOTON);
		btnCambiarFoto.setBounds(20, 151, 120, 23);
		panel.add(btnCambiarFoto);
		
		JLabel lblNombreUsuario = new JLabel("MendoAttack");
		lblNombreUsuario.setForeground(COLOR_TEXTO);
		lblNombreUsuario.setFont(FONT_TITULO);
		lblNombreUsuario.setBounds(160, 40, 300, 40);
		panel.add(lblNombreUsuario);
		
		JLabel lblPlanSuscripcion = new JLabel("Plan: PREMIUM");
		lblPlanSuscripcion.setForeground(COLOR_ACENTO); 
		lblPlanSuscripcion.setFont(FONT_SECCION);
		lblPlanSuscripcion.setBounds(160, 91, 150, 20);
		panel.add(lblPlanSuscripcion);
		
		JLabel lblNewLabel = new JLabel("Mi Perfil");
		lblNewLabel.setForeground(COLOR_TEXTO);
		lblNewLabel.setFont(FONT_SECCION);
		lblNewLabel.setBounds(10, 11, 100, 20);
		getContentPane().add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(COLOR_CONTENIDO);
		panel_1.setBorder(BorderFactory.createTitledBorder(
				new LineBorder(COLOR_ACENTO, 1), 
				"Datos de la Cuenta", 
				TitledBorder.LEADING, 
				TitledBorder.TOP, 
				FONT_SECCION, 
				COLOR_TEXTO));
		panel_1.setBounds(10, 261, 411, 290);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario: Mendoza");
		lblNewLabel_2.setForeground(COLOR_TEXTO);
		lblNewLabel_2.setFont(FONT_SUBTITULO);
		lblNewLabel_2.setBounds(10, 63, 200, 16);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email: Mendoza@example.com");
		lblNewLabel_3.setForeground(COLOR_TEXTO);
		lblNewLabel_3.setFont(FONT_SUBTITULO);
		lblNewLabel_3.setBounds(10, 88, 250, 16);
		panel_1.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Cambiar Contraseña");
		btnNewButton.setBackground(COLOR_FONDO);
		btnNewButton.setForeground(COLOR_TEXTO);
		btnNewButton.setBorder(new LineBorder(COLOR_ACENTO, 1));
		btnNewButton.setFont(FONT_BOTON);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBounds(150, 148, 153, 23);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Modificar Contraseña");
		lblNewLabel_4.setForeground(COLOR_TEXTO);
		lblNewLabel_4.setFont(FONT_SUBTITULO);
		lblNewLabel_4.setBounds(10, 152, 130, 16);
		panel_1.add(lblNewLabel_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(COLOR_CONTENIDO);
		panel_2.setBorder(BorderFactory.createTitledBorder(
				new LineBorder(COLOR_ACENTO, 1), 
				"Estadísticas", 
				TitledBorder.LEADING, 
				TitledBorder.TOP, 
				FONT_SECCION, 
				COLOR_TEXTO));
		panel_2.setBounds(428, 261, 411, 290);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Horas Jugadas: 120 hs");
		lblNewLabel_5.setForeground(COLOR_TEXTO);
		lblNewLabel_5.setFont(FONT_SUBTITULO);
		lblNewLabel_5.setBounds(41, 62, 200, 16);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Juegos Emulados: 8");
		lblNewLabel_6.setForeground(COLOR_TEXTO);
		lblNewLabel_6.setFont(FONT_SUBTITULO);
		lblNewLabel_6.setBounds(41, 98, 200, 16);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblJuegosRecientes = new JLabel("Juegos Recientes:");
		lblJuegosRecientes.setForeground(COLOR_TEXTO);
		lblJuegosRecientes.setFont(FONT_SUBTITULO);
		lblJuegosRecientes.setBounds(41, 140, 200, 16);
		panel_2.add(lblJuegosRecientes);
		
		JLabel lblListaJuegos = new JLabel("<html>- Doom (Freedoom)<br>- Cave Story<br>- Street Fighter</html>");
		lblListaJuegos.setForeground(COLOR_TEXTO);
		lblListaJuegos.setFont(FONT_SUBTITULO);
		lblListaJuegos.setBounds(41, 165, 300, 60);
		panel_2.add(lblListaJuegos);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(COLOR_FONDO);
		btnVolver.setForeground(COLOR_TEXTO);
		btnVolver.setBorder(new LineBorder(COLOR_ACENTO, 1));
		btnVolver.setFont(FONT_BOTON);
		btnVolver.setBounds(729, 555, 110, 23);
		btnVolver.setFocusPainted(false);
		getContentPane().add(btnVolver);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMiPerfil frame = new VentanaMiPerfil();
					frame.setLocationRelativeTo(null); 
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}