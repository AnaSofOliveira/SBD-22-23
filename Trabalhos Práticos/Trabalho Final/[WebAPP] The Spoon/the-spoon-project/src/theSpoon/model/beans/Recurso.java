package theSpoon.model.beans;

public class Recurso {

	private int id;
	private String nome;
	private String extensao;
	private byte[] conteudo;

	public Recurso(int id, String nome, String extensao, byte[] conteudo) {
		super();
		this.id = id;
		this.nome = nome;
		this.extensao = extensao;
		this.conteudo = conteudo;
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

	public byte[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}

	@Override
	public String toString() {
		return "Recurso [id=" + id + ", nome=" + nome + ", extensao=" + extensao + "]";
	}

	// TODO - Constructors Recurso
	// TODO - Getters and Setters Recurso
	// TODO - toString Recurso
}
