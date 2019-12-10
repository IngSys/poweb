package pe.org.pub.eess.poe.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class LogUtil {
	
	/**
     * M�todo que obtiene la traza de una excepci�n generada en alg�n m�todo.
     * @param excepcion Excepci�n generada, tipo Exception.
     * @return traza Traza de la excepci�n generada, tipo String.
     */
    public static String obtenerTrazaExcepcion(Exception excepcion) {
        StringWriter cadenaError = new StringWriter();
        PrintWriter cadenaImpresion = new PrintWriter(cadenaError);
        excepcion.printStackTrace(cadenaImpresion);
        String traza = cadenaError.toString();
        return traza;
    }

}
