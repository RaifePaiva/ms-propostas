package br.com.zup.mspropostas.controllers;

import br.com.zup.mspropostas.models.Proposta;
import br.com.zup.mspropostas.models.in.PropostaRequest;
import br.com.zup.mspropostas.services.PropostaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("v1/api/propostas")
public class PropostaController {


    private final PropostaService propostaService;

    /*----Injeção de dependencia via construtor----*/

    public PropostaController(PropostaService propostaService) {
        this.propostaService = propostaService;
    }

    /*--------*/

    @PostMapping
    public ResponseEntity cadastrarProposta(@Valid @RequestBody PropostaRequest propostaRequest){

        if(!propostaService.verificarExistenciaDePropostaViaDocumento(propostaRequest.getDocumento())){
            return ResponseEntity.unprocessableEntity().build();
        }

        Proposta novaProposta = propostaService.salvarProposta(propostaRequest.conveterParaProposta());
        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(novaProposta.getId())
                        .toUri())
                .build();
    }


}
