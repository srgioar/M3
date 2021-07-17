
public class Titular extends Persona {

	protected boolean seguro;
	protected boolean garaje;
	
	public Titular (String nombre,String apellido,int fecha_nacimiento,Licencia licencia,boolean seguro,boolean garaje) {
		super(nombre,apellido,fecha_nacimiento,licencia);
		this.seguro = seguro;
		this.garaje = garaje;
	}
	
}
