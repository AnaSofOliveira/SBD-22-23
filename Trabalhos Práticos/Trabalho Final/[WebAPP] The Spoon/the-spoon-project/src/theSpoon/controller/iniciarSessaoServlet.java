package theSpoon.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import theSpoon.model.dao.ClienteDAO;
import theSpoon.model.dao.FuncionarioDAO;
import theSpoon.model.dao.UtilizadorDAO;
import theSpoon.model.entities.Cliente;
import theSpoon.model.entities.Funcionario;
import theSpoon.model.entities.Utilizador;
import theSpoon.model.service.ClienteService;
import theSpoon.model.service.FuncionarioService;
import theSpoon.model.service.UtilizadorService;

/**
 * Servlet implementation class iniciarSessaoServlet
 */
@WebServlet("/iniciarSessaoServlet")
public class iniciarSessaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public iniciarSessaoServlet() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String tipo = request.getParameter("tipo"); 
		
		if("cliente".equals(tipo)) {
			ClienteService clienteService = new ClienteService(request, response); 
			clienteService.checkLogIn(); 
		}else if("funcionario".equals(tipo)) {
			FuncionarioService funcionarioService = new FuncionarioService(request, response); 
			funcionarioService.checkLogIn(); 
		}else {
			response.sendRedirect("./registar.jsp");
		}	
	}

}
