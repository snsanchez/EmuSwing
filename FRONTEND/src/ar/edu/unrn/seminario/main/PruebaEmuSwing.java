
package ar.edu.unrn.seminario.main;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import ar.edu.unrn.seminario.emulador.EmuladorWeb;

public class PruebaEmuSwing {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame ventana = new JFrame("EmuSwing - Prueba");
            ventana.setSize(1000, 700);
            ventana.setLocationRelativeTo(null);
            ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

            try {
                EmuladorWeb emulador = new EmuladorWeb(
                    "https://archive.org/embed/msdos_DOOM_1993"
                );

                ventana.add(emulador, BorderLayout.CENTER);

                ventana.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        emulador.cerrar();
                        ventana.dispose();
                    }
                });

                ventana.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();

                JOptionPane.showMessageDialog(
                    ventana,
                    "No se pudo iniciar el emulador:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );

                ventana.dispose();
            }
        });
    }
}
