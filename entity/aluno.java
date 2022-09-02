package entity;
class Aluno{
    private String nome;
    private Endereco endereco;
    private String matricula;
    
    Aluno(String nome, String matricula, Endereco endereco){
        setNome(nome);
        setMatricula(matricula);
        this.endereco = endereco;
    }

    public void setNome(String nome){
        if(nome.isEmpty()) this.nome = "indefinido";
        else this.nome = nome;
    }
    
    public void setMatricula(String matricula){
        if(matricula.isEmpty()) this.matricula = "indefinido";
        else this.matricula = matricula;
    }

    public String getNome(){return this.nome;};
    public String getMatricula(){return this.matricula;};

}