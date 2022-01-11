package br.com.zup.mspropostas.models.in;

import br.com.zup.mspropostas.models.Proposta;

public class AnaliseFinanceiraRequest {

    private String documento;

    private String nome;

    private String idProposta;


    @Deprecated
    public AnaliseFinanceiraRequest(){}

    public AnaliseFinanceiraRequest(Proposta proposta) {
        this.documento = proposta.getDocumento();
        this.nome = proposta.getNome();
        this.idProposta = proposta.getId().toString();
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public String getIdProposta() {
        return idProposta;
    }
}
