package br.edu.ufersa.SistemaEscolar.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.SistemaEscolar.model.entities.Afiliado;

public class EnderecoDAO extends StandardDAO<Afiliado>{
	
	public ResultSet findByMatricula(String matricula) {
		String sql = "SELECT * FROM tabela_endereco_aluno where mat_aluno=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, matricula);
			ResultSet rs = pst.executeQuery();
			return rs;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}
	
	public ResultSet findByCpf(String cpf) {
		String sql = "SELECT * FROM tabela_endereco_professor where cpf_prof=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1,cpf);
			ResultSet rs = pst.executeQuery();
			return rs;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}
}
