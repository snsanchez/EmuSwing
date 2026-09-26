package ar.edu.unrn.seminario.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import java.awt.Image;

public class VentanaMiPerfil extends JFrame {
	// Establecemos la paleta de colores
	public static final Color FONDO_OSCURO = new Color(35, 15, 45);
	public static final Color FONDO_CLARO  = new Color(74, 36, 92);
	public static final Color COLOR_BORDE  = new Color(169, 65, 196);
	public static final Color COLOR_TEXTO  = new Color(245, 240, 247);

	public VentanaMiPerfil() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 865, 620);
		getContentPane().setBackground(FONDO_OSCURO);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(FONDO_CLARO);
		panel.setBounds(10, 32, 829, 218);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");		// Cargar y achicar la imagen a 120x120
		ImageIcon iconoOriginal = new ImageIcon("C:\\Users\\Joaco\\Documents\\GitHub\\EmuSwing\\EmuSwing\\FRONTEND\\Recursos\\Foto de perfil EmuSwing.jpeg");
		Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		lblNewLabel_1.setIcon(new ImageIcon(imagenEscalada));

		lblNewLabel_1.setBorder(new LineBorder(COLOR_BORDE, 1));
		lblNewLabel_1.setBounds(20, 20, 120, 120);
		panel.add(lblNewLabel_1);
		
		JButton btnCambiarFoto = new JButton("Cambiar foto");
		btnCambiarFoto.setFocusPainted(false);  	// Para que no quede el JButoon marcado cuando lo seleccionan
		btnCambiarFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCambiarFoto.setBackground(FONDO_OSCURO);
		btnCambiarFoto.setForeground(COLOR_TEXTO);
		btnCambiarFoto.setBorder(new LineBorder(COLOR_BORDE, 1));
		btnCambiarFoto.setBounds(20, 151, 120, 23);
		panel.add(btnCambiarFoto);
		
		JLabel lblNombreUsuario = new JLabel("MendoAttack");
		lblNombreUsuario.setForeground(COLOR_TEXTO);
		lblNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNombreUsuario.setBounds(160, 40, 200, 40);
		panel.add(lblNombreUsuario);
		
		JLabel lblPlanSuscripcion = new JLabel("Plan: PREMIUM");
		lblPlanSuscripcion.setForeground(COLOR_BORDE); 
		lblPlanSuscripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPlanSuscripcion.setBounds(160, 91, 150, 20);
		panel.add(lblPlanSuscripcion);
		
		JLabel lblNewLabel = new JLabel("Mi Perfil");
		lblNewLabel.setForeground(COLOR_TEXTO);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 100, 14);
		getContentPane().add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(FONDO_CLARO);
		panel_1.setBorder(BorderFactory.createTitledBorder(
				new LineBorder(COLOR_BORDE, 1), 
				"Datos de la Cuenta", 
				TitledBorder.LEADING, 
				TitledBorder.TOP, 
				new Font("Tahoma", Font.BOLD, 11), 
				COLOR_TEXTO));
		panel_1.setBounds(10, 261, 411, 290);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario: Mendoza");
		lblNewLabel_2.setForeground(COLOR_TEXTO);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 63, 200, 16);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email: Mendoza@example.com");
		lblNewLabel_3.setForeground(COLOR_TEXTO);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 88, 250, 16);
		panel_1.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Cambiar Contraseña");
		btnNewButton.setBackground(FONDO_OSCURO);
		btnNewButton.setForeground(COLOR_TEXTO);
		btnNewButton.setBorder(new LineBorder(COLOR_BORDE, 1));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBounds(150, 148, 153, 23);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Modificar Contraseña");
		lblNewLabel_4.setForeground(COLOR_TEXTO);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(10, 152, 130, 16);
		panel_1.add(lblNewLabel_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(FONDO_CLARO);
		panel_2.setBorder(BorderFactory.createTitledBorder(
				new LineBorder(COLOR_BORDE, 1), 
				"Estadísticas", 
				TitledBorder.LEADING, 
				TitledBorder.TOP, 
				new Font("Tahoma", Font.BOLD, 11), 
				COLOR_TEXTO));
		panel_2.setBounds(428, 261, 411, 290);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Horas Jugadas: 120 hs");
		lblNewLabel_5.setForeground(COLOR_TEXTO);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(41, 62, 200, 16);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Juegos Emulados: 8");
		lblNewLabel_6.setForeground(COLOR_TEXTO);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(41, 98, 200, 16);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblJuegosRecientes = new JLabel("Juegos Recientes:");
		lblJuegosRecientes.setForeground(COLOR_TEXTO);
		lblJuegosRecientes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblJuegosRecientes.setBounds(41, 140, 200, 16);
		panel_2.add(lblJuegosRecientes);
		
		JLabel lblListaJuegos = new JLabel("<html>- Doom (Freedoom)<br>- Cave Story<br>- Street Fighter</html>");
		lblListaJuegos.setForeground(COLOR_TEXTO);
		lblListaJuegos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblListaJuegos.setBounds(41, 165, 300, 60);
		panel_2.add(lblListaJuegos);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(FONDO_OSCURO);
		btnVolver.setForeground(COLOR_TEXTO);
		btnVolver.setBorder(new LineBorder(COLOR_BORDE, 1));
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