package com.ArtCake.restAssuredTests;

import com.ArtCake.dto.UpdateUserDto;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RAUpdateUserTests extends TestBase{

    @Test
    public void updateUserTest200() {
        int userId = 1;
        Cookie sessionCookie = loginAsManager();

        UpdateUserDto updateUserDto = UpdateUserDto.builder()
                .houseNumber(12)
                .phoneNumber("+4917622334455")
                .role("CONFECTIONER")
                .street("Tondorfer str.")
                .zipCode("22112")
                .town("Berlin")
                .state("CONFIRMED")
                .build();

        given()
                .cookie(sessionCookie)
                .queryParam("user-id", userId)
                .contentType(ContentType.JSON)
                .body(updateUserDto)
                .when()
                .put("/api/users/" + userId)
                .then()
                .assertThat().statusCode(200);
    }

    @Test
    public void updateUserTest401() {
        int userId = 1;

        UpdateUserDto updateUserDto = UpdateUserDto.builder()
                .houseNumber(12)
                .phoneNumber("+4917622334455")
                .role("CONFECTIONER")
                .street("Tondorfer str.")
                .zipCode("22112")
                .town("Berlin")
                .state("CONFIRMED")
                .build();

        given()
                .queryParam("user-id", userId)
                .contentType(ContentType.JSON)
                .body(updateUserDto)
                .when()
                .put("/api/users/" + userId)
                .then()
                .assertThat().statusCode(401);
    }
}

