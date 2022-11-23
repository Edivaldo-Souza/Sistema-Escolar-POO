package br.edu.ufersa.SistemaEscolar.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.SistemaEscolar.model.entities.Aluno;
import br.edu.ufersa.SistemaEscolar.model.entities.Professor;
import br.edu.ufersa.SistemaEscolar.model.entities.Turma;
import br.edu.ufersa.SistemaEscolar.model.dao.StandardDAO;
import br.edu.ufersa.SistemaEscolar.model.dao.TurmaDAO;
import br.edu.ufersa.SistemaEscolar.model.dao.EnderecoDAO;
import br.edu.ufersa.SistemaEscolar.model.dao.ProfessorDAO;
import br.edu.ufersa.SistemaEscolar.api.dto.AlunoDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.ProfessorDTO;


public class ProfessorBO implements InterfaceServices<ProfessorDTO>{
	ProfessorDAO dao = new ProfessorDAO();
	EnderecoDAO endDAO = new EnderecoDAO();
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
				prof.setUsuario(rs.getString("usuario"));
				prof.setSenha(rs.getString("senha"));
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
		ProfessorDTO e = new ProfessorDTO();
		try {
				while(rs.next()) {
				e.setUsuario(rs.getString("usuario"));
				e.setSenha(rs.getString("senha"));
				e.setCpf(rs.getString("cpf"));
				}
				return e;
		
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}
	
	public ProfessorDTO findByCPF(String cpf) {
		Professor professor = new Professor();
		professor.setCpf(cpf);
		ResultSet rs = dao.findBySpecifiedField(professor,"cpf");
		ResultSet endRs = endDAO.findByCpf(cpf);
		try {
			ProfessorDTO e = new ProfessorDTO();
			while(rs.next()) {
				e.setCpf(rs.getString("cpf"));
				e.setNome(rs.getString("nome"));
			}
			while(endRs.next()) {
				e.setRua(endRs.getString("rua"));
				e.setBairro(endRs.getString("bairro"));
				e.setNumeroEndereco(endRs.getInt("numero"));
			}
			return e;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}
	
}
