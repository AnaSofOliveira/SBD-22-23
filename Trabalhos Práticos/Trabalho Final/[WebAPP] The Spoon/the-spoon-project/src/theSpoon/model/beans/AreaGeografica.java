package theSpoon.model.beans;

public class AreaGeografica {

	private int codigoPostal;
	private int zonaPostal;
	private String freguesia;
	private String concelho;
	private String distrito;
	
	public AreaGeografica(int codigoPostal, int zonaPostal, String freguesia, String concelho, String distrito) {
		super();
		this.codigoPostal = codigoPostal;
		this.zonaPostal = zonaPostal;
		this.freguesia = freguesia;
		this.concelho = concelho;
		this.distrito = distrito;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public int getZonaPostal() {
		return zonaPostal;
	}

	public void setZonaPostal(int zonaPostal) {
		this.zonaPostal = zonaPostal;
	}

	public String getFreguesia() {
		return freguesia;
	}

	public void setFreguesia(String freguesia) {
		this.freguesia = freguesia;
	}

	public String getConcelho() {
		return concelho;
	}

	public void setConcelho(String concelho) {
		this.concelho = concelho;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	@Override
	public String toString() {
		return "AreaGeografica [codigoPostal=" + codigoPostal + ", zonaPostal=" + zonaPostal + ", freguesia="
				+ freguesia + ", concelho=" + concelho + ", distrito=" + distrito + "]";
	}

}
