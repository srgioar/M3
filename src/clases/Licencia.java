package clases;

import javax.swing.JOptionPane;

public class Licencia {
	
	String ID;
	String tipo;
	String nombreCompleto;
	int fechaCaducidad;
	
	public Licencia(String ID, String tipo, String nombreCompleto, int fechaCaducidad) {
		this.ID = ID;
		this.tipo = tipo;
		this.nombreCompleto = nombreCompleto;
		this.fechaCaducidad = fechaCaducidad;
	}
	
	public static Licencia introducirLicencia() {
		
		String idLicencia = JOptionPane.showInputDialog("ID LICENCIA: ");
		String tipoLicencia = JOptionPane.showInputDialog("TIPO LICENCIA: ");
		String strNombreCompleto = JOptionPane.showInputDialog("NOMBRE LICENCIA: ");
		int strFechaCaducidad = Integer.parseInt(JOptionPane.showInputDialog("FECHA CAD.LICENCIA(AÑO): "));
		
		Licencia licencia = new Licencia(idLicencia, tipoLicencia, strNombreCompleto, strFechaCaducidad);
		
		return licencia;
		
	}

}


