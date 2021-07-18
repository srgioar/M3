/**
 * 
 */
package clases;

import java.util.ArrayList;

/**
 * @author Sergio
 *
 */
public abstract class Vehiculo {
	
	Titular titular;
	String matricula;
	String marca;
	String color;
	final String COLOR_AZUL = "AZUL";
	final String COLOR_ROJO = "ROJO";
	final String COLOR_AMARILLO = "AMARILLO";
	final String COLOR_VERDE = "VERDE";
	int ejes;
	ArrayList<Conductor> conductores;
	//int ruedasDelanteras, ruedasTraseras;

	
	public Vehiculo() {
		
	}
	
	public Vehiculo (Titular titular, String matricula, String marca, String color){
		this.titular = titular;
		this.matricula = matricula;
		this.marca = marca;
		this.color = color;

	}
	
	public Vehiculo (Titular titular, ArrayList<Conductor> conductores, String matricula, String marca, String color){
		this.titular = titular;
		//Probando
		this.conductores = new ArrayList<Conductor>();
		this.matricula = matricula;
		this.marca = marca;
		this.color = color;
	}

}
