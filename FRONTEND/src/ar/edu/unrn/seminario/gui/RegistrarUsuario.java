
package ar.edu.unrn.seminario.gui;

import ar.edu.unrn.seminario.helpers.UIHelper;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import ar.edu.unrn.seminario.exception.UsuarioExistenteException;
import ar.edu.unrn.seminario.exception.RolNoEncontradoException;
import ar.edu.unrn.seminario.api.IApi;

public class RegistrarUsuario {

    private JFrame frame;
    private JTextField textFieldNombre;
    private JPasswordField textFieldContrasena;
    private JTextField textFieldMail;
    private JTextField textFieldRol;
    private JTextField textFieldUsuario;

    // Guardo la API que utiliza el sistema.
    private IApi api;

    // Recibo la misma API que utiliza VentanaPrincipal.
    public RegistrarUsuario(IApi api) {
        this.api = api;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Registrar Usuario - EmuSwing");
        frame.setBounds(100, 100, 1280, 720);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);

        // Uso los colores definidos en UIHelper.
        frame.getContentPane().setBackground(UIHelper.COLOR_FONDO);

        // JMenuBar centrado estilo Home
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(UIHelper.COLOR_FONDO);
        menuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, UIHelper.COLOR_CONTENIDO));
        menuBar.add(javax.swing.Box.createHorizontalGlue());

        JMenu mnPerfil = new JMenu("Mi Perfil");
        mnPerfil.setForeground(UIHelper.COLOR_TEXTO);
        mnPerfil.setFont(new Font("SansSerif", Font.PLAIN, 13));
        menuBar.add(mnPerfil);

        // Abro la ventana Mi Perfil.
        mnPerfil.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                VentanaMiPerfil ventana = new VentanaMiPerfil();
                ventana.setVisible(true);
            }
        });

        JMenu mnBiblioteca = new JMenu("Biblioteca");
        mnBiblioteca.setForeground(UIHelper.COLOR_TEXTO);
        mnBiblioteca.setFont(new Font("SansSerif", Font.PLAIN, 13));
        menuBar.add(mnBiblioteca);

        // Abro la ventana Biblioteca.
        mnBiblioteca.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Biblioteca.main(new String[0]);
            }
        });

        JMenu mnJuegos = new JMenu("Juegos");
        mnJuegos.setForeground(UIHelper.COLOR_TEXTO);
        mnJuegos.setFont(new Font("SansSerif", Font.PLAIN, 13));
        menuBar.add(mnJuegos);

        // Abro Juegos pasando la misma API.
        mnJuegos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ListadoJuegos ventana = new ListadoJuegos(api);
                ventana.setVisible(true);
            }
        });

        JMenu mnTienda = new JMenu("Tienda");
        mnTienda.setForeground(UIHelper.COLOR_TEXTO);
        mnTienda.setFont(new Font("SansSerif", Font.PLAIN, 13));
        menuBar.add(mnTienda);

        // Abro la ventana Tienda.
        mnTienda.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                VentanaTienda ventana = new VentanaTienda();
                ventana.setVisible(true);
            }
        });

        JMenu mnSoporte = new JMenu("Soporte");
        mnSoporte.setForeground(UIHelper.COLOR_TEXTO);
        mnSoporte.setFont(new Font("SansSerif", Font.PLAIN, 13));
        menuBar.add(mnSoporte);

        JMenu mnAjustes = new JMenu("Ajustes");
        mnAjustes.setForeground(UIHelper.COLOR_TEXTO);
        mnAjustes.setFont(new Font("SansSerif", Font.PLAIN, 13));
        menuBar.add(mnAjustes);

        // Abro la ventana Configuración.
        mnAjustes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                VentanaConfiguracion ventana = new VentanaConfiguracion(api,"bjgorosito");
                ventana.setVisible(true);
            }
        });

        menuBar.add(javax.swing.Box.createHorizontalGlue());
        frame.setJMenuBar(menuBar);

        // Panel Central de Formulario
        JPanel panel = new JPanel();
        panel.setBackground(UIHelper.COLOR_CONTENIDO);
        panel.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1, true));
        panel.setBounds(390, 90, 500, 550);
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
        lblSubtitulo.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
        lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblSubtitulo.setBounds(0, 65, 500, 20);
        panel.add(lblSubtitulo);

        // Campo: Nombre
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblNombre.setForeground(UIHelper.COLOR_TEXTO);
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

        // Campo: Nombre de usuario
        // Agrego el campo para ingresar el username.
        JLabel lblUsuario = new JLabel("Nombre de usuario:");
        lblUsuario.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblUsuario.setForeground(UIHelper.COLOR_TEXTO);
        lblUsuario.setBounds(80, 180, 160, 20);
        panel.add(lblUsuario);

        textFieldUsuario = new JTextField();
        textFieldUsuario.setBounds(80, 203, 340, 32);
        textFieldUsuario.setBackground(UIHelper.COLOR_TARJETA);
        textFieldUsuario.setForeground(UIHelper.COLOR_TEXTO);
        textFieldUsuario.setCaretColor(UIHelper.COLOR_TEXTO);
        textFieldUsuario.setFont(new Font("SansSerif", Font.PLAIN, 13));
        textFieldUsuario.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(UIHelper.COLOR_BORDE, 1),
                BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        panel.add(textFieldUsuario);

        // Campo: Contraseña
        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblContrasena.setForeground(UIHelper.COLOR_TEXTO);
        lblContrasena.setBounds(80, 245, 100, 20);
        panel.add(lblContrasena);

        textFieldContrasena = new JPasswordField();
        textFieldContrasena.setBounds(80, 268, 340, 32);
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
        lblMail.setBounds(80, 310, 150, 20);
        panel.add(lblMail);

        textFieldMail = new JTextField();
        textFieldMail.setBounds(80, 333, 340, 32);
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
        lblRol.setBounds(80, 375, 100, 20);
        panel.add(lblRol);

        textFieldRol = new JTextField();
        textFieldRol.setBounds(80, 398, 340, 32);
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
        btnAceptar.setBounds(80, 460, 160, 38);
        btnAceptar.setBackground(UIHelper.COLOR_ACENTO);
        btnAceptar.setForeground(UIHelper.COLOR_TEXTO);
        btnAceptar.setFocusPainted(false);
        btnAceptar.setBorder(BorderFactory.createEmptyBorder());
        panel.add(btnAceptar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnCancelar.setBounds(260, 460, 160, 38);
        btnCancelar.setBackground(UIHelper.COLOR_TARJETA);
        btnCancelar.setForeground(UIHelper.COLOR_TEXTO);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setBorder(new LineBorder(UIHelper.COLOR_BORDE, 1));
        panel.add(btnCancelar);

        // Cierro la ventana sin registrar nada.
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        // Registro los datos cuando presionan Aceptar.
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Obtengo los datos ingresados en el formulario.
                String nombre = textFieldNombre.getText().trim();
                String username = textFieldUsuario.getText().trim();
                String password = new String(textFieldContrasena.getPassword());
                String email = textFieldMail.getText().trim();
                String rolTexto = textFieldRol.getText().trim();

                // Compruebo que no haya campos vacíos.
                if (nombre.isEmpty() || username.isEmpty() || password.isEmpty()
                        || email.isEmpty() || rolTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Complete todos los campos.");
                    return;
                }

                Integer rol;
                try {
                    // Convierto el código del rol a un entero.
                    rol = Integer.parseInt(rolTexto);

                } catch (NumberFormatException ex) {
                    // Muestro un error si el rol no es numérico.
                    JOptionPane.showMessageDialog(frame, "Ingrese un código de rol válido.");
                    return;
                }

                try {
                    // Envío los datos a la API para registrar.
                    api.registrarUsuario(username, password, email, nombre, rol);

                    // Muestro la confirmación del registro.
                    JOptionPane.showMessageDialog(frame, "Usuario registrado correctamente.");

                    // Limpio los campos después de registrar.
                    textFieldNombre.setText("");
                    textFieldUsuario.setText("");
                    textFieldContrasena.setText("");
                    textFieldMail.setText("");
                    textFieldRol.setText("");

                } catch (UsuarioExistenteException ex) {
                    // Muestro el error si el username ya existe.
                    JOptionPane.showMessageDialog(frame, ex.getMessage());

                } catch (RolNoEncontradoException ex) {
                    // Muestro el error si el rol no existe.
                    JOptionPane.showMessageDialog(frame, ex.getMessage());

                } catch (IllegalArgumentException ex) {
                    // Muestro el error si los datos son inválidos.
                    JOptionPane.showMessageDialog(frame, ex.getMessage());
                }
            }
        });
    }

    // Muestro la ventana desde VentanaPrincipal.
    public void mostrar() {
        frame.setVisible(true);
    }
}
