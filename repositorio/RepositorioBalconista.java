package repositorio;

import exception.BalconistaException;
import model.Balconista;
import java.util.List;
import java.util.ArrayList;

public class RepositorioBalconista implements IRepositorioBalconista {
    private static RepositorioBalconista instancia;
    private List<Balconista> listaDeBalconistas = new ArrayList<>();

    private RepositorioBalconista() {

    }

    public static RepositorioBalconista getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioBalconista();
        }
        return instancia;
    }
    

    @Override
    public void inserirBalconista(Balconista balconista) throws BalconistaException {
        listaDeBalconistas.add(balconista);

    }

    @Override
    public Balconista procurarBalconista(String cpf) {
        Balconista balconistaEncontrado = null;

        for (Balconista balconista : listaDeBalconistas) {
            if (balconista != null && balconista.getCpf().equals(cpf)) {
                balconistaEncontrado = balconista;
                break;
            }
        }
        return balconistaEncontrado;
    }

    @Override
    public void removerBalconista(String cpf) throws BalconistaException {
        for (Balconista balconista : listaDeBalconistas) {
            if (balconista != null && balconista.getCpf().equals(cpf)) {
                listaDeBalconistas.remove(balconista);
                return;
            }
        }

    }

    @Override
    public void atualizarBalconista(Balconista novoBalconista) throws BalconistaException {
        String cpf = novoBalconista.getCpf();
        int index = indexDoBalconista(cpf);

        // Esse pode ser redundante, já que o contrador já vai fazer essa verificação
        if (index != -1) {
            listaDeBalconistas.remove(index);
            listaDeBalconistas.add(index, novoBalconista);
        }


    }

    public int indexDoBalconista(String cpf) {
        int index = 0;
        
        for (Balconista balconista : listaDeBalconistas) {
            if (balconista != null && balconista.getCpf().equals(cpf)) {
                return index;
            }
            index++;
        }   
        return -1;
    }
    
    public int getTamanho() {
        return listaDeBalconistas.size();
    }

    // Função apenas para fazer testes
    // TODO: Apagar essa função quando terminar o trabalho
    public void mostraLista() {
        for (Balconista balconista : listaDeBalconistas) {
            System.out.println(balconista);
        }
        System.out.println("--------------");
    }
}