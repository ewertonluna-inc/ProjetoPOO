package controlador;

import exception.CozinheiroException;
import model.Cozinheiro;

public interface IControladorCozinheiro {
    void inserirCozinheiro(Cozinheiro cozinheiro) throws CozinheiroException;
    Cozinheiro procurarCozinheiro(String cpf) throws CozinheiroException;
    void removerCozinheiro(String cpf) throws CozinheiroException;
    void atualizarCozinheiro(Cozinheiro cozinheiro) throws CozinheiroException;
    Cozinheiro getCozinheiroLivre() throws CozinheiroException;
    int getTamanho();
}