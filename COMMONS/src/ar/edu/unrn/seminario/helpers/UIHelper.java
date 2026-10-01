package ar.edu.unrn.seminario.helpers;

import java.awt.Color;
import java.awt.Font;

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

    // FUENTES
    public static final Font FONT_TITULO = new Font("Segoe UI", Font.BOLD, 28);
    public static final Font FONT_BOTON = new Font("Segoe UI", Font.BOLD, 15);
    public static final Font FONT_SUBTITULO = new Font("Segoe UI", Font.PLAIN, 13);
    public static final Font FONT_SECCION = new Font("Segoe UI", Font.BOLD, 14);
    public static final Font FONT_MENU = new Font("Segoe UI", Font.PLAIN, 14);
    public static final Font FONT_TARJETA = new Font("Segoe UI", Font.BOLD, 13);

    //
    // DIMENSIONES (en px) -- si se quiere agrandar o achicar las portadas de los
    // juegos ajustar aca
    public static final int ANCHO_PORTADA = 150;
    public static final int ALTO_PORTADA = 180;
    public static final int ANCHO_TARJETA = 180;
    public static final int ALTO_TARJETA = 220;
    public static final int ANCHO_CONTENIDO = 980;
    public static final int ALTO_CONTENIDO = 470;
}
