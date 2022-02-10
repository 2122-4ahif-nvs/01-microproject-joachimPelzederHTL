package at.htl.control;
import io.quarkus.grpc.GrpcService;

@GrpcService
public class StreamingRepository implements Streaming{

    @Override
    public Multi<Item> source(Empty request) {
        // Just returns a stream emitting an item every 2ms and stopping after 10 items.
        return Multi.createFrom().ticks().every(Duration.ofMillis(2))
                .select().first(10)
                .map(l -> Item.newBuilder().setValue(Long.toString(l)).build());
    }

    @Override
    public Uni<Empty> sink(Multi<Item> request) {
        // Reads the incoming streams, consume all the items.
        return request
                .map(Item::getValue)
                .map(Long::parseLong)
                .collect().last()
                .map(l -> Empty.newBuilder().build());
    }

    @Override
    public Multi<Item> pipe(Multi<Item> request) {
        // Reads the incoming stream, compute a sum and return the cumulative results
        // in the outbound stream.
        return request
                .map(Item::getValue)
                .map(Long::parseLong)
                .onItem().scan(() -> 0L, Long::sum)
                .onItem().transform(l -> Item.newBuilder().setValue(Long.toString(l)).build());
    }
}