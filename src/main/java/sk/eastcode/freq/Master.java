package sk.eastcode.freq;

import akka.actor.AbstractLoggingActor;
import akka.actor.Props;

import java.util.HashMap;
import java.util.Map;

public class Master extends AbstractLoggingActor {
    private Map<String, Long> allFrequencies = new HashMap<>();

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Map.class, this::handleFrequencies)
                .build();
    }

    void handleFrequencies(Map<String, Long> frequencies) {
        this.allFrequencies = Utils.aggregate(frequencies, allFrequencies);

        log().info("Global frequencies: {}", this.allFrequencies);
    }

    public static Props props() {
        return Props.create(Master.class);
    }
}
