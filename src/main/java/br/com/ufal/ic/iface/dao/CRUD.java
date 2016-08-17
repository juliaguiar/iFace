package br.com.ufal.ic.iface.dao;

import java.util.List;

public interface CRUD<T>{
	
	
	public void addInstance(T instance);
	
	public void updateInstance(T instance);
	
	public void removeInstance(T instance);
	
	public void removeInstance(int identify);
	
	public List<T> getAllInstances();


}