package ui;

import java.util.Scanner;

import controlador.Fachada;
import exception.CozinheiroException;
import exception.GerenteException;
import exception.InsumoException;
import exception.LancheException;
import exception.PedidoException;
import model.Cliente;
import model.Cozinheiro;
import model.Gerente;
import model.Insumo;
import model.Lanche;
import model.Pedido;
import model.Solicitacao;
import util.Estoque;

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
               // Chama o método criarPedido() se houver cozinheiro disponível
                try {
                    Cozinheiro cozinheiro = Fachada.getInstancia().getCozinheiroLivre();
                    if (cozinheiro != null) {
                        criarPedido(cozinheiro);
                    } else {
                        System.out.println("Não há cozinheiro livre no momento");
                        System.out.println();
                    }
                } catch (CozinheiroException e) {
                    System.out.println("Problema ao buscar cozinheiro livre: " + e.getMessage());
                    System.out.println();
                }

            } else if (opcao.equals("2")) {
                // Chama o método enviarSolicitação se houver gerente disponível.
                try {
                    Gerente gerente = Fachada.getInstancia().getGerenteLivre();
                    if (gerente != null) {
                        enviarSolicitacao(gerente);
                    } else {
                        System.out.println("Não há Gerente livre no momento");
                        System.out.println();
                    }
                } catch (GerenteException e) {
                    System.out.println("Problema ao buscar gerente livre: " + e.getMessage());
                    System.out.println();
                }
            }
        }

    }

    // Reformular esse método
    private void criarPedido(Cozinheiro cozinheiro) {
        Lanche lanche;
        Pedido pedido;
        String nomeCliente;
        String cpf;
        String id, paraViagemString;
        boolean paraViagem = false;
        int qtdCarne, qtdQueijo, qtdAlface, qtdTomate, qtdBacon, qtdPao;
        int qtdCarneEstoque, qtdQueijoEstoque, qtdAlfaceEstoque;
        int qtdTomateEstoque, qtdBaconEstoque, qtdPaoEstoque;
        String auxCarne, auxQueijo, auxAlface, auxTomate, auxBacon, auxPao;

        // Obtendo informações para criar cliente e id do Pedido
        System.out.print("Nome do cliente: ");
        nomeCliente = scanner.nextLine();
        System.out.print("CPF do cliente: ");
        cpf = scanner.nextLine();
        System.out.print("id do pedido: ");
        id = scanner.nextLine();
        System.out.print("Para viagem? 's' para sim: ");
        paraViagemString = scanner.nextLine();
        System.out.println();

        // Verifica se pedido é para viagem
        if (paraViagemString.equals("s")) {
            paraViagem = true;
        }

        Cliente cliente = new Cliente(nomeCliente, cpf);

        // Obtendo informações para criar insumos para o lanche
        System.out.print("Qtd de carnes: ");
        auxCarne = scanner.nextLine();
        System.out.print("Qtd de fatias de queijo: ");
        auxQueijo = scanner.nextLine();
        System.out.print("Qtd de fatias de bacon: ");
        auxBacon = scanner.nextLine();
        System.out.print("Qtd de folhas de alface: ");
        auxAlface = scanner.nextLine();
        System.out.print("Qtd de fatias de tomate: ");
        auxTomate = scanner.nextLine();
        System.out.print("Qtd de fatias de pão: ");
        auxPao = scanner.nextLine();

        // Validação dos inputs
        try {
            qtdCarne = Integer.parseInt(auxCarne);
            qtdQueijo = Integer.parseInt(auxQueijo);
            qtdBacon = Integer.parseInt(auxBacon);
            qtdAlface = Integer.parseInt(auxAlface);
            qtdTomate = Integer.parseInt(auxTomate);
            qtdPao = Integer.parseInt(auxPao);
        } catch (Exception e) {
            System.out.println("Erro de input: " + e.getMessage());
            System.out.println();
            return;
        }

        // Verificação de quantidades de insumos no estoque;
        try {
            qtdCarneEstoque = Fachada.getInstancia().getQuantidadeDeInsumo("carne");
            qtdQueijoEstoque = Fachada.getInstancia().getQuantidadeDeInsumo("queijo");
            qtdBaconEstoque = Fachada.getInstancia().getQuantidadeDeInsumo("bacon");
            qtdAlfaceEstoque = Fachada.getInstancia().getQuantidadeDeInsumo("alface");
            qtdTomateEstoque = Fachada.getInstancia().getQuantidadeDeInsumo("tomate");
            qtdPaoEstoque = Fachada.getInstancia().getQuantidadeDeInsumo("pao");
        } catch (InsumoException e) {
            System.out.println("Problema no estoque: " + e.getMessage());
            System.out.println();
            return;
        }

        // Se existem as quantidades solicitadas em estoque, realiza o pedido
        if (qtdAlface < qtdAlfaceEstoque && qtdCarne < qtdCarneEstoque &&
                qtdQueijo < qtdQueijoEstoque && qtdTomate < qtdTomateEstoque &&
                qtdBacon < qtdBaconEstoque && qtdPao < qtdPaoEstoque) {
            
            Insumo carne = new Insumo("carne", Estoque.CARNE.getCaloriasIndividual(), Estoque.CARNE.getPrecoIndividual(), qtdCarne);
            Insumo queijo = new Insumo("queijo", Estoque.QUEIJO.getCaloriasIndividual(), Estoque.QUEIJO.getPrecoIndividual(), qtdQueijo);
            Insumo bacon = new Insumo("bacon", Estoque.BACON.getCaloriasIndividual(), Estoque.BACON.getPrecoIndividual(), qtdBacon);
            Insumo alface = new Insumo("alface", Estoque.ALFACE.getCaloriasIndividual(), Estoque.ALFACE.getPrecoIndividual(), qtdAlface);
            Insumo tomate = new Insumo("tomate", Estoque.TOMATE.getCaloriasIndividual(), Estoque.TOMATE.getPrecoIndividual(), qtdTomate);
            Insumo pao = new Insumo("pao", Estoque.PAO.getCaloriasIndividual(), Estoque.PAO.getPrecoIndividual(), qtdPao);
            lanche = new Lanche("Hamburguer");
            
            // Cria o lanche para o pedido
            try {
                lanche.adicionarInsumo(carne);
                lanche.adicionarInsumo(queijo);
                lanche.adicionarInsumo(bacon);
                lanche.adicionarInsumo(alface);
                lanche.adicionarInsumo(tomate);
                lanche.adicionarInsumo(pao);
            } catch (LancheException e) {
                System.out.println("Problema ao adicionar insumo: " + e.getMessage());
                System.out.println();
                return;
            }

            // Remove os insumos do estoque. Caso não consiga, termina o método.
            try {
                Fachada.getInstancia().removerInsumo("carne", qtdCarne);
                Fachada.getInstancia().removerInsumo("queijo", qtdQueijo);
                Fachada.getInstancia().removerInsumo("bacon", qtdBacon);
                Fachada.getInstancia().removerInsumo("alface", qtdAlface);
                Fachada.getInstancia().removerInsumo("tomate", qtdTomate);
                Fachada.getInstancia().removerInsumo("pao", qtdPao);
            } catch (InsumoException e) {
                System.out.println("Erro ao remover insumos. Tente novamente: " + e.getMessage());
                System.out.println();
                return;
            }
            
            pedido = new Pedido(id, cliente, lanche, paraViagem);
            
            // Envia o pedido para o cozinheiro. Se não tiver sucesso, termina o método.
            try {
                cozinheiro.setPedido(pedido);
                System.out.println("Pedido realizado com sucesso!");
            } catch (CozinheiroException e) {
                System.out.println("Problema ao setar pedido: " + e.getMessage());
                System.out.println();
                return;
            }
            
            // Tenta inserir pedido criado ao estoque. Porém, caso não haja sucesso, prossegue com o pedido.
            try {
                Fachada.getInstancia().inserirPedido(pedido);
            } catch (PedidoException e) {
                System.out.println("Pedido não foi inserido ao estoque: " + e.getMessage());
                System.out.println();
            }
            
            // Mostra no display o resumo do pedido
            System.out.println("Aperte qualquer tecla para ver um resumo do pedido");
            scanner.nextLine();
            System.out.println();
            System.out.println(pedido.getResumoDoPedido());
        
        } else {
            System.out.println("Quantidade de insumos no estoque é insuficiente para realizar o pedido");
        }

    }

    private void enviarSolicitacao(Gerente gerente) {
        Solicitacao solicitacao;
        String mensagem;
        
        System.out.print("Digite a solicitação: ");
        mensagem = scanner.nextLine();
        
        solicitacao = new Solicitacao(mensagem);

        try {
            gerente.inserirSolicitacao(solicitacao);
            System.out.println("Solicitação enviada com sucesso!");
            System.out.println();
        } catch (GerenteException e) {
            System.out.println("Problema ao inserir solicitação: " + e.getMessage());
            System.out.println();
        }
    }
    
}