package model;

public class Pedido {
    private int id;
    private Cliente cliente;
    private Lanche lanche;
    private double preco;
    private boolean paraViagem;
    private boolean isPronto;

    public Pedido(int id, Cliente cliente, Lanche lanche, boolean paraViagem) {
        this.id = id;
        this.cliente = cliente;
        this.lanche = lanche;
        this.preco = lanche.getPreco();
        this.paraViagem = paraViagem;
        if (paraViagem) {
            incluirPrecoEmbalagem(2);
        }
        isPronto = false;
    }

    private void incluirPrecoEmbalagem(double precoEmbalagem) {
        if (precoEmbalagem < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        preco += precoEmbalagem;
    }

    public void pedidoPronto() {
        isPronto = true;
    }

    public String getResumoDoPedido() {
        String resumo = "";
        String nomeCliente = cliente.getNome();
        String nomeLanche = lanche.getNome();;

        resumo += "Nome do cliente: " + nomeCliente + "\n";
        resumo += "Lanche: " + nomeLanche + "\n";
        resumo += "Para viagem: " + paraViagem + "\n";
        resumo += "Total a pagar: " + preco + "\n";
        
        return resumo;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Pedido [cliente=" + cliente + ", isPronto=" + isPronto + ", lanche=" + lanche + ", paraViagem="
                + paraViagem + ", preco=" + preco + ", id=" +  "]";
    }




}
