package Views;

import java.util.Scanner;

public class MenuAdm {

    public void Menu() {
        ItemView acessoItem = new ItemView();
        PedidoView acessoPedido = new PedidoView();
        ClienteView acessoCliente = new ClienteView();
        int op;
        do {
            System.out.println("\n<<MENU ADM>>");
            System.out.println("1 - Adicionar item ao cardapio");
            System.out.println("2 - Remover item do cardapio");
            System.out.println("3 - Alterar item do cardapio");
            System.out.println("4 - Mostrar cardapio");
            System.out.println("5 - Adicionar Combo ao cardapio");
            System.out.println("6 - Mostrar Histórico de Pedidos");
            System.out.println("7 - Fechar conta");
            System.out.println("8 - Alterar telefone do cliente");
            System.out.println("9 - Voltar\n");
            op = new Scanner(System.in).nextInt();
            System.out.println("");
            switch (op) {

                case 1:
                    acessoItem.adicionarItem();
                    break;

                case 2:
                    acessoItem.removerItem();
                    break;
                case 3:
                    acessoItem.alterarItem();
                    break;
                case 4:
                    acessoItem.mostrarCardapio();
                    break;
                case 5:
                    acessoItem.adicionarCombo();
                    break;
                case 6:
                    acessoPedido.historicoPedidos();
                    break;
                case 7:
                    acessoPedido.contaIndividual();
                    acessoPedido.salvarHistorico();
                    return;

                case 8:
                    acessoCliente.alterarCliente();
                    break;

                case 9:
                    acessoItem.salvar();
                    break;

                default:
                    System.out.println("\nOpção invalida!!!");

            }
        } while (op != 8);

    }

}

