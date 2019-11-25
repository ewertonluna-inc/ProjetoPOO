package model;

public class Cozinheiro extends Funcionario {
    // Pedido pedidoAtual;

    Cozinheiro(String nome, String cpf, byte idade, String empresa, byte tempoDeExperiencia) {
        super(nome, cpf, idade, empresa, tempoDeExperiencia);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double calculaSalario(byte tempoDeExperiencia) {
        // TODO Auto-generated method stub
        return 0;
    }

    // concluirPedido();
    
}