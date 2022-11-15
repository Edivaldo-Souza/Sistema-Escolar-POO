package br.edu.ufersa.SistemaEscolar.view;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import br.edu.ufersa.SistemaEscolar.api.controllers.DefinirTurma_AController;
import br.edu.ufersa.SistemaEscolar.api.controllers.DefinirTurma_BController;
import br.edu.ufersa.SistemaEscolar.api.dto.AlunoDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.TurmaDTO;

public class Telas extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		setStage(arg0);
		arg0.setTitle("Sistema Escolar");
		paginaPrincipal();
		
	}
	public static void main(String[] args) {
		launch();
	}
	
	private static Stage mainStage;
	
	private static void setStage(Stage s) {
		mainStage = s;
	}
	
	public static void paginaPrincipal() {
		try {
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
	
	public static void telaCadastrarAfiliado() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/CadastrarAfiliado.fxml"));
			Scene cena = new Scene(root);
			mainStage.setScene(cena);
			mainStage.setTitle("Novo cadastro");
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
	
	public static void telaDadosAluno () {
		try {
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
	public static void telaDadosProfessor () {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/DadosProfessor.fxml"));
			Scene cena = new Scene(root);
			mainStage.setScene(cena);
			mainStage.setTitle("Dados Aluno");
			mainStage.show();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

