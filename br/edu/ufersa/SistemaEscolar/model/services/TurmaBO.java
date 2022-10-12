package br.edu.ufersa.SistemaEscolar.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.SistemaEscolar.model.dao.TurmaDAO;
import br.edu.ufersa.SistemaEscolar.model.entities.Turma;
import br.edu.ufersa.SistemaEscolar.model.dao.StandardDAO;

public class TurmaBO {
  StandardDAO<Turma> dao = new TurmaDAO();

  public boolean inserir(Turma vo) {
    ResultSet rs = dao.findBySpecifiedField(vo, "id");
    try {
      if (rs == null || !(rs.next())) {
        if (dao.insert(vo) == true) {
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
  public boolean edit(Turma vo) {
    ResultSet rs = dao.findBySpecifiedField(vo, "id");
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


}
