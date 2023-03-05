package theSpoon.model.dao;

import java.util.ArrayList;


public interface DAO<E> {
	
	public boolean create(E t);
	
	public boolean update(E t);
	
	public E get(int id);
	
	public boolean delete(int id);
	
	public ArrayList<E> listAll();
	
}
	
