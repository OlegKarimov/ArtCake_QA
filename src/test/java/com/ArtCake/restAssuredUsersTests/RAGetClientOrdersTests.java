package com.ArtCake.restAssuredUsersTests;
import com.ArtCake.Users.dto.OrderRequestDto;
import io.restassured.http.Cookie;
import org.testng.annotations.Test;
import static com.ArtCake.restAssuredUsersTests.TestBase.loginWithUser;
import static io.restassured.RestAssured.given;

public class RAGetClientOrdersTests {

    @Test
    public void getAllOrdersForClientAsClient200() {

        int page = 0;

        Cookie sessionCookie = loginWithUser("client@gmail.com", "Client007!");

        given()
                .cookie(sessionCookie)
                .queryParam("page", page)
                .when()
                .get("/api/users/client/orders")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(OrderRequestDto.class);

    }

    @Test
    public void getAllOrdersForClientAsManager200() {

        int page = 0;

        Cookie sessionCookie = loginWithUser("manager@mail.com", "Manager007!");

        given()
                .cookie(sessionCookie)
                .queryParam("page", page)
                .when()
                .get("/api/users/client/orders")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(OrderRequestDto.class);

    }

    @Test
    public void getAllOrdersForClientAsConfectioner200() {

        int page = 0;

        Cookie sessionCookie = loginWithUser("konditerow@gmail.com", "Qwerty123!");

        given()
                .cookie(sessionCookie)
                .queryParam("page", page)
                .when()
                .get("/api/users/client/orders")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(OrderRequestDto.class);
    }

}
