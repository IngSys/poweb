package pe.org.pub.eess.poe.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the paciente database table.
 * 
 */
@Entity
@NamedQuery(name="Paciente.findAll", query="SELECT p FROM Paciente p")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idpaciente;

	@Column(name="ape_materno")
	private String apeMaterno;

	@Column(name="ape_paterno")
	private String apePaterno;

	@Column(name="cod_genero")
	private String codGenero;

	@Column(name="codcnd_asegurado")
	private String codcndAsegurado;

	@Column(name="codgrd_instruccion")
	private String codgrdInstruccion;

	@Column(name="codtip_documento")
	private String codtipDocumento;

	@Column(name="codtip_referencia")
	private String codtipReferencia;

	private Integer edad;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fch_nacimiento")
	private Date fchNacimiento;

	@Temporal(TemporalType.DATE)
	private Date fchrepste;

	@Temporal(TemporalType.DATE)
	private Date fchresys;

	@Column(name="hra_referencia")
	private String hraReferencia;

	private Integer idpersonareferencia;

	private String nacionalidad;

	private String nombre;

	@Column(name="nro_documento")
	private String nroDocumento;

	@Column(name="nro_hc")
	private String nroHc;

	private String ocupacion;

	private String procedencia;

	private String telefono;

	private String unidad;

	//bi-directional many-to-one association to Admision
	@OneToMany(mappedBy="paciente")
	private List<Admision> admisions;

	//bi-directional many-to-one association to Diagnosticohospital
	@OneToMany(mappedBy="paciente")
	private List<Diagnosticohospital> diagnosticohospitals;

	//bi-directional many-to-one association to Diagnosticoreferencia
	@OneToMany(mappedBy="paciente")
	private List<Diagnosticoreferencia> diagnosticoreferencias;

	//bi-directional many-to-one association to Enfermedad
	@OneToMany(mappedBy="paciente")
	private List<Enfermedad> enfermedads;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Ubigeo
	@OneToMany(mappedBy="paciente")
	private List<Ubigeo> ubigeos;

	public Paciente() {
	}

	public Integer getIdpaciente() {
		return this.idpaciente;
	}

	public void setIdpaciente(Integer idpaciente) {
		this.idpaciente = idpaciente;
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

	public String getCodGenero() {
		return this.codGenero;
	}

	public void setCodGenero(String codGenero) {
		this.codGenero = codGenero;
	}

	public String getCodcndAsegurado() {
		return this.codcndAsegurado;
	}

	public void setCodcndAsegurado(String codcndAsegurado) {
		this.codcndAsegurado = codcndAsegurado;
	}

	public String getCodgrdInstruccion() {
		return this.codgrdInstruccion;
	}

	public void setCodgrdInstruccion(String codgrdInstruccion) {
		this.codgrdInstruccion = codgrdInstruccion;
	}

	public String getCodtipDocumento() {
		return this.codtipDocumento;
	}

	public void setCodtipDocumento(String codtipDocumento) {
		this.codtipDocumento = codtipDocumento;
	}

	public String getCodtipReferencia() {
		return this.codtipReferencia;
	}

	public void setCodtipReferencia(String codtipReferencia) {
		this.codtipReferencia = codtipReferencia;
	}

	public Integer getEdad() {
		return this.edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFchNacimiento() {
		return this.fchNacimiento;
	}

	public void setFchNacimiento(Date fchNacimiento) {
		this.fchNacimiento = fchNacimiento;
	}

	public Date getFchrepste() {
		return this.fchrepste;
	}

	public void setFchrepste(Date fchrepste) {
		this.fchrepste = fchrepste;
	}

	public Date getFchresys() {
		return this.fchresys;
	}

	public void setFchresys(Date fchresys) {
		this.fchresys = fchresys;
	}

	public String getHraReferencia() {
		return this.hraReferencia;
	}

	public void setHraReferencia(String hraReferencia) {
		this.hraReferencia = hraReferencia;
	}

	public Integer getIdpersonareferencia() {
		return this.idpersonareferencia;
	}

	public void setIdpersonareferencia(Integer idpersonareferencia) {
		this.idpersonareferencia = idpersonareferencia;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNroDocumento() {
		return this.nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getNroHc() {
		return this.nroHc;
	}

	public void setNroHc(String nroHc) {
		this.nroHc = nroHc;
	}

	public String getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getProcedencia() {
		return this.procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUnidad() {
		return this.unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public List<Admision> getAdmisions() {
		return this.admisions;
	}

	public void setAdmisions(List<Admision> admisions) {
		this.admisions = admisions;
	}

	public Admision addAdmision(Admision admision) {
		getAdmisions().add(admision);
		admision.setPaciente(this);

		return admision;
	}

	public Admision removeAdmision(Admision admision) {
		getAdmisions().remove(admision);
		admision.setPaciente(null);

		return admision;
	}

	public List<Diagnosticohospital> getDiagnosticohospitals() {
		return this.diagnosticohospitals;
	}

	public void setDiagnosticohospitals(List<Diagnosticohospital> diagnosticohospitals) {
		this.diagnosticohospitals = diagnosticohospitals;
	}

	public Diagnosticohospital addDiagnosticohospital(Diagnosticohospital diagnosticohospital) {
		getDiagnosticohospitals().add(diagnosticohospital);
		diagnosticohospital.setPaciente(this);

		return diagnosticohospital;
	}

	public Diagnosticohospital removeDiagnosticohospital(Diagnosticohospital diagnosticohospital) {
		getDiagnosticohospitals().remove(diagnosticohospital);
		diagnosticohospital.setPaciente(null);

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
		diagnosticoreferencia.setPaciente(this);

		return diagnosticoreferencia;
	}

	public Diagnosticoreferencia removeDiagnosticoreferencia(Diagnosticoreferencia diagnosticoreferencia) {
		getDiagnosticoreferencias().remove(diagnosticoreferencia);
		diagnosticoreferencia.setPaciente(null);

		return diagnosticoreferencia;
	}

	public List<Enfermedad> getEnfermedads() {
		return this.enfermedads;
	}

	public void setEnfermedads(List<Enfermedad> enfermedads) {
		this.enfermedads = enfermedads;
	}

	public Enfermedad addEnfermedad(Enfermedad enfermedad) {
		getEnfermedads().add(enfermedad);
		enfermedad.setPaciente(this);

		return enfermedad;
	}

	public Enfermedad removeEnfermedad(Enfermedad enfermedad) {
		getEnfermedads().remove(enfermedad);
		enfermedad.setPaciente(null);

		return enfermedad;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Ubigeo> getUbigeos() {
		return this.ubigeos;
	}

	public void setUbigeos(List<Ubigeo> ubigeos) {
		this.ubigeos = ubigeos;
	}

	public Ubigeo addUbigeo(Ubigeo ubigeo) {
		getUbigeos().add(ubigeo);
		ubigeo.setPaciente(this);

		return ubigeo;
	}

	public Ubigeo removeUbigeo(Ubigeo ubigeo) {
		getUbigeos().remove(ubigeo);
		ubigeo.setPaciente(null);

		return ubigeo;
	}

}