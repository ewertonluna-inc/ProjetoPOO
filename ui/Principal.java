package ui;

import java.util.Scanner;

// import controlador.*;
// import model.*;
// import repositorio.*;
// import exception.*;

public class Principal {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        
        boolean sair = false;
        String opcao;

        while (!sair) {
            System.out.println("*** Menu Principal ***");
            System.out.println("0 - Sair");
            System.out.println("1 - Cadastro de Balconista");
            System.out.println("2 - Cadastro de Cozinheiro");
            System.out.println("3 - Cadastro de Gerente");
            System.out.println("4 - Cadastro de Cliente");
            System.out.println("5 - Cadastro de Pedido");
            System.out.println("6 - Cadastro de Insumos");
            System.out.println("7 - Menu Balconista");
            System.out.println("8 - Menu Cozinheiro");
            System.out.println("9 - Menu Gerente");
            System.out.println();
            System.out.print("Opcão >> ");

            opcao = scanner.nextLine();
            System.out.println();
            
            if (opcao.equals("0")) {
                sair = true;
            } else if (opcao.equals("1")) {
                UICadastroBalconista uiCadastroBalconista = new UICadastroBalconista();
                uiCadastroBalconista.showMenu();
            } else if (opcao.equals("2")) {
                UICadastroCozinheiro uiCadastroCozinheiro = new UICadastroCozinheiro();
                uiCadastroCozinheiro.showMenu();
            } else if (opcao.equals("3")) {
                UICadastroGerente uiCadastroGerente = new UICadastroGerente();
                uiCadastroGerente.showMenu();
            } else if (opcao.equals("4")) {
                // UICadastroCliente uiCadastroCliente = new UICadastroCliente();
                // uiCadastroCliente.showMenu();
            } else if (opcao.equals("5")) {
                // UICadastroPedido uiCadastroPedido = new UICadastroPedido();
                // uiCadastroPedido.showMenu();
            } else if (opcao.equals("6")) {
                // UICadastroInsumo uiCadastroInsumo = new UICadastroInsumo();
                // uiCadastroInsumo.showMenu();
            } else if (opcao.equals("7")) {
                // UIBalconista uiBalconista = new UIBalconista();
                // uiBalconista.showMenu();
            } else if (opcao.equals("8")) {
                // UICozinheiro uiCozinheiro = new UICozinheiro();
                // uiCozinheiro.showMenu();
            } else if (opcao.equals("9")) {
                // UIGerente uiGerente = new UIGerente();
                // uiGerente.showMenu();
            }
        }
    }
}