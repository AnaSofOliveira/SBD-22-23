package theSpoon.model.beans;

import java.util.ArrayList;
import java.util.Date;

public class Reserva {

	private int numero;
	private Restaurante restaurante;
	private Date dataMarcacao;
	private Cliente cliente;
	private int nroPessoas;
	private Date dataPedidoReserva;
	private ArrayList<Caracteristica> caracteristicas;
	private ArrayList<Item> itens;

	public Reserva(int numero, Restaurante restaurante, Date dataMarcacao, Cliente cliente, int nroPessoas,
			Date dataPedidoReserva) {
		super();
		this.numero = numero;
		this.restaurante = restaurante;
		this.dataMarcacao = dataMarcacao;
		this.cliente = cliente;
		this.nroPessoas = nroPessoas;
		this.dataPedidoReserva = dataPedidoReserva;
	}

	public Reserva(int numero, Restaurante restaurante, Date dataMarcacao, Cliente cliente, int nroPessoas,
			Date dataPedidoReserva, ArrayList<Caracteristica> caracteristicas, ArrayList<Item> itens) {
		super();
		this.numero = numero;
		this.restaurante = restaurante;
		this.dataMarcacao = dataMarcacao;
		this.cliente = cliente;
		this.nroPessoas = nroPessoas;
		this.dataPedidoReserva = dataPedidoReserva;
		this.caracteristicas = caracteristicas;
		this.itens = itens;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public Date getDataMarcacao() {
		return dataMarcacao;
	}

	public void setDataMarcacao(Date dataMarcacao) {
		this.dataMarcacao = dataMarcacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public ArrayList<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(ArrayList<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public ArrayList<Item> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}

	@Override
	public String toString() {
		return "Reserva [numero=" + numero + ", restaurante=" + restaurante + ", dataMarcacao=" + dataMarcacao
				+ ", cliente=" + cliente + ", nroPessoas=" + nroPessoas + ", dataPedidoReserva=" + dataPedidoReserva
				+ ", caracteristicas=" + caracteristicas + ", itens=" + itens + "]";
	}

	// TODO - Constructors Reserva
	// TODO - Getters and Setters Reserva
	// TODO - toString Reserva

}
