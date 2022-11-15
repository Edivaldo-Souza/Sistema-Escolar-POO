package br.edu.ufersa.SistemaEscolar.api.controllers;

import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

import br.edu.ufersa.SistemaEscolar.view.Telas;
import br.edu.ufersa.SistemaEscolar.api.dto.DisciplinaDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.ProfessorDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.TurmaDTO;
import br.edu.ufersa.SistemaEscolar.model.services.DisciplinaBO;
import br.edu.ufersa.SistemaEscolar.model.services.ProfessorBO;
import br.edu.ufersa.SistemaEscolar.model.services.TurmaBO;


public class DefinirTurma_AController implements InterfaceController,Initializable{
	@FXML
	private TableView<DisciplinaDTO> tabelaDisciplina;
	@FXML
	private TableColumn<DisciplinaDTO,String> nomeDisciplina;
	@FXML
	private TableColumn<DisciplinaDTO,String> codDisciplina;
	@FXML
	private TableView<ProfessorDTO> tabelaProfessor;
	@FXML
	private TableColumn<ProfessorDTO,String> nomeProfessor;
	@FXML
	private TableColumn<ProfessorDTO,String> cpfProfessor;
	@FXML
	private TextField horario;
	@FXML
	private TextField local;
	
	private static TurmaDTO turma;
	public static void setTurma(TurmaDTO t) {
		if(t != null )turma = t;
	}
	
	private ObservableList<ProfessorDTO> listaProfessores;
	private ObservableList<DisciplinaDTO> listaDisciplinas;
	private DisciplinaBO disciplinaBo = new DisciplinaBO();
	private ProfessorBO profBo = new ProfessorBO();
	private TurmaBO turmaBo = new TurmaBO();
	
	
	// Event Listener on Button.onAction
	@FXML
	public void nextPage(ActionEvent event) {
		if(tabelaDisciplina.getSelectionModel().getSelectedItem() == null ||
			tabelaProfessor.getSelectionModel().getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Preencha todos os dados!");
		}
		else if(JOptionPane.showConfirmDialog(null, "Deseja Salvar esses Dados?")==0) {
			
			DisciplinaDTO d = new DisciplinaDTO();
			d = tabelaDisciplina.getSelectionModel().getSelectedItem();
			
			ProfessorDTO p = new ProfessorDTO();
			p = tabelaProfessor.getSelectionModel().getSelectedItem();
			
			TurmaDTO turma = new TurmaDTO();
			
			turma.setCodDisciplina(d.getCodigo());
			turma.setCodProfessor(p.getCpf());
			turma.setHorario(horario.getText());
			turma.setLocal(local.getText());
			turma.setStatus(true);
			
			if(this.turma == null) {
				turmaBo.insert(turma);
				System.out.println("inserindo nova turma");
				Telas.telaDefinirTurma_B(turma);
			}
			else {
				turma.setId(this.turma.getId());
				System.out.println("alterando nova turma: " + turma.getId());
				turmaBo.alter(turma);
				setTurma(turma);
				Telas.telaDefinirTurma_B(this.turma);
			}
		}
	}
	// Event Listener on Button.onAction
	@FXML
	public void quit(ActionEvent event) {
		Telas.paginaPrincipal();
	}
	@Override
	public void listarAlunos() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void listarDisciplinas() {
		List<DisciplinaDTO> lista = disciplinaBo.listAll();
		if(lista!=null) {
			listaDisciplinas = FXCollections.observableArrayList(lista);
			nomeDisciplina.setCellValueFactory(new PropertyValueFactory<>("nome"));
			codDisciplina.setCellValueFactory(new PropertyValueFactory<>("codigo"));
			
			tabelaDisciplina.setItems(listaDisciplinas);
		}else System.out.println("tabela disciplinas vazia");
		
	}
	@Override
	public void listarProfessores() {
		List<ProfessorDTO> lista = profBo.listAll();
		if(lista!=null) {
			listaProfessores = FXCollections.observableArrayList(lista);
			nomeProfessor.setCellValueFactory(new PropertyValueFactory<>("nome"));
			cpfProfessor.setCellValueFactory(new PropertyValueFactory<>("cpf"));
			tabelaProfessor.setItems(listaProfessores);
		}else System.out.println("tabela professores vazia");
		
	}
	@Override
	public void listarTurmas() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listarDisciplinas();
		listarProfessores();
		if(turma != null) {
			System.out.println(turma.getCodDisciplina());
			String cod;
			for(int i = 0; i<tabelaDisciplina.getItems().size(); i++) {
				cod = tabelaDisciplina.getItems().get(i).getCodigo();
				if(turma.getCodDisciplina() == cod) {
					System.out.println("condicao satisfeita");
					tabelaDisciplina.getSelectionModel().select(i);
				}
			}
			
			for(int i = 0; i<tabelaProfessor.getItems().size(); i++) {
				if(turma.getCodProfessor() == tabelaProfessor.getItems().get(i).getCpf()) {
					tabelaProfessor.getSelectionModel().select(i);
				}
			}
			
			horario.setText(turma.getHorario());
			local.setText(turma.getLocal());
		}
	}
}
