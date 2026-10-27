package ar.edu.unrn.seminario.main;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;

import ar.edu.unrn.seminario.gui.VentanaJuego;

public class PruebaEmuSwing {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                VentanaJuego ventana = new VentanaJuego(
                    "https://archive.org/embed/Super_Street_Fighter_II_USA.md"
                );

                ventana.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();

                JOptionPane.showMessageDialog(
                    null,
                    "Error al iniciar el juego:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }
}
