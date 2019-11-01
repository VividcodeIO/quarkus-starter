package io.vividcode.quarkus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class EncodingResourceTest {
  @Test
  public void testEncoding() {
    given()
        .queryParam("data", "abc")
        .get("/encoding")
        .then()
        .body(equalTo("YWJj"));
  }
}
