package com.ArtCake.restAssuredTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.given;

public class TestBase {

    public static Cookie loginAsClient() {
        return loginWithUser("client@gmail.com", "Client007!");
    }

    public static Cookie loginAsManager() {
        return loginWithUser("manager@mail.com", "Manager007!");
    }

    public static Cookie loginAsConditioner() {
        return loginWithUser("konditerow@gmail.com", "Qwerty123!");
    }

    public static Cookie loginWithUser(String email, String password) {
        Response loginResponse = given()
                .contentType(ContentType.URLENC)
                .formParam("username", email)
                .formParam("password", password)
                .when()
                .post("/api/login");

        return loginResponse.getDetailedCookie("JSESSIONID");
    }

    @BeforeMethod
    public void precondition() {
        RestAssured.baseURI = "http://localhost:8080";
    }
}
