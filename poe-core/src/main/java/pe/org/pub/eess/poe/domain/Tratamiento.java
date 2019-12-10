package pe.org.pub.eess.poe.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tratamiento database table.
 * 
 */
@Entity
@NamedQuery(name="Tratamiento.findAll", query="SELECT t FROM Tratamiento t")
public class Tratamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idtratamiento;

	@Temporal(TemporalType.DATE)
	@Column(name="fch_final_tratamiento")
	private Date fchFinalTratamiento;

	@Temporal(TemporalType.DATE)
	@Column(name="fch_inicio_tratamiento")
	private Date fchInicioTratamiento;

	@Temporal(TemporalType.DATE)
	private Date fchresys;

	private String selector;

	//bi-directional many-to-one association to Detalletratamiento
	@ManyToOne
	@JoinColumn(name="iddetalle")
	private Detalletratamiento detalletratamiento;

	//bi-directional many-to-one association to Diagnosticohospital
	@ManyToOne
	@JoinColumn(name="iddxhospital")
	private Diagnosticohospital diagnosticohospital;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="idstatus")
	private Status status;

	public Tratamiento() {
	}

	public Integer getIdtratamiento() {
		return this.idtratamiento;
	}

	public void setIdtratamiento(Integer idtratamiento) {
		this.idtratamiento = idtratamiento;
	}

	public Date getFchFinalTratamiento() {
		return this.fchFinalTratamiento;
	}

	public void setFchFinalTratamiento(Date fchFinalTratamiento) {
		this.fchFinalTratamiento = fchFinalTratamiento;
	}

	public Date getFchInicioTratamiento() {
		return this.fchInicioTratamiento;
	}

	public void setFchInicioTratamiento(Date fchInicioTratamiento) {
		this.fchInicioTratamiento = fchInicioTratamiento;
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

	public Detalletratamiento getDetalletratamiento() {
		return this.detalletratamiento;
	}

	public void setDetalletratamiento(Detalletratamiento detalletratamiento) {
		this.detalletratamiento = detalletratamiento;
	}

	public Diagnosticohospital getDiagnosticohospital() {
		return this.diagnosticohospital;
	}

	public void setDiagnosticohospital(Diagnosticohospital diagnosticohospital) {
		this.diagnosticohospital = diagnosticohospital;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}