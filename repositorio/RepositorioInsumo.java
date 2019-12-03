package repositorio;

import java.util.ArrayList;
import java.util.List;
import exception.InsumoException;
import model.Insumo;
import util.Estoque;

public class RepositorioInsumo implements IRepositorioInsumo {
    private static RepositorioInsumo instancia;
    private List<Insumo> listaDeInsumos = new ArrayList<>();

    private RepositorioInsumo() {

    }

    public static RepositorioInsumo getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioInsumo();
        }
        return instancia;
    }

    @Override
    public void inserirInsumo(Insumo insumo) throws InsumoException {
        String nome = insumo.getNome();
        int index = indexDoInsumo(nome);

        // Se o tamanho da lista for 0 ou não existir insumo que contenha o mesmo nome, adiciona o objeto insumo a lista
        if (listaDeInsumos.size() == 0 || index == -1) {
            listaDeInsumos.add(insumo);
            return;
        } 
        // Caso contrário, adiciona-se à quantidade do insumo já existe
        listaDeInsumos.get(index).aumentarQuantidade(insumo.getQuantidade());
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
                
                if (insumo.getQuantidade() == 0 || quantidade > insumo.getQuantidade()) {
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
                int index = listaDeInsumos.indexOf(insumo);
                listaDeInsumos.remove(index);
                listaDeInsumos.add(index, novoInsumo);
                return;
            }
        }

    }

    public int getTamanho() {
        return listaDeInsumos.size();
    }

    // Método que será útil para o controlador
    @Override
    public int indexDoInsumo(String nome) {
        int index = 0;

        for (Insumo insumo : listaDeInsumos) {
            if (insumo != null && insumo.getNome().equals(nome)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    // Função apenas para fazer testes
    // TODO: Apagar essa função quando terminar o trabalho
    public void mostraLista() {
        for (Insumo insumo : listaDeInsumos) {
            System.out.println(insumo);
        }
        System.out.println("--------------");
    }

    @Override
    public void encherEstoque() {
        listaDeInsumos.clear();
        listaDeInsumos.add(Estoque.createTomate());
        listaDeInsumos.add(Estoque.createAlface());
        listaDeInsumos.add(Estoque.createCarne());
        listaDeInsumos.add(Estoque.createPao());
        listaDeInsumos.add(Estoque.createQueijo());
        listaDeInsumos.add(Estoque.createBacon());
    }
}