package model;

import exception.InsumoException;;

public class Insumo extends Alimento {
    private double precoIndividual;
    private int quantidade;

    public Insumo(String nome, double caloriasIndividual, double precoIndividual, int quantidade) {
        super(nome, caloriasIndividual);
        if (quantidade < 0) {
            throw new IllegalArgumentException("Argumento não válido");
        }
        this.precoIndividual = precoIndividual;
        this.quantidade = quantidade;
    }

    public double getPrecoIndividual() {
        return precoIndividual;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoTotal() {
        return quantidade * precoIndividual;
    }

    public double getCaloriasTotal(){
        return getCaloriasIndividual() * quantidade;
    }

    public void aumentarQuantidade(int quantidade){
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade negativa não é válida");
        }
        this.quantidade += quantidade;
    }

    public void aumentarQuantidade() {
        aumentarQuantidade(1);
    }

    public void diminuirQuantidade(int quantidade) throws InsumoException{
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade negativa não é válida");
        }
        if (this.quantidade - quantidade < 0) {
            throw new InsumoException("Quantidade não pode ser menor do que zero");
        }
        this.quantidade -= quantidade;        
    }

    public void diminuirQuantidade() throws InsumoException{
        diminuirQuantidade(1);
    }

    @Override
    public String toString() {
        return "Insumo [nome=" + getNome() + ", caloriasIndividual=" + getCaloriasIndividual() + ", precoIndividual=" + precoIndividual + ", quantidade=" + quantidade + "]";
    }

}