package com.ArtCake.restAssuredTests;

        import io.restassured.http.Cookie;
        import org.testng.annotations.Test;
        import static com.ArtCake.restAssuredTests.TestBase.loginWithUser;
        import static io.restassured.RestAssured.given;

public class RADeleteCakeTests {
    @Test
    public void deleteCakeByIDSuccessfulTest() {
        int cakeID= 2;
        Cookie sessionCookie = loginWithUser("manager@mail.com", "Manager007!");
        given()
                .cookie(sessionCookie)
                .queryParam("cakes", cakeID)
                .when()
                .delete("/api/cakes/" + cakeID)
                .then()
                .assertThat().statusCode(200);


    }

    @Test
    public void deleteCakeByIDTestError404() {
        int cakeID = 100;
        given()
                .queryParam("cakes", cakeID)
                .when()
                .delete("/api/cakes/" + cakeID)
                .then()
                .assertThat().statusCode(404);

    }
}
