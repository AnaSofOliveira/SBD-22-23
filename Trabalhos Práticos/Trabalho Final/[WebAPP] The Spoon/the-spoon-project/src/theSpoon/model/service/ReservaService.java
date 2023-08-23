package theSpoon.model.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import theSpoon.model.entities.Caracteristica;
import theSpoon.model.entities.Cliente;
import theSpoon.model.entities.Item;
import theSpoon.model.entities.Reserva;

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

			request.setAttribute("restaurante", request.getParameter("codigo"));
			request.setAttribute("dataAtual", new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss").format(new Date()));
			request.getRequestDispatcher("frontend/reserva.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void realizarReserva() {

		HttpSession session = this.request.getSession();
		Cliente cliente = (Cliente) session.getAttribute("user");

		int codigoRestaurante = Integer.parseInt(this.request.getParameter("codigoRestaurante"));
		String numeroPessoas = this.request.getParameter("numeroPessoas");
		String dataHoraMarcacao = this.request.getParameter("dataHoraMarcacao");
		String[] escolherItensEmenta = this.request.getParameterValues("escolherItensEmenta[]");
		String[] listaItens = this.request.getParameterValues("listaItens[]");
		String[] quantItens = this.request.getParameterValues("quantItens[]");
		String[] escolherCaracteristicas = this.request.getParameterValues("escolherCaracteristicas[]");
		String[] listaCaracteristicas = this.request.getParameterValues("listaCaracteristicas[]");
		String dataHoraReserva = this.request.getParameter("dataHoraReserva");

		System.out.println("All data: " + cliente + " " + codigoRestaurante + " " + numeroPessoas + " "
				+ dataHoraMarcacao + " " + escolherItensEmenta + " " + listaItens + " " + quantItens + " "
				+ escolherCaracteristicas + " " + listaCaracteristicas);

		// ReservaDAO reservaDAO = new ReservaDAO();

		Map<Item, Integer> itensEscolhidos = new HashMap<Item, Integer>();
		ItemDAO itemDAO = new ItemDAO();
		Item item = null;
		boolean haItens = false;

		if (escolherItensEmenta != null) {
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

		if (escolherCaracteristicas != null && listaCaracteristicas != null) {
			for (String car : listaCaracteristicas) {
				int numeroCaracteristica = Integer.parseInt(car);
				caracteristica = caracteristicaDAO.getCaracteristicaFromNumero(numeroCaracteristica);
				caracteristicasEscolhidas.add(caracteristica);
			}
			haCaracteristicas = true;
		}

		Instant instant = Instant.parse(dataHoraMarcacao);

		Date dataReserva = Date.from(instant);

		PrintWriter out;
		JsonObject json = new JsonObject();

		// String dataReserva = new SimpleDateFormat("yyy-MM-dd HH:mm").format(data);
		try {

			Reserva reserva = new Reserva(codigoRestaurante, dataReserva, cliente.getNumero(),
					Integer.parseInt(numeroPessoas), new Date());
			reserva = reservaDAO.create(reserva);

			if (haItens) {
				reservaDAO.addItensReserva(reserva, itensEscolhidos);
			}
			if (haCaracteristicas) {
				reservaDAO.addCaracteristicasReserva(reserva, caracteristicasEscolhidas);
			}

		} catch (NumberFormatException e) {
			try {
				this.response.sendError(400, "Erro ao realizar reserva");
			} catch (IOException e1) {
				System.out.println(e.getMessage());
			}
		}

	}

}
