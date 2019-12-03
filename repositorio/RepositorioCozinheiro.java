package repositorio;

import exception.CozinheiroException;
import model.Cozinheiro;
import java.util.List;
import java.util.ArrayList;

public class RepositorioCozinheiro implements IRepositorioCozinheiro {
    private static RepositorioCozinheiro instancia;
    private List<Cozinheiro> listaDeCozinheiros = new ArrayList<>();

    private RepositorioCozinheiro() {

    }

    public static RepositorioCozinheiro getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioCozinheiro();
        }
        return instancia;
    }

    @Override
    public void inserirCozinheiro(Cozinheiro cozinheiro) throws CozinheiroException {
        listaDeCozinheiros.add(cozinheiro);

    }

    @Override
    public Cozinheiro procurarCozinheiro(String cpf) {
        Cozinheiro cozinheiroEcontrado = null;

        for (Cozinheiro cozinheiro : listaDeCozinheiros) {
            if (cozinheiro != null && cozinheiro.getCpf().equals(cpf)) {
                cozinheiroEcontrado = cozinheiro;
                break;
            }
        }
        return cozinheiroEcontrado;
    }

    @Override
    public void removerCozinheiro(String cpf) throws CozinheiroException {
        for (Cozinheiro cozinheiro : listaDeCozinheiros) {
            if (cozinheiro != null && cozinheiro.getCpf().equals(cpf)) {    
                listaDeCozinheiros.remove(cozinheiro);
                return;
            }
        }
    }

    @Override
    public void atualizarCozinheiro(Cozinheiro novoCozinheiro) throws CozinheiroException {
        String cpf = novoCozinheiro.getCpf();
        int index = indexDoCozinheiro(cpf);

        if (index != -1) {
            listaDeCozinheiros.remove(index);
            listaDeCozinheiros.add(index, novoCozinheiro);
        }
    }

    @Override
    public int indexDoCozinheiro(String cpf) {
        int index = 0;
        
        for (Cozinheiro cozinheiro : listaDeCozinheiros) {
            if (cozinheiro != null && cozinheiro.getCpf().equals(cpf)) {
                return index;
            }
            index++;
        }   
        return -1;
    }

    public int getTamanho() {
        return listaDeCozinheiros.size();
    }

    // Função apenas para fazer testes
    // TODO: Apagar essa função quando terminar o trabalho
    public void mostraLista() {
        for (Cozinheiro cozinheiro : listaDeCozinheiros) {
            System.out.println(cozinheiro);
        }
        System.out.println("--------------");
    }

    @Override
    public Cozinheiro getCozinheiroLivre() throws CozinheiroException {
        if (listaDeCozinheiros.size() == 0) {
            throw new CozinheiroException("Lista de cozinheiro está vazia");
        }

        for (Cozinheiro cozinheiro : listaDeCozinheiros) {
            if (cozinheiro != null && cozinheiro.getPedidoAtual() == null) {
                return cozinheiro;
            }
            if (cozinheiro != null && cozinheiro.getPedidoAtual().isPronto()) {
                return cozinheiro;
            }
        }
        
        return null;
    }
    
}