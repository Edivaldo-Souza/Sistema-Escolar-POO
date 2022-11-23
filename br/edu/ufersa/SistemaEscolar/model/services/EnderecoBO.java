package br.edu.ufersa.SistemaEscolar.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.SistemaEscolar.model.entities.Endereco;

import br.edu.ufersa.SistemaEscolar.model.dao.EnderecoDAO;

public class EnderecoBO {

	public Endereco findByMatricula(String matricula) {
		try {
			ResultSet rs = new EnderecoDAO().findByMatricula(matricula);
			rs.next();
			Endereco endereco = new Endereco();
			endereco.setBairro(rs.getString("bairro"));
			endereco.setNumero(rs.getInt("numero"));
			endereco.setRua(rs.getString("rua"));
			return endereco;

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}

	}

	public Endereco findByCpf(String cpf) {
		try {
			ResultSet rs = new EnderecoDAO().findByCpf(cpf);
			rs.next();
			Endereco endereco = new Endereco();
			endereco.setBairro(rs.getString("bairro"));
			endereco.setNumero(rs.getInt("numero"));
			endereco.setRua(rs.getString("rua"));
			return endereco;

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
		
	}
}
