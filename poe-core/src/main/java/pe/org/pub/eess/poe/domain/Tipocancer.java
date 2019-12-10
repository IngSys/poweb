package pe.org.pub.eess.poe.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipocancer database table.
 * 
 */
@Entity
@NamedQuery(name="Tipocancer.findAll", query="SELECT t FROM Tipocancer t")
public class Tipocancer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idtipocancer;

	private String denominacion;

	//bi-directional many-to-one association to Diagnosticohospital
	@OneToMany(mappedBy="tipocancer")
	private List<Diagnosticohospital> diagnosticohospitals;

	public Tipocancer() {
	}

	public Integer getIdtipocancer() {
		return this.idtipocancer;
	}

	public void setIdtipocancer(Integer idtipocancer) {
		this.idtipocancer = idtipocancer;
	}

	public String getDenominacion() {
		return this.denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public List<Diagnosticohospital> getDiagnosticohospitals() {
		return this.diagnosticohospitals;
	}

	public void setDiagnosticohospitals(List<Diagnosticohospital> diagnosticohospitals) {
		this.diagnosticohospitals = diagnosticohospitals;
	}

	public Diagnosticohospital addDiagnosticohospital(Diagnosticohospital diagnosticohospital) {
		getDiagnosticohospitals().add(diagnosticohospital);
		diagnosticohospital.setTipocancer(this);

		return diagnosticohospital;
	}

	public Diagnosticohospital removeDiagnosticohospital(Diagnosticohospital diagnosticohospital) {
		getDiagnosticohospitals().remove(diagnosticohospital);
		diagnosticohospital.setTipocancer(null);

		return diagnosticohospital;
	}

}