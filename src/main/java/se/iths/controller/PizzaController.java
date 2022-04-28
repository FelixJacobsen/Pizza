package se.iths.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import se.iths.entity.Pizza;
import se.iths.repository.PizzaRepository;

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

    

}
