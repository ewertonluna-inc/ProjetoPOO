package repositorio;

import model.Cozinheiro;
import exception.CozinheiroException;

public interface IRepositorioCozinheiro {
    void inserirCozinheiro(Cozinheiro cozinheiro) throws CozinheiroException;
    Cozinheiro procurarCozinheiro(String cpf);
    void removerCozinheiro(String cpf) throws CozinheiroException;
    void atualizarCozinheiro(Cozinheiro cozinheiro) throws CozinheiroException;
    int indexDoCozinheiro(String cpf);
    int getTamanho();
}