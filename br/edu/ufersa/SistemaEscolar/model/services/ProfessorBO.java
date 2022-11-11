package br.edu.ufersa.SistemaEscolar.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.SistemaEscolar.model.entities.Professor;
import br.edu.ufersa.SistemaEscolar.model.entities.Turma;
import br.edu.ufersa.SistemaEscolar.model.dao.StandardDAO;
import br.edu.ufersa.SistemaEscolar.model.dao.TurmaDAO;
import br.edu.ufersa.SistemaEscolar.model.dao.ProfessorDAO;
import br.edu.ufersa.SistemaEscolar.api.dto.ProfessorDTO;


public class ProfessorBO implements InterfaceServices<Professor>{
	StandardDAO<Professor> dao = new ProfessorDAO();
	StandardDAO<Turma> daoTM = new TurmaDAO();
	
	@Override
	public boolean insert(Professor e) {
		ResultSet rs = dao.findBySpecifiedField(e, "cpf");
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
	public boolean delete(Professor e) {
		ResultSet rs = dao.findBySpecifiedField(e, "cpf");
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
	public boolean alter(Professor e) {
		ResultSet rs = dao.findBySpecifiedField(e, "cpf");
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

	public List<ProfessorDTO> selectAll() {
		List<ProfessorDTO> professores = new ArrayList<ProfessorDTO>();
		ResultSet rs = dao.findAll();
		try {
			while(rs.next()) {
				ProfessorDTO prof = new ProfessorDTO();
				prof.setCpf(rs.getString("cpf"));
				prof.setNome(rs.getString("nome"));
				
				professores.add(prof);
			}
			return professores;
		}catch(SQLException sqle) { 
			sqle.printStackTrace();
			return null;
		}
	}
	
}
