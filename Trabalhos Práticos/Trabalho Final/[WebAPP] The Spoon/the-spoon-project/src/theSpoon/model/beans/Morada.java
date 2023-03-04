package theSpoon.model.beans;

public class Morada {

	private int codigo;
	private AreaGeografica areaGeografica;
	private String designacao;

	public Morada(AreaGeografica areaGeografica, String designacao) {
		super();
		this.areaGeografica = areaGeografica;
		this.designacao = designacao;
	}

	public Morada(int codigo, AreaGeografica areaGeografica, String designacao) {
		super();
		this.codigo = codigo;
		this.areaGeografica = areaGeografica;
		this.designacao = designacao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public AreaGeografica getAreaGeografica() {
		return areaGeografica;
	}

	public void setAreaGeografica(AreaGeografica areaGeografica) {
		this.areaGeografica = areaGeografica;
	}

	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}

	@Override
	public String toString() {
		return "Morada [codigo=" + codigo + ", areaGeografica=" + areaGeografica + ", designacao=" + designacao + "]";
	}


}
