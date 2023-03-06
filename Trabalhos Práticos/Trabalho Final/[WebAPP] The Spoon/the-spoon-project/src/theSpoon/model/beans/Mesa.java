package theSpoon.model.beans;

import java.util.ArrayList;

public class Mesa {

	private int numero;
	private int codigoRestaurante;
	private int lotacao;
	/* private ArrayList<Caracteristica> caracteristicas; */

	public Mesa(int numero, int codigoRestaurante, int lotacao) {
		super();
		this.numero = numero;
		this.codigoRestaurante = codigoRestaurante;
		this.lotacao = lotacao;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCodigoRestaurante() {
		return codigoRestaurante;
	}

	public void setCodigoRestaurante(int codigoRestaurante) {
		this.codigoRestaurante = codigoRestaurante;
	}

	public int getLotacao() {
		return lotacao;
	}

	public void setLotacao(int lotacao) {
		this.lotacao = lotacao;
	}

	/*
	 * public ArrayList<Caracteristica> getCaracteristicas() { return
	 * caracteristicas; }
	 * 
	 * public void setCaracteristicas(ArrayList<Caracteristica> caracteristicas) {
	 * this.caracteristicas = caracteristicas; }
	 */

	@Override
	public String toString() {
		return "Mesa [numero=" + numero + ", codigoRestaurante=" + codigoRestaurante + ", lotacao=" + lotacao
				+ "]";
	}

	// TODO - Constructors Mesa
	// TODO - Getters and Setters Mesa
	// TODO - toString Mesa

}
