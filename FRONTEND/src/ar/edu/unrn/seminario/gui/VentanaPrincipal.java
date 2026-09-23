package ar.edu.unrn.seminario.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.edu.unrn.seminario.api.IApi;
import ar.edu.unrn.seminario.api.MemoryApi;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IApi api = new MemoryApi();
					VentanaPrincipal frame = new VentanaPrincipal(api);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(IApi api) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(1426, 780);
		// para que se abra la ventana centrada
		setLocationRelativeTo(null);    
		setResizable(false);   
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		// 10: horizontal. 5: vertical
		JPanel panelMenu = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));

		JButton btnBiblioteca = new JButton("Biblioteca");
		JButton btnJuegos = new JButton("Juegos");
		JButton btnTienda = new JButton("Tienda");
		JButton btnAjustes = new JButton("Ajustes");

		panelMenu.add(btnBiblioteca);
		panelMenu.add(btnJuegos);
		panelMenu.add(btnTienda);
		panelMenu.add(btnAjustes);

		menuBar.add(panelMenu);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		JPanel panelHome = new JPanel();
		contentPane.add(panelHome, BorderLayout.CENTER);

		JButton btnJugar = new JButton("Jugar");
		panelHome.add(btnJugar);
	}

}
