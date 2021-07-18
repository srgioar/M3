package clases;

public class Camion extends Vehiculo {
	
	Rueda[] ruedasDelanteras, ruedasTraseras;
	Rueda ruedaModelo;
	
	/* AMPLIAR: ENTRAR POR PARÁMETRO EL NÚMERO DE EJES */
	/* El modelo de datos real sería con ruedas izquierda / ruedas derecha si tienes en cuenta el n de ejes 
	 * Para respetar un poco el ejercicio, lo hemos dejado como Ruedas delanteras / ruedas traseras */
	
	public Camion(Titular titular, String matricula, String marca, String color) {
		
		super(titular, matricula, marca, color);
		
		this.ruedaModelo = Rueda.instanciarRueda();
		
		this.ejes = 2;
		this.ruedasDelanteras = new Rueda[ejes];
		this.ruedasTraseras = new Rueda[ejes];
		
//		for (int i = 0; i < ejes; i++) {
//			this.ruedasDelanteras[i] = this.ruedaModelo;
//			this.ruedasTraseras[i] = this.ruedaModelo;
//		}
		
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
		
		return "CAMIÓN Info:\n" + "TITULAR: " + nombreTitular +
				"MATRÍCULA: " + matricula + "\n MARCA: " + marca + "\n COLOR: " + color +
				"\n CANTIDAD RUEDAS DELANTERAS: 2" +
				"\n CANTIDAD RUEDAS TRASERAS: 2" +
				"\n RUEDAS INSTALADAS: \n" + this.ruedasDelanteras[0].toString() +
				"\n CANTIDAD DE EJES: 2 (CAMIÓN)";
	}
}
