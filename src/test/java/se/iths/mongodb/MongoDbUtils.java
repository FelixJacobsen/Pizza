package se.iths.mongodb;

import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

public class MongoDbUtils {

    static MongoDBContainer container;

    public static void startMongoDB() {
        if (container == null)
            container = new MongoDBContainer(DockerImageName.parse("mongo:4.0.10")).withExposedPorts(27017);
        if (!container.isRunning())
            container.start();
    }

    public static String getMongoDbUri() {
        if (container == null || !container.isRunning()) {
            startMongoDB();
        }
        return container.getReplicaSetUrl();
    }

    public static void closeMongoDb() {
        if (container != null)
            container.close();
    }
}
