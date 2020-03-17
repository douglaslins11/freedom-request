package FactoryMethod;

import DAO.Memento;
import DAO.PedidoDAO;
import DAO.PedidoDAOArquivo;
import DAO.PedidoDAOMemoria;

public class FactoryPedido {
    public static PedidoDAO getInstance (){
        int tipoDao=0;
        Memento.save(1);
        tipoDao = Memento.load();

        if(tipoDao == 1)
            return PedidoDAOMemoria.getInstance();
        else
            return PedidoDAOArquivo.getInstance();
    }
}
