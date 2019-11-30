package model;

public class Cliente extends Pessoa {
    Pedido ultimoPedido;

    public Cliente(String nome, String cpf) {
        super(nome, cpf);
    }
    
    public Pedido getUltimoPedido() {
        return ultimoPedido;
    }
}