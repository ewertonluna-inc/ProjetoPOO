package model;

public class Cozinheiro extends Funcionario {
    public static final double SALARIO_INICIAL = 2000;
    public static final double TAXA_DE_AUMENTO_ANUAL = 1.15;
    Pedido pedidoAtual;

    public Cozinheiro(String nome, String cpf, String empresa, byte tempoDeExperiencia) {
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

    @Override
    public String toString() {
        return "Funcionario [nome = " + getNome() + ", cpf=" + getCpf() + ", empresa=" + getEmpresa() +  ", tempoDeExperiencia=" + getTempoDeExperiencia() 
            + ", salario=" + getSalario() + "]";
    }
}