package br.edu.ufersa.SistemaEscolar.api.controllers;

import br.edu.ufersa.SistemaEscolar.model.services.*;
import br.edu.ufersa.SistemaEscolar.model.dao.*;
import br.edu.ufersa.SistemaEscolar.api.dto.*;


import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController {
	
	private Stage stage;
	private Scene scene;
	
	@FXML
	TextField senhaField;
	@FXML
	TextField usuarioField;
	
	private void cleanFields(String senhaMsg,String usuarioMsg) {
		senhaField.setText("");
		usuarioField.setText("");
		senhaField.setPromptText(senhaMsg);
		usuarioField.setPromptText(usuarioMsg);
	}
	
	public void loginUser(ActionEvent event) throws IOException{
		String usuario,senha;
		usuario = usuarioField.getText().strip();
		senha = senhaField.getText().strip();
		
		
		AlunoDTO alunoDto = new AlunoDTO();
		alunoDto.setUsuario(usuario);
		alunoDto.setSenha(senha);
		AlunoBO alunoBo = new AlunoBO();
		AlunoDTO resultAluno = alunoBo.findByLogin(alunoDto,"usuario");
		if(resultAluno != null) {
			if(resultAluno.getSenha().compareTo(senha) == 0) {
				switchToMain(event);
			}
			cleanFields("Senha Incorreta","Usuario");
			return;
	
		} 
		ProfessorDTO professorDto = new ProfessorDTO();
		professorDto.setUsuario(usuario);
		professorDto.setSenha(senha);
		ProfessorBO professorBo = new ProfessorBO();
		ProfessorDTO resultProfessor = professorBo.findByLogin(professorDto, "usuario");
		if(resultProfessor != null) {
			if(resultProfessor.getSenha().compareTo(senha) == 0) {
				switchToMain(event);
			}
			cleanFields("Senha Incorreta","Usuario");
			return;
		}
		cleanFields("Senha","Usuario Incorreto");

	}
	
	public void switchToRegister(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(loginController.class.getResource("/br/edu/ufersa/SistemaEscolar/view/resources/Cadastro.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
	}
	
	private void switchToMain(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(loginController.class.getResource("/br/edu/ufersa/SistemaEscolar/view/resources/PaginaPrincipal.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
	}


}
