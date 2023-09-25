package theSpoon.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import theSpoon.model.entities.Cliente;
import theSpoon.model.entities.Item;
import theSpoon.model.entities.Reserva;
import theSpoon.model.service.ClienteService;
import theSpoon.model.service.ReservaService;

/**
 * Servlet implementation class ObterReservasHoje
 */
@WebServlet("/ObterReservasHoje")
public class ObterReservasHoje extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ObterReservasHoje() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codigoRestaurante = Integer.parseInt(request.getParameter("codigoRestaurante"));
		
		ReservaService reservaService = new ReservaService(request, response); 
		ArrayList<Reserva> reservas = reservaService.getReservasHoje(codigoRestaurante); 
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ArrayList<Object> itens = new ArrayList<Object>();
		
		ClienteService clienteService = new ClienteService(request, response);
		Cliente cliente = null;		
		for (Reserva reserva: reservas) {
			
			cliente = clienteService.getClienteFromReserva(reserva);
			clientes.add(cliente);
			
			itens.add(reservaService.getItensReservados(reserva));		
			
		}
		
		Map<String, Object> resposta = new HashMap<String, Object>();

		/*request.setAttribute("reservas", reservas);
		request.setAttribute("clientes", clientes);
		request.setAttribute("itens", itens);*/
		
		resposta.put("reservas", reservas);
		resposta.put("clientes", clientes);
		resposta.put("itens", itens);
		
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter(); 
		out.print(new Gson().toJson(resposta));
				
	}

}
