package br.edu.ufersa.SistemaEscolar.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class StandardDAO<type> implements InterfaceDAO<type> {
	protected Connection connection;
	
	synchronized public Connection getConnection() {
		if(connection == null) {
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost/bd_sisescolar","root","escola123");
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}
		else return connection;
	}
	
	public void inserirTabelaAlunoTurma(String matricula, int id) {}
	public void deletarTabelaAlunoTurma(int id) {}

	@Override
	public boolean insert(type entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(type entity) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean alter(type entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public type findById(type entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet findBySpecifiedField(type entity, String field) {
		// TODO Auto-generated method stub
		return null;
	}
}
