package pe.org.pub.eess.poe.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the distrito database table.
 * 
 */
@Entity
@NamedQuery(name="Distrito.findAll", query="SELECT d FROM Distrito d")
public class Distrito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer iddistrito;

	private String nombre;

	//bi-directional many-to-one association to Provincia
	@ManyToOne
	@JoinColumn(name="idprovincia")
	private Provincia provincia;

	//bi-directional many-to-one association to Establecimientosalud
	@OneToMany(mappedBy="distrito")
	private List<Establecimientosalud> establecimientosaluds;

	//bi-directional many-to-one association to Ubigeo
	@OneToMany(mappedBy="distrito")
	private List<Ubigeo> ubigeos;

	public Distrito() {
	}

	public Integer getIddistrito() {
		return this.iddistrito;
	}

	public void setIddistrito(Integer iddistrito) {
		this.iddistrito = iddistrito;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public List<Establecimientosalud> getEstablecimientosaluds() {
		return this.establecimientosaluds;
	}

	public void setEstablecimientosaluds(List<Establecimientosalud> establecimientosaluds) {
		this.establecimientosaluds = establecimientosaluds;
	}

	public Establecimientosalud addEstablecimientosalud(Establecimientosalud establecimientosalud) {
		getEstablecimientosaluds().add(establecimientosalud);
		establecimientosalud.setDistrito(this);

		return establecimientosalud;
	}

	public Establecimientosalud removeEstablecimientosalud(Establecimientosalud establecimientosalud) {
		getEstablecimientosaluds().remove(establecimientosalud);
		establecimientosalud.setDistrito(null);

		return establecimientosalud;
	}

	public List<Ubigeo> getUbigeos() {
		return this.ubigeos;
	}

	public void setUbigeos(List<Ubigeo> ubigeos) {
		this.ubigeos = ubigeos;
	}

	public Ubigeo addUbigeo(Ubigeo ubigeo) {
		getUbigeos().add(ubigeo);
		ubigeo.setDistrito(this);

		return ubigeo;
	}

	public Ubigeo removeUbigeo(Ubigeo ubigeo) {
		getUbigeos().remove(ubigeo);
		ubigeo.setDistrito(null);

		return ubigeo;
	}

}