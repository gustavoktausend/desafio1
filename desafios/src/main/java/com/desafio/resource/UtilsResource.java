package com.desafio.resource;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Validated
@RestController
@RequestMapping(value = "/api/source")
public class UtilsResource {


    @GetMapping
    public Mono<String> getSourceLink(){

        return Mono.just("link");

    }
}
