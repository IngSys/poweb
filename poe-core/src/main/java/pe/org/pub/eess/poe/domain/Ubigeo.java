package pe.org.pub.eess.poe.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ubigeo database table.
 * 
 */
@Entity
@NamedQuery(name="Ubigeo.findAll", query="SELECT u FROM Ubigeo u")
public class Ubigeo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idubigeo;

	private String direccion;

	@Column(name="lug_ubigeo")
	private String lugUbigeo;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="iddistrito")
	private Distrito distrito;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private Paciente paciente;

	public Ubigeo() {
	}

	public Integer getIdubigeo() {
		return this.idubigeo;
	}

	public void setIdubigeo(Integer idubigeo) {
		this.idubigeo = idubigeo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLugUbigeo() {
		return this.lugUbigeo;
	}

	public void setLugUbigeo(String lugUbigeo) {
		this.lugUbigeo = lugUbigeo;
	}

	public Distrito getDistrito() {
		return this.distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}