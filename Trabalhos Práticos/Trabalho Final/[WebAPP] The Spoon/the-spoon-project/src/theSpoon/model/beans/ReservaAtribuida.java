package theSpoon.model.beans;

import java.util.Date;

public class ReservaAtribuida {

	private Reserva reserva;
	private Funcionario funcionario;
	private Mesa mesa;
	private EstadoReserva estado;
	private Date dataAlteracaoEstado;

	public ReservaAtribuida(Reserva reserva, Funcionario funcionario, Mesa mesa, EstadoReserva estado,
			Date dataAlteracaoEstado) {
		super();
		this.reserva = reserva;
		this.funcionario = funcionario;
		this.mesa = mesa;
		this.estado = estado;
		this.dataAlteracaoEstado = dataAlteracaoEstado;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
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
		return "ReservaAtribuida [reserva=" + reserva + ", funcionario=" + funcionario + ", mesa=" + mesa + ", estado="
				+ estado + ", dataAlteracaoEstado=" + dataAlteracaoEstado + "]";
	}

	// TODO - Constructors ReservaAtribuida
	// TODO - Getters and Setters ReservaAtribuida
	// TODO - toString ReservaAtribuida
}
