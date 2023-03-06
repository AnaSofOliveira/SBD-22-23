package theSpoon.model.beans;

import java.util.ArrayList;

public class Ementa {

	private int id;
	private int codigoRestaurante;
	private String designacao;
	private ArrayList<Item> itens;

	public Ementa(int id, int codigoRestaurante, String designacao) {
		super();
		this.id = id;
		this.codigoRestaurante = codigoRestaurante;
		this.designacao = designacao;
	}

	public Ementa(int id, int codigoRestaurante, String designacao, ArrayList<Item> itens) {
		super();
		this.id = id;
		this.codigoRestaurante = codigoRestaurante;
		this.designacao = designacao;
		this.itens = itens;
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

	public ArrayList<Item> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}

	@Override
	public String toString() {
		return "Ementa [id=" + id + ", codigoRestaurante=" + codigoRestaurante + ", designacao=" + designacao
				+ ", itens=" + itens + "]";
	}

}
