package ui;

import java.util.Scanner;

public class UIBalconista implements IMenu {
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void showMenu() {
        String opcao;
        boolean sair = false;

        while (!sair) {
            System.out.println("*** Menu Balconista ***");
            System.out.println("0 - Sair");
            System.out.println("1 - Criar pedido para o cliente");
            System.out.println("2 - Enviar solicitação para gerente");
            System.out.print("Opção >> ");

            opcao = scanner.nextLine();
            System.out.println();

            if (opcao.equals("0")) {
                sair = true;
            } else if (opcao.equals("1")) {
                criarPedido();
            } else if (opcao.equals("2")) {
                enviarSolicitacao();
            }
        }

    }

    private void criarPedido() {
    }

    private void enviarSolicitacao() {
    }
    
}