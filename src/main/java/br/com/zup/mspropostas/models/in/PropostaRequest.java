package br.com.zup.mspropostas.models.in;

import br.com.zup.mspropostas.models.Proposta;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class PropostaRequest {

    @NotBlank(message = "Documento não pode ser nulo ou vázio.")
    @Pattern(regexp = "^\\d{11}|\\d{14}$", message = "Este documento não é válido.")
    private String documento;

    @NotBlank(message = "E-mail não pode ser nulo ou vázio.")
    @Email(message = "E-mail inválido")
    private String email;

    @NotBlank(message = "Nome não pode ser nulo ou vázio.")
    private String nome;

    @NotBlank(message = "Endereço não pode ser nulo ou vázio.")
    private String endereco;

    @Positive(message = "O salário deve ser um valor positivo.")
    @NotNull(message = "salário não pode ser nulo ou vázio.")
    private BigDecimal salario;


    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PropostaRequest(String documento, String email, String nome, String endereco, BigDecimal salario) {
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }


    public Proposta conveterParaProposta(){
        return new Proposta(documento, email, nome, endereco, salario);
    }


}
