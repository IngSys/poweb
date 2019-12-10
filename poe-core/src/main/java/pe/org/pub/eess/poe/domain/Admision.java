package pe.org.pub.eess.poe.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the admision database table.
 * 
 */
@Entity
@NamedQuery(name="Admision.findAll", query="SELECT a FROM Admision a")
public class Admision implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idadmision;

	@Column(name="codcla_caso")
	private String codclaCaso;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fch_admision")
	private Date fchAdmision;

	@Temporal(TemporalType.DATE)
	@Column(name="fch_ultimo_control")
	private Date fchUltimoControl;

	@Temporal(TemporalType.DATE)
	private Date fchresys;

	@Column(name="nro_ficha")
	private String nroFicha;

	private String selector;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private Paciente paciente;

	public Admision() {
	}

	public Integer getIdadmision() {
		return this.idadmision;
	}

	public void setIdadmision(Integer idadmision) {
		this.idadmision = idadmision;
	}

	public String getCodclaCaso() {
		return this.codclaCaso;
	}

	public void setCodclaCaso(String codclaCaso) {
		this.codclaCaso = codclaCaso;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFchAdmision() {
		return this.fchAdmision;
	}

	public void setFchAdmision(Date fchAdmision) {
		this.fchAdmision = fchAdmision;
	}

	public Date getFchUltimoControl() {
		return this.fchUltimoControl;
	}

	public void setFchUltimoControl(Date fchUltimoControl) {
		this.fchUltimoControl = fchUltimoControl;
	}

	public Date getFchresys() {
		return this.fchresys;
	}

	public void setFchresys(Date fchresys) {
		this.fchresys = fchresys;
	}

	public String getNroFicha() {
		return this.nroFicha;
	}

	public void setNroFicha(String nroFicha) {
		this.nroFicha = nroFicha;
	}

	public String getSelector() {
		return this.selector;
	}

	public void setSelector(String selector) {
		this.selector = selector;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}