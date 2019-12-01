package ui;

import java.util.Scanner;
import controlador.Fachada;
import exception.BalconistaException;
import model.Balconista;

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
            System.out.print("Opção >> ");

            opcao = scanner.nextLine();
            System.out.println();

            if (opcao.equals("0")) {
                sair = true;
            } else if (opcao.equals("1")) {
                inserirBalconista();
            } else if (opcao.equals("2")) {
                removerBalconista();
            } else if (opcao.equals("3")) {
                procurarBalconista();
            } else if (opcao.equals("4")) {
                atualizarBalconista();
            }
        }

    }

    private void inserirBalconista() {
        String nome, cpf, empresa;
        String aux;
        byte tempoDeExperiencia;
        
        System.out.print("Nome: ");
        nome = scanner.nextLine();
        System.out.print("CPF: ");
        cpf = scanner.nextLine();
        System.out.print("Empresa: ");
        empresa = scanner.nextLine();
        System.out.print("Tempo de experiência: ");
        aux = scanner.nextLine();
        
        try {
            tempoDeExperiencia = Byte.parseByte(aux);   
        } catch (Exception e) {
            System.out.println("Erro de input: " + e.getMessage());
            System.out.println();
            return;
        }

        Balconista balconista = new Balconista(nome, cpf, empresa, tempoDeExperiencia); 
        
        try {
            Fachada.getInstancia().inserirBalconista(balconista);
            System.out.println("Balconista inserido com sucesso!");
            System.out.println();
        } catch (BalconistaException e) {
            System.out.println("Erro ao inserir balconista: " + e.getMessage());
            System.out.println();
        }
    }

    private void removerBalconista() {
        String cpf;

        System.out.print("CPF: ");
        cpf = scanner.nextLine();

        try {
            Fachada.getInstancia().removerBalconista(cpf);
            System.out.println("Balconista removido com sucesso!");
            System.out.println();
        } catch (BalconistaException e) {
            System.out.println("Erro ao remover balconista: " + e.getMessage());
            System.out.println();
        }
    }

    private void procurarBalconista() {
        Balconista balconista;
        String cpf;

        System.out.print("CPF: ");
        cpf = scanner.nextLine();
        try {
            balconista = Fachada.getInstancia().procurarBalconista(cpf);
        } catch (BalconistaException e) {
            System.out.println("Erro ao procurar balconista: " + e.getMessage());
            System.out.println();
            return;
        }

        if (balconista == null) {
            System.out.println("Não existe cadastro com esse cpf (" + cpf + ")");
            System.out.println();
        } else {
            System.out.println(balconista);
            System.out.println();
        }
    }

    private void atualizarBalconista() {
        String nome, cpf, empresa;
        String aux;
        byte tempoDeExperiencia;

        System.out.print("Nome: ");
        nome = scanner.nextLine();
        System.out.print("CPF: ");
        cpf = scanner.nextLine();
        System.out.print("Empresa: ");
        empresa = scanner.nextLine();
        System.out.print("Tempo de experiência: ");
        aux = scanner.nextLine();

        try {
            tempoDeExperiencia = Byte.parseByte(aux);
        } catch (Exception e) {
            System.out.println("Erro de input: " + e.getMessage());
            return;
        }

        Balconista balconista = new Balconista(nome, cpf, empresa, tempoDeExperiencia);
        
        try {
            Fachada.getInstancia().atualizarBalconista(balconista);
            System.out.println("Balconista atualizado com sucesso!");
            System.out.println();
        } catch (BalconistaException e) {
            System.out.println("Erro ao atualizar balconista: " + e.getMessage());
            System.out.println();
        }
    }
    
}