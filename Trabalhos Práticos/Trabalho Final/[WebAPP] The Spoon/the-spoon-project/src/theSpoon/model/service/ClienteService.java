package theSpoon.model.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import theSpoon.model.dao.AreaGeograficaDAO;
import theSpoon.model.dao.ClienteDAO;
import theSpoon.model.dao.MoradaDAO;
import theSpoon.model.entities.AreaGeografica;
import theSpoon.model.entities.Cliente;
import theSpoon.model.entities.Morada;
import theSpoon.model.entities.Reserva;
import theSpoon.model.entities.Utilizador;

public class ClienteService {

	private ClienteDAO clienteDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public ClienteService(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.clienteDAO = new ClienteDAO();
	}

	public void checkLogIn() {

		int nif = Integer.parseInt(request.getParameter("nif"));
		String tipo = request.getParameter("tipo");

		Cliente cliente = clienteDAO.getClienteFromNIF(nif);

		if (cliente == null) {
			try {
				response.sendRedirect("./registar.jsp");
			} catch (IOException e) {
				System.out.println("Erro ao reencaminhar para p�gina registar.jsp");
			}
		} else {
			HttpSession session = request.getSession(true);

			session.setAttribute("tipo", tipo);
			session.setAttribute("user", cliente);
			try {
				response.sendRedirect("./ListarRestaurantesServlet");
			} catch (IOException e) {
				System.out.println("Erro ao reencaminhar para p�gina cliente.jsp");
			}
		}
	}

	public void editarPerfil(Utilizador user) {
		try {

			Cliente cliente = clienteDAO.getClienteFromNIF(user.getNif());

			MoradaService moradaService = new MoradaService(request, response);

			Morada morada = moradaService.getMoradaFromCliente(cliente);
			AreaGeografica areaGeografica = moradaService.getAreaGeograficaFromMorada(morada);

			request.setAttribute("morada", morada);
			request.setAttribute("area", areaGeografica);
			request.getRequestDispatcher("./frontend/editarPerfil.jsp").forward(request, response);

		} catch (ServletException | IOException e) {
			System.out.println("Erro a abrir perfil do utilizador");
			e.printStackTrace();
		}
	}

	public void atualizarPerfil() {
		try {
			// Validar se existe AreaGeografica
			int codigoPostal = Integer.parseInt(request.getParameter("codigoPostal"));
			String zonaPostal = request.getParameter("zonaPostal");

			String freguesia = request.getParameter("freguesia");
			String concelho = request.getParameter("concelho");
			String distrito = request.getParameter("distrito");

			AreaGeograficaDAO areaGeograficaDAO = new AreaGeograficaDAO();

			AreaGeografica areaGeografica = areaGeograficaDAO.getAreaGeograficaByCodigoPostal(codigoPostal, zonaPostal);

			if (areaGeografica == null) {
				areaGeografica = new AreaGeografica(codigoPostal, zonaPostal, freguesia, concelho, distrito);
				areaGeografica = areaGeograficaDAO.create(areaGeografica);
			}

			// Validar se existe Morada
			String designacao = request.getParameter("morada");
			MoradaDAO moradaDAO = new MoradaDAO();
			Morada morada = moradaDAO.getMoradaFromDesignacao(designacao);

			if (morada == null) {
				morada = new Morada(areaGeografica.getCodigoPostal(), areaGeografica.getZonaPostal(), designacao);
				morada = moradaDAO.create(morada);
			}

			// Atualizar User
			int nif = Integer.parseInt(request.getParameter("nif"));
			String nomeProprio = request.getParameter("nomeProprio");
			String apelido = request.getParameter("apelido");
			int idade = Integer.parseInt(request.getParameter("idade"));

			ClienteDAO clienteDAO = new ClienteDAO();
			Cliente cliente = clienteDAO.getClienteFromNIF(nif);

			cliente.setNomeProprio(nomeProprio);
			cliente.setApelido(apelido);
			cliente.setIdade(idade);
			cliente.setCodigoMorada(morada.getCodigo());
			cliente.setCodigoArea(morada.getCodigoPostal());
			cliente.setZonaArea(morada.getZonaPostal());

			cliente = clienteDAO.update(cliente);

			HttpSession session = request.getSession();
			session.setAttribute("user", cliente);
			
			request.setAttribute("morada", morada);
			request.setAttribute("area", areaGeografica);

			request.setAttribute("sucesso", true);

			request.getRequestDispatcher("./frontend/editarPerfil.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println(e.getMessage());
		} 
	}

	public Cliente getClienteFromUtilizador(Utilizador user) {
		Cliente cliente = this.clienteDAO.getClienteFromUtilizador(user); 
		return cliente;
	}

	public Cliente getClienteFromReserva(Reserva reserva) {
		return this.clienteDAO.getClienteFromReserva(reserva);
	}

}
