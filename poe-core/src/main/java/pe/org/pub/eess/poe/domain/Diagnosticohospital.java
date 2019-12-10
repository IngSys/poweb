package pe.org.pub.eess.poe.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the diagnosticohospital database table.
 * 
 */
@Entity
@NamedQuery(name="Diagnosticohospital.findAll", query="SELECT d FROM Diagnosticohospital d")
public class Diagnosticohospital implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer iddxhospital;

	@Column(name="cla_tnm")
	private String claTnm;

	@Column(name="codgrd_diferenciacion")
	private String codgrdDiferenciacion;

	private String codlateralidad;

	private String descripciontnm;

	@Column(name="dx_histologico")
	private String dxHistologico;

	private String dxclinico;

	@Column(name="est_clinico")
	private String estClinico;

	@Temporal(TemporalType.DATE)
	@Column(name="fch_ex_histolog")
	private Date fchExHistolog;

	@Temporal(TemporalType.DATE)
	@Column(name="fch_primer_dx")
	private Date fchPrimerDx;

	@Temporal(TemporalType.DATE)
	private Date fchresys;

	@Column(name="nro_anat_patologico")
	private String nroAnatPatologico;

	private String selector;

	@Column(name="tie_enfermedad_day")
	private String tieEnfermedadDay;

	//bi-directional many-to-one association to Basedx
	@ManyToOne
	@JoinColumn(name="idbasedx")
	private Basedx basedx;

	//bi-directional many-to-one association to CieOM
	@ManyToOne
	@JoinColumn(name="idcie_o_m")
	private CieOM cieOM;

	//bi-directional many-to-one association to CieOT
	@ManyToOne
	@JoinColumn(name="idcie_o_t")
	private CieOT cieOT;

	//bi-directional many-to-one association to Metodoprimerdx
	@ManyToOne
	@JoinColumn(name="idmetodopdx")
	private Metodoprimerdx metodoprimerdx;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private Paciente paciente;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="idservicio")
	private Servicio servicio;

	//bi-directional many-to-one association to Tipocancer
	@ManyToOne
	@JoinColumn(name="idtipocancer")
	private Tipocancer tipocancer;

	//bi-directional many-to-one association to Tratamiento
	@OneToMany(mappedBy="diagnosticohospital")
	private List<Tratamiento> tratamientos;

	public Diagnosticohospital() {
	}

	public Integer getIddxhospital() {
		return this.iddxhospital;
	}

	public void setIddxhospital(Integer iddxhospital) {
		this.iddxhospital = iddxhospital;
	}

	public String getClaTnm() {
		return this.claTnm;
	}

	public void setClaTnm(String claTnm) {
		this.claTnm = claTnm;
	}

	public String getCodgrdDiferenciacion() {
		return this.codgrdDiferenciacion;
	}

	public void setCodgrdDiferenciacion(String codgrdDiferenciacion) {
		this.codgrdDiferenciacion = codgrdDiferenciacion;
	}

	public String getCodlateralidad() {
		return this.codlateralidad;
	}

	public void setCodlateralidad(String codlateralidad) {
		this.codlateralidad = codlateralidad;
	}

	public String getDescripciontnm() {
		return this.descripciontnm;
	}

	public void setDescripciontnm(String descripciontnm) {
		this.descripciontnm = descripciontnm;
	}

	public String getDxHistologico() {
		return this.dxHistologico;
	}

	public void setDxHistologico(String dxHistologico) {
		this.dxHistologico = dxHistologico;
	}

	public String getDxclinico() {
		return this.dxclinico;
	}

	public void setDxclinico(String dxclinico) {
		this.dxclinico = dxclinico;
	}

	public String getEstClinico() {
		return this.estClinico;
	}

	public void setEstClinico(String estClinico) {
		this.estClinico = estClinico;
	}

	public Date getFchExHistolog() {
		return this.fchExHistolog;
	}

	public void setFchExHistolog(Date fchExHistolog) {
		this.fchExHistolog = fchExHistolog;
	}

	public Date getFchPrimerDx() {
		return this.fchPrimerDx;
	}

	public void setFchPrimerDx(Date fchPrimerDx) {
		this.fchPrimerDx = fchPrimerDx;
	}

	public Date getFchresys() {
		return this.fchresys;
	}

	public void setFchresys(Date fchresys) {
		this.fchresys = fchresys;
	}

	public String getNroAnatPatologico() {
		return this.nroAnatPatologico;
	}

	public void setNroAnatPatologico(String nroAnatPatologico) {
		this.nroAnatPatologico = nroAnatPatologico;
	}

	public String getSelector() {
		return this.selector;
	}

	public void setSelector(String selector) {
		this.selector = selector;
	}

	public String getTieEnfermedadDay() {
		return this.tieEnfermedadDay;
	}

	public void setTieEnfermedadDay(String tieEnfermedadDay) {
		this.tieEnfermedadDay = tieEnfermedadDay;
	}

	public Basedx getBasedx() {
		return this.basedx;
	}

	public void setBasedx(Basedx basedx) {
		this.basedx = basedx;
	}

	public CieOM getCieOM() {
		return this.cieOM;
	}

	public void setCieOM(CieOM cieOM) {
		this.cieOM = cieOM;
	}

	public CieOT getCieOT() {
		return this.cieOT;
	}

	public void setCieOT(CieOT cieOT) {
		this.cieOT = cieOT;
	}

	public Metodoprimerdx getMetodoprimerdx() {
		return this.metodoprimerdx;
	}

	public void setMetodoprimerdx(Metodoprimerdx metodoprimerdx) {
		this.metodoprimerdx = metodoprimerdx;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Tipocancer getTipocancer() {
		return this.tipocancer;
	}

	public void setTipocancer(Tipocancer tipocancer) {
		this.tipocancer = tipocancer;
	}

	public List<Tratamiento> getTratamientos() {
		return this.tratamientos;
	}

	public void setTratamientos(List<Tratamiento> tratamientos) {
		this.tratamientos = tratamientos;
	}

	public Tratamiento addTratamiento(Tratamiento tratamiento) {
		getTratamientos().add(tratamiento);
		tratamiento.setDiagnosticohospital(this);

		return tratamiento;
	}

	public Tratamiento removeTratamiento(Tratamiento tratamiento) {
		getTratamientos().remove(tratamiento);
		tratamiento.setDiagnosticohospital(null);

		return tratamiento;
	}

}