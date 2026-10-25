/*
package ar.edu.unrn.seminario.main;
import ar.edu.unrn.seminario.gui.EmuladorWeb;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

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
*/

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
