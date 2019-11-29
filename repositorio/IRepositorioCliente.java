package repositorio;

import model.Cliente;
import exception.ClienteException;

public interface IRepositorioCliente {
    void inserirCliente(Cliente cliente) throws ClienteException;
    Cliente procurarCliente(String cpf);
    void removerCliente(String cpf) throws ClienteException;
    void atualizarCliente(Cliente cliente) throws ClienteException;
    int indexDoCliente(String cpf);
    int getTamanho();
}