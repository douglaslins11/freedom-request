package Controllers;

//import DAO.ItemDAO;
import DAO.ItemDAO;
import DAO.ItemDAOArquivo;
import FactoryMethod.FactoryItem;
import FactoryMethod.FactoryPedido;
import Models.CompositeItem;
import Models.ItemModel;
import Models.Produto;

import java.util.List;

public class ItemController {
    private ItemDAO acessoItDAO = FactoryItem.getInstance();

    public List mostrarCardapio() {
        return acessoItDAO.mostrarCardapio();

    }

    public List retornarCardapio() {
        return acessoItDAO.mostrarCardapio();

    }

    public Produto retornarItem(int cod) { //Acredito que no DAO já exista esse metodo implementado, tou comentando para vermos depois
        List<Produto> cardapio;
        Produto item;
        cardapio = acessoItDAO.mostrarCardapio();

        if (cardapio == null) {
            return null;
        } else {
            for (Produto aux : cardapio) {

                if (aux.getCod() == cod) {
                    item = clone(aux);
                    return item;
                }
            }
        }

        return null;
    }

    public void adicionarItem(Produto item) {
        acessoItDAO.adicionarItem(item);
    }

    private Produto clone(Produto aux) {
        Produto novo;
        if (CompositeItem.class == aux.getClass()) {
            novo = new CompositeItem();
        } else {
            novo = new ItemModel();

        }
        novo.setValor(aux.getValor());
        novo.setCod(aux.getCod());
        novo.setNome(aux.getNome());

        return novo;
    }

    public boolean removerItem(int cod) {
        List<Produto> cardapio;
        cardapio = retornarCardapio();

        if (cardapio == null) {
            return false;
        } else {
            for (Produto aux : cardapio) {

                if (aux.getCod() == cod) {
                    acessoItDAO.removerItem(aux);
                    return true;
                }

            }
        }
        return false;
    }
    
    public Produto alterarItem(int cod){

        return acessoItDAO.retornarItem(cod);
    }

    public void salvarDados() {
        acessoItDAO.save();
    }


}
