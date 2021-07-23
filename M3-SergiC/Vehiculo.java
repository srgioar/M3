import java.util.ArrayList;

import javax.swing.JOptionPane;

public abstract class Vehiculo {

	protected Titular titular;
	protected String matricula;
	protected String marca;
	protected String color;
	
	protected int ejes;
	protected Rueda[] ruedas_delanteras;
	protected Rueda[] ruedas_traseras;
	
	protected ArrayList<Conductor> Conductores;
	
	//Este es el constructor que usamos para el Milestone 3 (constructor final)
	public Vehiculo (Titular titular,ArrayList<Conductor> conductores,String matricula,String marca,String color) {
		this.matricula = matricula;	
		this.Conductores = new ArrayList <Conductor>();
		this.marca=marca;
		this.color=color;
	}
	
	public void asignarConductor (Conductor conductor){
		
		this.Conductores.add(conductor);
		JOptionPane.showMessageDialog(null, "Conductor asignado a: "+this);
		
	}
	
	public static void asignarConductor (Conductor conductor, Vehiculo vehiculo) {
	
		try {
			vehiculo.Conductores.add(conductor);
			JOptionPane.showMessageDialog(null, "Conductor asignado a: "+vehiculo);
		}
		
		catch (Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	
	}
	
	public boolean checkearMatricula() {
		/* En vez de chequear caracteres usamos una RegEx
		 * Antes de implementarla la comprobaremos en una calculadora de RegEx */
		
		if (this.matricula.toUpperCase().matches("^[0-9]{4}[A-Z]{3}$")) {
	        System.out.println("Matrícula válida");
	        return true;
	    }
		
		else {
	        System.out.println("Matrícula inválida");
	        return false;
	    }
		
	}
	
}
