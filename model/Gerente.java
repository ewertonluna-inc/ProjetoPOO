package model;

import exception.GerenteException;

public class Gerente extends Funcionario {
    private Solicitacao solicitacao;
    public static final double SALARIO_INICIAL = 6000;
    public static final double TAXA_DE_AUMENTO_ANUAL = 1.17;


    public Gerente(String nome, String cpf, String empresa, byte tempoDeExperiencia) {
        super(nome, cpf, empresa, tempoDeExperiencia);
        this.solicitacao = null;
    }

    public void inserirSolicitacao(Solicitacao solicitacao) throws GerenteException{
        if (solicitacao == null) {
            throw new GerenteException("null não é um argumento válido");
        }

        if (this.solicitacao != null) {
            if (this.solicitacao.isResolvida()) {
                this.solicitacao = solicitacao;
            } else {
                throw new GerenteException("Gerente possui solicitacao em aberto.");
            }
        } else {
            this.solicitacao = solicitacao;
        }
    }

    public void resolverSolicitacao() throws GerenteException{
        if (solicitacao == null) {
            throw new GerenteException("Gerente não possui solicitações.");
        } else {
            solicitacao.resolverSolicitacao();
        }
    }

    public Solicitacao getSolicitacao() {
        return this.solicitacao;
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
        + ", solicitacao=" + getSolicitacao() + "]";
    }
}

