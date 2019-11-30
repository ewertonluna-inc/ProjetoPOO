package controlador;

import exception.GerenteException;
import model.Gerente;
import repositorio.IRepositorioGerente;
import repositorio.RepositorioGerente;


public class ControladorGerente implements IControladorGerente {
    private static ControladorGerente instancia;
    private IRepositorioGerente repositorioGerente;

    private ControladorGerente() {
        repositorioGerente = RepositorioGerente.getInstancia();
    }

    public static ControladorGerente getInstancia() {
        if (instancia == null) {
            instancia = new ControladorGerente();
        }
        return instancia;
    }

	@Override
	public void inserirGerente(Gerente gerente) throws GerenteException {
        if (gerente == null) {
            throw new GerenteException("gerente não pode ser 'null'");
        }

        String cpf = gerente.getCpf();
        if (repositorioGerente.indexDoGerente(cpf) != -1) { 
            throw new GerenteException("Já existe gerente cadastrado com o CPF (" + cpf + ")");
        }
        repositorioGerente.inserirGerente(gerente);
	}

	@Override
	public Gerente procurarGerente(String cpf) throws GerenteException {
		if (cpf == null ||  cpf.isEmpty()) {
            throw new GerenteException("CPF vazio ou 'null' não é argumento inválido");
        }
        if (repositorioGerente.indexDoGerente(cpf) != -1) {
            return repositorioGerente.procurarGerente(cpf);
        }
		return null;
	}

	@Override
	public void removerGerente(String cpf) throws GerenteException {
		if (cpf == null ||  cpf.isEmpty()) {
            throw new GerenteException("CPF vazio ou 'null' não é argumento inválido");
        }
		if (repositorioGerente.indexDoGerente(cpf) == -1) {
            throw new GerenteException("Não existe balconista com o CPF dado (" + cpf + ")");
        }
        repositorioGerente.removerGerente(cpf);
	}

	@Override
	public void atualizarGerente(Gerente gerente) throws GerenteException {
        if (gerente == null) {
            throw new GerenteException("gerente não pode ser 'null'");
        }

        String cpf = gerente.getCpf();
        if (repositorioGerente.indexDoGerente(cpf) == -1) {
            throw new GerenteException("Não existe gerente cadastrado com o CPF dado (" + cpf + ")");
        }
        repositorioGerente.atualizarGerente(gerente);
	}

	@Override
	public int getTamanho() {
		return repositorioGerente.getTamanho();
	}
    
}