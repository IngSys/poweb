package pe.org.pub.eess.poe.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the defuncion database table.
 * 
 */
@Entity
@NamedQuery(name="Defuncion.findAll", query="SELECT d FROM Defuncion d")
public class Defuncion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer iddefuncion;

	@Column(name="causa_muerte")
	private String causaMuerte;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="fch_defuncion")
	private Date fchDefuncion;

	@Temporal(TemporalType.DATE)
	private Date fchresys;

	@Column(name="lug_deceso")
	private String lugDeceso;

	//bi-directional many-to-one association to Medico
	@ManyToOne
	@JoinColumn(name="idmedico")
	private Medico medico;

	//bi-directional many-to-one association to Enfermedad
	@OneToMany(mappedBy="defuncion")
	private List<Enfermedad> enfermedads;

	public Defuncion() {
	}

	public Integer getIddefuncion() {
		return this.iddefuncion;
	}

	public void setIddefuncion(Integer iddefuncion) {
		this.iddefuncion = iddefuncion;
	}

	public String getCausaMuerte() {
		return this.causaMuerte;
	}

	public void setCausaMuerte(String causaMuerte) {
		this.causaMuerte = causaMuerte;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFchDefuncion() {
		return this.fchDefuncion;
	}

	public void setFchDefuncion(Date fchDefuncion) {
		this.fchDefuncion = fchDefuncion;
	}

	public Date getFchresys() {
		return this.fchresys;
	}

	public void setFchresys(Date fchresys) {
		this.fchresys = fchresys;
	}

	public String getLugDeceso() {
		return this.lugDeceso;
	}

	public void setLugDeceso(String lugDeceso) {
		this.lugDeceso = lugDeceso;
	}

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Enfermedad> getEnfermedads() {
		return this.enfermedads;
	}

	public void setEnfermedads(List<Enfermedad> enfermedads) {
		this.enfermedads = enfermedads;
	}

	public Enfermedad addEnfermedad(Enfermedad enfermedad) {
		getEnfermedads().add(enfermedad);
		enfermedad.setDefuncion(this);

		return enfermedad;
	}

	public Enfermedad removeEnfermedad(Enfermedad enfermedad) {
		getEnfermedads().remove(enfermedad);
		enfermedad.setDefuncion(null);

		return enfermedad;
	}

}