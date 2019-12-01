package ui;

import java.util.Scanner;

public class UICadastroInsumo implements IMenu{
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void showMenu() {
        boolean sair = false;
        String opcao;

        while(!sair) {
            System.out.println("*** Menu Cadastro de Insumos ***");
            System.out.println("0 - Sair");
            System.out.println("1 - Inserir Insumo");
            System.out.println("2 - Remover Insumo");
            System.out.println("3 - Procurar Insumo");
            System.out.println("4 - Atualizar Insumo");
            System.out.print("Opção >> ");

            opcao = scanner.nextLine();
            System.out.println();

            if (opcao.equals("0")) {
                sair = true;
            }
        }

    }


}