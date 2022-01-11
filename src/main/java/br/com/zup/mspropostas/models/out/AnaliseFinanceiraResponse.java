package br.com.zup.mspropostas.models.out;

public class AnaliseFinanceiraResponse {

    private String resultadoSolicitacao;


    @Deprecated
    public AnaliseFinanceiraResponse() {
    }

    public AnaliseFinanceiraResponse(String resultadoSolicitacao) {
        this.resultadoSolicitacao = resultadoSolicitacao;
    }

    public String getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }
}
