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
		JOptionPane.showMessageDialog(null, "Crear Licencia");
		String ID_usuario = JOptionPane.showInputDialog("ID");
		int ID = Integer.parseInt(ID_usuario);
		String tipo = JOptionPane.showInputDialog("Tipo");
		String nombre = JOptionPane.showInputDialog("Nombre Completo");
		String fecha_usuario = JOptionPane.showInputDialog("Año Caducidad");
		int fecha = Integer.parseInt(fecha_usuario);
		
		Licencia licencia = new Licencia (ID,tipo,nombre,fecha);
		
		return licencia;
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public int getFecha_caducidad() {
		return fecha_caducidad;
	}

	public void setFecha_caducidad(int fecha_caducidad) {
		this.fecha_caducidad = fecha_caducidad;
	}
	
	
	
}
