package theSpoon.model.beans;

import java.util.ArrayList;

public class Ementa {
	
	private int id;
	private Restaurante restaurante;
	private String designacao;
	private ArrayList<Item> itens;
	
	public Ementa(int id, Restaurante restaurante, String designacao, ArrayList<Item> itens) {
		super();
		this.id = id;
		this.restaurante = restaurante;
		this.designacao = designacao;
		this.itens = itens;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
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
		return "Ementa [id=" + id + ", restaurante=" + restaurante + ", designacao=" + designacao + ", itens=" + itens + "]";
	}

}
