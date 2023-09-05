package com.ArtCake.restAssuredTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class RALoginTests extends TestBase {

    @BeforeMethod

    public void precondition() {
        RestAssured.baseURI = "http://localhost:8080/api";
    }

    @Test
    public void loginWithValidCredentialsTest() {
        String username = "client@gmail.com";
        String password = "Client007!";

        Response response = given()
                .contentType(ContentType.URLENC)
                .formParam("username", username)
                .formParam("password", password)
                .when()
                .post("/login");

        response.then().assertThat().statusCode(200);
    	}

    @Test
    public void loginWithInvalidCredentialsTest() {
        String username = "client@gmail.com";
        String invalidPassword = "InvalidPass123";

        Response response = given()
                .contentType(ContentType.URLENC)
                .formParam("username", username)
                .formParam("password", invalidPassword)
                .when()
                .post("/login");
        response.then().assertThat().statusCode(401);
    	}
    }