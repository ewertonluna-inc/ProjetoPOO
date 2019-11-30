package controlador;

import exception.GerenteException;
import model.Gerente;

public interface IControladorGerente {
    void inserirGerente(Gerente gerente) throws GerenteException;
    Gerente procurarGerente(String cpf) throws GerenteException;
    void removerGerente(String cpf) throws GerenteException;
    void atualizarGerente(Gerente gerente) throws GerenteException;
    int getTamanho();
}