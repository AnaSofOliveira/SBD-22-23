package theSpoon.model.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import theSpoon.model.dao.CaracteristicaDAO;
import theSpoon.model.dao.ItemDAO;
import theSpoon.model.dao.ReservaDAO;
import theSpoon.model.dao.RestauranteDAO;
import theSpoon.model.entities.Caracteristica;
import theSpoon.model.entities.Cliente;
import theSpoon.model.entities.Item;
import theSpoon.model.entities.Reserva;
import theSpoon.model.entities.Restaurante;
import theSpoon.model.entities.Utilizador;

public class ReservaService {

	private HttpServletRequest request;
	private HttpServletResponse response;
	ReservaDAO reservaDAO;

	public ReservaService(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.reservaDAO = new ReservaDAO();
	}

	public void iniciarReserva() {
		try {
						
			request.setAttribute("restaurante", request.getParameter("codigoRestaurante"));
			request.setAttribute("dataHoraMarcacao", request.getParameter("dataHoraMarcacao")); 
			request.setAttribute("pessoas", request.getParameter("numeroPessoas"));
			
			request.setAttribute("dataAtual", new Date().getTime());
			
			request.getRequestDispatcher("frontend/reserva.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void realizarReserva() {

		HttpSession session = this.request.getSession();
		Cliente cliente = (Cliente) session.getAttribute("user");

		int codigoRestaurante = Integer.parseInt(this.request.getParameter("codigoRestaurante"));
		String numeroPessoas = this.request.getParameter("numeroPessoas");
		Date dataHoraMarcacao =  new Date(Long.parseLong(this.request.getParameter("dataHoraMarcacao")));
		String[] listaItens = this.request.getParameterValues("listaItens[]");
		String[] quantItens = this.request.getParameterValues("quantItens[]");
		String[] listaCaracteristicas = this.request.getParameterValues("listaCaracteristicas[]");
		Date dataHoraReserva =  new Date(Long.parseLong(this.request.getParameter("dataHoraReserva")));
		
		
		String dataHoraMarcacao_formated = new SimpleDateFormat("EEE, yyyy-MM-dd HH:mm:ss").format(dataHoraMarcacao);
		String dataHoraReserva_formated = new SimpleDateFormat("EEE, yyyy-MM-dd HH:mm:ss").format(dataHoraReserva);


		System.out.println("All data: " + cliente + " " + codigoRestaurante + dataHoraMarcacao_formated + " " + dataHoraReserva_formated);
		
		//String diaSemana = formatted.split(",")[0];
		//diaSemana = Normalizer.normalize(diaSemana, Normalizer.Form.NFD);
		//diaSemana = diaSemana.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
	    
		//String hora = formatted.split(" ")[2];
	

		
		// ReservaDAO reservaDAO = new ReservaDAO();

		Map<Item, Integer> itensEscolhidos = new HashMap<Item, Integer>();
		ItemDAO itemDAO = new ItemDAO();
		Item item = null;
		boolean haItens = false;

		if (listaItens != null) {
			for (int i = 0; i < listaItens.length; i++) {
				int idItem = Integer.parseInt(listaItens[i]);
				int quantidade = Integer.parseInt(quantItens[i]);

				if (quantidade > 0) {
					item = itemDAO.getItemFromId(idItem);
					itensEscolhidos.put(item, quantidade);
					haItens = true;
				}
			}
		}

		ArrayList<Caracteristica> caracteristicasEscolhidas = new ArrayList<>();
		CaracteristicaDAO caracteristicaDAO = new CaracteristicaDAO();
		Caracteristica caracteristica = null;
		boolean haCaracteristicas = false;

		if (listaCaracteristicas != null) {
			for (String car : listaCaracteristicas) {
				int numeroCaracteristica = Integer.parseInt(car);
				caracteristica = caracteristicaDAO.getCaracteristicaFromNumero(numeroCaracteristica);
				caracteristicasEscolhidas.add(caracteristica);
			}
			haCaracteristicas = true;
		}

		try {

			Reserva reserva = new Reserva(codigoRestaurante, dataHoraMarcacao, cliente.getNumero(),
					Integer.parseInt(numeroPessoas), new Date());
			reserva = reservaDAO.create(reserva);

			if (haItens) {
				reservaDAO.addItensReserva(reserva, itensEscolhidos);
			}
			if (haCaracteristicas) {
				reservaDAO.addCaracteristicasReserva(reserva, caracteristicasEscolhidas);
			}
			
			//Retornar informação da reserva para ser apresentada na página de sucesso
			//Enviar informações: DataHoraMarcacao, Número de Pessoas, Itens reservados e quantidades e Caracteristicas reservadas
			
			Restaurante restaurante = new RestauranteDAO().getRestauranteFromCodigo(reserva.getCodigoRestaurante()); 
			
			String dataMarcacao = new SimpleDateFormat("dd-MM-yyyy").format(dataHoraMarcacao); 
			String horaMarcacao = new SimpleDateFormat("HH:mm").format(dataHoraMarcacao);
			
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("restaurante", restaurante); 
			data.put("reserva", reserva);
			/*data.put("pessoas", reserva.getNroPessoas()); 
			data.put("dataMarcacao", dataMarcacao); 
			data.put("horaMarcacao", horaMarcacao); 
			data.put("caracteristicas", caracteristicasEscolhidas); 
			data.put("itens", itensEscolhidos); */
			
			response.setContentType("application/json");
			
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print(new Gson().toJson(data));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

		} catch (NumberFormatException e) {
			try {
				this.response.sendError(400, "Erro ao realizar reserva");
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}
		}

	}

	public void validarHoraReserva() {

		HttpSession session = this.request.getSession();
		Cliente cliente = (Cliente) session.getAttribute("user");

		int codigoRestaurante = Integer.parseInt(this.request.getParameter("codigoRestaurante"));
		long dataHoraMarcacao = Long.parseLong(this.request.getParameter("dataHoraMarcacao"));

		Date date = new Date(dataHoraMarcacao);
		String formatted = new SimpleDateFormat("EEE, yyyy-MM-dd HH:mm").format(date);

		System.out.println("All data: " + cliente + " " + codigoRestaurante + dataHoraMarcacao + " " + formatted);
		
		String diaSemana = formatted.split(",")[0];
		diaSemana = Normalizer.normalize(diaSemana, Normalizer.Form.NFD);
		diaSemana = diaSemana.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
	    
		String hora = formatted.split(" ")[2];

		System.out.println("Marcação: " + diaSemana + " " + hora);

		boolean restauranteEstaAberto = new RestauranteDAO().checkIfOpenAtHour(codigoRestaurante, diaSemana, hora);
		
		System.out.println("Restaurante está Aberto: " + restauranteEstaAberto);
		
		try {
			this.response.setContentType("application/json");

			PrintWriter out = response.getWriter();
			out.print(new Gson().toJson(restauranteEstaAberto));

		} catch (IOException e) {
			System.out.println(e.getMessage());
			try {
				this.response.sendError(400, "Erro na resposta");
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}
		}
	}

	public Reserva getReserva() {
		
		int codigoReserva = Integer.parseInt(this.request.getParameter("codigoReserva"));
		
		Reserva reserva = new ReservaDAO().getReserva(codigoReserva); 
		
		return reserva;
	}

	public ArrayList<Item> getItensReservados(Reserva reserva) {
		
		ArrayList<Item> itensReservados = new ReservaDAO().getItensReservados(reserva);
		
		return itensReservados;
	}

	public ArrayList<Caracteristica> getCaracteristicasReservadas(Reserva reserva) {
		
		ArrayList<Caracteristica> caracteristicasReservadas = new ReservaDAO().getCaracteristicasReservadas(reserva); 
		
		return caracteristicasReservadas;
	}

	public ArrayList<Reserva> getReservasFromCliente(Cliente cliente) {
		ArrayList<Reserva> reservas = this.reservaDAO.getReservasFromCliente(cliente);
		return reservas;
	}

	public String validaEstadoReserva(Reserva reserva) {
		String estado = this.reservaDAO.getEstadoReserva(reserva);
		return estado;
	}

	public void deleteReserva() { 
		int numeroReserva = Integer.parseInt(this.request.getParameter("numeroReserva"));
		int codigoRestaurante = Integer.parseInt(this.request.getParameter("codigoRestaurante"));
		
		HttpSession session = request.getSession(); 
		Utilizador utilizador = (Utilizador) session.getAttribute("user");
		
		Cliente cliente = new ClienteService(request, response).getClienteFromUtilizador(utilizador);
		
		ReservaDAO reservaDAO = new ReservaDAO(); 
		Reserva reserva = new Reserva(numeroReserva, codigoRestaurante, cliente.getNumero());
		reservaDAO.delete(reserva);
		
	}

	public ArrayList<Reserva> getReservasHoje(int codigoRestaurante) {
		return this.reservaDAO.getReservasHoje(codigoRestaurante);
	}

}
