package theSpoon.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import theSpoon.model.entities.Cliente;
import theSpoon.model.entities.Funcionario;
import thsSpoon.model.database.DBConnection;

public class FuncionarioDAO implements DAO<Funcionario> {

	private static Connection connection = DBConnection.connection;

	@Override
	public Funcionario create(Funcionario entity) {

		System.out.println("FuncionarioDAO -> Start create");

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
					String insertFuncionario = "insert into funcionario (nif, chefe, codigoRestaurante) values (?, ?, ?);";

					preparedStatement = connection.prepareStatement(insertFuncionario);

					preparedStatement.setInt(1, entity.getNif());
					preparedStatement.setObject(2, entity.getNumeroFuncionarioChefe());
					preparedStatement.setInt(3, entity.getCodigoRestaurante());

					System.out.println(preparedStatement.toString());
					result = preparedStatement.executeUpdate();

					if (result == 1) {
						entity = get(entity);
						connection.commit();

						System.out.println("Commited");
						return entity;
					}
					return null;

				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
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
	public Funcionario update(Funcionario entity) {
		System.out.println("FuncionarioDAO -> Start update");

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
						String updateFuncionario = "update funcionario set chefe=?, codigoRestaurante=? where numero=?";

						preparedStatement = connection.prepareStatement(updateFuncionario);

						preparedStatement.setInt(1,
								entity.getNumeroFuncionarioChefe() != -1 ? entity.getNumeroFuncionarioChefe() : -1);
						preparedStatement.setInt(2, entity.getCodigoRestaurante());
						preparedStatement.setInt(3, entity.getNumero());

						System.out.println(preparedStatement.toString());
						result = preparedStatement.executeUpdate();

						connection.commit();
						connection.setAutoCommit(true);
						System.out.println("Commited");

						return (result == 1 ? entity : null);

					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
				}
				return null;
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
	public Funcionario get(Funcionario entity) {

		System.out.println("FuncionarioDAO -> Start get");
		Funcionario funcionario = null;

		try {

			try {
				String getFuncionario = "select u.nif as nif, u.nomeProprio as nomeProprio, u.apelido as apelido, "
						+ "u.idade as idade, f.numero as numero, f.chefe as numeroFuncionarioChefe, f.codigoRestaurante as codigoRestaurante "
						+ " from funcionario as f" + " inner join utilizador as u on f.nif = u.nif "
						+ "where f.nif = ?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getFuncionario);

				preparedStatement.setInt(1, entity.getNif());

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					funcionario = new Funcionario(result.getInt("nif"), result.getString("nomeProprio"),
							result.getString("apelido"), result.getInt("idade"), result.getInt("numero"),
							result.getInt("numeroFuncionarioChefe"), result.getInt("codigoRestaurante"));

				}
				System.out.println("Commited");
				return funcionario;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return funcionario;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return funcionario;
		}

	}

	@Override
	public boolean delete(Funcionario entity) {

		System.out.println("FuncionarioDAO -> Start delete");

		try {
			connection.setAutoCommit(false);

			try {
				String deleteFuncionario = "delete from funcionario where numero=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(deleteFuncionario);

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
				}
				return false;

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
	public ArrayList<Funcionario> listAll() {

		System.out.println("FuncionarioDAO -> Start listAll");
		ArrayList<Funcionario> funcionarios = new ArrayList<>();

		try {

			try {

				String getFuncionario = "select u.nif as nif, u.nomeProprio as nomeProprio, u.apelido as apelido, "
						+ "u.idade as idade, f.numero as numero, f.chefe as numeroFuncionarioChefe, f.codigoRestaurante as codigoRestaurante "
						+ " from funcionario as f" + " inner join utilizador as u on f.nif = u.nif;";

				PreparedStatement preparedStatement = connection.prepareStatement(getFuncionario);

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				Funcionario funcionario = null;
				while (result.next()) {

					funcionario = new Funcionario(result.getInt("nif"), result.getString("nomeProprio"),
							result.getString("apelido"), result.getInt("idade"), result.getInt("numero"),
							result.getInt("numeroFuncionarioChefe"), result.getInt("codigoRestaurante"));

					funcionarios.add(funcionario);
				}
				System.out.println("Commited");
				return funcionarios;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return funcionarios;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return funcionarios;
		}

	}

	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario(234503025, "Ana", "Oliveira", 28, 3, 3);
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		System.out.println(funcionarioDAO.create(funcionario));

		funcionario.setApelido("Preto");
		funcionario.setIdade(53);
		funcionario.setCodigoRestaurante(5);

		funcionarioDAO.update(funcionario);

		funcionario = funcionarioDAO.get(funcionario);
		System.out.println(funcionario);

		ArrayList<Funcionario> funcionarios = funcionarioDAO.listAll();
		System.out.println(funcionarios);
		for (int i = 0; i < funcionarios.size(); i++) {
			System.out.println(funcionarios.get(i));
		}
		
		System.out.println(funcionarioDAO.delete(funcionario));
	}

}
