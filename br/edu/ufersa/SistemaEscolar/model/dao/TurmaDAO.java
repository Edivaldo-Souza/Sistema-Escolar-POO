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

  public void inserir(Turma vo) {
    connection = getConnection();
    String sql = "insert into Turma (id, codigoDisciplina,codigoProfessor, horario,  local, status) values (?,?,?,?,?,?)";
    try {
      PreparedStatement ptst = connection.prepareStatement(sql);
      ptst.setInt(1, vo.getId());
      ptst.setString(2, vo.getDisciplina().getCodigo());
      ptst.setString(3, vo.getProfessor().getCpf());
      ptst.setString(4, vo.getHorario());

      ptst.setString(5, vo.getLocal());
      ptst.setBoolean(6, vo.isStatus());
      ptst.execute();

    } catch (SQLException e) {
      // TODO: handle exception
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

  /*public List<Turma> listar() {
    connection = getConnection();
    String sql = "select * from Turma,Disciplina,Professor where codigoDisciplina = codigo and cpf = codigoProfessor";
    Statement st;
    ResultSet rs;
    List<Turma> turma = new ArrayList<Turma>();

    try {
      st = connection.createStatement();
      rs = st.executeQuery(sql);

      while (rs.next()) {
        vo = new Turma();
        vo.setId(rs.getInt("id"));
        vo.getDisciplina().setCodigo(rs.getString("codigoDisciplina"));
        vo.getDisciplina().setNome(rs.getString("nome"));
        vo.getProfessor().setCpf(rs.getString("codigoProfessor"));
        vo.getProfessor().setNome(rs.getString("nome"));        
        vo.setHorario(rs.getString("horario"));
        vo.setLocal(rs.getString("local"));
        vo.setStatus(rs.getBoolean("status"));
        turma.add(vo);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return turma;
  }*/

  public void edit(Turma vo) {
    connection = getConnection();
    String sql = "update Turma set horario = ?, local = ?, status = ?, codigoDisciplina = ?, codigoProfessor = ? where id = ?";
    try {
      PreparedStatement ptst = connection.prepareStatement(sql);
      ptst.setString(1, vo.getHorario());
      ptst.setString(2, vo.getLocal());
      ptst.setBoolean(3, vo.isStatus());
      ptst.setString(4, vo.getDisciplina().getCodigo());
      ptst.setString(5, vo.getProfessor().getCpf());
      ptst.setInt(6, vo.getId());

      ptst.execute();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public ResultSet findBySpecifiedField(Turma vo, String field) {
    String sql = "SELECT * FROM Turma WHERE" + field + "=? ;";

    try {
      PreparedStatement pst = connection.prepareStatement(sql);
      switch (field) {
        case "codigoDisciplina":
          sql = "SELECT * FROM Turma WHERE codigoDisciplina = ? ;";
          break;

        case "codigoProfessor":
          sql = "SELECT * FROM Turma WHERE codigoProfessor = ? ;";
          break;
        case "horario":
          sql = "SELECT * FROM Turma WHERE horario = ? ;";
          break;
        case "local":
          sql = "SELECT * FROM Turma WHERE local = ? ;";
          break;
        case "status":
          sql = "SELECT * FROM Turma WHERE status = ? ;";
          break;
        case "id":
          sql = "SELECT * FROM Turma WHERE id = ? ;";
          break;
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
}
