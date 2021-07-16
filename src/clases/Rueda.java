package clases;

import javax.swing.JOptionPane;

public class Rueda {
	
	String marca;
	final static String MARCA_PIRELLI = "PIRELLI";
	final static String MARCA_DUNLOP = "DUNLOP";
	double diametro;
	
	public Rueda() {
		
	}
	
	public Rueda(String marca, double diametro) {
		this.marca = marca;
		this.diametro = diametro;
	}
	
	public static Rueda instanciarRueda() {
		
		Rueda ruedaFinal;
		
		String input = null;
		
		input = JOptionPane.showInputDialog("Elige MARCA DE LA RUEDA (PIRELLI o DUNLOP)");
		
		if (input != MARCA_PIRELLI || input != MARCA_DUNLOP) {
			
			input = JOptionPane.showInputDialog("Elige MARCA DE LA RUEDA (PIRELLI o DUNLOP)");
			
		}
		
//		else {
//	
//			input = JOptionPane.showInputDialog("Elige MARCA DE LA RUEDA (PIRELLI o DUNLOP)");
//
//		}
		
		String input2;
		
		input2 = JOptionPane.showInputDialog("Elige DIÁMETRO");
		
		double diam = Double.parseDouble(input2);
		
		while (!(diam > 0.4) && !(diam < 4.0)) {
			
			input2 = JOptionPane.showInputDialog("Elige DIÁMETRO");
			diam = Double.parseDouble(input2);
			
		}
		
		// Instanciar la rueda
		ruedaFinal = new Rueda(input, diam);
		// Dar información de la rueda
		JOptionPane.showMessageDialog(null, ruedaFinal.toString());
		
		return ruedaFinal;
		
	}
	

	@Override
	public String toString() {
		return "Rueda [marca=" + marca + ", diametro=" + diametro + "]";
	}

}
