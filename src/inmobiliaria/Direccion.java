package inmobiliaria;

public class Direccion {
	
	private String calle;
	private int numeracion;

	public Direccion(String calle, int numeracion) {
		this.calle = calle;
		this.numeracion = numeracion;
	}

	public String getCalle() {
		return calle;
	}

	public int getNumeracion() {
		return numeracion;
	}
	
}
