package pe.org.pub.eess.poe.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the establecimientosalud database table.
 * 
 */
@Entity
@NamedQuery(name="Establecimientosalud.findAll", query="SELECT e FROM Establecimientosalud e")
public class Establecimientosalud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idestablecimiento;

	private String categoria;

	@Column(name="cod_eess")
	private String codEess;

	@Column(name="cod_sis")
	private String codSis;

	private String nombre;

	//bi-directional many-to-one association to Diagnosticoreferencia
	@OneToMany(mappedBy="establecimientosalud")
	private List<Diagnosticoreferencia> diagnosticoreferencias;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="iddistrito")
	private Distrito distrito;

	public Establecimientosalud() {
	}

	public Integer getIdestablecimiento() {
		return this.idestablecimiento;
	}

	public void setIdestablecimiento(Integer idestablecimiento) {
		this.idestablecimiento = idestablecimiento;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCodEess() {
		return this.codEess;
	}

	public void setCodEess(String codEess) {
		this.codEess = codEess;
	}

	public String getCodSis() {
		return this.codSis;
	}

	public void setCodSis(String codSis) {
		this.codSis = codSis;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Diagnosticoreferencia> getDiagnosticoreferencias() {
		return this.diagnosticoreferencias;
	}

	public void setDiagnosticoreferencias(List<Diagnosticoreferencia> diagnosticoreferencias) {
		this.diagnosticoreferencias = diagnosticoreferencias;
	}

	public Diagnosticoreferencia addDiagnosticoreferencia(Diagnosticoreferencia diagnosticoreferencia) {
		getDiagnosticoreferencias().add(diagnosticoreferencia);
		diagnosticoreferencia.setEstablecimientosalud(this);

		return diagnosticoreferencia;
	}

	public Diagnosticoreferencia removeDiagnosticoreferencia(Diagnosticoreferencia diagnosticoreferencia) {
		getDiagnosticoreferencias().remove(diagnosticoreferencia);
		diagnosticoreferencia.setEstablecimientosalud(null);

		return diagnosticoreferencia;
	}

	public Distrito getDistrito() {
		return this.distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

}