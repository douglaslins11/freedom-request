package DAO;

import Models.ItemModel;
import Models.PedidoModel;
import Models.Produto;

import java.util.List;

public interface PedidoDAO {

    public void fazerPedido(Produto item);
    public List retornarPedidos();
    public float conta();
}
