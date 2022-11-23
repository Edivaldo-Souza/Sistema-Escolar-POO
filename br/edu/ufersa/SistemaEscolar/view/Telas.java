package br.edu.ufersa.SistemaEscolar.view;

import br.edu.ufersa.SistemaEscolar.api.dto.*;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import br.edu.ufersa.SistemaEscolar.api.controllers.DefinirTurma_AController;
import br.edu.ufersa.SistemaEscolar.api.controllers.DefinirTurma_BController;
import br.edu.ufersa.SistemaEscolar.api.controllers.PaginaPrincipalController;
import br.edu.ufersa.SistemaEscolar.api.controllers.EditarDisciplinaController;
import br.edu.ufersa.SistemaEscolar.api.controllers.*;
import br.edu.ufersa.SistemaEscolar.api.dto.AfiliadoDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.AlunoDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.TurmaDTO;
import br.edu.ufersa.SistemaEscolar.model.services.SecaoTipo;

public class Telas extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		setStage(arg0);
		arg0.setTitle("Sistema Escolar");
		telaLogin();
	}
	
	public static void main(String[] args) {
		launch();
	}
	
	private static Stage mainStage;
	
	private static void setStage(Stage s) {
		mainStage = s;
	}
	

	public static void telaEditarProfessor(ProfessorDTO entity) {
		try {
			EditarProfessorController.setProfessor(entity);
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/EditProfessor.fxml"));
			Scene cena = new Scene(root);
			mainStage.setScene(cena);
			mainStage.setTitle("Editar Professor");
			mainStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	
	public static void telaEditarAluno(AlunoDTO entity) {
		try {
			EditarAlunoController.setAluno(entity);
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/EditAluno.fxml"));
			Scene cena = new Scene(root);
			mainStage.setScene(cena);
			mainStage.setTitle("Editar Aluno");
			mainStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	
	public static void telaDefinirDisciplina() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/DefinirDisciplina.fxml"));
			Scene cena = new Scene(root);
			mainStage.setScene(cena);
			mainStage.setTitle("Definir Disciplina");
			mainStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void telaEditarDisciplina(DisciplinaDTO disciplina) {
		try {
			EditarDisciplinaController.setDisciplina(disciplina);
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/EditarDisciplina.fxml"));
			Scene cena = new Scene(root);
			mainStage.setScene(cena);
			mainStage.setTitle("Editar Disciplina");
			mainStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void telaLogin() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/Login.fxml"));
			Scene cena = new Scene(root);
			mainStage.setScene(cena);
			mainStage.setTitle("Login");
			mainStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	public static void telaCadastro() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/Cadastro.fxml"));
			Scene cena = new Scene(root);
			mainStage.setScene(cena);
			mainStage.setTitle("Login");
			mainStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	public static void paginaPrincipal(SecaoTipo secao, AfiliadoDTO user) {
		try {
			PaginaPrincipalController.setSecao(secao);
			PaginaPrincipalController.setId(user);
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/PaginaPrincipal.fxml"));
			Scene cena = new Scene(root);
			mainStage.setScene(cena);
			mainStage.setTitle("Sistema Escolar");
			mainStage.show();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void telaDefinirTurma_A() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/DefinirTurma_A.fxml"));
			Scene cena = new Scene(root);
			mainStage.setScene(cena);
			mainStage.setTitle("Definir Turma");
			mainStage.show();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void telaDefinirTurma_A(TurmaDTO entity) {
		try {
			DefinirTurma_AController.setTurma(entity);
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/DefinirTurma_A.fxml"));
			Scene cena = new Scene(root);
			mainStage.setScene(cena);
			mainStage.setTitle("Definir Turma");
			mainStage.show();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void telaDefinirTurma_B(TurmaDTO entity) {
		try {
			DefinirTurma_BController.setTurma(entity);
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/DefinirTurma_B.fxml"));
			Scene cena = new Scene(root);
			mainStage.setScene(cena);
			mainStage.setTitle("Definir Turma");
			mainStage.show();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void telaDadosAluno (String matricula) {
		try {
			DadosAlunoController.setMatricula(matricula);
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/DadosAluno.fxml"));
			Scene cena = new Scene(root);
			mainStage.setScene(cena);
			mainStage.setTitle("Dados Aluno");
			mainStage.show();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
	public static void telaDadosProfessor (String cpf) {
		try {
			DadosProfessorController.setCpf(cpf);
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/DadosProfessor.fxml"));
			Scene cena = new Scene(root);
			mainStage.setScene(cena);
			mainStage.setTitle("Dados Professor");
			mainStage.show();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void telaDadosTurma (String id) {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/DadosTurma.fxml"));
			Scene cena = new Scene(root);
			mainStage.setScene(cena);
			mainStage.setTitle("Dados Turma");
			mainStage.show();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

