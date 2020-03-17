package Views;

import Controllers.ItemController;
import Models.CompositeItem;
import Models.ItemModel;
import Models.Produto;

import java.util.List;
import java.util.Scanner;

public class ItemView {

    ItemController acesso = new ItemController();

    public void adicionarItem() {
        ItemModel item = new ItemModel();
        System.out.println("Informe o nome do produto:");
        item.setNome(new Scanner(System.in).nextLine());
        System.out.println("Informe o preço do produto:");
        item.setValor(new Scanner(System.in).nextFloat());
        System.out.println("Informe o codigo do produto:");
        item.setCod(new Scanner(System.in).nextInt());
        acesso.adicionarItem(item);
    }

    public void removerItem() {
        acesso.mostrarCardapio();
        System.out.println("Informe o codigo do produto que deseja retirar:");
        if (acesso.removerItem(new Scanner(System.in).nextInt())) {
            System.out.println("\nProduto removido do cardapio!!");
        } else {
            System.out.println("\nProduto não encontrado! Não foi possível remover. \n");
        }

    }

    public void adicionarCombo() {

        CompositeItem combo = new CompositeItem();
        Produto item1;
        Produto item2;
        Produto item3;

        mostrarCardapio();

        System.out.println("Informe o codigo do primeiro item :");
        item1 = acesso.retornarItem(new Scanner(System.in).nextInt());
        System.out.println("Informe o codigo do segundo item :");
        item2 = acesso.retornarItem(new Scanner(System.in).nextInt());
        System.out.println("Informe o codigo do terceiro item :");
        item3 = acesso.retornarItem(new Scanner(System.in).nextInt());
        combo.setItens(item1, item2, item3);
        combo.setNome(combo);
        System.out.println("Informe o codigo do produto :");
        combo.setCod(new Scanner (System.in).nextInt());
        System.out.println("Combo criado com sucesso");
        acesso.adicionarItem(combo);

    }

    public void mostrarCardapio() {
        List<Produto> cardapio;
        cardapio = acesso.mostrarCardapio();
        if (cardapio == null || cardapio.isEmpty()) {
            System.out.println("Cardapio vazio!!");
        } else {
            System.out.println("\n<<<<<<<<<<<<<<<>>>>>>>>>>>>>>");
            for (Produto aux : cardapio) {
                System.out.println("Nome: " + aux.getNome());
                System.out.println("Preco: " + aux.getValor());
                System.out.println("Codigo do produto: " + aux.getCod());
                System.out.println("<<<<<<<<<<<<<<<>>>>>>>>>>>>>>\n");
            }
        }

    }

    public Produto escolherItem(int cod) {
        return acesso.retornarItem(cod);
    }

    public boolean checarCardapio() {
        List<ItemModel> cardapio;
        cardapio = acesso.mostrarCardapio();
        return !cardapio.isEmpty();
    }

    public void alterarItem() {
        Produto item;
        int cod, op;
        mostrarCardapio();

        System.out.println("Informe o codigo do item a ser alterado");
        cod = new Scanner(System.in).nextInt();
        item = acesso.alterarItem(cod);

        if (item != null) {

            do {
                System.out.println("<<<<<Menu de alteração : >>>>>>>>>");
                System.out.println("1 - Alterar nome \n2 - Alterar preço");
                System.out.println("3 - Alterar código \n4 - Voltar");
                op = new Scanner(System.in).nextInt();

                switch (op) {

                    case 1:
                        System.out.println("Informe o novo nome :");
                        item.setNome(new Scanner(System.in).nextLine());
                        break;
                    case 2:
                        System.out.println("Informe o novo preço :");
                        item.setValor(new Scanner(System.in).nextFloat());
                        break;
                    case 3:
                        System.out.println("Informe o novo código :");
                        item.setCod(new Scanner(System.in).nextInt());
                        break;
                    case 4:
                        System.out.println("alterações salvas!");
                        break;

                    default:
                        System.out.println("Opção inválida!!!");

                }

            } while (op != 4);

        } else {
            System.out.println("Item não encontrado!! Verifique o cardápio.");
        }

    }
    
    public void salvar(){
       acesso.salvarDados();
    }

}
