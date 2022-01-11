package br.com.zup.mspropostas.httpClients;

import br.com.zup.mspropostas.models.in.AnaliseFinanceiraRequest;
import br.com.zup.mspropostas.models.out.AnaliseFinanceiraResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${webservice.analise-financeira.name}", url = "${webservice.analise-financeira.url}")
public interface AnaliseFinanceiraWebServiceClient {

    @PostMapping
    public AnaliseFinanceiraResponse getStatusAnalise(@RequestBody AnaliseFinanceiraRequest analiseFinanceiraRequest);

}
