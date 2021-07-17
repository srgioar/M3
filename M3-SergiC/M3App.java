import java.util.ArrayList;

import javax.swing.JOptionPane;

public class M3App {

	static ArrayList <Vehiculo> array_vehiculos = new ArrayList <Vehiculo>();
	static ArrayList <Titular> array_titulares = new ArrayList <Titular>();
	static ArrayList <Conductor> array_conductores = new ArrayList <Conductor>();
	
	
	public static void mostrarDatos() {
		JOptionPane.showMessageDialog(null, "TITULARES \n" + array_titulares.toString());
		JOptionPane.showMessageDialog(null, "VEHICULOS \n" + array_vehiculos.toString());
	}
	
public static Object menuVehiculos() {
		
		JOptionPane.showMessageDialog(null, "¿QUÉ TIPO DE VEHÍCULO QUIERES CREAR? \n   1-> COCHE  2-> MOTO  3-> CAMIÓN");
		String input = JOptionPane.showInputDialog("ELIGE 1-2-3");
		
		Object vehiculo = new Object();

		switch (input) {
		case "1":
			Coche testCoche = new Coche(null, "MATRICULA", "marcacoche", "azul");
			vehiculo = testCoche;
			JOptionPane.showMessageDialog(null, testCoche.toString());   
			break;
		case "2":
			Moto testMoto = new Moto(null, "MATRICULA", "marcamoto", "azul");
			vehiculo = testMoto;
			JOptionPane.showMessageDialog(null, testMoto.toString());  
			break;
		case "3":
			Camion testCamion = new Camion(null, "MATRICULA", "marcacoche", "azul");
			vehiculo = testCamion;
			break;
		}
		
		// Añadir a lista
		array_vehiculos.add((Vehiculo) vehiculo);
		return vehiculo;
		
	}
	
	public static void crearTitular () {
		
		boolean seguro = false;
		boolean garaje = false;
		
		String nombre = JOptionPane.showInputDialog("Nombre");
		String apellido = JOptionPane.showInputDialog("Apellido");
		String fecha_nacimiento_usuario = JOptionPane.showInputDialog("Fecha Nacimiento");
		int fecha_nacimiento = Integer.parseInt(fecha_nacimiento_usuario);
		
		Licencia licencia = Licencia.crearLicencia();
		
		String tiene_garaje = JOptionPane.showInputDialog("Garaje [S/N]");
		if (tiene_garaje == "S") {
			garaje = true;
		}
		String tiene_seguro = JOptionPane.showInputDialog("Seguro [S/N]");
		if (tiene_seguro == "S") {
			seguro = true;
		}
		
		Titular titular = new Titular(nombre,apellido,fecha_nacimiento,licencia,garaje,seguro);
		
	}
	
	public static void main(String[] args) {
		
		String menu1 = JOptionPane.showInputDialog("Que quieres hacer \n 1-Crear Titular \n 2-Crear Conductor \n 3-Crear Vehiculos \n 4-Mostrar Datos");
		
		switch(menu1) {
			case "1":
				crearTitular();
			break;
			case "2":
				//crearConductor();
			break;
			case "3":
				menuVehiculos();
			break;
			case "4":
				mostrarDatos();
			break;
			default:
				JOptionPane.showMessageDialog(null,"Valor incorrecto");
		}
		
		
	}
	
}
