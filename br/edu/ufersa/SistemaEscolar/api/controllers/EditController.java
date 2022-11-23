package br.edu.ufersa.SistemaEscolar.api.controllers;
import br.edu.ufersa.SistemaEscolar.model.services.*;
import br.edu.ufersa.SistemaEscolar.view.Telas;


public abstract class EditController{
	
	public void editHandle(){
		
	}	
	public void delHandle() {
		
	}
	
	public void switchToMain() {
		Telas.paginaPrincipal(SecaoTipo.DIRETOR, null);		
	}
	
	public boolean checkLogin(String usuario,String senha,String confirmSenha) {
		if(usuario.length()<=1 && senha.length()<=1 && senha.equals(confirmSenha)) {
			return true;
		}else {
			return false;
		}
	}
}
