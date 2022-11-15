package br.edu.ufersa.SistemaEscolar.model.entities;

import java.util.List;

import br.edu.ufersa.SistemaEscolar.api.dto.ProfessorDTO;

import java.util.ArrayList;

public class Professor extends Afiliado{

	private String nome;
	private String cpf;
	private List<Turma> turmas = new ArrayList<Turma>();
	
	public Professor(){}
	
	public Professor(String nome, String cpf) {
		this.setCpf(cpf);
		this.setNome(nome);
	}

	public void setNome(String nome) {
		if (nome.isEmpty())
			System.out.println("Nome invalido");
		else
			this.nome = nome;

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

	public List<Turma> getTurmas() {
		return this.turmas;
	}
	
	public void converter(ProfessorDTO e) {
		Endereco end = new Endereco();
		setNome(e.getNome());
		setCpf(e.getCpf());
		setUsuario(e.getUsuario());
		setSenha(e.getSenha());
		end.setRua(e.getRua());
		end.setBairro(e.getBairro());
		end.setNumero(e.getNumeroEndereco());
		setEndereco(end);
		
	}

}
