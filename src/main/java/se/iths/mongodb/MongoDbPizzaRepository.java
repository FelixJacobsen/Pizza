package se.iths.mongodb;

import com.mongodb.client.MongoClient;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;
import se.iths.entity.Pizza;
import se.iths.repository.PizzaRepository;

@Singleton
public class MongoDbPizzaRepository implements PizzaRepository {

    private final MongoDbConfiguration configuration;
    private final MongoClient client;

    public MongoDbPizzaRepository(MongoDbConfiguration configuration, MongoClient client) {
        this.configuration = configuration;
        this.client = client;
    }


    @Override
    public Publisher<Pizza> getAll() {
        return null;
    }

    @Override
    public Mono<Boolean> save(Pizza pizza) {
        return null;
    }
}
