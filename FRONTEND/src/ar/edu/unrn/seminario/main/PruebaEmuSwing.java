package ar.edu.unrn.seminario.main;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;

import ar.edu.unrn.seminario.api.IApi;
import ar.edu.unrn.seminario.api.MemoryApi;
import ar.edu.unrn.seminario.gui.VentanaJuego;

public class PruebaEmuSwing {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                IApi api = new MemoryApi();
                VentanaJuego ventana = new VentanaJuego(
                    api.getUrlJuegoByTitulo("Super Street Fighter II")
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
