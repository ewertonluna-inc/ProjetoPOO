package model;

import exception.CozinheiroException;

public class Cozinheiro extends Funcionario {
    public static final double SALARIO_INICIAL = 2000;
    public static final double TAXA_DE_AUMENTO_ANUAL = 1.15;
    Pedido pedidoAtual;

    public Cozinheiro(String nome, String cpf, String empresa, byte tempoDeExperiencia) {
        super(nome, cpf, empresa, tempoDeExperiencia);
    }

    public Pedido getPedidoAtual(){
        return pedidoAtual;
    }

    public void setPedido(Pedido pedido) throws CozinheiroException{
        if (pedido == null) {
            throw new CozinheiroException("Pedido não pode ser null");
        }
        if (pedido.isPronto() == false) {
            throw new CozinheiroException("Cozinheiro já está com pedido que ainda não foi concluído");
        }
        pedidoAtual = pedido;
    }

    @Override
    public double getSalario() {
        double tempoDeExperiencia = getTempoDeExperiencia();
        
        if (tempoDeExperiencia == 0) {
            return SALARIO_INICIAL;
        }
        
        return Math.pow(TAXA_DE_AUMENTO_ANUAL, tempoDeExperiencia) * SALARIO_INICIAL;
    }

    @Override
    public String toString() {
        return "Funcionario [nome = " + getNome() + ", cpf=" + getCpf() + ", empresa=" + getEmpresa() +  ", tempoDeExperiencia=" + getTempoDeExperiencia() 
            + ", salario=" + getSalario() + "Pedido atual=" + getPedidoAtual() + "]";
    }
}