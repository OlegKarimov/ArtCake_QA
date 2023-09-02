package com.ArtCake.restAssuredTests;


import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RAFinishedOrderTests extends TestBase {
    @Test
    public void MovingOrderToFinishedSuccessfulTest() {
        int orderId = 2;
        String username = ("konditerow@gmail.com");
        String password = ("Confectioner000!");

        Response response = given()
                .contentType(ContentType.URLENC)
                .formParam("username", username)
                .formParam("password", password)
                .when()
                .post("/api/login");

        Cookie sessionCookie = response.getDetailedCookie("JSESSIONID");

        given()
                .cookie(sessionCookie)
                .queryParam("orderId", orderId)
                .when()
                .put("/api/orders/" + orderId + "/done?" + orderId)
                .then()
                .assertThat().statusCode(200);
    }
    @Test

    public void MovingOrderToFinishedWithUserData(){
        int orderId = 2;
        String username = ("client@gmail.com");
        String password = ("Client123!");

        Response response = given()
                .contentType(ContentType.URLENC)
                .formParam("username", username)
                .formParam("password", password)
                .when()
                .post("/api/login");

        Cookie sessionCookie = response.getDetailedCookie("JSESSIONID");

        given()
                .cookie(sessionCookie)
                .queryParam("orderId", orderId)
                .when()
                .put("/api/orders/" + orderId + "/done?" + orderId)
                .then()
                .assertThat().statusCode(403);
    }

    @Test
    public void MovingOrderToFinishedWithUnexcitingOrderIdTest() {
        int orderId = 777;
        String username = ("konditerow@gmail.com");
        String password = ("Confectioner000!");

        Response response = given()
                .contentType(ContentType.URLENC)
                .formParam("username", username)
                .formParam("password", password)
                .when()
                .post("/api/login");

        Cookie sessionCookie = response.getDetailedCookie("JSESSIONID");

        given()
                .cookie(sessionCookie)
                .queryParam("orderId", orderId)
                .when()
                .put("/api/orders/" + orderId + "/done?" + orderId)
                .then()
                .assertThat().statusCode(404);
    }
}
