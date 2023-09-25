package theSpoon.model.dao;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import java.sql.Blob;

import theSpoon.model.database.DBConnection;
import theSpoon.model.entities.Ementa;
import theSpoon.model.entities.Item;
import theSpoon.model.entities.Recurso;
import theSpoon.model.entities.Restaurante;

public class RecursoDAO implements DAO<Recurso> {

	Connection connection = DBConnection.getConnection();

	@Override
	public Recurso create(Recurso entity) {
		System.out.println("RecursoDAO -> Start create");

		try {
			connection.setAutoCommit(false);

			String insertRecurso = "insert into recurso_multimedia (nome, extensao, conteudo) values (?, ?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(insertRecurso);

			String caminho = entity.getPath() + "/" + entity.getNome().replace(" ", "_") + "." + entity.getExtensao();

			preparedStatement.setString(1, entity.getNome().replace(" ", "_"));
			preparedStatement.setString(2, entity.getExtensao());
			preparedStatement.setBinaryStream(3, new FileInputStream(new File(caminho)));

			System.out.println(preparedStatement.toString());
			int result = preparedStatement.executeUpdate();

			if (result == 1) {
				entity = get(entity);
				connection.commit();

				System.out.println("Commited");
				return entity;
			}
			return null;

		} catch (SQLException | FileNotFoundException e) {
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
	public Recurso update(Recurso entity) {
		System.out.println("RecursoDAO -> Start update");

		try {
			connection.setAutoCommit(false);

			try {
				String updateRecurso = "update recurso_multimedia set nome=?, extensao=?, conteudo=? where id=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(updateRecurso);

				String caminho = entity.getPath() + "/" + entity.getNome().replace(" ", "_") + "."
						+ entity.getExtensao();

				preparedStatement.setString(1, entity.getNome().replace(" ", "_"));
				preparedStatement.setString(2, entity.getExtensao());
				preparedStatement.setBinaryStream(3, new FileInputStream(new File(caminho)));
				preparedStatement.setInt(4, entity.getId());

				System.out.println(preparedStatement.toString());
				int result = preparedStatement.executeUpdate();

				connection.commit();
				connection.setAutoCommit(true);

				System.out.println("Commited");

				return result == 1 ? entity : null;

			} catch (SQLException | FileNotFoundException e) {
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
	public Recurso get(Recurso entity) {
		System.out.println("RecursoDAO -> Start get");

		Recurso recurso = null;
		try {

			try {
				String getRecurso = "select * from recurso_multimedia where id=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getRecurso);

				preparedStatement.setInt(1, entity.getId());

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				FileOutputStream output;
				while (result.next()) {

					Blob image = result.getBlob("conteudo");

					InputStream inputStream = image.getBinaryStream();
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					byte[] buffer = new byte[4096];
					int bytesRead = -1;

					while ((bytesRead = inputStream.read(buffer)) != -1) {
						outputStream.write(buffer, 0, bytesRead);
					}

					byte[] imageBytes = outputStream.toByteArray();
					String base64Image = Base64.getEncoder().encodeToString(imageBytes);

					inputStream.close();
					outputStream.close();

					recurso = new Recurso(result.getInt("id"), result.getString("nome").replace(" ", "_"),
							result.getString("extensao"), "WebContent/imgs/recursos", base64Image);
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

	@Override
	public boolean delete(Recurso entity) {
		System.out.println("RecursoDAO -> Start delete");

		try {
			connection.setAutoCommit(false);

			try {
				String deleteRecurso = "delete from recurso_multimedia where id=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(deleteRecurso);

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
	public ArrayList<Recurso> listAll() {
		System.out.println("RecursoDAO -> Start listAll");

		ArrayList<Recurso> recursos = new ArrayList<>();
		try {

			try {
				String getRecurso = "select * from recurso_multimedia;";

				PreparedStatement preparedStatement = connection.prepareStatement(getRecurso);

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				Recurso recurso = null;
				while (result.next()) {

					Blob image = result.getBlob("conteudo");

					InputStream inputStream = image.getBinaryStream();
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					byte[] buffer = new byte[4096];
					int bytesRead = -1;

					while ((bytesRead = inputStream.read(buffer)) != -1) {
						outputStream.write(buffer, 0, bytesRead);
					}

					byte[] imageBytes = outputStream.toByteArray();
					String base64Image = Base64.getEncoder().encodeToString(imageBytes);

					inputStream.close();
					outputStream.close();

					recurso = new Recurso(result.getInt("id"), result.getString("nome").replace(" ", "_"),
							result.getString("extensao"), "WebContent/imgs/recursos", base64Image);
					recursos.add(recurso);
				}

				System.out.println("Commited");
				return recursos;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return recursos;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return recursos;
		}
	}

	public Recurso getRecursoFromRestaurante(Restaurante restaurante) {

		System.out.println("RecursoDAO -> Start getRecursoFromRestaurante");

		Recurso recurso = null;
		try {

			try {
				String getRecurso = "select rm.id as id, rm.nome as nome, rm.extensao as extensao, rm.conteudo as conteudo from recurso_multimedia as rm"
						+ " inner join recursos_restaurante as rr where rm.id = rr.idRecurso and rr.codigoRestaurante=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getRecurso);

				preparedStatement.setInt(1, restaurante.getCodigo());

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				FileOutputStream output;
				while (result.next()) {

					Blob image = result.getBlob("conteudo");

					InputStream inputStream = image.getBinaryStream();
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					byte[] buffer = new byte[4096];
					int bytesRead = -1;

					while ((bytesRead = inputStream.read(buffer)) != -1) {
						outputStream.write(buffer, 0, bytesRead);
					}

					byte[] imageBytes = outputStream.toByteArray();
					String base64Image = Base64.getEncoder().encodeToString(imageBytes);

					inputStream.close();
					outputStream.close();

					recurso = new Recurso(result.getInt("id"), result.getString("nome").replace(" ", "_"),
							result.getString("extensao"), "WebContent/imgs/recursos", base64Image);
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

	public Recurso getRecursoFromItemEmenta(Item item, Ementa ementa) {

		System.out.println("RecursoDAO -> Start getRecursoFromItem");

		Recurso recurso = null;
		try {

			try {
				String getRecurso = "select rm.id as id, rm.nome as nome, rm.extensao as extensao, rm.conteudo as conteudo from recurso_multimedia as rm"
						+ " inner join item_ementa as ie where rm.id = ie.idItem and ie.idItem=? and ie.idEmenta=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getRecurso);

				preparedStatement.setInt(1, item.getId());
				preparedStatement.setInt(2, ementa.getId());

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {

					Blob image = result.getBlob("conteudo");

					InputStream inputStream = image.getBinaryStream();
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					byte[] buffer = new byte[4096];
					int bytesRead = -1;

					while ((bytesRead = inputStream.read(buffer)) != -1) {
						outputStream.write(buffer, 0, bytesRead);
					}

					byte[] imageBytes = outputStream.toByteArray();
					String base64Image = Base64.getEncoder().encodeToString(imageBytes);

					inputStream.close();
					outputStream.close();

					recurso = new Recurso(result.getInt("id"), result.getString("nome").replace(" ", "_"),
							result.getString("extensao"), "WebContent/imgs/recursos", base64Image);
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

		/*
		 * Recurso recurso = new Recurso("spoon", "png", "WebContent/imgs");
		 * 
		 * RecursoDAO recursoDAO = new RecursoDAO();
		 * 
		 * System.out.println(recursoDAO.create(recurso));
		 * 
		 * recurso.setId(44); System.out.println(recursoDAO.get(recurso));
		 * 
		 * Recurso recurso2 = new Recurso(44, "logo", "png", "WebContent/imgs");
		 * recursoDAO.update(recurso2);
		 * 
		 * ArrayList<Recurso> recursos = recursoDAO.listAll();
		 * 
		 * System.out.println("\nRecursos -> " + recursos); for (Recurso r : recursos) {
		 * System.out.println(r); }
		 * 
		 * Restaurante restaurante = new Restaurante(1, "Teste", "Teste", 911039236,
		 * 1256, 4003, "003"); Recurso rec =
		 * recursoDAO.getRecursoFromRestaurante(restaurante); System.
		 * out.println(rec);*/
	}

}
