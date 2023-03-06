package theSpoon.model.beans;

import java.util.Date;

public class Horario {

	private Date horaInicio;
	private Date horaFim;
	private DiaSemana diaSemana;
	private int idEmenta;
	private int codigoRestaurante;

	public Horario(Date horaInicio, Date horaFim, DiaSemana diaSemana, int idEmenta, int codigoRestaurante) {
		super();
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.diaSemana = diaSemana;
		this.idEmenta = idEmenta;
		this.codigoRestaurante = codigoRestaurante;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Date horaFim) {
		this.horaFim = horaFim;
	}

	public DiaSemana getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DiaSemana diaSemana) {
		this.diaSemana = diaSemana;
	}

	public int getIdEmenta() {
		return idEmenta;
	}

	public void setIdEmenta(int idEmenta) {
		this.idEmenta = idEmenta;
	}

	public int getCodigoRestaurante() {
		return codigoRestaurante;
	}

	public void setCodigoRestaurante(int codigoRestaurante) {
		this.codigoRestaurante = codigoRestaurante;
	}

	@Override
	public String toString() {
		return "Horario [horaInicio=" + horaInicio + ", horaFim=" + horaFim + ", diaSemana=" + diaSemana + ", idEmenta="
				+ idEmenta + ", codigoRestaurante=" + codigoRestaurante + "]";
	}

}
