package model;

abstract public class Pessoa {
    private String nome;
    private String cpf;
    private byte idade;

    public Pessoa(String nome, String cpf, byte idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public byte getIdade() {
        return idade;
    }
}