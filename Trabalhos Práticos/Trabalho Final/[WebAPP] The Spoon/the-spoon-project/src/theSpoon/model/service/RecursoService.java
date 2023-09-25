package theSpoon.model.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import theSpoon.model.dao.RecursoDAO;
import theSpoon.model.entities.Recurso;
import theSpoon.model.entities.Restaurante;

public class RecursoService {
	
	private RecursoDAO recursoDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public RecursoService(HttpServletRequest request, HttpServletResponse response) {
		this.request = request; 
		this.response = response; 
		this.recursoDAO = new RecursoDAO();
	}

	
	public Recurso getRecursoFromRestaurante(Restaurante restaurante) {
		Recurso recurso = this.recursoDAO.getRecursoFromRestaurante(restaurante);
		return recurso;
	}

}
