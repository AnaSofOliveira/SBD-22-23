package theSpoon.model.beans;

public class Funcionario extends Utilizador {

	private int numero;
	private int numeroFuncionarioChefe = -1;
	private int codigoRestaurante;

	public Funcionario(int nif, String nomeProprio, String apelido, int idade, int numeroFuncionarioChefe,
			int codigoRestaurante) {
		super(nif, nomeProprio, apelido, idade);
		this.numeroFuncionarioChefe = numeroFuncionarioChefe;
		this.codigoRestaurante = codigoRestaurante;
	}

	public Funcionario(int nif, String nomeProprio, String apelido, int idade, int numero, int numeroFuncionarioChefe,
			int codigoRestaurante) {
		super(nif, nomeProprio, apelido, idade);
		this.numero = numero;
		this.numeroFuncionarioChefe = numeroFuncionarioChefe;
		this.codigoRestaurante = codigoRestaurante;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumeroFuncionarioChefe() {
		return numeroFuncionarioChefe;
	}

	public void setNumeroFuncionarioChefe(int numeroFuncionarioChefe) {
		this.numeroFuncionarioChefe = numeroFuncionarioChefe;
	}

	public int getCodigoRestaurante() {
		return codigoRestaurante;
	}

	public void setCodigoRestaurante(int codigoRestaurante) {
		this.codigoRestaurante = codigoRestaurante;
	}

	@Override
	public String toString() {
		return "Funcionario [numero=" + numero + ", numeroFuncionarioChefe=" + numeroFuncionarioChefe
				+ ", codigoRestaurante=" + codigoRestaurante + "]";
	}

}
