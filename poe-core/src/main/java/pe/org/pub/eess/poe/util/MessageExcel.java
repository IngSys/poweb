package pe.org.pub.eess.poe.util;

public interface MessageExcel {
   
    final static String ERROR_NRO_CORRELATIVO = " tiene el pasaje sin número correlativo.";
    final static String ERROR_MES_ANIO = " tiene el pasaje sin formato año-mes.";
	
    final static String ERROR_FECHA_EMISION = " tiene el pasaje sin fecha de emisión.";
    final static String ERROR_NRO_TICKET = " tiene el pasaje sin número de ticket.";
    
    final static String ERROR_NOMBRE_PASAJERO = " tiene el pasaje sin nombre del pasajero.";
    final static String ERROR_TIPO_DOCUMENTO = " tiene el pasaje sin tipo de documento.";   
    final static String ERROR_NRO_DOCUMENTO = " tiene el pasaje sin número de documento."; 
    
    final static String ERROR_RUTA = " tiene el pasaje Ruta.";
    final static String ERROR_FECHA_VUELO = " no tiene fecha de vuelo.";
    
    final static String ERROR_TARIFA_US = " no tiene Tarifa en dólares.";
    final static String ERROR_IGV_US = " no tiene IGV US.";
    
    final static String ERROR_TIPO_CAMBIO_US_SOL = " no tiene Tipo de Cambio de US  a S/.";
    
    
    
    final static String ERROR_ANIO_MES_EMISION = " tiene el Año-Mes del pasaje con fecha de emisión mayor al periodo (Año-Mes).";
    final static String ERROR_EMISION_ACTUAL = " tiene fecha de emisión del pasaje mayor a la fecha actual.";
    
    final static String ERROR_TIPO_DOCUMENTO_DIF = " tiene el pasaje con un tipo de documento diferente al '01', '04', '07'.";  
    
    //final static String ERROR_DIF_MONTOS_US = " la Tarifa en dólares debe ser mayor que el tipo de cambio US a S/."; 
    final static String ERROR_DIF_MONTOS_US = " tiene el monto del IGV ($)  mayor al monto de la tarifa del pasaje ($)."; 

    
    final static String ERROR_DIF_FECHA_VUELO = " la fecha del vuelo debe ser mayor o igual a la fecha de emisión.";
    
}
