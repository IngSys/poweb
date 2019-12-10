package pe.org.pub.eess.poe.service.impl;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.org.pub.eess.poe.domain.Usuario;
import pe.org.pub.eess.poe.model.UsuarioModel;
import pe.org.pub.eess.poe.service.UsuarioService;



@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
	
	
	Logger logger  = Logger.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private UsuarioModel  usuarioModel;

	public Usuario findUsuario(String aplicacion, String usuario) {
		return usuarioModel.findUsuario(aplicacion, usuario);
	}

	@Override
	public Usuario getUsuarioById(Integer id) {
		// TODO Auto-generated method stub
		return usuarioModel.getUsuarioById(id);
	}

	
}
