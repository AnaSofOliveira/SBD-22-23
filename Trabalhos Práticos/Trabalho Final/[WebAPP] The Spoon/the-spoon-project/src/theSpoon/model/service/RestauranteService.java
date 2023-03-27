package theSpoon.model.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import theSpoon.model.dao.MoradaDAO;
import theSpoon.model.dao.RecursoDAO;
import theSpoon.model.dao.RestauranteDAO;
import theSpoon.model.entities.AreaGeografica;
import theSpoon.model.entities.Morada;
import theSpoon.model.entities.Recurso;
import theSpoon.model.entities.Restaurante;

public class RestauranteService {
	
	private RestauranteDAO restauranteDAO; 
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public RestauranteService(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.restauranteDAO = new RestauranteDAO();
	}
	
	public void adicionarRestaurante() {
		String nome = request.getParameter("nome");

		RestauranteDAO restauranteDAO = new RestauranteDAO();
		Restaurante restaurante = restauranteDAO.findByNome(nome);
		
		String mensagem;
		
		if(restaurante == null) {
			String email = request.getParameter("email"); 
			int telefone = Integer.parseInt(request.getParameter("telefone")); 
			String desigMorada = request.getParameter("desigMorada");
			int codigoPostal = Integer.parseInt(request.getParameter("codigoPostal")); 
			String zonaPostal = request.getParameter("zonaPostal"); 
			
			MoradaDAO moradaDAO = new MoradaDAO(); 
			Morada morada = moradaDAO.findMoradaByDesignacao(desigMorada); 
			AreaGeografica areaGeografica = moradaDAO.getAreaGeograficaFromMorada(morada); 
						
			Restaurante rest = new Restaurante(nome, email, telefone, morada.getCodigo(), areaGeografica.getCodigoPostal(), areaGeografica.getZonaPostal());
			rest = restauranteDAO.create(rest);
			
			if (rest != null){
				mensagem = "Restaurante adicionado";
			}else {
				mensagem = "Não foi possível adicionar o restaurante";
			}
			
		}else {
			mensagem = "Não foi possível adicionar o restaurante";
		}
		listarRestaurantes(mensagem);
	}

	public void listarRestaurantes(String mensagem) {
		
		RestauranteDAO restauranteDAO = new RestauranteDAO(); 
		ArrayList<Restaurante> restaurantes = restauranteDAO.listAll(); 
		ArrayList<Recurso> recursos = new ArrayList<>();
		
		for (Restaurante restaurante: restaurantes) {
			RecursoDAO recursoDAO = new RecursoDAO(); 
			Recurso recurso = recursoDAO.getRecursoFromRestaurante(restaurante);
			recursos.add(recurso);
		}
		request.setAttribute("restaurantes", restaurantes);
		request.setAttribute("recursos", recursos);

		try {
			request.getRequestDispatcher("./listar_restaurantes.jsp").include(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	

}
