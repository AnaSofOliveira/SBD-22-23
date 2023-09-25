package theSpoon.model.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import theSpoon.model.dao.AreaGeograficaDAO;
import theSpoon.model.dao.FuncionarioDAO;
import theSpoon.model.dao.MoradaDAO;
import theSpoon.model.entities.AreaGeografica;
import theSpoon.model.entities.Cliente;
import theSpoon.model.entities.Morada;
import theSpoon.model.entities.Restaurante;
import theSpoon.model.entities.Utilizador;

public class MoradaService {
	
	private MoradaDAO moradaDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public MoradaService(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.moradaDAO = new MoradaDAO();
	}

	public Morada getMoradaFromCliente(Cliente cliente) {
		Morada morada = new MoradaDAO().getMoradaFromCliente(cliente); 
		return morada; 
	}

	public AreaGeografica getAreaGeograficaFromMorada(Morada morada) {
		AreaGeografica areaGeografica = new AreaGeograficaDAO().getAreaGeograficaByCodigoPostal(morada.getCodigoPostal(), morada.getZonaPostal()); 
		return areaGeografica;
	}

	public Morada getMoradaFromRestaurante(Restaurante restaurante) {
		Morada morada = this.moradaDAO.getMoradaFromRestaurante(restaurante); 
		return morada;
	}
	
	
	

}
