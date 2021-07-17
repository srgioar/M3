
public abstract class Vehiculo {

	protected Titular titular;
	protected String matricula;
	protected String marca;
	protected String color;
	
	protected int ejes;
	protected Rueda[] ruedas_delanteras;
	protected Rueda[] ruedas_traseras;
	
	public Vehiculo (Titular titular,String matricula,String marca,String color) {
		this.matricula = matricula;	
		this.marca=marca;
		this.color=color;
		
	}
	
	
	
}
