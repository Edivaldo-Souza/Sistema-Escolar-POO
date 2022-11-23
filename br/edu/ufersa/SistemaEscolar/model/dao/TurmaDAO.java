package br.edu.ufersa.SistemaEscolar.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.SistemaEscolar.model.entities.Turma;

public class TurmaDAO extends StandardDAO<Turma> {
  Turma vo;

  public boolean insert(Turma vo) {
    String sql = "insert into Turma (codigoDisciplina,codigoProfessor, horario, local, status) values (?,?,?,?,?)";
    try {
      PreparedStatement ptst = getConnection().prepareStatement(sql);
      ptst.setString(1, vo.getDisciplina().getCodigo());
      ptst.setString(2, vo.getProfessor().getCpf());
      ptst.setString(3, vo.getHorario());

      ptst.setString(4, vo.getLocal());
      ptst.setBoolean(5, vo.isStatus());
      ptst.execute();
      return true;

    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }
  
  public void inserirTabelaAlunoTurma(String matricula,int id) {
	
	  String sql = "insert into tabela_aluno_turma (mat_aluno,id_turma) values (?,?);";
	  try {
		  PreparedStatement ptst = getConnection().prepareStatement(sql);
		  ptst.setString(1, matricula);
		  ptst.setInt(2, id);
		  ptst.execute();
	  } catch (SQLException e) {
		  e.printStackTrace();
	  }
  }
  
  public void deletarTabelaAlunoTurma(int id) {
	  String sql = "delete from tabela_aluno_turma where id_turma=?;";
	  try {
		PreparedStatement ptst = getConnection().prepareStatement(sql);
		ptst.setInt(1, id);
		ptst.execute();
	  } catch (SQLException e) {
		  e.printStackTrace();
	  }
  }
  
  public ResultSet findByTurmaID(int id) {
	  String sql = "select * from tabela_aluno_turma where id_turma=?;";
	  try {
		PreparedStatement ptst = getConnection().prepareStatement(sql);
		ptst.setInt(1, id);
		ResultSet rs = ptst.executeQuery();
		return rs;
	  } catch (SQLException e) {
		  e.printStackTrace();
		  return null;
	  }
  }
  
  public ResultSet findLastTurma() {
	  String sql = "select * from turma order by id desc limit 1;";
	  try {
		  PreparedStatement pst = getConnection().prepareStatement(sql);
		  ResultSet rs = pst.executeQuery();
		  return rs;
	  }
	  catch (SQLException e) {
	      // TODO: handle exception
	      e.printStackTrace();
	      return null;
	    }
  }
  
  
  public boolean alter(Turma vo) {
	  
    String sql = "update Turma set horario = ?, local = ?, status = ?, codigoDisciplina = ?, codigoProfessor = ? where id = ?";
    try {
      PreparedStatement ptst = getConnection().prepareStatement(sql);
      ptst.setString(1, vo.getHorario());
      ptst.setString(2, vo.getLocal());
      ptst.setBoolean(3, vo.isStatus());
      ptst.setString(4, vo.getDisciplina().getCodigo());
      ptst.setString(5, vo.getProfessor().getCpf());
      ptst.setInt(6, vo.getId());

      ptst.execute();
      return true;

    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public void removeBySpecificField(Turma vo, String field) {
    connection = getConnection();
    String sql = "delete from Turma where " + field + " = ?";

    try {
      PreparedStatement pst = connection.prepareStatement(sql);
      switch (field) {
        case "id":
          sql = "delete from Turma where id = ?";
          pst = connection.prepareStatement(sql);
          pst.setInt(1, vo.getId());
          break;
        case "codigoDisciplina":
          sql = "delete from Turma where codigoDisciplina = ?";
          pst = connection.prepareStatement(sql);
          pst.setString(1, vo.getDisciplina().getCodigo());
          break;
        case "codigoProfessor":
          sql = "delete from Turma where codigoProfessor = ?";
          pst = connection.prepareStatement(sql);
          pst.setString(1, vo.getProfessor().getCpf());
          break;
        case "horario":
          sql = "delete from Turma where horario = ?";
          pst = connection.prepareStatement(sql);
          pst.setString(1, vo.getHorario());
          break;
        case "local":
          sql = "delete from Turma where local = ?";
          pst = connection.prepareStatement(sql);
          pst.setString(1, vo.getLocal());
          break;
        case "status":
          sql = "delete from Turma where status = ?";
          pst = connection.prepareStatement(sql);
          pst.setBoolean(1, vo.isStatus());
          break;
        default:
          break;

      }
      pst.execute();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public ResultSet listAlunos(int idturma) {
	  String sql = "SELECT * FROM tabela_aluno_turma WHERE id_turma =?";
	  try {
	      PreparedStatement pst = getConnection().prepareStatement(sql);
	      pst.setInt(1, idturma);
	      ResultSet rs = pst.executeQuery();
	      return rs;
	    } catch (SQLException e) {
	      // TODO: handle exception
	      e.printStackTrace();
	      return null;
	    }
  }
  @Override
  public ResultSet findBySpecifiedField(Turma vo, String field) {
    String sql = "SELECT * FROM Turma WHERE" + field + "=? ;";

    try {
      PreparedStatement pst = getConnection().prepareStatement(sql);
      switch (field) {
        case "codigoDisciplina":
          sql = "SELECT * FROM Turma WHERE codigoDisciplina = ? ;";
          pst.setString(1, vo.getDisciplina().getCodigo());
          break;
        case "id":
          sql = "SELECT * FROM Turma WHERE id = ? ;";
          pst.setInt(1, vo.getId());
          break;
        case "codigoProfessor":
        	sql = "SELECT * FROM Turma WHERE codigoProfessor = ?;";
        	pst.setString(1, vo.getProfessor().getCpf());
        default:
          break;
      }
      ResultSet rs = pst.executeQuery();
      return rs;
    } catch (SQLException e) {
      // TODO: handle exception
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public ResultSet findAll() {
	  String sql = "SELECT * FROM turma;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			return rs;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
  }
}
