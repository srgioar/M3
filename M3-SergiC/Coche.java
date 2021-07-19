import java.util.ArrayList;

public class Coche extends Vehiculo {

	protected Rueda rueda_modelo;
	
	//Este es el constructor que usamos para el Milestone 3 (constructor final)
	public Coche(Titular titular, ArrayList<Conductor> conductores, String matricula, String marca, String color) {
		
		super(titular,conductores,matricula, marca, color);

        this.rueda_modelo = Rueda.generarRueda();
        
        this.ejes = 2;
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
		
		return "INFO VEHÍCULO: \n" +
			"TIPO: " + "COCHE \n" + 
			"TITULAR: " + nombreTitular +
			"MATRÍCULA: " + matricula +
			"\n MARCA: " + marca +
			"\n COLOR: " + color +
			"\n CANTIDAD DE EJES: " + this.ejes +
			"\n CANT. RUEDAS DELANTERAS: " + this.ruedas_delanteras.length +
			"\n CANT. RUEDAS TRASERAS: " + this.ruedas_traseras.length +
			"\n RUEDAS TOTALES INSTALADAS: " + (this.ruedas_delanteras.length * ejes) + " " + rueda_modelo.toString();
	}
	
}
