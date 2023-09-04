package com.ArtCake.restAssuredTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.given;

public class TestBase {

    @BeforeMethod
    public void precondition(){
        RestAssured.baseURI ="http://localhost:8080";
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
}
