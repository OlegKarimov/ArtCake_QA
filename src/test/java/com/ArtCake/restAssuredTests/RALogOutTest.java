package com.ArtCake.restAssuredTests;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RALogOutTest extends TestBase {

    @Test
    public void successLogOut() {
        Cookie sessionCookie = loginWithUser("client@gmail.com", "Client007!");

        Response response = given()
                .contentType(ContentType.JSON)
                .cookie(sessionCookie)
                .when()
                .post("/api/logout")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        //Получаем сообщение с документации
        JsonPath jsonPath = response.jsonPath();
        String jsonString = jsonPath.prettify();
        System.out.println(jsonString);
    }
}
