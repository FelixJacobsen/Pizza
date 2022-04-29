package se.iths.mongodb;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;
import se.iths.entity.Pizza;
import se.iths.repository.PizzaRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Singleton
public class MongoDbPizzaRepository implements PizzaRepository {

    private final MongoDbConfiguration configuration;
    private final MongoClient client;

    public MongoDbPizzaRepository(MongoDbConfiguration configuration, MongoClient client) {
        this.configuration = configuration;
        this.client = client;
    }


    @Override
    public Mono<Boolean> save(@NonNull @NotNull @Valid Pizza pizza) {
        return Mono.from(getCollection().insertOne(pizza))
                .map(insertOneResult -> true)
                .onErrorReturn(false);
    }

    @Override
    @NonNull
    public Publisher<Pizza> getAll() {
        return getCollection().find();
    }

    @NonNull
    private MongoCollection<Pizza> getCollection() {
        return client.getDatabase(configuration.getName())
                .getCollection(configuration.getCollection(), Pizza.class);
    }
}
