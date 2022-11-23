package br.edu.ufersa.SistemaEscolar.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.SistemaEscolar.model.entities.Aluno;
import br.edu.ufersa.SistemaEscolar.model.entities.ResultadoTurma;
import br.edu.ufersa.SistemaEscolar.model.dao.StandardDAO;
import br.edu.ufersa.SistemaEscolar.api.dto.DisciplinaDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.ResultadoTurmaDTO;
import br.edu.ufersa.SistemaEscolar.model.dao.ResultadoTurmaDAO;

import java.util.List;
import java.util.ArrayList;

public class ResultadoTurmaBO implements InterfaceServices<ResultadoTurmaDTO>{
	ResultadoTurmaDAO dao = new ResultadoTurmaDAO();
	
	@Override
	public boolean insert(ResultadoTurmaDTO e) {
		ResultadoTurma resultado = new ResultadoTurma();
		Aluno al = new Aluno();
		al.setMatricula(e.getMat_aluno());
		resultado.converter(e);
		ResultSet rs = dao.findBySpecifiedField(resultado, "cod_turma");
		try {
			if(rs == null || !(rs.next())) {
				if(dao.insert(resultado)) return true;
				else return false;
			}
			else return false;
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean delete(ResultadoTurmaDTO e) {
		ResultadoTurma resultado = new ResultadoTurma();
		resultado.converter(e);
		ResultSet rs = dao.findBySpecifiedField(resultado,"cod_turma");
		try {
			if(rs == null || !(rs.next())) {
				if(dao.delete(resultado)) return true;
				else return false;
			}
			else return false;
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean alter(ResultadoTurmaDTO e) {
		ResultadoTurma resultado = new ResultadoTurma();
		Aluno aluno = new Aluno();
		aluno.setMatricula(e.getMat_aluno());
		resultado.converter(e);
		dao.alter(resultado,aluno);
		return true;
	}
	
	public List<ResultadoTurmaDTO> listResultadoByTurmaID(int id){
		ResultadoTurma rt = new ResultadoTurma();
		rt.setId_turma(id);
		ResultSet rs = dao.findBySpecifiedField(rt,"cod_turma");
		List<ResultadoTurmaDTO> lista = new ArrayList<ResultadoTurmaDTO>();
		try {
			while(rs.next()) {
				ResultadoTurmaDTO resultado = new ResultadoTurmaDTO();
				
				resultado.setCod_disciplina(rs.getString("cod_disciplina"));
				resultado.setNota1(rs.getFloat("nota1"));
				resultado.setNota2(rs.getFloat("nota2"));
				resultado.setNota3(rs.getFloat("nota3"));
				resultado.setMedia((resultado.getNota1()+resultado.getNota2()+resultado.getNota3())/3);
				resultado.setFrequencia(rs.getInt("frequencia"));
				resultado.setMat_aluno(rs.getString("mat_aluno"));
				if(rs.getBoolean("situacao")) {
					resultado.setAprovado(SituacaoAluno.APROVADO);
				}
				else {
					resultado.setAprovado(SituacaoAluno.REPROVADO);
				}
				lista.add(resultado);
			}
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<ResultadoTurmaDTO> listResultadoByMatricula(String matricula){
		ResultadoTurma rt = new ResultadoTurma();
		rt.setMatricula(matricula);
		ResultSet rs = dao.findBySpecifiedField(rt,"mat_aluno");
		List<ResultadoTurmaDTO> lista = new ArrayList<ResultadoTurmaDTO>();
		try {
			while(rs.next()) {
				ResultadoTurmaDTO resultado = new ResultadoTurmaDTO();
				
				resultado.setCod_disciplina(rs.getString("cod_disciplina"));
				resultado.setNota1(rs.getFloat("nota1"));
				resultado.setNota2(rs.getFloat("nota2"));
				resultado.setNota3(rs.getFloat("nota3"));
				resultado.setMedia((resultado.getNota1()+resultado.getNota2()+resultado.getNota3())/3);
				resultado.setFrequencia(rs.getInt("frequencia"));
				resultado.setMat_aluno(rs.getString("mat_aluno"));
				if(rs.getBoolean("situacao")) {
					resultado.setAprovado(SituacaoAluno.APROVADO);
				}
				else {
					resultado.setAprovado(SituacaoAluno.REPROVADO);
				}
				lista.add(resultado);
			}
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<ResultadoTurma> listAll(){
		return null;
	}

}

