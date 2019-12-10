package pe.org.pub.eess.poe.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the diagnosticoreferencia database table.
 * 
 */
@Entity
@NamedQuery(name="Diagnosticoreferencia.findAll", query="SELECT d FROM Diagnosticoreferencia d")
public class Diagnosticoreferencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer iddxreferencia;

	@Temporal(TemporalType.DATE)
	@Column(name="fch_referencia")
	private Date fchReferencia;

	@Temporal(TemporalType.DATE)
	private Date fchresys;

	private String selector;

	//bi-directional many-to-one association to Establecimientosalud
	@ManyToOne
	@JoinColumn(name="idestablecimiento")
	private Establecimientosalud establecimientosalud;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private Paciente paciente;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="idservicio")
	private Servicio servicio;

	public Diagnosticoreferencia() {
	}

	public Integer getIddxreferencia() {
		return this.iddxreferencia;
	}

	public void setIddxreferencia(Integer iddxreferencia) {
		this.iddxreferencia = iddxreferencia;
	}

	public Date getFchReferencia() {
		return this.fchReferencia;
	}

	public void setFchReferencia(Date fchReferencia) {
		this.fchReferencia = fchReferencia;
	}

	public Date getFchresys() {
		return this.fchresys;
	}

	public void setFchresys(Date fchresys) {
		this.fchresys = fchresys;
	}

	public String getSelector() {
		return this.selector;
	}

	public void setSelector(String selector) {
		this.selector = selector;
	}

	public Establecimientosalud getEstablecimientosalud() {
		return this.establecimientosalud;
	}

	public void setEstablecimientosalud(Establecimientosalud establecimientosalud) {
		this.establecimientosalud = establecimientosalud;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}