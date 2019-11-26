package model;

abstract public class Alimento {
    String nome;
    double calorias;

    public Alimento(String nome, double calorias) {
        this.nome = nome;
        this.calorias = calorias;
    }

    public String getNome() {
        return nome;
    }

    public double getCalorias() {
        return calorias;
    }

    

}