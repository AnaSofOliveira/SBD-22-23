package theSpoon.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import theSpoon.model.entities.Restaurante;
import thsSpoon.model.database.DBConnection;

public class RestauranteDAO implements DAO<Restaurante> {

	private static Connection connection = DBConnection.connection;

	@Override
	public Restaurante create(Restaurante entity) {

		System.out.println("RestauranteDAO -> Start create");

		try {
			connection.setAutoCommit(false);

			String insertRestaurante = "insert into restaurante (nome, email, telefone, codigoMorada, codigoArea, zonaArea) values (?, ?, ?, ?, ?, ?);";

			PreparedStatement preparedStatement = connection.prepareStatement(insertRestaurante);

			preparedStatement.setString(1, entity.getNome());
			preparedStatement.setString(2, entity.getEmail());
			preparedStatement.setInt(3, entity.getTelefone());
			preparedStatement.setInt(4, entity.getCodigoMorada());
			preparedStatement.setInt(5, entity.getCodigoArea());
			preparedStatement.setString(6, entity.getZonaArea());

			System.out.println(preparedStatement.toString());
			int result = preparedStatement.executeUpdate();

			if (result == 1) {
				entity = get(entity);
				connection.commit();

				System.out.println("Commited");
				return entity;
			}
			return null;

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
	public Restaurante update(Restaurante entity) {

		System.out.println("RestauranteDAO -> Start update");

		try {
			connection.setAutoCommit(false);

			try {
				String updateRestaurante = "update restaurante set nome=?, email=?, telefone=? where codigo=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(updateRestaurante);

				preparedStatement.setString(1, entity.getNome());
				preparedStatement.setString(2, entity.getEmail());
				preparedStatement.setInt(3, entity.getTelefone());
				preparedStatement.setInt(4, entity.getCodigo());

				System.out.println(preparedStatement.toString());
				int result = preparedStatement.executeUpdate();

				connection.commit();
				connection.setAutoCommit(true);

				System.out.println("Commited");

				return result == 1 ? entity : null;

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
	public Restaurante get(Restaurante entity) {
				
		System.out.println("RestauranteDAO -> Start get");
		Restaurante restaurante = null;

		try {

			try {
				String getRestaurante = "select * from restaurante where codigo=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getRestaurante);

				preparedStatement.setInt(1, entity.getCodigo());

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();
				
				while (result.next()) {
					restaurante = new Restaurante(result.getInt("codigo"), result.getString("nome"),
							result.getString("email"), result.getInt("telefone"), result.getInt("codigoMorada"),
							result.getInt("codigoArea"), result.getString("zonaArea"));
				

				}
				System.out.println("Commited");
				return restaurante;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return restaurante;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return restaurante;
		}
		
		
	}

	@Override
	public boolean delete(Restaurante entity) {
		
		System.out.println("RestauranteDAO -> Start delete");

		try {
			connection.setAutoCommit(false);

			try {
				String deleteRestaurante = "delete from restaurante where codigo=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(deleteRestaurante);

				preparedStatement.setInt(1, entity.getCodigo());

				System.out.println(preparedStatement.toString());
				int result = preparedStatement.executeUpdate();
				
				connection.commit();
				connection.setAutoCommit(true);
				System.out.println("Commited");
				return result == 1 ? true : false;
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
	public ArrayList<Restaurante> listAll() {
		System.out.println("RestauranteDAO -> Start listAll");
		ArrayList<Restaurante> restaurantes = new ArrayList<>();

		try {

			try {
				String getRestaurante = "select * from restaurante;";

				PreparedStatement preparedStatement = connection.prepareStatement(getRestaurante);

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();
				
				Restaurante restaurante = null; 
				while (result.next()) {
					restaurante = new Restaurante(result.getInt("codigo"), result.getString("nome"),
							result.getString("email"), result.getInt("telefone"), result.getInt("codigoMorada"),
							result.getInt("codigoArea"), result.getString("zonaArea"));
					restaurantes.add(restaurante);

				}
				System.out.println("Commited");
				return restaurantes;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return restaurantes;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return restaurantes;
		}
	}

	

	public static void main(String[] args) {
		Restaurante restaurante = new Restaurante("Teste", "teste@gmail.com", 911039236, 2, 1700, "120");
		RestauranteDAO restauranteDAO = new RestauranteDAO(); 
		
		restauranteDAO.create(restaurante); 
		
		restaurante.setCodigo(2);
		restaurante.setNome("Outro Nome");
		
		restauranteDAO.update(restaurante); 
		
		System.out.println(restauranteDAO.get(restaurante));
		
		ArrayList<Restaurante> restaurantes = restauranteDAO.listAll();
		
		for (int i = 0; i < restaurantes.size() ; i++) {
			System.out.println(restaurantes.get(i));
		}
		
		System.out.println(restauranteDAO.delete(restaurante));
	}

}
