package repositorio;

import java.util.ArrayList;
import java.util.List;

import exception.InsumoException;
import model.Insumo;

public class RepositorioInsumo implements IRepositorioInsumo {
    private static RepositorioInsumo instancia;
    private List<Insumo> listaDeInsumos = new ArrayList<>();

    @Override
    public void inserirInsumo(Insumo insumo) throws InsumoException {
        for (Insumo item : listaDeInsumos) {
            if (item != null && item.getNome().equals(insumo.getNome())) {
                item.aumentarQuantidade(insumo.getQuantidade());
                return;
            } else {
                listaDeInsumos.add(insumo);
                return;
            }
        }

    }

    @Override
    public Insumo procurarInsumo(String nome) {
        Insumo insumoEncontrado = null;

        for (Insumo insumo : listaDeInsumos) {
            if (insumo != null && insumo.getNome().equals(nome)) {
                insumoEncontrado = insumo;
                break;
            }
        }
        return insumoEncontrado;
    }

    @Override
    public void removerInsumo(String nome, int quantidade) throws InsumoException {
        for (Insumo insumo : listaDeInsumos) {
            if (insumo != null && insumo.getNome().equals(nome)) {
                
                if (insumo.getQuantidade() == 0) {
                    listaDeInsumos.remove(insumo);
                } else {
                    insumo.diminuirQuantidade(quantidade);
                }
                return;
            }
        }
    }

    public void removerInsumo(String nome) throws InsumoException{
        for (Insumo insumo : listaDeInsumos) {
            if (insumo != null && insumo.getNome().equals(nome)) {
                listaDeInsumos.remove(insumo);
                return;
            }
        }
    }

    @Override
    public void atualizarInsumo(Insumo novoInsumo) throws InsumoException {
        String nome = novoInsumo.getNome();
        
        for (Insumo insumo : listaDeInsumos) {
            if (insumo != null && insumo.getNome().equals(nome)) {
                insumo = novoInsumo;
                return;
            }
        }

    }

    public int getTamanho() {
        return listaDeInsumos.size();
    }

}