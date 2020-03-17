package DAO;

import Models.ItemModel;
import Models.PedidoModel;
import Models.Produto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoDAOArquivo implements PedidoDAO {

    private PedidoModel pedidos;
    private static PedidoDAOArquivo instancia;

    private PedidoDAOArquivo() {
        pedidos = new PedidoModel();
    }

    public static PedidoDAOArquivo getInstance() {
        if (instancia == null) {
            instancia = new PedidoDAOArquivo();
        }
        return instancia;
    }

    @Override
    public void fazerPedido(Produto item) {
          //pedido.add(item);
        pedidos.setItemModel(item);
        pedidos.setId();
        pedidos.setPrecoTotal(item.getValor());
    }

    @Override
    public List retornarPedidos() {
        return pedidos.getItemModel();
    }

    @Override
    public float conta() {
        return pedidos.getPrecoTotal();
    }

    public void saveHistoricoPedidos() { //Salvar a lista no arquivo
        //Adicionar ArrayList de funcionarios dentro do Arquivo
        if (pedidos.getId() == 0) {
            return;

        } else {
            try {
                List<PedidoModel> novo;
                novo = loadHistoricoPedidos();
                if(novo == null){
                    novo = new ArrayList();
                }
                if(!novo.contains(pedidos)){
                novo.add(pedidos);
                }
                FileOutputStream salvarFile = new FileOutputStream("HistoricoPed"); //Cria arquivo para ser escrito
                ObjectOutputStream objeto = new ObjectOutputStream(salvarFile); //Objeto que vai escrever no arquivo
                objeto.flush();
                objeto.writeObject(novo); //Grava a Arraylist no arquivo
                objeto.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(PedidoDAOArquivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public List loadHistoricoPedidos() {
        //Recriar ArrayList de Funcionarios

        try {
            FileInputStream recuperarFile = new FileInputStream("HistoricoPed"); //Abro arquivo 
            ObjectInputStream stream = new ObjectInputStream(recuperarFile); // 
            ArrayList<PedidoModel> novo;
            novo = (ArrayList<PedidoModel>) stream.readUnshared(); //Recupera a lista de objetos

            return novo;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PedidoDAOArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAOArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PedidoDAOArquivo.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

}
