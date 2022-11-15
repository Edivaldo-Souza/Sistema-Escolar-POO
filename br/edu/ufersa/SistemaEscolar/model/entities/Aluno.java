package br.edu.ufersa.SistemaEscolar.model.entities;

import java.util.List;

import br.edu.ufersa.SistemaEscolar.api.dto.AlunoDTO;

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
        	if(it.next().getDisciplina().getCodigo() ==  result.getDisciplina().getCodigo()
        	   || it.next() == null) {
        		historico.add(i,result);
        	}
        }
    }

    public String getMatricula() {return this.matricula;}

    public List<ResultadoTurma> getHistorico() {return this.historico;}
    
    public ResultadoTurma getHistorico(String cod_disciplina) {
    	Iterator<ResultadoTurma> iterator_R = historico.iterator();
    	
    	while(iterator_R.hasNext()) {
    		ResultadoTurma resultado = iterator_R.next();
    		if(resultado.getDisciplina().getCodigo() == cod_disciplina){
    			return resultado;
    		}
    	}
    	return null;
    }
    
    public void converter(AlunoDTO e) {
    	Endereco end = new Endereco();
    	setNome(e.getNome());
    	setMatricula(e.getMatricula());
    	end.setRua(e.getRua());
    	end.setBairro(e.getBairro());
    	end.setNumero(e.getNumeroEndereco());
    	setEndereco(end);
    	setUsuario(e.getUsuario());
    	setSenha(e.getSenha());
    }

}