package DAO;

import Models.ItemModel;
import Models.PedidoModel;
import Models.Produto;

import java.util.List;

public class PedidoDAOMemoria implements PedidoDAO {

    private PedidoModel pedidos;
    private static PedidoDAOMemoria instancia;

    private PedidoDAOMemoria() {
        pedidos = new PedidoModel();
    }

    public static PedidoDAOMemoria getInstance(){
        if(instancia == null)
            instancia = new PedidoDAOMemoria();
        return instancia;
    }

    @Override
    public void fazerPedido(Produto item) {
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
}
