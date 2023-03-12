package theSpoon.model.entities;

public class Ementa {

	private int id;
	private int codigoRestaurante;
	private String designacao;
	
	
	public Ementa(int codigoRestaurante, String designacao) {
		super();
		this.codigoRestaurante = codigoRestaurante;
		this.designacao = designacao;
	}

	public Ementa(int id, int codigoRestaurante, String designacao) {
		super();
		this.id = id;
		this.codigoRestaurante = codigoRestaurante;
		this.designacao = designacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigoRestaurante() {
		return codigoRestaurante;
	}

	public void setCodigoRestaurante(int codigoRestaurante) {
		this.codigoRestaurante = codigoRestaurante;
	}

	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}
	@Override
	public String toString() {
		return "Ementa [id=" + id + ", codigoRestaurante=" + codigoRestaurante + ", designacao=" + designacao
				+ "]";
	}

}
