package model;

public class Balconista extends Funcionario{

    public Balconista(String nome, String cpf, byte idade, String empresa, byte tempoDeExperiencia) {
        super(nome, cpf, idade, empresa, tempoDeExperiencia);
    }

    @Override
    public double calculaSalario(byte tempoDeExperiencia) {
        // TODO: Auto-generated method stub;
        return 0;
    }


}