package theSpoon.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Date;

import theSpoon.model.database.DBConnection;
import theSpoon.model.entities.DiaSemana;
import theSpoon.model.entities.Ementa;
import theSpoon.model.entities.Funcionario;
import theSpoon.model.entities.Horario;

public class HorarioDAO implements DAO<Horario>{
	
	Connection connection = DBConnection.getConnection();
	
	@Override
	public Horario create(Horario entity) {
		System.out.println("HorarioDAO -> Start create");

		try {
			connection.setAutoCommit(false);

			String insertHorario = "insert into horario (horaInicio, horaFim, diaSemana, idEmenta, codigoRestaurante) values (?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(insertHorario);

			preparedStatement.setObject(1, entity.getHoraInicio());
			preparedStatement.setObject(2, entity.getHoraFim());
			preparedStatement.setString(3, entity.getDiaSemana().toString());
			preparedStatement.setInt(4, entity.getIdEmenta());
			preparedStatement.setInt(5, entity.getCodigoRestaurante());

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
	public Horario update(Horario entity) {
		System.out.println("HorarioDAO -> Start update");

		try {
			connection.setAutoCommit(false);

			try {
				String updateHorario = "update horario set horaInicio=?, horaFim=?, diaSemana=?, idEmenta=? where horaInicio=? and horaFim=? and diaSemana=? and idEmenta=? and codigoRestaurante=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(updateHorario);

				preparedStatement.setObject(1, entity.getHoraInicio());
				preparedStatement.setObject(2, entity.getHoraFim());
				preparedStatement.setString(3, entity.getDiaSemana().toString());
				preparedStatement.setInt(4, entity.getIdEmenta());
				preparedStatement.setObject(5, entity.getHoraInicio());
				preparedStatement.setObject(6, entity.getHoraFim());
				preparedStatement.setString(7, entity.getDiaSemana().toString());
				preparedStatement.setInt(8, entity.getIdEmenta());
				preparedStatement.setInt(9, entity.getCodigoRestaurante());

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
	public Horario get(Horario entity) {
		System.out.println("HorarioDAO -> Start get");
		Horario horario = null;

		try {

			try {
				String getHorario = "select * from horario where diaSemana=? and idEmenta=? and codigoRestaurante=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getHorario);

				preparedStatement.setString(1, entity.getDiaSemana().toString());
				preparedStatement.setInt(2, entity.getIdEmenta());
				preparedStatement.setInt(3, entity.getCodigoRestaurante());

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					horario = new Horario(result.getTime("horaInicio"), result.getTime("horaFim"), DiaSemana.valueOf(result.getString("diaSemana")),
							result.getInt("idEmenta"), result.getInt("codigoRestaurante"));

				}
				System.out.println("Commited");
				return horario;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return horario;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return horario;
		}
		
	}

	@Override
	public boolean delete(Horario entity) {
		System.out.println("HorarioDAO -> Start delete");

		try {
			connection.setAutoCommit(false);

			try {
				String deleteHorario = "delete from horario where diaSemana=? and idEmenta=? and codigoRestaurante=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(deleteHorario);

				preparedStatement.setString(1, entity.getDiaSemana().toString());
				preparedStatement.setInt(2, entity.getIdEmenta());
				preparedStatement.setInt(3, entity.getCodigoRestaurante());

				System.out.println(preparedStatement.toString());
				int result = preparedStatement.executeUpdate();

				connection.commit();
				return (result == 1 ? true : false);

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
	public ArrayList<Horario> listAll() {
		System.out.println("HorarioDAO -> Start listAll");
		ArrayList<Horario> horarios = new ArrayList<>();

		try {

			try {
				String getHorario = "select * from horario;";

				PreparedStatement preparedStatement = connection.prepareStatement(getHorario);

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();
				
				Horario horario = null;
				while (result.next()) {
					horario = new Horario(result.getTime("horaInicio"), result.getTime("horaFim"), DiaSemana.valueOf(result.getString("diaSemana")),
							result.getInt("idEmenta"), result.getInt("codigoRestaurante"));
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
	
	public static void main(String[] args) {
		HorarioDAO horarioDAO = new HorarioDAO();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Horario horario;
		try {
			horario = new Horario(sdf.parse("12/03/2022 10:00"), sdf.parse("12/03/2022 16:00"), DiaSemana.Qui, 3, 1);
			
			horarioDAO.create(horario);
			
			Horario car = horarioDAO.get(horario);
			System.out.println(car);

			ArrayList<Horario> horarios = horarioDAO.listAll();

			for (Horario c : horarios) {
				System.out.println(c);
			}

			System.out.println(horarioDAO.delete(horario));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // TODO

		

	}
	

}
