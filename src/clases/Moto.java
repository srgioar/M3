package clases;

public class Moto extends Vehiculo {
	
	Rueda[] ruedasDelanteras, ruedasTraseras;
	Rueda ruedaModelo;
	
	public Moto(Titular titular, String matricula, String marca, String color) {
		
		super(titular, matricula, marca, color);
		
		this.ruedaModelo = Rueda.instanciarRueda();
		
		this.ejes = 2;
		this.ruedasDelanteras = new Rueda[1];
		this.ruedasTraseras = new Rueda[1];
		
		this.ruedasDelanteras[0] = this.ruedaModelo;
		this.ruedasTraseras[0] = this.ruedaModelo;
		
		//this.ruedasTraseras = new Rueda[2];
		

		this.color = color;
		this.matricula = matricula;
		this.marca = marca;
	}
	
	@Override
	public String toString() {
		
		String nombreTitular = "";
		
		if (titular == null) {
			nombreTitular = "Sin titular \n";
		}
		
		else {
			nombreTitular = titular.getNombre() + "\n";
		}
		
		return "MOTO Info:\n" + "TITULAR: " + nombreTitular +
				"MATRÍCULA: " + matricula + "\n MARCA: " + marca + "\n COLOR: " + color +
				"\n CANTIDAD RUEDAS DELANTERAS: 1" +
				"\n CANTIDAD RUEDAS TRASERAS: 1" +
				"\n RUEDAS INSTALADAS: " + this.ruedasDelanteras[0].toString() +
				"\n CANTIDAD DE EJES: 1 (Moto)";
	}
	
}
