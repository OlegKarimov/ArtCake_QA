package com.ArtCake.restAssuredTests;


import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import org.testng.annotations.Test;

import java.util.Date;

import static io.restassured.RestAssured.given;

public class RACakeAddToAssortment extends TestBase{
    private Cookie sessionCookie = loginWithUser("client@gmail.com", "Client007!");
    private Cookie sessionCookieManager = loginWithUser("manager@mail.com", "Manager007!");

    @Test
    public void createCakeWithUniqueName() {
        String productName = "blueberry-cake" + new Date().getTime(); // Генерируем уникальное имя с помощью временной метки

        String requestBody = "{\n" +
                "  \"name\": \"" + productName + "\",\n" +
                "  \"ingredients\": \"milk,egg,salt...\",\n" +
                "  \"price\": 70.5,\n" +
                "  \"category\": \"CUPCAKES\",\n" +
                "  \"state\": \"DELETED\"\n" +
                "}";

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
    public void forbiddenCreateCake() {
        String productName = "blueberry-cakeFail" + new Date().getTime(); // Генерируем уникальное имя с помощью временной метки

        String requestBody = "{\n" +
                "  \"name\": \"" + productName + "\",\n" +
                "  \"ingredients\": \"milk,egg,salt...\",\n" +
                "  \"price\": 70.5,\n" +
                "  \"category\": \"CUPCAKES\",\n" +
                "  \"state\": \"DELETED\"\n" +
                "}";

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