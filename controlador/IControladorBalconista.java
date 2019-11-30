package controlador;

import model.Balconista;
import exception.BalconistaException;

public interface IControladorBalconista {
    void inserirBalconista(Balconista balconista) throws BalconistaException;
    Balconista procurarBalconista(String cpf) throws BalconistaException;
    void removerBalconista(String cpf) throws BalconistaException;
    void atualizarBalconista(Balconista balconista) throws BalconistaException;
    int getTamanho();
}