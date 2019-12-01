package controlador;

import exception.BalconistaException;
import exception.ClienteException;
import exception.CozinheiroException;
import exception.GerenteException;
import exception.InsumoException;
import exception.PedidoException;
import model.Balconista;
import model.Cliente;
import model.Cozinheiro;
import model.Gerente;
import model.Insumo;
import model.Pedido;

public class Fachada implements IControladorBalconista, IControladorCliente, IControladorCozinheiro,
        IControladorGerente, IControladorInsumo, IControladorPedido {
    
    private static Fachada instancia;
    private IControladorBalconista controladorBalconista;
    private IControladorCliente controladorCliente;
    private IControladorCozinheiro controladorCozinheiro;
    private IControladorGerente controladorGerente;
    private IControladorInsumo controladorInsumo;
    private IControladorPedido controladorPedido;

    private Fachada() {
        controladorBalconista = ControladorBalconista.getInstancia();
        controladorCliente = ControladorCliente.getInstancia();
        controladorCozinheiro = ControladorCozinheiro.getInstancia();
        controladorGerente = ControladorGerente.getInstancia();
        controladorInsumo = ControladorInsumo.getInstancia();
        controladorPedido = ControladorPedido.getInstancia();
    }

    public static Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    @Override
    public void inserirPedido(Pedido pedido) throws PedidoException {
        controladorPedido.inserirPedido(pedido);
    }

    @Override
    public Pedido procurarPedido(String id) throws PedidoException {
        return controladorPedido.procurarPedido(id);
    }

    @Override
    public void removerPedido(String id) throws PedidoException {
        controladorPedido.removerPedido(id);

    }

    @Override
    public void atualizarPedido(Pedido pedido) throws PedidoException {
        controladorPedido.atualizarPedido(pedido);

    }

    @Override
    public void inserirInsumo(Insumo insumo) throws InsumoException {
        controladorInsumo.inserirInsumo(insumo);
    }

    @Override
    public Insumo procurarInsumo(String nome) throws InsumoException {
        return controladorInsumo.procurarInsumo(nome);
    }

    @Override
    public void removerInsumo(String nome, int quantidade) throws InsumoException {
        controladorInsumo.removerInsumo(nome, quantidade);
    }

    @Override
    public void removerInsumo(String nome) throws InsumoException {
        controladorInsumo.removerInsumo(nome);
    }

    @Override
    public void atualizarInsumo(Insumo insumo) throws InsumoException {
        controladorInsumo.atualizarInsumo(insumo);
    }

    @Override
    public void inserirGerente(Gerente gerente) throws GerenteException {
        controladorGerente.inserirGerente(gerente);
    }

    @Override
    public Gerente procurarGerente(String cpf) throws GerenteException {
        return controladorGerente.procurarGerente(cpf);
    }

    @Override
    public void removerGerente(String cpf) throws GerenteException {
        controladorGerente.removerGerente(cpf);
    }

    @Override
    public void atualizarGerente(Gerente gerente) throws GerenteException {
        controladorGerente.atualizarGerente(gerente);
    }

    @Override
    public void inserirCozinheiro(Cozinheiro cozinheiro) throws CozinheiroException {
        controladorCozinheiro.inserirCozinheiro(cozinheiro);
    }

    @Override
    public Cozinheiro procurarCozinheiro(String cpf) throws CozinheiroException {
        return controladorCozinheiro.procurarCozinheiro(cpf);
    }

    @Override
    public void removerCozinheiro(String cpf) throws CozinheiroException {
        controladorCozinheiro.removerCozinheiro(cpf);
    }

    @Override
    public void atualizarCozinheiro(Cozinheiro cozinheiro) throws CozinheiroException {
        controladorCozinheiro.atualizarCozinheiro(cozinheiro);
    }

    @Override
    public void inserirCliente(Cliente cliente) throws ClienteException {
        controladorCliente.inserirCliente(cliente);
    }

    @Override
    public Cliente procurarCliente(String cpf) throws ClienteException {
        return controladorCliente.procurarCliente(cpf);
    }

    @Override
    public void removerCliente(String cpf) throws ClienteException {
        controladorCliente.removerCliente(cpf);
    }

    @Override
    public void atualizarCliente(Cliente cliente) throws ClienteException {
        controladorCliente.atualizarCliente(cliente);

    }

    @Override
    public void inserirBalconista(Balconista balconista) throws BalconistaException {
        controladorBalconista.inserirBalconista(balconista);
    }

    @Override
    public Balconista procurarBalconista(String cpf) throws BalconistaException {
        return controladorBalconista.procurarBalconista(cpf);
    }

    @Override
    public void removerBalconista(String cpf) throws BalconistaException {
        controladorBalconista.removerBalconista(cpf);
    }

    @Override
    public void atualizarBalconista(Balconista balconista) throws BalconistaException {
        controladorBalconista.atualizarBalconista(balconista);

    }

    @Override
    public int getTamanho() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}