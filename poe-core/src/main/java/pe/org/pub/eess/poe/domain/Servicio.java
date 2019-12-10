package pe.org.pub.eess.poe.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the servicio database table.
 * 
 */
@Entity
@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idservicio;

	private String codigo;

	private String nombre;

	//bi-directional many-to-one association to Diagnosticohospital
	@OneToMany(mappedBy="servicio")
	private List<Diagnosticohospital> diagnosticohospitals;

	//bi-directional many-to-one association to Diagnosticoreferencia
	@OneToMany(mappedBy="servicio")
	private List<Diagnosticoreferencia> diagnosticoreferencias;

	public Servicio() {
	}

	public Integer getIdservicio() {
		return this.idservicio;
	}

	public void setIdservicio(Integer idservicio) {
		this.idservicio = idservicio;
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
		diagnosticohospital.setServicio(this);

		return diagnosticohospital;
	}

	public Diagnosticohospital removeDiagnosticohospital(Diagnosticohospital diagnosticohospital) {
		getDiagnosticohospitals().remove(diagnosticohospital);
		diagnosticohospital.setServicio(null);

		return diagnosticohospital;
	}

	public List<Diagnosticoreferencia> getDiagnosticoreferencias() {
		return this.diagnosticoreferencias;
	}

	public void setDiagnosticoreferencias(List<Diagnosticoreferencia> diagnosticoreferencias) {
		this.diagnosticoreferencias = diagnosticoreferencias;
	}

	public Diagnosticoreferencia addDiagnosticoreferencia(Diagnosticoreferencia diagnosticoreferencia) {
		getDiagnosticoreferencias().add(diagnosticoreferencia);
		diagnosticoreferencia.setServicio(this);

		return diagnosticoreferencia;
	}

	public Diagnosticoreferencia removeDiagnosticoreferencia(Diagnosticoreferencia diagnosticoreferencia) {
		getDiagnosticoreferencias().remove(diagnosticoreferencia);
		diagnosticoreferencia.setServicio(null);

		return diagnosticoreferencia;
	}

}