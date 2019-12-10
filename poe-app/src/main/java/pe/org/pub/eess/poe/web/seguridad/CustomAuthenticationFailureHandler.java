//package pe.org.pub.eess.poe.web.seguridad;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationServiceException;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.LockedException;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
//import org.springframework.security.web.authentication.session.SessionAuthenticationException;
//
//import pe.org.pub.eess.poe.service.UsuarioService;
//
//
//
//public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
//
//	@Autowired
//	private UsuarioService usuarioService;
//	
//	@Override
//	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
//		throws IOException, ServletException {
//		
//		try {
//			Integer nroIntentos = request.getParameter("nroIntentos") != "" ? Integer.parseInt(request.getParameter("nroIntentos")) : 0;
//			
//			String usuario = request.getParameter("j_username");
//			HttpSession session = request.getSession();
//			setDefaultFailureUrl("/loginFailed");
//			
//			if(exception.getClass().isAssignableFrom(BadCredentialsException.class)) {
//				//session.setAttribute("message", "ERROR: Credenciales erroneas.");
//				session.setAttribute("message", "ERROR: Validación Incorrecta");
//				//seguridadService.actualizarIntentosFallidos(usuario);
//			} else if (exception.getClass().isAssignableFrom(AuthenticationServiceException.class)) {
//				session.setAttribute("message", "ERROR: Validación Incorrecta");
//			} else if (exception.getClass().isAssignableFrom(SessionAuthenticationException.class)) {
//				//session.setAttribute("message", "ERROR: Ud. ha excedido el número de sessiones permitidas.");
//			} else if (exception.getClass().isAssignableFrom(LockedException.class)) {
//				session.setAttribute("message", "ERROR: Caracteres Incorrectos");
//				//session.setAttribute("message", "ERROR: Usuario Bloqueado");
//			} 
//			
//			nroIntentos =  new Integer(nroIntentos + 1);
//			request.getSession().setAttribute("nroIntentos", nroIntentos);
//			
//			super.onAuthenticationFailure(request, response, exception);
//		} catch (Exception e) {
//			e.getStackTrace();
//		}
//	}
//}
