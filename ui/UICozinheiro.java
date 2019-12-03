package ui;

import java.util.Scanner;

import controlador.Fachada;
import exception.CozinheiroException;
import model.Cozinheiro;
import model.Pedido;

public class UICozinheiro implements IMenu {
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void showMenu() {
        Cozinheiro cozinheiro = promptPorCozinheiro();

        if (cozinheiro == null) {
            System.out.println("Não há gerente cadastrado com esse cpf.");
            System.out.println();
        } else {
            String opcao;
            boolean sair = false;
            System.out.println("Bem-vindo, " + cozinheiro.getNome() + "!");
            System.out.println();

            while (!sair) {
                System.out.println("*** Menu Cozinheiro ***");
                System.out.println("0 - Sair");
                System.out.println("1 - Ver pedido atual");
                System.out.println("2 - Dar baixa no pedido");
                System.out.print("Opção >> ");
    
                opcao = scanner.nextLine();
                System.out.println();
    
                if (opcao.equals("0")) {
                    sair = true;
                } else if (opcao.equals("1")) {
                    verPedido(cozinheiro);
                } else if (opcao.equals("2")) {
                    darBaixa(cozinheiro);
                }
            }
        }
    }

    private void verPedido(Cozinheiro cozinheiro) {
        Pedido pedido = cozinheiro.getPedidoAtual();

        if (pedido == null) {
            System.out.println("Nenhum pedido foi inserido no campo 'pedidos'");
            System.out.println();
        } else {
            System.out.println(pedido.getResumoDoPedido());
            System.out.println();
            System.out.println("-----------------");
            System.out.println("Pedido pronto: " + pedido.isPronto());
            System.out.println();
        }
    }

    private void darBaixa(Cozinheiro cozinheiro) {
        Pedido pedido = cozinheiro.getPedidoAtual();

        if (pedido == null) {
            System.out.println("Nenhum pedido foi inserido no campo 'pedidos'");
            System.out.println();
        } else if (pedido.isPronto()){
            System.out.println("Já foi dado baixa no pedido atual.");
        } else {
            pedido.pedidoPronto();
            System.out.println("A baixa no pedido foi dada com sucesso!");
            System.out.println();
        }
    }

    private Cozinheiro promptPorCozinheiro() {
        String cpf;
        Cozinheiro cozinheiro = null;

        System.out.print("Digite seu CPF: ");
        cpf = scanner.nextLine();

        try {
            cozinheiro = Fachada.getInstancia().procurarCozinheiro(cpf);
        } catch (CozinheiroException e) {
            System.out.println("Erro ao buscar cozinheiro: " + e.getMessage());
            System.out.println();
        }

        return cozinheiro;
    }
}