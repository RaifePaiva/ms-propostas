package br.com.zup.mspropostas.repositories;

import br.com.zup.mspropostas.models.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, UUID> {


    Optional<Proposta> findByDocumento(String documento);
}
