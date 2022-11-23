package br.edu.ufersa.SistemaEscolar.api.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.SistemaEscolar.api.dto.AlunoDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.DisciplinaDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.ProfessorDTO;
import br.edu.ufersa.SistemaEscolar.api.dto.TurmaDTO;
import br.edu.ufersa.SistemaEscolar.model.services.AlunoBO;
import br.edu.ufersa.SistemaEscolar.model.services.DisciplinaBO;
import br.edu.ufersa.SistemaEscolar.model.services.ProfessorBO;
import br.edu.ufersa.SistemaEscolar.model.services.TurmaBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DadosTurmaController implements Initializable {
	
	@FXML
	private Label id;
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
	private TableView<AlunoDTO> tabelaAlunos;
	@FXML
	private TableColumn<AlunoDTO, String> nome;
	
	private static int idValue;
	public static void setId(int id) {
		idValue = id;
	}
	
	private TurmaBO tbo = new TurmaBO();
	private ProfessorBO pbo = new ProfessorBO();
	private DisciplinaBO dbo = new DisciplinaBO();
	private AlunoBO abo = new AlunoBO();
	private ObservableList<AlunoDTO> listaAlunos;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
		listarDadosTurma();
	}

	private void listarDadosTurma() {
		TurmaDTO t = tbo.findById(idValue);
		id.setText("Turma: "+ t.getId());
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
		List<AlunoDTO> alunos = tbo.listAlunosId(idValue); 
		for (AlunoDTO a : alunos) {
			a = abo.findByMatriucla(a.getMatricula());
		}
		listaAlunos = FXCollections.observableArrayList(alunos);
		nome.setCellValueFactory(new PropertyValueFactory<>("alunos"));
		tabelaAlunos.setItems(listaAlunos);
		
		
	}

}
