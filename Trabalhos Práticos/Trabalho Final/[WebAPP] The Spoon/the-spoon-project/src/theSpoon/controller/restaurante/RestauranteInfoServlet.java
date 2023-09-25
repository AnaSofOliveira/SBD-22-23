package theSpoon.controller.restaurante;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import theSpoon.model.dao.MoradaDAO;
import theSpoon.model.dao.RecursoDAO;
import theSpoon.model.dao.RestauranteDAO;
import theSpoon.model.entities.Horario;
import theSpoon.model.entities.Morada;
import theSpoon.model.entities.Recurso;
import theSpoon.model.entities.Restaurante;
import theSpoon.model.service.MoradaService;
import theSpoon.model.service.RecursoService;
import theSpoon.model.service.RestauranteService;

/**
 * Servlet implementation class RestauranteInfoServlet
 */
@WebServlet("/RestauranteInfoServlet")
public class RestauranteInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestauranteInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codigoRestaurante = Integer.parseInt(request.getParameter("codigo"));
		
		RestauranteService restauranteService = new RestauranteService(request, response);
		Restaurante restaurante = restauranteService.getRestauranteFromCodigo(codigoRestaurante);

		Morada morada = new MoradaService(request, response).getMoradaFromRestaurante(restaurante);
		Recurso recurso = new RecursoService(request, response).getRecursoFromRestaurante(restaurante);

		ArrayList<Horario> horarios = restauranteService.getHorariosFromRestaurante(restaurante);
		
		request.setAttribute("restaurante", restaurante);
		request.setAttribute("morada", morada);
		request.setAttribute("recurso", recurso);
		request.setAttribute("horarios", horarios);
		
		request.getRequestDispatcher("frontend/infoRestaurante.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
