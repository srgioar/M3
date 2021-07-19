package clases;

import java.util.ArrayList;

public class Coche extends Vehiculo {
	
	Rueda[] ruedasDelanteras, ruedasTraseras;
	Rueda ruedaModelo;
	
	public Coche(Titular titular, String matricula, String marca, String color) {
		
		super(titular, matricula, marca, color);
		
		this.ruedaModelo = Rueda.generarRueda();
		
		this.ejes = 2;
		this.ruedasDelanteras = new Rueda[2];
		this.ruedasDelanteras[0] = this.ruedaModelo;
		this.ruedasDelanteras[1] = this.ruedaModelo;
		
		this.ruedasTraseras = new Rueda[2];
		this.ruedasTraseras[0] = this.ruedaModelo;
		this.ruedasTraseras[0] = this.ruedaModelo;
		
		this.color = color;
		this.matricula = matricula;
		this.marca = marca;
	}
	
	public Coche(Titular titular, ArrayList<Conductor> conductores, String matricula, String marca, String color) {
		
		super(titular, conductores, matricula, marca, color);
		
		this.ruedaModelo = Rueda.generarRueda();
		
		this.ejes = 2;
		this.ruedasDelanteras = new Rueda[2];
		this.ruedasDelanteras[0] = this.ruedaModelo;
		this.ruedasDelanteras[1] = this.ruedaModelo;
		
		this.ruedasTraseras = new Rueda[2];
		this.ruedasTraseras[0] = this.ruedaModelo;
		this.ruedasTraseras[0] = this.ruedaModelo;
		
		this.color = color;
		this.matricula = matricula;
		this.marca = marca;
		
	}
	
	@Override
	public String toString() {
		
		String nombreTitular = "";
		
		if (titular == null) {
			
			nombreTitular = "Sin titular \n";
		}
		
		else {
			
			nombreTitular = titular.getNombre() + "\n";
		}
		
		return "INFO VEHÍCULO: \n" +
				"TIPO: " + "COCHE \n" + 
				"TITULAR: " + nombreTitular +
				"MATRÍCULA: " + matricula +
				"\n MARCA: " + marca +
				"\n COLOR: " + color +
				"\n CANTIDAD DE EJES: " + this.ejes +
				"\n CANT. RUEDAS DELANTERAS: " + this.ruedasDelanteras.length +
				"\n CANT. RUEDAS TRASERAS: " + this.ruedasTraseras.length +
				"\n RUEDAS TOTALES INSTALADAS: " + (this.ruedasDelanteras.length * ejes) + " " + ruedaModelo.toString();
	}
	
}
