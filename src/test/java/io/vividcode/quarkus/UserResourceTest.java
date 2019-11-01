package io.vividcode.quarkus;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.notNullValue;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class UserResourceTest {

  @Test
  public void testCreateUser() {
    given()
        .contentType(ContentType.JSON)
        .body(new User("test", "test@example.com"))
        .post("/user")
        .then()
        .statusCode(200)
        .body("name", equalTo("test"), "id", notNullValue());

    get("/user")
        .then()
        .statusCode(200)
        .body("name", hasItem("test"));
  }

}