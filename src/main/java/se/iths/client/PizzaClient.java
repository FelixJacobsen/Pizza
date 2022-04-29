package se.iths.client;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import se.iths.entity.Pizza;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Client
public interface PizzaClient {

    @Post
    @NonNull
    HttpStatus save(@NonNull @NotNull @Valid Pizza pizza);

    @NonNull
    @Get
    List<Pizza> findAll();
}
