package model;

import exception.FuncionarioException;

abstract public class Funcionario extends Pessoa{
    private String empresa;
    private byte tempoDeExperiencia;

    Funcionario(String nome, String cpf,  
                String empresa, byte tempoDeExperiencia) {
        
        super(nome, cpf);
        this.empresa = empresa;
        this.tempoDeExperiencia = tempoDeExperiencia;
    }

    abstract public double getSalario();

    public String getEmpresa() {
        return empresa;
    }

    public byte getTempoDeExperiencia() {
        return tempoDeExperiencia;
    }

    public void incrementarTempoDeExperiencia() {
        tempoDeExperiencia += 1;
    }

    public void decrementarTempoDeExperiencia() throws FuncionarioException {
        if (tempoDeExperiencia == 0) {
            throw new FuncionarioException("O tempo de experiência não pode ser menor que zero");
        }
        tempoDeExperiencia -= 1;
    }

    @Override
    public String toString() {
        return "Funcionario [empresa=" + empresa +  ", tempoDeExperiencia=" + tempoDeExperiencia
                + "]";
    }

    
}