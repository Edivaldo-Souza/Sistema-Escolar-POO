package br.edu.ufersa.SistemaEscolar.api.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import br.edu.ufersa.SistemaEscolar.model.services.*;
import br.edu.ufersa.SistemaEscolar.model.entities.*;


import java.io.IOException;

import br.edu.ufersa.SistemaEscolar.api.dto.*;


public class DefinirDisciplinaController {
	
	@FXML
	TextField nomeField;
	@FXML
	TextField codigoField;
	
	private void cleanFields(String nomeMsg,String codigoMsg) {
		if(!nomeMsg.isBlank()){
			nomeField.setText("");
			nomeField.setPromptText(nomeMsg);
		}else{
			nomeField.setPromptText("nome");
		};
		
		if(!codigoMsg.isBlank()){
			codigoField.setText("");
			codigoField.setPromptText(codigoMsg);
		}else{
			codigoField.setPromptText("código");
		};
		
	}
	
	public void registerDisciplina(ActionEvent event) throws IOException{
		String nome,codigo;
		nome = nomeField.getText().strip();
		codigo = codigoField.getText().strip();
		
		if(!(nome.isBlank() && codigo.isBlank())) {
			Disciplina disciplina = new Disciplina(nome,codigo);
			DisciplinaBO disciplinaBo = new DisciplinaBO();
			disciplinaBo.insert(disciplina);
		}else {
			String nomeMsg = "";
			String codigoMsg = "";
			if(nome.isBlank()){
				nomeMsg = "nome (Inválido)";
			}else if(codigo.isBlank()) {
				codigoMsg = "código (Inválido)";
			}else {
				nomeMsg = "nome (Invalido)";
				codigoMsg = "código (Inválido)";
			}
			this.cleanFields(nomeMsg,codigoMsg);
		}	
	}
	
}
