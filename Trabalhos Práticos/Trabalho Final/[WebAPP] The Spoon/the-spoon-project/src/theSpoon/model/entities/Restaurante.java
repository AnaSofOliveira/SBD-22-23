package theSpoon.model.entities;

import java.util.ArrayList;

public class Restaurante {

	private int codigo;
	private String nome;
	private String email;
	private int telefone;
	private int codigoMorada;
	private int codigoArea;
	private String zonaArea;

	public Restaurante(String nome, String email, int telefone, int codigoMorada, int codigoArea,
			String zonaArea) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.codigoMorada = codigoMorada;
		this.codigoArea = codigoArea;
		this.zonaArea = zonaArea;
	}
	
	public Restaurante(int codigo, String nome, String email, int telefone, int codigoMorada, int codigoArea,
			String zonaArea) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.codigoMorada = codigoMorada;
		this.codigoArea = codigoArea;
		this.zonaArea = zonaArea;
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

	public int getCodigoMorada() {
		return codigoMorada;
	}

	public void setCodigoMorada(int codigoMorada) {
		this.codigoMorada = codigoMorada;
	}

	public int getCodigoArea() {
		return codigoArea;
	}

	public void setCodigoArea(int codigoArea) {
		this.codigoArea = codigoArea;
	}

	public String getZonaArea() {
		return zonaArea;
	}

	public void setZonaArea(String zonaArea) {
		this.zonaArea = zonaArea;
	}

	@Override
	public String toString() {
		return "Restaurante [codigo=" + codigo + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone
				+ ", codigoMorada=" + codigoMorada + ", codigoArea=" + codigoArea + ", zonaArea=" + zonaArea + "]";
	}

}
