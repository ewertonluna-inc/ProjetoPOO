package model;

public class Balconista extends Funcionario{
    public static final double SALARIO_INICIAL = 1800;
    public static final double TAXA_DE_AUMENTO_ANUAL = 1.15;

    public Balconista(String nome, String cpf, String empresa, byte tempoDeExperiencia) {
        super(nome, cpf, empresa, tempoDeExperiencia);
    }

    @Override
    public double getSalario() {
        double tempoDeExperiencia = getTempoDeExperiencia();
        
        if (tempoDeExperiencia == 0) {
            return SALARIO_INICIAL;
        }

        return Math.pow(TAXA_DE_AUMENTO_ANUAL, tempoDeExperiencia) * SALARIO_INICIAL;
    }


}