package repositorio;

import exception.PedidoException;
import model.Pedido;
import java.util.List;
import java.util.ArrayList;

public class RepositorioPedido implements IRepositorioPedido {
    private static RepositorioPedido instancia;
    private List<Pedido> listaDePedido = new ArrayList<>();

    @Override
    public void inserirPedido(Pedido pedido) throws PedidoException {
        // TODO Auto-generated method stub

    }

    @Override
    public Pedido procurarPedido(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removerPedido(int id) throws PedidoException {
        // TODO Auto-generated method stub

    }

    @Override
    public void atualizarPedido(Pedido pedido) throws PedidoException {
        // TODO Auto-generated method stub

    }

    @Override
    public int getTamanho() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int indexDoPedido(int id) {
        // TODO Auto-generated method stub
        return 0;
    }
}