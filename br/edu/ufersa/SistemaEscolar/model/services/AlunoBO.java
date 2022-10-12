package br.edu.ufersa.SistemaEscolar.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.SistemaEscolar.model.entities.Aluno;
import br.edu.ufersa.SistemaEscolar.model.dao.StandardDAO;
import br.edu.ufersa.SistemaEscolar.model.dao.AlunoDAO;
import java.util.List;
import java.util.ArrayList;

public class AlunoBO implements InterfaceServices<Aluno>{
	StandardDAO<Aluno> dao = new AlunoDAO();
	
	@Override
	public boolean insert(Aluno e) {
		ResultSet rs = dao.findBySpecifiedField(e, "matricula");
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
	public boolean delete(Aluno e) {
		ResultSet rs = dao.findBySpecifiedField(e, "matricula");
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
	public boolean alter(Aluno e) {
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
	
	@Override
	public List<Aluno> listAll(){
		List<Aluno> alunos = new ArrayList<Aluno>();
		ResultSet rs = dao.findAll();
		try {
			while(rs.next()) {
				Aluno aluno = new Aluno();
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

}