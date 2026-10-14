package ar.edu.unrn.seminario.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import ar.edu.unrn.seminario.helpers.UIHelper;

public class VentanaRanking extends JFrame {
    private JPanel contentPane;
    private JTable tablaRanking;
    private DefaultTableModel modelo; 

    public VentanaRanking() {
        setTitle("EmuSwing - Top Jugadores");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 650); 
        setLocationRelativeTo(null); 

        contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBackground(UIHelper.COLOR_FONDO);
        contentPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0)); 
        setContentPane(contentPane);

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(UIHelper.COLOR_FONDO);

        JPanel panelNavegacion = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 15));
        panelNavegacion.setBackground(UIHelper.COLOR_FONDO); 
        String[] menuItems = {"Mi Perfil", "Biblioteca", "Juegos", "Tienda", "Soporte", "Ajustes"};
        for (String texto : menuItems) {
            JLabel lblMenu = new JLabel(texto);
            lblMenu.setForeground(UIHelper.COLOR_TEXTO_SECUNDARIO);
            lblMenu.setFont(UIHelper.FONT_MENU);
            lblMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
            panelNavegacion.add(lblMenu);
        }
        panelSuperior.add(panelNavegacion, BorderLayout.NORTH);


        // ---------- TÍTULO Y LOGO ----------
        JPanel panelTituloYLogo = new JPanel(new BorderLayout());
        panelTituloYLogo.setBackground(UIHelper.COLOR_FONDO);
        panelTituloYLogo.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20)); 

        JLabel contrapeso = new JLabel();
        contrapeso.setPreferredSize(new Dimension(260, 205)); 
        panelTituloYLogo.add(contrapeso, BorderLayout.WEST);

        JLabel lblTitulo = new JLabel("RANKING SEMANAL", SwingConstants.CENTER);
        lblTitulo.setForeground(UIHelper.COLOR_TEXTO);
        lblTitulo.setFont(UIHelper.FONT_TITULO); 
        
        lblTitulo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(UIHelper.COLOR_ACENTO, 2),
                BorderFactory.createEmptyBorder(10, 30, 10, 30) 
        ));

        JPanel panelContenedorTitulo = new JPanel(new GridBagLayout());
        panelContenedorTitulo.setBackground(UIHelper.COLOR_FONDO);
        panelContenedorTitulo.add(lblTitulo);
        
        panelTituloYLogo.add(panelContenedorTitulo, BorderLayout.CENTER);

        try {
            java.net.URL imgURL = getClass().getResource("/img/esw-logo.png");
            
            if (imgURL != null) {
                ImageIcon iconOriginal = new ImageIcon(imgURL);
                Image imagenEscalada = iconOriginal.getImage().getScaledInstance(260, 205, Image.SCALE_SMOOTH);
                JLabel lblLogo = new JLabel(new ImageIcon(imagenEscalada));
                panelTituloYLogo.add(lblLogo, BorderLayout.EAST);
            } else {
                System.out.println("Error: No se encontró el logo en /img/esw-logo.png");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        panelSuperior.add(panelTituloYLogo, BorderLayout.SOUTH);
        contentPane.add(panelSuperior, BorderLayout.NORTH);

        // --- TABLA DE RANKING ---
        String[] columnas = {"Posición", "Jugador", "Horas Jugadas", "Recompensa"};
        modelo = new DefaultTableModel(columnas, 0); 
        tablaRanking = new JTable(modelo);
        
        tablaRanking.setBackground(UIHelper.COLOR_CONTENIDO);
        tablaRanking.setForeground(UIHelper.COLOR_TEXTO);
        tablaRanking.setGridColor(UIHelper.COLOR_ACENTO);
        tablaRanking.setFont(UIHelper.FONT_SECCION);
        tablaRanking.setRowHeight(30);
        
        tablaRanking.getTableHeader().setBackground(UIHelper.COLOR_FONDO);
        tablaRanking.getTableHeader().setForeground(UIHelper.COLOR_ACENTO);
        tablaRanking.getTableHeader().setFont(UIHelper.FONT_SECCION);
        tablaRanking.getTableHeader().setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, UIHelper.COLOR_ACENTO));

        JScrollPane scrollPane = new JScrollPane(tablaRanking);
        scrollPane.getViewport().setBackground(UIHelper.COLOR_FONDO);
        scrollPane.setBorder(BorderFactory.createLineBorder(UIHelper.COLOR_ACENTO, 1));
        
        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.setBackground(UIHelper.COLOR_FONDO);
        panelCentro.setBorder(BorderFactory.createEmptyBorder(10, 40, 0, 40));
        panelCentro.add(scrollPane, BorderLayout.CENTER);
        
        contentPane.add(panelCentro, BorderLayout.CENTER);

        inicializarTop10Vacio();
    }

    private String obtenerRecompensa(int posicion) {
        switch (posicion) {
            case 1: return "Suscripción y 1000 puntos";
            case 2: return "Suscripción y 750 puntos";
            case 3: return "Suscripción y 500 puntos";
            case 4: return "Suscripción y 500 puntos";
            case 5: return "Suscripción y 250 puntos";
            case 6: return "250 puntos";
            case 7: return "200 puntos";
            case 8: return "150 puntos";
            case 9: return "100 puntos";
            case 10: return "100 puntos";
            default: return "-";
        }
    }

    private void inicializarTop10Vacio() {
        modelo.setRowCount(0); 
        for (int i = 1; i <= 10; i++) {
            modelo.addRow(new Object[]{i, "---", "---", obtenerRecompensa(i)});
        }
    }

    public void cargarHighScores(Object[][] jugadoresReales) {
        inicializarTop10Vacio(); 
        for (Object[] fila : jugadoresReales) {
            int posicion = Integer.parseInt(fila[0].toString());
            if (posicion <= 10) {
                modelo.setValueAt(fila[1], posicion - 1, 1); 
                modelo.setValueAt(fila[2], posicion - 1, 2); 
            } else {
                String recompensa = obtenerRecompensa(posicion);
                Object[] filaNueva = {fila[0], fila[1], fila[2], recompensa};
                modelo.addRow(filaNueva);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaRanking frame = new VentanaRanking();
            Object[][] datosPrueba = {
                {"1", "tobytur3r", "340"}, {"2", "Thimbo", "295"},
                {"3", "san2", "250"}, {"4", "tuquini", "210"},
                {"5", "pepe", "180"}, {"6", "ramon", "145"},
                {"7", "messi", "120"}, {"8", "ronaldo", "90"},
                {"9", "quintero", "65"}, {"10", "soteldo", "30"}
            };
            frame.cargarHighScores(datosPrueba);
            frame.setVisible(true); 
        });
    }
}