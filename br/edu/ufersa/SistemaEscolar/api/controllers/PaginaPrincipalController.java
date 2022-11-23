package br.edu.ufersa.SistemaEscolar.api.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import br.edu.ufersa.SistemaEscolar.model.services.AlunoBO;
import br.edu.ufersa.SistemaEscolar.model.services.ProfessorBO;
import br.edu.ufersa.SistemaEscolar.model.services.TurmaBO;
import br.edu.ufersa.SistemaEscolar.model.services.DisciplinaBO;

import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.SistemaEscolar.view.Telas;
import br.edu.ufersa.SistemaEscolar.api.dto.*;
import br.edu.ufersa.SistemaEscolar.model.services.SecaoTipo;

public class PaginaPrincipalController implements Initializable{
	@FXML
	private Pane painel;
	@FXML
	private TextField campoDeBusca;
	@FXML
	private Button buttonDefinirTurma;
	@FXML
	private Button buttonDefinirDisciplina;
	@FXML
	private MenuButton userIcon;
	@FXML
	private Label userName;
	@FXML
	private MenuItem menuConsultar;
	@FXML
	private MenuItem menuEditar;
	
	private AlunoBO alunoBO;
	private ProfessorBO profBO;
	private TurmaBO turmaBO;
	private DisciplinaBO disciplinaBO;
	
	private boolean selecao[] = new boolean[4];
	
	private final int IS_ALUNO = 0;
	private final int IS_PROF = 1;
	private final int IS_TURMA = 2;
	private final int IS_DISCIPLINA = 3;
	private final int TOOLBAR_HIEGHT = 40;
	private final int TOOLBAR_WIDTH = 520;
	
	private void limparPainel() {
		while(!painel.getChildren().isEmpty()) {
			for(int i = 0; i<painel.getChildren().size(); i++) {
				painel.getChildren().remove(i);
			}
		}
	}

	private void setSelecao(int index) {
		selecao[index] = true;
		for(int i = 0;i<selecao.length; i++) {
			if(i!=index) {
				selecao[i] = false;
			}
		}
	}
	// Event Listener on MenuItem.onAction
	@FXML
	public void listarAlunos(ActionEvent event) {
		limparPainel();
		setSelecao(IS_ALUNO);
		alunoBO = new AlunoBO();
		List<AlunoDTO> lista = alunoBO.listAll();
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
	// Event Listener on MenuItem.onAction
	@FXML
	public void listarProfessores(ActionEvent event) {
		limparPainel();
		setSelecao(IS_PROF);
		profBO = new ProfessorBO();
		List<ProfessorDTO> lista = profBO.listAll();
		painel.setPrefHeight(lista.size()*TOOLBAR_HIEGHT);
		
		List<ToolBar> items = new ArrayList<ToolBar>();
		for(int i = 0; i<lista.size(); i++) {
			
			ProfessorDTO entity = lista.get(i);
			Label tipo = new Label("Professor");
			
			Label arg1 = new Label(entity.getNome());
			arg1.setAlignment(Pos.CENTER);
			arg1.setPrefWidth(150);
			
			Label arg2 = new Label(entity.getCpf());
			arg2.setAlignment(Pos.CENTER);
			arg2.setPrefWidth(150);
			
			Button consultar = new Button("Consultar");
			consultar.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Telas.telaDadosProfessor(entity.getCpf());
				}
			});
			
			items.add(new ToolBar(tipo,arg1,arg2,consultar));
			items.get(i).setLayoutX(0);
			items.get(i).setLayoutY(i*TOOLBAR_HIEGHT);
			items.get(i).setPrefSize(TOOLBAR_WIDTH, TOOLBAR_HIEGHT);
			painel.getChildren().add(items.get(i));
		}
	}
	// Event Listener on MenuItem.onAction
	@FXML
	public void listarTurmas(ActionEvent event) {
		limparPainel();
		setSelecao(IS_TURMA);
		turmaBO = new TurmaBO();
		List<TurmaDTO> lista = turmaBO.listAll();
		painel.setPrefHeight(lista.size()*TOOLBAR_HIEGHT);
		
		List<ToolBar> items = new ArrayList<ToolBar>();
		for(int i = 0; i<lista.size(); i++) {
			
			TurmaDTO entity = lista.get(i);
			Label tipo = new Label("Turma");
			
			Label arg1 = new Label(entity.getCodDisciplina());
			arg1.setAlignment(Pos.CENTER);
			arg1.setPrefWidth(150);
			
			Label arg2 = new Label(entity.getCodProfessor());
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
	// Event Listener on MenuItem.onAction
	@FXML
	public void listarDisciplinas(ActionEvent event) {
		limparPainel();
		setSelecao(IS_DISCIPLINA);
		disciplinaBO = new DisciplinaBO();
		List<DisciplinaDTO> lista = disciplinaBO.listAll();
		painel.setPrefHeight(lista.size()*TOOLBAR_HIEGHT);
		
		List<ToolBar> items = new ArrayList<ToolBar>();
		for(int i = 0; i<lista.size(); i++) {
			
			DisciplinaDTO entity = lista.get(i);
			Label tipo = new Label("Disciplina");
			
			Label arg1 = new Label(entity.getNome());
			arg1.setAlignment(Pos.CENTER);
			arg1.setPrefWidth(150);
			
			Label arg2 = new Label(entity.getCodigo());
			arg2.setAlignment(Pos.CENTER);
			arg2.setPrefWidth(150);
			
			if(SecaoDTO.getSecao().getMinhaSecao() == SecaoTipo.DIRETOR) {
				Button editar = new Button("Editar");
				editar.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						Telas.telaEditarDisciplina(entity);
					}
				});
				
				items.add(new ToolBar(tipo,arg1,arg2,editar));
			}
			else {
				items.add(new ToolBar(tipo,arg1,arg2));
			}
			items.get(i).setLayoutX(0);
			items.get(i).setLayoutY(i*TOOLBAR_HIEGHT);
			items.get(i).setPrefSize(TOOLBAR_WIDTH, TOOLBAR_HIEGHT);
			painel.getChildren().add(items.get(i));
		}
	}
	
	@FXML
	public void buscar() {
		limparPainel();
		if(selecao[IS_ALUNO]) {
			alunoBO = new AlunoBO();
			AlunoDTO e = new AlunoDTO();
			e.setNome(campoDeBusca.getText());
			e.setMatricula("0"); e.setRua("0"); e.setBairro("0"); e.setNumeroEndereco(0); e.setUsuario("0"); e.setSenha("0");
			List<AlunoDTO> lista = alunoBO.listByName(e);
			painel.setPrefHeight(lista.size()*TOOLBAR_HIEGHT);
			
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
		else if(selecao[IS_PROF]) {
			
			profBO = new ProfessorBO();
			ProfessorDTO e = new ProfessorDTO();
			e.setNome(campoDeBusca.getText());
			e.setCpf("0"); e.setRua("0"); e.setBairro("0"); e.setNumeroEndereco(0); e.setUsuario("0"); e.setSenha("0");
			List<ProfessorDTO> lista = profBO.listByName(e);
			painel.setPrefHeight(lista.size()*TOOLBAR_HIEGHT);
			
			List<ToolBar> items = new ArrayList<ToolBar>();
			for(int i = 0; i<lista.size(); i++) {
				
				ProfessorDTO entity = lista.get(i);
				Label tipo = new Label("Professor");
				
				Label arg1 = new Label(entity.getNome());
				arg1.setAlignment(Pos.CENTER);
				arg1.setPrefWidth(150);
				
				Label arg2 = new Label(entity.getCpf());
				arg2.setAlignment(Pos.CENTER);
				arg2.setPrefWidth(150);
				
				Button consultar = new Button("Consultar");
				consultar.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						Telas.telaDadosProfessor(entity.getCpf());
					}
				});
				
				items.add(new ToolBar(tipo,arg1,arg2,consultar));
				items.get(i).setLayoutX(0);
				items.get(i).setLayoutY(i*TOOLBAR_HIEGHT);
				items.get(i).setPrefSize(TOOLBAR_WIDTH, TOOLBAR_HIEGHT);
				painel.getChildren().add(items.get(i));
			}
		}
		else if(selecao[IS_DISCIPLINA]) {
			disciplinaBO = new DisciplinaBO();
			DisciplinaDTO e = new DisciplinaDTO();
			e.setNome(campoDeBusca.getText());
			e.setCodigo("0");
			List<DisciplinaDTO> lista = disciplinaBO.listByName(e);
			painel.setPrefHeight(lista.size()*TOOLBAR_HIEGHT);
			
			List<ToolBar> items = new ArrayList<ToolBar>();
			for(int i = 0; i<lista.size(); i++) {
				
				DisciplinaDTO entity = lista.get(i);
				Label tipo = new Label("Disciplina");
				
				Label arg1 = new Label(entity.getNome());
				arg1.setAlignment(Pos.CENTER);
				arg1.setPrefWidth(150);
				
				Label arg2 = new Label(entity.getCodigo());
				arg2.setAlignment(Pos.CENTER);
				arg2.setPrefWidth(150);
				
				if(SecaoDTO.getSecao().getMinhaSecao() == SecaoTipo.DIRETOR) {
					Button editar = new Button("Editar");
					editar.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							Telas.telaEditarDisciplina(entity);
						}
					});
					
					items.add(new ToolBar(tipo,arg1,arg2,editar));
				}
				else {
					items.add(new ToolBar(tipo,arg1,arg2));
				}
				
				items.get(i).setLayoutX(0);
				items.get(i).setLayoutY(i*TOOLBAR_HIEGHT);
				items.get(i).setPrefSize(TOOLBAR_WIDTH, TOOLBAR_HIEGHT);
				painel.getChildren().add(items.get(i));
			}
		}
	}
	
	@FXML
	public void definirTurma() {
		Telas.telaDefinirTurma_A();
	}
	@FXML
	public void definirDisciplina() {
		Telas.telaDefinirDisciplina();
	}
	@FXML
	public void consultarDadosUsuario() {
		if(SecaoDTO.getSecao().getMinhaSecao() == SecaoTipo.ALUNO) {
			Telas.telaDadosAluno(SecaoDTO.getSecao().getUsuarioId(),false);
		}
		else if(SecaoDTO.getSecao().getMinhaSecao() == SecaoTipo.PROFESSOR) {
			Telas.telaDadosProfessor(SecaoDTO.getSecao().getUsuarioId());
		}
	}
	@FXML
	public void editarDadosUsuario() {
		if(SecaoDTO.getSecao().getMinhaSecao() == SecaoTipo.ALUNO) {
			Telas.telaEditarAluno(SecaoDTO.getSecao().getUsuarioAtual(),SecaoDTO.getSecao().getUsuarioId());
		}
		else if(SecaoDTO.getSecao().getMinhaSecao() == SecaoTipo.PROFESSOR) {
			Telas.telaEditarProfessor(SecaoDTO.getSecao().getUsuarioAtual(),SecaoDTO.getSecao().getUsuarioId());
		}
	}
	@FXML
	public void sair() {
		Telas.telaLogin();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(SecaoDTO.getSecao().getMinhaSecao() == SecaoTipo.DIRETOR) {
			buttonDefinirDisciplina.setDisable(false);
			buttonDefinirTurma.setDisable(false);
			menuConsultar.setDisable(true);
			menuEditar.setDisable(true);
			userIcon.setText("Diretor");
			userName.setText("Acesso Geral");
			System.out.println("Seção diretor");
		}
		else if(SecaoDTO.getSecao().getMinhaSecao() == SecaoTipo.ALUNO) {
			buttonDefinirDisciplina.setDisable(true);
			buttonDefinirTurma.setDisable(true);
			userIcon.setText("Aluno");
			userName.setText(SecaoDTO.getSecao().getUsuarioAtual().getUsuario());
			System.out.println("Seção aluno");
		}
		else if(SecaoDTO.getSecao().getMinhaSecao() == SecaoTipo.PROFESSOR) {
			buttonDefinirDisciplina.setDisable(true);
			buttonDefinirTurma.setDisable(true);
			userIcon.setText("Professor");
			userName.setText(SecaoDTO.getSecao().getUsuarioAtual().getUsuario());
			System.out.println("Seção professor");
		}
		
	}
}
