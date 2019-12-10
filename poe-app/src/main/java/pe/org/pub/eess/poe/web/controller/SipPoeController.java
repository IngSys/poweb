/*package pe.org.pub.eess.poe.web.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.org.pub.eess.poe.util.Constantes;
import pe.org.pub.eess.poe.util.LogUtil;
import pe.org.pub.eess.poe.web.seguridad.SesionContext;

@Controller
@SessionAttributes({"userNameSesion"}) 
public class SipPoeController {
    
    Logger logger  = Logger.getLogger(SipPoeController.class+"========PRUEBA REALIZADAEN SipPoeController========");
    

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String setupFormLogin(Model model, HttpServletRequest request) {
		logger.info("para entrar al login");
		model.addAttribute("message", "");
		return "acceso/login";
	}
	
	
    @RequestMapping(value="/privado/pagina", method=RequestMethod.GET)
    public String showPagina(@RequestParam("pagina") String pagina) {
            return pagina;     
    } 

    @RequestMapping(value="/test/pagina", method=RequestMethod.GET)
    public String showPaginaPublico(@RequestParam("pagina") String pagina) {
            return pagina;     
    }
    
	@RequestMapping(value="/loginFailed", method=RequestMethod.GET)
	public String loginFailed(ModelMap model) {
		return "acceso/login";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(ModelMap model) {
		logger.info("logout");
		return "acceso/login";
	}
	
	
	@RequestMapping(value="/privado/menu", method = { RequestMethod.GET, RequestMethod.POST })
	public String showMenu( HttpServletRequest request, Model model, Principal principal) {
		HttpSession session =   request.getSession();
		try{
			SesionContext sesionContext = new SesionContext();
		    session = request.getSession(true);
		    session.removeAttribute("lstMenu");
		    session.removeAttribute(Constantes.SESION_CONTEXT);
			
    		
    		session.setAttribute(Constantes.SESION_CONTEXT, sesionContext);
    		
    		
    		
           
    		
	    } catch(Exception ex) {
			logger.error(LogUtil.obtenerTrazaExcepcion(ex));
		}
        return "sistema/menu";
    }
	
}*/
