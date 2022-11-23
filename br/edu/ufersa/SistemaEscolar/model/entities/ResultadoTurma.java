package br.edu.ufersa.SistemaEscolar.model.entities;

import br.edu.ufersa.SistemaEscolar.api.dto.ResultadoTurmaDTO;
import br.edu.ufersa.SistemaEscolar.model.services.SituacaoAluno;

public class ResultadoTurma {
	private Disciplina disciplina;
	private String matricula;
	private float notas[] = new float[4];
	private float frequencia;
	private int id_turma;
	private boolean aprovado;

	public int getId_turma() {
		return id_turma;
	}

	public void setId_turma(int id_turma) {
		this.id_turma = id_turma;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		if(disciplina != null) {this.disciplina = disciplina;}
	}

	public float[] getNotas() {
		return notas;
	}

	public void setNotas(float[] notas) {
		for (int i = 0; i < notas.length; i++) {
			if (notas[i] < 0 || notas[i] > 10) {
				this.notas[i] = 0;

			} else {
				this.notas[i] = notas[i];
			}
		}

	}

	public float getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(float frequencia) {
		this.frequencia = frequencia;
	}
	
	void editar() {
		// Editar no banco de dados

	}
	
	public void converter(ResultadoTurmaDTO dto) {
		setId_turma(dto.getId_turma());
		Disciplina d = new Disciplina();
		d.setCodigo(dto.getCod_disciplina());
		d.setNome("0");
		setDisciplina(d);
		float[] notas = new float[4];
		notas[0] = dto.getNota1();
		notas[1] = dto.getNota2();
		notas[2] = dto.getNota3();
		notas[3] = dto.getMedia();
		setNotas(notas);
		setFrequencia(dto.getFrequencia());
		if(dto.getAprovado() == SituacaoAluno.APROVADO) setAprovado(true);
		else if(dto.getAprovado() == SituacaoAluno.REPROVADO) setAprovado(false);
		
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
