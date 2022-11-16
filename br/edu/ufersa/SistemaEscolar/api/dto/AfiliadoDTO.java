package br.edu.ufersa.SistemaEscolar.api.dto;

public class AfiliadoDTO {
	private String nome;
	private String usuario;
	private String senha;
	private String rua;
	private String bairro;
	private int numeroEndereco;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public int getNumeroEndereco() {
		return numeroEndereco;
	}
	public void setNumeroEndereco(int numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}
	
	
}
