package main;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import clases.Camion;
import clases.Coche;
import clases.Conductor;
import clases.Licencia;
import clases.Moto;
import clases.Titular;
import clases.Vehiculo;

public class VehiclesApp {
	
	static ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
	static ArrayList<Titular> listaTitulares = new ArrayList<Titular>();
	static ArrayList<Conductor> listaConductores = new ArrayList<Conductor>();
	
	/* IMPORTANTE:
	 * Este ArrayList de conductores es una base de datos de todos los conductores de la aplicación.
	 * Los arraylists de conductores internos de cada vehículo tienen los conductores correspondientes al vehículo.
	 * TODO: Indicar el vehículo asignado en cada conductor en su vista en mostrarDatos?
	 */
	
	public static void mostrarDatos() {
		
		String strTitulares = "TITULARES \n";
		
		for (int i = 0; i < listaTitulares.size(); i++) {
			Titular ti;
			ti = listaTitulares.get(i);
			strTitulares += "ID: " + (i+1) + " | ";
			strTitulares += ti.getNombre() + " | ";
			strTitulares += ti.getApellido() + " | ";
			strTitulares += "Licencia: " + ti.getLicencia();
		}
		
		JOptionPane.showMessageDialog(null, strTitulares);
		
		JOptionPane.showMessageDialog(null, "VEHICULOS \n" + listaVehiculos.toString());
		
		JOptionPane.showMessageDialog(null, "CONDUCTORES \n" + listaConductores.toString());
	}
	
	
	
	// POLIMORFISMO: SI TIENE TITULAR COMO PARÁMETRO ASIGNA TITULAR A CONDUCTOR, DE LO CONTRARIO SU FUNCIÓN GEMELA INTRODUCE DATOS
	
	public static Conductor crearConductor(Titular titular) {
		
		Conductor nuevoConductor = new Conductor(titular.getNombre(), titular.getApellido(), titular.getFechaNacimiento(), titular.getLicencia());
		listaConductores.add(nuevoConductor);
		return nuevoConductor;
		
	}
	
	// FORZAR ASIGNAR CONDUCTOR AL COCHE CREADO
	
	public static Conductor crearConductor() {
		
		//String nombre, String apellido, String fechaNacimiento, Licencia licencia, boolean tieneSeguro, boolean tieneGaraje
	
		String nombreTitular = JOptionPane.showInputDialog("NOMBRE CONDUCTOR: ");
		String apellidoTitular = JOptionPane.showInputDialog("APELLIDO CONDUCTOR: ");
		
		int strFechaNacimiento = Integer.parseInt(JOptionPane.showInputDialog("INSERTA FECHA NACIMIENTO (AÑO): "));
		
		// Introducción datos licencia del conductor
		Licencia licencia = Licencia.introducirLicencia();

		
		Conductor conductor = new Conductor(nombreTitular, apellidoTitular, strFechaNacimiento, licencia);
		
		// Añadir a la lista GLOBAL de conductores
		listaConductores.add(conductor);
		
		// CHEQUEAR LICENCIA Y SOLTAR EXCEPCIÓN COMO EN TITULAR!
		
		//Licencia licencia = new Licencia(idLicencia, tipoLicencia, strNombreCompleto, strFechaCaducidad);
		
		return conductor;
		
	}
	
	// crearConductor(conductor);
	// asignarConductor(conductor);
	
	
	public static Object crearVehiculo() {
		
		String tipoLicencia = "";
		String input = JOptionPane.showInputDialog("¿QUÉ TIPO DE VEHÍCULO QUIERES REGISTRAR? \n  1-> COCHE  2-> MOTO  3-> CAMIÓN");
		
		/* Como no podemos instanciar vehículo al ser abstracta, en vez de cambiar vehículo a clase no abstracta
		 * lo que hacemos es crear un objeto genérico, y luego asignarlo al tipo de objeto final
		 */
		
		Object vehiculo = new Object();
		
		int indexTitular = Integer.parseInt(
				JOptionPane.showInputDialog("TITULARES: \n " + listaTitulares.toString() + "\n INSERTA ID DE TITULAR: ")
				);
		
		try {
			// Depende del tipo de vehículo (SEGÚN ID DE TITULAR!) hace falta una licencia u otra
			Licencia li = listaTitulares.get(indexTitular-1).getLicencia();
			tipoLicencia = li.getTipo();
		}
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Excepción creando titular: \n" + e);
		}

		
		// if licencia no es válida o no existe titular -> excepción
		

		switch (input) {
		
		case "1":
	
			Coche testCoche = new Coche(listaTitulares.get(indexTitular-1), null, "MATRICULA", "marcacoche", "azul");
			
			if (!tipoLicencia.equalsIgnoreCase("B1")) {
				// Excepción
				JOptionPane.showMessageDialog(null, "Licencia no correcta para este vehículo");
				menuPrincipal();
				break;
			}
			
			else {
				vehiculo = testCoche;
				checkConductor(listaTitulares.get(indexTitular-1));
				Conductor c = checkConductor(listaTitulares.get(indexTitular-1));
				testCoche.asignarConductor(c);
				JOptionPane.showMessageDialog(null, testCoche.toString());   
				break;
			}
			
		case "2":
			
			Moto testMoto = new Moto(null, "MATRICULA", "marcamoto", "azul");
			
			if (tipoLicencia != "A1") {
				// Excepción
			}
			
			else {
				vehiculo = testMoto;
				JOptionPane.showMessageDialog(null, testMoto.toString());  
				break;
			}
			
			
		case "3":
			Camion testCamion = new Camion(null, "MATRICULA", "marcacoche", "azul");
			
			if (tipoLicencia != "C1") {
				// Excepción
			}
			
			else {
				vehiculo = testCamion;
				//JOptionPane.showMessageDialog(null, testMoto.toString()); 
				break;
			}

		}
		
		// Añadir a lista
		listaVehiculos.add((Vehiculo) vehiculo);
		return vehiculo;
		
	}
	
	// Preguntar si el titular será el conductor, de lo contrario te fuerza a introducir conductor y asignarlo
	public static Conductor checkConductor(Titular t) {
		Conductor c;
		
		String tieneGaraje = JOptionPane.showInputDialog("¿El titular será conductor? S/N: ");
		
		if (tieneGaraje.equalsIgnoreCase("s")) {
			c = crearConductor(t);
			return c;
		}
		
		else {
			c = crearConductor();
			return c;
		}
	}
	
	public static Titular crearTitular() {
		
		//String nombre, String apellido, String fechaNacimiento, Licencia licencia, boolean tieneSeguro, boolean tieneGaraje
		
			boolean seguro = false, garaje = false;
		
			String nombreTitular = JOptionPane.showInputDialog("NOMBRE TITULAR: ");
			String apellidoTitular = JOptionPane.showInputDialog("APELLIDO TITULAR: ");
			
			int strFechaNacimiento = Integer.parseInt(JOptionPane.showInputDialog("INSERTA FECHA NACIMIENTO (AÑO): "));
			Licencia licencia = Licencia.introducirLicencia();
			// Introducir un toLowerCase y comprobar contra n
			String tieneSeguro = JOptionPane.showInputDialog("¿Tiene seguro? S/N: ");
			if (tieneSeguro.equalsIgnoreCase("s")) seguro = true;
			
			String tieneGaraje = JOptionPane.showInputDialog("¿Tiene garaje? S/N: ");
			if (tieneGaraje.equalsIgnoreCase("s")) garaje = true;
			
			Titular titular = new Titular(nombreTitular, apellidoTitular, strFechaNacimiento, licencia, seguro, garaje);
			
			// Añadir a la lista
			listaTitulares.add(titular);
			
			//Licencia licencia = new Licencia(idLicencia, tipoLicencia, strNombreCompleto, strFechaCaducidad);
			
			return titular;
			
	}
	
	// Pide entrada de conductor y de vehiculo para poder vincular uno a otro
	// Es necesario porque desde el menú principal no tenemos ningún vehículo por defecto al que asignar
	// Con esta entrada, alimentamos el método estático asignarConductor(vehiculo, conductor)
	public static void asignarConductorManual() {
		
		int IDvehiculo = Integer.parseInt(JOptionPane.showInputDialog(null, "1. ELIGE UN VEHÍCULO (ID): "));
		int IDconductor = Integer.parseInt(JOptionPane.showInputDialog(null, "2. ELIGE UN CONDUCTOR QUE ASIGNARLE (ID): "));

		try {
			Vehiculo.asignarConductor(listaConductores.get(IDconductor), listaVehiculos.get(IDvehiculo));
		}
		
		catch (Exception e){
			System.out.println(e);
		}
		
		
	}
	
	public static void menuPrincipal() {
		
		/* TODO: Al habilitar Titulares como Conductor, crear un objeto Conductor con los campos comunes del Titular */
		
		String opcion = JOptionPane.showInputDialog(null, "1. INTRODUCE TITULAR \n 2. INTRODUCE CONDUCTOR \n 3. INTRODUCE VEHICULO \n 4. ASIGNAR CONDUCTOR \n 5. MOSTRAR DATOS \n 0. SALIR");
		
		switch (opcion) {
		case "1":
			// Introducir titular
			crearTitular();
			menuPrincipal();
			break;
		case "2":
			// Introducir conductor
			crearConductor();
			menuPrincipal();
			break;
		case "3":
			// Introducir vehiculo
			crearVehiculo();
			menuPrincipal();
			break;
		case "4":
			asignarConductorManual();
			menuPrincipal();
		case "5":
			// Mostrar datos
			mostrarDatos();
			menuPrincipal();
			break;
			
		case "0":
			// Salir del programa
		}

	} // FIN MENU 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// CREAR TITULAR O VEHICULO
		// ASIGNARLE TITULAR AL VEHICULO, SI NO ES POSIBLE, AVISAR CON EXCEPCION Y SALIR
		// AVISAR SI EL TITULAR SERÁ CONDUCTOR, SI NO, ASIGNARLE CONDUCTORES (INTRODUCIR CONDUCTOR)
		// COMPROBAR SI EL CONDUCTOR TIENE LICENCIA, DE LO CONTRARIO VOLVER A INTRODUCIR CONDUCTOR O CANCELAR
	
		menuPrincipal();
		
		
	}
	
	

}
