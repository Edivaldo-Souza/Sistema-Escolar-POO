class Disciplina{

	private String rua;
	private String bairro;
	private Integer numero;

	public void setRua(String rua) {
		if(this.rua.isEmpty())
		System.out.println("Nome de rua invalido");
		else 
		this.rua = rua;
	}

	public void setBairro(String bairro) {
		if(this.bairro.isEmpty())
		System.out.println("Nome de rua invalido");
		else 
		this.bairro = bairro;
	}

	public void setNumero(Integer numero) {
		if(this.numero.isEmpty())
		System.out.println("Nome de rua invalido");
		else 
		this.numero = numero;
	}

	public String getRua() {
		return this.rua;
	}

	public String getBairro() {
		return this.bairro;
	}

	public Integer getNumero() {
		return this.numero;
	}

	void cadastrar(){
		// cadastrar no banco de dados
	}

	void deletar(){
		// deletar no banco de dados
	}

	void editar(){
		// editar no banco de dados
	}
}
