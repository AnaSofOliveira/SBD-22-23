package theSpoon.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import theSpoon.model.beans.DiaSemana;
import theSpoon.model.beans.Ementa;
import theSpoon.model.beans.Funcionario;
import theSpoon.model.beans.Horario;
import theSpoon.model.beans.Item;
import theSpoon.model.beans.Morada;
import theSpoon.model.beans.Restaurante;
import theSpoon.model.beans.TipoItem;
import thsSpoon.model.database.DBConnection;

public class RestauranteDAO implements DAO<Restaurante> {

	private static Connection connection = DBConnection.connection;

	@Override
	public boolean create(Restaurante t) {
		System.out.println("RestauranteDAO -> Start create");

		try {
			connection.setAutoCommit(false);

			try (Statement stmt = connection.createStatement()) {
				String insertRestaurante = "INSERT INTO restaurante (nome, email, telefone, codigoMorada, codigoArea, zonaArea) VALUES ('"
						+ t.getNome() + "','" + t.getEmail() + "'," + t.getTelefone() + "," + t.getCodigoMorada() + ", "
						+ t.getCodigoArea() + ", " + t.getZonaArea() + ");";

				System.out.println("-> Instrução SQL: " + insertRestaurante);
				stmt.executeUpdate(insertRestaurante);

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
	public boolean update(Restaurante t) {
		System.out.println("RestauranteDAO -> Start update");

		try {
			connection.setAutoCommit(false);

			try (Statement stmt = connection.createStatement()) {
				String updateRestaurante = "UPDATE restaurante SET " + "nome ='" + t.getNome() + "', email = '"
						+ t.getEmail() + "', telefone =" + t.getTelefone() + " WHERE codigo = " + t.getCodigo() + ";";

				System.out.println("-> Instrução SQL: " + updateRestaurante);
				stmt.executeUpdate(updateRestaurante);

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
	public Restaurante get(int id) {
		System.out.println("RestauranteDAO -> Start get");
		Restaurante restaurante = null;

		try {

			try (Statement stmt = connection.createStatement()) {
				String getRestaurante = "select * " + " from restaurante " + "where codigo = " + id + ";";

				System.out.println("-> Instrução SQL: " + getRestaurante);
				ResultSet result = stmt.executeQuery(getRestaurante);

				while (result.next()) {
					restaurante = new Restaurante(result.getInt("codigo"), result.getString("nome"),
							result.getString("email"), result.getInt("telefone"), result.getInt("codigoMorada"),
							result.getInt("codigoArea"), result.getInt("zonaArea"));

				}
				System.out.println("Commited");

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} finally {
			return restaurante;
		}
	}

	@Override
	public boolean delete(int id) {
		System.out.println("RestauranteDAO -> Start delete");

		try {
			connection.setAutoCommit(false);

			try (Statement stmt = connection.createStatement()) {
				String deleteRestaurante = "DELETE FROM restaurante WHERE codigo=" + id + ";";

				System.out.println("-> Instrução SQL: " + deleteRestaurante);
				stmt.executeUpdate(deleteRestaurante);

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
	public ArrayList<Restaurante> listAll() {
		System.out.println("RestauranteDAO -> Start get");
		ArrayList<Restaurante> restaurantes = new ArrayList<>();

		try {

			try (Statement stmt = connection.createStatement()) {
				String getRestaurante = "select * " + " from restaurante;";

				System.out.println("-> Instrução SQL: " + getRestaurante);
				ResultSet result = stmt.executeQuery(getRestaurante);

				Restaurante restaurante = null;
				while (result.next()) {
					restaurante = new Restaurante(result.getInt("codigo"), result.getString("nome"),
							result.getString("email"), result.getInt("telefone"), result.getInt("codigoMorada"),
							result.getInt("codigoArea"), result.getInt("zonaArea"));

					restaurantes.add(restaurante);
				}
				System.out.println("Commited");

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} finally {
			return restaurantes;
		}
	}

	public Morada getMoradaFromRestaurante(Restaurante restaurante) {
		System.out.println("RestauranteDAO -> Start getMoradaFromRestaurante");
		Morada morada = null;

		try {

			try (Statement stmt = connection.createStatement()) {
				String getMorada = "select * " + " from morada " + "where codigo=" + restaurante.getCodigoMorada()
						+ " and codigoArea=" + restaurante.getCodigoArea() + " and zonaArea="
						+ restaurante.getZonaArea() + ";";

				System.out.println("-> Instrução SQL: " + getMorada);
				ResultSet result = stmt.executeQuery(getMorada);

				while (result.next()) {
					morada = new Morada(result.getInt("codigo"), result.getInt("codigoPostal"),
							result.getInt("zonaPostal"), result.getString("designacao"));

				}
				System.out.println("Commited");

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} finally {
			return morada;
		}
	}

	public HashMap<Horario, Ementa> getEmentasEHorariosFromRestaurante(Restaurante restaurante) {

		System.out.println("RestauranteDAO -> Start getEmentasEHorariosFromRestaurante");
		HashMap<Horario, Ementa> ementas_horarios = new HashMap<>();

		try {

			try (Statement stmt = connection.createStatement()) {
				String getHorario = "select h.horaInicio, h.horaFim, h.diaSemana, h.idEmenta, e.designacao "
						+ "from horario as h" + " inner join ementa as e on h.idEmenta = e.id"
						+ "where h.codigoRestaurante=1 " + "order by diaSemana;";

				System.out.println("-> Instrução SQL: " + getHorario);
				ResultSet result = stmt.executeQuery(getHorario);

				Horario horario = null;
				Ementa ementa = null;

				while (result.next()) {
					horario = new Horario(new Date(result.getDate("horaInicio").getTime()),
							new Date(result.getDate("horaFim").getTime()), (DiaSemana) result.getObject("diaSemana"),
							result.getInt("idEmenta"), result.getInt("codigoRestaurante"));

					ementa = new Ementa(result.getInt("idEmenta"), restaurante.getCodigo(),
							result.getString("designacao"));

					ementas_horarios.put(horario, ementa);
				}
				System.out.println("Commited");

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} finally {
			return ementas_horarios;
		}

	}

	public Ementa getEmentasInTime(Restaurante restaurante, Date time) {
		System.out.println("RestauranteDAO -> Start getEmenta");
		Ementa ementa = null;
		
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(time);
		
		DiaSemana weekDay = DiaSemana.fromInt(calendar.get(Calendar.DAY_OF_WEEK));
		int hour = calendar.get(Calendar.HOUR);

		try {

			try (Statement stmt = connection.createStatement()) {
				String getEmenta = "select * from horario where diaSemana='" + weekDay + "' and horaInicio <= '" + hour + "' and horaFim >= '" + hour + "' and codigoRestaurante=" + restaurante.getCodigo() + ";";

				System.out.println("-> Instrução SQL: " + getEmenta);
				ResultSet result = stmt.executeQuery(getEmenta);

				while (result.next()) {
					ementa = new Ementa(
							result.getInt("id"), 
							restaurante.getCodigo(), 
							result.getString("designacao"));
				}
				System.out.println("Commited");

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} finally {
			return ementa;
		}
	}
	
	public ArrayList<Item> getItensFromEmenta(Ementa ementa){

		System.out.println("RestauranteDAO -> Start getEmentasEHorariosFromRestaurante");
		ArrayList<Item> itens = new ArrayList<>();

		try {

			try (Statement stmt = connection.createStatement()) {
				String getItem = "select * from item_ementa as ie" + 
									"	inner join item as i on i.id = ie.idItem" + 
									"where ie.idEmenta=" + ementa.getId() + " and ie.codigoRestaurante=" + ementa.getCodigoRestaurante() + ";";

				System.out.println("-> Instrução SQL: " + getItem);
				ResultSet result = stmt.executeQuery(getItem);

				Item item = null;
				while (result.next()) {
					item = new Item(
							result.getInt("id"), 
							result.getString("desginacao"), 
							result.getString("descricao"), 
							(TipoItem) result.getObject("tipo"), 
							result.getInt("idRecurso"));

					itens.add(item);
				}
				System.out.println("Commited");

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} finally {
			return itens;
		}
	
	}
	
	
	public static void main(String[] args) {
//		Restaurante restaurante = new Restaurante("Teste", "teste@gmail.com", 911039236, 2, 1700, 120);
//		RestauranteDAO restauranteDAO = new RestauranteDAO(); 
//		
//		restauranteDAO.create(restaurante); 
//		
//		restaurante.setCodigo(8);
//		restaurante.setNome("Outro Nome");
//		restaurante.setCodigoMorada(15);
//		
//		restauranteDAO.update(restaurante); 
//		
//		System.out.println(restauranteDAO.get(7));
//		System.out.println(restauranteDAO.delete(8));
//		System.out.println(restauranteDAO.delete(9));
//		
//		
//		ArrayList<Restaurante> restaurantes = restauranteDAO.listAll();
//		System.out.println(restaurantes);
//		for (int i = 0; i < restaurantes.size() ; i++) {
//			System.out.println(restaurantes.get(i));
//		}
	}

}
