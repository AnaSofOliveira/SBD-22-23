package theSpoon.controller.reserva;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import theSpoon.model.entities.Caracteristica;
import theSpoon.model.entities.Item;
import theSpoon.model.entities.Reserva;
import theSpoon.model.entities.Restaurante;
import theSpoon.model.service.ItensService;
import theSpoon.model.service.ReservaService;
import theSpoon.model.service.RestauranteService;

/**
 * Servlet implementation class InformarReservaConcluida
 */
@WebServlet("/InformarReservaConcluida")
public class InformarReservaConcluida extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InformarReservaConcluida() {
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
				
		ReservaService reservaService = new ReservaService(request, response); 
		RestauranteService restauranteService = new RestauranteService(request, response);
		
		Restaurante restaurante = restauranteService.getRestaurante();
		Reserva reserva = reservaService.getReserva();
		
		ArrayList<Item> itensReservados = reservaService.getItensReservados(reserva); 
		ArrayList<Caracteristica> caracteristicasReservadas = reservaService.getCaracteristicasReservadas(reserva); 

		System.out.println("ItensReservados: " + itensReservados);
		
		request.setAttribute("restaurante", restaurante);
		request.setAttribute("dataHora", new SimpleDateFormat("dd-MM-yyyy HH:mm").format(reserva.getDataMarcacao()));
		request.setAttribute("reserva", reserva);
		request.setAttribute("itens", itensReservados);
		request.setAttribute("caracteristicas", caracteristicasReservadas);
		
		request.getRequestDispatcher("./frontend/sucesso_reserva.jsp").forward(request, response);
		
	}

}
