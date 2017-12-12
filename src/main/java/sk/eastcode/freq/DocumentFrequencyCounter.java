package sk.eastcode.freq;

import akka.actor.AbstractLoggingActor;
import akka.actor.Props;

import java.util.Map;

public class DocumentFrequencyCounter extends AbstractLoggingActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, this::handleDocument)
                .build();
    }

    void handleDocument(String document) {
        log().info("Processing document: {}", document);
        Map<String, Long> frequencies = Utils.calculateFrequencies(document);
        getSender().tell(frequencies, getSelf());
    }

    public static Props props() {
        return Props.create(DocumentFrequencyCounter.class);
    }
}
