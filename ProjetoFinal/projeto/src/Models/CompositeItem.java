package Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CompositeItem extends Produto{
    List<Produto> itens;


    public CompositeItem() {
        itens = new ArrayList();
        clientes = new ArrayList();
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public List<ClienteModel> getClientes() {
        return clientes;
    }
    
    public void setClientes(ClienteModel clientes) {
        this.clientes.add(clientes);
    }

    public List<Produto> getItens() {
        return itens;
    }

    public void setItens(Produto item1, Produto item2, Produto item3) {
        this.itens.add(item1);
        this.itens.add(item2);
        this.itens.add(item3);
        valor += item1.getValor() + item2.getValor() + item3.getValor();
    }

    @Override
    public float getValor() {
        return valor;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(Produto combo) {
        this.nome = "COMBO: " + itens.get(0).getNome() + "," + itens.get(1).getNome() + " e " + itens.get(2).getNome();

    }

    @Override
    public int getCod() {
        return cod;
    }

    @Override
    public void setCod(int cod) {
        this.cod = cod;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void setTam() {
        this.tam++;
    }

    @Override
    public void setValor(float valor) {

        this.valor = valor;
    }


    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
