package pe.org.pub.eess.poe.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class LogUtil {
	
	/**
     * Método que obtiene la traza de una excepción generada en algún método.
     * @param excepcion Excepción generada, tipo Exception.
     * @return traza Traza de la excepción generada, tipo String.
     */
    public static String obtenerTrazaExcepcion(Exception excepcion) {
        StringWriter cadenaError = new StringWriter();
        PrintWriter cadenaImpresion = new PrintWriter(cadenaError);
        excepcion.printStackTrace(cadenaImpresion);
        String traza = cadenaError.toString();
        return traza;
    }

}
