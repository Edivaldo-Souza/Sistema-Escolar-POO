package br.edu.ufersa.SistemaEscolar.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.SistemaEscolar.model.entities.ResultadoTurma;
import br.edu.ufersa.SistemaEscolar.model.dao.StandardDAO;
import br.edu.ufersa.SistemaEscolar.model.dao.ResultadoTurmaDAO;

import java.util.List;
import java.util.ArrayList;

public class ResultadoTurmaBO implements InterfaceServices<ResultadoTurma>{
	StandardDAO<ResultadoTurma> dao = new ResultadoTurmaDAO();
	
	@Override
	public boolean insert(ResultadoTurma e) {
		ResultSet rs = dao.findBySpecifiedField(e, "mat_aluno");
		try {
			if(rs == null || !(rs.next())) {
				if(dao.insert(e)) return true;
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
	public boolean delete(ResultadoTurma e) {
		ResultSet rs = dao.findBySpecifiedField(e, "mat_aluno");
		try {
			if(rs == null || !(rs.next())) {
				if(dao.delete(e)) return true;
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
	public boolean alter(ResultadoTurma e) {
		ResultSet rs = dao.findBySpecifiedField(e, "matricula");
		try {
			if(rs == null || !(rs.next())) {
				if(dao.alter(e)) return true;
				else return false;
			}
			else return false;
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	
	
	public List<ResultadoTurma> listAll(){
		return null;
	}

}

