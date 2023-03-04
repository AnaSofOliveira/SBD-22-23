package theSpoon.model.beans;

public class Caracteristica {

	private int numero;
	private String caracteristica;

	public Caracteristica(String caracteristica) {
		super();
		this.caracteristica = caracteristica;
	}

	public Caracteristica(int numero, String caracteristica) {
		super();
		this.numero = numero;
		this.caracteristica = caracteristica;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	@Override
	public String toString() {
		return "Caracteristica [numero=" + numero + ", caracteristica=" + caracteristica + "]";
	}

}
