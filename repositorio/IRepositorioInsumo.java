package repositorio;

import model.Insumo;
import exception.InsumoException;

public interface IRepositorioInsumo {
    void inserirInsumo(Insumo insumo) throws InsumoException;
    Insumo procurarInsumo(String nome);
    void removerInsumo(String nome, int quantidade) throws InsumoException;
    void removerInsumo(String nome) throws InsumoException;
    void atualizarInsumo(Insumo insumo) throws InsumoException;
    int indexDoInsumo(String nome);
    int getQuantidadeDeInsumo(String nome) throws InsumoException;
    void encherEstoque();
    int getTamanho();
}