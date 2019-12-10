package pe.org.pub.eess.poe.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class DateUtil {
	protected DateUtil() {
		throw new UnsupportedOperationException();
	}

	public static String formatDate(Date value, String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(value);
	}

	public static Date getCurrentDate() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}

	public static String getCurrentDate(String format) {
		Date currentDate = getCurrentDate();
		return formatDate(currentDate, format);
	}

	public static Short getCurrentYear() {
		Calendar calendar = Calendar.getInstance();
		Short year = new Short((short) calendar.get(1));
		return year;
	}

	public static Short getCurrentMonth() {
		Calendar calendar = Calendar.getInstance();
		Short month = new Short((short) (calendar.get(2) + 1));
		return month;
	}

	public static Short getCurrentDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		Short dayOfMonth = new Short((short) calendar.get(5));

		return dayOfMonth;
	}

	public static Short getCurrentHourOfDay() {
		Calendar calendar = Calendar.getInstance();
		Short hourOfDay = new Short((short) calendar.get(11));
		return hourOfDay;
	}

	public static Short getCurrentMinuteOfHourOfDay() {
		Calendar calendar = Calendar.getInstance();
		Short minuteOfHourOfDay = new Short((short) calendar.get(12));

		return minuteOfHourOfDay;
	}

	public static Short getCurrentSecondOfHourOfDay() {
		Calendar calendar = Calendar.getInstance();
		Short secondOfHourOfDay = new Short((short) calendar.get(13));

		return secondOfHourOfDay;
	}

	public static Short getCurrentMillisecondOfHourOfDay() {
		Calendar calendar = Calendar.getInstance();
		Short millisecondOfHourOfDay = new Short((short) calendar.get(14));

		return millisecondOfHourOfDay;
	}

	public static Timestamp nowTimestamp() {
		return getTimestamp(System.currentTimeMillis());
	}

	public static Timestamp getTimestamp(long time) {
		return new Timestamp(time);
	}

	public static Timestamp getTimestamp(String milliSecs)
			throws NumberFormatException {
		return new Timestamp(Long.parseLong(milliSecs));
	}

	public static String nowAsString() {
		return Long.toString(System.currentTimeMillis());
	}

	public static String nowDateString() {
		return nowDateString("yyyyMMddHHmmss");
	}

	public static String getDateAsPeruFormat() {
		return nowDateString("dd/MM/yyyy HH:mm:ss");
	}

	public static String getFechaAsPeruFormat() {
		return nowDateString("dd/MM/yyyy");
	}
   public static String getFechaAsPeruFormat(Date fecha) {
       SimpleDateFormat formatPeru = new SimpleDateFormat("dd/MM/yyyy");
        return formatPeru.format(fecha);
    }

	public static String getHoraAsPeruFormat() {
		return nowDateString("HH:mm:ss");
	}

	public static String nowDateString(String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(new Date());
	}

	public static Date nowDate() {
		return new Date();
	}

	public static String dateToString(Date date, String format) {
		try {
			if (date == null) {
				return null;
			}
			SimpleDateFormat df = new SimpleDateFormat(format);
			return df.format(date);
		} catch (Exception e) {
			System.err.println("ERROR::: En dateToString =" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public static Date stringToDate(String strDate, String format) {
		Date date = null;
		try {
			if (strDate == null) {
				return null;
			}
			DateFormat formatter = new SimpleDateFormat(format);
			date = formatter.parse(strDate);
		} catch (Exception e) {
			System.err.println("ERROR::: En stringToDate =" + e.getMessage());
			e.printStackTrace();
		}
		return date;
	}

	public static List<Integer> getListFromYear(Integer annoInicio) {
		Integer annoAux = annoInicio;
		List<Integer> listAnno = new ArrayList();
		Short annoActual = getCurrentYear();
		while (annoAux.intValue() <= annoActual.shortValue()) {
			listAnno.add(annoAux);
			annoAux = Integer.valueOf(annoAux.intValue() + 1);
		}
		return listAnno;
	}

	public static Map<Integer, Integer> getMapFromYear(Integer annoInicio) {
		Short annoActual = getCurrentYear();
		Integer annoAux = Integer.valueOf(annoActual.intValue());
		Map<Integer, Integer> annos = new LinkedHashMap();
		while (annoAux.intValue() >= annoInicio.intValue()) {
			annos.put(annoAux, annoAux);
			annoAux = Integer.valueOf(annoAux.intValue() - 1);
		}
		return annos;
	}

	public static String convertMesToString(Integer mes) {
		String mesString = "";
		switch (mes.intValue()) {
		case 1:
			mesString = "Enero";
			break;
		case 2:
			mesString = "Febrero";
			break;
		case 3:
			mesString = "Marzo";
			break;
		case 4:
			mesString = "Abril";
			break;
		case 5:
			mesString = "Mayo";
			break;
		case 6:
			mesString = "Junio";
			break;
		case 7:
			mesString = "Julio";
			break;
		case 8:
			mesString = "Agosto";
			break;
		case 9:
			mesString = "Setiembre";
			break;
		case 10:
			mesString = "Octubre";
			break;
		case 11:
			mesString = "Noviembre";
			break;
		case 12:
			mesString = "Diciembre";
			break;
		case 13:
			mesString = "Anual";
			break;
		default:
			mesString = "Invalido";
		}
		return mesString;
	}
}
