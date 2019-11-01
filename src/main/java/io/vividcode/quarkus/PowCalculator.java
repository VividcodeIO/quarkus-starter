package io.vividcode.quarkus;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import java.math.BigInteger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

@ApplicationScoped
public class PowCalculator {
  @Inject
  NumbersConfig numbersConfig;

  @Incoming("numbers")
  @Outgoing("pow10")
  @Broadcast
  public BigInteger calculate(Long number) {
    return BigInteger.valueOf(number).pow(numbersConfig.exponent());
  }
}
