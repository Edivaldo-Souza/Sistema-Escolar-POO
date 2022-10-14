package br.edu.ufersa.SistemaEscolar.model.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.ufersa.SistemaEscolar.model.entities.Aluno;
import br.edu.ufersa.SistemaEscolar.model.entities.ResultadoTurma;

public class ResultadoTurmaDAO extends StandardDAO<ResultadoTurma> {
	@Override
	public boolean insert(ResultadoTurma entity) {
		String sql = "insert into tabela_resultadoTurma (cod_disciplina, nota1, nota2, nota3, media, frequencia, mat_aluno) values (?,?,?,?,?,?,?);";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, entity.getDisciplina().getCodigo());
			ps.setFloat(2, entity.getNotas()[0]);
			ps.setFloat(3, entity.getNotas()[1]);
			ps.setFloat(4, entity.getNotas()[2]);
			ps.setFloat(5, entity.getMedia());
			ps.setFloat(6, entity.getFrequencia());
			ps.setString(7, entity.getAluno().getMatricula());
			ps.execute();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(ResultadoTurma entity) {
		String sql = "delete from tabela_resultadoTurma where mat_aluno=?;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, entity.getAluno().getMatricula());
			ps.execute();
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean alter(ResultadoTurma entity) {
		String sql = "update tabela_resultadoTurma set cod_disciplina=?, nota1=?, nota2=?, nota3=?, media=?, frequencia=? where mat_aluno=?;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, entity.getDisciplina().getCodigo());
			ps.setFloat(2, entity.getNotas()[0]);
			ps.setFloat(3, entity.getNotas()[1]);
			ps.setFloat(4, entity.getNotas()[2]);
			ps.setFloat(5, entity.getMedia());
			ps.setFloat(6, entity.getFrequencia());
			ps.setString(7, entity.getAluno().getMatricula());
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

}
