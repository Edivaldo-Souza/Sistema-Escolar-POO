package br.edu.ufersa.SistemaEscolar.api.controllers;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import javafx.event.Event;

import javax.swing.JOptionPane;

import br.edu.ufersa.SistemaEscolar.api.dto.AlunoDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.ProfessorDTO;
import br.edu.ufersa.SistemaEscolar.model.services.AlunoBO;
import br.edu.ufersa.SistemaEscolar.model.services.ProfessorBO;
import br.edu.ufersa.SistemaEscolar.view.Telas;

public class CadastrarAfiliadoController {
	@FXML
	private TextField nome;
	@FXML
	private TextField matricula;
	@FXML
	private TextField rua;
	@FXML
	private TextField bairro;
	@FXML
	private TextField numero;
	@FXML
	private TextField cpf;
	@FXML
	private TextField user;
	@FXML
	private TextField password;
	
	private AlunoBO alunoModel;
	private ProfessorBO professorModel;
	
	private boolean alunoSelecionado = true;
	
	
	@FXML
	public  void salvar() {
		if(nome.getText().isEmpty() || matricula.getText().isEmpty() || user.getText().isEmpty()
				|| password.getText().isEmpty()) {
			if((alunoSelecionado && matricula.getText().isEmpty()) ||
					(!alunoSelecionado && cpf.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Informe os dados obrigatórios");
			}
		}
		else {
			if(alunoSelecionado) {
				alunoModel = new AlunoBO();
				AlunoDTO aluno = new AlunoDTO();
				aluno.setNome(nome.getText());
				aluno.setMatricula(matricula.getText());
				aluno.setRua(rua.getText());
				aluno.setBairro(bairro.getText());
				if(!numero.getText().isEmpty()) aluno.setNumeroEndereco(Integer.parseInt(numero.getText()));
				aluno.setUsuario(user.getText());
				aluno.setSenha(password.getText());
				alunoModel.insert(aluno);
				JOptionPane.showMessageDialog(null, "Dados Salvos");
				System.out.println("aluno");
			}
			else {
				professorModel = new ProfessorBO();
				ProfessorDTO prof = new ProfessorDTO();
				prof.setNome(nome.getText());
				prof.setCpf(cpf.getText());
				prof.setRua(rua.getText());
				prof.setBairro(bairro.getText());
				if(!numero.getText().isEmpty()) prof.setNumeroEndereco(Integer.parseInt(numero.getText()));
				prof.setUsuario(user.getText());
				prof.setSenha(password.getText());
				professorModel.insert(prof);
				JOptionPane.showMessageDialog(null, "Dados Salvos");
				System.out.println("professor");
			}
		}
	}
	@FXML
	public void quit() {
		//Telas.login();
	}

	// Event Listener on Tab.onSelectionChanged
	@FXML
	public void selecionarAluno(Event event) {
		alunoSelecionado = true;
		nome.setText(null);
		matricula.setText(null);
		cpf.setText(null);
		rua.setText(null);
		bairro.setText(null);
		numero.setText(null);
		user.setText(null);
		password.setText(null);
	}
	// Event Listener on Tab.onSelectionChanged
	@FXML
	public void selecionarProfessor(Event event) {
		alunoSelecionado = false;
		nome.setText(null);
		matricula.setText(null);
		cpf.setText(null);
		rua.setText(null);
		bairro.setText(null);
		numero.setText(null);
		user.setText(null);
		password.setText(null);
	}
}
