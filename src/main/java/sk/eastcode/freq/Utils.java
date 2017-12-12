package sk.eastcode.freq;

  import akka.actor.OneForOneStrategy;
import akka.actor.SupervisorStrategy;
import akka.japi.pf.DeciderBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Utils {
    public static Map<String, Long> calculateFrequencies(String document) {
        return Arrays.stream(document.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static <T> Map<T, Long> aggregate(Map<T, Long> data1,
                                                Map<T, Long> data2) {
        Map<T, Long> aggregatedData = new HashMap<>(data1);
        for (T key : data2.keySet()) {
            long existingFrequency = aggregatedData.getOrDefault(key, 0L);
            aggregatedData.put(key, existingFrequency + data2.get(key));
        }
        return aggregatedData;
    }

    public static SupervisorStrategy stopOnIllegalStateExceptionStrategy() {
        return new OneForOneStrategy(DeciderBuilder
                .match(IllegalStateException.class, exception -> SupervisorStrategy.stop())
                .matchAny(o -> SupervisorStrategy.escalate())
                .build());
    }
}
