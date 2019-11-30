package repositorio;

import exception.ClienteException;
import model.Cliente;
import java.util.List;
import java.util.ArrayList;

public class RepositorioCliente implements IRepositorioCliente {
    private static RepositorioCliente instancia;
    private List<Cliente> listaDeClientes = new ArrayList<>();

    private RepositorioCliente() {

    }
    
    public static RepositorioCliente getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioCliente();
        }
        return instancia;
    }

    @Override
    // Controlador verifica se já existe cliente com o mesmo CPF
    public void inserirCliente(Cliente cliente) throws ClienteException {
        listaDeClientes.add(cliente);

    }

    @Override
    public Cliente procurarCliente(String cpf) {
        Cliente clienteEncontrado = null;

        for (Cliente cliente : listaDeClientes) {
            if (cliente != null && cliente.getCpf().equals(cpf)){
                clienteEncontrado = cliente;
                break;
            }
        }

        return clienteEncontrado;
    }

    @Override
    public void removerCliente(String cpf) throws ClienteException {
        for (Cliente cliente : listaDeClientes) {
            if (cliente != null && cliente.getCpf().equals(cpf)) {
                listaDeClientes.remove(cliente);
                return;
            }
        }
    }

    @Override
    public void atualizarCliente(Cliente novoCliente) throws ClienteException {
        String cpf = novoCliente.getCpf();
        int index = indexDoCliente(cpf);

        // Esse pode ser redundante, já que o contrador já vai fazer essa verificação
        if (index != -1) {
            listaDeClientes.remove(index);
            listaDeClientes.add(index, novoCliente);
        }
    } 

    public int indexDoCliente(String cpf) {
        int index = 0;
        
        for (Cliente cliente : listaDeClientes) {
            if (cliente != null && cliente.getCpf().equals(cpf)) {
                return index;
            }
            index++;
        }   
        return -1;
    }

    public int getTamanho() {
        return listaDeClientes.size();
    }

    // Função apenas para fazer testes
    // TODO: Apagar essa função quando terminar o trabalho
    public void mostraLista() {
        for (Cliente cliente : listaDeClientes) {
            System.out.println(cliente);
        }
        System.out.println("--------------");
    }

}