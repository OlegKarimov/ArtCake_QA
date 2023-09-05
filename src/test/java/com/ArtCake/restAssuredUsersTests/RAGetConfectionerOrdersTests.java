package com.ArtCake.restAssuredUsersTests;
import com.ArtCake.Users.dto.OrderRequestDto;
import io.restassured.http.Cookie;
import org.testng.annotations.Test;

import static com.ArtCake.restAssuredUsersTests.TestBase.loginWithUser;
import static io.restassured.RestAssured.given;

public class RAGetConfectionerOrdersTests {

    @Test
    public void getAllOrdersAsConfectioner200() {

        int page = 0;

        Cookie sessionCookie = loginWithUser("konditerow@gmail.com", "Qwerty123!");

        given()
                .cookie(sessionCookie)
                .queryParam("page", page)
                .when()
                .get("/api/users/confectioner/orders")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(OrderRequestDto.class);
    }

    @Test
    public void getAllOrdersAsConfectioner401() {

        int page = 0;

        given()
                .queryParam("page", page)
                .when()
                .get("/api/users/confectioner/orders")
                .then()
                .assertThat().statusCode(401)
                .extract().response().as(OrderRequestDto.class);
    }
}
