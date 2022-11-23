package br.edu.ufersa.SistemaEscolar.model.services;

public enum SituacaoAluno {
	APROVADO("APV"),
	REPROVADO("RPV"),
	INDEFINIDO("IDF");
	private String estado;
	SituacaoAluno(String i) {
		estado = i;
	}
	public String getEstado() {
		return estado;
	}
}
