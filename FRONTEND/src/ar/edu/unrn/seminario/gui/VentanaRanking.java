package ar.edu.unrn.seminario.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaRanking extends JFrame {
    private JPanel contentPane;
    private JTable tablaRanking;
    private DefaultTableModel modelo; 

    public VentanaRanking() {
        setTitle("EmuSwing - Top Jugadores");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 500); 
        setLocationRelativeTo(null); 


        contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBackground(PaletaRetro.FONDO_OSCURO);
        contentPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0)); 
        setContentPane(contentPane);


        JPanel panelSuperior = new JPanel(new BorderLayout(0, 20));
        panelSuperior.setBackground(PaletaRetro.FONDO_OSCURO);


        JPanel panelNavegacion = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panelNavegacion.setBackground(PaletaRetro.FONDO_OSCURO); 
        panelNavegacion.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, PaletaRetro.BORDE)); 

        String[] botonesMenu = {"Mi Perfil", "Biblioteca", "Juegos", "Tienda", "Soporte", "Ajustes"};
        for (String textoBtn : botonesMenu) {
            JButton btn = new JButton(textoBtn);
            btn.setBackground(PaletaRetro.FONDO_CLARO);
            btn.setForeground(PaletaRetro.TEXTO);
            btn.setFont(new Font("Monospaced", Font.BOLD, 12));
            btn.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(PaletaRetro.BORDE, 1),
                    BorderFactory.createEmptyBorder(5, 15, 5, 15) 
            ));
            btn.setFocusPainted(false);
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            panelNavegacion.add(btn);
        }
        panelSuperior.add(panelNavegacion, BorderLayout.NORTH);

   
        JLabel lblTitulo = new JLabel("RANKING SEMANAL", SwingConstants.CENTER);
        lblTitulo.setForeground(PaletaRetro.TEXTO);
        lblTitulo.setFont(new Font("Monospaced", Font.BOLD, 24)); 
        panelSuperior.add(lblTitulo, BorderLayout.SOUTH);

        contentPane.add(panelSuperior, BorderLayout.NORTH);


        String[] columnas = {"Posición", "Jugador", "Horas Jugadas", "Recompensa"};
        modelo = new DefaultTableModel(columnas, 0); 
        tablaRanking = new JTable(modelo);
        

        tablaRanking.setBackground(PaletaRetro.FONDO_CLARO);
        tablaRanking.setForeground(PaletaRetro.TEXTO);
        tablaRanking.setGridColor(PaletaRetro.BORDE);
        tablaRanking.setFont(new Font("Monospaced", Font.PLAIN, 14));
        
        tablaRanking.getTableHeader().setBackground(PaletaRetro.FONDO_OSCURO);
        tablaRanking.getTableHeader().setForeground(PaletaRetro.TEXTO);
        tablaRanking.getTableHeader().setFont(new Font("Monospaced", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(tablaRanking);
        scrollPane.getViewport().setBackground(PaletaRetro.FONDO_OSCURO);
        scrollPane.setBorder(BorderFactory.createLineBorder(PaletaRetro.BORDE, 2));
        
        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.setBackground(PaletaRetro.FONDO_OSCURO);
        panelCentro.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
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
                modelo.setValueAt(fila[1], posicion - 1, 1); // Jugador
                modelo.setValueAt(fila[2], posicion - 1, 2); // Horas
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
                {"1", "tobytur3r", "340"},
                {"2", "Thimbo", "295"},
                {"3", "san2", "250"},
                {"4", "tuquini", "210"},
                {"5", "pepe", "180"},
                {"6", "ramon", "145"},
                {"7", "messi", "120"},
                {"8", "ronaldo", "90"},
                {"9", "quintero", "65"},
                {"10", "soteldo", "30"}
            };
            
            frame.cargarHighScores(datosPrueba);
            frame.setVisible(true); 
        });
    }
}
