package sk.eastcode.freq;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Runner {
    public static void main(String[] args) throws Exception {
        ActorSystem actorSystem = ActorSystem.create();
        ActorRef master = actorSystem.actorOf(Props.create(Master.class));

        while (true) {
            master.tell("Poďme bratia, do Betléma", ActorRef.noSender());
            master.tell("Poďme bratia, poďme spolu", ActorRef.noSender());
            master.tell("V maštaľôčke tíško drieme", ActorRef.noSender());
            master.tell("My Ježiška nevzbudíme.", ActorRef.noSender());
            master.tell("Hájaj, búvaj, dieťa zlaté.", ActorRef.noSender());

            Thread.sleep(1000);
        }

    }
}
