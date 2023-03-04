package theSpoon.model.beans;

import java.util.Date;

public class Cliente extends Utilizador {

	private Date dataUltimaVisita;
	private Morada morada;

	public Cliente(int nif, String nomeProprio, String apelido, int idade, Morada morada) {
		super(nif, nomeProprio, apelido, idade);
		this.morada = morada;
	}

	public Cliente(int nif, String nomeProprio, String apelido, int idade, Date dataUltimaVisita, Morada morada) {
		super(nif, nomeProprio, apelido, idade);
		this.dataUltimaVisita = dataUltimaVisita;
		this.morada = morada;
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
		return "Cliente [" + " nif=" + super.getNif() + "," + " nomeProprio=" + super.getNomeProprio() + ","
				+ " apelido=" + super.getApelido() + "," + " idade=" + super.getIdade() + "," + " dataUltimaVisita="
				+ dataUltimaVisita + "," + " morada=" + morada + "]";
	}

	public int getCodigoArea() {
		// TODO Auto-generated method stub
		return 0;
	}

}
