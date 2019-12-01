package ui;

import java.util.Scanner;
import controlador.Fachada;
import exception.CozinheiroException;
import model.Cozinheiro;

public class UICadastroCozinheiro implements IMenu {
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void showMenu() {
        boolean sair = false;
        String opcao;

        while(!sair) {
            System.out.println("*** Menu Cadastro de Cozinheiro ***");
            System.out.println("0 - Sair");
            System.out.println("1 - Inserir Cozinheiro");
            System.out.println("2 - Remover Cozinheiro");
            System.out.println("3 - Procurar Cozinheiro");
            System.out.println("4 - Atualizar Cozinheiro");
            System.out.print("Opção >> ");

            opcao = scanner.nextLine();
            System.out.println();

            if (opcao.equals("0")) {
                sair = true;
            } else if (opcao.equals("1")) {
                inserirCozinheiro();
            } else if (opcao.equals("2")) {
                removerCozinheiro();
            } else if (opcao.equals("3")) {
                procurarCozinheiro();
            } else if (opcao.equals("4")) {
                atualizarCozinheiro();
            }
        }

    }

    private void inserirCozinheiro() {
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

        Cozinheiro cozinheiro = new Cozinheiro(nome, cpf, empresa, tempoDeExperiencia); 
        
        try {
            Fachada.getInstancia().inserirCozinheiro(cozinheiro);
            System.out.println("Cozinheiro inserido com sucesso!");
            System.out.println();
        } catch (CozinheiroException e) {
            System.out.println("Erro ao inserir cozinheiro: " + e.getMessage());
            System.out.println();
        }
    }

    private void removerCozinheiro() {
        String cpf;

        System.out.print("CPF: ");
        cpf = scanner.nextLine();

        try {
            Fachada.getInstancia().removerCozinheiro(cpf);
            System.out.println("Cozinheiro removido com sucesso!");
            System.out.println();
        } catch (CozinheiroException e) {
            System.out.println("Erro ao remover cozinheiro: " + e.getMessage());
            System.out.println();
        }
    }

    private void procurarCozinheiro() {
        Cozinheiro cozinheiro;
        String cpf;

        System.out.print("CPF: ");
        cpf = scanner.nextLine();
        try {
            cozinheiro = Fachada.getInstancia().procurarCozinheiro(cpf);
        } catch (CozinheiroException e) {
            System.out.println("Erro ao procurar cozinheiro: " + e.getMessage());
            System.out.println();
            return;
        }

        if (cozinheiro == null) {
            System.out.println("Não existe cadastro com esse cpf (" + cpf + ")");
            System.out.println();
        } else {
            System.out.println(cozinheiro);
            System.out.println();
        }
    }

    private void atualizarCozinheiro() {
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

        Cozinheiro cozinheiro = new Cozinheiro(nome, cpf, empresa, tempoDeExperiencia);
        
        try {
            Fachada.getInstancia().atualizarCozinheiro(cozinheiro);
            System.out.println("Cozinheiro atualizado com sucesso!");
            System.out.println();
        } catch (CozinheiroException e) {
            System.out.println("Erro ao atualizar cozinheiro: " + e.getMessage());
            System.out.println();
        }
    }
    
}