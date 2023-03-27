package theSpoon.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import theSpoon.model.database.DBConnection;
import theSpoon.model.entities.Funcionario;
import theSpoon.model.entities.Utilizador;

public class UtilizadorDAO implements DAO<Utilizador> {

	Connection connection = DBConnection.getConnection();

	@Override
	public Utilizador create(Utilizador entity) {
		System.out.println("UtilizadorDAO -> Start create");

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
	public Utilizador update(Utilizador entity) {
		System.out.println("UtilizadorDAO -> Start update");

		try {
			connection.setAutoCommit(false);

			String updateUtilizador = "update utilizador set nomeProprio=?, apelido=?, idade=? where nif=?;";

			PreparedStatement preparedStatement = connection.prepareStatement(updateUtilizador);

			preparedStatement.setString(1, entity.getNomeProprio());
			preparedStatement.setString(2, entity.getApelido());
			preparedStatement.setInt(3, entity.getIdade());
			preparedStatement.setInt(4, entity.getNif());

			System.out.println(preparedStatement.toString());
			int result = preparedStatement.executeUpdate();

			return (result == 1 ? entity : null);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Utilizador get(Utilizador entity) {
		System.out.println("UtilizadorDAO -> Start get");
		Utilizador utilizador = null;

		try {

			try {
				String getUtilizador = "select * from utilizador where nif=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getUtilizador);

				preparedStatement.setInt(1, entity.getNif());

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					utilizador = new Utilizador(result.getInt("nif"), result.getString("nomeProprio"),
							result.getString("apelido"), result.getInt("idade"));
				}
				System.out.println("Commited");
				return utilizador;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return utilizador;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return utilizador;
		}
	}

	@Override
	public boolean delete(Utilizador entity) {
		System.out.println("UtilizadorDAO -> Start delete");

		try {
			connection.setAutoCommit(false);

			String deleteUtilizador = "delete from utilizador where nif=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(deleteUtilizador);

			preparedStatement.setInt(1, entity.getNif());

			System.out.println(preparedStatement.toString());
			int result = preparedStatement.executeUpdate();

			connection.commit();
			connection.setAutoCommit(true);
			System.out.println("Commited");

			return (result == 1 ? true : false);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public ArrayList<Utilizador> listAll() {
		System.out.println("UtilizadorDAO -> Start listAll");
		ArrayList<Utilizador> utilizadores = new ArrayList<>();

		try {

			try {
				String getUtilizadores = "select * from utilizador;";

				PreparedStatement preparedStatement = connection.prepareStatement(getUtilizadores);

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();
				
				Utilizador utilizador = null;
				
				while (result.next()) {
					utilizador = new Utilizador(result.getInt("nif"), result.getString("nomeProprio"),
							result.getString("apelido"), result.getInt("idade"));
					utilizadores.add(utilizador);
				}
				System.out.println("Commited");
				return utilizadores;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return utilizadores;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return utilizadores;
		}
	}

}
