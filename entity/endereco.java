package entity;

class Endereco {
    private String rua;
    private int numero;
    private String bairro;

    Endereco(String rua, String bairro, int numero) {
        setRua(rua);
        setBairro(bairro);
        setNumero(numero);
    }

    public void setNumero(int numero) {
        if (numero > 0) {
            this.numero = numero;
        } else
            this.numero = 0;
    }

    public void setRua(String rua) {
        if (rua.isEmpty())
            this.rua = "indefinido";
        else
            this.rua = rua;
    }

    public void setBairro(String bairro) {
        if (bairro.isEmpty())
            this.bairro = "indefinido";
        else
            this.bairro = bairro;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getRua() {
        return this.rua;
    }

    public String getBairro() {
        return this.bairro;
    }

}
