package br.edu.ufersa.SistemaEscolar.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.SistemaEscolar.model.entities.Disciplina;
import br.edu.ufersa.SistemaEscolar.model.dao.StandardDAO;
import br.edu.ufersa.SistemaEscolar.model.dao.DisciplinaDAO;



public  class DisciplinaBO{
	StandardDAO<Disciplina> dao = new DisciplinaDAO();
	
	public boolean insert(Disciplina e) {
		ResultSet rs = dao.findBySpecifiedField(e, "codigo");
		try {
			if(rs != null && !(rs.next())) {
				return dao.insert(e);
			}
			else return false;
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	
	
	
	public boolean delete(Disciplina e) {
		ResultSet rs = dao.findBySpecifiedField(e, "codigo");
		try {
			if((rs != null) && (rs.next())) {
				return dao.delete(e);
			}
			else return false;
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	
	
	
	public boolean alter( Disciplina e) {
		ResultSet rs = dao.findBySpecifiedField(e, "codigo");
		try {
			if(rs != null && (rs.next())) {
				return dao.alter(e);
			}
			else return false;
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	


	}
