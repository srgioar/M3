/**
 * 
 */
package clases;

import java.util.ArrayList;

import javax.swing.JOptionPane;

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
	ArrayList<Conductor> conductores = new ArrayList<Conductor>();
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
		//En teoría la lista la inicializamos al construir el objeto pero permanece sin elementos hasta introducirlos:
		this.conductores = new ArrayList<Conductor>();
		this.matricula = matricula;
		this.marca = marca;
		this.color = color;
	}
	
	// Asigna un conductor a un vehículo
	public void asignarConductor(Conductor conductor) {
		this.conductores.add(conductor);
		JOptionPane.showMessageDialog(null, "Conductor asignado a: \n" + marca + " " + matricula + " " + conductor);
	}
	
	// Asigna un conductor a un vehículo, esta vez con coche como parámetro
	// Es estática porque funciona con ambos parámetros y podemos invocarla fuera
	public static void asignarConductor(Conductor conductor, Vehiculo vehiculo) {
		vehiculo.conductores.add(conductor);
		JOptionPane.showMessageDialog(null, "Conductor asignado a: \n" + vehiculo.marca + " " + vehiculo.matricula + " " + conductor);
	}

}
