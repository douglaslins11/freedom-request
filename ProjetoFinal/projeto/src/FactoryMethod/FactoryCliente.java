package FactoryMethod;

import DAO.ClienteDAO;
import DAO.ClienteDAOArquivo;
import DAO.ClienteDAOMemoria;
import DAO.Memento;

public class FactoryCliente {
    
    public static ClienteDAO getInstance(){
        int tipoDao=0;//iniciei com 0, para não dar erro no if abaixo
        //codigo que descobre o tipoDao
        Memento.save(1);
        tipoDao = Memento.load();
        
        if(tipoDao == 1){
            return ClienteDAOMemoria.getInstance();
        }
        else{
            return ClienteDAOArquivo.getInstance();
        }
    }
}
