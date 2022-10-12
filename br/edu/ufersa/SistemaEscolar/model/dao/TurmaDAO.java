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

  public void removeByDisciplina(Turma vo) {
    connection = getConnection();
    String sql = "delete from Turma where codigoDisciplina = ?";

    try {
      PreparedStatement ptst = connection.prepareStatement(sql);
      ptst.setString(1, vo.getDisciplina().getCodigo());
      ptst.execute();

    } catch (SQLException e) {
      // TODO: handle exception
      e.printStackTrace();
    }

  }

  public List<Turma> listar() {
    connection = getConnection();
    String sql = "select * from Turma";
    Statement st;
    ResultSet rs;
    List<Turma> turma = new ArrayList<Turma>();

    try {
      st = connection.createStatement();
      rs = st.executeQuery(sql);

      while (rs.next()) {
        Turma vo = new Turma();
        vo.setId(rs.getInt("id"));
        vo.setHorario(rs.getString("horario"));
        vo.setLocal(rs.getString("local"));
        vo.setStatus(rs.getBoolean("status"));

        turma.add(vo);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return turma;
  }

  public void Edit(Turma vo) {
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
}
