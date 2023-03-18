package theSpoon.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import theSpoon.model.entities.Cliente;
import thsSpoon.model.database.DBConnection;

public class ClienteDAO implements DAO<Cliente> {

	private static Connection connection = DBConnection.connection;

	@Override
	public Cliente create(Cliente entity) {

		System.out.println("ClienteDAO -> Start create");

		try {
			connection.setAutoCommit(false);

			String insertUtilizador = "insert into utilizador (nif, nomeProprio, apelido, idade) values (?, ?, ?, ?);";

			PreparedStatement preparedStatement = connection.prepareStatement(insertUtilizador);

			preparedStatement.setInt(1, entity.getNif());
			preparedStatement.setString(2, entity.getNomeProprio());
			preparedStatement.setString(3, entity.getApelido());
			preparedStatement.setInt(4, entity.getIdade());

			System.out.println(preparedStatement.toString());
			int result = preparedStatement.executeUpdate();

			if (result == 1) {
				try {
					String insertCliente;
					if(entity.getDataUltimaVisita() != null) {
						insertCliente = "insert into cliente (nif, dataUltimaVisita, codigoMorada, codigoArea, zonaArea) values (?, ?, ?, ?, ?);";
	
						preparedStatement = connection.prepareStatement(insertCliente);
	
						preparedStatement.setInt(1, entity.getNif());
						preparedStatement.setObject(2, entity.getDataUltimaVisita());
						preparedStatement.setInt(3, entity.getCodigoMorada());
						preparedStatement.setInt(4, entity.getCodigoArea());
						preparedStatement.setString(5, entity.getZonaArea());
					
					}else {
						insertCliente = "insert into cliente (nif, codigoMorada, codigoArea, zonaArea) values (?, ?, ?, ?);";
						
						preparedStatement = connection.prepareStatement(insertCliente);
	
						preparedStatement.setInt(1, entity.getNif());
						preparedStatement.setInt(2, entity.getCodigoMorada());
						preparedStatement.setInt(3, entity.getCodigoArea());
						preparedStatement.setString(4, entity.getZonaArea());
					}

					System.out.println(preparedStatement.toString());
					result = preparedStatement.executeUpdate();

					if(result == 1) {
						entity = get(entity);
						connection.commit();

						System.out.println("Commited");
						return entity;
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}return null;

		} catch (SQLException e) {
			try {
				connection.rollback();
				connection.setAutoCommit(true);
			} catch (SQLException ex) {
				ex.printStackTrace();
				return null;
			}
			System.out.println(e.getMessage());
			return null;
		}

	}

	@Override
	public Cliente update(Cliente entity) {

		System.out.println("ClienteDAO -> Start update");

		try {
			connection.setAutoCommit(false);

			try {
				String updateUtilizador = "update utilizador set nomeProprio=?, apelido=?, idade=? where nif=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(updateUtilizador);

				preparedStatement.setString(1, entity.getNomeProprio());
				preparedStatement.setString(2, entity.getApelido());
				preparedStatement.setInt(3, entity.getIdade());
				preparedStatement.setInt(4, entity.getNif());

				System.out.println(preparedStatement.toString());
				int result = preparedStatement.executeUpdate();

				if (result == 1) {
					try {
						String updateCliente;
						if(entity.getDataUltimaVisita() != null) {
							updateCliente = "update cliente set dataUltimaVisita=?, codigoMorada=?, codigoArea=?, zonaArea=? where numero=?";
		
							preparedStatement = connection.prepareStatement(updateCliente);
		
							preparedStatement.setObject(1, entity.getDataUltimaVisita());
							preparedStatement.setInt(2, entity.getCodigoMorada());
							preparedStatement.setInt(3, entity.getCodigoArea());
							preparedStatement.setString(4, entity.getZonaArea());
							preparedStatement.setInt(5, entity.getNumero());
						
						}else {
							updateCliente = "update cliente set codigoMorada=?, codigoArea=?, zonaArea=? where numero=?";
							
							preparedStatement = connection.prepareStatement(updateCliente);
		
							preparedStatement.setInt(1, entity.getCodigoMorada());
							preparedStatement.setInt(2, entity.getCodigoArea());
							preparedStatement.setString(3, entity.getZonaArea());
							preparedStatement.setInt(4, entity.getNumero());
						}

						System.out.println(preparedStatement.toString());
						result = preparedStatement.executeUpdate();

						connection.commit();
						connection.setAutoCommit(true);
						System.out.println("Commited");
						
						return result == 1 ? entity : null;
						
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
				}return null;
			} catch (SQLException e) {
				connection.rollback();
				connection.setAutoCommit(true);
				System.out.println(e.getMessage());
				return null;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	@Override
	public Cliente get(Cliente entity) {

		System.out.println("ClienteDAO -> Start get");
		Cliente cliente = null;

		try {

			try {
				String getCliente = "select c.numero as numero, u.nif as nif, u.nomeProprio as nomeProprio, u.apelido as apelido, "
						+ "u.idade as idade, c.dataUltimaVisita as dataUltimaVisita, c.codigoMorada as codigoMorada, c.codigoArea as codigoArea, "
						+ "c.zonaArea as zonaArea from utilizador as u inner join cliente as c on c.nif = u.nif where u.nif=?; ";

				PreparedStatement preparedStatement = connection.prepareStatement(getCliente);

				preparedStatement.setInt(1, entity.getNif());

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					cliente = new Cliente(result.getInt("nif"), result.getString("nomeProprio"),
							result.getString("apelido"), result.getInt("idade"), result.getInt("numero"),
							result.getInt("codigoMorada"), result.getInt("codigoArea"), result.getString("zonaArea"));

				}
				System.out.println("Commited");
				return cliente;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return cliente;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return cliente;
		}

	}

	@Override
	public boolean delete(Cliente entity) {

		System.out.println("ClienteDAO -> Start delete");

		try {
			connection.setAutoCommit(false);

			try {
				String deleteCliente = "delete from cliente where numero=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(deleteCliente);

				preparedStatement.setInt(1, entity.getNumero());

				System.out.println(preparedStatement.toString());
				int result = preparedStatement.executeUpdate();

				if (result == 1) {
					String deleteUtilizador = "delete from utilizador where nif=?;";

					preparedStatement = connection.prepareStatement(deleteUtilizador);

					preparedStatement.setInt(1, entity.getNif());

					System.out.println(preparedStatement.toString());
					result = preparedStatement.executeUpdate();
					

					connection.commit();
					connection.setAutoCommit(true);
					System.out.println("Commited");
					
					return (result == 1 ? true : false);
				}return false;
				
			} catch (SQLException e) {
				connection.rollback();
				connection.setAutoCommit(true);
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

		System.out.println("ClienteDAO -> Start listAll");
		ArrayList<Cliente> clientes = new ArrayList<>();

		try {

			try {
				String getMorada = "select c.numero as numero, u.nif as nif, u.nomeProprio as nomeProprio, u.apelido as apelido, "
						+ "u.idade as idade, c.dataUltimaVisita as dataUltimaVisita, c.codigoMorada as codigoMorada, c.codigoArea as codigoArea,"
						+ "c.zonaArea as zonaArea from utilizador as u inner join cliente as c on c.nif = u.nif;";

				PreparedStatement preparedStatement = connection.prepareStatement(getMorada);

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				Cliente cliente = null;
				while (result.next()) {
					cliente = new Cliente(result.getInt("nif"), result.getString("nomeProprio"),
							result.getString("apelido"), result.getInt("idade"), result.getInt("numero"),
							result.getInt("codigoMorada"), result.getInt("codigoArea"), result.getString("zonaArea"));
					clientes.add(cliente);
				}
				System.out.println("Commited");
				return clientes;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return clientes;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return clientes;
		}

	}

	public static void main(String[] args) {

		Cliente cliente = new Cliente(234503025, "Ana", "Oliveira", 28, 100, null, 23, 2615, "359");

		ClienteDAO clienteDAO = new ClienteDAO();
		System.out.println("Create cliente: " + clienteDAO.create(cliente));

		cliente.setApelido("Preto");
		cliente.setIdade(53);
		cliente.setDataUltimaVisita(new Date());
		System.out.println("Update cliente: " + clienteDAO.update(cliente));
		

		System.out.println("Get cliente: " + clienteDAO.get(cliente));
		

		ArrayList<Cliente> clientes_2 = clienteDAO.listAll();
		System.out.println(clientes_2);
		for (int i = 0; i < clientes_2.size(); i++) {
			System.out.println(clientes_2.get(i));
		}
		
		System.out.println("Delete cliente: " + clienteDAO.get(cliente));
	}

}
