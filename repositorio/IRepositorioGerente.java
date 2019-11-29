package repositorio;

import model.Gerente;
import exception.GerenteException;

public interface IRepositorioGerente {
    void inserirGerente(Gerente gerente) throws GerenteException;
    Gerente procurarGerente(String cpf);
    void removerGerente(String cpf) throws GerenteException;
    void atualizarGerente(Gerente gerente) throws GerenteException;
}