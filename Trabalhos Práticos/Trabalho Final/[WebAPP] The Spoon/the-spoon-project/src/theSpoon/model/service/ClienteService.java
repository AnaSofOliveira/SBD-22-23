package theSpoon.model.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import theSpoon.model.dao.ClienteDAO;
import theSpoon.model.dao.FuncionarioDAO;
import theSpoon.model.entities.Cliente;

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
		
		if(cliente == null) {
			try {
				response.sendRedirect("./registar.jsp");
			} catch (IOException e) {
				System.out.println("Erro ao reencaminhar para página registar.jsp");
			}
		}else {
			HttpSession session = request.getSession(true); 
			
			session.setAttribute("tipo", tipo);
			session.setAttribute("user", cliente);
			try {
				response.sendRedirect("./frontend/homePage.jsp");
			} catch (IOException e) {
				System.out.println("Erro ao reencaminhar para página cliente.jsp");
			}
		}
	}

	public void abrirPerfil() {
		try {
			request.getRequestDispatcher("./frontend/perfil.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println("Erro a abrir perfil do utilizador");
			e.printStackTrace();
		} 
	}
	
	

}
