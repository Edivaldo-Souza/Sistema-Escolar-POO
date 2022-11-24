package br.edu.ufersa.SistemaEscolar.api.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.edu.ufersa.SistemaEscolar.api.dto.AlunoDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.DisciplinaDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.ProfessorDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.ResultadoTurmaDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.SecaoDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.TurmaDTO;
import br.edu.ufersa.SistemaEscolar.model.services.AlunoBO;
import br.edu.ufersa.SistemaEscolar.model.services.DisciplinaBO;
import br.edu.ufersa.SistemaEscolar.model.services.ProfessorBO;
import br.edu.ufersa.SistemaEscolar.model.services.ResultadoTurmaBO;
import br.edu.ufersa.SistemaEscolar.model.services.SecaoTipo;
import br.edu.ufersa.SistemaEscolar.model.services.SituacaoAluno;
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

public class DadosTurmaController implements Initializable {
	
	@FXML
	private Label professor;
	@FXML
	private Label disciplina;
	@FXML
	private Label horario;
	@FXML
	private Label status;
	@FXML
	private Label local;
	@FXML
	private Pane painel;
	@FXML
	private Button edNotas;
	@FXML
	private Button matricula;
	
	private static int idValue;
	public static void setId(int id) {
		idValue = id;
	}
	boolean podeMatricular = true;
	private final int TOOLBAR_HIEGHT = 40;
	private final int TOOLBAR_WIDTH = 585;
	private TurmaBO tbo = new TurmaBO();
	private ProfessorBO pbo = new ProfessorBO();
	private DisciplinaBO dbo = new DisciplinaBO();
	private AlunoBO alunoBO;
	private ResultadoTurmaBO resultadoBO;
	private TurmaDTO t;
	List<AlunoDTO> matriculas;
	List<AlunoDTO> lista;
	
	private void limparPainel() {
		while(!painel.getChildren().isEmpty()) {
			for(int i = 0; i<painel.getChildren().size(); i++) {
				painel.getChildren().remove(i);
			}
		}
	}
	private void definirDados() {
		alunoBO = new AlunoBO();
		t = tbo.findById(idValue);
		matriculas = tbo.listAlunosId(idValue);
		lista = new ArrayList<AlunoDTO>();
		for(int i=0; i<matriculas.size();i++) {
			AlunoDTO e = alunoBO.findByMatriucla(matriculas.get(i).getMatricula());
			lista.add(i, e);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		listarDadosTurma();
		
		if(SecaoDTO.getSecao().getMinhaSecao() == SecaoTipo.PROFESSOR &&
				SecaoDTO.getSecao().getUsuarioId().contains(t.getCodProfessor())) {
			edNotas.setDisable(false);
			matricula.setDisable(true);
		}
		else if(SecaoDTO.getSecao().getMinhaSecao() == SecaoTipo.PROFESSOR || SecaoDTO.getSecao().getMinhaSecao() == SecaoTipo.DIRETOR) {
			matricula.setDisable(true);
			edNotas.setDisable(true);
		}
		else edNotas.setDisable(true);
		
		if(lista!=null) {
			for(int i = 0; i<lista.size(); i++) {
				if(SecaoDTO.getSecao().getMinhaSecao() == SecaoTipo.ALUNO &&
						SecaoDTO.getSecao().getUsuarioId().contains(lista.get(i).getMatricula())) {
					podeMatricular = false;
					break;
				}
			}
		}
		
		if(!podeMatricular) matricula.setText("Desmatricular-se");
		else matricula.setText("Matricular-se");
	}

	private void listarDadosTurma() {
		definirDados();
		
		String profcpf = t.getCodProfessor();
		ProfessorDTO p = pbo.findByCPF(profcpf);		
		professor.setText(p.getNome());
		
		String codDisc = t.getCodDisciplina();
		DisciplinaDTO d = dbo.findByCod(codDisc);		
		disciplina.setText(d.getNome());
		
		horario.setText(t.getHorario());
		if(t.isStatus()) {
			status.setText("Ativo");
		}
		else status.setText("Inativo");
		local.setText(t.getLocal());
		
		limparPainel();
		painel.setPrefHeight(lista.size()*TOOLBAR_HIEGHT);;
		
		List<ToolBar> items = new ArrayList<ToolBar>();
		for(int i = 0; i<lista.size(); i++) {
			
			AlunoDTO entity = lista.get(i);
			Label tipo = new Label("Aluno");
			
			Label arg1 = new Label(entity.getNome());
			arg1.setAlignment(Pos.CENTER);
			arg1.setPrefWidth(150);
			
			Label arg2 = new Label(entity.getMatricula());
			arg2.setAlignment(Pos.CENTER);
			arg2.setPrefWidth(150);
			
			Button consultar = new Button("Consultar");
			consultar.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Telas.telaDadosAluno(entity.getMatricula(),true);
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
	@FXML
	public void matricular_se(){
		resultadoBO = new ResultadoTurmaBO();
		if(podeMatricular) {

			ResultadoTurmaDTO rs = new ResultadoTurmaDTO();
			rs.setMat_aluno(SecaoDTO.getSecao().getUsuarioId());
			rs.setAprovado(SituacaoAluno.INDEFINIDO); rs.setFrequencia(0); rs.setMedia(0); rs.setNota1(0); rs.setNota2(0); rs.setNota3(0);
			rs.setId_turma(idValue); 
			rs.setCod_disciplina(t.getCodDisciplina());
			resultadoBO.insert(rs);
			
			tbo.insertTabelaAlunoTurma(SecaoDTO.getSecao().getUsuarioId(), idValue);
			listarDadosTurma();
		}
		else {
			ResultadoTurmaDTO rs = new ResultadoTurmaDTO();
			rs.setMat_aluno(SecaoDTO.getSecao().getUsuarioId());
			rs.setAprovado(SituacaoAluno.INDEFINIDO); rs.setFrequencia(0); rs.setMedia(0); rs.setNota1(0); rs.setNota2(0); rs.setNota3(0);
			rs.setId_turma(idValue); 
			rs.setCod_disciplina(t.getCodDisciplina());
			resultadoBO.delete(rs);
			
			tbo.deletarTabelaAlunoTurma(SecaoDTO.getSecao().getUsuarioId(), idValue);
			listarDadosTurma();
		}
	}
	@FXML
	public void editarNotas() {
		if(t.isStatus()) Telas.telaLancarNotas(idValue);
		else {
			JOptionPane.showMessageDialog(null, "Turma já finalizada!");
		}
	}
}
