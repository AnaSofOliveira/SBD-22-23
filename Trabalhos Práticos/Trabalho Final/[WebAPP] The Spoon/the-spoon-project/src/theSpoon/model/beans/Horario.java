package theSpoon.model.beans;

import java.util.Date;

public class Horario {

	private Date horaInicio;
	private Date horaFim;
	private DiaSemana diaSemana;

	public Horario(Date horaInicio, Date horaFim, DiaSemana diaSemana) {
		super();
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.diaSemana = diaSemana;
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

	@Override
	public String toString() {
		return "Horario [horaInicio=" + horaInicio + ", horaFim=" + horaFim + ", diaSemana=" + diaSemana + "]";
	}

}
