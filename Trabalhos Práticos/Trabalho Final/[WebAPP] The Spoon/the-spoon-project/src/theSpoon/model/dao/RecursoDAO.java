package theSpoon.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.stream.FileImageInputStream;

import theSpoon.model.entities.Mesa;
import theSpoon.model.entities.Recurso;
import thsSpoon.model.database.DBConnection;

public class RecursoDAO implements DAO<Recurso>{
	
	Connection connection = DBConnection.getConnection();

	@Override
	public Recurso create(Recurso entity) {
		System.out.println("EmentaDAO -> Start create");

		try {
			connection.setAutoCommit(false);

			String insertEmenta = "insert into recurso_multimedia (nome, extensao, conteudo) values (?, ?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(insertEmenta);

			String caminho = entity.getPath() + "/" + entity.getNome() + "." + entity.getExtensao();
			
			preparedStatement.setString(1, entity.getNome());
			preparedStatement.setString(2, entity.getExtensao());
			preparedStatement.setBinaryStream(3, new FileInputStream(new File(caminho)));
			
			System.out.println(preparedStatement.toString());
			int result = preparedStatement.executeUpdate();

			if(result == 1) {
				entity = get(entity);
				connection.commit();

				System.out.println("Commited");
				return entity;
			}return null;

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
		System.out.println("EmentaDAO -> Start update");

		try {
			connection.setAutoCommit(false);

			try {
				String updateEmenta = "update recurso_multimedia set nome=?, extensao=?, conteudo=? where id=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(updateEmenta);

				String caminho = entity.getPath() + "/" + entity.getNome() + "/" + entity.getExtensao();
				
				preparedStatement.setString(1, entity.getNome());
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
		System.out.println("EmentaDAO -> Start get");

		Recurso recurso = null;
		try {

			try {
				String getItem = "select * from recurso_multimedia where id=?;";

				PreparedStatement preparedStatement = connection.prepareStatement(getItem);

				preparedStatement.setInt(1, entity.getId());

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();
				
	            FileOutputStream output;
				while (result.next()) {
					
		            output = new FileOutputStream("WebContent/imgs/recursos/" + result.getString("nome") + "." + result.getString("extensao"));
		            
	                InputStream input = result.getBinaryStream("conteudo");
	                byte[] buffer = new byte[1024];
	                while (input.read(buffer) > 0) {
	                    output.write(buffer);
	                }

					output.close();

					recurso = new Recurso(result.getInt("id"), result.getString("nome"), result.getString("extensao"), "/imgs");
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
		System.out.println("EmentaDAO -> Start delete");

		try {
			connection.setAutoCommit(false);

			try {
				String deleteEmenta = "delete from recurso_multimedia where id=?;";

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
	public ArrayList<Recurso> listAll() {
		System.out.println("EmentaDAO -> Start listAll");

		ArrayList<Recurso> recursos = new ArrayList<>();
		try {

			try {
				String getItem = "select * from recurso_multimedia;";

				PreparedStatement preparedStatement = connection.prepareStatement(getItem);

				System.out.println(preparedStatement.toString());
				ResultSet result = preparedStatement.executeQuery();
				
	            Recurso recurso = null;
				while (result.next()) {
					
		            FileOutputStream output;
					while (result.next()) {
						
			            output = new FileOutputStream("WebContent/imgs/recursos/" + result.getString("nome") + "." + result.getString("extensao"));
			            
		                InputStream input = result.getBinaryStream("conteudo");
		                byte[] buffer = new byte[1024];
		                while (input.read(buffer) > 0) {
		                    output.write(buffer);
		                }

						recurso = new Recurso(result.getInt("id"), result.getString("nome"), result.getString("extensao"), "/imgs");
						recursos.add(recurso);
						output.close();
					}
					
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
	
	public static void main(String[] args) {
		
		  Recurso recurso = new Recurso("spoon", "png", "WebContent/imgs");
		  
		  RecursoDAO recursoDAO = new RecursoDAO();
		  
		  System.out.println(recursoDAO.create(recurso));
		  
		  recurso.setId(44);
		  System.out.println(recursoDAO.get(recurso));
		  
		  ArrayList<Recurso> recursos = recursoDAO.listAll(); 
		  
		  System.out.println("\nRecursos -> " + recursos);
		  for (Recurso r : recursos) {
				System.out.println(r);
			}

		 
	}

}
