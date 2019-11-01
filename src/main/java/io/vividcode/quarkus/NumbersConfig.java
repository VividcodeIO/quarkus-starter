package io.vividcode.quarkus;

import io.quarkus.arc.config.ConfigProperties;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ConfigProperties(prefix = "numbers")
public interface NumbersConfig {
  @ConfigProperty(name = "exponent", defaultValue = "10")
  Integer exponent();
}
