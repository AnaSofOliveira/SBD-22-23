package theSpoon.model.dao;

import java.util.List;

import theSpoon.model.beans.Restaurante;

public interface DAO<E> {
	
	public boolean create(E t);
	
	public boolean update(E t);
	
	public E get(Object id);
	
	public boolean delete(Object id);
	
	public List<E> listAll();
	
	public long count();
}
	
