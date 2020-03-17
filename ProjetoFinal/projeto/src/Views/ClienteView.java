package Views;

import Controllers.ClienteController;
import Models.ClienteModel;

import java.util.Scanner;

public class ClienteView {

    ClienteController acesso = new ClienteController();
    


    public ClienteModel inserirCliente(){
        String nome;
        String telefone;

        System.out.println("Informe o telefone ");
        telefone = new Scanner (System.in).nextLine();
        ClienteModel cliente = acesso.buscar(telefone);

        if(cliente == null){
            System.out.println("Informe o nome do cliente: ");
            nome = new Scanner(System.in).nextLine();
            cliente = acesso.inserir(nome,telefone);
        }

        return cliente;
    }
    
    public void alterarCliente(){
        System.out.print("Informe o telefone antigo: ");
        String telefone = new Scanner (System.in).nextLine();
        System.out.print("Informe o novo numero do cliente: ");
        String novotelefone = new Scanner (System.in).nextLine();
        boolean result = acesso.alterar(telefone,novotelefone);
        
        if(result == false){
            System.out.println("Cliente nunca visitou restaurante");
        }
        else{
            System.out.println("Dados alterados com sucesso");
        }
    }
}
