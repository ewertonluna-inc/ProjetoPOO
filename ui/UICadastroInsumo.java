package ui;

import java.util.Scanner;

import controlador.Fachada;
import exception.InsumoException;
import model.Insumo;

public class UICadastroInsumo implements IMenu{
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void showMenu() {
        boolean sair = false;
        String opcao;

        while (!sair) {
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
            } else if (opcao.equals("1")) {
                inserirInsumo();
            } else if (opcao.equals("2")) {
                removerInsumo();
            } else if (opcao.equals("3")) {
                // procurarInsumo();
            } else if (opcao.equals("4")) {
                // atualizarInsumo();
            }
        }

    }

    private void inserirInsumo() {
        String nome;
        String aux1, aux2, aux3;
        double caloriasIndividual, precoIndividual;
        int quantidade;

        System.out.print("Nome: ");
        nome = scanner.nextLine();
        System.out.print("Calorias por porção: ");
        aux1 = scanner.nextLine();
        System.out.println("Preço por unidade: ");
        aux2 = scanner.nextLine();
        System.out.println("Quantidade: ");
        aux3 = scanner.nextLine();

        try {
            caloriasIndividual = Double.parseDouble(aux1);
            precoIndividual = Double.parseDouble(aux2);
            quantidade = Integer.parseInt(aux3);
        } catch (Exception e) {
            System.out.println("Erro de input: " + e.getMessage());
            System.out.println();
            return;
        }

        Insumo insumo = new Insumo(nome, caloriasIndividual, precoIndividual, quantidade);

        try {
            Fachada.getInstancia().inserirInsumo(insumo);
            System.out.println("Insumo inserido com sucesso!");
            System.out.println();
        } catch (InsumoException e) {
            System.out.println("Erro ao inserir insumo: " + e.getMessage());
            System.out.println();
        }
    }

    private void removerInsumo() {
        String nome;
        String aux;
        int quantidade;
        int quantidadeAntes = 0;

        System.out.println(
            "O valor mínimo do campo 'quantidade' de insumos é 0.\n" +
            "Se a quantidade a ser removida for maior do que a do Insumo, o insumo é retirado do cadastro."
        );
        System.out.println();

        System.out.print("Nome do insumo: ");
        nome = scanner.nextLine();
        System.out.print("Quantidade a ser removida: ");
        aux = scanner.nextLine();
        System.out.println();

        try {
            quantidade = Integer.parseInt(aux);
        } catch (Exception e) {
            System.out.println("Erro de input: " + e.getMessage());
            System.out.println();
            return;
        }

        // Bloco para buscar a quantidade de insumos antes de ser removido.
        try {
            Insumo insumo = Fachada.getInstancia().procurarInsumo(nome);
            if (insumo != null) {
                quantidadeAntes = insumo.getQuantidade();
            }
        } catch (InsumoException e) {
            System.out.println("Erro ao procurar insumo: " + e.getMessage());
            System.out.println();
            return;
        }

        // Bloco para remover a quantidade de insumo desejada.
        try {
            Fachada.getInstancia().removerInsumo(nome, quantidade);
            System.out.println("Insumo removido com sucesso!");
            if (quantidade > quantidadeAntes) {
                System.out.println("Insumo retirado do cadastro");
            } else {
                System.out.println("Quantidade de '" + nome + "' antes: " + quantidadeAntes);
                System.out.println("Quantidade de '" + nome + "' atual: " + (quantidadeAntes - quantidade));
            }
            System.out.println();
        } catch (InsumoException e) {
            System.out.println("Erro ao remover insumo: " + e.getMessage());
            System.out.println();
        }
    }


}