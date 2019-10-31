package io.vividcode.quarkus;

import io.reactivex.Flowable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

@ApplicationScoped
public class NumberGenerator {

  @Outgoing("generated-number")
  public Flowable<Long> generate() {
    return Flowable.interval(10, TimeUnit.SECONDS)
        .map(tick -> ThreadLocalRandom.current().nextLong());
  }

}
