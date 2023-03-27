package theSpoon.controller.restaurante;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import theSpoon.model.service.ClienteService;
import theSpoon.model.service.FuncionarioService;

/**
 * Servlet implementation class AbrirPerfil
 */
@WebServlet("/AbrirPerfilServlet")
public class AbrirPerfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AbrirPerfilServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(); 
		String tipo = (String) session.getAttribute("tipo");

		if ("cliente".equals(tipo)) {
			new ClienteService(request, response).abrirPerfil();

		} else if ("funcionario".equals(tipo)) {
			new FuncionarioService(request, response).abrirPerfil();
		} else {
			request.getRequestDispatcher("./registar.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
