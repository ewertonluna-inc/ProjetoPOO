package model;

public class Solicitacao {
    private String mensagem;
    private boolean isResolvida;

    public Solicitacao(String mensagem) {
        this.mensagem = mensagem;
        isResolvida = false;
    }

    public void resolverSolicitacao() {
        this.isResolvida = true;
    }

    public String getMensagem() {
        return mensagem;
    }

    public boolean isResolvida() {
        return isResolvida;
    }

    @Override
    public String toString() {
        return "Solicitacao [isResolvida=" + isResolvida + ", mensagem=" + mensagem + "]";
    }

    
}

