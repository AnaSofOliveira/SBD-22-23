package theSpoon.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import theSpoon.controller.controller;
import theSpoon.model.database.DBConnection;
import theSpoon.model.entities.AreaGeografica;
import theSpoon.model.entities.Morada;

public class AreaGeograficaDAO implements DAO<AreaGeografica> {

	Connection connection = DBConnection.getConnection();

	@Override
	public AreaGeografica create(AreaGeografica entity) {
		System.out.println("AreaGeograficaDAO -> Start create");

		try {
			connection.setAutoCommit(false);

			String insertAreaGeografica = "insert into area_geografica (codigoPostal, zonaPostal, freguesia, concelho, distrito) values (?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(insertAreaGeografica);

			preparedStatement.setInt(1, entity.getCodigoPostal());
			preparedStatement.setString(2, entity.getZonaPostal());
			preparedStatement.setString(3, entity.getFreguesia());
			preparedStatement.setString(4, entity.getConcelho());
			preparedStatement.setString(5, entity.getDistrito());

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
	public AreaGeografica update(AreaGeografica entity) {
		System.out.println("AreaGeograficaDAO -> Start update");

		try {
			connection.setAutoCommit(false);

			try {
				String updateAreaGeografica = "update area_geografica set freguesia=?, concelho=?, distrito=? where codigoPostal=? and zonaPostal=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(updateAreaGeografica);

				preparedStatement.setString(1, entity.getFreguesia());
				preparedStatement.setString(2, entity.getConcelho());
				preparedStatement.setString(3, entity.getDistrito());
				preparedStatement.setInt(4, entity.getCodigoPostal());
				preparedStatement.setString(5, entity.getZonaPostal());

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
	public AreaGeografica get(AreaGeografica entity) {
		System.out.println("AreaGeograficaDAO -> Start get");

		AreaGeografica areaGeografica = null;

		try {

			try {
				String getAreaGeografica = "select * from area_geografica where codigoPostal=? and zonaPostal=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getAreaGeografica);

				preparedStatement.setInt(1, entity.getCodigoPostal());
				preparedStatement.setString(2, entity.getZonaPostal());

				System.out.println("=> Instrução SQL: " + preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					areaGeografica = new AreaGeografica(result.getInt("codigoPostal"), result.getString("zonaPostal"),
							result.getString("freguesia"), result.getString("concelho"), result.getString("distrito"));
				}
				System.out.println("Commited");
				return areaGeografica;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return areaGeografica;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return areaGeografica;
		}
	}

	@Override
	public boolean delete(AreaGeografica entity) {
		System.out.println("AreaGeograficaDAO -> Start delete");

		try {
			connection.setAutoCommit(false);

			try {
				String deleteAreaGeografica = "delete from area_geografica where codigoPostal=? and zonaPostal=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(deleteAreaGeografica);

				preparedStatement.setInt(1, entity.getCodigoPostal());
				preparedStatement.setString(2, entity.getZonaPostal());

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
	public ArrayList<AreaGeografica> listAll() {
		System.out.println("AreaGeograficaDAO -> Start listAll");

		ArrayList<AreaGeografica> areasGeograficas = new ArrayList<>();

		try {

			try {
				String getAreaGeografica = "select * from area_geografica;";

				PreparedStatement preparedStatement = connection.prepareStatement(getAreaGeografica);

				System.out.println("=> Instrução SQL: " + preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				AreaGeografica areaGeografica = null;

				while (result.next()) {
					areaGeografica = new AreaGeografica(result.getInt("codigoPostal"), result.getString("zonaPostal"),
							result.getString("freguesia"), result.getString("concelho"), result.getString("distrito"));
					areasGeograficas.add(areaGeografica);
				}
				System.out.println("Commited");
				return areasGeograficas;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return areasGeograficas;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return areasGeograficas;
		}
	}
	
	public AreaGeografica getAreaGeograficaByCodigoPostal(int codigoPostal, String zonaPostal) {
		System.out.println("AreaGeograficaDAO -> Start getAreaGeograficaByCodigoPostal");
		AreaGeografica areaGeografica = null;

		try {

			try {
				String getAreaGeografica = "select * from area_geografica where codigoPostal=? and zonaPostal=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getAreaGeografica);

				preparedStatement.setInt(1, codigoPostal);
				preparedStatement.setString(2, zonaPostal);
				
				System.out.println("=> Instrução SQL: " + preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					areaGeografica = new AreaGeografica(result.getInt("codigoPostal"), result.getString("zonaPostal"),
							result.getString("freguesia"), result.getString("concelho"), result.getString("distrito"));
				}
				System.out.println("Commited");
				return areaGeografica;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return areaGeografica;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return areaGeografica;
		}
	}

	public static void main(String[] args) {

		AreaGeograficaDAO areaGeograficaDAO = new AreaGeograficaDAO();

		AreaGeografica areaGeografica = new AreaGeografica(1600, "583", "Carnide", "Lisboa", "Lisboa");

		areaGeograficaDAO.delete(areaGeografica);
		areaGeograficaDAO.create(areaGeografica);

		AreaGeografica ag = areaGeograficaDAO.get(areaGeografica);
		System.out.println(ag);
		
		AreaGeografica areaGeografica2 = new AreaGeografica(2615, "040");
		AreaGeografica ag2 = areaGeograficaDAO.get(areaGeografica2);
		System.out.println(ag2);

		ArrayList<AreaGeografica> areasGeograficas = areaGeograficaDAO.listAll();

		for (AreaGeografica ar : areasGeograficas) {
			System.out.println(ar);
		}

	}

}
