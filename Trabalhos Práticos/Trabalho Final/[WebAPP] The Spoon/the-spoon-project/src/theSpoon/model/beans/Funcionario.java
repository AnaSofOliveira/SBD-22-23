package theSpoon.model.beans;

public class Funcionario extends Utilizador {

	private int numero;
	private Funcionario chefe;
	private Restaurante restaurante;

	public Funcionario(int numero, int nif, String nomeProprio, String apelido, int idade, Restaurante restaurante) {
		super(nif, nomeProprio, apelido, idade);
		this.numero = numero;
		this.restaurante = restaurante;
	}

	public Funcionario(int numero, int nif, String nomeProprio, String apelido, int idade, Funcionario chefe,
			Restaurante restaurante) {
		super(nif, nomeProprio, apelido, idade);
		this.numero = numero;
		this.chefe = chefe;
		this.restaurante = restaurante;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Funcionario getChefe() {
		return chefe;
	}

	public void setChefe(Funcionario chefe) {
		this.chefe = chefe;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	@Override
	public String toString() {
		return "Funcionario [numero=" + numero + ", chefe=" + chefe + ", restaurante=" + restaurante + "]";
	}

}
