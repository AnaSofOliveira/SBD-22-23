package theSpoon.model.entities;

import java.util.Date;

public class ReservaAtribuida {

	private int numeroReserva;
	private int codigoRestaurante;
	private int numeroFuncionario;
	private int numeroMesa;
	private EstadoReserva estado;
	private Date dataAlteracaoEstado;

	public ReservaAtribuida(int numeroReserva, int codigoRestaurante, int numeroFuncionario, int numeroMesa,
			EstadoReserva estado, Date dataAlteracaoEstado) {
		super();
		this.numeroReserva = numeroReserva;
		this.codigoRestaurante = codigoRestaurante;
		this.numeroFuncionario = numeroFuncionario;
		this.numeroMesa = numeroMesa;
		this.estado = estado;
		this.dataAlteracaoEstado = dataAlteracaoEstado;
	}

	

	public ReservaAtribuida(int numeroReserva, int codigoRestaurante, int numeroFuncionario, EstadoReserva estado,
			Date dataAlteracaoEstado) {
		super();
		this.numeroReserva = numeroReserva;
		this.codigoRestaurante = codigoRestaurante;
		this.numeroFuncionario = numeroFuncionario;
		this.estado = estado;
		this.dataAlteracaoEstado = dataAlteracaoEstado;
	}



	public int getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(int numeroReserva) {
		this.numeroReserva = numeroReserva;
	}

	public int getCodigoRestaurante() {
		return codigoRestaurante;
	}

	public void setCodigoRestaurante(int codigoRestaurante) {
		this.codigoRestaurante = codigoRestaurante;
	}

	public int getNumeroFuncionario() {
		return numeroFuncionario;
	}

	public void setNumeroFuncionario(int numeroFuncionario) {
		this.numeroFuncionario = numeroFuncionario;
	}

	public int getNumeroMesa() {
		return numeroMesa;
	}

	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	public EstadoReserva getEstado() {
		return estado;
	}

	public void setEstado(EstadoReserva estado) {
		this.estado = estado;
	}

	public Date getDataAlteracaoEstado() {
		return dataAlteracaoEstado;
	}

	public void setDataAlteracaoEstado(Date dataAlteracaoEstado) {
		this.dataAlteracaoEstado = dataAlteracaoEstado;
	}

	@Override
	public String toString() {
		return "ReservaAtribuida [numeroReserva=" + numeroReserva + ", codigoRestaurante=" + codigoRestaurante
				+ ", numeroFuncionario=" + numeroFuncionario + ", numeroMesa=" + numeroMesa + ", estado=" + estado
				+ ", dataAlteracaoEstado=" + dataAlteracaoEstado + "]";
	}

}
