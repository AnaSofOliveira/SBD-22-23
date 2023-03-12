package theSpoon.model.entities;

import java.util.ArrayList;
import java.util.Date;

public class Reserva {

	private int numero;
	private int codigoRestaurante;
	private Date dataMarcacao;
	private int numeroCliente;
	private int nroPessoas;
	private Date dataPedidoReserva;
	/*
	 * private ArrayList<Caracteristica> caracteristicas; private ArrayList<Item>
	 * itens;
	 */

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

	public Reserva(int numero, int codigoRestaurante, Date dataMarcacao, int numeroCliente, int nroPessoas,
			Date dataPedidoReserva, ArrayList<Caracteristica> caracteristicas, ArrayList<Item> itens) {
		super();
		this.numero = numero;
		this.codigoRestaurante = codigoRestaurante;
		this.dataMarcacao = dataMarcacao;
		this.numeroCliente = numeroCliente;
		this.nroPessoas = nroPessoas;
		this.dataPedidoReserva = dataPedidoReserva;
		/*
		 * this.caracteristicas = caracteristicas; this.itens = itens;
		 */
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getRestaurante() {
		return codigoRestaurante;
	}

	public void setRestaurante(int codigoRestaurante) {
		this.codigoRestaurante = codigoRestaurante;
	}

	public Date getDataMarcacao() {
		return dataMarcacao;
	}

	public void setDataMarcacao(Date dataMarcacao) {
		this.dataMarcacao = dataMarcacao;
	}

	public int getCliente() {
		return numeroCliente;
	}

	public void setCliente(int numeroCliente) {
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

	/*
	 * public ArrayList<Caracteristica> getCaracteristicas() { return
	 * caracteristicas; }
	 * 
	 * public void setCaracteristicas(ArrayList<Caracteristica> caracteristicas) {
	 * this.caracteristicas = caracteristicas; }
	 * 
	 * public ArrayList<Item> getItens() { return itens; }
	 * 
	 * public void setItens(ArrayList<Item> itens) { this.itens = itens; }
	 */

	@Override
	public String toString() {
		return "Reserva [numero=" + numero + ", restaurante=" + codigoRestaurante + ", dataMarcacao=" + dataMarcacao
				+ ", cliente=" + numeroCliente + ", nroPessoas=" + nroPessoas + ", dataPedidoReserva=" + dataPedidoReserva
				+ "]";
	}

	// TODO - Constructors Reserva
	// TODO - Getters and Setters Reserva
	// TODO - toString Reserva

}
