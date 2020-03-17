package DAO;

import Models.ItemModel;
import Models.Produto;

import java.util.ArrayList;
import java.util.List;

 public class ItemDAOMemoria implements ItemDAO {
    List<Produto> cardapio;
    private static ItemDAOMemoria instancia;

    private ItemDAOMemoria() {

        cardapio = new ArrayList<>();
    }

    public static ItemDAOMemoria getInstance(){
        if(instancia == null)
            instancia = new ItemDAOMemoria();
        return instancia;
    }

    @Override
    public List mostrarCardapio() {
        return cardapio;
    }

    @Override
    public Produto retornarItem(int cod) {
        if (cardapio.isEmpty()) {
            return null;
        }
        else {
            for (Produto aux : cardapio) {
                if (aux.getCod() == cod) {
                    return aux;
                }
            }
        }
        return null;
    }

    @Override
    public void adicionarItem(Produto item) {
        cardapio.add(item);
    }

    @Override
    public void removerItem(Produto item) {
        cardapio.remove(item);
    }

    @Override
    public void save() {

    }
}
