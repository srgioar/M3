import java.util.ArrayList;

import javax.swing.JOptionPane;

public class M3App {

	static ArrayList <Vehiculo> array_vehiculos = new ArrayList <Vehiculo>();
	static ArrayList <Titular> array_titulares = new ArrayList <Titular>();
	static ArrayList <Conductor> array_conductores = new ArrayList <Conductor>();
	
	public static void mostrarDatos() {
		
		String strTitulares = "TITULARES \n";
		
		for (int i = 0; i < array_titulares.size(); i++) {
			Titular ti;
			ti = array_titulares.get(i);
			strTitulares += "ID: " + (i+1) + " | ";
			strTitulares += ti.getNombre() + " | ";
			strTitulares += ti.getApellido() + " | ";
			strTitulares += "Licencia: " + ti.getLicencia();
		}
		
		JOptionPane.showMessageDialog(null, strTitulares);
		
		JOptionPane.showMessageDialog(null, "VEHICULOS \n" + array_vehiculos.toString());
		JOptionPane.showMessageDialog(null, "CONDUCTORES \n" + array_conductores.toString());
	}
	
	//Funcion por si el usuario dice que el titular sera conductor
	public static Conductor checkConductor(Titular titular) {
		Conductor conductor;
		
		String input = JOptionPane.showInputDialog("¿El titular será conductor? [S/N] ");
		
		if (input.equalsIgnoreCase("S")) {
			conductor = crearConductor(titular);
			return conductor;
		}
		
		else {
			conductor = crearConductor();
			return conductor;
		}
	}
	
	public static Object menuVehiculos() {
		
		//Creo y inicializo las variables que usare mas tarde
		String tipo_licencia = "";
		
		int id_titular = 0;
		
		//Pido el tipo de vehiculo que quiere añadir
		String input = JOptionPane.showInputDialog(null, "¿QUÉ TIPO DE VEHÍCULO QUIERES CREAR? \n   1-> COCHE  2-> MOTO  3-> CAMIÓN");
		
		//Creamos vehiculo para poder añadir al ArrayList Vehiculos
		Object vehiculo = new Object();

		//Excepcion por si no existe el id que introduzca el usuario
		try {
		
			String id_titular_usuario = JOptionPane.showInputDialog(null, "Titulares \n "+ array_titulares.toString() +"\n Introduce el id");
			id_titular = Integer.parseInt(id_titular_usuario);
			
			Licencia licencia = array_titulares.get(id_titular).getLicencia();
			tipo_licencia = licencia.getTipo();
		
		}catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, "Excepcion: \n"+e);
			menuPrincipal();
		}
		
		//Switch que dependiendo de lo introducido por el usuario creara un vehiculo u otro
		switch (input) {
		case "1":
			Coche testCoche = new Coche(null, "MATRICULA", "marcacoche", "azul");
			
			if(!tipo_licencia.equalsIgnoreCase("B1")) {
				JOptionPane.showMessageDialog(null, "Licencia no correcta para este vehículo");
				menuPrincipal();
				break;
			}else {
				vehiculo = testCoche;
				//checkConductor(array_titulares.get(id_titular-1));
				Conductor c = checkConductor(array_titulares.get(id_titular-1));
				//Metodo de la clase vehiculo
				testCoche.asignarConductor(c);
				JOptionPane.showMessageDialog(null, testCoche.toString());  
				break;
			}

		case "2":
			Moto testMoto = new Moto(null, "MATRICULA", "marcamoto", "azul");
			
			if(!tipo_licencia.equalsIgnoreCase("A1")) {
				JOptionPane.showMessageDialog(null, "Licencia no correcta para este vehículo");
				menuPrincipal();
				break;
			}else {
				vehiculo = testMoto;
				JOptionPane.showMessageDialog(null, testMoto.toString());
				break;
			}
		case "3":
			Camion testCamion = new Camion(null, "MATRICULA", "marcacoche", "azul");
			
			if(!tipo_licencia.equalsIgnoreCase("C1")) {
				JOptionPane.showMessageDialog(null, "Licencia no correcta para este vehículo");
				menuPrincipal();
				break;
			}else {
				vehiculo = testCamion;
				JOptionPane.showMessageDialog(null, testCamion.toString());
				break;
			}
		}
		
		// Añadir a lista
		array_vehiculos.add((Vehiculo) vehiculo);
		
		return vehiculo;
		
	}
	
	public static Conductor crearConductor (Titular titular) {
		
		//Creo el conductor con los datos de titular
		Conductor conductor = new Conductor (titular.nombre,titular.apellido,titular.fecha_nacimiento,titular.licencia);

		//Lo añado al arraylists
		array_conductores.add(conductor);
		
		return conductor;
		
	}
	
	public static Conductor crearConductor () {
		
		//Pido los datos para crear el conductor
		String nombre = JOptionPane.showInputDialog("Nombre");
		String apellido = JOptionPane.showInputDialog("Apellido");
		String fecha_nacimiento_usuario = JOptionPane.showInputDialog("Fecha Nacimiento [Año]");
		int fecha_nacimiento = Integer.parseInt(fecha_nacimiento_usuario);
		
		//Creo la licencia con el metodo crearLicencia
		Licencia licencia = Licencia.crearLicencia();
		
		//Creo el conductor
		Conductor conductor = new Conductor(nombre,apellido,fecha_nacimiento,licencia);
		
		array_conductores.add(conductor);
		
		return conductor;
		
	}
	
	//Funcion para crear Titular
	public static void crearTitular () {
		
		//Declaro y inicializo los booleanos
		boolean seguro = false;
		boolean garaje = false;
		
		//Pido los datos para crear el titular
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
		
		//Llamo al metodo crearLicencia para crear-la
		Licencia licencia = Licencia.crearLicencia();
		
		//Creo el titular
		Titular titular = new Titular(nombre,apellido,fecha_nacimiento,licencia,garaje,seguro);
		
		//Lo añado al arraylist
		array_titulares.add(titular);
		
	}
	
	public static void asignarConductorManual() {
		
		int IDvehiculo = Integer.parseInt(JOptionPane.showInputDialog(null, "1. ELIGE UN VEHÍCULO (ID): "));
		int IDconductor = Integer.parseInt(JOptionPane.showInputDialog(null, "2. ELIGE UN CONDUCTOR QUE ASIGNARLE (ID): "));

		try {
			Vehiculo.asignarConductor(array_conductores.get(IDconductor), array_vehiculos.get(IDvehiculo));
		}
		
		catch (Exception e){
			System.out.println(e);
		}
		
		
	}
	
	public static void menuPrincipal () {
		
		String menu = JOptionPane.showInputDialog("Que quieres hacer \n 1-Crear Titular \n 2-Crear Conductor \n 3-Crear Vehiculos \n 4-Añadir Conductor \n 5-Mostrar Datos \n 0-Salir");
		
		switch(menu) {
			case "1":
				crearTitular();
				menuPrincipal();
			break;
			case "2":
				crearConductor();
				menuPrincipal();
			break;
			case "3":
				menuVehiculos();
				menuPrincipal();
			break;
			case "4":
				asignarConductorManual();
				menuPrincipal();
			break;
			case "5":
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
