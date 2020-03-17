package Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ItemModel extends Produto {

    private List <ClienteModel> clientes;


    @Override
    public float getValor() {
        return valor;
    }

    public int getTam() {
        return tam;
    }

    public void setTam() {
        this.tam++;
    }

    @Override
    public void setValor(float v) {
        valor = v;
    }


    public List<ClienteModel> getClientes() {
        return clientes;
    }

    public void setClientes(ClienteModel cliente) {
        if(clientes == null)clientes = new ArrayList<>();
        clientes.add(cliente);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }


    public int compare(ItemModel item1, ItemModel item2) {
        return item1.getCod() - item2.getCod();
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
