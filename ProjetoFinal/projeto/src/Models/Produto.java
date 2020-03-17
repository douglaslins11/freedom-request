package Models;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

public abstract class Produto implements Comparator,Serializable  {

    float valor;
    int cod;
    String nome;
    protected int tam;
    protected List<ClienteModel> clientes;

    public abstract float getValor();

    public abstract int getTam();

    public abstract List<ClienteModel> getClientes();

    public abstract String getNome();

    public abstract int getCod();
    
    public abstract void setCod(int cod);
    
    public abstract void setNome(String nome);
    
    public abstract void setTam();
    
    public abstract void setValor(float valor);
    
    public abstract void setClientes(ClienteModel cliente);
}
