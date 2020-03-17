package DAO;

import Models.ClienteModel;
import java.util.ArrayList;

public interface ClienteDAO {
    
    public void adicionarCliente (ClienteModel cliente);
    public void removerCliente (ClienteModel cliente);
    public void alterarCliente (String novoTelefone, ClienteModel cliente);
    public ArrayList retornaClientes();
    public ClienteModel buscarCliente (String telefone);
}
