package Controllers;

import DAO.ClienteDAO;
import FactoryMethod.FactoryCliente;
import Models.ClienteModel;
import java.util.ArrayList;
public class ClienteController {

    private ClienteDAO dao = FactoryCliente.getInstance();

    public ClienteModel buscar (String telefone){
        ClienteModel cliente = dao.buscarCliente(telefone);
        return cliente;
    }

    public ClienteModel inserir (String nome, String telefone){
        ClienteModel cliente;

            cliente = new ClienteModel(nome, telefone);
            cliente.setQtdVezesRest(cliente.getQtdVezesRest() + 1);
            return cliente;
    }

    public boolean alterar (String telefone, String novoTelefone){
        ClienteModel cliente = dao.buscarCliente(telefone);
        if(cliente == null){
            return false;
        }
        else{
            dao.alterarCliente(novoTelefone,cliente);
            return true;
        }
    }
    
    public void remover (ClienteModel cliente){
        dao.removerCliente(cliente);
    }
    
    public ArrayList listaClientes (){
        return dao.retornaClientes();
    }
}
