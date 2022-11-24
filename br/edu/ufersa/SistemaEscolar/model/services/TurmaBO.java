package br.edu.ufersa.SistemaEscolar.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.SistemaEscolar.model.dao.TurmaDAO;
import br.edu.ufersa.SistemaEscolar.model.entities.Turma;
import br.edu.ufersa.SistemaEscolar.api.dto.AlunoDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.TurmaDTO;
import br.edu.ufersa.SistemaEscolar.model.dao.StandardDAO;

public class TurmaBO implements InterfaceServices<TurmaDTO>{
	TurmaDAO dao = new TurmaDAO();

  public boolean insert(TurmaDTO vo) {
	Turma turma = new Turma();
	turma.converter(vo);
    dao.insert(turma);
    return true;
  }
  
  public void insertTabelaAlunoTurma(String matricula,int id) {
	  dao.inserirTabelaAlunoTurma(matricula,id);
  }
  
  public void deletarTabelaAlunoTurma(String matricula,int id) {
	  dao.deletarTabelaAlunoTurma(matricula,id);
  }
  public void deletarTabelaAlunoTurma(int id) {
	  dao.deletarTabelaAlunoTurma(id);
  }
  
  public List<String> listMatriculasAlunosByTurma(int id){
	  List<String> lista = new ArrayList<String>();
	  ResultSet rs = dao.findByTurmaID(id);
	  try {
		  while (rs.next()) {
			  TurmaDTO vo = new TurmaDTO();
			  vo.setId(rs.getInt("id"));
			  vo.setCodDisciplina(rs.getString("codigoDisciplina"));
			  vo.setCodProfessor(rs.getString("codigoProfessor"));
			  vo.setHorario(rs.getString("horario"));
			  vo.setLocal(rs.getString("local"));
			  vo.setStatus(rs.getBoolean("status"));
			  //lista.add(vo);
		  }
		  return lista;
	  } catch (SQLException e) {
		  e.printStackTrace();
		  return null;
	  } 
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
  public List<AlunoDTO> listAlunosId(int idturma){
	  List<AlunoDTO> alunos = new ArrayList<AlunoDTO>();
	  TurmaDAO tdao = new TurmaDAO();
	  ResultSet rs = tdao.listAlunos(idturma);
	  try {
		  while(rs.next()) {
			  AlunoDTO aluno = new AlunoDTO();
			  aluno.setMatricula(rs.getString("mat_aluno"));
			  alunos.add(aluno);
		  }
		  return alunos;
	  }
	  catch(SQLException sqle) {
			sqle.printStackTrace();
			return null;
		} 
  }
  
  
  
  public TurmaDTO findById(int id) {
	  Turma turma = new Turma();
	  turma.setId(id);
	  ResultSet rs = dao.findBySpecifiedField(turma, "id");
	  try {
		  TurmaDTO t = new TurmaDTO();
		  while(rs.next()) {
			  t.setId(rs.getInt("id"));
			  t.setCodDisciplina(rs.getString("codigoDisciplina"));
			  t.setCodProfessor(rs.getString("codigoProfessor"));
			  t.setHorario(rs.getString("horario"));
			  t.setLocal(rs.getString("local"));
			  t.setStatus(rs.getBoolean("status"));			  
			
		  }
		  return t;
	  }
	  catch(SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
  }
  
  public List<TurmaDTO> turmasProfessor(TurmaDTO t){
	  Turma turma = new Turma();
	  turma.converter(t);
	  List<TurmaDTO> lista = new ArrayList<TurmaDTO>();	  	  
	  ResultSet rs = dao.findBySpecifiedField(turma, "codigoprofessor");
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

  public boolean alter(TurmaDTO vo) {
	Turma turma = new Turma();
	turma.converter(vo);
    dao.alter(turma);
    return true;
  }

	@Override
	public boolean delete(TurmaDTO entity) {
		Turma turma = new Turma();
		turma.converter(entity);
	    dao.delete(turma);
		return false;
	}
	
}
