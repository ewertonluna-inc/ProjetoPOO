package model;

import exception.GerenteException;
import java.util.List;
import java.util.ArrayList;

public class Gerente extends Funcionario {
    Solicitacao solicitacao;


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
    public double calculaSalario(byte tempoDeExperiencia) {
        
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " Gerente [solicitacao=" + solicitacao + "]";
    }

     

    
    
}

