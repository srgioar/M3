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
		//En teor�a la lista la inicializamos al construir el objeto pero permanece sin elementos hasta introducirlos:
		this.conductores = new ArrayList<Conductor>();
		this.matricula = matricula;
		this.marca = marca;
		this.color = color;
	}
	
	// Asigna un conductor a un veh�culo
	public void asignarConductor(Conductor conductor) {
		this.conductores.add(conductor);
		JOptionPane.showMessageDialog(null, "Conductor asignado a: \n" + marca + " " + matricula + " " + conductor);
	}
	
	// Asigna un conductor a un veh�culo, esta vez con coche como par�metro
	// Es est�tica porque funciona con ambos par�metros y podemos invocarla fuera
	public static void asignarConductor(Conductor conductor, Vehiculo vehiculo) {
		
		try {
			vehiculo.conductores.add(conductor);
			JOptionPane.showMessageDialog(null, "Conductor asignado a: \n" + vehiculo.marca + " " + vehiculo.matricula + " " + conductor);

		}
		
		catch (Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
	public boolean checkearMatricula() {
		/* En vez de chequear caracteres usamos una RegEx
		 * Antes de implementarla la comprobaremos en una calculadora de RegEx */
		
		if (this.matricula.toUpperCase().matches("^[0-9]{4}[A-Z]{3}$")) {
	        System.out.println("Matr�cula v�lida");
	        return true;
	    }
		
		else {
	        System.out.println("Matr�cula inv�lida");
	        return false;
	    }
		
	}

}
