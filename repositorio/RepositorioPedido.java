package repositorio;

import exception.PedidoException;
import model.Pedido;
import java.util.List;
import java.util.ArrayList;

public class RepositorioPedido implements IRepositorioPedido {
    private static RepositorioPedido instancia;
    private List<Pedido> listaDePedidos = new ArrayList<>();

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
        listaDePedidos.add(pedido);
    }

    @Override
    public Pedido procurarPedido(String id) {
        Pedido pedidoEncontrado = null;

        for (Pedido pedido : listaDePedidos) {
            if (pedido != null && pedido.getId().equals(id)) {
                pedidoEncontrado = pedido;
                break;
            }
        }

        return pedidoEncontrado;
    }

    @Override
    public void removerPedido(String id) throws PedidoException {
        for (Pedido pedido : listaDePedidos) {
            if (pedido != null && pedido.getId().equals(id)) {
                listaDePedidos.remove(pedido);
                return;
            }
        }
    }

    @Override
    public void atualizarPedido(Pedido novoPedido) throws PedidoException {
        String id = novoPedido.getId();
        int index = indexDoPedido(id);

        if (index != -1) {
            listaDePedidos.remove(index);
            listaDePedidos.add(index, novoPedido);
        }
    }

    @Override
    public int getTamanho() {
        return listaDePedidos.size();
    }

    @Override
    public int indexDoPedido(String id) {
        int index = 0;

        for (Pedido pedido : listaDePedidos) {
            if (pedido != null && pedido.getId().equals(id)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    // Função apenas para fazer testes
    // TODO: Apagar essa função quando terminar o trabalho
    public void mostraLista() {
        for (Pedido pedido : listaDePedidos) {
            System.out.println(pedido);
        }
        System.out.println("--------------");
    }
}