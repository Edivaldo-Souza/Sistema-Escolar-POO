package br.edu.ufersa.SistemaEscolar.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.SistemaEscolar.model.entities.Professor;
import br.edu.ufersa.SistemaEscolar.model.dao.StandardDAO;
import br.edu.ufersa.SistemaEscolar.model.dao.ProfessorDAO;
import br.edu.ufersa.SistemaEscolar.model.entities.Endereco;

public class ProfessorBO implements InterfaceServices<Professor>{
	StandardDAO<Professor> dao = new ProfessorDAO();
	
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

	@Override
	public List<Professor> listAll() {
		List<Professor> professores = new ArrayList<Professor>();
		ResultSet rs = dao.findAll();
		try {
			while(rs.next()) {
				Professor prof = new Professor();
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
	
	public static void main(String args[]) {
		Professor pr = new Professor("Júlio Mesquita","222.222.444-12");
		Endereco end = new Endereco("rua Asas","Bairro terra",23);
		pr.setEndereco(end);
		ProfessorBO bo = new ProfessorBO();
		bo.insert(pr);
		List<Professor> list = bo.listAll();
		for(Professor e:list) {
			System.out.println(e.getNome());
		}
	}

}
