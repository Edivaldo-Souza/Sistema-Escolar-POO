package br.edu.ufersa.SistemaEscolar.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;

public interface InterfaceDAO<type> {
	public Connection getConnection();
	public boolean insert(type entity);
	public boolean delete(type entity);
	public boolean alter(type entity);
	public type findById(type entity);
	public ResultSet findAll();
	public ResultSet findBySpecifiedField(type entity, String field);
}
