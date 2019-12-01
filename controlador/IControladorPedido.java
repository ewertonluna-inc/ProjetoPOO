package controlador;

import exception.PedidoException;
import model.Pedido;

public interface IControladorPedido {
    void inserirPedido(Pedido pedido) throws PedidoException;
    Pedido procurarPedido(String id) throws PedidoException;
    void removerPedido(String id) throws PedidoException;
    void atualizarPedido(Pedido pedido) throws PedidoException;
    int getTamanho();
}