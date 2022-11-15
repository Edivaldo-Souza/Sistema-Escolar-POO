package br.edu.ufersa.SistemaEscolar.model.entities;

public class Afiliado {
	private String nome;
    private Endereco endereco;
    private String usuario;
    private String senha;
    
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
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		if(usuario != null) this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		if(senha != null) this.senha = senha;
	}
}
