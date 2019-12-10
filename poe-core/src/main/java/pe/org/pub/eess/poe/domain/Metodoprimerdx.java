package pe.org.pub.eess.poe.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the metodoprimerdx database table.
 * 
 */
@Entity
@NamedQuery(name="Metodoprimerdx.findAll", query="SELECT m FROM Metodoprimerdx m")
public class Metodoprimerdx implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idmetodopdx;

	private String codigo;

	private String nombre;

	//bi-directional many-to-one association to Diagnosticohospital
	@OneToMany(mappedBy="metodoprimerdx")
	private List<Diagnosticohospital> diagnosticohospitals;

	public Metodoprimerdx() {
	}

	public Integer getIdmetodopdx() {
		return this.idmetodopdx;
	}

	public void setIdmetodopdx(Integer idmetodopdx) {
		this.idmetodopdx = idmetodopdx;
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
		diagnosticohospital.setMetodoprimerdx(this);

		return diagnosticohospital;
	}

	public Diagnosticohospital removeDiagnosticohospital(Diagnosticohospital diagnosticohospital) {
		getDiagnosticohospitals().remove(diagnosticohospital);
		diagnosticohospital.setMetodoprimerdx(null);

		return diagnosticohospital;
	}

}