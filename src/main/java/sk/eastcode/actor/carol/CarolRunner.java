package sk.eastcode.actor.carol;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class CarolRunner {
    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create();
        ActorRef carolActor = actorSystem.actorOf(Props.create(CarolActor.class));

        carolActor.tell("Poďme bratia, do Betléma", ActorRef.noSender());
        carolActor.tell("Poďme bratia, poďme spolu", ActorRef.noSender());
        carolActor.tell("V maštaľôčke tíško drieme", ActorRef.noSender());
        carolActor.tell("My Ježiška nevzbudíme.", ActorRef.noSender());
        carolActor.tell("Hájaj, búvaj, dieťa zlaté.", ActorRef.noSender());
    }
}
