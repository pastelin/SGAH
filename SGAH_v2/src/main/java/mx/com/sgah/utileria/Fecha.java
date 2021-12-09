package mx.com.sgah.utileria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha {
	
	private Fecha() {
		
	}

	public static String getCurrentDate() {
		LocalDate currentDay = LocalDate.now();
		return currentDay.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
}
