package theSpoon.model.entities;

import java.util.Date;

public class Reserva {

	private int numero;
	private int codigoRestaurante;
	private Date dataMarcacao;
	private int numeroCliente;
	private int nroPessoas;
	private Date dataPedidoReserva;

	public Reserva(int codigoRestaurante, Date dataMarcacao, int numeroCliente, int nroPessoas,
			Date dataPedidoReserva) {
		super();
		this.codigoRestaurante = codigoRestaurante;
		this.dataMarcacao = dataMarcacao;
		this.numeroCliente = numeroCliente;
		this.nroPessoas = nroPessoas;
		this.dataPedidoReserva = dataPedidoReserva;
	}

	public Reserva(int numero, int codigoRestaurante, Date dataMarcacao, int numeroCliente, int nroPessoas,
			Date dataPedidoReserva) {
		super();
		this.numero = numero;
		this.codigoRestaurante = codigoRestaurante;
		this.dataMarcacao = dataMarcacao;
		this.numeroCliente = numeroCliente;
		this.nroPessoas = nroPessoas;
		this.dataPedidoReserva = dataPedidoReserva;
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

	public Date getDataMarcacao() {
		return dataMarcacao;
	}

	public void setDataMarcacao(Date dataMarcacao) {
		this.dataMarcacao = dataMarcacao;
	}

	public int getNumeroCliente() {
		return numeroCliente;
	}

	public void setNumeroCliente(int numeroCliente) {
		this.numeroCliente = numeroCliente;
	}

	public int getNroPessoas() {
		return nroPessoas;
	}

	public void setNroPessoas(int nroPessoas) {
		this.nroPessoas = nroPessoas;
	}

	public Date getDataPedidoReserva() {
		return dataPedidoReserva;
	}

	public void setDataPedidoReserva(Date dataPedidoReserva) {
		this.dataPedidoReserva = dataPedidoReserva;
	}

	@Override
	public String toString() {
		return "Reserva [numero=" + numero + ", restaurante=" + codigoRestaurante + ", dataMarcacao=" + dataMarcacao
				+ ", cliente=" + numeroCliente + ", nroPessoas=" + nroPessoas + ", dataPedidoReserva="
				+ dataPedidoReserva + "]";
	}

}
