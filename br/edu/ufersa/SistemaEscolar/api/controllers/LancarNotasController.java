package br.edu.ufersa.SistemaEscolar.api.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import br.edu.ufersa.SistemaEscolar.api.dto.DisciplinaDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.ResultadoTurmaDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.TurmaDTO;
import br.edu.ufersa.SistemaEscolar.model.services.ResultadoTurmaBO;
import br.edu.ufersa.SistemaEscolar.model.services.SecaoTipo;
import br.edu.ufersa.SistemaEscolar.model.services.SituacaoAluno;
import br.edu.ufersa.SistemaEscolar.model.services.TurmaBO;
import br.edu.ufersa.SistemaEscolar.view.Telas;

public class LancarNotasController implements Initializable{
	@FXML
	private TableView<ResultadoTurmaDTO> tabelaNotas;
	@FXML
	private TableColumn<ResultadoTurmaDTO,String> matAluno;
	@FXML
	private TableColumn<ResultadoTurmaDTO,Float> nota1;
	@FXML
	private TableColumn<ResultadoTurmaDTO,Float> nota2;
	@FXML
	private TableColumn<ResultadoTurmaDTO,Float> nota3;
	@FXML
	private TableColumn<ResultadoTurmaDTO,Float> media;
	@FXML
	private TableColumn<ResultadoTurmaDTO,Integer> frequencia;
	@FXML
	private TableColumn<ResultadoTurmaDTO,SituacaoAluno> situacao;
	
	private static int id_turma;
	public static void setTurma(int id) {
		id_turma = id;
	}
	
	private ResultadoTurmaBO bo;
	private TurmaBO turmaBO;
	private ObservableList<ResultadoTurmaDTO> listaNotas;
	// Event Listener on Button.onAction
	@FXML
	public void save() {
		bo = new ResultadoTurmaBO();
		ObservableList<ResultadoTurmaDTO> obList = tabelaNotas.getItems();
		
		System.out.println(obList.get(0).getNota1());
		
		ResultadoTurmaDTO dto = new ResultadoTurmaDTO();
		for(int i = 0; i<obList.size(); i++) {
			dto = obList.get(i);
			dto.setId_turma(id_turma);
			dto.setCod_disciplina("0");
			bo.alter(dto);
		}
	}
	// Event Listener on Button.onAction
	@FXML
	public void lancarNotas(ActionEvent event) {
		if(JOptionPane.showConfirmDialog(null,"Deseja finalizar a turma?")==0) {
			save();
			TurmaDTO e = new TurmaDTO();
			turmaBO = new TurmaBO();
			e = turmaBO.findById(id_turma);
			e.setStatus(false);
			turmaBO.alter(e);
		}
	}
	@FXML
	public void add() {
		
	}
	// Event Listener on Button.onAction
	@FXML
	public void quit(ActionEvent event) {
		Telas.telaDadosTurma(id_turma);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println(id_turma);
		listarResultados();
	}
	public void listarResultados() {
		bo = new ResultadoTurmaBO();
		List<ResultadoTurmaDTO> lista = bo.listResultadoByTurmaID(id_turma);
		for(int i = 0; i<lista.size(); i++) {
			if(lista.get(i).getFrequencia()<=0 || lista.get(i).getMedia()<=0) {
				lista.get(i).setAprovado(SituacaoAluno.INDEFINIDO);
			}
		}
		
		tabelaNotas.setEditable(true);
		if(lista!=null) {
			listaNotas = FXCollections.observableArrayList(lista);
			matAluno.setCellValueFactory(new PropertyValueFactory<>("mat_aluno"));
			nota1.setCellValueFactory(new PropertyValueFactory<>("nota1"));
			nota1.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
			nota1.setOnEditCommit(new EventHandler<CellEditEvent<ResultadoTurmaDTO,Float>>(){

				@Override
				public void handle(CellEditEvent<ResultadoTurmaDTO, Float> arg0) {
					// TODO Auto-generated method stub
					ResultadoTurmaDTO dto = arg0.getRowValue();
					dto.setNota1(arg0.getNewValue());
				}
				
			});
				
			
			nota2.setCellValueFactory(new PropertyValueFactory<>("nota2"));
			nota2.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
			nota2.setOnEditCommit(new EventHandler<CellEditEvent<ResultadoTurmaDTO,Float>>(){

				@Override
				public void handle(CellEditEvent<ResultadoTurmaDTO, Float> arg0) {
					// TODO Auto-generated method stub
					ResultadoTurmaDTO dto = arg0.getRowValue();
					dto.setNota2(arg0.getNewValue());
				}
				
			});
			
			nota3.setCellValueFactory(new PropertyValueFactory<>("nota3"));
			nota3.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
			nota3.setOnEditCommit(new EventHandler<CellEditEvent<ResultadoTurmaDTO,Float>>(){

				@Override
				public void handle(CellEditEvent<ResultadoTurmaDTO, Float> arg0) {
					// TODO Auto-generated method stub
					ResultadoTurmaDTO dto = arg0.getRowValue();
					dto.setNota3(arg0.getNewValue());
					dto.setMedia((dto.getNota1()+dto.getNota2()+dto.getNota3())/3);
				}
				
			});
			
			media.setCellValueFactory(new PropertyValueFactory<>("media"));
			
			frequencia.setCellValueFactory(new PropertyValueFactory<>("frequencia"));
			frequencia.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
			frequencia.setOnEditCommit(new EventHandler<CellEditEvent<ResultadoTurmaDTO,Integer>>(){

				@Override
				public void handle(CellEditEvent<ResultadoTurmaDTO, Integer> arg0) {
					// TODO Auto-generated method stub
					ResultadoTurmaDTO dto = arg0.getRowValue();
					dto.setFrequencia(arg0.getNewValue());
					if(dto.getFrequencia()>=75 && dto.getMedia()>=7) {
						dto.setAprovado(SituacaoAluno.APROVADO);
					}
					else {
						dto.setAprovado(SituacaoAluno.REPROVADO);
					}
				}
				
			});
			
			situacao.setCellValueFactory(new PropertyValueFactory<>("aprovado"));
			
			tabelaNotas.setItems(listaNotas);
		}
	}
}
