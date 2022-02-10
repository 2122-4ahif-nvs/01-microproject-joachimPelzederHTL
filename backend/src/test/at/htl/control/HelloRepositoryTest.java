package at.htl.control;

import io.quarkus.grpc.GrpcClient;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
/*
class HelloRepositoryTest implements Greeter{

    @GrpcClient
    Greeter client;

    @Test
    void shouldReturnHello() {
        CompletableFuture<String> message = new CompletableFuture<>();
        client.sayHello(HelloRequest.newBuilder().setName("Quarkus").build())
                .subscribe().with(reply -> message.complete(reply.getMessage()));
        assertThat(message.get(5, TimeUnit.SECONDS)).isEqualTo("Hello Quarkus");
    }
}

 */