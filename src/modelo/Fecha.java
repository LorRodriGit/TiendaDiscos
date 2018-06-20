package modelo;

import java.time.LocalDate;

public class Fecha {
	private LocalDate date; 
	private int dia;
	private int mes;
	private int anio;
	
	public  String getfecha() {
		String fecha;
		dia=date.now().getDayOfMonth();
		mes=date.now().getMonthValue();
		anio=date.now().getYear();
		fecha=dia+"/"+mes+"/"+anio;
		return fecha;
		
	}
	
}
