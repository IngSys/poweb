package pe.org.pub.eess.poe.util;

public interface Constantes {
    
	int SI = 1;
	int NO = 0;
    public static final String APLICACION = "CATASTRO";
    public static final String PERSISTENCE_UNIT_NAME = "catastroJpa";
    
    public static final String URL_M3 = "https://apps4.mineco.gob.pe/m3/";
  	
    public static final String URL_IMG_CALENDAR = URL_M3 + "images/calendar.gif";
    
    public static final String URL_IMG_PDF = URL_M3 + "images/pdf.gif";
    public static final String URL_IMG_VIEW = URL_M3 + "images/ver.png";
    public static final String URL_IMG_NEW = URL_M3 + "images/new.png";
    public static final String URL_IMG_LOGO = "images/logomef.jpg";
    public static final String URL_IMG_FIRMA = "images/firma.jpg";
    
    public static final String CONTENT_TYPE_PDF = "application/pdf";
    public static final long MAX_ALLOWED_FILE_SIZE = 5242880;//5MB(5242880 bytes) - 10MB(10485760 bytes)
    
    public static final String VACIO = "";
    public static final String SESION_CONTEXT = "SesionContext";
    
    public static final String ESTADO_ACTIVO = "A";
    public static final String ESTADO_INACTIVO = "I";
	
	public static final Integer ACCOR_CERO = 0;
	public static final Integer ACCOR_UNO = 1;

	public static final Integer MAX_INTENTOS = 3;
	
	public static final String TIPO_ARCHIVO_XLSX = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	public static final String TIPO_ARCHIVO_XLS = "application/vnd.ms-excel";
	public static final String TIPO_ARCHIVO_PDF = "application/pdf";
	
	public static final Integer TIPO_DOCUMENTO_DNI = 1;
	
	public static final String CODIGO_ESTADO_VALE = "ESTADO_VALE";
	public static final String CODIGO_TIPO_DOCUMENTO = "TIPO_DOCUMENTO";
	public static final Integer ANIO_BASE_VALES = 2019;
	public static final String ESTADO_VALE_REGISTRADO = "G";
	public static final String ESTADO_VALE_PENDIENTE = "P";
	public static final String ESTADO_VALE_AUTORIZADO = "A";
	public static final String ESTADO_VALE_RECHAZADO = "R";
	public static final String ESTADO_VALE_ANULADO = "X";
	
	public static final String FORMATO_FECHA = "dd/MM/yyyy";
	
	public static final String ENTRE_FECHAS = "ENTRE_FECHAS";
	public static final String POR_PERIODO = "POR_PERIODO";
	
	public static final String ESTADO_PENDIENTE = "P";
	
	 //ROLES
    public static final String ROL_AUTORIZADOR = "CATASTRO - AUTORIZADOR";
    public static final String ROL_RRHH = "CATASTRO - RRHH";
    
    public static final String NAME_SOLICITUD_REGULARIZA = "SOLICITUD_VALE";
    
    public static final String CODIGO_CONCEPTO_AIRHSP = "0001";
    public static final String CODIGO_SERVIDOR_PUBLICO_AIRHSP = "1";
    
    public static final String ESTADO_USUARIO_PEND_CONF = "PC";
    
    
	
}
