package com.ArtCake.restAssuredTests;

import com.ArtCake.dto.CakeResponseDto;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class RAGetAllCakes {
    @Test
    public void getCakeByIDSuccessfulTest() {
        int page = 2;

       given()
                .queryParam("page", page)
                .when()
                .get("/api/cakes")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(CakeResponseDto.class);
    }

    @Test
    public void getCakeByIDTestError404() {
        String page = "abc";
        given()
                .queryParam("page", page)
                .when()
                .get("/cakes/."+page)
                .then()
                .assertThat().statusCode(404);
    }
}
