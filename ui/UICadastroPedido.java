package ui;

import java.util.Scanner;
import controlador.Fachada;
import exception.PedidoException;
import model.Pedido;

public class UICadastroPedido implements IMenu {
    private static Scanner scanner = new Scanner(System.in);   

    @Override
    public void showMenu() {
        String opcao;
        boolean sair = false;

        while (!sair) {
            System.out.println("*** Menu Cadastro de Pedidos ***");
            System.out.println("0 - Sair");
            System.out.println("1 - Remover Pedido");
            System.out.println("2 - Procurar Pedido");
            System.out.print("Opção >> ");

            opcao = scanner.nextLine();
            System.out.println();

            if (opcao.equals("0")) {
                sair = true;
            } else if (opcao.equals("1")) {
                removerPedido();
            } else if (opcao.equals("2")) {
                procurarPedido();
            }
        }
    }

    private void removerPedido() {
        String id;

        System.out.print("id do Pedido: ");
        id = scanner.nextLine();

        try {
            Fachada.getInstancia().removerPedido(id);
            System.out.println("Pedido removido com sucesso!");
            System.out.println();
        } catch (PedidoException e) {
            System.out.println("Erro ao remover o pedido: " + e.getMessage());
            System.out.println();
        }
    }

    private void procurarPedido() {
        Pedido pedido;
        String id;

        System.out.println("id do Pedido: ");
        id = scanner.nextLine();

        try {
            pedido = Fachada.getInstancia().procurarPedido(id);
        } catch (PedidoException e) {
            System.out.println("Erro ao procurar o pedido: " + e.getMessage());
            System.out.println();
            return;
        }

        if (pedido == null) {
            System.out.println("Não existe pedido com o id procurado (" + id + ")");
            System.out.println();
        } else {
            System.out.println(pedido);
            System.out.println();
        }
    }  
}