package Views;

import Models.PedidoModel;
import java.util.Scanner;

public class menuPrincipal {

    public static void main(String[] args) {
        int op;
        MenuAdm acessoAdm = new MenuAdm();        
        MenuCliente acessoCliente = new MenuCliente();
        do {
            
            System.out.println("<<MENU PRINCIPAL>>");
            System.out.println("1 - Administrador");
            System.out.println("2 - Cliente");
            System.out.println("3 - Sair");           
            op = new Scanner(System.in).nextInt();
            switch (op) {

                case 1:
                    acessoAdm.Menu();
                    break;
                case 2:
                    acessoCliente.Menu();
                    break;
                case 3:                    
                    break;
            }
        } while (op != 3);

    }

}
