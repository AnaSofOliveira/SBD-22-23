package theSpoon.model.dao;

import java.util.ArrayList;


public interface DAO<Entity> {
	
	public Entity create(Entity entity);
	
	public Entity update(Entity entity);
	
	public Entity get(Entity entity);
	
	public boolean delete(Entity entity);
	
	public ArrayList<Entity> listAll();
	
}
	
