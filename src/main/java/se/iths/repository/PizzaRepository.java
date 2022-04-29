package se.iths.repository;

import io.micronaut.core.annotation.NonNull;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;
import se.iths.entity.Pizza;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface PizzaRepository {

    @NonNull
    Publisher<Pizza> getAll();

    Mono<Boolean> save(@NonNull @NotNull @Valid Pizza pizza);
}
