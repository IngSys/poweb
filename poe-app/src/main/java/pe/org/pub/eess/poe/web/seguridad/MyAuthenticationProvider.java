//package pe.org.pub.eess.poe.web.seguridad;
//
//import java.util.ArrayList;
//
//
//import org.apache.log4j.Logger;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import pe.org.pub.eess.poe.service.UsuarioService;
//import pe.org.pub.eess.poe.domain.Usuario;
//
//
//
//
//
//
////import com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet;
//
//public class MyAuthenticationProvider implements UserDetailsService {
//
//	private static final Logger logger = Logger.getLogger(MyAuthenticationProvider.class);
//	
//	@Autowired
//	private UsuarioService usuarioService;
//
//	private String aplicacion;
//	
//	//private CaptchaCaptureFilter captchaCaptureFilter;
//		
//	public MyAuthenticationProvider(String aplicacion) {
//		super();
//		logger.info(aplicacion);
//		this.aplicacion = aplicacion;
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws AuthenticationException{
//		UserDetails user = null;
//		//Captcha captcha;		
//		
//		logger.info("paso  por aqui ");
//		
//		try {
//			Usuario userDB = usuarioService.findUsuario(this.aplicacion, username.toUpperCase());
//			
//			logger.info("paso  por aqui :::... "+userDB.toString());
//			
//			
//			if (userDB != null) {
//				
//				logger.info("paso 13333");
//				
//			//	logger.info("paso captchaCaptureFilter.getUserRequest()  "+captchaCaptureFilter.getUserRequest());
//				
//				/*if (captchaCaptureFilter.getUserRequest() != null) {
//					HttpSession session = captchaCaptureFilter.getUserRequest().getSession();
//					captcha = (Captcha) session.getAttribute(Captcha.NAME);
//					
//					logger.info("paso 4445555");
//					
//					if (captchaCaptureFilter.getUserCaptchaResponse() != null ) {
//	                    boolean captchaResult = captcha.isCorrect(captchaCaptureFilter.getUserCaptchaResponse());
//        			    user = new User(userDB.getUserName(), userDB.getPassword(),Boolean.valueOf( userDB.getEnabled()), true, true, captchaResult, new ArrayList<GrantedAuthority>());
//					}
//					captchaCaptureFilter.setUserRequest(null);
//		            captchaCaptureFilter.setUserCaptchaResponse(null);
//				}else {*/
//					user = new User(userDB.getLogin(), userDB.getPasword(), Boolean.valueOf(userDB.getEstado()), true, true, true, new ArrayList<GrantedAuthority>());
//				//}
//			} else {
//				throw new UsernameNotFoundException("Error login no existe usuario");
//			}
//		} catch (Exception e) {
//			e.getStackTrace();
//		}
//		
//		return user;
//	}
//
//	
//	
//}
