package controlador;

import exception.ClienteException;
import model.Cliente;
import repositorio.IRepositorioCliente;
import repositorio.RepositorioCliente;

// TODO: Continuar 

public class ControladorCliente implements IControladorCliente {
    static private ControladorCliente instancia;
    private IRepositorioCliente repositorioCliente;

    private ControladorCliente() {
        repositorioCliente = RepositorioCliente.getInstancia();
    }

    static public ControladorCliente getInstancia(){
        if (instancia == null) {
            instancia = new ControladorCliente();
        }
        return instancia;
    }

    @Override
    public void inserirCliente(Cliente cliente) throws ClienteException {
        if (cliente == null) {
            throw new ClienteException("cliente não pode ser 'null'");
        }
        String cpf = cliente.getCpf();
        if (repositorioCliente.indexDoCliente(cpf) != -1) {
            throw new ClienteException("Já existe cliente cadastrado com o CPF (" + cpf + ")");
        }
        repositorioCliente.inserirCliente(cliente);
    }

    @Override
    public Cliente procurarCliente(String cpf) throws ClienteException{
        if (cpf == null || cpf.isEmpty()) {
            throw new ClienteException("CPF vazio ou 'null' não é argumento válido");
        }
        if (repositorioCliente.indexDoCliente(cpf) != -1) {
            return repositorioCliente.procurarCliente(cpf);
        }
        return null;
    }

    @Override
    public void removerCliente(String cpf) throws ClienteException {
        if (cpf == null || cpf.isEmpty()) {
            throw new ClienteException("CPF vazio ou 'null' não é argumento inválido");
        }
        if (repositorioCliente.indexDoCliente(cpf) == -1) {
            throw new ClienteException("Não existe cliente com o CPF dado (" + cpf + ")");
        }
        repositorioCliente.removerCliente(cpf);
    }

    @Override
    public void atualizarCliente(Cliente cliente) throws ClienteException {
        if (cliente == null) {
            throw new ClienteException("cliente não pode ser 'null'");
        }
        String cpf = cliente.getCpf();
        if (repositorioCliente.indexDoCliente(cpf) == -1) {
            throw new ClienteException("Não existe cozinheiro cadastrado com o CPF dado (" + cpf + ")");
        }
        repositorioCliente.atualizarCliente(cliente);
    }

    @Override
    public int getTamanho() {
        return repositorioCliente.getTamanho();
    }

}