package br.edu.ufersa.SistemaEscolar.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Scanner;

import br.edu.ufersa.SistemaEscolar.model.entities.Aluno;
import br.edu.ufersa.SistemaEscolar.model.entities.Professor;
import br.edu.ufersa.SistemaEscolar.model.entities.Turma;
import br.edu.ufersa.SistemaEscolar.model.entities.ResultadoTurma;
import br.edu.ufersa.SistemaEscolar.model.dao.StandardDAO;
import br.edu.ufersa.SistemaEscolar.model.dao.TurmaDAO;
import br.edu.ufersa.SistemaEscolar.model.dao.ProfessorDAO;
import br.edu.ufersa.SistemaEscolar.model.dao.ResultadoTurmaDAO;
import br.edu.ufersa.SistemaEscolar.model.entities.Endereco;

public class ProfessorBO implements InterfaceServices<Professor>{
	StandardDAO<Professor> dao = new ProfessorDAO();
	StandardDAO<Turma> daoTM = new TurmaDAO();
	
	@Override
	public boolean insert(Professor e) {
		ResultSet rs = dao.findBySpecifiedField(e, "cpf");
		try {
			if(rs == null || !(rs.next())) {
				if(dao.insert(e)) return true;
				else return false;
			}
			else return false;
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Professor e) {
		ResultSet rs = dao.findBySpecifiedField(e, "cpf");
		try {
			if(rs == null || !(rs.next())) {
				if(dao.delete(e)) return true;
				else return false;
			}
			else return false;
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean alter(Professor e) {
		ResultSet rs = dao.findBySpecifiedField(e, "cpf");
		try {
			if(rs == null || !(rs.next())) {
				if(dao.alter(e)) return true;
				else return false;
			}
			else return false;
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Professor> listAll() {
		List<Professor> professores = new ArrayList<Professor>();
		ResultSet rs = dao.findAll();
		try {
			while(rs.next()) {
				Professor prof = new Professor();
				prof.setCpf(rs.getString("cpf"));
				prof.setNome(rs.getString("nome"));
				
				professores.add(prof);
			}
			return professores;
		}catch(SQLException sqle) { 
			sqle.printStackTrace();
			return null;
		}
	}
	
	/*public void editarNotas(Professor e,int index) {
		Turma turmaSelecionada = e.getTurmas().get(index);
		List<Aluno> alunosDaTurma = turmaSelecionada.getAlunos();
		
		Iterator<Aluno> iterator_A = alunosDaTurma.iterator();
		
		Aluno aluno;
		ResultadoTurma historico;
		
		Scanner leitor = new Scanner(System.in);
		while(iterator_A.hasNext()) {
			aluno = iterator_A.next();
			historico = aluno.getHistorico(turmaSelecionada.getDisciplina().getCodigo());
			
			historico.setFrequencia(leitor.nextFloat());
			for(int i = 0; i<historico.getNotas().length; i++) {
				
			}
			
		}
		//ResultSet rs = daoTM.findBySpecifiedField(turma, "id");
		
	}*/
}
