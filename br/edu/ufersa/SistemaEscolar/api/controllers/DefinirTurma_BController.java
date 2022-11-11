package br.edu.ufersa.SistemaEscolar.api.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.List;
import br.edu.ufersa.SistemaEscolar.view.Telas;
import br.edu.ufersa.SistemaEscolar.api.dto.AlunoDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.TurmaDTO;
import br.edu.ufersa.SistemaEscolar.model.services.AlunoBO;
import br.edu.ufersa.SistemaEscolar.model.services.TurmaBO;

public class DefinirTurma_BController implements InterfaceController,Initializable{
	@FXML
	private TableView<AlunoDTO> tabelaAlunos;
	@FXML
	private TableColumn<AlunoDTO,String> nomeAluno;
	@FXML
	private TableColumn<AlunoDTO,String> matAluno;
	
	private static TurmaDTO turma;
	public static void setTurma(TurmaDTO t) {
		if(t != null) turma = t;
	}
	
	private AlunoBO bo = new AlunoBO();
	private TurmaBO turmaBo = new TurmaBO();
	private ObservableList<AlunoDTO> listaAlunos;

	// Event Listener on Button.onAction
	@FXML
	public void quit(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button.onAction
	@FXML
	public void nextPage(ActionEvent event) {
		if(JOptionPane.showConfirmDialog(null, "Deseja Salvar esses Dados?")==0) {
			ObservableList<AlunoDTO> listaOB = tabelaAlunos.getSelectionModel().getSelectedItems();
			List<String> matriculas = new ArrayList<String>();
			for(int i = 0; i<listaOB.size(); i++) {
				matriculas.add(listaOB.get(i).getMatricula());
			}
			TurmaDTO turma = new TurmaDTO();
			turma.setAlunos_matriculados(matriculas);
			if(this.turma.getId()<=0) {
				System.out.println("inserindo alunos: " + this.turma.getId());
				int id = turmaBo.ultimaTurmaInserida().getId();
				System.out.println(id);
				turma.setId(id);
				for(int i = 0; i<turma.getAlunos_matriculados().size(); i++) {
					turmaBo.insertTabelaAlunoTurma(turma.getAlunos_matriculados().get(i),turma.getId());
				}
				this.turma.setId(id);
				this.turma.setAlunos_matriculados(turma.getAlunos_matriculados());
				for(int i = 0; i<turma.getAlunos_matriculados().size(); i++) {
					System.out.println(this.turma.getAlunos_matriculados().get(i));
				}
			}
			else {
				System.out.println("alterando alunos: " + this.turma.getId());
				turmaBo.deletarTabelaAlunoTurma(this.turma.getId());
				turma.setId(this.turma.getId());
				for(int i = 0; i<turma.getAlunos_matriculados().size(); i++) {
					turmaBo.insertTabelaAlunoTurma(turma.getAlunos_matriculados().get(i),turma.getId());
				}
				this.turma.setAlunos_matriculados(turma.getAlunos_matriculados());
			}
		}
	}
	// Event Listener on Button.onAction
	@FXML
	public void previousPage(ActionEvent event) {
		Telas.telaDefinirTurma_A(turma);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tabelaAlunos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		listarAlunos();
		this.turma.setId(turmaBo.ultimaTurmaInserida().getId());
		System.out.println(this.turma.getId());
		
		if(this.turma.getId()>0 && turma.getAlunos_matriculados()!=null) {
			System.out.println("selecionar alunos existentes");
			for(int i = 0; i<tabelaAlunos.getItems().size(); i++) {
				for(int j = 0; j<turma.getAlunos_matriculados().size(); j++) {
					if(turma.getAlunos_matriculados().get(j) == tabelaAlunos.getItems().get(i).getMatricula()) {
						tabelaAlunos.getSelectionModel().select(i);
					}
				}
			}
		}
	}
	@Override
	public void listarAlunos() {
		List<AlunoDTO> lista = bo.listAll();
		if(lista!=null) {
			listaAlunos = FXCollections.observableArrayList(lista);
			nomeAluno.setCellValueFactory(new PropertyValueFactory<>("nome"));
			matAluno.setCellValueFactory(new PropertyValueFactory<>("matricula"));
			tabelaAlunos.setItems(listaAlunos);
		}else System.out.println("tabela alunos vazia");
		
	}
	@Override
	public void listarDisciplinas() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void listarProfessores() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void listarTurmas() {
		// TODO Auto-generated method stub
		
	}
}
