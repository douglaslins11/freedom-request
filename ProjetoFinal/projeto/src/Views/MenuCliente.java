package Views;

import java.util.Scanner;

public class MenuCliente {

    public void Menu() {
        ItemView acessoItem = new ItemView();
        PedidoView acessoPed = new PedidoView();
        int op;
        do {
            System.out.println("\n<<MENU CLIENTE>>");
            System.out.println("1 - Fazer pedido");
            System.out.println("2 - Mostrar cardapio");
            System.out.println("3 - Mostrar pedido");
            System.out.println("4 - Mostrar conta");
            System.out.println("5 - Mostrar conta Individual");
            System.out.println("6 - Mostrar Clientes da Mesa");
            System.out.println("7 - Voltar");
            op = new Scanner(System.in).nextInt();
            System.out.println("");
            switch (op) {
                case 1:
                    acessoPed.fazerPedido();
                    break;
                case 2:
                    acessoItem.mostrarCardapio();
                    ;
                    break;
                case 3:
                    acessoPed.mostrarPedidos();
                    break;
                case 4:
                    acessoPed.conta();
                    break;
                case 5:
                    acessoPed.contaIndividual();
                    break;
                case 6:
                    acessoPed.mostrarClientes();
                    break;

                case 7:
                    break;

                default:
                    System.out.println("Opcao invalida!!");
            }
        } while (op != 7);

    }

}
