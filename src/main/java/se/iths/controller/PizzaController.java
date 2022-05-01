package se.iths.controller;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;
import se.iths.entity.Pizza;
import se.iths.repository.PizzaRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static io.micronaut.http.HttpStatus.CONFLICT;
import static io.micronaut.http.HttpStatus.CREATED;

@Controller("/pizzas")
public class PizzaController {
    private final PizzaRepository service;

    public PizzaController(PizzaRepository service) {
        this.service = service;
    }

    @Get
    public Publisher<Pizza> getAll() {
        return service.getAll();
    }

    @Post
    public Mono<HttpStatus> save(@NonNull @NotNull @Valid Pizza pizza) {
        return service.save(pizza).map(added -> added ? CREATED : CONFLICT);
    }

}
