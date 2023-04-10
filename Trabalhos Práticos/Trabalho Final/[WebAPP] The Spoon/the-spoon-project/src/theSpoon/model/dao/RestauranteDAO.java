package theSpoon.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import theSpoon.model.database.DBConnection;
import theSpoon.model.entities.Caracteristica;
import theSpoon.model.entities.DiaSemana;
import theSpoon.model.entities.Ementa;
import theSpoon.model.entities.Horario;
import theSpoon.model.entities.Morada;
import theSpoon.model.entities.Recurso;
import theSpoon.model.entities.Restaurante;

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

	public ArrayList<Horario> getHorariosFromRestaurante(Restaurante restaurante) {
		System.out.println("RestauranteDAO -> Start getHorariosFromRestaurante");
		ArrayList<Horario> horarios = new ArrayList<>();

		try {

			try {
				String getHorarios = "select h.diaSemana as diaSemana, min(h.horaInicio) as horaInicio, max(h.horaFim) as horaFim from horario as h " + 
						"inner join restaurante as r " + 
						"on r.codigo = h.codigoRestaurante and r.codigo = ? " + 
						"group by h.diaSemana " + 
						"order by h.diaSemana;";

				PreparedStatement preparedStatement = connection.prepareStatement(getHorarios);

				preparedStatement.setInt(1, restaurante.getCodigo());

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				Horario horario = null;
				while (result.next()) {
					horario = new Horario(result.getTime("horaInicio"), result.getTime("horaFim"),
							DiaSemana.valueOf(result.getString("diaSemana")));
					horarios.add(horario);

				}
				System.out.println("Commited");
				return horarios;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return horarios;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return horarios;
		}
	}

	public ArrayList<Ementa> getEmentasFromRestauranteInTime(Restaurante restaurante, String time, DiaSemana dia) {
		System.out.println("RestauranteDAO -> Start getEmentasFromRestauranteInTime");
		ArrayList<Ementa> ementas = new ArrayList<>();

		try {

			try {
				String getEmentas = "select h.codigoRestaurante, e.id, e.designacao, h.horaInicio, h.horaFim, h.diaSemana "
						+ "from ementa as e " + "inner join horario as h "
						+ "on h.idEmenta = e.id and h.horaInicio < ? and h.horaFim > ? and h.diaSemana=? and h.codigoRestaurante=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getEmentas);

				Date date = new SimpleDateFormat("HH:mm").parse(time);
				time = new SimpleDateFormat("HH:mm").format(date);

				preparedStatement.setString(1, time);
				preparedStatement.setString(2, time);
				preparedStatement.setObject(3, dia.toString());
				preparedStatement.setInt(4, restaurante.getCodigo());

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				Ementa ementa = null;
				while (result.next()) {
					ementa = new Ementa(result.getInt("id"), result.getInt("codigoRestaurante"),
							result.getString("designacao"));
					ementas.add(ementa);

				}
				System.out.println("Commited");
				return ementas;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return ementas;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ementas;
		}
	}
	
	public Morada getMorada(Restaurante restaurante) {
		System.out.println("RestauranteDAO -> Start getMorada");
		Morada morada = null;
		try {

			try {
				String getMorada = "select m.codigo, m.codigoPostal, m.zonaPostal, m.designacao from morada as m" + 
						" inner join restaurante as r on m.codigo=r.codigoMorada and m.codigoPostal=r.codigoArea and m.zonaPostal=r.zonaArea and r.codigo=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getMorada);

				preparedStatement.setInt(1, restaurante.getCodigo());

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				
				while (result.next()) {
					morada = new Morada(result.getInt("codigo"), result.getInt("codigoPostal"), result.getString("zonaPostal"), result.getString("designacao"));
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
	
	public Recurso getRecursoFromRestaurante(Restaurante restaurante) {
		System.out.println("RestauranteDAO -> Start getRecursoFromRestaurante");
		Recurso recurso = null;
		try {

			try {
				String getMorada = "select * from recursos_restaurante where codigoRestaurante=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getMorada);

				preparedStatement.setInt(1, restaurante.getCodigo());

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				
				while (result.next()) {
					recurso = new Recurso(result.getInt("idRecurso")); 
					
					RecursoDAO recursoDAO = new RecursoDAO(); 
					recurso = recursoDAO.get(recurso);
				}
				System.out.println("Commited");
				return recurso;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return recurso;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return recurso;
		}
	}
	
	public Restaurante findByNome(String nome) {
		System.out.println("RestauranteDAO -> Start findByNome");
		Restaurante restaurante = null;
		try {

			try {
				String getRestaurante = "select * from restaurante where nome=?; ";

				PreparedStatement preparedStatement = connection.prepareStatement(getRestaurante);

				preparedStatement.setString(1, nome);

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					restaurante = new Restaurante(
							result.getInt("codigo"), 
							result.getString("nome"), 
							result.getString("email"), 
							result.getInt("telefone"), 
							result.getInt("codigoMorada"), 
							result.getInt("codigoArea"), 
							result.getString("zonaArea"));
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
	
	
	public Restaurante getRestauranteFromCodigo(int codigoRestaurante) {
		System.out.println("RestauranteDAO -> Start getRestauranteFromCodigo");
		Restaurante restaurante = null;

		try {

			try {
				String getRestaurante = "select * from restaurante where codigo=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getRestaurante);

				preparedStatement.setInt(1, codigoRestaurante);

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

	public static void main(String[] args) {
		Restaurante restaurante = new Restaurante("Teste", "teste@gmail.com", 911039236, 2, 1700, "120");
		RestauranteDAO restauranteDAO = new RestauranteDAO();

		restauranteDAO.create(restaurante);

		restaurante.setCodigo(2);
		restaurante.setNome("Outro Nome");

		restauranteDAO.update(restaurante);

		System.out.println(restauranteDAO.get(restaurante));

		ArrayList<Restaurante> restaurantes = restauranteDAO.listAll();

		Restaurante rest;
		for (int i = 0; i < restaurantes.size(); i++) {
			rest = restaurantes.get(i);
			System.out.println(rest);
			System.out.println(restauranteDAO.getMorada(rest));
		}

		System.out.println(restauranteDAO.delete(restaurante));

		ArrayList<Horario> horarios = restauranteDAO
				.getHorariosFromRestaurante(new Restaurante(1, "Teste", "Teste", 911039236, 3, 3, "003"));

		for (int i = 0; i < horarios.size(); i++) {
			System.out.println(horarios.get(i));
		}

		DiaSemana diaSemana = DiaSemana.Seg;

		ArrayList<Ementa> ementas = restauranteDAO.getEmentasFromRestauranteInTime(restaurante, "11:00", diaSemana);

		for (int i = 0; i < ementas.size(); i++) {
			System.out.println(ementas.get(i));
		}
		

	}

	public ArrayList<Caracteristica> getCaracteristicas(int codigoRestaurante) {
		System.out.println("RestauranteDAO -> Start getCaracteristicas");
		ArrayList<Caracteristica> caracteristicas = new ArrayList<>();

		try {

			try {
				String getHorarios = "select * from caracteristica as c" + 
						" inner join caracteristicas_mesa as cm on c.numero = cm.numeroCaracteristica and cm.codigoRestaurante=?" + 
						" group by c.caracteristica;";

				PreparedStatement preparedStatement = connection.prepareStatement(getHorarios);

				preparedStatement.setInt(1, codigoRestaurante);

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				Caracteristica caracteristica = null;
				while (result.next()) {
					caracteristica = new Caracteristica(
							result.getInt("numero"), 
							result.getString("caracteristica")); 
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

}
