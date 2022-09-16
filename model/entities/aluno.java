package mode.entity;

class Aluno {
    private String nome;
    private Endereco endereco;
    private String matricula;
    private ResultadoTurma historico[];

    Aluno(String nome, String matricula, Endereco endereco) {
        setNome(nome);
        setMatricula(matricula);
        this.endereco = endereco;
        historico = new ResultadoTurma[40];
    }

    public void setNome(String nome) {
        if (nome.isEmpty()) this.nome = "indefinido";
        else this.nome = nome;
    }

    public void setMatricula(String matricula) {
        if (matricula.isEmpty()) this.matricula = "indefinido";
        else this.matricula = matricula;
    }

    public void setHistorico(ResultadoTurma result){
        for(int i = 0; i<historico.length; i++){
            if(historico[i] == null){
                historico[i] = result;
                break;
            }
        }
    }

    public String getNome() {return this.nome;}

    public String getMatricula() {return this.matricula;}

    public Endereco getEndereco() {return this.endereco;}

    public ResultadoTurma[] getHistorico() {return this.historico;}

}