package io.vividcode.quarkus;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import java.math.BigInteger;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

@ApplicationScoped
public class PowCalculator {
  @Incoming("numbers")
  @Outgoing("pow10")
  @Broadcast
  public BigInteger calculate(Long number) {
    return BigInteger.valueOf(number).pow(10);
  }
}
