package ui;

import java.util.Scanner;
import controlador.Fachada;
import exception.ClienteException;
import model.Cliente;

public class UICadastroCliente implements IMenu {
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void showMenu() {
        boolean sair = false;
        String opcao;

        while(!sair) {
            System.out.println("*** Menu Cadastro de Cliente ***");
            System.out.println("0 - Sair");
            System.out.println("1 - Inserir Cliente");
            System.out.println("2 - Remover Cliente");
            System.out.println("3 - Procurar Cliente");
            System.out.println("4 - Atualizar Cliente");
            System.out.print("Opção >> ");

            opcao = scanner.nextLine();
            System.out.println();

            if (opcao.equals("0")) {
                sair = true;
            } else if (opcao.equals("1")) {
                inserirCliente();
            } else if (opcao.equals("2")) {
                removerCliente();
            } else if (opcao.equals("3")) {
                procurarCliente();
            } else if (opcao.equals("4")) {
                atualizarCliente();
            }
        }

    }

    private void inserirCliente() {
        String nome, cpf;
        
        System.out.print("Nome: ");
        nome = scanner.nextLine();
        System.out.print("CPF: ");
        cpf = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf); 
        
        try {
            Fachada.getInstancia().inserirCliente(cliente);
            System.out.println("Cliente inserido com sucesso!");
            System.out.println();
        } catch (ClienteException e) {
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
            System.out.println();
        }
    }

    private void removerCliente() {
        String cpf;

        System.out.print("CPF: ");
        cpf = scanner.nextLine();

        try {
            Fachada.getInstancia().removerCliente(cpf);
            System.out.println("Cliente removido com sucesso!");
            System.out.println();
        } catch (ClienteException e) {
            System.out.println("Erro ao remover cliente: " + e.getMessage());
            System.out.println();
        }
    }

    private void procurarCliente() {
        Cliente cliente;
        String cpf;

        System.out.print("CPF: ");
        cpf = scanner.nextLine();
        try {
            cliente = Fachada.getInstancia().procurarCliente(cpf);
        } catch (ClienteException e) {
            System.out.println("Erro ao procurar cliente: " + e.getMessage());
            System.out.println();
            return;
        }

        if (cliente == null) {
            System.out.println("Não existe cadastro com esse cpf (" + cpf + ")");
            System.out.println();
        } else {
            System.out.println(cliente);
            System.out.println();
        }
    }

    private void atualizarCliente() {
        String nome, cpf;

        System.out.print("Nome: ");
        nome = scanner.nextLine();
        System.out.print("CPF: ");
        cpf = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf);
        
        try {
            Fachada.getInstancia().atualizarCliente(cliente);
            System.out.println("Cliente atualizado com sucesso!");
            System.out.println();
        } catch (ClienteException e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
            System.out.println();
        }
    }
    
}