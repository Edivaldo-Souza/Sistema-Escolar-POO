package br.edu.ufersa.SistemaEscolar.model.entities;

import br.edu.ufersa.SistemaEscolar.api.dto.DisciplinaDTO;

public class Disciplina {
	private String nome;
	private String codigo;
	
	public Disciplina(String nome,String codigo){
		this.setCodigo(codigo);
		this.setNome(nome);
	}

	public Disciplina() {
		// TODO Auto-generated constructor stub
	}

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

	public void converter(DisciplinaDTO e){
		setNome(e.getNome());
		setCodigo(e.getCodigo());
	}
}
