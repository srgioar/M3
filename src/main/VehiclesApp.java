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
	 * Este ArrayList de conductores es una base de datos de todos los conductores de la aplicaci�n.
	 * Los arraylists de conductores internos de cada veh�culo tienen los conductores correspondientes al veh�culo.
	 * TODO: Indicar el veh�culo asignado en cada conductor en su vista en mostrarDatos?
	 */
	
	public static void mostrarDatos() {
		
		String strTitulares = "TITULARES \n";
		
		for (int i = 0; i < listaTitulares.size(); i++) {
			Titular ti;
			ti = listaTitulares.get(i);
			strTitulares += "ID: " + (i+1) + " | ";
			strTitulares += ti.getNombre();
		}
		
		JOptionPane.showMessageDialog(null, strTitulares);
		
		JOptionPane.showMessageDialog(null, "VEHICULOS \n" + listaVehiculos.toString());
	}
	
	
	public static Object crearVehiculo() {
		
		/*
		 * Hay que modificar para que se pida un titular y dependiendo del numero introducido
		 * introduzca el titular del �ndice correspondiente en listaTitulares
		 * 
		 * 
		 */
		
		//JOptionPane.showMessageDialog(null, "�QU� TIPO DE VEH�CULO QUIERES CREAR? \n   1-> COCHE  2-> MOTO  3-> CAMI�N");
		String input = JOptionPane.showInputDialog("�QU� TIPO DE VEH�CULO QUIERES REGISTRAR? \n  1-> COCHE  2-> MOTO  3-> CAMI�N");
		
		/* Como no podemos instanciar veh�culo al ser abstracta, en vez de cambiar veh�culo a clase no abstracta
		 * lo que hacemos es crear un objeto gen�rico, y luego asignarlo al tipo de objeto final
		 */
		
		Object vehiculo = new Object();
		
		/* 
		 * CONTROLAR POR EXCEPCI�N QUE EL TITULAR ASIGNADO TENGA LICENCIA ADECUADA
		 * A�ADIR LISTA DE CONDUCTORES A VEH�CULOS
		 * SI EL TITULAR NO ES EL CONDUCTOR, A�ADIR USUARIO NUEVO (TIPO CONDUCTOR)
		 * TIENE ANIDADO CADA COCHE UNA LISTA DE CONDUCTORES
		 * 
		 */
		
		// Extender a comprobar si el titular existe y si el titular tiene licencia, con excepciones o breaks
		
		int indexTitular = Integer.parseInt(
				JOptionPane.showInputDialog("TITULARES: \n " + listaTitulares.toString() + "\n INSERTA ID DE TITULAR: ")
				);
		
		// Depende del tipo de veh�culo hace falta una licencia u otra
		Licencia li = listaTitulares.get(indexTitular).getLicencia();
		String tipoLicencia = li.getTipo();
		
		
		// Si el titular no existe o no tiene licencia, soltar excepci�n
		
		switch (input) {
		
		case "1":
	
			Coche testCoche = new Coche(listaTitulares.get(indexTitular), "MATRICULA", "marcacoche", "azul");
			
			if (tipoLicencia != "B1") {
				// Excepci�n
			}
			
			else {
				vehiculo = testCoche;
				JOptionPane.showMessageDialog(null, testCoche.toString());   
				break;
			}
			
		case "2":
			
			Moto testMoto = new Moto(null, "MATRICULA", "marcamoto", "azul");
			
			if (tipoLicencia != "A1") {
				// Excepci�n
			}
			
			else {
				vehiculo = testMoto;
				JOptionPane.showMessageDialog(null, testMoto.toString());  
				break;
			}
			
			
		case "3":
			Camion testCamion = new Camion(null, "MATRICULA", "marcacoche", "azul");
			
			if (tipoLicencia != "C1") {
				// Excepci�n
			}
			
			else {
				vehiculo = testCamion;
				//JOptionPane.showMessageDialog(null, testMoto.toString()); 
				break;
			}

		}
		
		// A�adir a lista
		listaVehiculos.add((Vehiculo) vehiculo);
		return vehiculo;
		
	}
	
	public static Titular crearTitular() {
		
		//String nombre, String apellido, String fechaNacimiento, Licencia licencia, boolean tieneSeguro, boolean tieneGaraje
		
			boolean seguro = false, garaje = false;
		
			String nombreTitular = JOptionPane.showInputDialog("NOMBRE TITULAR: ");
			String apellidoTitular = JOptionPane.showInputDialog("APELLIDO TITULAR: ");
			
			int strFechaNacimiento = Integer.parseInt(JOptionPane.showInputDialog("INSERTA FECHA NACIMIENTO (A�O): "));
			Licencia licencia = Licencia.introducirLicencia();
			String tieneSeguro = JOptionPane.showInputDialog("�Tiene seguro? S/N: ");
			if (tieneSeguro == "S") seguro = true;
			
			String tieneGaraje = JOptionPane.showInputDialog("�Tiene garaje? S/N: ");
			if (tieneGaraje == "S") garaje = true;
			
			Titular titular = new Titular(nombreTitular, apellidoTitular, strFechaNacimiento, licencia, seguro, garaje);
			
			// A�adir a la lista
			listaTitulares.add(titular);
			
			//Licencia licencia = new Licencia(idLicencia, tipoLicencia, strNombreCompleto, strFechaCaducidad);
			
			return titular;
			
	}
	
	public static void menuPrincipal() {
		
		/* TODO: Al habilitar Titulares como Conductor, crear un objeto Conductor con los campos comunes del Titular */
		
		String opcion = JOptionPane.showInputDialog(null, "1. INTRODUCE TITULAR \n 2. INTRODUCE CONDUCTOR \n 3. INTRODUCE VEHICULO \n 4. MOSTRAR DATOS \n 0. SALIR");
		
		switch (opcion) {
		case "1":
			// Introducir titular
			crearTitular();
			menuPrincipal();
			break;
		case "2":
			// Introducir conductor
			break;
		case "3":
			// Introducir vehiculo
			crearVehiculo();
			menuPrincipal();
			break;
		case "4":
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
		// AVISAR SI EL TITULAR SER� CONDUCTOR, SI NO, ASIGNARLE CONDUCTORES (INTRODUCIR CONDUCTOR)
		// COMPROBAR SI EL CONDUCTOR TIENE LICENCIA, DE LO CONTRARIO VOLVER A INTRODUCIR CONDUCTOR O CANCELAR
	
		menuPrincipal();
		
		
	}
	
	

}
