package repositorio;

import model.Balconista;
import exception.BalconistaException;

public interface IRepositorioBalconista {
    void inserirBalconista(Balconista balconista) throws BalconistaException;
    Balconista procurarBalconista(String cpf);
    void removerBalconista(String cpf) throws BalconistaException;
    void atualizarBalconista(Balconista balconista) throws BalconistaException;
    int indexDoBalconista(String cpf);
    int getTamanho();
}