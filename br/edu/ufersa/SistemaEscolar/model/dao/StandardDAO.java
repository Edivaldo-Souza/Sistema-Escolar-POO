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
	private static Properties getProperties() throws IOException{
		Properties prop = new Properties();
		String configPath =  System.getProperty("user.dir") + "/src/database.properties";
		InputStream input = new FileInputStream(configPath);
		prop.load(input);
		return prop;	
	}
	
	synchronized public Connection getConnection() {
		if(connection == null) {
			try {
			Properties prop = getProperties();
			final String url = prop.getProperty("db.url"); 
			final String user = prop.getProperty("db.user"); 
			final String pass = prop.getProperty("db.pass"); 

			connection = DriverManager.getConnection(url,user,pass);
			} 
			catch(SQLException | IOException e) {
				e.printStackTrace();
			}
			return connection;
		}
		else return connection;
	}

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
