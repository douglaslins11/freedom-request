package FactoryMethod;

import DAO.ItemDAO;
import DAO.ItemDAOArquivo;
import DAO.ItemDAOMemoria;
import DAO.Memento;

public class FactoryItem {
    public static ItemDAO getInstance(){
        int tipoDao=0;//iniciei com 0, para não dar erro no if abaixo
        //codigo que descobre o tipoDao
        Memento.save(1);
        tipoDao = Memento.load();

        if(tipoDao == 1)
            return ItemDAOMemoria.getInstance();
        else
            return ItemDAOArquivo.getInstance();
    }
}
