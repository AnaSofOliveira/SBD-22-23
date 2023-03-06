package theSpoon.model.beans;

import java.util.Date;

public class Cliente extends Utilizador {

	private int numero;
	private Date dataUltimaVisita;
	private int codigoMorada;
	private int codigoArea;
	private int zonaArea;

	public Cliente(int nif, String nomeProprio, String apelido, int idade, int codigoMorada, int codigoArea,
			int zonaArea) {
		super(nif, nomeProprio, apelido, idade);
		this.codigoMorada = codigoMorada;
		this.codigoArea = codigoArea;
		this.zonaArea = zonaArea;
	}

	public Cliente(int nif, String nomeProprio, String apelido, int idade, int numero, int codigoMorada, int codigoArea,
			int zonaArea) {
		super(nif, nomeProprio, apelido, idade);
		this.numero = numero;
		this.codigoMorada = codigoMorada;
		this.codigoArea = codigoArea;
		this.zonaArea = zonaArea;
	}

	public Cliente(int nif, String nomeProprio, String apelido, int idade, int numero, Date dataUltimaVisita,
			int codigoMorada, int codigoArea, int zonaArea) {
		super(nif, nomeProprio, apelido, idade);
		this.numero = numero;
		this.dataUltimaVisita = dataUltimaVisita;
		this.codigoMorada = codigoMorada;
		this.codigoArea = codigoArea;
		this.zonaArea = zonaArea;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getDataUltimaVisita() {
		return dataUltimaVisita;
	}

	public void setDataUltimaVisita(Date dataUltimaVisita) {
		this.dataUltimaVisita = dataUltimaVisita;
	}

	public int getCodigoMorada() {
		return codigoMorada;
	}

	public void setCodigoMorada(int codigoMorada) {
		this.codigoMorada = codigoMorada;
	}

	public int getCodigoArea() {
		return codigoArea;
	}

	public void setCodigoArea(int codigoArea) {
		this.codigoArea = codigoArea;
	}

	public int getZonaArea() {
		return zonaArea;
	}

	public void setZonaArea(int zonaArea) {
		this.zonaArea = zonaArea;
	}

	@Override
	public String toString() {
		return "Cliente [numero=" + numero + ", dataUltimaVisita=" + dataUltimaVisita + ", codigoMorada=" + codigoMorada
				+ ", codigoArea=" + codigoArea + ", zonaArea=" + zonaArea + "]";
	}

}
