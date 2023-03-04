package theSpoon.model.beans;

public class Funcionario extends Utilizador {

	private Funcionario chefe;
	private Restaurante restaurante;

	public Funcionario(int nif, String nomeProprio, String apelido, int idade, Restaurante restaurante) {
		super(nif, nomeProprio, apelido, idade);
		this.restaurante = restaurante;
	}

	public Funcionario(int nif, String nomeProprio, String apelido, int idade, Funcionario chefe,
			Restaurante restaurante) {
		super(nif, nomeProprio, apelido, idade);
		this.chefe = chefe;
		this.restaurante = restaurante;
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
		return "Funcionario [nif=" + super.getNif() + "," + " nomeProprio=" + super.getNomeProprio() + "," + " apelido="
				+ super.getApelido() + "," + " idade=" + super.getIdade() + "," + " chefe=" + chefe + ", restaurante="
				+ restaurante + "]";
	}
}
