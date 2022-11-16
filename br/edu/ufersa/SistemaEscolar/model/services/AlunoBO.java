package br.edu.ufersa.SistemaEscolar.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.SistemaEscolar.api.dto.AlunoDTO;
import br.edu.ufersa.SistemaEscolar.model.entities.Aluno;
import br.edu.ufersa.SistemaEscolar.model.dao.StandardDAO;
import br.edu.ufersa.SistemaEscolar.model.dao.AlunoDAO;
import br.edu.ufersa.SistemaEscolar.model.dao.EnderecoDAO;
import java.util.List;
import java.util.ArrayList;

public class AlunoBO implements InterfaceServices<AlunoDTO>{
	AlunoDAO dao = new AlunoDAO();
	EnderecoDAO endDAO = new EnderecoDAO();
	
	@Override
	public boolean insert(AlunoDTO e) {
		Aluno aluno = new Aluno();
		aluno.converter(e);
		dao.insert(aluno);
		return true;
	}
	
	@Override
	public boolean delete(AlunoDTO e) {
		Aluno aluno = new Aluno();
		aluno.converter(e);
		dao.delete(aluno);
		return true;
	}
	
	@Override
	public boolean alter(AlunoDTO e) {
		Aluno aluno = new Aluno();
		aluno.converter(e);
		dao.alter(aluno);
		return true;
	}
	
	
	public List<AlunoDTO> listAll(){
		List<AlunoDTO> alunos = new ArrayList<AlunoDTO>();
		ResultSet rs = dao.findAll();
		try {
			while(rs.next()) {
				AlunoDTO aluno = new AlunoDTO();
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setNome(rs.getString("nome"));
				
				alunos.add(aluno);
			}
			return alunos;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}
	
	public List<AlunoDTO> listByName(AlunoDTO entity) {
		Aluno aluno = new Aluno();
		aluno.converter(entity);
		List<AlunoDTO> alunos = new ArrayList<AlunoDTO>();
		ResultSet rs = dao.findBySpecifiedField(aluno,"nome");
		try {
			while(rs.next()) {
				AlunoDTO e = new AlunoDTO();
				e.setMatricula(rs.getString("matricula"));
				e.setNome(rs.getString("nome"));
				
				alunos.add(e);
			}
			return alunos;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}
	
	public AlunoDTO findByMatriucla(String matricula) {
		Aluno aluno = new Aluno();
		aluno.setMatricula(matricula);
		ResultSet rs = dao.findBySpecifiedField(aluno,"matricula");
		ResultSet endRs = endDAO.findByMatricula(matricula);
		try {
			AlunoDTO e = new AlunoDTO();
			while(rs.next()) {
				e.setMatricula(rs.getString("matricula"));
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

	public AlunoDTO findByLogin(AlunoDTO entity,String field) {
		ResultSet rs = dao.findByLogin(entity, field);
		AlunoDTO e = new AlunoDTO();
		try {
			while(rs.next()) {
				e.setUsuario(rs.getString("usuario"));
				e.setSenha(rs.getString("senha"));
				e.setMatricula(rs.getString("matricula"));
			}
			return e;

		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}
}
