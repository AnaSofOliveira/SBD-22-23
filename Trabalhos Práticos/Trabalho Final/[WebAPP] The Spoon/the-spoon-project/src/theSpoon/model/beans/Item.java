package theSpoon.model.beans;

public class Item {

	private int id;
	private String desginacao;
	private String descricao;
	private TipoItem tipo;
	private Recurso recurso;

	public Item(int id, String desginacao, String descricao, TipoItem tipo, Recurso recurso) {
		super();
		this.id = id;
		this.desginacao = desginacao;
		this.descricao = descricao;
		this.tipo = tipo;
		this.recurso = recurso;
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

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", desginacao=" + desginacao + ", descricao=" + descricao + ", tipo=" + tipo
				+ ", recurso=" + recurso + "]";
	}

	// TODO - Constructors Item
	// TODO - Getters and Setters Item
	// TODO - toString Item

}
