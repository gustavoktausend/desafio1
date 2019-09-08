package com.desafio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonDeserialize(builder = Pessoa.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@Wither
@Entity
public class Pessoa {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String genero;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;
    private LocalDate dataNascimento;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String naturalidade;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nacionalidade;
    private String documentId;
    private LocalDateTime dataHoraCadastro;
    private LocalDateTime ultimaAlteracao;


    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {}
}
