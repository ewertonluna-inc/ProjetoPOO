package controlador;

import exception.PedidoException;
import model.Pedido;
import repositorio.IRepositorioPedido;
import repositorio.RepositorioPedido;

public class ControladorPedido implements IControladorPedido {
    private static ControladorPedido instancia;
    private IRepositorioPedido repositorioPedido;

    private ControladorPedido() {
        repositorioPedido = RepositorioPedido.getInstancia();
    }

    public static ControladorPedido getInstancia() {
        if (instancia == null) {
            instancia = new ControladorPedido();
        }
        return instancia;
    }

    @Override
    public void inserirPedido(Pedido pedido) throws PedidoException {
        if (pedido == null) {
            throw new PedidoException("pedido não pode ser null");
        }
        String id = pedido.getId();
        if (repositorioPedido.indexDoPedido(id) != -1) {
            throw new PedidoException("Já existe pedido cadastrado com id (" + id + ")");
        }
        repositorioPedido.inserirPedido(pedido);
    }

    @Override
    public Pedido procurarPedido(String id) throws PedidoException{
        if (id == null || id.isEmpty()) {
            throw new PedidoException("id vazio ou null não é argumento válido");
        }
        if (repositorioPedido.indexDoPedido(id) != -1) {
            return repositorioPedido.procurarPedido(id);
        }
        return null;
    }

    @Override
    public void removerPedido(String id) throws PedidoException {
        if (id == null || id.isEmpty()) {
            throw new PedidoException("id vazio ou null não é argumento válido");
        }
        if (repositorioPedido.indexDoPedido(id) == -1) {
            throw new PedidoException("Não existe pedido com o id dado (" + id + ")");
        }
        repositorioPedido.removerPedido(id);
    }

    @Override
    public void atualizarPedido(Pedido pedido) throws PedidoException {
        if (pedido == null) {
            throw new PedidoException("pedido não pode ser 'null'");
        }
        String id = pedido.getId();
        if (repositorioPedido.indexDoPedido(id) == -1) {
            throw new PedidoException("Não existe pedido cadastrado com o id dado (" + id + ")");
        }
        repositorioPedido.atualizarPedido(pedido);
    }

    @Override
    public int getTamanho() {
        return repositorioPedido.getTamanho();
    }
    
}