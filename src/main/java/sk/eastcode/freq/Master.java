package sk.eastcode.freq;

import akka.actor.AbstractLoggingActor;
import akka.actor.Props;

public class Master extends AbstractLoggingActor {
    @Override
    public Receive createReceive() {
        return null;
    }

    public static Props props() {
        return Props.create(Master.class);
    }
}
