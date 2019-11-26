package model;

abstract public class Funcionario extends Pessoa{
    private String empresa;
    private byte tempoDeExperiencia;
    private double salario;

    Funcionario(String nome, String cpf,  
                String empresa, byte tempoDeExperiencia) {
                    super(nome, cpf);
                    this.empresa = empresa;
                    this.tempoDeExperiencia = tempoDeExperiencia;
                    this.salario = calculaSalario(tempoDeExperiencia);
                }

    
    
    abstract public double calculaSalario(byte tempoDeExperiencia);

    public String getEmpresa() {
        return empresa;
    }

    public byte getTempoDeExperiencia() {
        return tempoDeExperiencia;
    }

    public double getSalario() {
        return salario;
    }
}