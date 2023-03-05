package theSpoon.model.beans;

import java.util.Date;

public class Cliente extends Utilizador {

	private int numero; 
	private Date dataUltimaVisita;
	private Morada morada;

	public Cliente(int numero, int nif, String nomeProprio, String apelido, int idade, Morada morada) {
		super(nif, nomeProprio, apelido, idade);
		this.numero = numero; 
		this.morada = morada;
	}

	public Cliente(int numero, int nif, String nomeProprio, String apelido, int idade, Date dataUltimaVisita, Morada morada) {
		super(nif, nomeProprio, apelido, idade);
		this.numero = numero; 
		this.dataUltimaVisita = dataUltimaVisita;
		this.morada = morada;
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

	public Morada getMorada() {
		return morada;
	}

	public void setMorada(Morada morada) {
		this.morada = morada;
	}

	@Override
	public String toString() {
		return "Cliente [ numero=" + getNumero() + ", nif=" + super.getNif() + "," + " nomeProprio=" + super.getNomeProprio() + ","
				+ " apelido=" + super.getApelido() + "," + " idade=" + super.getIdade() + "," + " dataUltimaVisita="
				+ dataUltimaVisita + "," + " morada=" + morada + "]";
	}
}
