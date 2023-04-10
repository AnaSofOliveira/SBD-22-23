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

import com.google.gson.Gson;

import theSpoon.model.dao.EmentaDAO;
import theSpoon.model.dao.ItemDAO;
import theSpoon.model.dao.RestauranteDAO;
import theSpoon.model.entities.Ementa;
import theSpoon.model.entities.Item;
import theSpoon.model.entities.Recurso;
import theSpoon.model.entities.Restaurante;

public class ItensService {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private ItemDAO itemDAO;

	public ItensService(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.itemDAO = new ItemDAO();
	}

	public void obterItensServidos() {

		int codigoRestaurante = Integer.parseInt(request.getParameter("codigoRestaurante"));
		String data = request.getParameter("dataReserva");
		System.out.println(data);
		Restaurante restautante = new RestauranteDAO().getRestauranteFromCodigo(codigoRestaurante);

		try {
			
			Instant instant = Instant.parse(data); 
						
			Date dataReserva = Date.from(instant);
			
			String diaSemana = new SimpleDateFormat("E").format(dataReserva);
			String time = new SimpleDateFormat("HH:mm").format(dataReserva);

			System.out.println("Data Reserva: " + diaSemana + " at time: " + time);

			Ementa ementa = new EmentaDAO().getEmentaInTime(restautante, diaSemana, time);

			System.out.println("Ementa: " + ementa);

			ArrayList<Item> itens = itemDAO.getItensFromEmenta(ementa);

			
			ArrayList<Recurso> recursos = new ArrayList<>();
			for (Item item : itens) {
				recursos.add(itemDAO.getRecursoFromItem(item));
			}
			
			Map<String, Object> itensServidos = new HashMap<String, Object>();
			request.setAttribute("itens", itens);
			request.setAttribute("recursos", recursos);
			
			itensServidos.put("itens", itens);
			itensServidos.put("recursos", recursos);
			
			response.setContentType("application/json");
			
			PrintWriter out = response.getWriter(); 
			out.print(new Gson().toJson(itensServidos));
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
