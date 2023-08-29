package com.artcake.restAssuredTests;

import com.artcake.dto.RegistrationRequestDto;
import com.artcake.dto.RegistrationResponseDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RARegistrationTest {
    @BeforeMethod

    public void precondition() {
        RestAssured.baseURI = "http://localhost:8080";

    }

    @Test
    public void loginSuccessTest() {
        RegistrationRequestDto login = RegistrationRequestDto.builder()
                .fullName("Billy Smith")
                .email("exexe@mail.com")
                .password("Qwerty123!")
                .address("Town - Berlin, Street - Sonnenallee, House Number - 17")
                .phoneNumber("+4917612930456")
                .build();

        RegistrationResponseDto responseDto = given()
                .contentType(ContentType.JSON)
                .body(login)
                .when()
                .post("api/registration")
                .then()
                .assertThat().statusCode(201)
                .extract().response().as(RegistrationResponseDto.class);
        System.out.println(responseDto.getId());


    }
}
