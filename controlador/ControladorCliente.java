package controlador;

import exception.ClienteException;
import model.Cliente;

// TODO: Continuar 

public class ControladorCliente implements IControladorCliente {
    static private ControladorCliente instancia;
    // 

    private ControladorCliente() {

    }

    static public ControladorCliente getInstancia(){
        if (instancia == null) {
            instancia = new ControladorCliente();
        }
        
        return instancia;
    }

    @Override
    public void inserirCliente(Cliente cliente) throws ClienteException {
        // TODO Auto-generated method stub

    }

    @Override
    public Cliente procurarCliente(String cpf) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removerCliente(String cpf) throws ClienteException {
        // TODO Auto-generated method stub

    }

    @Override
    public void atualizarCliente(Cliente cliente) throws ClienteException {
        // TODO Auto-generated method stub

    }

}