package pe.org.pub.eess.poe.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the basedx database table.
 * 
 */
@Entity
@NamedQuery(name="Basedx.findAll", query="SELECT b FROM Basedx b")
public class Basedx implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idbasedx;

	private String codigo;

	private String nombre;

	//bi-directional many-to-one association to Diagnosticohospital
	@OneToMany(mappedBy="basedx")
	private List<Diagnosticohospital> diagnosticohospitals;

	public Basedx() {
	}

	public Integer getIdbasedx() {
		return this.idbasedx;
	}

	public void setIdbasedx(Integer idbasedx) {
		this.idbasedx = idbasedx;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Diagnosticohospital> getDiagnosticohospitals() {
		return this.diagnosticohospitals;
	}

	public void setDiagnosticohospitals(List<Diagnosticohospital> diagnosticohospitals) {
		this.diagnosticohospitals = diagnosticohospitals;
	}

	public Diagnosticohospital addDiagnosticohospital(Diagnosticohospital diagnosticohospital) {
		getDiagnosticohospitals().add(diagnosticohospital);
		diagnosticohospital.setBasedx(this);

		return diagnosticohospital;
	}

	public Diagnosticohospital removeDiagnosticohospital(Diagnosticohospital diagnosticohospital) {
		getDiagnosticohospitals().remove(diagnosticohospital);
		diagnosticohospital.setBasedx(null);

		return diagnosticohospital;
	}

}