package theSpoon.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import theSpoon.model.database.DBConnection;
import theSpoon.model.entities.Mesa;

public class MesaDAO implements DAO<Mesa>{
	
	Connection connection = DBConnection.getConnection();
	
	@Override
	public Mesa create(Mesa entity) {
		System.out.println("MesaDAO -> Start create");

		try {
			connection.setAutoCommit(false);

			String insertMesa = "insert into mesa (codigoRestaurante, lotacao) values (?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(insertMesa);

			preparedStatement.setInt(1, entity.getCodigoRestaurante());
			preparedStatement.setInt(2, entity.getLotacao());

			System.out.println(preparedStatement.toString());
			int result = preparedStatement.executeUpdate();

			if(result == 1) {
				entity = get(entity);
				connection.commit();

				System.out.println("Commited");
				return entity;
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
	public Mesa update(Mesa entity) {
		System.out.println("MesaDAO -> Start update");

		try {
			connection.setAutoCommit(false);

			try {
				String updateMesa = "update mesa set lotacao=? where numero=? and codigoRestaurante=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(updateMesa);

				preparedStatement.setInt(1, entity.getLotacao());
				preparedStatement.setInt(2, entity.getNumero());
				preparedStatement.setInt(3, entity.getCodigoRestaurante());

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
	public Mesa get(Mesa entity) {
		System.out.println("MesaDAO -> Start get");

		Mesa mesa = null;
		try {

			try {
				String getMesa = "select * from mesa where numero=? and codigoRestaurante=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getMesa);

				preparedStatement.setInt(1, entity.getNumero());
				preparedStatement.setInt(2, entity.getCodigoRestaurante());

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					mesa = new Mesa(result.getInt("numero"), result.getInt("codigoRestaurante"), result.getInt("lotacao"));
				}
				System.out.println("Commited");
				return mesa;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return mesa;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return mesa;
		}
	}

	@Override
	public boolean delete(Mesa entity) {
		System.out.println("MesaDAO -> Start delete");

		try {
			connection.setAutoCommit(false);

			try {
				String deleteMesa = "delete from mesa where numero=? and codigoRestaurante=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(deleteMesa);

				preparedStatement.setInt(1, entity.getNumero());
				preparedStatement.setInt(2, entity.getCodigoRestaurante());
				
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
	public ArrayList<Mesa> listAll() {
		System.out.println("MesaDAO -> Start listAll");
		ArrayList<Mesa> mesas = new ArrayList<>();

		try {

			try {
				String getMesa = "select * from mesa;";

				PreparedStatement preparedStatement = connection.prepareStatement(getMesa);

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();
				
				Mesa mesa = null;
				while (result.next()) {
					mesa = new Mesa(result.getInt("numero"), result.getInt("codigoRestaurante"), result.getInt("lotacao"));
					mesas.add(mesa);
				}
				System.out.println("Commited");
				return mesas;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return mesas;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return mesas;
		}
	}
	
	public static void main(String[] args) {
		MesaDAO mesaDAO = new MesaDAO();

		Mesa mesa = new Mesa(5, 3, 10);

		System.out.println(mesaDAO.create(mesa));

		Mesa car = mesaDAO.get(mesa);
		System.out.println(car);

		ArrayList<Mesa> ementas = mesaDAO.listAll();

		for (Mesa c : ementas) {
			System.out.println(c);
		}

		System.out.println(mesaDAO.delete(mesa));
	}

}
