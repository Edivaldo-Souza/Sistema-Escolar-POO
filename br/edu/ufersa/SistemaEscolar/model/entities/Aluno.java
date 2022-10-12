package br.edu.ufersa.SistemaEscolar.model.entities;
import java.util.List;

import java.util.Iterator;

public class Aluno extends Afiliado{
    private String matricula;
    private List<ResultadoTurma> historico;
    
    public Aluno() {}

    public Aluno(String nome, Endereco endereco, String matricula) {
        super(nome,endereco);
    	setMatricula(matricula);
    }

    public void setMatricula(String matricula) {
        if (matricula.isEmpty()) this.matricula = "indefinido";
        else this.matricula = matricula;
    }

    public void setHistorico(ResultadoTurma result){
        Iterator<ResultadoTurma> it = historico.iterator();
        for(int i = 0; i<historico.size(); i++) {
        	if(it.next() == null) historico.add(i, result); 
        }
    }

    public String getMatricula() {return this.matricula;}

    public List<ResultadoTurma> getHistorico() {return this.historico;}

}