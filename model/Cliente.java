package model;

public class Cliente extends Pessoa {
    // Pedido pedido;

    public Cliente(String nome, String cpf) {
        super(nome, cpf);
    }
    
    public String toString() {
        String nome = this.getNome();
        return "O nome do cliente é: " + nome;
    }
}