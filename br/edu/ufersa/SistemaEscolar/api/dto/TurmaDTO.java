package br.edu.ufersa.SistemaEscolar.api.dto;

import java.util.List;

public class TurmaDTO {
	private int id;
	private String codDisciplina;
	private String codProfessor;
	private String horario;
	private String local;
	public List<String> alunos_matriculados;
	private boolean status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodDisciplina() {
		return codDisciplina;
	}
	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}
	public String getCodProfessor() {
		return codProfessor;
	}
	public void setCodProfessor(String codProfessor) {
		this.codProfessor = codProfessor;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public List<String> getAlunos_matriculados() {
		return alunos_matriculados;
	}
	public void setAlunos_matriculados(List<String> alunos_matriculados) {
		this.alunos_matriculados = alunos_matriculados;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
