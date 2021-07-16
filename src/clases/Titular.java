package clases;

public class Titular extends Persona {
	
	boolean tieneSeguro;
	boolean tieneGaraje;
	
	public Titular(String nombre, String apellido, int fechaNacimiento, Licencia licencia, boolean tieneSeguro, boolean tieneGaraje) {
		super(nombre, apellido, fechaNacimiento, licencia);
		this.tieneSeguro = tieneSeguro;
		this.tieneGaraje = tieneGaraje;
	}
	
	
}
