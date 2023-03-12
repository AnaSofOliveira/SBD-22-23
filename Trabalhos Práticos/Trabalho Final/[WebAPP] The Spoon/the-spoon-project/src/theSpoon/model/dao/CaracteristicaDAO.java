package theSpoon.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import theSpoon.model.entities.AreaGeografica;
import theSpoon.model.entities.Caracteristica;
import thsSpoon.model.database.DBConnection;

public class CaracteristicaDAO implements DAO<Caracteristica> {

	Connection connection = DBConnection.getConnection();

	@Override
	public Caracteristica create(Caracteristica entity) {
		System.out.println("CaracteristicaDAO -> Start create");

		try {
			connection.setAutoCommit(false);

			String insertCaracteristica = "insert into caracteristica (caracteristica) values (?)";

			PreparedStatement preparedStatement = connection.prepareStatement(insertCaracteristica);

			preparedStatement.setString(1, entity.getCaracteristica());

			System.out.println("=> Instrução SQL: " + preparedStatement.toString());
			int result = preparedStatement.executeUpdate();

			if(result == 1) {
				entity = get(entity);
				connection.commit();

				System.out.println("Commited");
				return entity;
			}
			connection.setAutoCommit(true);
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
	public Caracteristica update(Caracteristica entity) {
		System.out.println("CaracteristicaDAO -> Start update");

		try {
			connection.setAutoCommit(false);

			try {
				String updateCaracteristica = "update caracteristica set caracteristica=? where numero=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(updateCaracteristica);

				preparedStatement.setString(1, entity.getCaracteristica());
				preparedStatement.setInt(2, entity.getNumero());

				System.out.println("=> Instrução SQL: " + preparedStatement.toString());
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
	public Caracteristica get(Caracteristica entity) {
		System.out.println("CaracteristicaDAO -> Start get");

		Caracteristica caracteristica = null;

		try {

			try {
				String getCaracteristica = "select * from caracteristica where caracteristica=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getCaracteristica);

				preparedStatement.setString(1, entity.getCaracteristica());

				System.out.println("=> Instrução SQL: " + preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					caracteristica = new Caracteristica(result.getInt("numero"), result.getString("caracteristica"));
				}
				System.out.println("Commited");
				return caracteristica;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return caracteristica;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return caracteristica;
		}
	}

	@Override
	public boolean delete(Caracteristica entity) {
		System.out.println("CaracteristicaDAO -> Start delete");

		try {
			connection.setAutoCommit(false);

			try {
				String deleteCaracteristica = "delete from caracteristica where numero=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(deleteCaracteristica);

				preparedStatement.setInt(1, entity.getNumero());

				System.out.println("=> Instrução SQL: " + preparedStatement.toString());
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
	public ArrayList<Caracteristica> listAll() {
		System.out.println("CaracteristicaDAO -> Start listAll");

		ArrayList<Caracteristica> caracteristicas = new ArrayList<>();

		try {

			try {
				String getAreaGeografica = "select * from caracteristica;";

				PreparedStatement preparedStatement = connection.prepareStatement(getAreaGeografica);

				System.out.println("=> Instrução SQL: " + preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				Caracteristica caracteristica = null;
				while (result.next()) {
					caracteristica = new Caracteristica(result.getInt("numero"), result.getString("caracteristica"));
					caracteristicas.add(caracteristica);
				}
				System.out.println("Commited");
				return caracteristicas;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return caracteristicas;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return caracteristicas;
		}
	}

	public static void main(String[] args) {
		CaracteristicaDAO caracteristicaDAO = new CaracteristicaDAO();

		Caracteristica caracteristica = new Caracteristica("Teste");

		caracteristicaDAO.delete(caracteristica);
		caracteristicaDAO.create(caracteristica);

		Caracteristica car = caracteristicaDAO.get(caracteristica);
		System.out.println(car);
		
		Caracteristica areaGeografica2 = new Caracteristica("Fumador");
		Caracteristica car2 = caracteristicaDAO.get(areaGeografica2);
		System.out.println(car2);

		ArrayList<Caracteristica> caract = caracteristicaDAO.listAll();

		for (Caracteristica ar : caract) {
			System.out.println(ar);
		}
	}

}
