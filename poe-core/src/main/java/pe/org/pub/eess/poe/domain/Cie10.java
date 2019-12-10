package pe.org.pub.eess.poe.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cie_10 database table.
 * 
 */
@Entity
@Table(name="cie_10")
@NamedQuery(name="Cie10.findAll", query="SELECT c FROM Cie10 c")
public class Cie10 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idcie_10")
	private Integer idcie10;

	private String codigo;

	private String denominacion;

	private String estado;

	//bi-directional many-to-one association to Enfermedad
	@OneToMany(mappedBy="cie10")
	private List<Enfermedad> enfermedads;

	public Cie10() {
	}

	public Integer getIdcie10() {
		return this.idcie10;
	}

	public void setIdcie10(Integer idcie10) {
		this.idcie10 = idcie10;
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

	public List<Enfermedad> getEnfermedads() {
		return this.enfermedads;
	}

	public void setEnfermedads(List<Enfermedad> enfermedads) {
		this.enfermedads = enfermedads;
	}

	public Enfermedad addEnfermedad(Enfermedad enfermedad) {
		getEnfermedads().add(enfermedad);
		enfermedad.setCie10(this);

		return enfermedad;
	}

	public Enfermedad removeEnfermedad(Enfermedad enfermedad) {
		getEnfermedads().remove(enfermedad);
		enfermedad.setCie10(null);

		return enfermedad;
	}

}