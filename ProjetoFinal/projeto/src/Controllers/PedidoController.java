package Controllers;

import DAO.PedidoDAO;
import DAO.PedidoDAOArquivo;
import FactoryMethod.FactoryPedido;
import Models.ItemModel;
import Models.PedidoModel;
import Models.Produto;

import java.util.List;

public class PedidoController {

    PedidoDAO instancia = FactoryPedido.getInstance();

    public void fazerPedido(Produto item) {
        instancia.fazerPedido(item);
    }

    public List mostrarPedidos() {
        return instancia.retornarPedidos();
    }

    public float conta() {
        return instancia.conta();
    }

    /*public List<PedidoModel> Historico() {
       return instancia.loadHistoricoPedidos();
    }

    public void salvarPedido() {
        instancia.saveHistoricoPedidos();
    }*/

}
