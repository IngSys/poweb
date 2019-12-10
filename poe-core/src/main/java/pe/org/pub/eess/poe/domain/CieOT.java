package pe.org.pub.eess.poe.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cie_o_t database table.
 * 
 */
@Entity
@Table(name="cie_o_t")
@NamedQuery(name="CieOT.findAll", query="SELECT c FROM CieOT c")
public class CieOT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idcie_o_t")
	private Integer idcieOT;

	private String codigo;

	private String denominacion;

	private String estado;

	//bi-directional many-to-one association to Diagnosticohospital
	@OneToMany(mappedBy="cieOT")
	private List<Diagnosticohospital> diagnosticohospitals;

	public CieOT() {
	}

	public Integer getIdcieOT() {
		return this.idcieOT;
	}

	public void setIdcieOT(Integer idcieOT) {
		this.idcieOT = idcieOT;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDenominacion() {
		return this.denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Diagnosticohospital> getDiagnosticohospitals() {
		return this.diagnosticohospitals;
	}

	public void setDiagnosticohospitals(List<Diagnosticohospital> diagnosticohospitals) {
		this.diagnosticohospitals = diagnosticohospitals;
	}

	public Diagnosticohospital addDiagnosticohospital(Diagnosticohospital diagnosticohospital) {
		getDiagnosticohospitals().add(diagnosticohospital);
		diagnosticohospital.setCieOT(this);

		return diagnosticohospital;
	}

	public Diagnosticohospital removeDiagnosticohospital(Diagnosticohospital diagnosticohospital) {
		getDiagnosticohospitals().remove(diagnosticohospital);
		diagnosticohospital.setCieOT(null);

		return diagnosticohospital;
	}

}