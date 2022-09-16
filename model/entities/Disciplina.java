package entity;

public class Disciplina {
	private String nome;
	private String codigo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.isEmpty())
			this.nome = "indefinido";
		else
			this.nome = nome;

	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		 if (codigo.isEmpty())
	            this.codigo = "indefinido";
	        else
	            this.codigo = codigo;
	}

	void cadastrar(Disciplina novo) {
		// Inserir no banco de dados
	}

	void deletar() {
		// Deletar no banco de dados
	}

	void editar() {
		// Editar no banco de dados

	}
}
