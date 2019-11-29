package repositorio;

import model.Pedido;
import exception.PedidoException;

public interface IRepositorioPedido {
    void inserirPedido(Pedido pedido) throws PedidoException;
    Pedido procurarPedido(int id);
    void removerPedido(int id) throws PedidoException;
    void atualizarPedido(Pedido pedido) throws PedidoException;
    int getTamanho();
    int indexDoPedido(int id);
}