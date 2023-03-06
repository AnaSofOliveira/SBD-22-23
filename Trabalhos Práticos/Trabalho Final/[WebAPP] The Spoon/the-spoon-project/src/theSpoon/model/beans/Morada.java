package theSpoon.model.beans;

public class Morada {

	private int codigo;
	private int codigoPostal;
	private int zonaPostal;
	private String designacao;

	public Morada(int codigo, int codigoPostal, int zonaPostal, String designacao) {
		super();
		this.codigo = codigo;
		this.codigoPostal = codigoPostal;
		this.zonaPostal = zonaPostal;
		this.designacao = designacao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public int getZonaPostal() {
		return zonaPostal;
	}

	public void setZonaPostal(int zonaPostal) {
		this.zonaPostal = zonaPostal;
	}

	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}

	@Override
	public String toString() {
		return "Morada [codigo=" + codigo + ", codigoPostal=" + codigoPostal + ", zonaPostal=" + zonaPostal
				+ ", designacao=" + designacao + "]";
	}

}
