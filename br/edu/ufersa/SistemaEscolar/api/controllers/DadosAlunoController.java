package br.edu.ufersa.SistemaEscolar.api.controllers;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import br.edu.ufersa.SistemaEscolar.api.dto.AfiliadoDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.AlunoDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.DisciplinaDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.ResultadoTurmaDTO;
import br.edu.ufersa.SistemaEscolar.model.services.AlunoBO;
import br.edu.ufersa.SistemaEscolar.model.services.DisciplinaBO;
import br.edu.ufersa.SistemaEscolar.model.services.ResultadoTurmaBO;
import br.edu.ufersa.SistemaEscolar.model.services.SecaoTipo;
import br.edu.ufersa.SistemaEscolar.model.services.SituacaoAluno;
import br.edu.ufersa.SistemaEscolar.view.Telas;


public class DadosAlunoController implements Initializable{
	@FXML
	private Label nome;
	@FXML
	private Label matricula;
	@FXML
	private Label endereco;
	@FXML
	private TableView<ResultadoTurmaDTO> tabelaAluno;
	@FXML 
	private TableColumn<AlunoDTO,String> disciplina;
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
	
	private static String matriculaValue;
	public static void setMatricula(String matricula) {
		matriculaValue = matricula;
	}
	private static boolean disableHistorico;
	public static void disableH(boolean d) {
		disableHistorico = d;
	}
	
	private ObservableList<ResultadoTurmaDTO> historico;
	private AlunoBO alunoBO = new AlunoBO();
	private ResultadoTurmaBO rtBO = new ResultadoTurmaBO();
	private DisciplinaBO discBO;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(disableHistorico) {
			tabelaAluno.setOpacity(0);
		}
		else listarDadosAluno();
		
	}
	
	public void listarDadosAluno() {
		System.out.print("encontrou aluno");
		System.out.print(matriculaValue);
		AlunoDTO aluno1 = alunoBO.findByMatriucla(matriculaValue);
		
		nome.setText(aluno1.getNome());
		matricula.setText(aluno1.getMatricula());
		endereco.setText(aluno1.getRua()+" "+aluno1.getBairro()+" "+aluno1.getNumeroEndereco());
		
		discBO = new DisciplinaBO();
		DisciplinaDTO discDTO = new DisciplinaDTO();
		List<ResultadoTurmaDTO> lista = rtBO.listResultadoByMatricula(matriculaValue);
		for(int i = 0; i<lista.size(); i++) {
			discDTO = discBO.findByCod(lista.get(i).getCod_disciplina());
			lista.get(i).setCod_disciplina(discDTO.getNome());
		}
		
		if(lista!=null) {
			historico = FXCollections.observableArrayList(lista);
			disciplina.setCellValueFactory(new PropertyValueFactory<>("cod_disciplina"));
			nota1.setCellValueFactory(new PropertyValueFactory<>("nota1"));
			nota2.setCellValueFactory(new PropertyValueFactory<>("nota2"));
			nota3.setCellValueFactory(new PropertyValueFactory<>("nota3"));
			media.setCellValueFactory(new PropertyValueFactory<>("media"));
			frequencia.setCellValueFactory(new PropertyValueFactory<>("frequencia"));
			situacao.setCellValueFactory(new PropertyValueFactory<>("aprovado"));
			tabelaAluno.setItems(historico);
		}
	}
	
	@FXML
	public void quit() {
		Telas.paginaPrincipal();
	}
}
