//package com.ArtCake.restAssuredTests;
//
//import com.ArtCake.dto.AuthRequestDto;
//import com.ArtCake.dto.AuthResponseDto;
//import com.ArtCake.dto.ErrorDto;
//import io.restassured.http.ContentType;
//import org.testng.annotations.Test;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.containsString;
//import static org.hamcrest.Matchers.equalTo;
//
//public class RALoginTests extends TestBase{
//    @Test
//    public void loginSuccessTest(){
//        AuthRequestDto auth = AuthRequestDto.builder()
//                .username("kalambur1921@mail.ru")
//                .password("Karabas@1991")
//                .build();
//
//        AuthResponseDto responseDto = given()
//                .contentType(ContentType.JSON)
//                .body(auth)
//                .when()
//                .post("user/login/usernamepassword")
//                .then()
//                .assertThat().statusCode(200)
//                .extract().response().as(AuthResponseDto.class);
//
//        System.out.println(responseDto.getToken());
//    }
//
//    @Test
//    public void loginWithWrongFormatEmailTest(){
//        AuthRequestDto auth = AuthRequestDto.builder()
//                .username("kalambur1921@mail.ru")
//                .password("Karabas@1")
//                .build();
//
//        ErrorDto errorDto = given().contentType(ContentType.JSON)
//                .body(auth)
//                .when()
//                .post("user/login/usernamepassword")
//                .then()
//                .assertThat().statusCode(401)
//                .extract().response().as(ErrorDto.class);
//
//        System.out.println(errorDto.getMessage());
//
//        System.out.println(errorDto.getError());
//    }
//
//    @Test
//    public void loginWithWrongFormatEmailTest2(){
//        AuthRequestDto auth = AuthRequestDto.builder()
//                .username("kalambur1921mail.ru")
//                .password("Karabas@1991")
//                .build();
//
//        given().contentType(ContentType.JSON)
//                .body(auth)
//                .when()
//                .post("user/login/usernamepassword")
//                .then()
//                .assertThat()
//                .statusCode(401)
//                .assertThat()
//                .body("message", containsString("Login or Password incorrect"))
//                .assertThat().body("error", equalTo("Unauthorized"));
//    }
//}
//
//
///*
//                .setEmail("ma121nnnnnn@gmail.com")
//                .setPassword("M12annn1234$"));
//
//                TOKEN: eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoibWExMjFubm5ubm5AZ21haWwuY29tIiwiaXNzIjoiUmVndWxhaXQiLCJleHAiOjE2OTA0NDE3NzYsImlhdCI6MTY4OTg0MTc3Nn0.58koCodYuK10LFsqEyz3SY7F0NaO_2Gj94vQSF0OU-M
// */