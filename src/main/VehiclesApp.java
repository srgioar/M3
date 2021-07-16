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
	
	public static void mostrarDatos() {
		JOptionPane.showMessageDialog(null, "TITULARES \n" + listaTitulares.toString());
		JOptionPane.showMessageDialog(null, "VEHICULOS \n" + listaVehiculos.toString());
	}
	
	public static Object crearVehiculo() {
		
		/*
		 * Hay que modificar para que se pida un titular y dependiendo del numero introducido
		 * introduzca el titular del índice correspondiente en listaTitulares
		 * 
		 * 
		 */
		
		JOptionPane.showMessageDialog(null, "¿QUÉ TIPO DE VEHÍCULO QUIERES CREAR? \n   1-> COCHE  2-> MOTO  3-> CAMIÓN");
		String input = JOptionPane.showInputDialog("ELIGE 1-2-3");
		
		/* Como no podemos instanciar vehículo al ser abstracta, en vez de cambiar vehículo a clase no abstracta
		 * lo que hacemos es crear un objeto genérico, y luego asignarlo al tipo de objeto final
		 */
		
		Object vehiculo = new Object();
		
		/* 
		 * CONTROLAR POR EXCEPCIÓN QUE EL TITULAR ASIGNADO TENGA LICENCIA ADECUADA
		 * AÑADIR LISTA DE CONDUCTORES A VEHÍCULOS
		 * SI EL TITULAR NO ES EL CONDUCTOR, AÑADIR USUARIO NUEVO (TIPO CONDUCTOR)
		 * TIENE ANIDADO CADA COCHE UNA LISTA DE CONDUCTORES
		 * 
		 */
		
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
		listaVehiculos.add((Vehiculo) vehiculo);
		return vehiculo;
		
	}
	
	public static Titular crearTitular() {
		
		//String nombre, String apellido, String fechaNacimiento, Licencia licencia, boolean tieneSeguro, boolean tieneGaraje
		
			boolean seguro = false, garaje = false;
		
			String nombreTitular = JOptionPane.showInputDialog("NOMBRE TITULAR: ");
			String apellidoTitular = JOptionPane.showInputDialog("APELLIDO TITULAR: ");
			
			int strFechaNacimiento = Integer.parseInt(JOptionPane.showInputDialog("INSERTA FECHA CADUCIDAD (AÑO): "));
			Licencia licencia = Licencia.introducirLicencia();
			String tieneSeguro = JOptionPane.showInputDialog("¿Tiene seguro? S/N: ");
			if (tieneSeguro == "S") seguro = true;
			
			String tieneGaraje = JOptionPane.showInputDialog("¿Tiene garaje? S/N: ");
			if (tieneGaraje == "S") garaje = true;
			
			Titular titular = new Titular(nombreTitular, apellidoTitular, strFechaNacimiento, licencia, seguro, garaje);
			
			// Añadir a la lista
			listaTitulares.add(titular);
			
			//Licencia licencia = new Licencia(idLicencia, tipoLicencia, strNombreCompleto, strFechaCaducidad);
			
			return titular;
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String input = JOptionPane.showInputDialog("Elige opción: \n 1 -> Mostrar stock \n 2-> Insertar artículo \n 3-> Consultar artículo \n 4->Reponer artículo \n 5-> Realizar venta");
//		JOptionPane.showMessageDialog(null, input);
		
		// CREAR TITULAR O VEHICULO
		// ASIGNARLE TITULAR AL VEHICULO, SI NO ES POSIBLE, AVISAR CON EXCEPCION Y SALIR
		// AVISAR SI EL TITULAR SERÁ CONDUCTOR, SI NO, ASIGNARLE CONDUCTORES (INTRODUCIR CONDUCTOR)
		// COMPROBAR SI EL CONDUCTOR TIENE LICENCIA, DE LO CONTRARIO VOLVER A INTRODUCIR CONDUCTOR O CANCELAR
		
		String opcion = JOptionPane.showInputDialog(null, "1. INTRODUCE TITULAR \n 2. INTRODUCE CONDUCTOR \n 3. INTRODUCE VEHICULO \n 4. MOSTRAR DATOS \n 5. SALIR");
		
		switch (opcion) {
		case "1":
			// Introducir titular
			crearTitular();
			break;
		case "2":
			// Introducir conductor
			break;
		case "3":
			// Introducir vehiculo
			crearVehiculo();
			break;
		case "4":
			// Mostrar datos
			mostrarDatos();
			break;
		}

	}
	
	

}
