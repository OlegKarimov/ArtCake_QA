package com.ArtCake.stepDefinitions;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class RALogOutTests {

    @Test
    private void logout() {
    given()
                .accept(ContentType.JSON)
                .when()
                .post("/logout")
                .then()
                .extract().response()
                .prettyPrint();
		}

    }