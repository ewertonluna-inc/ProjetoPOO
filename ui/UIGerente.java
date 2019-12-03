package ui;

import java.util.Scanner;

import controlador.Fachada;
import exception.GerenteException;
import model.Gerente;
import model.Solicitacao;

public class UIGerente implements IMenu {
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void showMenu() {
        Gerente gerente = promptPorGerente();

        if (gerente == null) {
            System.out.println("Não há gerente cadastrado com esse cpf.");
            System.out.println();
        } else {
            String opcao;
            boolean sair = false;
            System.out.println("Bem-vindo, " + gerente.getNome() + "!");
            System.out.println();

            while (!sair) {
                System.out.println("*** Menu Gerente ***");
                System.out.println("0 - Sair");
                System.out.println("1 - Ver solicitação");
                System.out.println("2 - Dar baixa na solicitação");
                System.out.print("Opção >> ");
    
                opcao = scanner.nextLine();
                System.out.println();
    
                if (opcao.equals("0")) {
                    sair = true;
                } else if (opcao.equals("1")) {
                    verSolicitacao(gerente);
                } else if (opcao.equals("2")) {
                    darBaixa(gerente);
                }
            }
        }
    }

    private void verSolicitacao(Gerente gerente) {
        Solicitacao solicitacao = gerente.getSolicitacao();

        if (solicitacao == null) {
            System.out.println("Campo de solicitações está vazio");
        } else {
            String mensagem = solicitacao.getMensagem();
            boolean isResolvida = solicitacao.isResolvida();
            System.out.println(
                "Solicitação: '" + mensagem + "'\n" +
                "Resolvida: " + "'" + isResolvida + "'"
            );
            System.out.println();
        }
    }

    private void darBaixa(Gerente gerente) {
        Solicitacao solicitacao = gerente.getSolicitacao();
        
        if (solicitacao == null) {
            System.out.println("Campo de solicitações está vazio. Não há solicitação para dar baixa");
            System.out.println();
        } else if (solicitacao.isResolvida()) {
            System.out.println("Solicitação já está resolvida.");
            System.out.println();
        } else {
            solicitacao.resolverSolicitacao();
            System.out.println("Solicitação resolvida com sucesso!");
            System.out.println();
        }
    }


    private Gerente promptPorGerente() {
        String cpf;
        Gerente gerente = null;

        System.out.print("Digite seu CPF: ");
        cpf = scanner.nextLine();

        try {
            gerente = Fachada.getInstancia().procurarGerente(cpf);
        } catch (GerenteException e) {
            System.out.println("Erro ao buscar gerente: " + e.getMessage());
            System.out.println();
        }

        return gerente;
    }


    
}