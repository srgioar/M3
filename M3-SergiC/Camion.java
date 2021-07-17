
public class Camion extends Vehiculo {

	protected Rueda rueda_modelo;
	
	public Camion (Titular titular,String matricula,String marca,String color) {
		super(titular,matricula, marca, color);

		this.ejes = 2;
		
        this.rueda_modelo = Rueda.generarRueda();
        
        this.ruedas_delanteras = new Rueda[2];
        this.ruedas_traseras = new Rueda[2];
        
        this.ruedas_traseras[0] = this.rueda_modelo;
        this.ruedas_traseras[1] = this.rueda_modelo;
        
        this.ruedas_delanteras[0] = this.rueda_modelo;
        this.ruedas_delanteras[1] = this.rueda_modelo;
        
	}
	
public String toString() {
		
		String nombreTitular = "";
		
		if (titular == null) {
			nombreTitular = "Sin titular \n";
		}
		
		else {
			nombreTitular = titular.nombre + "\n";
		}
		
		return "Coche Info:\n" + "TITULAR: " + nombreTitular +
				"MATRÍCULA: " + matricula + "\n MARCA: " + marca + "\n COLOR: " + color +
				"\n CANTIDAD RUEDAS DELANTERAS: 2" +
				"\n CANTIDAD RUEDAS TRASERAS: 2" +
				"\n RUEDAS INSTALADAS: " + this.ruedas_delanteras[0].toString() +
				"\n CANTIDAD DE EJES: 2 (Camion)";
	}
	
}
