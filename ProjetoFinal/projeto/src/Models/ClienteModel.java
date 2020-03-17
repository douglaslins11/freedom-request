package Models;

import java.io.Serializable;

public class ClienteModel implements Serializable {
    
    private String nome, telefone;
    private float valor;
    private int qtdVezesRest; //Cartão fidelidade, após 5 visitas ao restaurante, o cliente recebe um desconto de 20% no valor da conta

    public ClienteModel(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.valor = 0f;
        this.qtdVezesRest = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor += valor;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getQtdVezesRest() {
        return qtdVezesRest;
    }

    public void setQtdVezesRest(int qtdVezesRest) {
        this.qtdVezesRest = qtdVezesRest;
    }
}