package com.desafio.resource;

import com.desafio.model.Pessoa;
import com.desafio.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Validated
@RestController
@RequestMapping(value = "/api/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/{id}")
    public Mono<Pessoa> get(@PathVariable Long id) {
        return pessoaService.getPessoaById(id);
    }

    @PostMapping("/novo")
    public Mono<Void> post(@RequestParam String nome,
                           @RequestParam(required = false) String email,
                           @RequestParam(required = false) String genero,
                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataNascimento,
                           @RequestParam String documentId,
                           @RequestParam(required = false) String naturalidade,
                           @RequestParam(required = false) String nacionalidade){

        return pessoaService.insertNewPessoa(nome,email,genero,dataNascimento,documentId,naturalidade,nacionalidade);
    }

    @PutMapping("/{id}")
    public Mono<Pessoa> put(@PathVariable Long id,
                            @RequestParam(required = false) String nome,
                            @RequestParam(required = false) String email,
                            @RequestParam(required = false) String genero,
                            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataNascimento,
                            @RequestParam(required = false) String documentId,
                            @RequestParam(required = false) String naturalidade,
                            @RequestParam(required = false) String nacionalidade) {

        return pessoaService.update(id,nome,email,genero,dataNascimento,documentId,naturalidade,nacionalidade);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pessoaService.deleteById(id);
    }




}
