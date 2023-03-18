package theSpoon.model.entities;

public class Morada {

	private int codigo;
	private int codigoPostal;
	private String zonaPostal;
	private String designacao;

	public Morada(int codigoPostal, String zonaPostal, String designacao) {
		super();
		this.codigoPostal = codigoPostal;
		this.zonaPostal = zonaPostal;
		this.designacao = designacao;
	}

	public Morada(int codigo, int codigoPostal, String zonaPostal, String designacao) {
		super();
		this.codigo = codigo;
		this.codigoPostal = codigoPostal;
		this.zonaPostal = zonaPostal;
		this.designacao = designacao;
	}

	public Morada(int codigo, int codigoPostal, String zonaPostal) {
		super();
		this.codigo = codigo;
		this.codigoPostal = codigoPostal;
		this.zonaPostal = zonaPostal;
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

	public String getZonaPostal() {
		return zonaPostal;
	}

	public void setZonaPostal(String zonaPostal) {
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
