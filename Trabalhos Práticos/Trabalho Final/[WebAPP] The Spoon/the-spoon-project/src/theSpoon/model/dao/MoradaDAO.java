package theSpoon.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import theSpoon.model.database.DBConnection;
import theSpoon.model.entities.AreaGeografica;
import theSpoon.model.entities.Morada;

public class MoradaDAO implements DAO<Morada> {

	Connection connection = DBConnection.getConnection();

	@Override
	public Morada create(Morada entity) {
		System.out.println("MoradaDAO -> Start create");

		try {
			connection.setAutoCommit(false);

			String insertMorada = "insert into morada (codigoPostal, zonaPostal, designacao) values (?, ?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(insertMorada);

			preparedStatement.setInt(1, entity.getCodigoPostal());
			preparedStatement.setString(2, entity.getZonaPostal());
			preparedStatement.setString(3, entity.getDesignacao());

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
	public Morada update(Morada entity) {
		System.out.println("MoradaDAO -> Start update");

		try {
			connection.setAutoCommit(false);

			try {
				String updateMorada = "update morada set deginacao=? where codigo=? and codigoPostal=? and zonaPostal=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(updateMorada);

				preparedStatement.setString(1, entity.getDesignacao());
				preparedStatement.setInt(2, entity.getCodigo());
				preparedStatement.setInt(3, entity.getCodigoPostal());
				preparedStatement.setString(4, entity.getZonaPostal());

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
	public Morada get(Morada entity) {
		System.out.println("MoradaDAO -> Start get");
		Morada morada = null;

		try {

			try {
				String getMorada = "select * from morada where codigo=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getMorada);

				preparedStatement.setInt(1, entity.getCodigo());

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();
				
				while (result.next()) {
					morada = new Morada(result.getInt("codigo"), result.getInt("codigoPostal"),
							result.getString("zonaPostal"), result.getString("designacao"));

				}
				System.out.println("Commited");
				return morada;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return morada;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return morada;
		}
	}

	@Override
	public boolean delete(Morada entity) {
		System.out.println("MoradaDAO -> Start delete");

		try {
			connection.setAutoCommit(false);

			try {
				String deleteMorada = "delete from morada where codigo=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(deleteMorada);

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
	public ArrayList<Morada> listAll() {
		System.out.println("MoradaDAO -> Start get");
		ArrayList<Morada> moradas = new ArrayList<>();

		try {

			try {
				String getMorada = "select * from morada;";

				PreparedStatement preparedStatement = connection.prepareStatement(getMorada);

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				Morada morada = null;
				while (result.next()) {
					morada = new Morada(result.getInt("codigo"), result.getInt("codigoPostal"),
							result.getString("zonaPostal"), result.getString("designacao"));
					moradas.add(morada);
				}
				System.out.println("Commited");
				return moradas;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return moradas;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return moradas;
		}
	}
	
	public AreaGeografica getAreaGeograficaFromMorada(Morada morada) {
		System.out.println("MoradaDAO -> Start getAreaGeograficaFromMorada");
		AreaGeografica areaGeografica = null;

		try {

			try {
				String getAreaGeografica = "select * from area_geografica as ag " + 
						"inner join morada as m on ag.codigoPostal=m.codigoPostal and ag.zonaPostal=m.zonaPostal and m.codigo=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getAreaGeografica);

				preparedStatement.setInt(1, morada.getCodigo());
				
				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					areaGeografica = new AreaGeografica(
							result.getInt("codigoPostal"), 
							result.getString("zonaPostal"), 
							result.getString("freguesia"), 
							result.getString("concelho"), 
							result.getString("distrito"));
					
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
	
	public Morada findMoradaByDesignacao(String desginacao){
		System.out.println("MoradaDAO -> Start getAreaGeograficaFromMorada");
		Morada morada = null;

		try {

			try {
				String getAreaGeografica = "select * from morada where designacao=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getAreaGeografica);

				preparedStatement.setString(1, desginacao);
				
				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					morada = new Morada(
							result.getInt("codigo"), 
							result.getInt("codigoPostal"), 
							result.getString("zonaPostal"),
							result.getString("designacao")); 
					
				}
				System.out.println("Commited");
				return morada;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return morada;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return morada;
		}
	}
	
	public static void main(String[] args) {
		
		
		  MoradaDAO moradaDAO = new MoradaDAO();
		  
		  Morada morada = new Morada(2615, "040", "Rua Coronel Bento Roma Lt 942");
		  
		  moradaDAO.create(morada);
		  
		  Morada m = moradaDAO.get(morada); System.out.println(m);
		  
		  
		  ArrayList<Morada> moradas = moradaDAO.listAll();
		  
		  for(Morada mor : moradas) { 
			  System.out.println(mor);
			  System.out.println(moradaDAO.getAreaGeograficaFromMorada(mor));
		  }

		  moradaDAO.delete(morada);
				
	}

}
