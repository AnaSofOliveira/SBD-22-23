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
import theSpoon.model.beans.Funcionario;
import theSpoon.model.beans.Morada;
import theSpoon.model.beans.Restaurante;
import thsSpoon.model.database.DBConnection;

public class FuncionarioDAO implements DAO<Funcionario>{
	
	private static Connection connection = DBConnection.connection;

	@Override
	public boolean create(Funcionario t) {
		System.out.println("FuncionarioDAO -> Start create");

		try {
			connection.setAutoCommit(false);

			try (Statement stmt = connection.createStatement()) {
				String insertUtilizador = "INSERT INTO utilizador (nif, nomeProprio, apelido, idade) VALUES ("
						+ t.getNif() + ",'" + t.getNomeProprio() + "','" + t.getApelido() + "'," + t.getIdade() + ");";

				System.out.println("-> Instrução SQL: " + insertUtilizador);
				stmt.executeUpdate(insertUtilizador);

				String insertFuncionario = "INSERT INTO funcionario (nif, chefe, codigoRestaurante) VALUES ("
						+ t.getNif() + "," + ((t.getChefe() == null) ? "NULL" : t.getChefe().getNumero())
						+ "," + t.getRestaurante().getCodigo() + ");";

				System.out.println("-> Instrução SQL: " + insertFuncionario);
				stmt.executeUpdate(insertFuncionario);

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
	public boolean update(Funcionario t) {
		System.out.println("FuncionarioDAO -> Start update");

		try {
			connection.setAutoCommit(false);

			try (Statement stmt = connection.createStatement()) {
				String updateUtilizador = "UPDATE utilizador SET " + "nomeProprio ='" + t.getNomeProprio()
						+ "', apelido = '" + t.getApelido() + "', idade =" + t.getIdade() + " WHERE nif = " + t.getNif()
						+ ";";

				System.out.println("-> Instrução SQL: " + updateUtilizador);
				stmt.executeUpdate(updateUtilizador);

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				String updateFuncionario = "UPDATE funcionario SET " + "numero ='"
						+ t.getNumero() + "', nif = "
						+ t.getNif() + ", chefe ="
						+ ((t.getChefe() == null) ? "NULL" : t.getChefe().getNumero()) + ", codigoRestaurante ="
						+ t.getRestaurante().getCodigo() + ";";

				System.out.println("-> Instrução SQL: " + updateFuncionario);
				stmt.executeUpdate(updateFuncionario);

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
	public Funcionario get(int id) {
		System.out.println("FuncionarioDAO -> Start get");
		Funcionario funcionario = null; 
		
		try {

			try (Statement stmt = connection.createStatement()) {
				String getFuncionario = "select f.numero as numero, u.nif as nif, u.nomeProprio as nomeProprio, u.apelido as apelido, u.idade as idade, r.codigo as codigoRest, r.nome as nomeRest, r.email as emailRest, r.telefone as telefoneRest, f.chefe as chefe, m.codigo as codigoMorada, m.designacao as desigMorada, a.codigoPostal as codigoPostal, a.zonaPostal as zonaPostal, a.freguesia as freguesia, a.concelho as concelho, a.distrito as distrito"
						+ " from funcionario as f" + 
						" inner join utilizador as u on f.nif = u.nif" + 
						" inner join funcionario as chefe on f.chefe = chefe.numero" + 
						" inner join restaurante as r on f.codigoRestaurante = r.codigo" + 
						" inner join morada as m on r.codigoMorada = m.codigo" + 
						" inner join area_geografica as a on r.codigoArea = a.codigoPostal and r.zonaArea = a.zonaPostal " + 
						"where f.nif = " + id + ";";

				System.out.println("-> Instrução SQL: " + getFuncionario);
				ResultSet result = stmt.executeQuery(getFuncionario);
				
				
				while (result.next()) {
					funcionario = new Funcionario(
										result.getInt("numero"),
										result.getInt("nif"), 
										result.getString("nomeProprio"), 
										result.getString("apelido"), 
										result.getInt("idade"),
										new Restaurante(
												result.getInt("codigoRest"),
												result.getString("nomeRest"),
												result.getString("emailRest"),
												result.getInt("telefone"),
												new Morada(
														new AreaGeografica(
																result.getInt("codigoPostal"),
																result.getInt("zonaPostal"),
																result.getString("freguesia"), 
																result.getString("concelho"), 
																result.getString("distrito")
														), 
														result.getString("desigMorada")
												)
										));
					int codigoChefe = result.getInt("chefe");
					
					String getChefe = "select * from funcionario as f" + 
							"	inner join utilizador as u on f.nif = u.nif" + 
							"where f.numero = "+ codigoChefe +"; ";

					System.out.println("-> Instrução SQL: " + getChefe);
					result = stmt.executeQuery(getChefe);
					
					while(result.next()) {
						funcionario.setChefe(new Funcionario(
								result.getInt("numero"), 
								result.getInt("nif"), 
								result.getString("nomeProprio"),
								result.getString("apelido"), 
								result.getInt("idade"),
								funcionario.getRestaurante()));
					}			
				}
				System.out.println("Commited");
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}finally {
			return funcionario;
		}
	}

	@Override
	public boolean delete(int id) {
		System.out.println("FuncionarioDAO -> Start delete");

		try {
			connection.setAutoCommit(false);

			try (Statement stmt = connection.createStatement()) {
				String deleteFuncionario = "DELETE FROM funcionario WHERE nif="+ id + ";";

				System.out.println("-> Instrução SQL: " + deleteFuncionario);
				stmt.executeUpdate(deleteFuncionario);
				
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
	public ArrayList<Funcionario> listAll() {
		// TODO Auto-generated method stub
		TERMINAR MÉTODO
		return null;
	}

}
