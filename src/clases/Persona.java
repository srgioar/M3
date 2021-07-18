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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(int fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Licencia getLicencia() {
		return licencia;
	}

	public void setLicencia(Licencia licencia) {
		this.licencia = licencia;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
