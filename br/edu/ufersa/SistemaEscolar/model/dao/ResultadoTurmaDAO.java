package br.edu.ufersa.SistemaEscolar.model.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.ufersa.SistemaEscolar.model.entities.Aluno;
import br.edu.ufersa.SistemaEscolar.model.entities.ResultadoTurma;

public class ResultadoTurmaDAO extends StandardDAO<ResultadoTurma> {
	
	public boolean insert(ResultadoTurma entity, String matricula) {
		String sql = "insert into tabela_resultadoTurma (mat_aluno,cod_turma) values (?,?);";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, matricula);
			ps.setInt(2, entity.getId_turma());
			ps.execute();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(ResultadoTurma entity, Aluno entity_A) {
		String sql = "delete from tabela_resultadoTurma where mat_aluno=?;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, entity_A.getMatricula());
			ps.execute();
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		return true;
	}


	public boolean alter(ResultadoTurma entity, Aluno entity_A) {
		String sql = "update tabela_resultadoTurma set nota1=?, nota2=?, nota3=?, media=?, frequencia=?, situacao=? where mat_aluno=? and cod_turma=?;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setFloat(1, entity.getNotas()[0]);
			ps.setFloat(2, entity.getNotas()[1]);
			ps.setFloat(3, entity.getNotas()[2]);
			ps.setFloat(4, entity.getNotas()[3]);
			ps.setFloat(5, entity.getFrequencia());
			ps.setBoolean(6, entity.isAprovado());
			ps.setString(7, entity_A.getMatricula());
			ps.setInt(8, entity.getId_turma());
			
			ps.execute();
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ResultSet findAll() {
		String sql = "SELECT * FROM tabela_resultadoTurma;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			return rs;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	
	}
	
	@Override
	public ResultSet findBySpecifiedField(ResultadoTurma e,String field) {
		String sql = "SELECT * FROM tabela_resultadoTurma where "+field+"=?;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			switch(field) {
			case "cod_turma":
				ps.setInt(1, e.getId_turma());
				break;
			case "mat_aluno":
				ps.setString(1, e.getMatricula());
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
