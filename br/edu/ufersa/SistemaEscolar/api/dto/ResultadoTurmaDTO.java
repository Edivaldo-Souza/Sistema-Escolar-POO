package br.edu.ufersa.SistemaEscolar.api.dto;

import br.edu.ufersa.SistemaEscolar.model.services.SituacaoAluno;

public class ResultadoTurmaDTO {
	private String cod_disciplina;
	private String mat_aluno;
	private int id_turma;
	private float nota1;
	private float nota2;
	private float nota3;
	private float media;
	private int frequencia;
	private SituacaoAluno aprovado;
	
	public float getNota1() {
		return nota1;
	}
	public void setNota1(float nota1) {
		this.nota1 = nota1;
	}
	public float getNota2() {
		return nota2;
	}
	public void setNota2(float nota2) {
		this.nota2 = nota2;
	}
	public float getNota3() {
		return nota3;
	}
	public void setNota3(float nota3) {
		this.nota3 = nota3;
	}
	public float getMedia() {
		return media;
	}
	public void setMedia(float media) {
		this.media = media;
	}
	public String getMat_aluno() {
		return mat_aluno;
	}
	public void setMat_aluno(String mat_aluno) {
		this.mat_aluno = mat_aluno;
	}
	public int getId_turma() {
		return id_turma;
	}
	public void setId_turma(int id_turma) {
		this.id_turma = id_turma;
	}
	public int getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}
	public SituacaoAluno getAprovado() {
		return aprovado;
	}
	public void setAprovado(SituacaoAluno aprovado) {
		this.aprovado = aprovado;
	}
	public String getCod_disciplina() {
		return cod_disciplina;
	}
	public void setCod_disciplina(String cod_disciplina) {
		this.cod_disciplina = cod_disciplina;
	}
}
