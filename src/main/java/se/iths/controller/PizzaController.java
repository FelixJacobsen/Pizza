package se.iths.controller;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Status;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import se.iths.entity.Pizza;
import se.iths.repository.PizzaRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller("/pizzas")
@ExecuteOn(TaskExecutors.IO)
public class PizzaController {
    private final PizzaRepository service;

    public PizzaController(PizzaRepository service) {
        this.service = service;
    }

    @Get
    List<Pizza> getAll(){
        return service.getAll();
    }

    @Post
    @Status(HttpStatus.CREATED)
    void save(@NonNull @NotNull @Valid Pizza pizza){
        service.save(pizza);
    }

}
