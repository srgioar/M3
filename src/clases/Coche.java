package clases;

public class Coche extends Vehiculo {
	
	Rueda[] ruedasDelanteras, ruedasTraseras;
	Rueda ruedaModelo;
	
	public Coche(Titular titular, String matricula, String marca, String color) {
		
		super(titular, matricula, marca, color);
		
		this.ruedaModelo = Rueda.instanciarRueda();
		
		this.ejes = 2;
		this.ruedasDelanteras = new Rueda[2];
		this.ruedasDelanteras[0] = this.ruedaModelo;
		this.ruedasDelanteras[1] = this.ruedaModelo;
		
		this.ruedasTraseras = new Rueda[2];
		this.ruedasTraseras[0] = this.ruedaModelo;
		this.ruedasTraseras[0] = this.ruedaModelo;
		
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
		
		return "Coche Info:\n" + "TITULAR: " + nombreTitular +
				"MATR�CULA: " + matricula + "\n MARCA: " + marca + "\n COLOR: " + color +
				"\n CANTIDAD RUEDAS DELANTERAS: 2" +
				"\n CANTIDAD RUEDAS TRASERAS: 2" +
				"\n RUEDAS INSTALADAS: " + this.ruedasDelanteras[0].toString() +
				"\n CANTIDAD DE EJES: 2 (Coche)";
	}
	
}