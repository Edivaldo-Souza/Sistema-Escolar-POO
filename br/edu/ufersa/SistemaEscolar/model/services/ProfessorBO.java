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
import br.edu.ufersa.SistemaEscolar.api.dto.AlunoDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.ProfessorDTO;


public class ProfessorBO implements InterfaceServices<ProfessorDTO>{
	ProfessorDAO dao = new ProfessorDAO();
	StandardDAO<Turma> daoTM = new TurmaDAO();
	
	@Override
	public boolean insert(ProfessorDTO e) {
		Professor professor = new Professor();
		professor.converter(e);
		dao.insert(professor);
		return true;
	}

	@Override
	public boolean delete(ProfessorDTO e) {
		Professor professor = new Professor();
		professor.converter(e);
		dao.delete(professor);
		return true;
	}

	@Override
	public boolean alter(ProfessorDTO e) {
		Professor professor = new Professor();
		professor.converter(e);
		dao.alter(professor);
		return true;
	}

	public List<ProfessorDTO> listAll() {
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
	
	public List<ProfessorDTO> listByName(ProfessorDTO entity){
		Professor e = new Professor();
		e.converter(entity);
		List<ProfessorDTO> professores = new ArrayList<ProfessorDTO>();
		ResultSet rs = dao.findBySpecifiedField(e,"nome");
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
	
	public ProfessorDTO findByLogin(ProfessorDTO entity,String field) {
		ResultSet rs = dao.findByLogin(entity, field); 

		try {
				rs.next();
				ProfessorDTO e = new ProfessorDTO();
				e.setUsuario(rs.getString("usuario"));
				e.setSenha(rs.getString("senha"));
				return e;
		
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}
}
