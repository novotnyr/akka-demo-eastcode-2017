package sk.eastcode.actor.carol;

import akka.actor.AbstractActor;

public class CarolActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, this::handleString)
                .build();
    }

    void handleString(String message) {
        StringBuilder carol = new StringBuilder(message)
                .append("\nDidlaj didlaj didlaj dá.")
                .append("\nJežišku, miláčku, ja ťa budem kolembati,")
                .append("\nJežišku, miláčku, ja ťa budem kolembať.");

        System.out.println(carol);
    }
}
