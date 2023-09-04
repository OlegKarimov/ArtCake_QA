package com.ArtCake.restAssuredTests;
import com.ArtCake.dto.CakeUpdateRequestDto;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class RAUpdateCakeTests extends TestBase {

    @Test
    public void updateCakeByIdSuccessfulTest() {

        int cakeId = 1;
        CakeUpdateRequestDto cakeUpdateRequestDto = CakeUpdateRequestDto.builder()
                .name("vanilla-cupcake")
                .ingredients("sugar, butter, eggs")
                .price(32.87)
                .state("CREATED")
                .build();
        String username = ("manager@mail.com");
        String password = ("qwerty123!");

        Response response = given()
                .contentType(ContentType.URLENC)
                .formParam("username", username)
                .formParam("password", password)
                .when()
                .post("/api/login");

        Cookie sessionCookie = response.getDetailedCookie("JSESSIONID");

        ValidatableResponse update = given()
                .cookie(sessionCookie)
                .queryParam("cake-id", cakeId)
                .contentType(ContentType.JSON)
                .body(cakeUpdateRequestDto)
                .when()
                .put("api/cakes/" + cakeId)
                .then()
                .assertThat().statusCode(200);
    }

    @Test
    public void updateCakeWithUserAccessError403Test(){
        int cakeId = 1;
        CakeUpdateRequestDto cakeUpdateRequestDto = CakeUpdateRequestDto.builder()
                .name("vanilla-cupcake")
                .ingredients("sugar, butter, eggs")
                .price(32.87)
                .state("CREATED")
                .build();
        String username = ("client@gmail.com");
        String password = ("Client123!");

        Response response = given()
                .contentType(ContentType.URLENC)
                .formParam("username", username)
                .formParam("password", password)
                .when()
                .post("/api/login");

        Cookie sessionCookie = response.getDetailedCookie("JSESSIONID");

        ValidatableResponse update = given()
                .cookie(sessionCookie)
                .queryParam("cake-id", cakeId)
                .contentType(ContentType.JSON)
                .body(cakeUpdateRequestDto)
                .when()
                .put("api/cakes/" + cakeId)
                .then()
                .assertThat().statusCode(403);
    }
}