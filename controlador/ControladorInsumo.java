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

    public static ControladorInsumo getInstancia() {
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
        if (insumo.getQuantidade() < 0) {
            throw new InsumoException("campo 'quantidade de insumo não pode ser negativo'");
        }
        repositorioInsumo.inserirInsumo(insumo);
    }

    @Override
    public Insumo procurarInsumo(String nome) throws InsumoException {
        if (nome == null || nome.isEmpty()) {
            throw new InsumoException("nome vazio ou 'null' não é argumento válido");
        }
        if(repositorioInsumo.indexDoInsumo(nome) != -1) {
            return repositorioInsumo.procurarInsumo(nome);
        }
        return null;
    }

    @Override
    public void removerInsumo(String nome, int quantidade) throws InsumoException {
        if (nome == null || nome.isEmpty() || quantidade < 0) {
            throw new InsumoException("Parâmetro 'nome' ou 'quantidade' inválido");
        }
        if (repositorioInsumo.indexDoInsumo(nome) == -1) {
            throw new InsumoException("Não existe insumo com o 'nome' (" + nome + ") dado");
        }
        repositorioInsumo.removerInsumo(nome, quantidade);
    }

    @Override
    public void removerInsumo(String nome) throws InsumoException {
        if (nome == null || nome.isEmpty()) {
            throw new InsumoException("Parâmetro 'nome' ou 'quantidade' inválido");
        }
        if (repositorioInsumo.indexDoInsumo(nome) == -1) {
            throw new InsumoException("Não existe ìnsumo com o 'nome' (" + nome + ") dado");
        }
        repositorioInsumo.removerInsumo(nome);
    }

    @Override
    public void atualizarInsumo(Insumo insumo) throws InsumoException {
        if (insumo == null) {
            throw new InsumoException("insumo não pode ser 'null'");
        }
        String nome = insumo.getNome();
        if (repositorioInsumo.indexDoInsumo(nome) == -1) {
            throw new InsumoException("Não existe insumo cadastrado com o 'nome' dado (" + nome + ")");
        }
        repositorioInsumo.atualizarInsumo(insumo);
    }

    @Override
    public int getTamanho() {
        return repositorioInsumo.getTamanho();
    }

    @Override
    public void encherEstoqueDeInsumo() {
        repositorioInsumo.encherEstoque();
    }

    @Override
    public int getQuantidadeDeInsumo(String nome) throws InsumoException {
        if (nome == null || nome.isEmpty()) {
            throw new InsumoException("'nome' não pode ser null ou string vazia");
        }
        if (repositorioInsumo.indexDoInsumo(nome) == -1) {
            throw new InsumoException("Não há insumo (" + nome + ") cadastrado");
        }

        return repositorioInsumo.getQuantidadeDeInsumo(nome);
    }

}