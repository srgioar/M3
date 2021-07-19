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
	
	protected ArrayList Conductores;
	
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
	
		vehiculo.Conductores.add(conductor);
		JOptionPane.showMessageDialog(null, "Conductor asignado a: "+vehiculo);
	
	}	
}
