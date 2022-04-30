package se.iths.mongodb;


import io.micronaut.http.HttpStatus;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.micronaut.test.support.TestPropertyProvider;
import jakarta.inject.Inject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import se.iths.entity.Pizza;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static io.micronaut.http.HttpStatus.CREATED;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@MicronautTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PizzaControllerTest implements TestPropertyProvider {

    @Inject
    PizzaClient client;

    @Test
    void fruitsEndpointInteractsWithMongo() {

        List<Pizza> pizzas = client.findAll();
        assertTrue(pizzas.isEmpty());

        HttpStatus status = client.save(new Pizza("Margarita"));
        assertEquals(CREATED, status);

        pizzas = client.findAll();
        assertFalse(pizzas.isEmpty());
        assertEquals("Margarita", pizzas.get(0).getName());
        assertNull(pizzas.get(0).getIngrediens());

        status = client.save(new Pizza("Hawaii", "Tomato sauce, Cheese, Ham, Pineapple"));
        assertEquals(CREATED, status);

        pizzas = client.findAll();
        assertTrue(pizzas.stream().anyMatch(p -> "Tomato sauce, Cheese, Ham, Pineapple".equals(p.getIngrediens())));
    }

    @AfterAll
    static void cleanup() {
        MongoDbUtils.closeMongoDb();
    }

    @Override
    public Map<String, String> getProperties() {
        MongoDbUtils.startMongoDB();
        return Collections.singletonMap("mongodb.uri",MongoDbUtils.getMongoDbUri());
    }
}
