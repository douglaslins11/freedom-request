package DAO;

import Models.ClienteModel;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAOArquivo implements ClienteDAO,Serializable {
    
    private static ClienteDAOArquivo self;
    ArrayList<ClienteModel> clientes;

    private ClienteDAOArquivo() {
        clientes = new ArrayList<ClienteModel>();
     //   clientes = load(clientes);
    }

    public static ClienteDAOArquivo getInstance(){
        if(self==null)
            self = new ClienteDAOArquivo();
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

    public void save() { //Salvar a lista no arquivo
        //Adicionar ArrayList de funcionarios dentro do Arquivo
        try {
            FileOutputStream salvarFile = new FileOutputStream("Clientes"); //Cria arquivo para ser escrito
            ObjectOutputStream objeto = new ObjectOutputStream(salvarFile); //Objeto que vai escrever no arquivo
            objeto.writeObject(clientes);//Grava a Arraylist no arquivo
            objeto.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(ItemDAOArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList load(ArrayList<ClienteModel> clientes) {
        //Recriar ArrayList de Funcionarios
        try {
            FileInputStream recuperarFile = new FileInputStream("Clientes"); //Abro arquivo
            ObjectInputStream stream = new ObjectInputStream(recuperarFile); //
            ArrayList<ClienteModel> novo = (ArrayList<ClienteModel>) stream.readObject();//Recupera a lista de objetos
            clientes = new ArrayList();
            clientes.addAll(novo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemDAOArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemDAOArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemDAOArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
}
