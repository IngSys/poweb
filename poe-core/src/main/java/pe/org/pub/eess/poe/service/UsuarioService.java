package pe.org.pub.eess.poe.service;

import java.util.List;
import java.util.Map;

import pe.org.pub.eess.poe.domain.Usuario;

public interface UsuarioService {

	public Usuario findUsuario(String aplicacion, String usuario);
	public Usuario getUsuarioById(Integer id);

}
