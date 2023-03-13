package theSpoon.model.entities;

import java.awt.Image;

public class Recurso {

	private int id;
	private String nome;
	private String extensao;
	private String path;

	public Recurso(String nome, String extensao, String path) {
		super();
		this.nome = nome;
		this.extensao = extensao;
		this.path = path;
	}

	public Recurso(int id, String nome, String extensao, String path) {
		super();
		this.id = id;
		this.nome = nome;
		this.extensao = extensao;
		this.path = path;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Recurso [id=" + id + ", nome=" + nome + ", extensao=" + extensao + "]";
	}

}
