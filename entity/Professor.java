class Professor{

	private String nome;
	private Endereco endereco;
	private String cpf;
	private Turmas[] turmas;


	Professor(String nome,String cpf){
		this.setCpf(cpf);
		this.setEndereco(endereco);
		this.setNome(nome);
	}


	public void setNome(String nome) {
		if(this.nome.isEmpty())
		System.out.prinln("Nome invalido");
		else
		this.nome = nome;

	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;

	}

	public void setCpf(String cpf) {	
		if(this.cpf.isEmpty())
		System.out.prinln("Nome invalido");
		else
		this.cpf = cpf;

	}

	public String getCpf() {
		return this.cpf;
	}

	public String getNome() {
		return this.nome;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public Turmas[] getTurmas() {
		return this.turmas;
	}

	void cadastrar(Professor novo){
		//Inserir no banco de dados
	}

	void deletar(){
		//Deletar no banco de dados
	}

	void editar(){
		//Editar no banco de dados

	}





}
