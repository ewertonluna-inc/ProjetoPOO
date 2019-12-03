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

    public boolean isPronto(){
        return isPronto;
    }

    public String getResumoDoPedido() {
        String resumo = "";
        String nomeCliente = cliente.getNome();
        String nomeLanche = lanche.getNome();;
        resumo += "====== RESUMO DO PEDIDO ======\n";
        resumo += "Nome do cliente: " + nomeCliente + "\n";
        resumo += "Lanche: " + nomeLanche + "\n";
        resumo += "** Insumos ** \n";

        for (Insumo insumo : getLanche().getInsumos()) {
            resumo += "--" + insumo.getNome().toUpperCase() + "\n";
            resumo += "Qtd: " + insumo.getQuantidade() + "\n";
            resumo += "Preço Individual: " + insumo.getPrecoIndividual() + "; ";
            resumo += "Total(R$): " + insumo.getQuantidade() + " x " + insumo.getPrecoIndividual();
            resumo += " = " + insumo.getPrecoTotal() + "\n";
        }
        resumo += "\n";
        resumo += "Se pedido é para viagem: + R$ 2,00\n";
        resumo += "Para viagem: " + paraViagem + "\n";
        resumo += "TOTAL A PAGAR: " + preco + "\n";
        
        return resumo;
    }

    public String getId() {
        return id;
    }

    public Lanche getLanche() {
        return lanche;
    }

    @Override
    public String toString() {
        return "Pedido [cliente=" + cliente + ", isPronto=" + isPronto + ", lanche=" + lanche + ", paraViagem="
                + paraViagem + ", preco=" + preco + ", id=" +  getId() + "]";
    }
}
