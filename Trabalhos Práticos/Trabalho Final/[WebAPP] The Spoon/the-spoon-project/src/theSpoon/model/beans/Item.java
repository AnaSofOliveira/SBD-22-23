package theSpoon.model.beans;

public class Item {

	private int id;
	private String desginacao;
	private String descricao;
	private TipoItem tipo;
	private int idRecurso;

	public Item(int id, String desginacao, String descricao, TipoItem tipo, int idRecurso) {
		super();
		this.id = id;
		this.desginacao = desginacao;
		this.descricao = descricao;
		this.tipo = tipo;
		this.idRecurso = idRecurso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesginacao() {
		return desginacao;
	}

	public void setDesginacao(String desginacao) {
		this.desginacao = desginacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoItem getTipo() {
		return tipo;
	}

	public void setTipo(TipoItem tipo) {
		this.tipo = tipo;
	}

	public int getRecurso() {
		return idRecurso;
	}

	public void setRecurso(int idRecurso) {
		this.idRecurso = idRecurso;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", desginacao=" + desginacao + ", descricao=" + descricao + ", tipo=" + tipo
				+ ", recurso=" + idRecurso + "]";
	}

	// TODO - Constructors Item
	// TODO - Getters and Setters Item
	// TODO - toString Item

}
