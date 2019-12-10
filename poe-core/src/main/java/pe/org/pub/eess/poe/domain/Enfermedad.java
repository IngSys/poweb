package pe.org.pub.eess.poe.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the enfermedad database table.
 * 
 */
@Entity
@NamedQuery(name="Enfermedad.findAll", query="SELECT e FROM Enfermedad e")
public class Enfermedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idenfermedad;

	@Column(name="cnt_causadef")
	private String cntCausadef;

	//bi-directional many-to-one association to Cie10
	@ManyToOne
	@JoinColumn(name="idcie_10")
	private Cie10 cie10;

	//bi-directional many-to-one association to Defuncion
	@ManyToOne
	@JoinColumn(name="iddefuncion")
	private Defuncion defuncion;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private Paciente paciente;

	public Enfermedad() {
	}

	public Integer getIdenfermedad() {
		return this.idenfermedad;
	}

	public void setIdenfermedad(Integer idenfermedad) {
		this.idenfermedad = idenfermedad;
	}

	public String getCntCausadef() {
		return this.cntCausadef;
	}

	public void setCntCausadef(String cntCausadef) {
		this.cntCausadef = cntCausadef;
	}

	public Cie10 getCie10() {
		return this.cie10;
	}

	public void setCie10(Cie10 cie10) {
		this.cie10 = cie10;
	}

	public Defuncion getDefuncion() {
		return this.defuncion;
	}

	public void setDefuncion(Defuncion defuncion) {
		this.defuncion = defuncion;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}