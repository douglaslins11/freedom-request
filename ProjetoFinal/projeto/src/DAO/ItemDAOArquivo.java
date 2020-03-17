package DAO;

import Models.ComparatorProduto;
import Models.ItemModel;
import Models.Produto;
import Models.Produto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemDAOArquivo implements ItemDAO {

    private List<Produto> cardapio;
    private static ItemDAOArquivo instancia;

    private ItemDAOArquivo() {
    //  cardapio = new ArrayList<>();
       cardapio = load(cardapio);
    }

    public static ItemDAOArquivo getInstance() {
        if (instancia == null) {
            instancia = new ItemDAOArquivo();
        }
        return instancia;
    }
    @Override
    public List mostrarCardapio() {
        return cardapio;
    }
    @Override
    public void adicionarItem(Produto item) {
        cardapio.add(item);
        Collections.sort(cardapio, new ComparatorProduto());

    }
    @Override
    public void removerItem(Produto item) {
        cardapio.remove(item);
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

    public void save() { //Salvar a lista no arquivo
        //Adicionar ArrayList de funcionarios dentro do Arquivo
        try {
            FileOutputStream salvarFile = new FileOutputStream("Produto"); //Cria arquivo para ser escrito
            ObjectOutputStream objeto = new ObjectOutputStream(salvarFile); //Objeto que vai escrever no arquivo
            objeto.writeObject(cardapio);//Grava a Arraylist no arquivo
            objeto.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(ItemDAOArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List load(List<Produto> cardapio) {
        //Recriar ArrayList de Funcionarios
        try {
            FileInputStream recuperarFile = new FileInputStream("Produto"); //Abro arquivo
            ObjectInputStream stream = new ObjectInputStream(recuperarFile); //
            ArrayList<Produto> novo = (ArrayList<Produto>) stream.readObject();//Recupera a lista de objetos
            cardapio = new ArrayList();
            cardapio.addAll(novo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemDAOArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemDAOArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemDAOArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cardapio;
    }

}
