package br.com.zup.mspropostas.services;

import br.com.zup.mspropostas.models.Proposta;
import br.com.zup.mspropostas.repositories.PropostaRepository;
import org.springframework.stereotype.Service;

@Service
public class PropostaService {

    private final PropostaRepository propostaRepository;

    /*----Injeção de dependencia via construtor----*/

    public PropostaService(PropostaRepository propostaRepository) {
        this.propostaRepository = propostaRepository;
    }

    /*--------*/

    public void salvarProposta(Proposta proposta){
            propostaRepository.save(proposta);
    }


}
