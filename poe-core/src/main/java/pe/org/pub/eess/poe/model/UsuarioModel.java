package pe.org.pub.eess.poe.model;

import pe.org.pub.eess.poe.domain.Personareferencia;
import pe.org.pub.eess.poe.domain.Usuario;

public interface UsuarioModel {
	public Usuario findUsuario(String aplicacion, String usuario);
	public Usuario getUsuarioById(Integer id);

}
