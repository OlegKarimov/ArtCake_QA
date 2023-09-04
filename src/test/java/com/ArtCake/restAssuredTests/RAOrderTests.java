package com.ArtCake.restAssuredTests;

import com.ArtCake.dto.OrderRequestDto;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class RAOrderTests extends TestBase {

    @Test
    public void creatingOrderSuccessfulTest() {

        String username = ("client@gmail.com");
        String password = ("Client007!");
        Cookie sessionCookie=loginWithUser(username,password);
        int cakeID = 1;
        OrderRequestDto orderRequestDto = OrderRequestDto.builder()
                .count(3)
                .deadline("2023-10-10")
                .clientWishes("Make in blue and white colours")
                .build();

        given()
                .contentType(ContentType.JSON)
               .cookie(sessionCookie)
                .body(orderRequestDto)
                .when()
                .post("/api/orders/cakes/" + cakeID + "?cakeId=" + cakeID)
                .then()
                .assertThat().statusCode(201);

    }

    @Test
    public void addNewOrderWithoutAuthenticationTest() {
        int cakeID = 1;
        OrderRequestDto orderRequestDto = OrderRequestDto.builder()
                .count(3)
                .deadline("2023-10-10")
                .clientWishes("Make in blue and white colours")
                .build();


        given()
                .contentType(ContentType.JSON)
                .body(orderRequestDto)
                .when()
                .post("/api/orders/cakes/" + cakeID + "?cakeId=" + cakeID)
                .then()
                .assertThat().statusCode(401);

    }

}
