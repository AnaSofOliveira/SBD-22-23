package theSpoon.model.entities;

public class Utilizador {

	private int nif;
	private String nomeProprio;
	private String apelido;
	private int idade;

	public Utilizador(int nif, String nomeProprio, String apelido, int idade) {
		super();
		this.nif = nif;
		this.nomeProprio = nomeProprio;
		this.apelido = apelido;
		this.idade = idade;
	}

	public int getNif() {
		return nif;
	}

	public void setNif(int nif) {
		this.nif = nif;
	}

	public String getNomeProprio() {
		return nomeProprio;
	}

	public void setNomeProprio(String nomeProprio) {
		this.nomeProprio = nomeProprio;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Utilizador [nif=" + nif + ", nomeProprio=" + nomeProprio + ", apelido=" + apelido + ", idade=" + idade
				+ "]";
	}

}
