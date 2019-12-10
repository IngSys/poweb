package pe.org.pub.eess.poe.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the detalletratamiento database table.
 * 
 */
@Entity
@NamedQuery(name="Detalletratamiento.findAll", query="SELECT d FROM Detalletratamiento d")
public class Detalletratamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer iddetalle;

	private String nombre;

	//bi-directional many-to-one association to Tratamiento
	@OneToMany(mappedBy="detalletratamiento")
	private List<Tratamiento> tratamientos;

	public Detalletratamiento() {
	}

	public Integer getIddetalle() {
		return this.iddetalle;
	}

	public void setIddetalle(Integer iddetalle) {
		this.iddetalle = iddetalle;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Tratamiento> getTratamientos() {
		return this.tratamientos;
	}

	public void setTratamientos(List<Tratamiento> tratamientos) {
		this.tratamientos = tratamientos;
	}

	public Tratamiento addTratamiento(Tratamiento tratamiento) {
		getTratamientos().add(tratamiento);
		tratamiento.setDetalletratamiento(this);

		return tratamiento;
	}

	public Tratamiento removeTratamiento(Tratamiento tratamiento) {
		getTratamientos().remove(tratamiento);
		tratamiento.setDetalletratamiento(null);

		return tratamiento;
	}

}