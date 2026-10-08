package ar.edu.unrn.seminario.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.File;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ar.edu.unrn.seminario.helpers.UIHelper;

public class MisLogrosView extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MisLogrosView frame = new MisLogrosView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MisLogrosView() {


		setTitle("Mis Logros - Vitrina Personal");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1150, 750);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(UIHelper.COLOR_FONDO);
		contentPane.setLayout(new GridBagLayout());
		setContentPane(contentPane);

		// =====================================================
		// PANEL SUPERIOR: RESUMEN DEL JUGADOR
		// =====================================================
		JPanel panelResumen = new JPanel();
		panelResumen.setBackground(UIHelper.COLOR_CONTENIDO);
		panelResumen.setBorder(new CompoundBorder(
				new LineBorder(UIHelper.COLOR_BORDE, 2, true),
				new EmptyBorder(15, 20, 15, 20)));
		panelResumen.setLayout(new BorderLayout(10, 10));
		panelResumen.setPreferredSize(new Dimension(1050, 130));

		// Izquierda: usuario y rango
		JPanel panelInfoUser = new JPanel();
		panelInfoUser.setOpaque(false);
		panelInfoUser.setLayout(new GridLayout(2, 1, 0, 5));
		panelResumen.add(panelInfoUser, BorderLayout.WEST);

		JLabel lblUsuario = new JLabel("Player_67");
		lblUsuario.setFont(UIHelper.FONT_TITULO.deriveFont(34f));
		lblUsuario.setForeground(UIHelper.COLOR_TEXTO);
		panelInfoUser.add(lblUsuario);

		JLabel lblRango = new JLabel("Rango: Cazador de Tesoros");
		lblRango.setFont(UIHelper.FONT_TITULO);
		lblRango.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
		panelInfoUser.add(lblRango);

		// Derecha: puntaje total
		JPanel panelPuntaje = new JPanel();
		panelPuntaje.setOpaque(false);
		panelPuntaje.setLayout(new GridLayout(2, 1, 0, 5));
		panelResumen.add(panelPuntaje, BorderLayout.EAST);

		JLabel lblPuntosTitulo = new JLabel("PUNTOS TOTALES");
		lblPuntosTitulo.setFont(UIHelper.FONT_MENU);
		lblPuntosTitulo.setForeground(UIHelper.COLOR_TEXTO);
		lblPuntosTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		panelPuntaje.add(lblPuntosTitulo);

		JLabel lblPuntosValor = new JLabel("145 PTS");
		lblPuntosValor.setFont(UIHelper.FONT_MENU.deriveFont(Font.BOLD, 16f));
		lblPuntosValor.setForeground(UIHelper.COLOR_PUNTOS);
		lblPuntosValor.setHorizontalAlignment(SwingConstants.RIGHT);
		panelPuntaje.add(lblPuntosValor);

		// Abajo: barra de progreso con progressBar
		JPanel panelProgreso = new JPanel();
		panelProgreso.setOpaque(false);
		panelProgreso.setLayout(new BorderLayout(10, 0));
		panelResumen.add(panelProgreso, BorderLayout.SOUTH);

		JLabel lblProgresoTxt = new JLabel("Completado: 3/15");
		lblProgresoTxt.setFont(UIHelper.FONT_MENU.deriveFont(Font.PLAIN, 16f));
		lblProgresoTxt.setForeground(UIHelper.COLOR_TEXTO);
		panelProgreso.add(lblProgresoTxt, BorderLayout.WEST);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(20);
		progressBar.setBackground(UIHelper.COLOR_FONDO);
		progressBar.setForeground(UIHelper.COLOR_BORDE);
		progressBar.setBorder(BorderFactory.createLineBorder(UIHelper.COLOR_BORDE));
		panelProgreso.add(progressBar, BorderLayout.CENTER);

		
		// ubicacion correcta del panel de Player
		GridBagConstraints gbcResumen = new GridBagConstraints();
		gbcResumen.gridx = 0;
		gbcResumen.gridy = 0;
		gbcResumen.insets = new Insets(30, 0, 30, 0);
		gbcResumen.anchor = GridBagConstraints.NORTH;
		gbcResumen.fill = GridBagConstraints.NONE;
		contentPane.add(panelResumen, gbcResumen);

		// =====================================================
		// PANEL INFERIOR: LOGROS DESBLOQUEADOS (CON SCROLL)
		// =====================================================
		JPanel panelAbajo = new JPanel();
		panelAbajo.setOpaque(false);
		panelAbajo.setLayout(new BorderLayout(0, 15));
		panelAbajo.setPreferredSize(new Dimension(850, 400));

		JLabel lblTituloSeccion = new JLabel("LOGROS DESBLOQUEADOS");
		lblTituloSeccion.setFont(UIHelper.FONT_MENU);
		lblTituloSeccion.setForeground(UIHelper.COLOR_BORDE);
		lblTituloSeccion.setBorder(new CompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 0, UIHelper.COLOR_BORDE),
				new EmptyBorder(0, 0, 5, 0)));
		panelAbajo.add(lblTituloSeccion, BorderLayout.NORTH);

		JPanel panelListaLogros = new JPanel();
		panelListaLogros.setBackground(UIHelper.COLOR_FONDO);
		panelListaLogros.setLayout(new BoxLayout(panelListaLogros, BoxLayout.Y_AXIS));

		// --- TARJETA DESBLOQUEADA 1 ---
		JPanel panelLogro1 = new JPanel();
		panelLogro1.setBackground(UIHelper.COLOR_CONTENIDO);
		panelLogro1.setBorder(new CompoundBorder(BorderFactory.createLineBorder(UIHelper.COLOR_EXITO, 1), new EmptyBorder(10, 15, 10, 15)));
		panelLogro1.setMaximumSize(new Dimension(850, 75));
		panelLogro1.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelLogro1.setLayout(new BorderLayout(5, 5));
		panelListaLogros.add(panelLogro1);

		JPanel panelSup1 = new JPanel();
		panelSup1.setOpaque(false);
		panelSup1.setLayout(new BorderLayout());
		panelLogro1.add(panelSup1, BorderLayout.NORTH);

		JLabel lblTit1 = new JLabel("Primer Botonazo");
		lblTit1.setFont(UIHelper.FONT_MENU);
		lblTit1.setForeground(UIHelper.COLOR_TEXTO);
		panelSup1.add(lblTit1, BorderLayout.WEST);

		JLabel lblPts1 = new JLabel("10 PTS");
		lblPts1.setFont(UIHelper.FONT_TEXTFIELDS);
		lblPts1.setForeground(UIHelper.COLOR_PUNTOS);
		panelSup1.add(lblPts1, BorderLayout.EAST);

		JPanel panelInf1 = new JPanel();
		panelInf1.setOpaque(false);
		panelInf1.setLayout(new BorderLayout());
		panelLogro1.add(panelInf1, BorderLayout.CENTER);

		JLabel lblDesc1 = new JLabel("Iniciar cualquier juego por primera vez.");
		lblDesc1.setFont(UIHelper.FONT_TEXTFIELDS);
		lblDesc1.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
		panelInf1.add(lblDesc1, BorderLayout.WEST);

		JLabel lblFecha1 = new JLabel("Desbloqueado: 06/07/2026");
		lblFecha1.setFont(UIHelper.FONT_TARJETA);
		lblFecha1.setForeground(UIHelper.COLOR_EXITO);
		panelInf1.add(lblFecha1, BorderLayout.EAST);

		// Espaciador final (para que la última tarjeta no quede pegada al borde)
		panelListaLogros.add(Box.createVerticalStrut(10));

		JScrollPane scrollPane = new JScrollPane(panelListaLogros);
		scrollPane.setBorder(null);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.getVerticalScrollBar().setUnitIncrement(12);
		panelAbajo.add(scrollPane, BorderLayout.CENTER);

		GridBagConstraints gbcAbajo = new GridBagConstraints();
		gbcAbajo.gridx = 0;
		gbcAbajo.gridy = 1;
		gbcAbajo.weighty = 1.0;
		gbcAbajo.insets = new Insets(0, 0, 30, 0);
		gbcAbajo.fill = GridBagConstraints.VERTICAL;
		contentPane.add(panelAbajo, gbcAbajo);
	}
}



