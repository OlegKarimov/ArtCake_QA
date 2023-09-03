package com.ArtCake.restAssuredTests;


import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class RACakeAddToAssortment extends TestBase{
    private Cookie sessionCookie = loginWithUser("client@gmail.com", "Client123!");
   private Cookie sessionCookieManager = loginWithUser("manager@mail.com", "qwerty123!");

   private String requestBody = "{\n" +
            "  \"name\": \"blueberry-cupcake\",\n" +
            "  \"ingredients\": \"milk,egg,salt...\",\n" +
            "  \"price\": 70.5,\n" +
            "  \"category\": \"CUPCAKES\",\n" +
            "  \"state\": \"DELETED\"\n" +
            "}";
   @Test
    public void getCakeByCategoryTest200() {
       given()
               .contentType(ContentType.JSON)
               .cookie(sessionCookieManager)
               .accept(ContentType.JSON)
               .body(requestBody)
               .when()
               .post("/api/cakes")
               .then()
               .assertThat().statusCode(201);
    }

    @Test
    public void forbidenCreateCake() {
        given()
                .contentType(ContentType.JSON)
                .cookie(sessionCookie)
                .accept(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/cakes")
                .then()
                .assertThat().statusCode(403);
    }
}

