import javax.swing.JOptionPane;

public class Rueda {

	protected String marca;
	protected Double diametro;

	protected final static String MARCA_DUNLOP = "DUNLOP";
	protected final static String MARCA_PIRELLI = "PIRELLI";
	
	public Rueda (String marca,Double diametro) {
		this.marca=marca;
		this.diametro=diametro;
	}
	
	public static Rueda generarRueda () {
		String marca = "";
		Double diametro=0.0;
		
		do{
			marca = JOptionPane.showInputDialog("Introduce la marca de la rueda");
		}while(!marca.equalsIgnoreCase(MARCA_DUNLOP)&&!marca.equalsIgnoreCase(MARCA_PIRELLI));
		
		do {
			String diametro_usuario = JOptionPane.showInputDialog("Introduce el diametro de la rueda");
			diametro=Double.parseDouble(diametro_usuario);
		}while(diametro<0.4||diametro>4);
		
		Rueda rueda = new Rueda (marca,diametro);
		
		return rueda;
	}

	public String toString() {
		return "Rueda [marca=" + marca + ", diametro=" + diametro + "]";
	}
	
}
