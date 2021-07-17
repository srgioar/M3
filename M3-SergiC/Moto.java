
public class Moto extends Vehiculo {

	protected Rueda rueda_modelo;
	
	public Moto (Titular titular,String matricula,String marca,String color) {
		super(titular,matricula, marca, color);

        this.rueda_modelo = Rueda.generarRueda();
        
        this.ejes = 2;
        this.ruedas_delanteras = new Rueda[1];
        this.ruedas_traseras = new Rueda[1];
        this.ruedas_traseras[0] = this.rueda_modelo;
        this.ruedas_delanteras[0] = this.rueda_modelo;
	}
	
public String toString() {
		
		String nombre_titular = "";
		
		if (titular == null) {
			nombre_titular = "Sin titular \n";
		}
		
		else {
			nombre_titular = titular.nombre + "\n";
		}
		
		return "Coche Info:\n" + "TITULAR: " + nombre_titular +
				"MATRÍCULA: " + matricula + "\n MARCA: " + marca + "\n COLOR: " + color +
				"\n CANTIDAD RUEDAS DELANTERAS: 2" +
				"\n CANTIDAD RUEDAS TRASERAS: 2" +
				"\n RUEDAS INSTALADAS: " + this.ruedas_delanteras[0].toString() +
				"\n CANTIDAD DE EJES: 1 (Moto)";
	}
	
}
