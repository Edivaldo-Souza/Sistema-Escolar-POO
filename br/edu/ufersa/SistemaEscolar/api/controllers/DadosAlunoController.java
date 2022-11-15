package br.edu.ufersa.SistemaEscolar.api.controllers;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.ObservableList;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import br.edu.ufersa.SistemaEscolar.api.dto.AlunoDTO;

import br.edu.ufersa.SistemaEscolar.model.services.AlunoBO;
import br.edu.ufersa.SistemaEscolar.model.services.ResultadoTurmaBO;


public class DadosAlunoController implements Initializable{
	@FXML
	private Label nome;
	@FXML
	private Label matricula;
	@FXML
	private Label endereco;
	@FXML
	private TableView<AlunoDTO> tabelaAluno;
	@FXML
	private TableColumn<AlunoDTO,String> disciplina;
	@FXML
	private TableColumn<AlunoDTO,Double> nota1;
	@FXML
	private TableColumn<AlunoDTO,Double> nota2;
	@FXML
	private TableColumn<AlunoDTO,Double> nota3;
	@FXML
	private TableColumn<AlunoDTO,Double> media;
	@FXML
	private TableColumn<AlunoDTO,Double> frequencia;
	
	
	private ObservableList<AlunoDTO> historico;
	private AlunoBO alunoBO = new AlunoBO();
	private ResultadoTurmaBO rtBO = new ResultadoTurmaBO();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub	
	listarDadosAluno();
	}
	public void listarDadosAluno() {
		String nomeRecebido = "recebido", matriculaRecebida = "XXXXX", enderecoRecebido = "aaaa";
		nome.setText(nomeRecebido);
		matricula.setText(matriculaRecebida);
		endereco.setText(enderecoRecebido);
		disciplina.setCellValueFactory(new PropertyValueFactory<>("disciplina"));
		nota1.setCellValueFactory(new PropertyValueFactory<>("unidade1"));
		nota2.setCellValueFactory(new PropertyValueFactory<>("unidade2"));
		nota3.setCellValueFactory(new PropertyValueFactory<>("unidade3"));
		media.setCellValueFactory(new PropertyValueFactory<>("media"));
		frequencia.setCellValueFactory(new PropertyValueFactory<>("frequencia"));
		tabelaAluno.setItems(historico);
	}
}
