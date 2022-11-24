package br.edu.ufersa.SistemaEscolar.api.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.SistemaEscolar.api.dto.ProfessorDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.TurmaDTO;
import br.edu.ufersa.SistemaEscolar.model.services.ProfessorBO;
import br.edu.ufersa.SistemaEscolar.model.services.TurmaBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DadosProfessorController implements Initializable {
	@FXML
	private Label nome;
	@FXML
	private Label cpf;
	@FXML
	private Label endereco;
	@FXML
	private TableView<TurmaDTO> tabelaTurmas;
	@FXML
	private TableColumn<TurmaDTO,String> codigo;
	@FXML
	private TableColumn<TurmaDTO,String> disciplina;
	@FXML
	private TableColumn<TurmaDTO,String> local;
	@FXML
	private TableColumn<TurmaDTO,String> horario;
	@FXML
	private TableColumn<TurmaDTO,Boolean> status;
	
	private static String cpfValue;
	public static void setCpf(String cpf) {
		cpfValue = cpf;
	}
	
	private ProfessorBO bo = new ProfessorBO();
	private TurmaBO Tbo = new TurmaBO();
	private ObservableList<TurmaDTO> listaTurmas;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub	
		listarDadosProfessor();
	}
	
	public void listarDadosProfessor() {
		TurmaDTO t = new TurmaDTO();
		ProfessorDTO prof = bo.findByCPF(cpfValue);		
		nome.setText(prof.getNome());
		cpf.setText(prof.getCpf());
		endereco.setText(prof.getRua()+" "+prof.getBairro()+" "+prof.getNumeroEndereco());
		List<TurmaDTO> turmas = Tbo.turmasProfessor(t);
		
		if(turmas!=null) {
			listaTurmas = FXCollections.observableArrayList(turmas);
			codigo.setCellValueFactory(new PropertyValueFactory<>("codDisciplina"));
			disciplina.setCellValueFactory(new PropertyValueFactory<>("nomeDisciplina"));
			local.setCellValueFactory(new PropertyValueFactory<>("local"));
			horario.setCellValueFactory(new PropertyValueFactory<>("horario"));
			status.setCellValueFactory(new PropertyValueFactory<>("status"));
			tabelaTurmas.setItems(listaTurmas);
		}
		
	}
	
}
