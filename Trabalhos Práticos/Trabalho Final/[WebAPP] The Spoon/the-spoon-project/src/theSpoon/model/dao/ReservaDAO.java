package theSpoon.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import theSpoon.model.database.DBConnection;
import theSpoon.model.entities.Caracteristica;
import theSpoon.model.entities.Cliente;
import theSpoon.model.entities.Item;
import theSpoon.model.entities.Mesa;
import theSpoon.model.entities.Reserva;
import theSpoon.model.entities.Restaurante;
import theSpoon.model.entities.TipoItem;

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
				String getReserva = "select * from reserva where dataHoraMarcacao=? and codigoRestaurante=? and numeroCliente=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getReserva);

				preparedStatement.setObject(1, entity.getDataMarcacao());
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
		/*try {
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
		}*/

	}

	public void addItensReserva(Reserva reserva, Map<Item, Integer> itensEscolhidos) {
		System.out.println("ReservaDAO -> Start addItensReserva");
		
		System.out.println("Reserva: " + reserva);
		System.out.println("Itens Escolhidos: " + itensEscolhidos);

		for (Map.Entry<Item, Integer> item : itensEscolhidos.entrySet()) {

			try {
				connection.setAutoCommit(false);

				String insertReserva = "insert into item_reserva (numeroReserva, codigoRestaurante, idItem, quantidade) values (?, ?, ?, ?)";

				PreparedStatement preparedStatement = connection.prepareStatement(insertReserva);

				preparedStatement.setInt(1, reserva.getNumero());
				preparedStatement.setObject(2, reserva.getCodigoRestaurante());
				preparedStatement.setInt(3, item.getKey().getId());
				preparedStatement.setInt(4, item.getValue());

				System.out.println(preparedStatement.toString());
				int result = preparedStatement.executeUpdate();

				if (result == 1) {
					connection.commit();
					System.out.println("Commited");
				}

			} catch (SQLException e) {
				try {
					connection.rollback();
					connection.setAutoCommit(true);
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				System.out.println(e.getMessage());
			}

		}
	}

	public void addCaracteristicasReserva(Reserva reserva, ArrayList<Caracteristica> caracteristicasEscolhidas) {
		System.out.println("ReservaDAO -> Start addCaracteristicasReserva");

		for (Caracteristica caracteristica : caracteristicasEscolhidas) {

			try {
				connection.setAutoCommit(false);

				String insertReserva = "insert into caracteristicas_reserva (numeroReserva, codigoRestaurante, numeroCaracteristica) values (?, ?, ?)";

				PreparedStatement preparedStatement = connection.prepareStatement(insertReserva);

				preparedStatement.setInt(1, reserva.getNumero());
				preparedStatement.setObject(2, reserva.getCodigoRestaurante());
				preparedStatement.setInt(3, caracteristica.getNumero());

				System.out.println(preparedStatement.toString());
				int result = preparedStatement.executeUpdate();

				if (result == 1) {
					connection.commit();

					System.out.println("Commited");
				}
				
			} catch (SQLException e) {
				try {
					connection.rollback();
					connection.setAutoCommit(true);
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				System.out.println(e.getMessage());
			}

		}

	}

	public Reserva getReserva(int codigoReserva) {
		System.out.println("ReservaDAO -> Start getReserva");

		Reserva reserva = null;
		try {

			try {
				String getReserva = "select * from reserva where numero=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getReserva);

				preparedStatement.setObject(1, codigoReserva);
				
				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					reserva = new Reserva(result.getInt("numero"), result.getInt("codigoRestaurante"),
							new Date(result.getTimestamp("dataHoraMarcacao").getTime()), result.getInt("numeroCliente"),
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

	public ArrayList<Item> getItensReservados(Reserva reserva) {
		System.out.println("ReservaDAO -> Start getItensReservados");

		ArrayList<Item> itensReservados = new ArrayList<>();
		Item item;
		try {

			try {
				String getReserva = "SELECT i.*, ir.quantidade FROM item as i INNER JOIN item_reserva as ir " + 
						"WHERE i.id = ir.idItem and ir.numeroReserva=? and ir.codigoRestaurante=?; ";

				PreparedStatement preparedStatement = connection.prepareStatement(getReserva);

				preparedStatement.setObject(1, reserva.getNumero());
				preparedStatement.setObject(2, reserva.getCodigoRestaurante());
				
				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					item = new Item(result.getInt("id"), result.getString("designacao"), result.getString("descricao"), TipoItem.valueOf(result.getString("tipo")), result.getInt("idRecurso"), result.getInt("quantidade"));
					itensReservados.add(item);
				}
				System.out.println("Commited");
				return itensReservados;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return itensReservados;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return itensReservados;
		}
	}

	public ArrayList<Caracteristica> getCaracteristicasReservadas(Reserva reserva) {
		System.out.println("ReservaDAO -> Start getCaracteristicasReservadas");

		ArrayList<Caracteristica> caracteristicasReservadas = new ArrayList<>();
		Caracteristica caracteristica;
		try {

			try {
				String getReserva = "SELECT c.numero, c.caracteristica FROM caracteristica as c INNER JOIN caracteristicas_reserva as cr " + 
						"WHERE c.numero = cr.numeroCaracteristica and cr.numeroReserva=? and cr.codigoRestaurante=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getReserva);

				preparedStatement.setObject(1, reserva.getNumero());
				preparedStatement.setObject(2, reserva.getCodigoRestaurante());
				
				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					caracteristica = new Caracteristica(result.getInt("numero"), result.getString("caracteristica"));
					caracteristicasReservadas.add(caracteristica);
				}
				System.out.println("Commited");
				return caracteristicasReservadas;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return caracteristicasReservadas;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return caracteristicasReservadas;
		}
	}

	public ArrayList<Reserva> getReservasFromCliente(Cliente cliente) {
		System.out.println("ReservaDAO -> Start getReservasFromCliente");

		ArrayList<Reserva> reservas = new ArrayList<>();
		Reserva reserva;
		try {

			try {
				String getReserva = "SELECT * FROM reserva WHERE numeroCliente=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getReserva);

				preparedStatement.setObject(1, cliente.getNumero());
				
				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					reserva = new Reserva(result.getInt("numero"), result.getInt("codigoRestaurante"), result.getDate("dataHoraMarcacao"), 
							result.getInt("numeroCliente"), result.getInt("nroPessoas"), result.getDate("dataHora"));
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

	public String getEstadoReserva(Reserva reserva) {
		System.out.println("ReservaDAO -> Start getEstadoReserva");

		String estado = "Pendente";
		try {

			try {
				String getReserva = "SELECT * FROM reservas_atribuidas WHERE numeroReserva=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getReserva);

				preparedStatement.setObject(1, reserva.getNumero());
				
				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					estado = result.getString("estado"); 
				}
				System.out.println("Commited");
				return estado;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return estado;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return estado;
		}
	}

	public ArrayList<Reserva> getReservasHoje(int codigoRestaurante) {
		System.out.println("ReservaDAO -> Start getReservasHoje");
		
		ArrayList<Reserva> reservas = new ArrayList<>();
		Reserva reserva;
		try {

			try {
				String getReserva = "SELECT r.numero, r.codigoRestaurante, r.dataHoraMarcacao, r.numeroCliente, r.nroPessoas, r.dataHora " + 
						"FROM reservas_atribuidas as ra " + 
						"INNER JOIN reserva as r " + 
						"WHERE ra.numeroReserva = r.numero and ra.codigoRestaurante = r.codigoRestaurante and r.codigoRestaurante=? and DATE(r.dataHoraMarcacao)=CURDATE();";

				PreparedStatement preparedStatement = connection.prepareStatement(getReserva);

				preparedStatement.setObject(1, codigoRestaurante);
				
				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					reserva = new Reserva(result.getInt("numero"), result.getInt("codigoRestaurante"), result.getTime("dataHoraMarcacao"), 
							result.getInt("numeroCliente"), result.getInt("nroPessoas"), result.getDate("dataHora"));
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

}
