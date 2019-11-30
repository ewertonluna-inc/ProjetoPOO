package controlador;

import exception.InsumoException;
import model.Insumo;
import repositorio.IRepositorioInsumo;
import repositorio.RepositorioInsumo;

public class ControladorInsumo implements IControladorInsumo {
    private static ControladorInsumo instancia;
    private IRepositorioInsumo repositorioInsumo;

    private ControladorInsumo() {
        repositorioInsumo = RepositorioInsumo.getInstancia();
    }

    public static ControladorInsumo getInstacia() {
        if (instancia == null) {
            instancia = new ControladorInsumo();
        }
        return instancia;
    }

    @Override
    public void inserirInsumo(Insumo insumo) throws InsumoException {
        if (insumo == null) {
            throw new InsumoException("insumo não pode ser 'null'");
        }
        repositorioInsumo.inserirInsumo(insumo);
    }

    @Override
    public Insumo procurarInsumo(String nome) throws InsumoException {
        if (nome == null || nome.isEmpty) {
            throw new InsumoException("nome vazio ou 'null' não é argumento inválido");
        }
        return null;
    }

    @Override
    public void removerInsumo(String nome, int quantidade) throws InsumoException {
        // TODO Auto-generated method stub

    }

    @Override
    public void removerInsumo(String nome) throws InsumoException {
        // TODO Auto-generated method stub

    }

    @Override
    public void atualizarInsumo(Insumo insumo) throws InsumoException {
        // TODO Auto-generated method stub

    }

    @Override
    public int getTamanho() {
        // TODO Auto-generated method stub
        return 0;
    }

}