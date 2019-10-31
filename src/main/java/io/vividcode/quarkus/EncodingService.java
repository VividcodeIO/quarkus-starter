package io.vividcode.quarkus;

import io.quarkus.vertx.ConsumeEvent;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EncodingService {

  @ConsumeEvent("encoding")
  public String encode(String data) {
    return Base64.getEncoder().encodeToString(data.getBytes(StandardCharsets.UTF_8));
  }
}
