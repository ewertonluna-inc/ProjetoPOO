package util;

import model.Insumo;

public final class Estoque {
    public static final Insumo TOMATE = new Insumo("tomate", 4, 1.5, 100);
    public static final Insumo ALFACE = new Insumo("alface", 1.5, 0.5, 100);
    public static final Insumo CARNE = new Insumo("carne", 98, 6, 100);
    public static final Insumo PAO = new Insumo("pao", 142, 1, 100);
    public static final Insumo QUEIJO = new Insumo("queijo", 27, .2, 100);
    public static final Insumo BACON = new Insumo("bacon", 40, 1.1, 100);

    public static Insumo createTomate() {
        String nome = TOMATE.getNome();
        double caloriasIndividual = TOMATE.getCaloriasIndividual();
        double precoIndividual = TOMATE.getPrecoIndividual();
        int quantidade = TOMATE.getQuantidade();

        return new Insumo(nome, caloriasIndividual, precoIndividual, quantidade);
    }

    public static Insumo createAlface() {
        String nome = ALFACE.getNome();
        double caloriasIndividual = ALFACE.getCaloriasIndividual();
        double precoIndividual = ALFACE.getPrecoIndividual();
        int quantidade = ALFACE.getQuantidade();

        return new Insumo(nome, caloriasIndividual, precoIndividual, quantidade);
    }

    public static Insumo createCarne() {
        String nome = CARNE.getNome();
        double caloriasIndividual = CARNE.getCaloriasIndividual();
        double precoIndividual = CARNE.getPrecoIndividual();
        int quantidade = CARNE.getQuantidade();

        return new Insumo(nome, caloriasIndividual, precoIndividual, quantidade);
    }

    public static Insumo createPao() {
        String nome = PAO.getNome();
        double caloriasIndividual = PAO.getCaloriasIndividual();
        double precoIndividual = PAO.getPrecoIndividual();
        int quantidade = PAO.getQuantidade();

        return new Insumo(nome, caloriasIndividual, precoIndividual, quantidade);
    }

    public static Insumo createQueijo() {
        String nome = QUEIJO.getNome();
        double caloriasIndividual = QUEIJO.getCaloriasIndividual();
        double precoIndividual = QUEIJO.getPrecoIndividual();
        int quantidade = QUEIJO.getQuantidade();

        return new Insumo(nome, caloriasIndividual, precoIndividual, quantidade);
    }

    public static Insumo createBacon() {
        String nome = BACON.getNome();
        double caloriasIndividual = BACON.getCaloriasIndividual();
        double precoIndividual = BACON.getPrecoIndividual();
        int quantidade = BACON.getQuantidade();

        return new Insumo(nome, caloriasIndividual, precoIndividual, quantidade);
    }
}