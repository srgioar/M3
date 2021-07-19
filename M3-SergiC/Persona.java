
public abstract class Persona {

	protected String nombre;
	protected String apellido;
	protected int fecha_nacimiento;
	protected Licencia licencia;
	
	public Persona (String nombre,String apellido,int fecha_nacimiento,Licencia licencia) {
		this.nombre=nombre;
		this.apellido = apellido;
		this.fecha_nacimiento=fecha_nacimiento;
		this.licencia=licencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(int fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Licencia getLicencia() {
		return licencia;
	}

	public void setLicencia(Licencia licencia) {
		this.licencia = licencia;
	}
	
}
