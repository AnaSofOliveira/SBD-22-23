package theSpoon.model.entities;

public enum DiaSemana {
	Seg, Ter, Qua, Qui, Sex, Sab, Dom;

	public static DiaSemana fromInt(int dia) {
		switch (dia) {
		case 1:
			return Dom;
		case 2:
			return Seg;
		case 3:
			return Ter;
		case 4:
			return Qua;
		case 5:
			return Qui;
		case 6:
			return Sex;
		case 7:
			return Sab;
		}
		return null;
	}
	
}
