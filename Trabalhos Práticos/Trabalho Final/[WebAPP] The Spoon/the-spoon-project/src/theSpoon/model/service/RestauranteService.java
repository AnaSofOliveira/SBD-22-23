package theSpoon.model.service;

import java.awt.image.RescaleOp;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import theSpoon.model.dao.MoradaDAO;
import theSpoon.model.dao.RecursoDAO;
import theSpoon.model.dao.RestauranteDAO;
import theSpoon.model.entities.AreaGeografica;
import theSpoon.model.entities.Caracteristica;
import theSpoon.model.entities.Horario;
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

		if (restaurante == null) {
			String email = request.getParameter("email");
			int telefone = Integer.parseInt(request.getParameter("telefone"));
			String desigMorada = request.getParameter("desigMorada");
			int codigoPostal = Integer.parseInt(request.getParameter("codigoPostal"));
			String zonaPostal = request.getParameter("zonaPostal");

			MoradaDAO moradaDAO = new MoradaDAO();
			Morada morada = moradaDAO.findMoradaByDesignacao(desigMorada);
			AreaGeografica areaGeografica = moradaDAO.getAreaGeograficaFromMorada(morada);

			Restaurante rest = new Restaurante(nome, email, telefone, morada.getCodigo(),
					areaGeografica.getCodigoPostal(), areaGeografica.getZonaPostal());
			rest = restauranteDAO.create(rest);

			if (rest != null) {
				mensagem = "Restaurante adicionado";
			} else {
				mensagem = "Não foi possível adicionar o restaurante";
			}

		} else {
			mensagem = "Não foi possível adicionar o restaurante";
		}
		listarRestaurantes(mensagem);
	}

	public void listarRestaurantes(String mensagem) {

		RestauranteDAO restauranteDAO = new RestauranteDAO();
		ArrayList<Restaurante> restaurantes = restauranteDAO.listAll();
		ArrayList<Recurso> recursos = new ArrayList<>();

		for (Restaurante restaurante : restaurantes) {
			RecursoDAO recursoDAO = new RecursoDAO();
			Recurso recurso = recursoDAO.getRecursoFromRestaurante(restaurante);
			recursos.add(recurso);
		}
		request.setAttribute("restaurantes", restaurantes);
		request.setAttribute("recursos", recursos);

		try {
			request.getRequestDispatcher("./listar_restaurantes.jsp").include(request, response);
		} catch (ServletException | IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void getCaracteristicasFromRestaurante() {
		try {
			int codigoRestaurante = Integer.parseInt(request.getParameter("codigoRestaurante"));

			RestauranteDAO restauranteDAO = new RestauranteDAO();

			Map<String, Object> caracteristicas = new HashMap<String, Object>();
			caracteristicas.put("caracteristicas", restauranteDAO.getCaracteristicas(codigoRestaurante));

			response.setContentType("application/json");

			PrintWriter out = response.getWriter();
			out.print(new Gson().toJson(caracteristicas));

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public Restaurante getRestaurante() {
		int codigoRestaurante = Integer.parseInt(request.getParameter("codigoRestaurante"));

		Restaurante restaurante = new RestauranteDAO().get(new Restaurante(codigoRestaurante));

		return restaurante;

	}

	public void listarRestaurantesByName() {
		try {

			String pesquisa = this.request.getParameter("termo");

			ArrayList<Restaurante> restaurantes = this.restauranteDAO.listAll();
			ArrayList<Recurso> recursos = new ArrayList<>();

			ArrayList<Restaurante> restaurantesEncontrados = new ArrayList<Restaurante>();
			for (Restaurante restaurante : restaurantes) {
				String nome = restaurante.getNome().toLowerCase();
				String term = pesquisa.toLowerCase();

				if (term.equals("")) {
					restaurantesEncontrados = new ArrayList<>();
					recursos = new ArrayList<>();
				} else {
					System.out.println(nome + " " + term);
					if (nome.contains(term)) {
						RecursoDAO recursoDAO = new RecursoDAO();
						Recurso recurso = recursoDAO.getRecursoFromRestaurante(restaurante);

						restaurantesEncontrados.add(restaurante);
						recursos.add(recurso);
					}
				}
			}
			Map<String, Object> resultado = new HashMap<String, Object>();
			resultado.put("restaurantes", restaurantesEncontrados);
			resultado.put("recursos", recursos);

			response.setContentType("application/json");

			PrintWriter out = response.getWriter();
			out.print(new Gson().toJson(resultado));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public Restaurante getRestauranteFromCodigo(int codigoRestaurante) {
		Restaurante restaurante = this.restauranteDAO.getRestauranteFromCodigo(codigoRestaurante);
		return restaurante;
	}

	public ArrayList<Horario> getHorariosFromRestaurante(Restaurante restaurante) {
		ArrayList<Horario> horarios = this.restauranteDAO.getHorariosFromRestaurante(restaurante);
		
		return horarios;
	}

}
