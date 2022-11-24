package br.edu.ufersa.SistemaEscolar.api.controllers;

import br.edu.ufersa.SistemaEscolar.model.services.*;
import br.edu.ufersa.SistemaEscolar.api.dto.*;



import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroController {
	
	@FXML
	TextField nomeField;
	@FXML
	TextField cpfOrMatriculaField;
	@FXML
	TextField usuarioField;
	@FXML
	TextField senhaField;
	@FXML
	TextField ruaField;
	@FXML
	TextField numeroField;
	@FXML
	TextField bairroField;
	
	@FXML 
	Label erroLabel;
	
	private Stage stage;
	private Scene scene;
	
	public void switchToLogin(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(LoginController.class.getResource("/br/edu/ufersa/SistemaEscolar/view/resources/Login.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
	}
	
	
	public void registerUser(ActionEvent event) throws IOException {
		
		String nome,usuario,senha,cpfOrMatricula,rua,bairro;
		nome = nomeField.getText().strip();
		cpfOrMatricula = cpfOrMatriculaField.getText().strip();
		usuario = usuarioField.getText().strip();
		senha = senhaField.getText().strip();
		rua = ruaField.getText().strip();
		bairro = bairroField.getText().strip();
		Integer numeroEndereco = Integer.parseInt(numeroField.getText().strip());
		
		if(nome.isBlank() || cpfOrMatricula.isBlank() || usuario.isBlank() || senha.isBlank() || rua.isBlank() || bairro.isBlank()) {
			erroLabel.setText("Campo(s) em branco");
			return;
		}else if(cpfOrMatricula.contains(".")) {
			ProfessorDTO novoProfessor = new ProfessorDTO();
			novoProfessor.setNome(nome);
			novoProfessor.setUsuario(usuario);
			novoProfessor.setSenha(senha);
			novoProfessor.setCpf(cpfOrMatricula);
			novoProfessor.setRua(rua);
			novoProfessor.setBairro(bairro);
			novoProfessor.setNumeroEndereco(numeroEndereco);
			new ProfessorBO().insert(novoProfessor);
		}else {
			AlunoDTO novoAluno = new AlunoDTO();
			novoAluno.setNome(nome);
			novoAluno.setUsuario(usuario);
			novoAluno.setSenha(senha);
			novoAluno.setMatricula(cpfOrMatricula);
			novoAluno.setRua(rua);
			novoAluno.setBairro(bairro);
			novoAluno.setNumeroEndereco(numeroEndereco);
			new AlunoBO().insert(novoAluno);
		}	
		switchToLogin(event);
	}

}
