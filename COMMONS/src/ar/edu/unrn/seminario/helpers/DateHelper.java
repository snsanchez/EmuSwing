package ar.edu.unrn.seminario.helpers;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateHelper {

    private static final String FORMATO_DIA_MES_ANIO = "%02d-%02d-%04d";

    public static String toString(Date d) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int dia = c.get(Calendar.DAY_OF_MONTH);
        int mes = c.get(Calendar.MONTH) + 1;
        int anio = c.get(Calendar.YEAR);
        return String.format(FORMATO_DIA_MES_ANIO, dia, mes, anio);
    }

    public static Date stringToDate(String fecha) throws ParseException {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
        return df.parse(fecha);
    }

}
