/*
Para renderizar el juego en un JPanel, se utiliza la biblioteca JCEF (Java Chromium Embedded Framework)

Ver docu:
- https://github.com/chromiumembedded/java-cef
- https://chromiumembedded.github.io/java-cef/building_openjdk.html


IMPORTANTE
- tener configurado java 8 en eclipse. Ver run -> run configurations -> JREs

Agrego
- builder.addJcefArgs("--disable-gpu");
- browser = client.createBrowser(urlJuego, true, false);
- builder.getCefSettings().windowless_rendering_enabled = true;

porque sino la pantalla se queda en negro
*/
package ar.edu.unrn.seminario.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import javax.swing.JPanel;
import me.friwi.jcefmaven.CefAppBuilder;
import org.cef.CefApp;
import org.cef.CefClient;
import org.cef.browser.CefBrowser;
import ar.edu.unrn.seminario.gui.EmuladorWeb;


public class EmuladorWeb extends JPanel {

    private static final long serialVersionUID = 1L;

    private CefApp cefApp;
    private CefClient client;
    private CefBrowser browser;

    public EmuladorWeb(String urlJuego) throws Exception {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        if (urlJuego == null || urlJuego.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "La URL del juego no puede estar vacía"
            );
        }

        inicializarNavegador(urlJuego);
    }

    private void inicializarNavegador(String urlJuego) throws Exception {
        String sistema = System.getProperty("os.name").toLowerCase();
        // En Windows el OSR causa problemas de rendimiento y compatibilidad
        boolean usarOSR = !sistema.contains("win");

        CefAppBuilder builder = new CefAppBuilder();

        // OSR significa Off-Screen Rendering, que permite renderizar el contenido del navegador sin necesidad de una ventana nativa. Permite mas control sobre apariencia y comportamiento del navegador.
        builder.getCefSettings().windowless_rendering_enabled = usarOSR;

        // esto me permite que el navegador funcione en sistemas donde no hay GPU o aceleración gráfica.
        builder.addJcefArgs("--disable-gpu");

        File cacheDir = new File(
            System.getProperty("user.home"),
            ".emuswing/cef-cache"
        );
        // guarda una pequeña cache para mejorar el rendimiento, contiene: recursos de la web, cookies, historial, etc. Se puede borrar si se quiere liberar espacio o resetear el navegador)

        if (!cacheDir.exists() && !cacheDir.mkdirs()) {
            throw new IllegalStateException(
                "No se pudo crear la carpeta de caché de EmuSwing"
            );
        }

        builder.getCefSettings().root_cache_path =
            cacheDir.getAbsolutePath();


        cefApp = builder.build();
        // cefApp seria el proceso principal que gestiona la vida útil del navegador y sus recursos
        client = cefApp.createClient();

        browser = client.createBrowser(urlJuego, usarOSR, false);
        add(browser.getUIComponent(), BorderLayout.CENTER);
    }

    public void cerrar() {
        // cierra la instancia y libera los recursos asociados al navegador, cliente y aplicación CEF
        if (browser != null) {
            browser.close(true);
            browser = null;
        }

        if (client != null) {
            client.dispose();
            client = null;
        }

        if (cefApp != null) {
            cefApp.dispose();
            cefApp = null;
        }
    }
}
