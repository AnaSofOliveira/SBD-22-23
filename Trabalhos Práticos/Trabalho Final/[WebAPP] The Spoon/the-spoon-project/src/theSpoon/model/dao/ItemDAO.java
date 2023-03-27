package theSpoon.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import theSpoon.model.database.DBConnection;
import theSpoon.model.entities.Item;
import theSpoon.model.entities.Recurso;
import theSpoon.model.entities.Restaurante;
import theSpoon.model.entities.TipoItem;

public class ItemDAO implements DAO<Item>{

	Connection connection = DBConnection.getConnection(); 
	
	@Override
	public Item create(Item entity) {
		System.out.println("ItemDAO -> Start create");

		try {
			connection.setAutoCommit(false);

			String insertItem = "insert into item (id, designacao, descricao, tipo, idRecurso) values (?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(insertItem);

			preparedStatement.setInt(1, entity.getId());
			preparedStatement.setString(2, entity.getDesignacao());
			preparedStatement.setString(3, entity.getDescricao());
			preparedStatement.setString(4, entity.getTipo().toString());
			preparedStatement.setInt(5, entity.getRecurso());

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
	public Item update(Item entity) {
		System.out.println("ItemDAO -> Start update");

		try {
			connection.setAutoCommit(false);

			try {
				String updateItem = "update item set designacao=?, descricao=?, tipo=?, idRecurso=? where id=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(updateItem);

				preparedStatement.setInt(1, entity.getId());

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
	public Item get(Item entity) {
		System.out.println("ItemDAO -> Start get");

		Item item = null;
		try {

			try {
				String getItem = "select * from item where id=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getItem);

				preparedStatement.setInt(1, entity.getId());

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					item = new Item(result.getInt("id"), result.getString("designacao"), result.getString("descricao"), 
							TipoItem.valueOf(result.getString("tipo")), result.getInt("idRecurso"));
				}
				System.out.println("Commited");
				return item;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return item;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return item;
		}
	}

	@Override
	public boolean delete(Item entity) {
		System.out.println("ItemDAO -> Start delete");

		try {
			connection.setAutoCommit(false);

			try {
				String deleteItem = "delete from item where id=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(deleteItem);

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
	public ArrayList<Item> listAll() {
		System.out.println("ItemDAO -> Start listAll");
		ArrayList<Item> itens = new ArrayList<>();

		try {

			try {
				String getItem = "select * from item;";

				PreparedStatement preparedStatement = connection.prepareStatement(getItem);

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();
				
				Item item = null;
				while (result.next()) {
					item = new Item(result.getInt("id"), result.getString("designacao"), result.getString("descricao"), 
							TipoItem.valueOf(result.getString("tipo")), result.getInt("idRecurso"));
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
	
	public Recurso getRecursosFromItem(Item item) {
		System.out.println("ItemDAO -> Start getRecursosFromItem");
		Recurso recurso = null;
		try {

			try {
				String getMorada = "select rm.id as idRecurso from recurso_multimedia as rm " + 
						"inner join item as i on rm.id=i.idRecurso and i.id=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getMorada);

				preparedStatement.setInt(1, item.getId());

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
	
	public static void main(String[] args) {
		ItemDAO itemDAO = new ItemDAO();

		Item item = new Item("Teste", TipoItem.prato, 3); 
		item.setDescricao("Isto � um texto de exemplo");

		itemDAO.create(item);

		Item car = itemDAO.get(item);
		System.out.println(car);

		ArrayList<Item> itens = itemDAO.listAll();

		for (Item i : itens) {
			System.out.println(i);
			System.out.println(itemDAO.getRecursosFromItem(i) + "\n");
		}

		itemDAO.delete(item);
	}

}
