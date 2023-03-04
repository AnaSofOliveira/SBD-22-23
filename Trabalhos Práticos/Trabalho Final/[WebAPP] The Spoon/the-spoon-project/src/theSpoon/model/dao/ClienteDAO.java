package theSpoon.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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

			String insertUtlizadorQuery = "INSERT INTO utilizador (nif, nomeProprio, apelido, idade) VALUES (?, ?, ?, ?);";
			PreparedStatement preparedStatement = connection.prepareStatement(insertUtlizadorQuery);

			preparedStatement.setInt(1, t.getNif());
			preparedStatement.setString(2, t.getNomeProprio());
			preparedStatement.setString(3, t.getApelido());
			preparedStatement.setInt(4, t.getIdade());

			int result = preparedStatement.executeUpdate();
			System.out.println("Primeiro resultado: " + result);

			if (result == 1) {
				System.out.println("ClienteDAO -> Create Cliente -> Adicionado utilizador");
				if (t.getDataUltimaVisita() != null) {
					String insertClienteQuery = "INSERT INTO cliente (nif, dataUltimaVisita, codigoMorada, codigoArea, zonaArea) VALUES (?, ?, ?, ?, ?);";
					preparedStatement = connection.prepareStatement(insertClienteQuery);

					preparedStatement.setInt(1, t.getNif());
					preparedStatement.setDate(2, new Date(t.getDataUltimaVisita().getTime()));
					preparedStatement.setInt(3, t.getMorada().getCodigo());
					preparedStatement.setInt(4, t.getMorada().getAreaGeografica().getCodigoPostal());
					preparedStatement.setInt(5, t.getMorada().getAreaGeografica().getZonaPostal());
				} else {
					String insertClienteQuery = "INSERT INTO cliente (nif, codigoMorada, codigoArea, zonaArea) VALUES (?, ?, ?, ?);";
					preparedStatement = connection.prepareStatement(insertClienteQuery);

					preparedStatement.setInt(1, t.getNif());
					preparedStatement.setInt(2, t.getMorada().getCodigo());
					preparedStatement.setInt(3, t.getMorada().getAreaGeografica().getCodigoPostal());
					preparedStatement.setInt(4, t.getMorada().getAreaGeografica().getZonaPostal());
				}

				result = preparedStatement.executeUpdate();
				System.out.println("Segundo resultado: " + result);

				if (result == 1) {
					connection.commit();
				}
			}

			return (result==1) ? true : false;

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Erro na criação do cliente: " + e1.getMessage());
				e1.printStackTrace();
			}
			System.out.println("Erro na criação do cliente: " + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(Cliente t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cliente get(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Object id) {
		// TODO Auto-generated method stub
		return false;

	}

	@Override
	public List<Cliente> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {
		AreaGeografica areaGeografica = new AreaGeografica(2615, 359, "Alverca do Ribatejo", "Vila Franca de Xira",
				"Lisboa");
		Morada morada = new Morada(23, areaGeografica, "Rua D. João I número 4");
		Cliente cliente = new Cliente(234503025, "Ana", "Oliveira", 28, null, morada);

		new ClienteDAO().create(cliente);

	}

}
