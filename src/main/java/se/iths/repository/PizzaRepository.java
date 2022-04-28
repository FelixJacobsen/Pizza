package se.iths.repository;

import io.micronaut.core.annotation.NonNull;
import se.iths.entity.Pizza;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface PizzaRepository {

    @NonNull
    List<Pizza> getAll();

    void save(@NonNull @NotNull @Valid Pizza pizza);
}
