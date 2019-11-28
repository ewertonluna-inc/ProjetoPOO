package model;

import exception.LancheException;
import java.util.List;
import java.util.ArrayList;

public class Lanche {
    private String nome;
    private List<Insumo> insumos;
    private double preco;

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
            incrementaPreco(insumo.getPrecoTotal());
        } else {
            Insumo insumoEncontrado = procurarInsumoPorNome(insumo.getNome());
            if (insumoEncontrado != null) {
                    insumoEncontrado.aumentarQuantidade(insumo.getQuantidade());
                    incrementaPreco(insumo.getPrecoTotal());
            } else {
                insumos.add(insumo);
                incrementaPreco(insumo.getPrecoTotal());
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

    public void incrementaPreco(double preco) throws LancheException{
        if (preco < 0) {
            throw new LancheException("Preço não pode ser menor que zero");
        }
        this.preco += preco;
    }

    public void removerInsumo(Insumo insumo) throws LancheException {
        // TODO: Concluir essa função
        // if (insumo == null) {
        //     throw new LancheException("null não é um argumento válido");
        // }

        // for (Insumo item : insumos) {
        //     if (item != null && item.getNome().equals(insumo.getNome())){
        //         try {
        //             item.aumentarQuantidade(insumo.getQuantidade());
        //         } catch (InsumoException e) {
        //             System.out.println("Houve um erro: " + e.getMessage());
        //         }
                
        //     } else {
        //         insumos.add(insumo);
        //     }
        // }
    }

    public double getCalorias() {
        double calorias = 0;
        
        for (Insumo insumo : insumos) {
            calorias += insumo.getCalorias();
        }
        return calorias;
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