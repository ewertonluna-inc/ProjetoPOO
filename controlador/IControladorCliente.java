package controlador;

import model.Cliente;
import exception.ClienteException;

public interface IControladorCliente {
    void inserirCliente(Cliente cliente) throws ClienteException;
    Cliente procurarCliente(String cpf) throws ClienteException;
    void removerCliente(String cpf) throws ClienteException;
    void atualizarCliente(Cliente cliente) throws ClienteException;
    int getTamanho();
}


