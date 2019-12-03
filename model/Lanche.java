package model;

import exception.InsumoException;
import exception.LancheException;
import java.util.List;
import java.util.ArrayList;

public class Lanche {
    private String nome;
    private List<Insumo> insumos;

    public Lanche(String nome) {
        this.nome = nome;
        insumos = new ArrayList<>();
    }

    public double getCalorias() {
        double calorias = 0;

        for (Insumo insumo : insumos) {
            calorias += insumo.getCaloriasTotal();
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
        double preco = 0;
        
        if (insumos.size() > 0) {
            for (Insumo insumo : insumos) {
                preco += insumo.getPrecoTotal();
            }
        }
        
        return preco;
    }

    public void adicionarInsumo(Insumo insumo) throws LancheException{
        if (insumos == null) {
            throw new LancheException("null não é um argumento válido");
        }
        // Quando adiciona-se um insumo, é necessário que sua quantidade seja, no mínimo, 1.
        if (insumo.getQuantidade() < 0) {
            throw new LancheException("Quantidade do insumo adicionado tem que ser igual ou maior que 1");
        }
        // Se a lista de insumos estiver vazia, adiciona Insumo a lista
        if (insumos.size() == 0) {
            insumos.add(insumo);
        } else {
            Insumo insumoEncontrado = procurarInsumoPorNome(insumo.getNome());
            // Se já houver algum insumo com o mesmo nome, aumenta propriedade quantidade do Insumo
            if (insumoEncontrado != null) {
                    insumoEncontrado.aumentarQuantidade(insumo.getQuantidade());
            // Se não houver insumo com o mesmo nome, adiciona Insumo a lista
            } else {
                insumos.add(insumo);
            }
        }
    }

    public void removerInsumoPorNome(String nome) throws LancheException{
        if (nome == null) {
            throw new LancheException("Parâmetro 'nome' não pode ser null");
        }
        if (insumos.size() == 0) {
            throw new LancheException("O campo 'insumos' precisa ter pelo menos 1 objeto Insumo");
        }

        Insumo insumo = procurarInsumoPorNome(nome);
        
        if (insumo == null) {
            throw new LancheException("Não há '" + nome + "' entre os insumos");
        }
        // Se a quantidade do insumo for no mínimo 1, remove o objeto insumo da lista
        if (insumo.getQuantidade() <= 1) {
            insumos.remove(insumo);
        } else {
            try {
                insumo.diminuirQuantidade();
            } catch (InsumoException e) {
                throw new LancheException("Não foi possível remover insumo: " + e.getMessage());
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

    @Override
    public String toString() {
        return "Lanche [insumos=" + insumos + ", nome=" + nome + ", preco=" + getPreco() + "]";
    }

    
}