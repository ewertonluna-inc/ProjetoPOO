package controlador;

import exception.BalconistaException;
import model.Balconista;
import repositorio.IRepositorioBalconista;
import repositorio.RepositorioBalconista;

public class ControladorBalconista implements IControladorBalconista {
    private IRepositorioBalconista repositorioBalconista;
    private static ControladorBalconista instancia;

    private ControladorBalconista() {
        repositorioBalconista = RepositorioBalconista.getInstancia();
    }

    public static ControladorBalconista getInstancia() {
        if (instancia == null) {
            instancia = new ControladorBalconista();
        }
        return instancia;
    }

    @Override
    public void inserirBalconista(Balconista balconista) throws BalconistaException {
        String cpf = balconista.getCpf();
        
        // TODO: Perguntar ao professor o porque disso ser código morto.
        // if (balconista == null) {
        //     throw new BalconistaException("null não é um argumento válido");
        // }
        if (repositorioBalconista.indexDoBalconista(cpf) != -1) {
            throw new BalconistaException("CPF (" + cpf + ") já existente no repositório");
        }
        
        repositorioBalconista.inserirBalconista(balconista);
    }

    @Override
    public Balconista procurarBalconista(String cpf) throws BalconistaException {
        if (cpf == null || cpf.isEmpty()) {
            throw new BalconistaException("CPF vazio ou null não é argumento inválido");
        }
        if (repositorioBalconista.indexDoBalconista(cpf) != -1) {
            return repositorioBalconista.procurarBalconista(cpf);
        }
        return null;
    }

    @Override
    public void removerBalconista(String cpf) throws BalconistaException {
        if (cpf == null || cpf.isEmpty()) {
            throw new BalconistaException("CPF vazio ou null não é argumento inválido");
        }
        if (repositorioBalconista.indexDoBalconista(cpf) == -1) {
            throw new BalconistaException("Não existe balconista com o CPF dado (" + cpf + ")");
        }
        repositorioBalconista.removerBalconista(cpf);
    }

    @Override
    public void atualizarBalconista(Balconista balconista) throws BalconistaException {
        String cpf = balconista.getCpf();
        // TODO: Perguntar ao professor o porque disso ser código morto.
        // if (balconista == null) {
        //     throw new BalconistaException("null não é argumento válido");
        // }
        if (repositorioBalconista.indexDoBalconista(cpf) == -1) {
            throw new BalconistaException("Não existe balconista cadastrado com o CPF dado (" + cpf + ")");
        }
        repositorioBalconista.atualizarBalconista(balconista);
    }   

    @Override
    public int getTamanho() {
        return repositorioBalconista.getTamanho();
    }
    
}