/*package pe.org.pub.eess.poe.web.seguridad;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


public class SesionContext {

	Logger logger = Logger.getLogger(SesionContext.class);
	
	private static SesionContext instancia;
	
	private Integer opcionActual;
	
	public SesionContext() {

	}

	public SesionContext getInstance() {
		try {
			ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			if(sra == null) {
				return null;
			} else {
				HttpServletRequest request = sra.getRequest();
				HttpSession session = request.getSession(false);
				instancia = (SesionContext) session.getAttribute("SesionContext");
				return instancia;
			}
		} catch (Exception excepcion) {
			logger.error(excepcion.getMessage());
			return null;
		}
	}


	
	public Integer getOpcionActual() {
		return opcionActual;
	}

	public void setOpcionActual(Integer opcionActual) {
		this.opcionActual = opcionActual;
	}


	
}*/
