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
						+ t.getNif() + "," + ((t.getNumeroFuncionarioChefe() == -1) ? "NULL" : t.getNumeroFuncionarioChefe())
						+ "," + t.getCodigoRestaurante() + ");";

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

				String updateFuncionario = "UPDATE funcionario SET " 
											+ "chefe =" + ((t.getNumeroFuncionarioChefe() == -1) ? "NULL" : t.getNumeroFuncionarioChefe()) 
											+ ", codigoRestaurante =" + t.getCodigoRestaurante() + " WHERE nif = " + t.getNif()
											+ ";";

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
				String getFuncionario = "select u.nif as nif, u.nomeProprio as nomeProprio, u.apelido as apelido, "
						+ "u.idade as idade, f.numero as numero, f.chefe as numeroFuncionarioChefe, f.codigoRestaurante as codigoRestaurante "
						+ " from funcionario as f" + 
						" inner join utilizador as u on f.nif = u.nif " + 
						"where f.nif = " + id + ";";

				System.out.println("-> Instrução SQL: " + getFuncionario);
				ResultSet result = stmt.executeQuery(getFuncionario);
				
				while (result.next()) {
					funcionario = new Funcionario(
							result.getInt("nif"), 
							result.getString("nomeProprio"), 
							result.getString("apelido"),
							result.getInt("idade"),
							result.getInt("numero"),
							(result.getInt("numeroFuncionarioChefe") == 0? -1 : result.getInt("numeroFuncionarioChefe")),
							result.getInt("codigoRestaurante"));			
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
		System.out.println("FuncionarioDAO -> Start listAll");
		ArrayList<Funcionario> funcionarios = new ArrayList<>(); 
		
		try {

			try (Statement stmt = connection.createStatement()) {
				String getFuncionarios = "select u.nif as nif, u.nomeProprio as nomeProprio, u.apelido as apelido, "
						+ "u.idade as idade, f.numero as numero, f.chefe as numeroFuncionarioChefe, f.codigoRestaurante as codigoRestaurante "
						+ " from funcionario as f" + 
						" inner join utilizador as u on f.nif = u.nif;";
				
				System.out.println("-> Instrução SQL: " + getFuncionarios);
				ResultSet result = stmt.executeQuery(getFuncionarios);
				
				Funcionario funcionario = null;
				while (result.next()) {
					funcionario = new Funcionario(
							result.getInt("nif"), 
							result.getString("nomeProprio"), 
							result.getString("apelido"),
							result.getInt("idade"),
							result.getInt("numero"),
							(result.getInt("numeroFuncionarioChefe") == 0? -1 : result.getInt("numeroFuncionarioChefe")),
							result.getInt("codigoRestaurante"));
					
					funcionarios.add(funcionario);
				}
				System.out.println("Commited");
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}finally {
			return funcionarios;
		}
	}
	
	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario(234503025, "Ana", "Oliveira", 28, 3, 3);
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO(); 
		
//		funcionarioDAO.create(funcionario);
//
//		funcionario.setApelido("Preto");
//		funcionario.setIdade(53);
//		funcionario.setCodigoRestaurante(3);
//
//		funcionarioDAO.update(funcionario);
//		
//		System.out.println(funcionarioDAO.get(108257681));
//		
//		System.out.println(funcionarioDAO.delete(234503025));
		
		ArrayList<Funcionario> funcionarios = funcionarioDAO.listAll();
		System.out.println(funcionarios);
		for (int i = 0; i < funcionarios.size() ; i++) {
			System.out.println(funcionarios.get(i));
		}
	}

}
