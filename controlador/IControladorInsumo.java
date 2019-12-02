package controlador;

import model.Insumo;
import exception.InsumoException;

public interface IControladorInsumo {
    void inserirInsumo(Insumo insumo) throws InsumoException;
    Insumo procurarInsumo(String nome) throws InsumoException;
    void removerInsumo(String nome, int quantidade) throws InsumoException;
    void removerInsumo(String nome) throws InsumoException;
    void atualizarInsumo(Insumo insumo) throws InsumoException;
    void encherEstoqueDeInsumo();
    int getTamanho();
}