package pe.org.pub.eess.poe.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the personareferencia database table.
 * 
 */
@Entity
@NamedQuery(name="Personareferencia.findAll", query="SELECT p FROM Personareferencia p")
public class Personareferencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idpersonareferencia;

	@Column(name="ape_materno")
	private String apeMaterno;

	@Column(name="ape_paterno")
	private String apePaterno;

	@Column(name="cod_genero")
	private String codGenero;

	@Column(name="codtip_parentesco")
	private String codtipParentesco;

	@Column(name="dir_referencia")
	private String dirReferencia;

	private String dni;

	@Temporal(TemporalType.DATE)
	private Date fchresys;

	private String nombre;

	private String telefono;

	public Personareferencia() {
	}

	public Integer getIdpersonareferencia() {
		return this.idpersonareferencia;
	}

	public void setIdpersonareferencia(Integer idpersonareferencia) {
		this.idpersonareferencia = idpersonareferencia;
	}

	public String getApeMaterno() {
		return this.apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getApePaterno() {
		return this.apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getCodGenero() {
		return this.codGenero;
	}

	public void setCodGenero(String codGenero) {
		this.codGenero = codGenero;
	}

	public String getCodtipParentesco() {
		return this.codtipParentesco;
	}

	public void setCodtipParentesco(String codtipParentesco) {
		this.codtipParentesco = codtipParentesco;
	}

	public String getDirReferencia() {
		return this.dirReferencia;
	}

	public void setDirReferencia(String dirReferencia) {
		this.dirReferencia = dirReferencia;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFchresys() {
		return this.fchresys;
	}

	public void setFchresys(Date fchresys) {
		this.fchresys = fchresys;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}