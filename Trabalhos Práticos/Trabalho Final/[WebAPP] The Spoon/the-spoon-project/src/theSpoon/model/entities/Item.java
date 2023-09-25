package theSpoon.model.entities;

public class Item {

	private int id;
	private String designacao;
	private String descricao;
	private TipoItem tipo;
	private int idRecurso;
	private int quantidade;
	
	public Item(String designacao, TipoItem tipo, int idRecurso) {
		super();
		this.designacao = designacao;
		this.tipo = tipo;
		this.idRecurso = idRecurso;
		this.quantidade = 0;
	}

	public Item(int id, String designacao, TipoItem tipo, int idRecurso) {
		super();
		this.id = id;
		this.designacao = designacao;
		this.tipo = tipo;
		this.idRecurso = idRecurso;
		this.quantidade = 0;
	}

	public Item(int id, String designacao, String descricao, TipoItem tipo, int idRecurso) {
		super();
		this.id = id;
		this.designacao = designacao;
		this.descricao = descricao;
		this.tipo = tipo;
		this.idRecurso = idRecurso;
		this.quantidade = 0;
	}
	
	public Item(int id, String designacao, String descricao, TipoItem tipo, int idRecurso, int quantidade) {
		super();
		this.id = id;
		this.designacao = designacao;
		this.descricao = descricao;
		this.tipo = tipo;
		this.idRecurso = idRecurso;
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", designacao=" + designacao + ", descricao=" + descricao + ", tipo=" + tipo
				+ ", idRecurso=" + idRecurso + ", quantidade=" + quantidade + "]";
	}
	
		// TODO - Constructors Item
	// TODO - Getters and Setters Item
	// TODO - toString Item

}
