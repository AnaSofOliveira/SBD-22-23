package theSpoon.model.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import theSpoon.model.dao.ClienteDAO;
import theSpoon.model.dao.FuncionarioDAO;
import theSpoon.model.dao.UtilizadorDAO;
import theSpoon.model.entities.Cliente;
import theSpoon.model.entities.Funcionario;
import theSpoon.model.entities.Utilizador;

public class UtilizadorService {

	private ClienteDAO clienteDAO;
	private FuncionarioDAO funcionarioDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public UtilizadorService(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.clienteDAO = new ClienteDAO();
		this.funcionarioDAO = new FuncionarioDAO();
		this.request = request;
		this.response = response;
	}

	public Utilizador logIn() {
			  
	  	int nif = Integer.parseInt(request.getParameter("nif"));
		String tipo = request.getParameter("tipo"); 
		
		UtilizadorDAO utilizadorDAO = new UtilizadorDAO(); 
		Utilizador utilizador = new Utilizador(nif, "", "", 0); 
		utilizador = utilizadorDAO.get(utilizador);
		
		if(utilizador != null && tipo.equals("cliente")){
			
			ClienteDAO clienteDAO = new ClienteDAO(); 
			Cliente cliente = clienteDAO.getClienteFromUtilizador(utilizador);
			
			return cliente;
		}else if(utilizador != null && tipo.equals("funcionario")){
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO(); 
			Funcionario funcionario = funcionarioDAO.getFuncionarioFromUtilizador(utilizador);
			
			return funcionario;
		}
		
		return null; 			
		
	  }

}
