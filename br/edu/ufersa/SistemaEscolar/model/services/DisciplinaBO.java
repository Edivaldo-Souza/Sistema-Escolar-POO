package br.edu.ufersa.SistemaEscolar.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import br.edu.ufersa.SistemaEscolar.model.entities.Disciplina;
import br.edu.ufersa.SistemaEscolar.model.dao.StandardDAO;
import br.edu.ufersa.SistemaEscolar.model.dao.DisciplinaDAO;
import br.edu.ufersa.SistemaEscolar.api.dto.DisciplinaDTO;

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
	

	public List<DisciplinaDTO> selectAll(){
		ResultSet rs = dao.findAll();
		List<DisciplinaDTO> lista = new ArrayList<DisciplinaDTO>();
		try {
			while(rs.next()) {
				DisciplinaDTO dis = new DisciplinaDTO();
				dis.setNome(rs.getString("nome"));
				dis.setCodigo(rs.getString("codigo"));
				lista.add(dis);
			}
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
