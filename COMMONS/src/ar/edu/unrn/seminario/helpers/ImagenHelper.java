package ar.edu.unrn.seminario.helpers;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
/*

Recibir una URL.
Descargar la imagen en segundo plano.
Redimensionarla al tamaño del componente.
Mostrarla en el JLabel.
Mostrar una imagen predeterminada si falla la descarga.

- SwingWorker: descarga en segundo plano.
- ImageIO: lectura de imágenes.
- BufferedImage: manipulación y escalado.
- ConcurrentHashMap: caché de imágenes descargadas.


EJEMPLO DE COVER PARA CARGAR: 
    https://dn721803.ca.archive.org/0/items/Super_Street_Fighter_II_USA.md/00_coverscreenshot.png [FUNCIONA]
    https://dn710107.ca.archive.org/0/items/street-fighter-ii-snes-hiresscans/Street%20Fighter%20II%20-%20Box%20Front.jpg
    https://upload.wikimedia.org/wikipedia/en/1/1d/SF2_JPN_flyer.jpg [TIRA ERROR 403]
    https://en.wikipedia.org/w/index.php?curid=10642320%22

    */



public final class ImagenHelper {

    private ImagenHelper() {
    }

    public static void cargarImagen(String urlImagen, JLabel etiqueta, int ancho, int alto) {
        etiqueta.setIcon(null);
        etiqueta.setText("Cargando...");

        if (urlImagen == null || urlImagen.trim().isEmpty()) {
            etiqueta.setText("No se pudo cargar la imagen");
            return;
        }

        new SwingWorker<ImageIcon, Void>() {

            @Override
            protected ImageIcon doInBackground() throws Exception {
                URL url = new URL(urlImagen);
                if (!"https".equalsIgnoreCase(url.getProtocol())) {
                    throw new IOException("Solo se permiten URL HTTPS");
                }

                URLConnection conexion = url.openConnection();
                conexion.setConnectTimeout(5000);
                conexion.setReadTimeout(8000);

                BufferedImage original;
                try (InputStream entrada = conexion.getInputStream()) {
                    original = ImageIO.read(entrada);
                }

                if (original == null) {
                    throw new IOException("El recurso no es una imagen válida");
                }

                BufferedImage escalada = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g = escalada.createGraphics();
                try {
                    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                    double escala = Math.min((double) ancho / original.getWidth(),
                            (double) alto / original.getHeight());
                    int nuevoAncho = (int) (original.getWidth() * escala);
                    int nuevoAlto = (int) (original.getHeight() * escala);
                    int x = (ancho - nuevoAncho) / 2;
                    int y = (alto - nuevoAlto) / 2;
                    g.drawImage(original, x, y, nuevoAncho, nuevoAlto, null);
                } finally {
                    g.dispose();
                }

                return new ImageIcon(escalada);
            }

            @Override
            protected void done() {
                try {
                    etiqueta.setIcon(get());
                    etiqueta.setText("");
                } catch (Exception e) {
                    etiqueta.setIcon(null);
                    etiqueta.setText("No se pudo cargar la imagen");
                    System.err.println("No se pudo cargar la portada: " + e.getMessage());
                }
            }
        }.execute();
    }
}
