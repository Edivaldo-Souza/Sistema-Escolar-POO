package br.edu.ufersa.SistemaEscolar.api.controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import br.edu.ufersa.SistemaEscolar.api.dto.*;
import br.edu.ufersa.SistemaEscolar.model.services.EnderecoBO;
import br.edu.ufersa.SistemaEscolar.model.services.SecaoTipo;
import br.edu.ufersa.SistemaEscolar.view.Telas;
import br.edu.ufersa.SistemaEscolar.model.services.ProfessorBO;
import br.edu.ufersa.SistemaEscolar.model.dao.EnderecoDAO;
import br.edu.ufersa.SistemaEscolar.model.entities.Endereco;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EditarProfessorController extends EditController implements Initializable {

	private static AfiliadoDTO professor;
	private static String cpf;

	@FXML
	TextField nomeField;
	@FXML
	TextField ruaField;
	@FXML
	Label cpfLabel;
	@FXML
	Label errorLabel;
	@FXML
	TextField bairroField;
	@FXML
	TextField numeroField;
	@FXML
	TextField usuarioField;
	@FXML
	TextField senhaField;
	@FXML
	TextField senhaConfirmField;
	
	private ProfessorBO professorBo = new ProfessorBO();
	
	public void delHandle() {
		ProfessorDTO temp = new ProfessorDTO();
		temp.setCpf(cpf);
		professorBo.delete(temp);
	}
	public void editHandle() {
		ProfessorDTO professorDto = new ProfessorDTO();
		String nome, rua, bairro, usuario, senha, senhaConfirm;

		int numero = Integer.parseInt(numeroField.getText().strip());
		nome = nomeField.getText().strip();
		rua = ruaField.getText().strip();
		bairro = bairroField.getText().strip();
		usuario = usuarioField.getText().strip();
		senha = senhaField.getText().strip();
		senhaConfirm = senhaConfirmField.getText().strip();

		if ((nome.isBlank() || rua.isBlank() ||
			 bairro.isBlank() || usuario.isBlank())) 
		{
			errorLabel.setText("Campo(s) em branco(s).");
			return;
		}else if(senha.equals(senhaConfirm)){
			professorDto.setNome(nome);
			professorDto.setRua(rua);
			professorDto.setCpf(cpf);
			professorDto.setBairro(bairro);
			professorDto.setNumeroEndereco(numero);
			professorDto.setUsuario(usuario);
			if(senha.isBlank()) {
				professorDto.setSenha(professor.getSenha());
			}else{
				professorDto.setSenha(senha);
			};
			professorBo.alter(professorDto);
			Telas.paginaPrincipal();
		}else {
			errorLabel.setText("As senhas não coincidem.");
			return;
		}
	}

	public static void setProfessor(AfiliadoDTO professorEntity) {
		professor = professorEntity;
	}
	public static void setCpf(String cpf_temp) {
		cpf = cpf_temp;
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nomeField.setText(professor.getNome());
		cpfLabel.setText("CPF: "+cpf);
		usuarioField.setText(professor.getUsuario());
		EnderecoBO enderecoBo = new EnderecoBO();
		Endereco endereco = enderecoBo.findByCpf(cpf);
		ruaField.setText(endereco.getRua());
		bairroField.setText(endereco.getBairro());
		numeroField.setText(Integer.toString(endereco.getNumero()));
	}
}
