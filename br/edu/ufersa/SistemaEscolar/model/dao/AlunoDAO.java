package br.edu.ufersa.SistemaEscolar.model.dao;
import br.edu.ufersa.SistemaEscolar.api.dto.*;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.edu.ufersa.SistemaEscolar.model.entities.Aluno;

public class AlunoDAO extends StandardDAO<Aluno>{
	public boolean insert(Aluno e) {
		String sql = "insert into tabela_aluno (matricula,nome,usuario,senha) values (?,?,?,?);";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, e.getMatricula());
			ps.setString(2, e.getNome());
			ps.setString(3, e.getUsuario());
			ps.setString(4, e.getSenha());
			ps.execute();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			return false;
		}
		
		sql = "insert into tabela_endereco_aluno (rua,bairro,numero,mat_aluno) values (?,?,?,?);";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, e.getEndereco().getRua());
			ps.setString(2, e.getEndereco().getBairro());
			ps.setInt(3, e.getEndereco().getNumero());
			ps.setString(4, e.getMatricula());
			ps.execute();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean delete(Aluno e) {
		String sql = "delete from tabela_aluno where matricula=?;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, e.getMatricula());
			ps.execute();
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		
		sql = "delete from tabela_endereco_aluno where mat_aluno=?;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, e.getMatricula());
			ps.execute();
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean alter(Aluno e) {
		String sql = "update tabela_aluno set nome=?, usuario=?, senha=? where matricula=?;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, e.getNome());
			ps.setString(2, e.getUsuario());
			ps.setString(3, e.getSenha());
			ps.setString(4, e.getMatricula());
			ps.execute();
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		
		sql = "update tabela_endereco_aluno set rua=?, bairro=?, numero=? where mat_aluno=?;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, e.getEndereco().getRua());
			ps.setString(2, e.getEndereco().getBairro());
			ps.setInt(3, e.getEndereco().getNumero());
			ps.setString(4, e.getMatricula());
			ps.execute();
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		return true;
	}
 
	
	public ResultSet findAll() {
		String sql = "SELECT * FROM tabela_aluno;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			return rs;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}
	
	public ResultSet findBySpecifiedField(Aluno e, String field) {
		String sql = "SELECT * FROM tabela_aluno where "+field+"=?;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			switch(field) {
			case "matricula":
				ps.setString(1, e.getMatricula());
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
	public ResultSet findByLogin(AlunoDTO e, String field) {
		String sql = "SELECT * FROM tabela_aluno where "+field+"=?;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			switch(field) {
			case "usuario":
				ps.setString(1, e.getUsuario());
				break;
			case "senha":
				ps.setString(1, e.getSenha());
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
