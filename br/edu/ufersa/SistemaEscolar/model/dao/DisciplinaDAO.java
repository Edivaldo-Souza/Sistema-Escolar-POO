package br.edu.ufersa.SistemaEscolar.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.edu.ufersa.SistemaEscolar.model.entities.Disciplina;

public class DisciplinaDAO extends StandardDAO<Disciplina>{
	public boolean insert(Disciplina e) {
		String sql = "insert into tabela_disciplina (codigo,nome) values (?,?);";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, e.getCodigo());
			ps.setString(2, e.getNome());
			ps.execute();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean delete(Disciplina e) {
		String sql = "delete from tabela_disciplina where codigo=?;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, e.getCodigo());
			ps.execute();
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean alter(Disciplina e) {
		String sql = "update tabela_disciplina set nome=? where codigo=?;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, e.getNome());
			ps.setString(2, e.getCodigo());
			ps.execute();
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public ResultSet findAll() {
		String sql = "SELECT * FROM tabela_disciplina;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			return rs;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}
	
	public ResultSet findBySpecifiedField(Disciplina e, String field) {
		String sql = "SELECT * FROM tabela_disciplina where "+field+"=?;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			switch(field) {
			case "codigo":
				ps.setString(1, e.getCodigo());
				break;
			case "nome":
				ps.setString(1, e.getNome());
				break;
			}
			ResultSet rs = ps.executeQuery();
			return rs;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}
}