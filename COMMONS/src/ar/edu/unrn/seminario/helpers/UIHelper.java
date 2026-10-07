package ar.edu.unrn.seminario.helpers;

import java.awt.Color;
import java.awt.Font;
import java.io.InputStream;

/*
--- Como usar el helper en el frontend
1. Mirar si FRONTEND tenga configurado Java Build Path para que conozca a COMMONS
2. import ar.edu.unrn.seminario.helpers.UIHelper;
3. usar sus funciones de clase

ejemplo de uso:
    panel.setBackground(UIHelper.COLOR_FONDO);
    lblTitulo.setFont(UIHelper.FONT_TITULO);
*/
public class UIHelper {

    // PALETA DE COLORES
    public static final Color COLOR_FONDO = new Color(24, 10, 32);
    public static final Color COLOR_CONTENIDO = new Color(50, 22, 66);
    public static final Color COLOR_TARJETA = new Color(64, 30, 82);
    public static final Color COLOR_TARJETA_HOVER = new Color(82, 40, 104);
    public static final Color COLOR_ACENTO = new Color(191, 90, 224);
    public static final Color COLOR_ACENTO_HOVER = new Color(206, 130, 235);
    public static final Color COLOR_TEXTO = new Color(245, 240, 247);
    public static final Color COLOR_TEXTO_SECUNDARIO = new Color(196, 180, 206);
	public static final Color COLOR_BORDE = new Color(153, 50, 204);


    // FUENTES
    public static final Font FONT_TITULO = cargarFuente("/fonts/PublicPixel.ttf", 20);
    public static final Font FONT_BOTON = cargarFuente("/fonts/PublicPixel.ttf", 13);
    public static final Font FONT_LABEL = cargarFuente("/fonts/PublicPixel.ttf", 10);
    public static final Font FONT_TEXTFIELDS = cargarFuente("/fonts/PublicPixel.ttf", 13);
    public static final Font FONT_SUBTITULO = cargarFuente("/fonts/PublicPixel.ttf", 13);
    public static final Font FONT_SECCION = cargarFuente("/fonts/PublicPixel.ttf", 14);
    public static final Font FONT_MENU = cargarFuente("/fonts/PublicPixel.ttf", 14);
    public static final Font FONT_TARJETA = cargarFuente("/fonts/PublicPixel.ttf", 10);

    //
    // DIMENSIONES (en px) -- si se quiere agrandar o achicar las portadas de los
    // juegos ajustar aca
    public static final int ANCHO_PORTADA = 150;
    public static final int ALTO_PORTADA = 180;
    public static final int ANCHO_TARJETA = 180;
    public static final int ALTO_TARJETA = 220;
    public static final int ANCHO_CONTENIDO = 980;
    public static final int ALTO_CONTENIDO = 470;

    
    
    // metodo privado para traer la fuente de la carpeta /fonts
    private static Font cargarFuente(String ruta, float tamaño) {
        try (InputStream is = UIHelper.class.getResourceAsStream(ruta)) {

            if (is == null) {
                System.err.println("No se encontró la fuente: " + ruta);
                return new Font("SansSerif", Font.PLAIN, (int) tamaño);
            }

            Font fuente = Font.createFont(Font.TRUETYPE_FONT, is);
            return fuente.deriveFont(Font.PLAIN, tamaño);

        } catch (Exception e) {
            e.printStackTrace();
            return new Font("SansSerif", Font.PLAIN, (int) tamaño);
        }
    }
    

}


