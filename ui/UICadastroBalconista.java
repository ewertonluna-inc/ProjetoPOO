package ui;

import java.util.Scanner;

public class UICadastroBalconista implements IMenu {
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void showMenu() {
        boolean sair = false;
        String opcao;

        while(!sair) {
            System.out.println("*** Menu Cadastro de Balconista ***");
            System.out.println("0 - Sair");
            System.out.println("1 - Inserir Balconista");
            System.out.println("2 - Remover Balconista");
            System.out.println("3 - Procurar Balconista");
            System.out.println("4 - Atualizar Balconista");
            System.out.println("Opção >> ");

            opcao = scanner.nextLine();

            if (opcao.equals("0")) {
                sair = true;
            } else if (opcao.equals("1")) {
                // inserirBalconista();
            } else if (opcao.equals("2")) {
                // removerBalconista();
            } else if (opcao.equals("3")) {
                // procurarBalconista();
            } else if (opcao.equals("4")) {
                // atualizarBalconista();
            }
        }

    }

    private void atualizarBalconista() {
    }

    private void inserirBalconista() {
    }

    private void removerBalconista() {
    }

    private void procurarBalconista() {
    }
    
}