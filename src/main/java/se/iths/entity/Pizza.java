package se.iths.entity;

import io.micronaut.core.annotation.*;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Introspected
@ReflectiveAccess
public class Pizza {

    @NotEmpty
    @NotNull
    @BsonProperty("name")
    private final String name;

    @Nullable
    @BsonProperty("ingrediens")
    private final String ingrediens;

    public Pizza(@NonNull String name) {
        this(name,null);
    }

    @Creator
    @BsonCreator
    public Pizza(@NonNull @BsonProperty("name") String name,
                 @Nullable @BsonProperty("description") String ingrediens) {
        this.name = name;
        this.ingrediens = ingrediens;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @Nullable
    public String getIngrediens() {
        return ingrediens;
    }
}
