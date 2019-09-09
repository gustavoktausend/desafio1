package com.desafio.service;

import com.desafio.model.Pessoa;
import com.desafio.repository.PessoaRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Mono<Pessoa> getPessoaById(Long id) {
        return Mono.fromCallable(
                () -> pessoaRepository.findById(id)
                        .orElseThrow(Exception::new));
    }

    public Mono<Void> insertNewPessoa(String nome, String email, String genero,
                                      LocalDate dataNascimento, String documentId,
                                      String naturalidade, String nacionalidade) {
        return Mono.fromCallable(
                () -> pessoaRepository.save(
                        Pessoa.builder()
                                .nome(nome)
                                .genero(genero)
                                .email(email)
                                .dataNascimento(dataNascimento)
                                .documentId(documentId)
                                .naturalidade(naturalidade)
                                .nacionalidade(nacionalidade)
                                .dataHoraCadastro(LocalDateTime.now())
                                .build())
        ).then();
    }

    public Mono<Pessoa> update(Long id, String nome,  String email, String genero,
                                   LocalDate dataNascimento, String documentId,
                                   String naturalidade, String nacionalidade) {
        return Mono.fromCallable(
                () -> pessoaRepository.findById(id)
                        .orElseThrow(Exception::new)
        ).map(pessoa -> pessoaRepository.save(
                pessoa.withId(id)
                        .withNome(StringUtils.isBlank(nome) ? pessoa.getNome() : nome)
                        .withEmail(StringUtils.isBlank(email) ? pessoa.getEmail() : email)
                        .withGenero(StringUtils.isBlank(genero) ? pessoa.getGenero() : genero)
                        .withDocumentId(StringUtils.isBlank(documentId) ? pessoa.getDocumentId() : documentId)
                        .withDataNascimento(dataNascimento == null ? pessoa.getDataNascimento() :dataNascimento)
                        .withNacionalidade(StringUtils.isBlank(nacionalidade) ? pessoa.getNacionalidade() :nacionalidade)
                        .withNaturalidade(StringUtils.isBlank(naturalidade) ? pessoa.getNaturalidade() :naturalidade)
                        .withUltimaAlteracao(LocalDateTime.now()))
        );

    }

    public void deleteById(Long id) {
        pessoaRepository.deleteById(id);
    }

}
