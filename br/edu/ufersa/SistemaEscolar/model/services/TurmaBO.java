package br.edu.ufersa.SistemaEscolar.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.SistemaEscolar.model.dao.TurmaDAO;
import br.edu.ufersa.SistemaEscolar.model.entities.Turma;
import br.edu.ufersa.SistemaEscolar.api.dto.TurmaDTO;
import br.edu.ufersa.SistemaEscolar.model.dao.StandardDAO;

public class TurmaBO {
  StandardDAO<Turma> dao = new TurmaDAO();

  public void insert(TurmaDTO vo) {
	Turma turma = new Turma();
	turma.converter(vo);
    dao.insert(turma); 
  }
  
  public void insertTabelaAlunoTurma(String matricula,int id) {
	  dao.inserirTabelaAlunoTurma(matricula,id);
  }
  
  public TurmaDTO ultimaTurmaInserida() {
	  TurmaDTO t = new TurmaDTO();
	  ResultSet rs = dao.findLastTurma();
	  try {
		while(rs.next()) {
			  t.setId(rs.getInt("id"));
			  t.setCodDisciplina(rs.getString("codigoDisciplina"));
			  t.setCodProfessor(rs.getString("codigoProfessor"));
			  t.setHorario(rs.getString("horario"));
			  t.setLocal(rs.getString("local"));
			  t.setStatus(rs.getBoolean("status"));
			  
		  }
		return t;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
  }
  
  public void deletarTabelaAlunoTurma(int id) {
	  dao.deletarTabelaAlunoTurma(id);
  }

  public List<TurmaDTO> listAll() {
    List<TurmaDTO> lista = new ArrayList<TurmaDTO>();
    ResultSet rs = dao.findAll();
    try {
      while (rs.next()) {
        TurmaDTO vo = new TurmaDTO();
        vo.setId(rs.getInt("id"));
        vo.setCodDisciplina(rs.getString("codigoDisciplina"));
        vo.setCodProfessor(rs.getString("codigoProfessor"));
        vo.setHorario(rs.getString("horario"));
        vo.setLocal(rs.getString("local"));
        vo.setStatus(rs.getBoolean("status"));
        lista.add(vo);
      }
      return lista;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }
  
  public List<TurmaDTO> turmasProfessor(TurmaDTO t){
	  Turma turma = new Turma();
	  turma.converter(t);
	  List<TurmaDTO> lista = new ArrayList<TurmaDTO>();	  	  
	  ResultSet rs = dao.findBySpecifiedField(turma, "cpf");
	  try {
		  while (rs.next()) {
			  TurmaDTO to = new TurmaDTO();
			  to.setId(rs.getInt("id"));
		      to.setCodDisciplina(rs.getString("codigoDisciplina"));
		      to.setCodProfessor(rs.getString("codigoProfessor"));
		      to.setHorario(rs.getString("horario"));
		      to.setLocal(rs.getString("local"));
		      to.setStatus(rs.getBoolean("status"));
		      lista.add(to);
		  }
		  return lista;
	  }
	  catch (SQLException e) {
	      e.printStackTrace();
	      return null;
	    }
  }

  public boolean removeBySpecificField(Turma vo, String field) {
    ResultSet rs = dao.findBySpecifiedField(vo, field);
    try {
      if (rs != null && rs.next()) {
        if (dao.delete(vo) == true) {
          return true;
        } else
          return false;
      } else
        return false;
    } catch (SQLException e) {
      // TODO: handle exception
      e.printStackTrace();
      return false;
    }
  }

  public boolean alter(TurmaDTO vo) {
	Turma turma = new Turma();
	turma.converter(vo);
    dao.alter(turma);
    return true;
  }
}
