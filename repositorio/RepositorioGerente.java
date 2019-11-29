package repositorio;

import exception.GerenteException;
import model.Gerente;
import java.util.List;
import java.util.ArrayList;

public class RepositorioGerente implements IRepositorioGerente {
    private static RepositorioGerente instancia;
    private List<Gerente> listaDeGerentes = new ArrayList<>();

    private RepositorioGerente() {

    }

    public static RepositorioGerente getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioGerente();
        }
        return instancia;
    }

    @Override
    public void inserirGerente(Gerente gerente) throws GerenteException {
        listaDeGerentes.add(gerente);
    }

    @Override
    public Gerente procurarGerente(String cpf) {
        Gerente gerenteEncontrado = null;

        for (Gerente gerente : listaDeGerentes) {
            if (gerente != null && gerente.getCpf().equals(cpf)) {
                gerenteEncontrado = gerente;
                break;
            }
        }
        return gerenteEncontrado;
    }

    @Override
    public void removerGerente(String cpf) throws GerenteException {
        for (Gerente gerente : listaDeGerentes) {
            if (gerente != null && gerente.getCpf().equals(cpf)) {
                listaDeGerentes.remove(gerente);
                return;
            }
        }

    }

    @Override
    public void atualizarGerente(Gerente novoGerente) throws GerenteException {
        String cpf = novoGerente.getCpf();
        int index = indexDoGerente(cpf);

        if (index != -1) {
            listaDeGerentes.remove(index);
            listaDeGerentes.add(index, novoGerente);
        }

    }

    public int indexDoGerente(String cpf) {
        int index = 0;
        
        for (Gerente gerente : listaDeGerentes) {
            if (gerente != null && gerente.getCpf().equals(cpf)) {
                return index;
            }
            index++;
        }   
        return -1;
    }

    public int getTamanho() {
        return listaDeGerentes.size();
    }

    // Função apenas para fazer testes
    // TODO: Apagar essa função quando terminar o trabalho
    public void mostraLista() {
        for (Gerente gerente : listaDeGerentes) {
            System.out.println(gerente);
        }
        System.out.println("--------------");
    }
    
}