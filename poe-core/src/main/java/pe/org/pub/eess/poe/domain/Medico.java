package pe.org.pub.eess.poe.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the medico database table.
 * 
 */
@Entity
@NamedQuery(name="Medico.findAll", query="SELECT m FROM Medico m")
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idmedico;

	@Column(name="ape_materno")
	private String apeMaterno;

	@Column(name="ape_paterno")
	private String apePaterno;

	@Column(name="cod_colegiatura")
	private String codColegiatura;

	@Column(name="dat_adicionales")
	private String datAdicionales;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fchresys;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Defuncion
	@OneToMany(mappedBy="medico")
	private List<Defuncion> defuncions;

	public Medico() {
	}

	public Integer getIdmedico() {
		return this.idmedico;
	}

	public void setIdmedico(Integer idmedico) {
		this.idmedico = idmedico;
	}

	public String getApeMaterno() {
		return this.apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getApePaterno() {
		return this.apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getCodColegiatura() {
		return this.codColegiatura;
	}

	public void setCodColegiatura(String codColegiatura) {
		this.codColegiatura = codColegiatura;
	}

	public String getDatAdicionales() {
		return this.datAdicionales;
	}

	public void setDatAdicionales(String datAdicionales) {
		this.datAdicionales = datAdicionales;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFchresys() {
		return this.fchresys;
	}

	public void setFchresys(Date fchresys) {
		this.fchresys = fchresys;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Defuncion> getDefuncions() {
		return this.defuncions;
	}

	public void setDefuncions(List<Defuncion> defuncions) {
		this.defuncions = defuncions;
	}

	public Defuncion addDefuncion(Defuncion defuncion) {
		getDefuncions().add(defuncion);
		defuncion.setMedico(this);

		return defuncion;
	}

	public Defuncion removeDefuncion(Defuncion defuncion) {
		getDefuncions().remove(defuncion);
		defuncion.setMedico(null);

		return defuncion;
	}

}