package model;

public class Pedido {
    private static final double PRECO_EMBALAGEM = 2;
    private String id;
    private Cliente cliente;
    private Lanche lanche;
    private double preco;
    private boolean paraViagem;
    private boolean isPronto;

    public Pedido(String id, Cliente cliente, Lanche lanche, boolean paraViagem) {
        this.id = id;
        this.cliente = cliente;
        this.lanche = lanche;
        this.preco = lanche.getPreco();
        this.paraViagem = paraViagem;
        if (paraViagem) {
            this.preco += PRECO_EMBALAGEM;
        }
        isPronto = false;
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

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Pedido [cliente=" + cliente + ", isPronto=" + isPronto + ", lanche=" + lanche + ", paraViagem="
                + paraViagem + ", preco=" + preco + ", id=" +  getId() + "]";
    }
}
