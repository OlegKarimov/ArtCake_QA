package com.ArtCake.restAssuredTests;

import com.ArtCake.dto.OrderRequestDto;
import com.ArtCake.dto.MoveOrderToProcessDto;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RAMoveOrderToProcessTest extends TestBase {

    private static String orderId = "";

    @BeforeMethod
    public void precondition(){
        String username = ("client@gmail.com");
        String password = ("Client123!");

        int cakeID = 1;
        OrderRequestDto orderRequestDto = OrderRequestDto.builder()
                .count(3)
                .deadline("2023-10-10")
                .clientWishes("Make in blue and white colours")
                .build();


        Response loginResponse = given()
                .contentType(ContentType.URLENC)
                .formParam("username", username)
                .formParam("password", password)
                .when()
                .post("/api/login");

        Cookie sessionCookie = loginResponse.getDetailedCookie("JSESSIONID");

        orderId = given()
                .contentType(ContentType.JSON)
                .cookie(sessionCookie)
                .body(orderRequestDto)
                .when()
                .post("/api/orders/cakes/" + cakeID + "?cakeId=" + cakeID)
                .then()
                .assertThat().statusCode(201)
                .extract().body().jsonPath().getString("id");
    }

    @Test
    public void moveOrderToProcessFailTest() {
        String username = ("client@gmail.com");
        String password = ("Client123!");

        Response loginResponse = given()
                .contentType(ContentType.URLENC)
                .formParam("username", username)
                .formParam("password", password)
                .when()
                .post("/api/login");

        Cookie sessionCookie = loginResponse.getDetailedCookie("JSESSIONID");

        MoveOrderToProcessDto dto = MoveOrderToProcessDto.builder()
                .confectionerId(2)
                .build();

        given()
                .contentType(ContentType.JSON)
                .cookie(sessionCookie)
                .body(dto)
                .when()
                .put("/api/orders/" + orderId + "?orderId=" + orderId)
                .then()
                .assertThat().statusCode(403);
    }

    @Test
    public void moveOrderToProcessSuccessTest() {
        String username = ("manager@mail.com");
        String password = ("qwerty123!");

        Response loginResponse = given()
                .contentType(ContentType.URLENC)
                .formParam("username", username)
                .formParam("password", password)
                .when()
                .post("/api/login");

        Cookie sessionCookie = loginResponse.getDetailedCookie("JSESSIONID");

        MoveOrderToProcessDto dto = MoveOrderToProcessDto.builder()
                .confectionerId(2)
                .build();

        given()
                .contentType(ContentType.JSON)
                .cookie(sessionCookie)
                .body(dto)
                .when()
                .put("/api/orders/" + orderId + "?orderId=" + orderId)
                .then()
                .assertThat().statusCode(200);
    }
}