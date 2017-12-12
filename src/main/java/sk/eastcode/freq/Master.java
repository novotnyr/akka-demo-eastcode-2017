package sk.eastcode.freq;

import akka.actor.AbstractLoggingActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.RoundRobinPool;

import java.util.HashMap;
import java.util.Map;

public class Master extends AbstractLoggingActor {
    private Map<String, Long> allFrequencies = new HashMap<>();

    private ActorRef documentFrequencyCounter = getContext().actorOf(DocumentFrequencyCounter.props()
            .withRouter(new RoundRobinPool(2)
                    .withSupervisorStrategy(Utils.stopOnIllegalStateExceptionStrategy())
            ));

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, this::handleDocument)
                .match(Map.class, this::handleFrequencies)
                .build();
    }

    void handleDocument(String document) {
        documentFrequencyCounter.tell(document, getSelf());
    }

    void handleFrequencies(Map<String, Long> frequencies) {
        this.allFrequencies = Utils.aggregate(frequencies, this.allFrequencies);

        log().info("Global frequencies: {}", this.allFrequencies);
    }

    public static Props props() {
        return Props.create(Master.class);
    }
}
