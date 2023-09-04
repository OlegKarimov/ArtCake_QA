package com.ArtCake.restAssuredUsersTests;
import com.ArtCake.Users.dto.OrderRequestDto;
import io.restassured.http.Cookie;
import org.testng.annotations.Test;
import static com.ArtCake.restAssuredUsersTests.TestBase.loginWithUser;
import static io.restassured.RestAssured.given;

public class RAGetManagerOrdersTests {

    @Test
    public void getAllOrdersAsManager200() {

        int page = 2;

        Cookie sessionCookie = loginWithUser("manager@mail.com", "Manager007!");

        given()
                .cookie(sessionCookie)
                .queryParam("page", page)
                .when()
                .get("/api/users/manager/orders")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(OrderRequestDto.class);
    }

    @Test
    public void getAllOrdersAsManager401() {

        int page = 0;

        given()
                .queryParam("page", page)
                .when()
                .get("/api/users/manager/orders")
                .then()
                .assertThat().statusCode(401)
                .extract().response().as(OrderRequestDto.class);
    }
}
