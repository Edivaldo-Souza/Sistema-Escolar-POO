package br.edu.ufersa.SistemaEscolar.model.entities;

public class Afiliado {
	private String nome;
    private Endereco endereco;
    
    public Afiliado(String nome, Endereco endereco){
    	setNome(nome);
    	setEndereco(endereco);
    }
    public Afiliado(){};
	
    public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		if(endereco != null) this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome.isEmpty()) this.nome = "indefinido";
		else this.nome = nome;
	}
    
}
