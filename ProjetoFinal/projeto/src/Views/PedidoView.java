package Views;

import Controllers.PedidoController;
import Models.ClienteModel;
import Models.ItemModel;
import Models.PedidoModel;
import Models.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PedidoView {

    PedidoController acessoController = new PedidoController();
    ItemView cardapio = new ItemView();
    ClienteView viewClientes = new ClienteView();

    List<ClienteModel> clientes = new ArrayList();
    ClienteModel cliente;

    public void fazerPedido() {
        Produto item;
        int cod, op;
        String nome;
        if (!cardapio.checarCardapio()) {
            System.out.println("Cardapio vazio!!");
            return;
        }
        cardapio.mostrarCardapio();
        System.out.println("Informe o codigo do produto: ");
        cod = new Scanner(System.in).nextInt();
        item = cardapio.escolherItem(cod);
        do {
            if (clientes != null && !clientes.isEmpty()) {
                System.out.println("Clientes na mesa :");
                System.out.println("========================");
                for (ClienteModel aux : clientes) {
                    System.out.println("Nome :" + aux.getNome());
                    System.out.println("========================");
                }
            }
            cliente = viewClientes.inserirCliente();
            if (!clientes.contains(cliente)) {
                clientes.add(cliente);
            }
            item.setClientes(cliente);

            System.out.println("Deseja adicionar mais alguem?");
            System.out.println("1 - Sim \n2 - Nao");
            op = new Scanner(System.in).nextInt();
            item.setTam();
        } while (op != 2);
        for (ClienteModel aux : item.getClientes()) {
            aux.setValor(item.getValor() / item.getTam());
        }
        acessoController.fazerPedido(item);
    }

    public void mostrarPedidos() {
        List<ItemModel> pedidos;
        pedidos = acessoController.mostrarPedidos();

        if (pedidos.isEmpty()) {
            System.out.println("Não existem pedidos para a mesa");

        } else {
            for (ItemModel aux : pedidos) {
                System.out.println("Nome do produto: " + aux.getNome());
                System.out.println("Preço do produto: " + aux.getValor());
                System.out.println("Clientes do pedido: ");
                for (int i = 0; i < aux.getTam(); i++) {
                    System.out.println("[" + aux.getClientes().get(i).getNome() + "]");
                }

            }
        }

    }

    public void conta() {
        List<ItemModel> pedidos;
        pedidos = acessoController.mostrarPedidos();

        if (pedidos.isEmpty()) {
            System.out.println("Não existem pedidos para a mesa");

        } else {
            for (ItemModel aux : pedidos) {
                System.out.println("\nNome do produto: " + aux.getNome());
                System.out.println("Preço do produto: " + aux.getValor());
                System.out.print("Clientes do pedido: ");
                for (int i = 0; i < aux.getTam(); i++) {
                    System.out.print("[" + aux.getClientes().get(i).getNome() + "]");
                }
                System.out.println("");

            }
            System.out.println("\nValor Total: [" + acessoController.conta() + "]");
        }

    }

    public void contaIndividual() {
        int i = 0, j;
        List<ClienteModel> clientes = new ArrayList<>();
        List<ItemModel> pedidos;
        pedidos = acessoController.mostrarPedidos();

        if (pedidos.isEmpty()) {
            System.out.println("Não existem pedidos para a mesa");

        } else {
            for (ItemModel aux : pedidos) {
                System.out.println("<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>");
                System.out.println("Pedido numero " + (i + 1));
                System.out.println("Nome do produto: " + aux.getNome());
                System.out.println("Preço do produto: " + aux.getValor());
                System.out.println("Clientes do pedido: ");
                for (j = 0; j < pedidos.get(i).getClientes().size(); j++) {
                    System.out.println("[" + pedidos.get(i).getClientes().get(j).getNome() + "]" + "\n[Valor Individual do cliente no pedido:  " + pedidos.get(i).getValor() / pedidos.get(i).getClientes().size() + "]");
                    if (!clientes.contains(pedidos.get(i).getClientes().get(j))) {
                        clientes.add(pedidos.get(i).getClientes().get(j));
                    }
                }
                System.out.println("<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>");
                i++;
            }
            i = 0;
            System.out.println("");
            for (ClienteModel aux : clientes) {
                System.out.print("Valor Individual do cliente" + "[" + clientes.get(i).getNome() + "] :");
                System.out.println(clientes.get(i).getValor());
                i++;
            }
            System.out.println("\nValor Total: [" + acessoController.conta() + "]");
        }

    }

    void historicoPedidos() {

        List<PedidoModel> historico = new ArrayList();

      //  historico = acessoController.Historico();

        if (historico == null || historico.isEmpty()) {
            System.out.println("Histórico de Pedidos vazio");
        } else {

            for (PedidoModel aux : historico) {
                System.out.println("Numero de Pedidos : " + aux.getId());
                System.out.println("Valor da Conta : " + aux.getPrecoTotal());
                System.out.println("<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>");
            }
            System.out.println("<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>");

        }

    }

    void salvarHistorico() {
      //  acessoController.salvarPedido();

    }
    
    void mostrarClientes(){
        
        if(clientes.isEmpty()){
            System.out.println("Nao existem clientes na mesa!");
        }
        else{
            System.out.println("CLIENTES NA MESA :");
            System.out.println("<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>");
            for (ClienteModel aux : clientes){
                System.out.println("Nome :" + aux.getNome());
                System.out.println("<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>");
            }
        
        }
    
    }
}
