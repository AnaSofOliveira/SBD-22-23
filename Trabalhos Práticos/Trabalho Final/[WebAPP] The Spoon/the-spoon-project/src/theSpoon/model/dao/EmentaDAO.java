package theSpoon.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import theSpoon.model.database.DBConnection;
import theSpoon.model.entities.Ementa;
import theSpoon.model.entities.Item;
import theSpoon.model.entities.Restaurante;
import theSpoon.model.entities.TipoItem;

public class EmentaDAO implements DAO<Ementa> {

	Connection connection = DBConnection.getConnection();

	@Override
	public Ementa create(Ementa entity) {
		System.out.println("EmentaDAO -> Start create");

		try {
			connection.setAutoCommit(false);

			String insertEmenta = "insert into ementa (codigoRestaurante, designacao) values (?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(insertEmenta);

			preparedStatement.setInt(1, entity.getCodigoRestaurante());
			preparedStatement.setString(2, entity.getDesignacao());

			System.out.println(preparedStatement.toString());
			int result = preparedStatement.executeUpdate();

			if(result == 1) {
				entity = get(entity);
				connection.commit();

				System.out.println("Commited");
				return entity;
			}return null;

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
	public Ementa update(Ementa entity) {
		System.out.println("EmentaDAO -> Start update");

		try {
			connection.setAutoCommit(false);

			try {
				String updateEmenta = "update ementa set desginacao=? where id=? and codigoRestaurante=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(updateEmenta);

				preparedStatement.setInt(1, entity.getId());
				preparedStatement.setInt(2, entity.getCodigoRestaurante());

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
	public Ementa get(Ementa entity) {
		System.out.println("EmentaDAO -> Start get");

		Ementa ementa = null;
		try {

			try {
				String getEmenta = "select * from ementa where id=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getEmenta);

				preparedStatement.setInt(1, entity.getId());

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					ementa = new Ementa(result.getInt("id"), result.getInt("codigoRestaurante"),
							result.getString("designacao"));
				}
				System.out.println("Commited");
				return ementa;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return ementa;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ementa;
		}
	}

	@Override
	public boolean delete(Ementa entity) {
		System.out.println("EmentaDAO -> Start delete");

		try {
			connection.setAutoCommit(false);

			try {
				String deleteEmenta = "delete from ementa where id=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(deleteEmenta);

				preparedStatement.setInt(1, entity.getId());

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
	public ArrayList<Ementa> listAll() {
		System.out.println("EmentaDAO -> Start listAll");
		ArrayList<Ementa> ementas = new ArrayList<>();

		try {

			try {
				String getEmenta = "select * from ementa;";

				PreparedStatement preparedStatement = connection.prepareStatement(getEmenta);

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
	
	public ArrayList<Item> getItensFromEmenta(Ementa ementa){
		System.out.println("EmentaDAO -> Start getItensFromEmenta");
		ArrayList<Item> itens = new ArrayList<>();

		try {

			try {
				String getItens = "select * from item_ementa as ie" + 
						" inner join ementa as e on ie.idEmenta=e.id and e.id=?" + 
						" inner join item as i on ie.idItem=i.id;";

				PreparedStatement preparedStatement = connection.prepareStatement(getItens);

				preparedStatement.setInt(1, ementa.getId());
				
				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();
				
				Item item = null;
				while (result.next()) {
					item = new Item(
							result.getInt("id"), 
							result.getString("designacao"),
							result.getString("descricao"), 
							TipoItem.valueOf(result.getString("tipo")), 
							result.getInt("idRecurso"));
					itens.add(item);
				}
				System.out.println("Commited");
				return itens;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return itens;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return itens;
		}
	}

	public Ementa getEmentaInTime(Restaurante restaurante, String diaSemana, String time) {
		System.out.println("EmentaDAO -> Start getEmentaInTime");
		
		System.out.println(time);
					

		Ementa ementa = null;
		try {

			try {
				String getEmenta = "select * from ementa as e " + 
						"inner join horario as h on e.id = h.idEmenta and h.codigoRestaurante=? and h.horaInicio<? and h.horaFim>? and h.diaSemana=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getEmenta);

				preparedStatement.setInt(1, restaurante.getCodigo());
				preparedStatement.setString(2, time);
				preparedStatement.setString(3, time);
				preparedStatement.setString(4, diaSemana);
				
				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					ementa = new Ementa(result.getInt("id"), result.getInt("codigoRestaurante"),
							result.getString("designacao"));
				}
				System.out.println("Commited");
				return ementa;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return ementa;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ementa;
		}
		
		
		
		
		
		// TODO To be implemented
	}
	
	public static void main(String[] args) {
		EmentaDAO ementaDAO = new EmentaDAO();

		Ementa ementa = new Ementa(3, "Teste"); 

		ementaDAO.create(ementa);

		Ementa car = ementaDAO.get(ementa);
		System.out.println(car);

		ArrayList<Ementa> ementas = ementaDAO.listAll();

		for (Ementa c : ementas) {
			System.out.println(c);
			System.out.println(ementaDAO.getItensFromEmenta(c));
		}

		ementaDAO.delete(ementa);
	}

}
