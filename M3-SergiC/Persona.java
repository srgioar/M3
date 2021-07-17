
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
}
