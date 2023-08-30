package com.ArtCake.stepDefinitions;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class RALoginTests {

    private void sendLoginRequest(String username, String password) {
    given()
                .accept(ContentType.JSON)
                .contentType("application/x-www-form-urlencoded")
                .formParam("username", username)
                .formParam("password", password)
                .when()
                .post("/login")
                .then()
                .extract().response()
                .prettyPrint();
}

    @Test
    public void succesLoginTest200() {
        sendLoginRequest("marke@mail.com", "Qwerty123!");
    }

    @Test
    public void failedLoginTest401() {
        sendLoginRequest("marke@mail.com", "InvalidPass!");
    }
    }

