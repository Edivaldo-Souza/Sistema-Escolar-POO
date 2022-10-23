package br.edu.ufersa.SistemaEscolar.model.entities;

import java.util.List;
import java.util.ArrayList;

public class Professor {

	private String nome;
	private Endereco endereco;
	private String cpf;
	private List<Turma> turmas = new ArrayList<Turma>();
	
	public Professor(){}
	
	public Professor(String nome, String cpf) {
		this.setCpf(cpf);
		this.setEndereco(endereco);
		this.setNome(nome);
	}

	public void setNome(String nome) {
		if (nome.isEmpty())
			System.out.println("Nome invalido");
		else
			this.nome = nome;

	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;

	}

	public void setCpf(String cpf) {
		if (cpf.isEmpty())
			System.out.println("Nome invalido");
		else
			this.cpf = cpf;

	}

	public String getCpf() {
		return this.cpf;
	}

	public String getNome() {
		return this.nome;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public List<Turma> getTurmas() {
		return this.turmas;
	}

}
