package model;

abstract public class Alimento {
    String nome;
    double calorias;

    public Alimento(String nome, double calorias) {
        this.nome = nome;
        this.calorias = calorias;
    }
}