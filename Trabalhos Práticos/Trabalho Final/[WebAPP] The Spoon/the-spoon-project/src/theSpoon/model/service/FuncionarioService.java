package theSpoon.model.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import theSpoon.model.dao.ClienteDAO;
import theSpoon.model.dao.FuncionarioDAO;
import theSpoon.model.dao.RestauranteDAO;
import theSpoon.model.entities.Cliente;
import theSpoon.model.entities.Funcionario;
import theSpoon.model.entities.Recurso;
import theSpoon.model.entities.Restaurante;
import theSpoon.model.entities.Utilizador;

public class FuncionarioService {

	private FuncionarioDAO funcionarioDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public FuncionarioService(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.funcionarioDAO = new FuncionarioDAO();
	}

	public void checkLogIn() {

		int nif = Integer.parseInt(request.getParameter("nif"));
		String tipo = request.getParameter("tipo");

		Funcionario funcionario = funcionarioDAO.getFuncionarioFromNIF(nif);

		if (funcionario == null) {
			try {
				response.sendRedirect("./registar.jsp");
			} catch (IOException e) {
				System.out.println("Erro ao reencaminhar para p�gina registar.jsp");
			}
		} else {
			HttpSession session = request.getSession(true);

			session.setAttribute("tipo", tipo);
			session.setAttribute("user", funcionario);

			request.setAttribute("chefe", funcionario.getNumeroFuncionarioChefe());

			RestauranteDAO restauranteDAO = new RestauranteDAO();
			Restaurante restaurante = restauranteDAO.getRestauranteFromCodigo(funcionario.getCodigoRestaurante());

			try {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/RestauranteInfoServlet?codigo="+restaurante.getCodigo());
				dispatcher.forward(request, response);

			} catch (IOException | ServletException e) {
				System.out.println("Erro ao reencaminhar para página funcionario.jsp");
			}
		}
	}

	public void atualizarPerfil() {
		int nif = Integer.parseInt(request.getParameter("nif"));
		String nomeProprio = request.getParameter("nomeProprio");
		String apelido = request.getParameter("apelido");
		int idade = Integer.parseInt(request.getParameter("idade"));

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.getFuncionarioFromNIF(nif);

		funcionario.setNomeProprio(nomeProprio);
		funcionario.setApelido(apelido);
		funcionario.setIdade(idade);

		funcionario = new FuncionarioDAO().update(funcionario);

		HttpSession session = request.getSession();
		session.setAttribute("user", funcionario);

		request.setAttribute("sucesso", true);

		try {
			request.getRequestDispatcher("./AbrirPerfilServlet").forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println("Erro ao abrir perfil atualizado");
		}
	}

	public void editarPerfil(Utilizador user) {
		try {
			request.getRequestDispatcher("./admin/perfil.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println("Erro a abrir perfil do funcionario");
			e.printStackTrace();
		}
	}

}
