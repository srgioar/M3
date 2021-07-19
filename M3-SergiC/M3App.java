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
		
		String input = JOptionPane.showInputDialog(null, "¿QUÉ TIPO DE VEHÍCULO QUIERES CREAR? \n   1-> COCHE  2-> MOTO  3-> CAMIÓN");
		
		//Creamos vehiculo para poder añadir al ArrayList Vehiculos
		Object vehiculo = new Object();

		System.out.println(array_titulares.toString());
		
		String id_titular_usuario = JOptionPane.showInputDialog(null, "Titulares \n "+array_titulares.toString()+"\n Introduce el id");
		int id_titular = Integer.parseInt(id_titular_usuario);
		
		Licencia licencia = array_titulares.get(id_titular).getLicencia();
		String tipo_licencia = licencia.getTipo();
		
		switch (input) {
		case "1":
			Coche testCoche = new Coche(null, "MATRICULA", "marcacoche", "azul");
			
			if(tipo_licencia != "B1") {
				
			}else {
				vehiculo = testCoche;
				JOptionPane.showMessageDialog(null, testCoche.toString());   
			}
		break;
		case "2":
			Moto testMoto = new Moto(null, "MATRICULA", "marcamoto", "azul");
			
			if(tipo_licencia != "A1") {
				
			}else {
				vehiculo = testMoto;
				JOptionPane.showMessageDialog(null, testMoto.toString());
			}
		break;
		case "3":
			Camion testCamion = new Camion(null, "MATRICULA", "marcacoche", "azul");
			
			if(tipo_licencia != "A1") {
				
			}else {
				vehiculo = testCamion;
				JOptionPane.showMessageDialog(null, testCamion.toString());
			}
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
		String fecha_nacimiento_usuario = JOptionPane.showInputDialog("Fecha Nacimiento [Año]");
		int fecha_nacimiento = Integer.parseInt(fecha_nacimiento_usuario);
		
		String tiene_garaje = JOptionPane.showInputDialog("Garaje [S/N]");
		if (tiene_garaje.equalsIgnoreCase("S")) {
			garaje = true;
		}
		String tiene_seguro = JOptionPane.showInputDialog("Seguro [S/N]");
		if (tiene_seguro.equalsIgnoreCase("S")) {
			seguro = true;
		}
		
		Licencia licencia = Licencia.crearLicencia();
		
		Titular titular = new Titular(nombre,apellido,fecha_nacimiento,licencia,garaje,seguro);
		
		//array_titulares.add(titular);
		
	}
	
	public static void menuPrincipal () {
		
		String menu = JOptionPane.showInputDialog("Que quieres hacer \n 1-Crear Titular \n 2-Crear Conductor \n 3-Crear Vehiculos \n 4-Mostrar Datos \n 0-Salir");
		
		switch(menu) {
			case "1":
				crearTitular();
				menuPrincipal();
			break;
			case "2":
				//crearConductor();
				//menuPrincipal();
			break;
			case "3":
				menuVehiculos();
				menuPrincipal();
			break;
			case "4":
				mostrarDatos();
				menuPrincipal();
			break;
			case "0":
				//Salir
			break;
		}
		
	}
	
	public static void main(String[] args) {
		
		menuPrincipal();
		
	}
	
}
