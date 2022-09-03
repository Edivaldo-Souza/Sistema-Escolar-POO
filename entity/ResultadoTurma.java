package implementarDiagrama;

public class ResultadoTurma {
	private Disciplina disciplina;
	private float notas[] = new float[4];
	private float frequencia;

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public float[] getNotas() {
		return notas;
	}

	public void setNotas(float[] notas) {
		for (int i = 0; i < notas.length; i++) {
			if (notas[i] < 0) {
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

}
