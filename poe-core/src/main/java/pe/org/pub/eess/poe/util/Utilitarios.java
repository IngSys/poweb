package pe.org.pub.eess.poe.util;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.print.*;
import java.beans.PropertyVetoException;
import java.io.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import com.toedter.calendar.JDateChooser;

public final class Utilitarios extends JLabel implements Runnable {

	/**
	 * serial versionUID 1.0.0
	 */
	private static final long serialVersionUID = 1L;
	private static final String[] UNIDADES = { "", "uno ", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ",
			"ocho ", "nueve " };
	private static final String[] DECENAS = { "diez ", "once ", "doce ", "trece ", "catorce ", "quince ", "dieciseis ",
			"diecisiete ", "dieciocho ", "diecinueve", "veinte ", "treinta ", "cuarenta ", "cincuenta ", "sesenta ",
			"setenta ", "ochenta ", "noventa " };
	private static final String[] CENTENAS = { "", "ciento ", "doscientos ", "trecientos ", "cuatrocientos ",
			"quinientos ", "seiscientos ", "setecientos ", "ochocientos ", "novecientos " };

	public static String[] Dias_Semana = { "Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado" };
	public static String[] Meses_Anio = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
			"Setiembre", "Octubre", "Noviembre", "Diciembre" };
	public static int[] Hora = { 12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
	public static String[] Horario = { "a.m.", "p.m." };
	public static final int HORA_SISTEMA = 0;
	public static final int FECHA_SISTEMA = 1;

	private static TableRowSorter<AbstractTableModel> clasificador;
	private static JTextField tftxt;

	private static Integer width_x = 0;
	private static Integer height_y = 0;
	// private static Integer segwidth_x = 0;
	// private static Integer segheight_y = 0;

	private int op = -1;
	private Thread hilo;

	public Utilitarios(int util) {
		this.op = util;
		setHorizontalAlignment(JLabel.CENTER);
		setForeground(Color.WHITE);
		setFont(new java.awt.Font("Tahoma", 1, 11));
		hilo = new Thread(this);
		hilo.start();
	}

	public Utilitarios() {

	}
	/*
	 * ---------------------------------- Simulador dinamico de fecha y hora
	 * ----------------------------------
	 */

	@Override
	public void run() {
		while (true) {
			if (op != -1) {
				Date hoy = new Date();
				if (op == HORA_SISTEMA) {
					SimpleDateFormat hora = new SimpleDateFormat("h:mm:ss a");
					setText(hora.format(hoy));
				} else if (op == FECHA_SISTEMA) {
					SimpleDateFormat fecha = new SimpleDateFormat("E dd/MM/yyyy ");
					setText(fecha.format(hoy).toUpperCase());
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
			}
		}
	}
	/*
	 * -------------------- Formateador Numerico --------------------
	 */

	public static String numberFormat(double src, String fmt) {// Format : ###.####
		fmt = fmt.replaceAll("#", "0");
		DecimalFormat df = new DecimalFormat(fmt);
		return df.format(src);
	}

	public static String numberFormat(long src, String fmt) {// Format : ###.####
		fmt = fmt.replaceAll("#", "0");
		DecimalFormat df = new DecimalFormat(fmt);
		return df.format(src);
	}
	/*----------------------------------------------------------------------
	 * Casteador de datos de java.util a java.sql y viceversa
	 * ---------------------------------------------------------------------
	 */

	public static java.util.Date castDate_SQL_UTIL(java.sql.Date df) {
		return new java.util.Date(df.getTime());
	}

	public static java.sql.Date castDate_UTIL_SQL(java.util.Date df) {
		return new java.sql.Date(df.getTime());
	}

	public static java.sql.Timestamp castTimestamp_UTIL_SQL(java.util.Date df) {
		Date dat = new Date();
		df.setHours(dat.getHours());
		df.setMinutes(dat.getMinutes());
		df.setSeconds(dat.getSeconds());
		return new java.sql.Timestamp(df.getTime());
	}

	public static void captureDimensionInternalFrame(Integer dimwidth, Integer dimheight) {
		width_x = dimwidth;
		height_y = dimheight;
		// segwidth_x = dimwidth;
		// segheight_y = dimheight;

	}

	/*
	 * ------------------------------------------------------ Insertador de frame
	 * internos en un panel de escritorio
	 * ------------------------------------------------------
	 */

	public static void insertaInternalFrame(JInternalFrame jf, JDesktopPane jd) throws PropertyVetoException {
		if (!jf.isShowing()) {
			if (jf.isIcon()) {
				jf.setIcon(false);
			} else {
				jf.pack();
				try {
					jd.add(jf);
				} catch (IllegalArgumentException e) {
					jd.remove(jf);
					jd.add(jf);
				}
				jf.setLocation(((jd.getWidth() / 2) - (jf.getWidth() / 2)),
						((jd.getHeight() / 2) - (jf.getHeight() / 2)));
				jf.show();
				jf.toFront();
			}
		} else {
			jf.toFront();
		}
		// jd.updateUI();
	}
	/*
	 * este metodo me ayudara a poner dos frames en una posion adecuada
	 * ------------------------------------------------------ Inserta el frame a una
	 * posicion diferente del centro internos en un panel de escritorio
	 * ------------------------------------------------------
	 */

	public static void insertLocationInternalFrame(JInternalFrame jf, JDesktopPane jd) throws PropertyVetoException {
		// ancho=jf.getWidth();
		if (!jf.isShowing()) {
			if (jf.isIcon()) {
				jf.setIcon(false);
			} else {
				jf.pack();
				try {
					jd.add(jf);
				} catch (IllegalArgumentException e) {
					jd.remove(jf);
					jd.add(jf);
				}
				// jf.reshape(0, 0, 100, 100);
				jf.setLocation((jd.getWidth() / 2 - (jf.getWidth() + width_x) / 2),
						(jd.getHeight() / 2 - jf.getHeight() / 2));
				width_x = jf.getWidth();
				jf.show();
				jf.toFront();
			}
		} else {
			jf.toFront();
		}
	}
	/*
	 * este metodo me ayudara a poner dos frames en una posion adecuada
	 * ------------------------------------------------------ Inserta el frame a una
	 * posicion diferente del centro internos en un panel de escritorio
	 * ------------------------------------------------------
	 */

	public static void insertPositionInternalFrame(JInternalFrame jf, JDesktopPane jd) throws PropertyVetoException {
		if (!jf.isShowing()) {
			if (jf.isIcon()) {
				jf.setIcon(false);
			} else {
				jf.pack();
				try {
					jd.add(jf);
				} catch (IllegalArgumentException e) {
					jd.remove(jf);
					jd.add(jf);
				}
				// jf.reshape(0, 0, 100, 100);
				jf.setLocation(((jd.getWidth() / 2) + (width_x - jf.getWidth()) / 2),
						((jd.getHeight() / 2) - (jf.getHeight() / 2)));
				// jf.setLocation(2, 2);
				// width_x = ((jd.getWidth() / 2) + (width_x -jf.getWidth()) / 2);
				// height_y = ((jd.getHeight() / 2) - (jf.getHeight() / 2));
				jf.show();
				jf.toFront();
			}
		} else {
			jf.toFront();
		}
	}

	// public static int getWidthX() {
	// return width_x;
	// }
	//
	// public static int getHeightX() {
	// return height_y;
	// }
	public static void closeInternalFrame(JInternalFrame jf, JDesktopPane jd) throws PropertyVetoException {
		jf.doDefaultCloseAction();
		jd.remove(jf);
	}
	/*
	 * --------------------------------------------- Filtrador de busqueda en una
	 * tabla de objetos ---------------------------------------------
	 */

	public static void filtradorBusqueda(AbstractTableModel mdl, JTable tb, JTextField txt) {
		clasificador = new TableRowSorter<AbstractTableModel>(mdl);
		tb.setModel(mdl);
		tb.setRowSorter(clasificador);
		actualizadorFiltrado(txt);
	}

	public static void actualizadorFiltrado(JTextField txt) {
		tftxt = txt;
		txt.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent e) {
				nuevoFiltradoProductos();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				nuevoFiltradoProductos();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				nuevoFiltradoProductos();
			}
		});
	}

	private static void nuevoFiltradoProductos() {
		RowFilter<AbstractTableModel, Object> Filtrador_Filas = null;
		try {
			Filtrador_Filas = RowFilter.regexFilter(tftxt.getText(), 0);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		clasificador.setRowFilter(Filtrador_Filas);
	}
	/*
	 * --------------------------------------------- Inpresor de Log para hacer
	 * seguimiento de excepciones ---------------------------------------------
	 */

	public static void printException(Exception exRef) {
		exRef.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error: \n" + exRef.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	/*
	 * ----------------------------- Recuperador de path del direcctorio actual
	 * -----------------------------
	 */
	public static String getComand(String inf) {
		return inf.substring((inf.indexOf("=")) + 1, inf.length());
	}
	/*
	 * ----------------------------- Validador de Letras y Numeros
	 * -----------------------------
	 */

	public static void validaNumeroCaracteres(JTextField txt, int cant) {
		String textAux = "";
		for (int i = 0; i < txt.getText().length(); i++) {
			if (textAux.length() < cant) {
				textAux += txt.getText().charAt(i);
			}
		}
		txt.setText(textAux);
	}

	public static void validaNumeroCaracteres(JTextArea txt, int cant) {
		String textAux = "";
		for (int i = 0; i < txt.getText().length(); i++) {
			if (textAux.length() < cant) {
				textAux += txt.getText().charAt(i);
			}
		}
		txt.setText(textAux);
	}

	public static int getNumeroCaracteres(JTextField txt) {
		return txt.getText().length();
	}

	public static int getNumeroCaracteres(JTextArea txt) {
		return txt.getText().length();
	}

	public static int getNumeroCaracteres(JTextPane txt) {
		return txt.getText().length();
	}

	public static void validaCaracterNumerico(KeyEvent e, JTextField txt) {
		Character caract = new Character(e.getKeyChar());
		if (!esNumerico(caract)) {
			String textAux = "";
			for (int i = 0; i < txt.getText().length(); i++) {
				if (esNumerico(new Character(txt.getText().charAt(i)))) {
					textAux += txt.getText().charAt(i);
				}
			}
			txt.setText(textAux);
			// getToolkit().beep();
		}
	}

	public static void validaCaracterNumerico(KeyEvent e, JTextArea txt) {
		Character caract = new Character(e.getKeyChar());
		if (!esNumerico(caract)) {
			String textAux = "";
			for (int i = 0; i < txt.getText().length(); i++) {
				if (esNumerico(new Character(txt.getText().charAt(i)))) {
					textAux += txt.getText().charAt(i);
				}
			}
			txt.setText(textAux);
			// getToolkit().beep();
		}
	}

	public static void validaCaracterNumerico(KeyEvent e, JTextPane txt) {
		Character caract = new Character(e.getKeyChar());
		if (!esNumerico(caract)) {
			String textAux = "";
			for (int i = 0; i < txt.getText().length(); i++) {
				if (esNumerico(new Character(txt.getText().charAt(i)))) {
					textAux += txt.getText().charAt(i);
				}
			}
			txt.setText(textAux);
			// getToolkit().beep();
		}
	}

	public static void validaCaracterNumerico(KeyEvent e, JEditorPane txt) {
		Character caract = new Character(e.getKeyChar());
		if (!esNumerico(caract)) {
			String textAux = "";
			for (int i = 0; i < txt.getText().length(); i++) {
				if (esNumerico(new Character(txt.getText().charAt(i)))) {
					textAux += txt.getText().charAt(i);
				}
			}
			txt.setText(textAux);
			// getToolkit().beep();
		}
	}

	public static boolean esNumerico(Character caracter) {
		char caract = caracter.charValue();
		if (!(Character.isDigit(caract) || caract == KeyEvent.VK_SPACE || caract == KeyEvent.VK_BACK_SPACE
				|| caract == KeyEvent.VK_ENTER)) {
			return false;
		} else {
			return true;
		}
	}

	public static void validaCaracterAlfabetico(KeyEvent e, JTextField txt) {
		Character caract = new Character(e.getKeyChar());
		if (!esAlfabetico(caract)) {
			String textAux = "";
			for (int i = 0; i < txt.getText().length(); i++) {
				if (esAlfabetico(new Character(txt.getText().charAt(i)))) {
					textAux += txt.getText().charAt(i);
				}
			}
			txt.setText(textAux);
			// getToolkit().beep();
		}
	}

	public static void validaCaracterAlfabetico(KeyEvent e, JTextArea txt) {
		Character caract = new Character(e.getKeyChar());
		if (!esAlfabetico(caract)) {
			String textAux = "";
			for (int i = 0; i < txt.getText().length(); i++) {
				if (esAlfabetico(new Character(txt.getText().charAt(i)))) {
					textAux += txt.getText().charAt(i);
				}
			}
			txt.setText(textAux);
			// getToolkit().beep();
		}
	}

	public static void validaCaracterAlfabetico(KeyEvent e, JTextPane txt) {
		Character caract = new Character(e.getKeyChar());
		if (!esAlfabetico(caract)) {
			String textAux = "";
			for (int i = 0; i < txt.getText().length(); i++) {
				if (esAlfabetico(new Character(txt.getText().charAt(i)))) {
					textAux += txt.getText().charAt(i);
				}
			}
			txt.setText(textAux);
			// getToolkit().beep();
		}
	}

	public static void validaCaracterAlfabetico(KeyEvent e, JEditorPane txt) {
		Character caract = new Character(e.getKeyChar());
		if (!esAlfabetico(caract)) {
			String textAux = "";
			for (int i = 0; i < txt.getText().length(); i++) {
				if (esAlfabetico(new Character(txt.getText().charAt(i)))) {
					textAux += txt.getText().charAt(i);
				}
			}
			txt.setText(textAux);
			// getToolkit().beep();
		}
	}

	public static boolean esAlfabetico(Character caracter) {
		char caract = caracter.charValue();
		if (!(Character.isLetter(caract) || caract == KeyEvent.VK_SPACE || caract == KeyEvent.VK_BACK_SPACE
				|| caract == KeyEvent.VK_ENTER)) {
			return false;
		} else {
			return true;
		}
	}

	public static void validaCaracterAlfabeticoCM(KeyEvent e, JTextField txt) {
		Character caract = new Character(e.getKeyChar());
		if (!esAlfabeticoCM(caract)) {
			String textAux = "";
			for (int i = 0; i < txt.getText().length(); i++) {
				if (esAlfabeticoCM(new Character(txt.getText().charAt(i)))) {
					textAux += txt.getText().charAt(i);
				}
			}
			txt.setText(textAux);
			// getToolkit().beep();
		}
	}

	public static void validaCaracterAlfabeticoCM(KeyEvent e, JTextArea txt) {
		Character caract = new Character(e.getKeyChar());
		if (!esAlfabeticoCM(caract)) {
			String textAux = "";
			for (int i = 0; i < txt.getText().length(); i++) {
				if (esAlfabeticoCM(new Character(txt.getText().charAt(i)))) {
					textAux += txt.getText().charAt(i);
				}
			}
			txt.setText(textAux);
			// getToolkit().beep();
		}
	}

	public static void validaCaracterAlfabeticoCM(KeyEvent e, JTextPane txt) {
		Character caract = new Character(e.getKeyChar());
		if (!esAlfabeticoCM(caract)) {
			String textAux = "";
			for (int i = 0; i < txt.getText().length(); i++) {
				if (esAlfabeticoCM(new Character(txt.getText().charAt(i)))) {
					textAux += txt.getText().charAt(i);
				}
			}
			txt.setText(textAux);
			// getToolkit().beep();
		}
	}

	public static void validaCaracterAlfabeticoCM(KeyEvent e, JEditorPane txt) {
		Character caract = new Character(e.getKeyChar());
		if (!esAlfabeticoCM(caract)) {
			String textAux = "";
			for (int i = 0; i < txt.getText().length(); i++) {
				if (esAlfabeticoCM(new Character(txt.getText().charAt(i)))) {
					textAux += txt.getText().charAt(i);
				}
			}
			txt.setText(textAux);
			// getToolkit().beep();
		}
	}

	public static boolean esAlfabeticoCM(Character caracter) {
		char caract = caracter.charValue();
		if (!(Character.isLetter(caract) || caract == KeyEvent.VK_SPACE || caract == KeyEvent.VK_BACK_SPACE
				|| caract == KeyEvent.VK_ENTER || caract == KeyEvent.VK_COMMA)) {
			return false;
		} else {
			return true;
		}
	}

	public static void validaCaracterAlfabeticoNumerico(KeyEvent e, JTextField txt) {
		Character caract = new Character(e.getKeyChar());
		if (!esAlfabeticoNumerico(caract)) {
			String textAux = "";
			for (int i = 0; i < txt.getText().length(); i++) {
				if (esAlfabeticoNumerico(new Character(txt.getText().charAt(i)))) {
					textAux += txt.getText().charAt(i);
				}
			}
			txt.setText(textAux);
			// getToolkit().beep();
		}
	}

	public static void validaCaracterAlfabeticoNumerico(KeyEvent e, JTextArea txt) {
		Character caract = new Character(e.getKeyChar());
		if (!esAlfabeticoNumerico(caract)) {
			String textAux = "";
			for (int i = 0; i < txt.getText().length(); i++) {
				if (esAlfabeticoNumerico(new Character(txt.getText().charAt(i)))) {
					textAux += txt.getText().charAt(i);
				}
			}
			txt.setText(textAux);
			// getToolkit().beep();
		}
	}

	public static void validaCaracterAlfabeticoNumerico(KeyEvent e, JTextPane txt) {
		Character caract = new Character(e.getKeyChar());
		if (!esAlfabeticoNumerico(caract)) {
			String textAux = "";
			for (int i = 0; i < txt.getText().length(); i++) {
				if (esAlfabeticoNumerico(new Character(txt.getText().charAt(i)))) {
					textAux += txt.getText().charAt(i);
				}
			}
			txt.setText(textAux);
			// getToolkit().beep();
		}
	}

	public static void validaCaracterAlfabeticoNumerico(KeyEvent e, JEditorPane txt) {
		Character caract = new Character(e.getKeyChar());
		if (!esAlfabeticoNumerico(caract)) {
			String textAux = "";
			for (int i = 0; i < txt.getText().length(); i++) {
				if (esAlfabeticoNumerico(new Character(txt.getText().charAt(i)))) {
					textAux += txt.getText().charAt(i);
				}
			}
			txt.setText(textAux);
			// getToolkit().beep();
		}
	}

	public static boolean esAlfabeticoNumerico(Character caracter) {
		char caract = caracter.charValue();
		if (!(Character.isDigit(caract) || Character.isLetter(caract) || caract == KeyEvent.VK_SPACE
				|| caract == KeyEvent.VK_BACK_SPACE || caract == KeyEvent.VK_ENTER)) {
			return false;
		} else {
			return true;
		}
	}

	public static void validaCaracterAlfabeticoNumericoSPB(KeyEvent e, JTextField txt) {
		Character caract = new Character(e.getKeyChar());
		if (!esAlfabeticoNumericoSPB(caract)) {
			String textAux = "";
			for (int i = 0; i < txt.getText().length(); i++) {
				if (esAlfabeticoNumericoSPB(new Character(txt.getText().charAt(i)))) {
					textAux += txt.getText().charAt(i);
				}
			}
			txt.setText(textAux);
			// getToolkit().beep();
		}
	}

	public static void validaCaracterAlfabeticoNumericoSPB(KeyEvent e, JTextArea txt) {
		Character caract = new Character(e.getKeyChar());
		if (!esAlfabeticoNumericoSPB(caract)) {
			String textAux = "";
			for (int i = 0; i < txt.getText().length(); i++) {
				if (esAlfabeticoNumericoSPB(new Character(txt.getText().charAt(i)))) {
					textAux += txt.getText().charAt(i);
				}
			}
			txt.setText(textAux);
			// getToolkit().beep();
		}
	}

	public static void validaCaracterAlfabeticoNumericoSPB(KeyEvent e, JTextPane txt) {
		Character caract = new Character(e.getKeyChar());
		if (!esAlfabeticoNumericoSPB(caract)) {
			String textAux = "";
			for (int i = 0; i < txt.getText().length(); i++) {
				if (esAlfabeticoNumericoSPB(new Character(txt.getText().charAt(i)))) {
					textAux += txt.getText().charAt(i);
				}
			}
			txt.setText(textAux);
			// getToolkit().beep();
		}
	}

	public static void validaCaracterAlfabeticoNumericoSPB(KeyEvent e, JEditorPane txt) {
		Character caract = new Character(e.getKeyChar());
		if (!esAlfabeticoNumericoSPB(caract)) {
			String textAux = "";
			for (int i = 0; i < txt.getText().length(); i++) {
				if (esAlfabeticoNumericoSPB(new Character(txt.getText().charAt(i)))) {
					textAux += txt.getText().charAt(i);
				}
			}
			txt.setText(textAux);
			// getToolkit().beep();
		}
	}

	public static boolean esAlfabeticoNumericoSPB(Character caracter) {
		char caract = caracter.charValue();
		if (!(Character.isDigit(caract) || Character.isLetter(caract) || caract == KeyEvent.VK_SPACE // espacio
				|| caract == KeyEvent.VK_BACK_SPACE // retroceso
				|| caract == KeyEvent.VK_COMMA // coma
				|| caract == KeyEvent.VK_PERIOD // punto
				|| caract == KeyEvent.VK_COLON // dos puntos
				|| caract == KeyEvent.VK_SEMICOLON || caract == KeyEvent.VK_ENTER)) { // punto y coma
			return false;
		} else {
			return true;
		}
	}

	public static void validaCaracterNumericoMoneda(KeyEvent e, JTextField txt) {
		Character caract = new Character(e.getKeyChar());
		if (!esCaracterNumericoMoneda(caract)) {
			String textAux = "";
			for (int i = 0; i < txt.getText().length(); i++) {
				if (esCaracterNumericoMoneda(new Character(txt.getText().charAt(i)))) {
					textAux += txt.getText().charAt(i);
				}
			}
			txt.setText(textAux);
			// getToolkit().beep();
		}
	}

	public static boolean esCaracterNumericoMoneda(Character caracter) {
		char caract = caracter.charValue();
		if (!(Character.isDigit(caract) || caract == KeyEvent.VK_SPACE // espacio
				|| caract == KeyEvent.VK_BACK_SPACE // retroceso
				|| caract == KeyEvent.VK_COMMA // coma
				|| caract == KeyEvent.VK_PERIOD // punto
				|| caract == KeyEvent.VK_ENTER)) { // punto y coma
			return false;
		} else {
			return true;
		}
	}
	/*
	 * --------------------------------- Inmovilisador de Columnas de Tabla
	 * ---------------------------------
	 */

	public static void inmovilizaColumnas(JTable table) {
		/*
		 * table.getTableHeader().disable();
		 * table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		 */
		table.setRowSelectionAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
	}
	/*
	 * --------------------------------- Formateador de columnas de tabla
	 * ---------------------------------
	 */

	public static void formateaColumna(int index, JTable table, int size) {
		table.getColumnModel().getColumn(index).setResizable(false);
		table.getColumnModel().getColumn(index).setMinWidth(size);
		table.getColumnModel().getColumn(index).setWidth(size);
		table.getColumnModel().getColumn(index).setMaxWidth(size);
	}

	public static void formateaColumnaResidimensionable(int index, JTable table, int size) {
		table.getColumnModel().getColumn(index).setResizable(true);
		table.getColumnModel().getColumn(index).setMinWidth(size);
		table.getColumnModel().getColumn(index).setMaxWidth(size + 100);
	}
	/*
	 * --------------------------------- Alinea Cabeceras Columna Tabla
	 * -----------------------------------
	 */

	public static void alinearTextoCabeceraColumnaDerecha(int index, JTable table) {

		TableCellRenderer render = new DefaultTableCellRenderer() {
			/**
			 * serialVersionUID 1.0.0
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				JLabel componet = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
						column);
				componet.setHorizontalAlignment(SwingConstants.RIGHT);
				componet.setFont(new Font("Tahoma", Font.BOLD, 11));
				componet.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
				return componet;
			}
		};
		table.getColumnModel().getColumn(index).setHeaderRenderer(render);
	}

	public static void alinearTextoCabeceraColumnaIzquierda(int index, JTable table) {
		TableCellRenderer render = new DefaultTableCellRenderer() {
			/**
			 * serialVersionUID 1.0.0
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				JLabel componet = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
						column);
				componet.setHorizontalAlignment(SwingConstants.LEFT);
				componet.setFont(new Font("Tahoma", Font.BOLD, 11));
				componet.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
				return componet;
			}
		};
		table.getColumnModel().getColumn(index).setHeaderRenderer(render);
	}

	public static void alinearTextoCabeceraColumnaCentro(int index, JTable table) {
		TableCellRenderer render = new DefaultTableCellRenderer() {
			/**
			 * serialVersionUID 1.0.0
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				JLabel componet = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
						column);
				componet.setHorizontalAlignment(SwingConstants.CENTER);
				componet.setFont(new Font("Tahoma", Font.BOLD, 11));
				componet.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
				return componet;
			}
		};

		table.getColumnModel().getColumn(index).setHeaderRenderer(render);
	}
	/*
	 * --------------------- Alinea Datos de Tabla ---------------------
	 */

	public static void alinearDatosColumnaTablaDerecha(int index, JTable table) {
		TableCellRenderer render = new DefaultTableCellRenderer() {
			/**
			 * serialVersionUID 1.0.0
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				JLabel componet = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
						column);
				componet.setHorizontalAlignment(SwingConstants.RIGHT);
				return componet;
			}
		};
		table.getColumnModel().getColumn(index).setCellRenderer(render);
	}

	public static void alinearDatosColumnaTablaIzquierda(int index, JTable table) {
		TableCellRenderer render = new DefaultTableCellRenderer() {
			/**
			 * serialVersionUID 1.0.0
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				JLabel componet = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
						column);
				componet.setHorizontalAlignment(SwingConstants.LEFT);
				return componet;
			}
		};
		table.getColumnModel().getColumn(index).setCellRenderer(render);
	}

	public static void alinearDatosColumnaTablaCentro(int index, JTable table) {
		TableCellRenderer render = new DefaultTableCellRenderer() {
			/**
			 * serialVersionUID 1.0.0
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				JLabel componet = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
						column);
				componet.setHorizontalAlignment(SwingConstants.CENTER);
				return componet;
			}
		};
		table.getColumnModel().getColumn(index).setCellRenderer(render);
	}
	/*
	 * ------------------------------------ Colorear una fila de un Jtable al
	 * seleccionar la fila ------------------------------------
	 */

	// ----------------------------------------------------
	/*
	 * ------------------------------------ Personaliza Comportamiento de ventanas
	 * ------------------------------------
	 */
	public static void centreaVentana(Window vent) {
		vent.setLocationRelativeTo(null);
	}

	public void setIconoVentana(Window vent, String resourcePath) {
		Image icon = Toolkit.getDefaultToolkit().createImage(getClass().getResource(resourcePath));
		vent.setIconImage(icon);
	}

	public void setIconoVentana(JInternalFrame vent, String resourcePath) {
		ImageIcon icon = new ImageIcon(getClass().getResource(resourcePath));
		vent.setFrameIcon(icon);
	}

	public static void maximizarAbsoluta(Frame ref) {
		ref.setExtendedState(Frame.MAXIMIZED_BOTH);
	}

	public static void maximizar(Frame ref) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenSize.height = screenSize.height - 40;
		screenSize.width = screenSize.width - 10;
		ref.setSize(screenSize);
	}

	public static void restaurar(Frame ref) {
		ref.setExtendedState(Frame.NORMAL);
	}

	public static void maximizarHorizontalmente(Frame ref) {
		ref.setExtendedState(Frame.MAXIMIZED_HORIZ);
	}

	public static void maximizarVerticalmente(Frame ref) {
		ref.setExtendedState(Frame.MAXIMIZED_VERT);
	}
	/*
	 * ------------------------------- Gestor de Impresion Componentes
	 * -------------------------------
	 */

	public static void imprimirSilencioso(Printable prntbl) throws PrinterException {
		PrinterJob pj = PrinterJob.getPrinterJob();
		/*
		 * PageFormat defaultFormat = new PageFormat(); defaultFormat =
		 * pj.defaultPage(defaultFormat);
		 */
		pj.setPrintable(prntbl);
		pj.print();
	}

	public static void imprimirDialogo(Printable prntbl) throws PrinterException {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(prntbl);
		boolean aceptar_impresion = job.printDialog();
		if (aceptar_impresion) {
			job.print();
		}
	}

	public static int imprimir(Graphics graphics, PageFormat pageFormat, int pageIndex, JComponent component) {
		if (pageIndex > 0) {
			return Printable.NO_SUCH_PAGE;
		} else {
			Graphics2D g2d = (Graphics2D) graphics;
			g2d.setClip(0, 0, component.getWidth(), component.getHeight());
			g2d.translate(0, 0);
			// g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
			// g2d.scale(
			// ((Number)(scale/100)).doubleValue(),((Number)(scale/100)).doubleValue());
			g2d.scale(0.408, 0.421);
			component.printAll(graphics);
			return Printable.PAGE_EXISTS;
		}
	}

	public static String getFechaUltimaModificacionCorto(File fl) {
		Date dt = new Date(fl.lastModified());
		Calendar gc = new GregorianCalendar();
		gc.setTime(dt);
		return (new DecimalFormat("00").format(gc.get(Calendar.DATE)) + "/"
				+ new DecimalFormat("00").format((gc.get(Calendar.MONTH) + 1)) + "/" + gc.get(Calendar.YEAR) + " "
				+ new DecimalFormat("00").format(Hora[gc.get(Calendar.HOUR)]) + ":"
				+ new DecimalFormat("00").format(gc.get(Calendar.MINUTE)) + ":"
				+ new DecimalFormat("00").format(gc.get(Calendar.SECOND)) + " " + Horario[gc.get(Calendar.AM_PM)]);
	}

	public static String toUpperCaseInit(String src) {
		String nmsg = "";
		int pos, sz = src.length();
		for (int i = 0; i < sz; i++) {
			src = src.trim();
			pos = src.indexOf(" ");
			if (pos != -1) {
				nmsg += toUpperCaseInitLetter(src.substring(0, pos)) + " ";
				src = src.substring(pos, src.length()).trim();
			} else {
				nmsg += toUpperCaseInitLetter(src);
				i = sz;
			}
		}
		return nmsg;
	}

	private static String toUpperCaseInitLetter(String src) {
		String tmp1, tmp2;
		tmp1 = ("" + src.charAt(0)).toUpperCase();
		tmp2 = src.substring(1, src.length()).toLowerCase();
		return (tmp1 + tmp2);
	}

	public static int cantidadPalabras(String src) {
		int cant = 0, pos, sz = src.length();
		for (int i = 0; i < sz; i++) {
			src = src.trim();
			pos = src.indexOf(" ");
			if (pos != -1) {
				cant++;
				src = src.substring(pos, src.length()).trim();
			} else {
				cant++;
				i = sz;
			}
		}
		return cant;
	}

	public static int cantidadOcurrenciasPatron(String cadena, String patron) {
		int count = 0, start = 0, len = patron.length();
		while ((start = cadena.indexOf(patron, start) + 1) > 0) {
			count++;
			start += len;
		}
		return count;
	}

	public static String getFechaUltimaModificacionLargo(File fl) {
		
		Date dt = null;
		Calendar gc = null;
		dt = new Date(fl.lastModified());
		gc = new GregorianCalendar();
		gc.setTime(dt);
		return (Dias_Semana[dt.getDay()] + ", " + new DecimalFormat("00").format(gc.get(Calendar.DATE)) + " de "
				+ Meses_Anio[gc.get(Calendar.MONTH)] + " de " + gc.get(Calendar.YEAR) + ", "
				+ new DecimalFormat("00").format(Hora[gc.get(Calendar.HOUR)]) + ":"
				+ new DecimalFormat("00").format(gc.get(Calendar.MINUTE)) + ":"
				+ new DecimalFormat("00").format(gc.get(Calendar.SECOND)) + " " + Horario[gc.get(Calendar.AM_PM)]);
	}

	public static String convertirFecha_Letra(int dia, int mes, int anio) {
		String fecha = "";
		fecha += convertirNumero_Letras((String.valueOf(dia)), true) + convertirMes(mes)
				+ convertirNumero_Letras((String.valueOf(anio + 1900)), true);
		return fecha;
	}

	public static String convertirNumero_Letras(String numero, boolean mayusculas) {

		String literal = "";
		String Num[] = numero.split(",");

		if (Integer.parseInt(Num[0]) > 999) {// si es miles
			literal = getMiles(Num[0]);
		} else if (Integer.parseInt(Num[0]) > 99) {// si es centena
			literal = getCentenas(Num[0]);
		} else if (Integer.parseInt(Num[0]) > 9) {// si es decena
			literal = getDecenas(Num[0]);
		} else {// sino unidades -> 9
			literal = getUnidades(Num[0]);
		}
		// devuelve el resultado en mayusculas o minusculas
		if (mayusculas) {
			return (literal).toUpperCase();
		} else {
			return (literal);
		}
	}

	/* funciones para convertirNumero_Letras los numeros a literales */
	private static String getUnidades(String numero) {// 1 - 9
		// si tuviera algun 0 antes se lo quita -> 09 = 9 o 009=9
		String num = numero.substring(numero.length() - 1);
		return UNIDADES[Integer.parseInt(num)];
	}

	private static String getDecenas(String num) {// 99
		int n = Integer.parseInt(num);
		if (n < 10) {// para casos como -> 01 - 09
			return getUnidades(num);
		} ////////////////////////////
		else if (n >= 20 && n < 30) {// para 20...99
			String u = getUnidades(num);
			if (u.equals("")) { // para 20,30,40,50,60,70,80,90
				return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8];
			} else {
				return "veinti" + u;
			}
		} ///////////////
		else if (n >= 30) {// para 20...99
			String u = getUnidades(num);
			if (u.equals("")) { // para 20,30,40,50,60,70,80,90
				return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8];
			} else {
				return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8] + "y " + u;
			}
		} else {// numeros entre 11 y 19
			return DECENAS[n - 10];
		}
	}

	private static String getCentenas(String num) {// 999 o 099
		if (Integer.parseInt(num) > 99) {// es centena
			if (Integer.parseInt(num) == 100) {// caso especial
				return " cien ";
			} else {
				return CENTENAS[Integer.parseInt(num.substring(0, 1))] + getDecenas(num.substring(1));
			}
		} else {// por Ej. 099
			// se quita el 0 antes de convertirNumero_Letras a decenas
			return getDecenas(Integer.parseInt(num) + "");
		}
	}

	private static String getMiles(String numero) {// 999 999
		// obtiene las centenas
		String c = numero.substring(numero.length() - 3);
		// obtiene los miles
		String m = numero.substring(0, numero.length() - 3);
		String n;
		// se comprueba que miles tenga valor entero
		if (Integer.parseInt(m) > 0) {
			if (Integer.parseInt(m) == 1) {
				return "mil " + getCentenas(c);
			} else {
				n = getCentenas(m);
				return n + "mil " + getCentenas(c);
			}
		} else {
			return "" + getCentenas(c);
		}
	}

	private static String convertirMes(int mes) {
		return ("DE " + Meses_Anio[mes].toUpperCase() + " DEL ");
	}

	public static String mesLetras(int mes) {
		return (Meses_Anio[mes].toUpperCase());
	}
	/*
	 * ============ESTE METODO ME CALCULA LA EDAD ENTRE DOS FECHAS DADAS===========
	 * ======FECHA DE NACIMIENTO Y ASTA LA FECHA DADA======= EJEMPLO FECHA
	 * NACIMIENTO INGRESADO 12/09/1991 AND FECHA FINAL INGRESADO 01/12/2005
	 */

	public static int obtenerEdadEntreDosFechas(Date fechaNacimiento, Date fechafinal) {
		return obtenerEdadEntreDosFechas(fechaNacimiento.getYear(), fechaNacimiento.getMonth(),
				fechaNacimiento.getDate(), fechafinal.getYear(), fechafinal.getMonth(), fechafinal.getDate());
	}

	private static int obtenerEdadEntreDosFechas(int anioNacimiento, int mesNacimiento, int diaNacimiento, int anioF,
			int mesF, int diaF) {
		// Date fechaActual = new Date();
		if (mesF >= mesNacimiento) {
			if (mesF > mesNacimiento) {
				return Math.abs(anioF - anioNacimiento);
			} else {
				if (diaF >= diaNacimiento) {
					return Math.abs(anioF - anioNacimiento);
				} else {
					return Math.abs((anioF - 1) - anioNacimiento);
				}
			}
		} else {
			return Math.abs((anioF - 1) - anioNacimiento);
		}
	}

	/*
	 * ============ESTE METODO ME CALCULA LA EDAD EN DIAS SI AUN NO TIENE MESES
	 * CUMPLIDOS,================ =====MESES SI AUN NO TIENE AÑOS CUMPLIDOS EN CASO
	 * CONTRARIO CALCULARA SU EDAD EN AÑOS CUMPLIDOSS ======
	 * ===========================FECHA DE NACIMIENTO Y ASTA LA FECHA
	 * DADA=================================== ========EJEMPLO FECHA NACIMIENTO
	 * INGRESADO 12/09/1991 AND FECHA FINAL INGRESADO 01/12/2005============
	 */
	public static String obtenerEdadEnYYMMDDEntreDosFechas(Date fechaNacimiento, Date fechaF) {
		return obtenerEdadEnYYMMDDEntreDosFechas(fechaNacimiento.getYear(), fechaNacimiento.getMonth(),
				fechaNacimiento.getDate(), fechaF);
	}

	private static String obtenerEdadEnYYMMDDEntreDosFechas(int anioNacimiento, int mesNacimiento, int diaNacimiento,
			Date fechaF) {
		// Date fechaActual = new Date();
		// Calendar hoy = Calendar.getInstance();
		String edadd = "", edadm = "", edada = "";
		if (fechaF.getDate() >= diaNacimiento) {
			if (fechaF.getDate() > diaNacimiento) {
				edadd = ("" + Math.abs(fechaF.getDate() - diaNacimiento));
			} else {
				edadd = ("" + 0);
			}

		} else {

			// hoy.add(Calendar.MONTH, -1);
			// fechaActual=fechaActual.
			Calendar c = new GregorianCalendar(fechaF.getYear(), fechaF.getMonth() - 1, 1);
			int daysmonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
			edadd = ("" + Math.abs((daysmonth - diaNacimiento) + fechaF.getDate()));
		}

		if (fechaF.getMonth() > mesNacimiento && fechaF.getDate() > diaNacimiento) {

			edadm = ("" + Math.abs(fechaF.getMonth() - mesNacimiento));

		} else if (fechaF.getMonth() > mesNacimiento && fechaF.getDate() < diaNacimiento) {
			edadm = "" + Math.abs((fechaF.getMonth() - mesNacimiento) - 1);
		} else if (fechaF.getMonth() < mesNacimiento) {
			edadm = "" + Math.abs(12 - (mesNacimiento - fechaF.getMonth()));
		} else if (fechaF.getYear() > anioNacimiento && fechaF.getMonth() == mesNacimiento
				&& fechaF.getDate() < diaNacimiento) {
			edadm = "" + 11;
		} else if (fechaF.getYear() == anioNacimiento && fechaF.getMonth() > mesNacimiento
				&& fechaF.getDate() == diaNacimiento) {
			edadm = "" + (fechaF.getMonth() - mesNacimiento);
		} else if (fechaF.getYear() > anioNacimiento && fechaF.getMonth() > mesNacimiento
				&& fechaF.getDate() == diaNacimiento) {
			edadm = "" + (fechaF.getMonth() - mesNacimiento);
		} else {
			edadm = "" + 0;
		}

		if (fechaF.getYear() > anioNacimiento && fechaF.getMonth() > mesNacimiento) {
			edada = "" + Math.abs(fechaF.getYear() - anioNacimiento);

		} else if (fechaF.getYear() > anioNacimiento && fechaF.getMonth() < mesNacimiento) {
			edada = "" + Math.abs((fechaF.getYear() - anioNacimiento) - 1);
		} else if (fechaF.getYear() > anioNacimiento && fechaF.getMonth() == mesNacimiento
				&& fechaF.getDate() > diaNacimiento) {
			edada = "" + Math.abs((fechaF.getYear() - anioNacimiento));

		} else if (fechaF.getYear() > anioNacimiento && fechaF.getMonth() == mesNacimiento
				&& fechaF.getDate() < diaNacimiento) {
			edada = "" + Math.abs((fechaF.getYear() - anioNacimiento) - 1);
		} else if (fechaF.getYear() > anioNacimiento && fechaF.getMonth() == mesNacimiento
				&& fechaF.getDate() == diaNacimiento) {
			edada = "" + Math.abs((fechaF.getYear() - anioNacimiento));
		} else {
			edada = "" + 0;
		}
		return edada + "-" + edadm + "-" + edadd;

	}

	// CALCULAR EDADES A PARTIR DE LA FECHA DE NACIMIENTO
	public static int obtenerEdad(Date fechaNacimiento) {
		return obtenerEdad(fechaNacimiento.getYear(), fechaNacimiento.getMonth(), fechaNacimiento.getDate());
	}

	private static int obtenerEdad(int anioNacimiento, int mesNacimiento, int diaNacimiento) {
		Date fechaActual = new Date();
		if ((fechaActual.getMonth()) >= mesNacimiento) {
			if ((fechaActual.getMonth()) > mesNacimiento) {
				return Math.abs(fechaActual.getYear() - anioNacimiento);
			} else {
				if (fechaActual.getDate() >= diaNacimiento) {
					return Math.abs(fechaActual.getYear() - anioNacimiento);
				} else {
					return Math.abs((fechaActual.getYear() - 1) - anioNacimiento);
				}
			}
		} else {
			return Math.abs((fechaActual.getYear() - 1) - anioNacimiento);
		}
	}

	public static String obtenerEdadEnYYMMDD(Date fechaNacimiento) {
		return obtenerEdadEnYYMMDD(fechaNacimiento.getYear(), fechaNacimiento.getMonth(), fechaNacimiento.getDate());
	}

	private static String obtenerEdadEnYYMMDD(int anioNacimiento, int mesNacimiento, int diaNacimiento) {
		Date fechaActual = new Date();
		// Calendar hoy = Calendar.getInstance();
		String edadd = "", edadm = "", edada = "";
		if (fechaActual.getDate() >= diaNacimiento) {
			if (fechaActual.getDate() > diaNacimiento) {
				edadd = ("" + Math.abs(fechaActual.getDate() - diaNacimiento));
			} else {
				edadd = ("" + 0);
			}

		} else {

			// hoy.add(Calendar.MONTH, -1);
			// fechaActual=fechaActual.
			Calendar c = new GregorianCalendar(fechaActual.getYear(), fechaActual.getMonth() - 1, 1);
			int daysmonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
			edadd = ("" + Math.abs((daysmonth - diaNacimiento) + fechaActual.getDate()));
		}

		if (fechaActual.getMonth() > mesNacimiento && fechaActual.getDate() > diaNacimiento) {

			edadm = ("" + Math.abs(fechaActual.getMonth() - mesNacimiento));

		} else if (fechaActual.getMonth() > mesNacimiento && fechaActual.getDate() < diaNacimiento) {
			edadm = "" + Math.abs((fechaActual.getMonth() - mesNacimiento) - 1);
		} else if (fechaActual.getMonth() < mesNacimiento) {
			edadm = "" + Math.abs(12 - (mesNacimiento - fechaActual.getMonth()));
		} else if (fechaActual.getYear() > anioNacimiento && fechaActual.getMonth() == mesNacimiento
				&& fechaActual.getDate() < diaNacimiento) {
			edadm = "" + 11;
		} else if (fechaActual.getYear() == anioNacimiento && fechaActual.getMonth() > mesNacimiento
				&& fechaActual.getDate() == diaNacimiento) {
			edadm = "" + (fechaActual.getMonth() - mesNacimiento);
		} else if (fechaActual.getYear() > anioNacimiento && fechaActual.getMonth() > mesNacimiento
				&& fechaActual.getDate() == diaNacimiento) {
			edadm = "" + (fechaActual.getMonth() - mesNacimiento);
		} else {
			edadm = "" + 0;
		}

		if (fechaActual.getYear() > anioNacimiento && fechaActual.getMonth() > mesNacimiento) {
			edada = "" + Math.abs(fechaActual.getYear() - anioNacimiento);

		} else if (fechaActual.getYear() > anioNacimiento && fechaActual.getMonth() < mesNacimiento) {
			edada = "" + Math.abs((fechaActual.getYear() - anioNacimiento) - 1);
		} else if (fechaActual.getYear() > anioNacimiento && fechaActual.getMonth() == mesNacimiento
				&& fechaActual.getDate() > diaNacimiento) {
			edada = "" + Math.abs((fechaActual.getYear() - anioNacimiento));

		} else if (fechaActual.getYear() > anioNacimiento && fechaActual.getMonth() == mesNacimiento
				&& fechaActual.getDate() < diaNacimiento) {
			edada = "" + Math.abs((fechaActual.getYear() - anioNacimiento) - 1);
		} else if (fechaActual.getYear() > anioNacimiento && fechaActual.getMonth() == mesNacimiento
				&& fechaActual.getDate() == diaNacimiento) {
			edada = "" + Math.abs((fechaActual.getYear() - anioNacimiento));
		} else {
			edada = "" + 0;
		}
		return edada + "-" + edadm + "-" + edadd;

	}

	/*
	 * --------------------------------------------------------------------------
	 */
	public static String remplazarPatron(String src, String r1, String r2) {
		return src.trim().replaceAll(r1, r2);
	}

	public static String quitaEspaciosBlancos(String src) {
		return remplazarPatron(src, " ", "");
	}

	public static String prepareStringRefence(String ref) {
		String rf1, rf2;
		int psc = ref.indexOf(",");
		if (psc != -1) {
			rf1 = ref.substring(0, psc).trim();
			rf2 = ref.substring(psc + 1, ref.length()).trim();

			return rf1 + "," + (char) KeyEvent.VK_SPACE + rf2;
		} else {
			return ref.trim();
		}
	}

	public static String[] analyzeStringReference(String ref) {
		String rsp[] = new String[4], tmp[], rf[] = new String[3];

		tmp = splitStringReference(prepareStringRefence(ref));
		rsp[0] = tmp[0].toLowerCase();
		tmp = splitStringReference(tmp[1]);
		rsp[1] = tmp[0].toLowerCase();
		if (tmp[1] != null) {
			tmp = splitStringReference(tmp[1]);
			rsp[2] = tmp[0].toLowerCase();
			if (tmp[1] != null) {
				rsp[3] = tmp[1].toLowerCase();
			}
		} else {// Tiene Un solo apellido y sus nombres
			rf[0] = rsp[0];
			rf[1] = "";
			rf[2] = rsp[1];
			rsp = null;
			return rf;
		}
		if (rsp[3] != null) {
			if (rsp[1].toLowerCase().trim().startsWith("de la")) {// de la en el primer apellido
				rf[0] = rsp[0] + (char) KeyEvent.VK_SPACE + rsp[1];
				rf[1] = rsp[2];
				rf[2] = rsp[3];
				rsp = null;
				return rf;
			} else if (rsp[2].toLowerCase().trim().startsWith("de la")) {// de la en el segundo apellido
				rf[0] = rsp[0];
				rf[1] = rsp[1] + (char) KeyEvent.VK_SPACE + rsp[2];
				rf[2] = rsp[3];
				rsp = null;
				return rf;
			}
		} else {
			rf[0] = rsp[0];
			rf[1] = rsp[1];
			rf[2] = rsp[2];
			rsp = null;
			return rf;
		}
		return rsp;
	}

	public static String[] splitStringReference(String ref) {
		if (ref != null && !ref.trim().equals("")) {
			String nref[] = new String[2];
			int pos, pos_coma;
			ref = ref.toLowerCase().trim();

			pos = ref.indexOf("" + (char) KeyEvent.VK_SPACE); // +(char)KeyEvent.VK_SPACE

			if (pos != -1) {
				if (ref.startsWith("del" + (char) KeyEvent.VK_SPACE)) {
					pos = ref.indexOf("del") + "del".length();

					nref[0] = ref.substring(0, pos).trim();
					nref[1] = ref.substring(pos, ref.length()).trim();
					pos = nref[1].trim().indexOf("" + (char) KeyEvent.VK_SPACE);
					nref[0] += "" + (char) KeyEvent.VK_SPACE + nref[1].substring(0, pos).trim();
					nref[1] = nref[1].substring(pos, nref[1].length()).trim();

					pos_coma = nref[0].indexOf(",");
					if (pos_coma != -1) {
						if (pos_coma == nref[0].length() - 1) {
							nref[0] = nref[0].substring(0, pos_coma);
						}
					} else {
						pos_coma = nref[1].indexOf(",");
						if (pos_coma != -1) {
							if (pos_coma == 0) {
								nref[1] = nref[1].substring(pos_coma + 1, nref[1].length()).trim();
							}
						} else {
							nref[0] = ref.trim();
							nref[1] = null;
						}
					}
				} else if (ref.startsWith("la" + (char) KeyEvent.VK_SPACE)) {
					pos = ref.indexOf("la") + "la".length();

					nref[0] = ref.substring(0, pos).trim();
					nref[1] = ref.substring(pos, ref.length()).trim();
					pos = nref[1].trim().indexOf("" + (char) KeyEvent.VK_SPACE);
					nref[0] += "" + (char) KeyEvent.VK_SPACE + nref[1].substring(0, pos).trim();
					nref[1] = nref[1].substring(pos, nref[1].length()).trim();

					pos_coma = nref[0].indexOf(",");
					if (pos_coma != -1) {
						if (pos_coma == nref[0].length() - 1) {
							nref[0] = nref[0].substring(0, pos_coma);
						}
					} else {
						pos_coma = nref[1].indexOf(",");
						if (pos_coma != -1) {
							if (pos_coma == 0) {
								nref[1] = nref[1].substring(pos_coma + 1, nref[1].length()).trim();
							}
						} else {
							nref[0] = ref.trim();
							nref[1] = null;
						}
					}
				} else if (ref.startsWith("de" + (char) KeyEvent.VK_SPACE)) {

					if (ref.startsWith("de" + (char) KeyEvent.VK_SPACE + "la" + (char) KeyEvent.VK_SPACE)) { // "+(char)KeyEvent.VK_SPACE+"
						pos = ref.indexOf("de" + (char) KeyEvent.VK_SPACE + "la")
								+ ("de" + (char) KeyEvent.VK_SPACE + "la").length();

						nref[0] = ref.substring(0, pos).trim();
						nref[1] = ref.substring(pos, ref.length()).trim();
						pos = nref[1].trim().indexOf("" + (char) KeyEvent.VK_SPACE);
						nref[0] += "" + (char) KeyEvent.VK_SPACE + nref[1].substring(0, pos).trim();
						nref[1] = nref[1].substring(pos, nref[1].length()).trim();
						pos_coma = nref[0].indexOf(",");
						if (pos_coma != -1) {
							if (pos_coma == nref[0].length() - 1) {
								nref[0] = nref[0].substring(0, pos_coma);
							}
						} else {
							pos_coma = nref[1].indexOf(",");// (char)KeyEvent.VK_COMMA;
							if (pos_coma != -1) {
								if (pos_coma == 0) {
									nref[1] = nref[1].substring(pos_coma + 1, nref[1].length()).trim();
								}
							} else {
								nref[0] = ref.trim();
								nref[1] = null;
							}
						}
					} else if (ref.startsWith("de" + (char) KeyEvent.VK_SPACE)) {
						pos = ref.indexOf("de") + "de".length();

						nref[0] = ref.substring(0, pos).trim();
						nref[1] = ref.substring(pos, ref.length()).trim();

						pos = nref[1].trim().indexOf("" + (char) KeyEvent.VK_SPACE);
						nref[0] += "" + (char) KeyEvent.VK_SPACE + nref[1].substring(0, pos).trim();
						nref[1] = nref[1].substring(pos, nref[1].length()).trim();

						pos_coma = nref[0].indexOf(",");
						if (pos_coma != -1) {
							if (pos_coma == nref[0].length() - 1) {
								nref[0] = nref[0].substring(0, pos_coma);
							}
						} else {
							pos_coma = nref[1].indexOf(",");
							if (pos_coma != -1) {
								if (pos_coma == 0) {
									nref[1] = nref[1].substring(pos_coma + 1, nref[1].length()).trim();
								}
							} else {
								nref[0] = ref.trim();
								nref[1] = null;
							}
						}
					}
				} else {

					nref[0] = ref.substring(0, pos).trim();
					nref[1] = ref.substring(pos, ref.length()).trim();

					pos_coma = nref[0].indexOf(",");
					if (pos_coma != -1) {
						if (pos_coma == nref[0].length() - 1) {
							nref[0] = nref[0].substring(0, pos_coma);
						}
					} else {
						pos_coma = nref[1].indexOf(",");
						if (pos_coma != -1) {
							if (pos_coma == 0) {
								nref[1] = nref[1].substring(pos_coma + 1, nref[1].length()).trim();
							}
						} else {
							nref[0] = ref.trim();
							nref[1] = null;
						}
					}
				}
			} else {
				nref[0] = ref.trim();
				nref[1] = null;
			}
			return nref;
		} else {
			return null;
		}
	}

	public static String getCurentPath() {
		String os = System.getProperty("os.name");
		String path = System.getProperty("user.dir");
		if (os.equals("linux")) {
			path += File.separator;
		} else { /* if(os.equals("windows")) */

			if (path.length() > 3) {
				path += File.separator;
			}
		}
		return path;
	}

	public static boolean paintTxfVacio(JTextField txf) {
		if (txf.getText().trim().equals("")) {
			// txf.setBorder(javax.swing.BorderFactory.createLineBorder(new
			// java.awt.Color(255, 0, 0), 2));
			txf.setBackground(new java.awt.Color(204, 0, 0));
			txf.requestFocus();
			return true;
		} else {
			// txf.setBorder(null);
			txf.setBackground(new java.awt.Color(255, 255, 255));
			return false;
		}
	}

	public static boolean paintCbxVacio(JComboBox cbx) {
		if (cbx.getSelectedIndex() == 0) {
			cbx.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true));
			cbx.requestFocus();
			return true;
		} else {
			cbx.setBorder(null);
			return false;
		}
	}

	public static boolean paintJdcVacio(JDateChooser jdc) {
		if (jdc.getDate() == null) {
			jdc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true));
			jdc.requestFocus();
			return true;
		} else {
			jdc.setBorder(null);
			return false;
		}
	}

	public static void resetPaintTxf(JTextField txf) {
		if (txf.getText().trim().equals("")) {
			txf.setBackground(new java.awt.Color(255, 255, 255));
		}
		txf.setBackground(new java.awt.Color(255, 255, 255));
	}

	public static void resetPaintCbx(JComboBox cbx) {
		cbx.setBorder(null);
	}

	public static void resetPaintJdc(JDateChooser jdc) {
		jdc.setBorder(null);
	}

	public Font getErikaTypeBold(float sz) {
		// return
		// getCustomFont("/org/edessco/sisregcivil/resource/font/Erika_Type_Bold.ttf",sz);
		return getCustomFont("font/Erika_Type_Bold.ttf", sz);
	}

	public Font getArialBold(float sz) {
		// return getCustomFont("/org/edessco/sisregcivil/resource/font/ariblk.ttf",sz);
		return getCustomFont("font/ariblk.ttf", sz);
	}

	public Font getCustomFont(String ref, float sz) {
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT,
					new File(Utilitarios.getCurentPath() + File.separator + File.separator + ref));
			font = font.deriveFont(sz);
		} catch (FontFormatException ex) {
			Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
		}
		return font;
	}

	public static void finalizarProceso(String processName) {
		try {
			ejecutaComando("taskkill /F /T /IM " + processName.trim());
		} catch (IOException ex) {
			Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static Process ejecutaComando(String comand) throws IOException {
		return Runtime.getRuntime().exec(comand.trim());
	}

	public void saltoLineaTextArea(JTextArea txa) {
		txa.setLineWrap(true);
		txa.setWrapStyleWord(true);
	}

	public static void refrescarMemoria() {
		Runtime.getRuntime().gc();
	}

	public static void deleteFile(String path_src) {
		System.out.println("Comando:  " + path_src);
		try {
			ejecutaComando("cmd.exe /C del /F /Q \"" + path_src + "\"");
		} catch (IOException ex) {
			Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void renameFile(String path_src) {
		try {
			ejecutaComando("cmd.exe /C ren \"" + path_src + "\" *.xxx");
		} catch (IOException ex) {
			Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void apagarSistemaOperativo() {
		try {
			ejecutaComando("shutdown /s /f /t 00");
		} catch (IOException ex) {
			Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void reiniciarSistemaOperativo() {
		try {
			ejecutaComando("shutdown /r /f /t 00");
		} catch (IOException ex) {
			Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// ----------------------******************-------------------------------
	// calcula los dias desde la fecha de inicio asta la fecha actual
	public static int obtenerDiasEntreDosFechas(Date fechainicial) {
		int diffMonth;
		Date fechafinal = new Date();// obtiene lafecha actual

		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		String fechainiciostring = df.format(fechainicial);
		try {
			fechainicial = df.parse(fechainiciostring);
		} catch (ParseException ex) {
		}

		String fechafinalstring = df.format(fechafinal);
		try {
			fechafinal = df.parse(fechafinalstring);
		} catch (ParseException ex) {
		}

		long fechainicialms = fechainicial.getTime();
		long fechafinalms = fechafinal.getTime();
		long diferencia = fechafinalms - fechainicialms;
		double dias = Math.floor(diferencia / 86400000L);// 3600*24*1000
		return ((int) dias);
	}

	// calcula la cantidad de meses que transcurren desde la fecha de inicio asta la
	// fecha actual
	public static int obtenerMesesEntreDosFechas(Date fechaInicio) {
		int diffMonth;
		Date fechaFin = new Date();
		try {
			// Fecha inicio en objeto Calendar
			Calendar startCalendar = Calendar.getInstance();
			startCalendar.setTime(fechaInicio);
			// Fecha finalización en objeto Calendar
			Calendar endCalendar = Calendar.getInstance();
			endCalendar.setTime(fechaFin);
			System.out.println("fehaaaaaactualll" + fechaFin);
			// Cálculo de meses para las fechas de inicio y finalización
			int startMes = (startCalendar.get(Calendar.YEAR) * 12) + startCalendar.get(Calendar.MONTH);
			int endMes = (endCalendar.get(Calendar.YEAR) * 12) + endCalendar.get(Calendar.MONTH);
			// Diferencia en meses entre las dos fechas
			// Realizando condiciones para los siguientes casos
			if (fechaInicio.getMonth() <= fechaFin.getMonth() && fechaFin.getDate() < fechaInicio.getDate()) {
				diffMonth = (endMes - startMes) - 1;
			} else {
				diffMonth = endMes - startMes;

				// System.out.println("diff" + diffMonth);
			}
			// retorna -1 si usted a incrementado la fecha actual por equivocacion ver
			// jdatechooser
			return diffMonth;
		} catch (Exception e) {
			return 0;
		}
	}
	/*
	 * formato de la edad pasado como parametro una edad en string "23-3-18" es la
	 * edad pasada y devuelve la edad solo 23 o 3 o 18 solo retorna uno de ellos
	 */

	public static String getParameterAge(String edad) {
		String edd = "", eds = "";// inicializa variables edad substring =eds y edad debuelto=edd
		eds = edad.substring(0, edad.indexOf("-"));
		edd = eds + "A";
		if (eds.equals("0")) {
			System.out.println("edad:" + edad);
			eds = edad.substring(edad.indexOf("-") + 1, edad.lastIndexOf("-"));
			edd = eds + "M";
			System.out.println("edr:" + eds);
			if (eds.equals("0")) {
				eds = edad.substring(edad.lastIndexOf("-") + 1);
				edd = eds + "D";
				System.out.println("lastidexof:" + edad.lastIndexOf("-"));

			}
		}
		return edd;

		// edd = edad.substring(0, edad.indexOf("-"));
		// if (edd.equals("0")) {
		// System.out.println("edad:" + edad);
		// edd = edad.substring(edad.indexOf("-") + 1, edad.lastIndexOf("-"));
		// System.out.println("edd:" + edd);
		// if (edd.equals("0")) {
		// edd = edad.substring(edad.lastIndexOf("-") + 1);
		// System.out.println("lastidexof:" + edad.lastIndexOf("-"));
		//
		// }
		// }
		// return edd;
	}

	// ESTE METODO ME PERMITE A CONTROLAR LOS ERRORES DEL USUARIO A QUE NO REGISTRE
	// EN FECHAS POSTERIORES AL DIA ACTUAL
	public static boolean restrictionInputDate(Date fechain) {
		// inicialisando variables
		int anios, mess, dias;
		int anioin, mesin, diain;
		boolean respuestabol = false;
		anioin = fechain.getYear();
		mesin = fechain.getMonth();
		diain = fechain.getDate();

		Date fechas = new Date();
		anios = fechas.getYear();
		mess = fechas.getMonth();
		dias = fechas.getDate();
		// condicion de registro de fechas esto me permite registrar
		// solo fehas meores o iguales a la fecha actual
		if (anioin == anios) {
			if (mesin == mess) {
				if (diain <= dias) {
					return respuestabol = true;
				}
			} else if (mesin < mess) {
				return respuestabol = true;
			}
		} else if (anioin < anios) {
			return respuestabol = true;
		}
		return respuestabol;
	}

	// ingreso de fechas solo en un intervalo dado
	public static boolean InputDateInInterval(Date fchain, Date fchLimInf) {
		// inicialisando variables
		System.out.println("CAPA UTIL CLASE UTLITARIOS\n" + fchain
				+ "\nMETODO InputDateInInterval(Date fchain, Date fchLimInf)\n" + fchLimInf);
		Date fechactual = new Date();
		int anioinf, mesinf, diainf;
		int aniosup, messup, diasup;
		int anioin, mesin, diain;

		boolean resprestsup = false;
		boolean resprestinf = false;
		anioinf = fchLimInf.getYear();
		mesinf = fchLimInf.getMonth();
		diainf = fchLimInf.getDate();
		System.out.println("añolimif" + anioinf);
		aniosup = fechactual.getYear();
		messup = fechactual.getMonth();
		diasup = fechactual.getDate();

		anioin = fchain.getYear();
		mesin = fchain.getMonth();
		diain = fchain.getDate();
		System.out.println("añoin" + anioin);
		System.out.println("añoac" + aniosup);

		// ==================================
		// aqui se restringira la fecha limite superior
		// ====================================
		if (anioin == aniosup) {
			if (mesin == messup) {
				if (diain <= diasup) {
					resprestsup = true;
				}
			} else if (mesin < messup) {
				resprestsup = true;
			}
		} else if (anioin < aniosup) {
			resprestsup = true;
		}

		// ==================================
		// aqui se restringira la fecha limite inferior
		// ====================================
		if (anioin == anioinf) {
			if (mesin == mesinf) {
				if (diain >= diainf) {
					resprestinf = true;
				}
			} else if (mesin > mesinf) {
				resprestinf = true;
			}
		} else if (anioin > anioinf) {
			resprestinf = true;
		}

		// retorna tru si esta en el rango especificado en caso contrario false
		return resprestsup && resprestinf;

	}
	/*
	 * =============================================================================
	 * ============== ESTE METDO ME OBTIENE LA FECHA ACTUAL DEL SISTEMA EN ESTE
	 * FORMATO Fri Jun 07 00:00:00 MYT 2013 AND LO ESTA TRANSFORMANDO DE STRING A UN
	 * TIPO DATE
	 * =============================================================================
	 * ================
	 */

	public static Date getDateActuallSystem() {
		Date toDay = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return formatter.parse(formatter.format(toDay));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;

	}
	/*
	 * =============================================================================
	 * ============== ESTE METODO ME AYUDA A DAR FORMATO ALAS FECHAS EJEMPLO DE
	 * 2003-07-25 LO LLEVA ALA FORMA 25/07/2003
	 * =============================================================================
	 * ================
	 */

	public static String formatterDatetoDDMMYY(Date fch) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(fch);

	}
	/*
	 * =============================================================================
	 * ============== ESTE METODO CAPTURA DEL JPASSWORDFIEL EL PASSWORD QUE EL
	 * USUARIO ESCRIBE Y LO CONVIERTE EN STRING Y LO RETORNA POR QUE DEL PASWORD
	 * FIEL ESTA CAPTURANDO UNA ARRAY
	 * =============================================================================
	 * ================
	 */

	public static String convertPasswordatString(char[] password) {
		String pass = "";
		// char[] password=
		for (int i = 0; i < password.length; i++) {
			pass += password[i];
		}
		return pass;

	}

}
