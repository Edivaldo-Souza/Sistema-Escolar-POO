package br.edu.ufersa.SistemaEscolar.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.SistemaEscolar.api.dto.AlunoDTO;
import br.edu.ufersa.SistemaEscolar.model.entities.Aluno;
import br.edu.ufersa.SistemaEscolar.model.dao.StandardDAO;
import br.edu.ufersa.SistemaEscolar.model.dao.AlunoDAO;
import java.util.List;
import java.util.ArrayList;

public class AlunoBO implements InterfaceServices<AlunoDTO>{
	StandardDAO<Aluno> dao = new AlunoDAO();
	
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
}
