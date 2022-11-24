package br.edu.ufersa.SistemaEscolar.api.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.edu.ufersa.SistemaEscolar.api.dto.ProfessorDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.SecaoDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.TurmaDTO;
import br.edu.ufersa.SistemaEscolar.model.services.ProfessorBO;
import br.edu.ufersa.SistemaEscolar.model.services.SecaoTipo;
import br.edu.ufersa.SistemaEscolar.model.services.TurmaBO;
import br.edu.ufersa.SistemaEscolar.view.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class DadosProfessorController implements Initializable {
	@FXML
	private Label nome;
	@FXML
	private Label cpf;
	@FXML
	private Label endereco;
	@FXML
	private Pane painel;
	
	private static String cpfValue;
	public static void setCpf(String cpf) {
		cpfValue = cpf;
	}
	private final int TOOLBAR_HIEGHT = 40;
	private final int TOOLBAR_WIDTH = 585;
	private ProfessorBO bo = new ProfessorBO();
	private TurmaBO turmaBO;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub	
		listarDadosProfessor();
	}
	
	public void listarDadosProfessor() {
		ProfessorDTO prof = bo.findByCPF(cpfValue);		
		turmaBO = new TurmaBO();
		
		nome.setText(prof.getNome());
		cpf.setText(prof.getCpf());
		endereco.setText(prof.getRua()+" "+prof.getBairro()+" "+prof.getNumeroEndereco());
		
		TurmaDTO t = new TurmaDTO();
		t.setCodDisciplina("0"); t.setHorario("0"); t.setLocal("0"); t.setStatus(false);
		t.setCodProfessor(cpfValue);
		List<TurmaDTO> lista = turmaBO.turmasProfessor(t);
		
		painel.setPrefHeight(lista.size()*TOOLBAR_HIEGHT);
		
		List<ToolBar> items = new ArrayList<ToolBar>();
		for(int i = 0; i<lista.size(); i++) {
			
			TurmaDTO entity = lista.get(i);
			Label tipo = new Label("Turma");
			
			Label arg1 = new Label(entity.getCodDisciplina());
			arg1.setAlignment(Pos.CENTER);
			arg1.setPrefWidth(150);
			
			Label arg2 = new Label(entity.getHorario());
			arg2.setAlignment(Pos.CENTER);
			arg2.setPrefWidth(150);
			
			Button consultar = new Button("Consultar");
			consultar.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Telas.telaDadosTurma(entity.getId());
				}
			});
			
			items.add(new ToolBar(tipo,arg1,arg2,consultar));
			
			items.get(i).setLayoutX(0);
			items.get(i).setLayoutY(i*TOOLBAR_HIEGHT);
			items.get(i).setPrefSize(TOOLBAR_WIDTH, TOOLBAR_HIEGHT);
			painel.getChildren().add(items.get(i));
		}
		
	}
	
	@FXML
	public void quit() {
		Telas.paginaPrincipal();
	}
	
}
