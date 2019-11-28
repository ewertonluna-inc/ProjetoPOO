package model;

abstract public class Alimento {
    private String nome;
    private double caloriasIndividual;

    public Alimento(String nome, double calorias) {
        this.nome = nome;
        this.caloriasIndividual = calorias;
    }

    public String getNome() {
        return nome;
    }

    public double getCaloriasIndividual() {
        return caloriasIndividual;
    }

}