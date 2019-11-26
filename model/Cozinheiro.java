package model;

public class Cozinheiro extends Funcionario {
    // Pedido pedidoAtual;

    public Cozinheiro(String nome, String cpf, String empresa, byte tempoDeExperiencia) {
        super(nome, cpf, empresa, tempoDeExperiencia);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double calculaSalario(byte tempoDeExperiencia) {
        // TODO Auto-generated method stub
        return 0;
    }

}