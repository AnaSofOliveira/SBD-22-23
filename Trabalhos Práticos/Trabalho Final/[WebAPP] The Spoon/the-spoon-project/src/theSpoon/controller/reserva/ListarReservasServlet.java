package theSpoon.controller.reserva;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import theSpoon.model.dao.ClienteDAO;
import theSpoon.model.dao.ReservaDAO;
import theSpoon.model.entities.Cliente;
import theSpoon.model.entities.Reserva;
import theSpoon.model.entities.Restaurante;
import theSpoon.model.entities.Utilizador;
import theSpoon.model.service.ClienteService;
import theSpoon.model.service.ReservaService;
import theSpoon.model.service.RestauranteService;

/**
 * Servlet implementation class ListarReservasServlet
 */
@WebServlet("/ListarReservasServlet")
public class ListarReservasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarReservasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Identificar cliente
		HttpSession session = request.getSession(); 
		Utilizador user = (Utilizador) session.getAttribute("user");
		
		Cliente cliente = new ClienteService(request, response).getClienteFromUtilizador(user);
		
		// Identificar reservas
		ReservaService reservaService = new ReservaService(request, response);
		RestauranteService restauranteService = new RestauranteService(request, response);
		
		ArrayList<Reserva> reservas = reservaService.getReservasFromCliente(cliente);
		
		ArrayList<String> estadoReservas = new ArrayList<>();
		ArrayList<Restaurante> restaurantesReserva = new ArrayList<>();
		
		String estado = "";
		Restaurante restaurante;
		for(Reserva reserva: reservas) {
			estado = reservaService.validaEstadoReserva(reserva); 
			estadoReservas.add(estado);		
			
			restaurante = restauranteService.getRestauranteFromCodigo(reserva.getCodigoRestaurante());
			restaurantesReserva.add(restaurante);
		}
		
		
		request.setAttribute("reservas", reservas);
		request.setAttribute("restaurantes", restaurantesReserva);
		request.setAttribute("estados", estadoReservas);
		
		request.getRequestDispatcher("./frontend/reservasCliente.jsp").forward(request, response);
	}

}
