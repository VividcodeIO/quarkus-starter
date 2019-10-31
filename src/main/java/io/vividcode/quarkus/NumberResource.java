package io.vividcode.quarkus;

import io.smallrye.reactive.messaging.annotations.Channel;
import java.math.BigInteger;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.reactivestreams.Publisher;

@Path("/numbers")
public class NumberResource {
  @Inject
  @Channel("pow10")
  Publisher<BigInteger> numbers;

  @GET
  @Produces(MediaType.SERVER_SENT_EVENTS)
  public Publisher<BigInteger> stream() {
    return numbers;
  }
}
