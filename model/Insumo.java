package model;

public class Insumo extends Alimento {
    double preco;
    int quantidade;

    public Insumo(String nome, double calorias, double preco, int quantidade) {
        super(nome, calorias);
        this.preco = preco;
        this.quantidade = quantidade;
    }
}