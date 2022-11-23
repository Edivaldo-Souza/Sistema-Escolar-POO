package br.edu.ufersa.SistemaEscolar.api.dto;

import br.edu.ufersa.SistemaEscolar.model.services.SecaoTipo;

public class SecaoDTO {
	
	private SecaoDTO() {}
	private static SecaoDTO secaoAtual = new SecaoDTO();
	public static SecaoDTO getSecao() {
		return secaoAtual;
	}
	
	private SecaoTipo minhaSecao;
	private AfiliadoDTO usuarioAtual;
	private String usuarioId;
	public SecaoTipo getMinhaSecao() {
		return minhaSecao;
	}
	public void setMinhaSecao(SecaoTipo minhaSecao) {
		this.minhaSecao = minhaSecao;
	}
	public AfiliadoDTO getUsuarioAtual() {
		return usuarioAtual;
	}
	public void setUsuarioAtual(AfiliadoDTO usuarioAtual) {
		this.usuarioAtual = usuarioAtual;
	}
	public String getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}
	
}
