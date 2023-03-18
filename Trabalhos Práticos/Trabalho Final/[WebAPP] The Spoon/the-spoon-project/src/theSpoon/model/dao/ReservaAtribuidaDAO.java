package theSpoon.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import theSpoon.model.entities.EstadoReserva;
import theSpoon.model.entities.Reserva;
import theSpoon.model.entities.ReservaAtribuida;
import thsSpoon.model.database.DBConnection;

public class ReservaAtribuidaDAO implements DAO<ReservaAtribuida> {

	Connection connection = DBConnection.getConnection();

	@Override
	public ReservaAtribuida create(ReservaAtribuida entity) {
		System.out.println("ReservaAtribuidaDAO -> Start create");

		try {
			connection.setAutoCommit(false);

			String insertReservaAtribuida = "insert into reservas_atribuidas (numeroReserva, codigoRestaurante, numeroFuncionario, numeroMesa, estado, dataHora) values (?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(insertReservaAtribuida);

			preparedStatement.setInt(1, entity.getNumeroReserva());
			preparedStatement.setInt(2, entity.getCodigoRestaurante());
			preparedStatement.setInt(3, entity.getNumeroFuncionario());
			preparedStatement.setObject(4, entity.getNumeroMesa()==0 ? null : entity.getNumeroMesa());
			preparedStatement.setString(5, entity.getEstado().toString());
			preparedStatement.setObject(6, entity.getDataAlteracaoEstado());

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
	public ReservaAtribuida update(ReservaAtribuida entity) {
		System.out.println("ReservaAtribuidaDAO -> Start update");

		try {
			connection.setAutoCommit(false);

			try {
				String updateReservaAtribuida = "update reservas_atribuidas set numeroMesa=?, estado=? where numeroReserva=? and codigoRestaurante=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(updateReservaAtribuida);

				preparedStatement.setInt(1, entity.getNumeroMesa());
				preparedStatement.setString(2, entity.getEstado().toString());
				preparedStatement.setInt(3, entity.getNumeroReserva());
				preparedStatement.setInt(4, entity.getCodigoRestaurante());

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
	public ReservaAtribuida get(ReservaAtribuida entity) {
		System.out.println("ReservaAtribuidaDAO -> Start get");

		ReservaAtribuida reservaAtribuida = null;
		try {

			try {
				String getReservaAtribuida = "select * from reservas_atribuidas where numeroReserva=? and codigoRestaurante=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getReservaAtribuida);

				preparedStatement.setInt(1, entity.getNumeroReserva());
				preparedStatement.setInt(2, entity.getCodigoRestaurante());

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					reservaAtribuida = new ReservaAtribuida(
												result.getInt("numeroReserva"),
												result.getInt("codigoRestaurante"), 
												result.getInt("numeroFuncionario"),
												result.getInt("numeroMesa"),
												EstadoReserva.valueOf(result.getString("estado")),
												result.getDate("dataHora"));
				}
				System.out.println("Commited");
				return reservaAtribuida;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return reservaAtribuida;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return reservaAtribuida;
		}
	}

	@Override
	public boolean delete(ReservaAtribuida entity) {
		System.out.println("ReservaAtribuidaDAO -> Start delete");

		try {
			connection.setAutoCommit(false);

			try {
				String deleteReservaAtribuida = "delete from reservas_atribuidas where numeroReserva=? and codigoRestaurante=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(deleteReservaAtribuida);

				preparedStatement.setInt(1, entity.getNumeroReserva());
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
	public ArrayList<ReservaAtribuida> listAll() {
		System.out.println("ReservaAtribuidaDAO -> Start get");

		ArrayList<ReservaAtribuida> reservasAtribuidas = new ArrayList<>();
		try {

			try {
				String getReservaAtribuida = "select * from reservas_atribuidas;";

				PreparedStatement preparedStatement = connection.prepareStatement(getReservaAtribuida);

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				ReservaAtribuida reservaAtribuida = null;
				while (result.next()) {
					reservaAtribuida = new ReservaAtribuida(
												result.getInt("numeroReserva"),
												result.getInt("codigoRestaurante"), 
												result.getInt("numeroFuncionario"),
												result.getInt("numeroMesa"),
												EstadoReserva.valueOf(result.getString("estado")),
												result.getDate("dataHora"));
					reservasAtribuidas.add(reservaAtribuida);
				}
				System.out.println("Commited");
				return reservasAtribuidas;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return reservasAtribuidas;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return reservasAtribuidas;
		}
	}
	
	public static void main(String[] args) {
		ReservaAtribuidaDAO reservaAtribuidaDAO = new ReservaAtribuidaDAO();

		ReservaAtribuida reservaAtribuidaAceite, reservaAtribuidaRecusada;
		
		reservaAtribuidaAceite = new ReservaAtribuida(8, 4, 5, 2, EstadoReserva.aceite, new Date());
		reservaAtribuidaRecusada = new ReservaAtribuida(4, 3, 24, EstadoReserva.recusado, new Date());
		
		System.out.println(reservaAtribuidaDAO.create(reservaAtribuidaAceite));
		System.out.println(reservaAtribuidaDAO.create(reservaAtribuidaRecusada));

		ReservaAtribuida res = reservaAtribuidaDAO.get(reservaAtribuidaAceite);
		System.out.println(res);

		ArrayList<ReservaAtribuida> reservasAtribuidas = reservaAtribuidaDAO.listAll();

		for (ReservaAtribuida r : reservasAtribuidas) {
			System.out.println(r);
		}

		System.out.println(reservaAtribuidaDAO.delete(reservaAtribuidaAceite));
		System.out.println(reservaAtribuidaDAO.delete(reservaAtribuidaRecusada));
	}

}
