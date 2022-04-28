package se.iths.entity;

import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Introspected
public class Pizza {

    @NotEmpty
    @NotNull
    @BsonProperty("name")
    private String name;

    @Nullable
    @BsonProperty("ingrediens")
    private String ingrediens;

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
