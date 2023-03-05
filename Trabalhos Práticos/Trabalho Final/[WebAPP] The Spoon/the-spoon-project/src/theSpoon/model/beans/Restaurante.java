package theSpoon.model.beans;

import java.util.ArrayList;

public class Restaurante {

	private int codigo;
	private String nome;
	private String email;
	private int telefone;
	private Morada morada;
	private ArrayList<Mesa> mesas;
	private ArrayList<Ementa> ementas;
	private ArrayList<Recurso> recursos;
	private ArrayList<Horario> horarios;
	
	
	public Restaurante(int codigo, String nome, String email, int telefone, Morada morada) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.morada = morada;
	}

	public Restaurante(int codigo, String nome, String email, int telefone, Morada morada, ArrayList<Mesa> mesas,
			ArrayList<Ementa> ementas, ArrayList<Recurso> recursos, ArrayList<Horario> horarios) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.morada = morada;
		this.mesas = mesas;
		this.ementas = ementas;
		this.recursos = recursos;
		this.horarios = horarios;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public Morada getMorada() {
		return morada;
	}

	public void setMorada(Morada morada) {
		this.morada = morada;
	}

	public ArrayList<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(ArrayList<Mesa> mesas) {
		this.mesas = mesas;
	}

	public ArrayList<Ementa> getEmentas() {
		return ementas;
	}

	public void setEmentas(ArrayList<Ementa> ementas) {
		this.ementas = ementas;
	}

	public ArrayList<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(ArrayList<Recurso> recursos) {
		this.recursos = recursos;
	}

	public ArrayList<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(ArrayList<Horario> horarios) {
		this.horarios = horarios;
	}

	@Override
	public String toString() {
		return "Restaurante [codigo=" + codigo + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone
				+ ", morada=" + morada + ", mesas=" + mesas + ", ementas=" + ementas + ", recursos=" + recursos
				+ ", horarios=" + horarios + "]";
	}

	// TODO - Constructors Restaurante
	// TODO - Getters and Setters Restaurante
	// TODO - toString Restaurante

}
