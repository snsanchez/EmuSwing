/*
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
        boolean usarOSR = !sistema.contains("win");

        CefAppBuilder builder = new CefAppBuilder();
        builder.getCefSettings().windowless_rendering_enabled = usarOSR;

        builder.addJcefArgs("--disable-gpu");

        File cacheDir = new File(
            System.getProperty("user.home"),
            ".emuswing/cef-cache"
        );

        if (!cacheDir.exists() && !cacheDir.mkdirs()) {
            throw new IllegalStateException(
                "No se pudo crear la carpeta de caché de EmuSwing"
            );
        }

        builder.getCefSettings().root_cache_path =
            cacheDir.getAbsolutePath();


        cefApp = builder.build();
        client = cefApp.createClient();

        browser = client.createBrowser(urlJuego, usarOSR, false);
        // El primer true solicita renderizado sin ventana nativa para ese navegador; el segundo false mantiene desactivada la transparencia
        add(browser.getUIComponent(), BorderLayout.CENTER);
    }

    public void cerrar() {
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
