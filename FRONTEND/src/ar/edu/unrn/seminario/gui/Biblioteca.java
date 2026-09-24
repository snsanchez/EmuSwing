package ar.edu.unrn.seminario.gui;

import java.awt.EventQueue;
import java.awt.Color; 
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSpinner;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Biblioteca {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Biblioteca window = new Biblioteca();
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
	public Biblioteca() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("BIBLIOTECA");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(700,400);
		Color FONDO_CLARO = new Color(74, 36, 92);
		Color FONDO_OSCURO = new Color(35, 15, 45);
	    Color BORDE = new Color(169, 65, 196);
	    Color LETRAS = new Color(245, 240, 247);
		frame.setBackground(FONDO_CLARO);
		frame.getContentPane().setBackground(FONDO_OSCURO);
	    
	    
	    
		table = new JTable();
		table.setBounds(33, 12, 638, 239);
		frame.getContentPane().add(table);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setBounds(174, 420, 105, 27);
		frame.getContentPane().add(btnPlay);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(424, 420, 105, 27);
		frame.getContentPane().add(btnRemove);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 392, 622, 18);
		frame.getContentPane().add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(125, 263, 452, 19);
		frame.getContentPane().add(scrollPane_1);
		
		JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
		
		
		
		scrollPane_1.setViewportView(scrollBar);
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(174, 294, 105, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRemove_1 = new JButton("Remove");
		btnRemove_1.setBounds(424, 294, 105, 27);
		frame.getContentPane().add(btnRemove_1);
		//scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		
		JButton btnHome = new JButton("Home");
		btnHome.setBackground(LETRAS);
		menuBar.add(btnHome);
		
		JMenu mnOrder = new JMenu("order");
		mnOrder.setBackground(LETRAS);
		menuBar.add(mnOrder);
		menuBar.setBackground(LETRAS);
		JMenuItem mntmNumber = new JMenuItem("number");
		mnOrder.add(mntmNumber);
		
		JMenuItem mntmOld = new JMenuItem("old");
		mnOrder.add(mntmOld);
		
		JMenuItem mntmNew = new JMenuItem("new");
		mnOrder.add(mntmNew);
	}
}
