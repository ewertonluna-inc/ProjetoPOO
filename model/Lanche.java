package model;

import exception.InsumoException;
import exception.LancheException;
import java.util.List;
import java.util.ArrayList;

public class Lanche {
    String nome;
    List<Insumo> insumos;
    double preco;

    public Lanche(String nome) {
        this.nome = nome;
        insumos = new ArrayList<>();
        preco = 0;
    }

    public void adicionarInsumo(Insumo insumo) throws LancheException{

        if (insumos == null) {
            throw new LancheException("null não é um argumento válido");
        }

        if (insumos.size() == 0) {
            insumos.add(insumo);

        } else {
            Insumo insumoEncontrado = procurarInsumoPorNome(insumo.nome);
            if (insumoEncontrado != null) {
                try {
                    insumoEncontrado.aumentarQuantidade(insumo.getQuantidade());
                } catch (InsumoException e) {
                    System.out.println("Houve um erro: " + e.getMessage());
                }
            } else {
                insumos.add(insumo);
            }
        }
    }

    public Insumo procurarInsumoPorNome(String nome) {
        nome = nome.toLowerCase();

        for (Insumo insumo : insumos) {
            if (insumo != null && insumo.getNome().equals(nome)) {
                return insumo;
            }
        }
        
        return null;
    }

    public void atualizaPreco() {
        double precoFinal = 0;

        for (Insumo insumo : insumos) {
            
        }
    }

    public void removerInsumo(Insumo insumo) throws LancheException {
        if (insumo == null) {
            throw new LancheException("null não é um argumento válido");
        }

        for (Insumo item : insumos) {
            if (item != null && item.getNome().equals(insumo.getNome())){
                try {
                    item.aumentarQuantidade(insumo.getQuantidade());
                } catch (InsumoException e) {
                    System.out.println("Houve um erro: " + e.getMessage());
                }
                
            } else {
                insumos.add(insumo);
            }
        }

    }

    public String getNome() {
        return nome;
    }

    public List<Insumo> getInsumos() {
        return insumos;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Lanche [insumos=" + insumos + ", nome=" + nome + ", preco=" + preco + "]";
    }

    
}