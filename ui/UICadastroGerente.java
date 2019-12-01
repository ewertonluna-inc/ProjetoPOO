package ui;

import java.util.Scanner;
import controlador.Fachada;
import exception.GerenteException;
import model.Gerente;

public class UICadastroGerente implements IMenu {
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void showMenu() {
        boolean sair = false;
        String opcao;

        while(!sair) {
            System.out.println("*** Menu Cadastro de Gerente ***");
            System.out.println("0 - Sair");
            System.out.println("1 - Inserir Gerente");
            System.out.println("2 - Remover Gerente");
            System.out.println("3 - Procurar Gerente");
            System.out.println("4 - Atualizar Gerente");
            System.out.print("Opção >> ");

            opcao = scanner.nextLine();
            System.out.println();

            if (opcao.equals("0")) {
                sair = true;
            } else if (opcao.equals("1")) {
                inserirGerente();
            } else if (opcao.equals("2")) {
                removerGerente();
            } else if (opcao.equals("3")) {
                procurarGerente();
            } else if (opcao.equals("4")) {
                atualizarGerente();
            }
        }

    }

    private void inserirGerente() {
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

        Gerente gerente = new Gerente(nome, cpf, empresa, tempoDeExperiencia); 
        
        try {
            Fachada.getInstancia().inserirGerente(gerente);
            System.out.println("Gerente inserido com sucesso!");
            System.out.println();
        } catch (GerenteException e) {
            System.out.println("Erro ao inserir gerente: " + e.getMessage());
            System.out.println();
        }
    }

    private void removerGerente() {
        String cpf;

        System.out.print("CPF: ");
        cpf = scanner.nextLine();

        try {
            Fachada.getInstancia().removerGerente(cpf);
            System.out.println("Gerente removido com sucesso!");
            System.out.println();
        } catch (GerenteException e) {
            System.out.println("Erro ao remover gerente: " + e.getMessage());
            System.out.println();
        }
    }

    private void procurarGerente() {
        Gerente gerente;
        String cpf;

        System.out.print("CPF: ");
        cpf = scanner.nextLine();
        try {
            gerente = Fachada.getInstancia().procurarGerente(cpf);
        } catch (GerenteException e) {
            System.out.println("Erro ao procurar gerente: " + e.getMessage());
            System.out.println();
            return;
        }

        if (gerente == null) {
            System.out.println("Não existe cadastro com esse cpf (" + cpf + ")");
            System.out.println();
        } else {
            System.out.println(gerente);
            System.out.println();
        }
    }

    private void atualizarGerente() {
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

        Gerente gerente = new Gerente(nome, cpf, empresa, tempoDeExperiencia);
        
        try {
            Fachada.getInstancia().atualizarGerente(gerente);
            System.out.println("Gerente atualizado com sucesso!");
            System.out.println();
        } catch (GerenteException e) {
            System.out.println("Erro ao atualizar gerente: " + e.getMessage());
            System.out.println();
        }
    }
    
}