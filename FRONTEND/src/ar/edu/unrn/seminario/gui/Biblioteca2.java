package ar.edu.unrn.seminario.gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Panel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Biblioteca2 {

	private JFrame frame;
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
					Biblioteca2 window = new Biblioteca2();
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
	public Biblioteca2() {
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
		frame.setSize(700, 400);
		frame.setBackground(FONDO_CLARO);
		frame.getContentPane().setBackground(FONDO_OSCURO);
		JButton button = new JButton("<-");
		button.setBounds(120, 110, 45, 130);
		frame.getContentPane().add(button);
		button.setBackground(LETRAS);
		
		Panel panel = new Panel();
		panel.setBounds(221, 71, 210, 196);
		frame.getContentPane().add(panel);
		panel.setBackground(LETRAS);
		
		JButton button_1 = new JButton("->");
		button_1.setBounds(482, 110, 45, 130);
		frame.getContentPane().add(button_1);
		button_1.setBackground(LETRAS);
		
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPlay.setBounds(276, 281, 105, 27);
		frame.getContentPane().add(btnPlay);
		btnPlay.setBackground(LETRAS);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(276, 38, 105, 27);
		frame.getContentPane().add(btnRemove);
		btnRemove.setBackground(LETRAS);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		menuBar.setBackground(LETRAS);
		
		JMenu mnOpt = new JMenu("opt");
		menuBar.add(mnOpt);
		mnOpt.setBackground(LETRAS);
		
		JMenuItem mntmMenu = new JMenuItem("Menu");
		mnOpt.add(mntmMenu);
		
		
		JMenuItem mntmVerTodos = new JMenuItem("Ver todos");
		mnOpt.add(mntmVerTodos);
	}
}
