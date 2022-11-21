package br.edu.ufersa.SistemaEscolar.api.controllers;
import br.edu.ufersa.SistemaEscolar.model.services.DisciplinaBO;
import br.edu.ufersa.SistemaEscolar.model.services.SecaoTipo;
import br.edu.ufersa.SistemaEscolar.view.Telas;
import br.edu.ufersa.SistemaEscolar.model.entities.Disciplina;



import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ufersa.SistemaEscolar.api.dto.DisciplinaDTO;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EditarDisciplinaController implements Initializable{
	
	@FXML
	TextField nomeField;
	@FXML
	Label codigoLabel;
	
	private static DisciplinaDTO disciplina;
	
	public static void setDisciplina(DisciplinaDTO disciplinaEntity){
		disciplina = disciplinaEntity;
	}
	public void switchToMain() {
		Telas.paginaPrincipal(SecaoTipo.DIRETOR, null);		
	}
	public void delDisciplina() {
		Disciplina DisciplinaEntity = new Disciplina();
		DisciplinaEntity.setCodigo(disciplina.getCodigo());
		DisciplinaEntity.setNome(disciplina.getNome());
		new DisciplinaBO().delete(DisciplinaEntity);
		switchToMain();
	}
	
	public void editDisciplina() {
		String nome = nomeField.getText().strip();
		
		if(nome.isBlank()) {
			nomeField.setPromptText("nome (inválido)");
			return;
		}
		Disciplina disciplinaEntity = new Disciplina();
		disciplinaEntity.setNome(nome);
		disciplinaEntity.setCodigo(disciplina.getCodigo());
		new DisciplinaBO().alter(disciplinaEntity);
		switchToMain();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nomeField.setText(disciplina.getNome());
		codigoLabel.setText(disciplina.getCodigo());
	}
	
}
