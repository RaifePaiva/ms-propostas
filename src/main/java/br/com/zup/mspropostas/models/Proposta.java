package br.com.zup.mspropostas.models;

import br.com.zup.mspropostas.models.enums.StatusAnaliseFinanceira;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_propostas")
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank
    @Pattern(regexp = "^\\d{11}|\\d{14}$")
    private String documento;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String endereco;

    @Positive
    @NotNull
    private BigDecimal salario;

    @Enumerated(EnumType.STRING)
    private StatusAnaliseFinanceira statusDaAnalise;

    @Deprecated
    public Proposta(){}

    public Proposta(String documento, String email, String nome, String endereco, BigDecimal salario) {
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }

    public UUID getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public void setStatusDaAnalise(StatusAnaliseFinanceira statusDaAnalise) {
        this.statusDaAnalise = statusDaAnalise;
    }
}
