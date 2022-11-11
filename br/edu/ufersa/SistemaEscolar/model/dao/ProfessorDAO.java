package br.edu.ufersa.SistemaEscolar.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.SistemaEscolar.model.entities.Professor;

public class ProfessorDAO extends StandardDAO<Professor>{
	public boolean insert(Professor e) {
		String sql = "insert into tabela_professor (cpf,nome) values (?,?);";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, e.getCpf());
			ps.setString(2, e.getNome());
			ps.execute();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			return false;
		}
		
		sql = "insert into tabela_endereco_professor (rua,bairro,numero,cpf_prof) values (?,?,?,?);";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, e.getEndereco().getRua());
			ps.setString(2, e.getEndereco().getBairro());
			ps.setInt(3, e.getEndereco().getNumero());
			ps.setString(4, e.getCpf());
			ps.execute();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean delete(Professor e) {
		String sql = "delete from tabela_professor where cpf=?;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, e.getCpf());
			ps.execute();
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		
		sql = "delete from tabela_endereco_professor where cpf_prof=?;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, e.getCpf());
			ps.execute();
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean alter(Professor e) {
		String sql = "update tabela_aluno set nome=? where cpf=?;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(2, e.getNome());
			ps.setString(3, e.getCpf());
			ps.execute();
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		
		sql = "update tabela_endereco_professor set rua=?, bairro=?, numero=? where cpf_prof=?;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, e.getEndereco().getRua());
			ps.setString(2, e.getEndereco().getBairro());
			ps.setInt(3, e.getEndereco().getNumero());
			ps.setString(4, e.getCpf());
			ps.execute();
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		return true;
	}
	
	public ResultSet findAll() {
		String sql = "SELECT * FROM tabela_professor;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			return rs;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}
	
	public ResultSet findBySpecifiedField(Professor e, String field) {
		String sql = "SELECT * FROM tabela_professor where "+field+"=?;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			switch(field) {
			case "cpf":
				ps.setString(1, e.getCpf());
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
