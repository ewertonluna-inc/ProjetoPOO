package repositorio;

import exception.PedidoException;
import model.Pedido;
import java.util.List;
import java.util.ArrayList;

public class RepositorioPedido implements IRepositorioPedido {
    private static RepositorioPedido instancia;
    private List<Pedido> listaDePedido = new ArrayList<>();

    private RepositorioPedido() {

    }

    public static RepositorioPedido getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioPedido();
        }
        return instancia;
    }

    @Override
    public void inserirPedido(Pedido pedido) throws PedidoException {
        listaDePedido.add(pedido);

    }

    @Override
    public Pedido procurarPedido(int id) {
        Pedido pedidoEncontrado = null;

        for (Pedido pedido : listaDePedido) {
            if (pedido.getId() == id) {
                pedidoEncontrado = pedido;
                break;
            }
        }

        return pedidoEncontrado;
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
        return listaDePedido.size();
    }

    @Override
    public int indexDoPedido(int id) {
        // TODO Auto-generated method stub
        return 0;
    }
}