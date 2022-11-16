package br.edu.ufersa.SistemaEscolar.model.services;

public enum SecaoTipo {
	ALUNO(0),
	PROFESSOR(1),
	DIRETOR(2);
	private int estado; 
	SecaoTipo(int i) {
		this.estado = i;
	}
	public int getEstado() {return estado;}
}
