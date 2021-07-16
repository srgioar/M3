package clases;

public abstract class Persona {
	
	String nombre;
	String apellido;
	int fechaNacimiento;
	Licencia licencia;
	
	public Persona() {
		
	}
	
	public Persona(String nombre, String apellido, int fechaNacimiento, Licencia licencia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.licencia = licencia;
	}
	
	
	public String getNombre() {
		return nombre;
	}

}
