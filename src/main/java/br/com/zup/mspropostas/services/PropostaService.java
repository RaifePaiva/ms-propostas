package br.com.zup.mspropostas.services;

import br.com.zup.mspropostas.httpClients.AnaliseFinanceiraWebServiceClient;
import br.com.zup.mspropostas.models.Proposta;
import br.com.zup.mspropostas.models.enums.StatusAnaliseFinanceira;
import br.com.zup.mspropostas.models.in.AnaliseFinanceiraRequest;
import br.com.zup.mspropostas.models.out.AnaliseFinanceiraResponse;
import br.com.zup.mspropostas.repositories.PropostaRepository;
import feign.FeignException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PropostaService {

    private final PropostaRepository propostaRepository;

    private final AnaliseFinanceiraWebServiceClient analiseFinanceiraWebServiceClient;

    /*----Injeção de dependencia via construtor----*/

    public PropostaService(PropostaRepository propostaRepository, AnaliseFinanceiraWebServiceClient analiseFinanceiraWebServiceClient) {
        this.propostaRepository = propostaRepository;
        this.analiseFinanceiraWebServiceClient = analiseFinanceiraWebServiceClient;
    }

    /*--------*/

    public Proposta salvarProposta(Proposta proposta){
        Proposta novaProposta = propostaRepository.save(proposta);
        Proposta propostaClassificada = classificarAnaliseFinanceira(novaProposta);
        propostaRepository.save(propostaClassificada);
        return propostaClassificada;
    }

    public Boolean verificarExistenciaDePropostaViaDocumento(String documento){
        Optional<Proposta> possivelProposta = propostaRepository.findByDocumento(documento);

        if(possivelProposta.isEmpty()){
            return true;
        }

        return false;

    }

    private Proposta classificarAnaliseFinanceira(Proposta proposta){

        AnaliseFinanceiraRequest dadosParaAnalise = new AnaliseFinanceiraRequest(proposta);

        try{
            analiseFinanceiraWebServiceClient.getStatusAnalise(dadosParaAnalise);
            proposta.setStatusDaAnalise(StatusAnaliseFinanceira.ELEGIVEL);
            return proposta;
        }catch (FeignException.UnprocessableEntity e){
            proposta.setStatusDaAnalise(StatusAnaliseFinanceira.NAO_ELEGIVEL);
        }

        return proposta;

    }


}
