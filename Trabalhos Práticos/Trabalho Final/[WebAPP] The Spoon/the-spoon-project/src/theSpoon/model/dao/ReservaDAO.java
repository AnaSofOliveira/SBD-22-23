package theSpoon.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import theSpoon.model.database.DBConnection;
import theSpoon.model.entities.Mesa;
import theSpoon.model.entities.Reserva;

public class ReservaDAO implements DAO<Reserva> {

	Connection connection = DBConnection.getConnection();

	@Override
	public Reserva create(Reserva entity) {
		System.out.println("ReservaDAO -> Start create");

		try {
			connection.setAutoCommit(false);

			String insertReserva = "insert into reserva (codigoRestaurante, dataHoraMarcacao, numeroCliente, nroPessoas, dataHora) values (?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(insertReserva);

			preparedStatement.setInt(1, entity.getCodigoRestaurante());
			preparedStatement.setObject(2, entity.getDataMarcacao());
			preparedStatement.setInt(3, entity.getNumeroCliente());
			preparedStatement.setInt(4, entity.getNroPessoas());
			preparedStatement.setObject(5, entity.getDataPedidoReserva());

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
	public Reserva update(Reserva entity) {
		System.out.println("ReservaDAO -> Start update");

		try {
			connection.setAutoCommit(false);

			try {
				String updateReserva = "update reserva set dataHoraMarcacao=?, nroPessoas=? where numero=? and codigoRestaurante=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(updateReserva);

				preparedStatement.setObject(1, entity.getDataMarcacao());
				preparedStatement.setInt(2, entity.getNroPessoas());
				preparedStatement.setInt(3, entity.getNumero());
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
	public Reserva get(Reserva entity) {
		System.out.println("ReservaDAO -> Start get");

		Reserva reserva = null;
		try {

			try {
				String getReserva = "select * from reserva where numero=? and codigoRestaurante=? and numeroCliente=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getReserva);

				preparedStatement.setInt(1, entity.getNumero());
				preparedStatement.setInt(2, entity.getCodigoRestaurante());
				preparedStatement.setInt(3, entity.getNumeroCliente());

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					reserva = new Reserva(result.getInt("numero"), result.getInt("codigoRestaurante"),
							result.getDate("dataHoraMarcacao"), result.getInt("numeroCliente"),
							result.getInt("nroPessoas"), result.getDate("dataHora"));
				}
				System.out.println("Commited");
				return reserva;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return reserva;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return reserva;
		}
	}

	@Override
	public boolean delete(Reserva entity) {
		System.out.println("ReservaDAO -> Start delete");

		try {
			connection.setAutoCommit(false);

			try {
				String deleteReserva = "delete from reserva where numero=? and codigoRestaurante=? and numeroCliente=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(deleteReserva);

				preparedStatement.setInt(1, entity.getNumero());
				preparedStatement.setInt(2, entity.getCodigoRestaurante());
				preparedStatement.setInt(3, entity.getNumeroCliente());

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
	public ArrayList<Reserva> listAll() {
		System.out.println("ReservaDAO -> Start get");

		ArrayList<Reserva> reservas = new ArrayList<>();

		try {
			try {
				String getReserva = "select * from reserva;";

				PreparedStatement preparedStatement = connection.prepareStatement(getReserva);

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				Reserva reserva = null;
				while (result.next()) {
					reserva = new Reserva(result.getInt("numero"), result.getInt("codigoRestaurante"),
							result.getDate("dataHoraMarcacao"), result.getInt("numeroCliente"),
							result.getInt("nroPessoas"), result.getDate("dataHora"));
					reservas.add(reserva);
				}
				System.out.println("Commited");
				return reservas;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return reservas;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return reservas;
		}
	}

	public static void main(String[] args) {
		ReservaDAO reservaDAO = new ReservaDAO();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Reserva reserva;
		try {
			reserva = new Reserva(4, sdf.parse("10/03/2023 20:00"), 4, 20, new Date());

			System.out.println(reservaDAO.create(reserva));

			reserva.setNumero(5);
			Reserva res = reservaDAO.get(reserva);
			System.out.println(res);

			ArrayList<Reserva> reservas = reservaDAO.listAll();

			for (Reserva r : reservas) {
				System.out.println(r);
			}

			System.out.println(reservaDAO.delete(reserva));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
