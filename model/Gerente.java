package model;

import java.util.List;
import java.util.ArrayList;

public class Gerente extends Funcionario {
    // Solicitacao solicitacao;


    Gerente(String nome, String cpf, String empresa, byte tempoDeExperiencia) {
        super(nome, cpf, empresa, tempoDeExperiencia);
    }

    public void resolverSolicitaçao() {
        // todo: terminar
    }

    @Override
    public double calculaSalario(byte tempoDeExperiencia) {
        
        return 0;
    }
    
}