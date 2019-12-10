package pe.org.pub.eess.poe.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cie_o_m database table.
 * 
 */
@Entity
@Table(name="cie_o_m")
@NamedQuery(name="CieOM.findAll", query="SELECT c FROM CieOM c")
public class CieOM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idcie_o_m")
	private Integer idcieOM;

	private String codigo;

	private String denominacion;

	private String estado;

	//bi-directional many-to-one association to Diagnosticohospital
	@OneToMany(mappedBy="cieOM")
	private List<Diagnosticohospital> diagnosticohospitals;

	public CieOM() {
	}

	public Integer getIdcieOM() {
		return this.idcieOM;
	}

	public void setIdcieOM(Integer idcieOM) {
		this.idcieOM = idcieOM;
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
		diagnosticohospital.setCieOM(this);

		return diagnosticohospital;
	}

	public Diagnosticohospital removeDiagnosticohospital(Diagnosticohospital diagnosticohospital) {
		getDiagnosticohospitals().remove(diagnosticohospital);
		diagnosticohospital.setCieOM(null);

		return diagnosticohospital;
	}

}