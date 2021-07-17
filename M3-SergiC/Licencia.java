import javax.swing.JOptionPane;

public class Licencia {

	protected int ID;
	protected String tipo;
	protected String nombre_completo ;
	protected int fecha_caducidad;
	
	public Licencia () {
	}
	
	public Licencia (int ID,String tipo,String nombre_completo,int fecha_caducidad) {
		this.ID = ID;
		this.tipo = tipo;
		this.nombre_completo=nombre_completo;
		this.fecha_caducidad = fecha_caducidad;
	}
	
	public static Licencia crearLicencia() {
		String ID_usuario = JOptionPane.showInputDialog("ID");
		int ID = Integer.parseInt(ID_usuario);
		String tipo = JOptionPane.showInputDialog("Tipo");
		String nombre = JOptionPane.showInputDialog("Nombre Completo");
		String fecha_usuario = JOptionPane.showInputDialog("Año Caducidad");
		int fecha = Integer.parseInt(fecha_usuario);
		
		Licencia licencia = new Licencia (ID,tipo,nombre,fecha);
		
		return licencia;
		
	}
	
}
