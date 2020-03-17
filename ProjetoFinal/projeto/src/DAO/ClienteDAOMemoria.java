package DAO;

import Models.ClienteModel;
import java.util.ArrayList;

public class ClienteDAOMemoria implements ClienteDAO {

    private static ClienteDAOMemoria self;
    ArrayList<ClienteModel> clientes;

    private ClienteDAOMemoria() {
        clientes = new ArrayList<ClienteModel>();
    }

    public static ClienteDAOMemoria getInstance(){
        if(self == null)
            self = new ClienteDAOMemoria();
        return self;
    }

    @Override
    public void adicionarCliente(ClienteModel cliente) {
        clientes.add(cliente);
    }

    @Override
    public void removerCliente(ClienteModel cliente) {
        clientes.remove(cliente);
    }

    @Override
    public void alterarCliente(String novoTelefone, ClienteModel cliente) {
        clientes.get(clientes.indexOf(cliente)).setTelefone(novoTelefone);
    }

    @Override
    public ArrayList retornaClientes() {
        return this.clientes;
    }

    @Override
    public ClienteModel buscarCliente(String telefone) {
        for(ClienteModel cliente: clientes){
            if(cliente.getTelefone().equals(telefone))
                return cliente;
        }
        return null;
    }
}
