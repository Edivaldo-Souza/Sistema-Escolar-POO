class Turma {
  private int id;
  private Disciplina disciplina;
  private String horario;
  private Aluno[] alunos;
  private String local;
  private boolean status;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    if (id <= 0) {
      System.out.println("ID inválido.");
    } else
      this.id = id;
  }

  public Disciplina getDisciplina() {
    return disciplina;
  }

  public void setDisciplina(Disciplina disciplina) {
    if (disciplina == null) {
      System.out.println("A turma precisa de uma disciplina");
    } else
      this.disciplina = disciplina;
  }

  public String getHorario() {
    return horario;
  }

  public void setHorario(String horario) {
    if (horario == null || horario.isEmpty()) {
      System.out.println(
          "Insira um horário no modelo [Dias da semana(enumerados)][Turno(primeira letra do turno em maiusculo)][horarios(enumerados)]");
      System.out.println("Exemplo: 23M12(Segunda e terça, Manhã, primeiro e segundo horário)");
    } else
      this.horario = horario;
  }

  public Aluno[] getAlunos() {
    return alunos;
  }

  public void setAlunos(Aluno[] alunos) {
    if (alunos == null) {
      System.out.println("A turma precisa de alunos");
    } else
      this.alunos = alunos;
  }

  public String getLocal() {
    return local;
  }

  public void setLocal(String local) {
    if (local == null || local.isEmpty()) {
      System.out.println("Insira um local válido");
    }
    this.local = local;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public void cadastrar() {

  }

  public void editar() {

  }

}
