package controlador;

import exception.CozinheiroException;
import model.Cozinheiro;
import repositorio.IRepositorioCozinheiro;
import repositorio.RepositorioCozinheiro;

public class ControladorCozinheiro implements IControladorCozinheiro {
    private static ControladorCozinheiro instancia;
    private IRepositorioCozinheiro repositorioCozinheiro;

    private ControladorCozinheiro() {
        repositorioCozinheiro = RepositorioCozinheiro.getInstancia();
    }

    public static ControladorCozinheiro getInstancia() {
        if (instancia == null) {
            instancia = new ControladorCozinheiro();
        }
        return instancia;
    }

    @Override
    public void inserirCozinheiro(Cozinheiro cozinheiro) throws CozinheiroException {
        if (cozinheiro == null) {
            throw new CozinheiroException("cozinheiro não pode ser 'null'");
        }

        String cpf = cozinheiro.getCpf();
        if (repositorioCozinheiro.indexDoCozinheiro(cpf) != -1) { 
            throw new CozinheiroException("Já existe cozinheiro cadastrado com o CPF (" + cpf + ")");
        }
        repositorioCozinheiro.inserirCozinheiro(cozinheiro);
    }

    @Override
    public Cozinheiro procurarCozinheiro(String cpf) throws CozinheiroException {
        if (cpf == null ||  cpf.isEmpty()) {
            throw new CozinheiroException("CPF vazio ou 'null' não é argumento válido");
        }
        if (repositorioCozinheiro.indexDoCozinheiro(cpf) != -1) {
            return repositorioCozinheiro.procurarCozinheiro(cpf);
        }
		return null;
    }

    @Override
    public void removerCozinheiro(String cpf) throws CozinheiroException {
        if (cpf == null || cpf.isEmpty()) {
            throw new CozinheiroException("CPF vazio ou 'null' não é argumento válido");
        }
        if (repositorioCozinheiro.indexDoCozinheiro(cpf) == -1) {
            throw new CozinheiroException("Não existe cozinheiro com o CPF dado (" + cpf + ")");
        }
        repositorioCozinheiro.removerCozinheiro(cpf);

    }

    @Override
    public void atualizarCozinheiro(Cozinheiro cozinheiro) throws CozinheiroException {
        if (cozinheiro == null) {
            throw new CozinheiroException("cozinheiro não pode ser 'null'");
        }
        String cpf = cozinheiro.getCpf();
        if (repositorioCozinheiro.indexDoCozinheiro(cpf) == -1) {
            throw new CozinheiroException("Não existe cozinheiro cadastrado com o CPF dado (" + cpf + ")");
        }
        repositorioCozinheiro.atualizarCozinheiro(cozinheiro);
    }

    @Override
    public int getTamanho() {
        return repositorioCozinheiro.getTamanho();
    }
}