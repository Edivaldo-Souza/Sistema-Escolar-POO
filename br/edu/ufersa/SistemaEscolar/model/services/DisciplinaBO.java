package br.edu.ufersa.SistemaEscolar.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import br.edu.ufersa.SistemaEscolar.model.entities.Disciplina;
import br.edu.ufersa.SistemaEscolar.model.entities.Professor;
import br.edu.ufersa.SistemaEscolar.model.dao.StandardDAO;
import br.edu.ufersa.SistemaEscolar.model.dao.DisciplinaDAO;
import br.edu.ufersa.SistemaEscolar.api.dto.DisciplinaDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.ProfessorDTO;

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
	

	public List<DisciplinaDTO> listAll(){
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
	
	public List<DisciplinaDTO> listByName(DisciplinaDTO entity){
		Disciplina disciplina = new Disciplina();
		disciplina.converter(entity);
		ResultSet rs = dao.findBySpecifiedField(disciplina,"nome");
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
	
	public DisciplinaDTO findByCod(String cod) {
		Disciplina disciplina = new Disciplina();
		disciplina.setCodigo(cod);
		disciplina.setNome("0");
		ResultSet rs = dao.findBySpecifiedField(disciplina,"codigo");
		try {
			DisciplinaDTO dis = new DisciplinaDTO();
			while(rs.next()) {
				dis.setNome(rs.getString("nome"));
				dis.setCodigo(rs.getString("codigo"));
				
			}
			return dis;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
