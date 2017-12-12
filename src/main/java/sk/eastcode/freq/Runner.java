package sk.eastcode.freq;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import sk.eastcode.actor.carol.CarolActor;

public class Runner {
    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create();
        ActorRef master = actorSystem.actorOf(Props.create(Master.class));

        master.tell("Poďme bratia, do Betléma", ActorRef.noSender());
        master.tell("Poďme bratia, poďme spolu", ActorRef.noSender());
        master.tell("V maštaľôčke tíško drieme", ActorRef.noSender());
        master.tell("My Ježiška nevzbudíme.", ActorRef.noSender());
        master.tell("Hájaj, búvaj, dieťa zlaté.", ActorRef.noSender());
    }
}
