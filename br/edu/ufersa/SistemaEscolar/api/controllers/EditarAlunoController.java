package br.edu.ufersa.SistemaEscolar.api.controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import br.edu.ufersa.SistemaEscolar.api.dto.*;
import br.edu.ufersa.SistemaEscolar.model.services.EnderecoBO;
import br.edu.ufersa.SistemaEscolar.model.services.SecaoTipo;
import br.edu.ufersa.SistemaEscolar.view.Telas;
import br.edu.ufersa.SistemaEscolar.model.services.AlunoBO;
import br.edu.ufersa.SistemaEscolar.model.dao.EnderecoDAO;
import br.edu.ufersa.SistemaEscolar.model.entities.Endereco;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EditarAlunoController extends EditController implements Initializable {

	private static AfiliadoDTO aluno;
	private static String matricula;


	@FXML
	TextField nomeField;
	@FXML
	TextField ruaField;
	@FXML
	Label matriculaLabel;
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

	private AlunoBO alunoBo = new AlunoBO();

	public void delHandle() {
		AlunoDTO temp =  new AlunoDTO();
		temp.setMatricula(matricula);
		alunoBo.delete(temp);
	}

	public void editHandle() {
		AlunoDTO alunoDto = new AlunoDTO();
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
			alunoDto.setNome(nome);
			alunoDto.setRua(rua);
			alunoDto.setMatricula(matricula);
			alunoDto.setBairro(bairro);
			alunoDto.setNumeroEndereco(numero);
			alunoDto.setUsuario(usuario);	
			if(senha.isBlank()) {
				alunoDto.setSenha(aluno.getSenha());
			}else{
				alunoDto.setSenha(senha);
			};
			alunoBo.alter(alunoDto);
			Telas.paginaPrincipal();
		}else {
			errorLabel.setText("As senhas não coincidem.");
			return;
		}
	}

	public static void setAluno(AfiliadoDTO alunoEntity) {
		aluno = alunoEntity;
	}
	public static void setMatricula(String matricula_temp) {
		matricula = matricula_temp;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nomeField.setText(aluno.getNome());
		matriculaLabel.setText("Matricula: " + matricula);
		usuarioField.setText(aluno.getUsuario());
		EnderecoBO enderecoBo = new EnderecoBO();
		Endereco endereco = enderecoBo.findByMatricula(matricula);
		ruaField.setText(endereco.getRua());
		bairroField.setText(endereco.getBairro());
		numeroField.setText(Integer.toString(endereco.getNumero()));
	}
}
