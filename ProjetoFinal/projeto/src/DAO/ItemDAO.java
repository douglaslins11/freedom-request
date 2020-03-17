package DAO;

import Models.ItemModel;
import Models.Produto;

import java.util.List;

public interface ItemDAO {
    
    public List mostrarCardapio();
    public Produto retornarItem(int cod);
    public void adicionarItem(Produto item);
    public void removerItem(Produto item);
    public void save();
}
