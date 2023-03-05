package theSpoon.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import theSpoon.model.beans.AreaGeografica;
import theSpoon.model.beans.Cliente;
import theSpoon.model.beans.Morada;
import thsSpoon.model.database.DBConnection;

public class ClienteDAO implements DAO<Cliente> {

	private static Connection connection = DBConnection.connection;

	@Override
	public boolean create(Cliente t) {
		System.out.println("ClienteDAO -> Start create");

		try {
			connection.setAutoCommit(false);

			try (Statement stmt = connection.createStatement()) {
				String insertUtilizador = "INSERT INTO utilizador (nif, nomeProprio, apelido, idade) VALUES ("
						+ t.getNif() + ",'" + t.getNomeProprio() + "','" + t.getApelido() + "'," + t.getIdade() + ");";

				System.out.println("-> Instrução SQL: " + insertUtilizador);
				stmt.executeUpdate(insertUtilizador);

				String insertCliente = "INSERT INTO cliente (nif, dataUltimaVisita, codigoMorada, codigoArea, zonaArea) VALUES ("
						+ t.getNif() + "," + ((t.getDataUltimaVisita() == null) ? "NULL" : t.getDataUltimaVisita())
						+ "," + t.getMorada().getCodigo() + "," + t.getMorada().getAreaGeografica().getCodigoPostal()
						+ "," + t.getMorada().getAreaGeografica().getZonaPostal() + ");";

				System.out.println("-> Instrução SQL: " + insertCliente);
				stmt.executeUpdate(insertCliente);

				connection.commit();
				System.out.println("Commited");
				return true;
			} catch (SQLException e) {
				connection.rollback();
				System.out.println(e.getMessage());
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(Cliente t) {
		System.out.println("ClienteDAO -> Start update");

		try {
			connection.setAutoCommit(false);

			try (Statement stmt = connection.createStatement()) {
				String updateUtilizador = "UPDATE utilizador SET " + "nomeProprio ='" + t.getNomeProprio()
						+ "', apelido = '" + t.getApelido() + "', idade =" + t.getIdade() + " WHERE nif = " + t.getNif()
						+ ";";

				System.out.println("-> Instrução SQL: " + updateUtilizador);
				stmt.executeUpdate(updateUtilizador);

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				String updateCliente = "UPDATE cliente SET " + "dataUltimaVisita ='"
						+ ((t.getDataUltimaVisita() == null) ? "NULL" : sdf.format(t.getDataUltimaVisita()))
						+ "', codigoMorada = " + t.getMorada().getCodigo() + ", codigoArea ="
						+ t.getMorada().getAreaGeografica().getCodigoPostal() + ", zonaArea ="
						+ t.getMorada().getAreaGeografica().getZonaPostal() + " WHERE nif = " + t.getNif() + ";";

				System.out.println("-> Instrução SQL: " + updateCliente);
				stmt.executeUpdate(updateCliente);

				connection.commit();
				System.out.println("Commited");
				return true;
			} catch (SQLException e) {
				connection.rollback();
				System.out.println(e.getMessage());
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public Cliente get(int id) {
		System.out.println("ClienteDAO -> Start get");
		Cliente cliente = null;
		
		try {

			try (Statement stmt = connection.createStatement()) {
				String getUtilizador = "SELECT c.numero as numero, u.nif as nif, u.nomeProprio as nomeProprio, u.apelido as apelido, u.idade as idade, c.dataUltimaVisita as dataUltimaVisita, c.codigoMorada as codigoMorada, m.designacao as designacaoMorada, c.codigoArea as codigoPostal, c.zonaArea as zonaPostal, a.freguesia as freguesia, a.concelho as concelho, a.distrito as distrito "
										+ "FROM utilizador as u  "
											+ "inner join cliente as c on c.nif = u.nif  "
											+ "inner join morada as m on m.codigo = c.codigoMorada "
											+ "inner join area_geografica as a on c.codigoArea = a.codigoPostal and c.zonaArea = a.zonaPostal "
										+ "WHERE u.nif=" + id + ";";

				System.out.println("-> Instrução SQL: " + getUtilizador);
				ResultSet result = stmt.executeQuery(getUtilizador);

				
				while (result.next()) {
					cliente = new Cliente(
							result.getInt("numero"), 
							result.getInt("nif"), 
							result.getString("nomeProprio"), 
							result.getString("apelido"), 
							result.getInt("idade"), 
							((result.getDate("dataUltimaVisita") == null) ? null: new Date(result.getDate("dataUltimaVisita").getDate())),
							new Morada(
									new AreaGeografica(
											result.getInt("codigoPostal"), 
											result.getInt("zonaPostal"), 
											result.getString("freguesia"), 
											result.getString("concelho"), 
											result.getString("distrito")),
									result.getString("designacaoMorada"))
						);
				}
				System.out.println("Commited");
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}finally {
			return cliente;
		}
	}

	@Override
	public boolean delete(int id) {
		System.out.println("ClienteDAO -> Start delete");

		try {
			connection.setAutoCommit(false);

			try (Statement stmt = connection.createStatement()) {
				String deleteCliente = "DELETE FROM cliente WHERE nif="+ id + ";";

				System.out.println("-> Instrução SQL: " + deleteCliente);
				stmt.executeUpdate(deleteCliente);
				
				String deleteUtilizador = "DELETE FROM utilizador WHERE nif="+ id + ";";

				System.out.println("-> Instrução SQL: " + deleteUtilizador);
				stmt.executeUpdate(deleteUtilizador);

				connection.commit();
				System.out.println("Commited");
				return true;
			} catch (SQLException e) {
				connection.rollback();
				System.out.println(e.getMessage());
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	@Override
	public ArrayList<Cliente> listAll() {
		System.out.println("ClienteDAO -> Start get");
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		try {

			try (Statement stmt = connection.createStatement()) {
				String getUtilizador = "SELECT c.numero as numero, u.nif as nif, u.nomeProprio as nomeProprio, u.apelido as apelido, u.idade as idade, c.dataUltimaVisita as dataUltimaVisita, c.codigoMorada as codigoMorada, m.designacao as designacaoMorada, c.codigoArea as codigoPostal, c.zonaArea as zonaPostal, a.freguesia as freguesia, a.concelho as concelho, a.distrito as distrito "
										+ "FROM utilizador as u  "
											+ "inner join cliente as c on c.nif = u.nif  "
											+ "inner join morada as m on m.codigo = c.codigoMorada "
											+ "inner join area_geografica as a on c.codigoArea = a.codigoPostal and c.zonaArea = a.zonaPostal";

				System.out.println("-> Instrução SQL: " + getUtilizador);
				ResultSet result = stmt.executeQuery(getUtilizador);

				Cliente cliente = null; 
				while (result.next()) {
					cliente = new Cliente(
							result.getInt("numero"), 
							result.getInt("nif"), 
							result.getString("nomeProprio"), 
							result.getString("apelido"), 
							result.getInt("idade"), 
							((result.getDate("dataUltimaVisita") == null) ? null: new Date(result.getDate("dataUltimaVisita").getDate())),
							new Morada(
									new AreaGeografica(
											result.getInt("codigoPostal"), 
											result.getInt("zonaPostal"), 
											result.getString("freguesia"), 
											result.getString("concelho"), 
											result.getString("distrito")),
									result.getString("designacaoMorada"))
						);
					clientes.add(cliente);
				}
				System.out.println("Commited");
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}finally {
			return clientes;
		}
	}


	public static void main(String[] args) {
		AreaGeografica areaGeografica = new AreaGeografica(2615, 359, "Alverca do Ribatejo", "Vila Franca de Xira",
				"Lisboa");
		Morada morada = new Morada(23, areaGeografica, "Rua D. João I número 4");
		Cliente cliente = new Cliente(100, 234503025, "Ana", "Oliveira", 28, null, morada);

		ClienteDAO clienteDAO = new ClienteDAO();
		// clienteDAO.create(cliente);

		cliente.setApelido("Preto");
		cliente.setIdade(53);
		cliente.setDataUltimaVisita(new Date());

		//clienteDAO.update(cliente);
		
		//System.out.println(clienteDAO.get(159403057));
		
		//System.out.println(clienteDAO.delete(234503025));
		
		ArrayList<Cliente> clientes_2 = clienteDAO.listAll();
		System.out.println(clientes_2);
		for (int i = 0; i < clientes_2.size() ; i++) {
			System.out.println(clientes_2.get(i));
		}
	}

}
