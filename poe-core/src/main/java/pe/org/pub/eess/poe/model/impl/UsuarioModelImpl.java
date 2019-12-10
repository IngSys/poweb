package pe.org.pub.eess.poe.model.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.org.pub.eess.poe.domain.Personareferencia;
import pe.org.pub.eess.poe.domain.Usuario;
import pe.org.pub.eess.poe.model.UsuarioModel;

//import oracle.jdbc.driver.OracleTypes;

@Repository
public class UsuarioModelImpl implements UsuarioModel {

	Logger log = Logger.getLogger(UsuarioModelImpl.class);

	@PersistenceContext(unitName = "poeJpa")
	private EntityManager em;

	@Autowired
	private DataSource poeDS;

	public Usuario findUsuario(String aplicacion, String usuario) {
		Usuario user = null;
		/*
		 * logger.info("usuario::: " + usuario);
		 * 
		 * Usuario user = null; Connection conn = null; CallableStatement csmt = null;
		 * ResultSet rs = null; try { conn = poeDS.getConnection(); csmt =
		 * conn.prepareCall("call unsch.get_seguridad_usuario(?,?)"); csmt.setString(1,
		 * usuario); csmt.registerOutParameter(2, postgresql.CURSOR); csmt.execute(); rs
		 * = (ResultSet) csmt.getObject(2); if (rs.next()) { user = new Usuario();
		 * logger.info("usuario nombre:: " + rs.getString("user_name"));
		 * 
		 * user.setLogin(rs.getString("user_name"));
		 * user.setPasword(rs.getString("password"));
		 * user.setEstado(String.valueOf(rs.getInt("enabled") == 1)); } } catch
		 * (Exception excepcion) { logger.error(excepcion.getMessage()); } finally { //
		 * finally block used to close resources try { if (csmt != null) csmt.close(); }
		 * catch (SQLException se2) { } // nothing we can do try { if (conn != null)
		 * conn.close(); } catch (SQLException se) { se.printStackTrace(); } // end
		 * finally try }
		 */
		return user;
	}

	@Override
	public Usuario getUsuarioById(Integer id) {
		Usuario usuario = null;
		try {
			usuario = this.em.find(Usuario.class, id);

		} catch (Exception e) {
			log.info("================ERROR AL BUSCAR USUARIO POR ID================================");
		}

		return usuario;
	}

}
