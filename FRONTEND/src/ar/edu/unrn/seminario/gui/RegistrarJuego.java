package ar.edu.unrn.seminario.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ar.edu.unrn.seminario.api.IApi;
import ar.edu.unrn.seminario.api.PersistenceApi;
import ar.edu.unrn.seminario.dao.JuegoDAOJDBC;
import ar.edu.unrn.seminario.helpers.UIHelper;
import ar.edu.unrn.seminario.modelo.Juego;

public class RegistrarJuego extends JFrame {

	private IApi api;

	private JTextField txtTitulo;
	private JTextField txtUrlEmulador;
	private JTextField txtUrlPortada;

	// Componentes de la Vista Previa
	private JLabel lblPreviewImagen;
	private JLabel lblPreviewTitulo;
	private JLabel lblPreviewEstado;

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(() -> {
			try {
				IApi apiReal = new PersistenceApi(new JuegoDAOJDBC());
				RegistrarJuego frame = new RegistrarJuego(apiReal);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public RegistrarJuego(IApi api) {
		this.api = api;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Registrar Juego - EmuSwing");
		setSize(750, 680);
		setLocationRelativeTo(null);

		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.setBackground(UIHelper.COLOR_FONDO);
		contentPane.setBorder(new EmptyBorder(25, 45, 25, 45));
		setContentPane(contentPane);

		// ---------- ENCABEZADO ----------
		JPanel panelHeader = new JPanel(new BorderLayout());
		panelHeader.setBackground(UIHelper.COLOR_FONDO);
		panelHeader.setBorder(new EmptyBorder(0, 0, 20, 0));

		JLabel lblTituloVentana = new JLabel("Registrar nuevo juego");
		lblTituloVentana.setFont(UIHelper.FONT_TITULO);
		lblTituloVentana.setForeground(UIHelper.COLOR_TEXTO);
		panelHeader.add(lblTituloVentana, BorderLayout.WEST);

		contentPane.add(panelHeader, BorderLayout.NORTH);

		// ---------- FORMULARIO CENTRAL ----------
		JPanel panelFormulario = new JPanel();
		panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));
		panelFormulario.setBackground(UIHelper.COLOR_CONTENIDO);
		panelFormulario.setBorder(new CompoundBorder(
				new LineBorder(UIHelper.COLOR_BORDE, 2, true),
				new EmptyBorder(25, 30, 25, 30)));

		// Campo 1: Nombre del juego
		panelFormulario.add(crearLabelCampo("Nombre del juego"));
		panelFormulario.add(Box.createRigidArea(new Dimension(0, 8)));
		txtTitulo = crearCampoTexto();
		panelFormulario.add(txtTitulo);
		panelFormulario.add(Box.createRigidArea(new Dimension(0, 20)));

		// Campo 2: URL del emulador
		panelFormulario.add(crearLabelCampo("URL del emulador (Internet Archive)"));
		panelFormulario.add(Box.createRigidArea(new Dimension(0, 8)));
		txtUrlEmulador = crearCampoTexto();
		panelFormulario.add(txtUrlEmulador);
		panelFormulario.add(Box.createRigidArea(new Dimension(0, 20)));

		// Campo 3: URL de portada
		panelFormulario.add(crearLabelCampo("URL de portada"));
		panelFormulario.add(Box.createRigidArea(new Dimension(0, 8)));
		txtUrlPortada = crearCampoTexto();
		panelFormulario.add(txtUrlPortada);
		panelFormulario.add(Box.createRigidArea(new Dimension(0, 25)));

		// ---------- SECCIÓN VISTA PREVIA ----------
		JLabel lblTituloPreview = new JLabel("VISTA PREVIA DE PORTADA");
		lblTituloPreview.setFont(UIHelper.FONT_LABEL);
		lblTituloPreview.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
		lblTituloPreview.setAlignmentX(LEFT_ALIGNMENT);
		panelFormulario.add(lblTituloPreview);
		panelFormulario.add(Box.createRigidArea(new Dimension(0, 10)));

		JPanel panelPreview = new JPanel(new BorderLayout(15, 0));
		panelPreview.setBackground(UIHelper.COLOR_TARJETA);
		panelPreview.setBorder(new CompoundBorder(
				new LineBorder(UIHelper.COLOR_BORDE, 1, true),
				new EmptyBorder(12, 15, 12, 15)));
		panelPreview.setMaximumSize(new Dimension(Integer.MAX_VALUE, 115));
		panelPreview.setAlignmentX(LEFT_ALIGNMENT);

		// Miniatura de portada
		lblPreviewImagen = new JLabel("Sin IMG", SwingConstants.CENTER);
		lblPreviewImagen.setPreferredSize(new Dimension(75, 90));
		lblPreviewImagen.setFont(UIHelper.FONT_LABEL);
		lblPreviewImagen.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
		lblPreviewImagen.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1));
		panelPreview.add(lblPreviewImagen, BorderLayout.WEST);

		// Textos de vista previa
		JPanel panelTextosPreview = new JPanel();
		panelTextosPreview.setLayout(new BoxLayout(panelTextosPreview, BoxLayout.Y_AXIS));
		panelTextosPreview.setBackground(UIHelper.COLOR_TARJETA);

		lblPreviewTitulo = new JLabel("Título del juego...");
		lblPreviewTitulo.setFont(UIHelper.FONT_SECCION);
		lblPreviewTitulo.setForeground(UIHelper.COLOR_TEXTO);

		lblPreviewEstado = new JLabel("Esperando URL de portada");
		lblPreviewEstado.setFont(UIHelper.FONT_LABEL);
		lblPreviewEstado.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);

		JLabel lblSubNota = new JLabel("Vista previa ilustrativa");
		lblSubNota.setFont(UIHelper.FONT_LABEL);
		lblSubNota.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);

		panelTextosPreview.add(lblPreviewTitulo);
		panelTextosPreview.add(Box.createRigidArea(new Dimension(0, 8)));
		panelTextosPreview.add(lblPreviewEstado);
		panelTextosPreview.add(Box.createRigidArea(new Dimension(0, 8)));
		panelTextosPreview.add(lblSubNota);

		panelPreview.add(panelTextosPreview, BorderLayout.CENTER);
		panelFormulario.add(panelPreview);

		contentPane.add(panelFormulario, BorderLayout.CENTER);

		// ---------- PANEL INFERIOR (BOTONES) ----------
		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 15));
		panelBotones.setBackground(UIHelper.COLOR_FONDO);

		JButton btnCancelar = crearBoton("Cancelar", false);
		JButton btnRegistrar = crearBoton("Registrar juego", true);

		btnCancelar.addActionListener(e -> dispose());
		btnRegistrar.addActionListener(e -> registrarJuego());

		panelBotones.add(btnCancelar);
		panelBotones.add(btnRegistrar);
		contentPane.add(panelBotones, BorderLayout.SOUTH);

		// ---------- EVENTOS DE VISTA PREVIA ----------
		// Actualiza el título en tiempo real mientras escribe
		txtTitulo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String texto = txtTitulo.getText().trim();
				lblPreviewTitulo.setText(texto.isEmpty() ? "Título del juego..." : texto);
			}
		});

		// Carga la imagen cuando el usuario sale del campo URL de portada
		txtUrlPortada.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				cargarVistaPreviaImagen(txtUrlPortada.getText().trim());
			}
		});
	}

	private void cargarVistaPreviaImagen(String urlStr) {
		if (urlStr.isEmpty()) {
			lblPreviewImagen.setIcon(null);
			lblPreviewImagen.setText("Sin IMG");
			lblPreviewEstado.setText("Esperando URL de portada");
			lblPreviewEstado.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
			return;
		}

		lblPreviewEstado.setText("Cargando imagen...");
		lblPreviewEstado.setForeground(UIHelper.COLOR_PUNTOS);

		// Usamos SwingWorker para descargar la imagen sin tildar la ventana
		new SwingWorker<ImageIcon, Void>() {
			@Override
			protected ImageIcon doInBackground() throws Exception {
				URL url = new java.net.URI(urlStr).toURL();
				Image img = ImageIO.read(url);
				if (img == null) {
					throw new Exception("No es una imagen válida");
				}
				Image escalada = img.getScaledInstance(75, 90, Image.SCALE_SMOOTH);
				return new ImageIcon(escalada);
			}

			@Override
			protected void done() {
				try {
					ImageIcon icon = get();
					lblPreviewImagen.setText("");
					lblPreviewImagen.setIcon(icon);
					lblPreviewEstado.setText("Imagen cargada");
					lblPreviewEstado.setForeground(UIHelper.COLOR_EXITO);
				} catch (Exception ex) {
					lblPreviewImagen.setIcon(null);
					lblPreviewImagen.setText("Error");
					lblPreviewEstado.setText("URL inválida o inaccesible");
					lblPreviewEstado.setForeground(Color.RED);
				}
			}
		}.execute();
	}

	private void registrarJuego() {
		String titulo = txtTitulo.getText().trim();
		String urlEmulador = txtUrlEmulador.getText().trim();
		String urlPortada = txtUrlPortada.getText().trim();

		// Validación básica en frontend antes de armar el objeto
		if (titulo.isEmpty() || urlEmulador.isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"El nombre del juego y la URL del emulador son obligatorios.",
					"Campos incompletos",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		try {
			Juego nuevoJuego = new Juego(null, titulo, null, null, null, null, urlPortada, urlEmulador);

			api.registrarJuego(nuevoJuego);

			JOptionPane.showMessageDialog(this,
					"¡El juego \"" + titulo + "\" se registró correctamente en la base de datos!",
					"Registro Exitoso",
					JOptionPane.INFORMATION_MESSAGE);

			limpiarFormulario();

		} catch (IllegalArgumentException ex) {
			// Capturamos la excepción recomendada por el líder
			JOptionPane.showMessageDialog(this,
					ex.getMessage(),
					"Error de validación",
					JOptionPane.WARNING_MESSAGE);
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this,
					"Error al guardar el juego en la base de datos: " + ex.getMessage(),
					"Error de Persistencia",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void limpiarFormulario() {
		txtTitulo.setText("");
		txtUrlEmulador.setText("");
		txtUrlPortada.setText("");
		lblPreviewTitulo.setText("Título del juego...");
		lblPreviewImagen.setIcon(null);
		lblPreviewImagen.setText("Sin IMG");
		lblPreviewEstado.setText("Esperando URL de portada");
		lblPreviewEstado.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
	}

	private JLabel crearLabelCampo(String texto) {
		JLabel label = new JLabel(texto);
		label.setFont(UIHelper.FONT_LABEL);
		label.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
		label.setAlignmentX(LEFT_ALIGNMENT);
		return label;
	}

	private JTextField crearCampoTexto() {
		JTextField field = new JTextField();
		field.setFont(UIHelper.FONT_TEXTFIELDS);
		field.setBackground(UIHelper.COLOR_TARJETA);
		field.setForeground(UIHelper.COLOR_TEXTO);
		field.setCaretColor(UIHelper.COLOR_ACENTO);
		field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 38));
		field.setAlignmentX(LEFT_ALIGNMENT);
		field.setBorder(new CompoundBorder(
				new LineBorder(UIHelper.COLOR_BORDE, 1, true),
				new EmptyBorder(6, 10, 6, 10)));
		return field;
	}

	private JButton crearBoton(String texto, boolean primario) {
		JButton btn = new JButton(texto);
		btn.setFont(UIHelper.FONT_BOTON);
		btn.setFocusPainted(false);
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

		Color bgNormal = primario ? UIHelper.COLOR_ACENTO : UIHelper.COLOR_CONTENIDO;
		Color bgHover = primario ? UIHelper.COLOR_ACENTO_HOVER : UIHelper.COLOR_TARJETA_HOVER;

		btn.setBackground(bgNormal);
		btn.setForeground(primario ? UIHelper.COLOR_FONDO : UIHelper.COLOR_TEXTO);
		btn.setBorder(primario
				? new EmptyBorder(10, 22, 10, 22)
				: new CompoundBorder(new LineBorder(UIHelper.COLOR_ACENTO, 2, true), new EmptyBorder(8, 20, 8, 20)));

		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { btn.setBackground(bgHover); }
			@Override
			public void mouseExited(MouseEvent e) { btn.setBackground(bgNormal); }
		});

		return btn;
	}
}
